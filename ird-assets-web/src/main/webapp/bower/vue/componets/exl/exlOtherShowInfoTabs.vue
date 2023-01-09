<template>
    
    <div>
        <slot name="testSlot"></slot>
        <input type="hidden" :value="value" >
        <ul id="service-tabs" class="nav nav-tabs" role="tablist" ref = "tabUL">
            <slot name="compomentLi"></slot>
        </ul>
        <div id="service-tab-content" class="tab-content" ref = "showContent">
            <slot name="compomentContent"></slot>
        </div>
    </div>
</template>
<script>
define(['jquery','Vue','atosUtil'],function($,Vue,atosUtil){
    

     var otherShowTabs = Vue.extend({
        template:template,
        props:{
            value:{ type : Object },
            docSeq:{
			    type : String
            },
            tabs:{
                type : Object
            }
        },
        data:function(){
            return {
                // tabs 切換時操作指南 judgeStr 與href進行比對匹配,requesturl :請求url,operateEle:操作元素,data:請求數據
                judgeTab : { 
                    tabArr : this.tabs,
                    showResult:function(ele,pdaResponse){
                        var opeEle = ele.children('span').eq(0);
                        var resultObj = {oldHiddenStatus:true,newIsHidden:false,html:''};
                        resultObj.html = pdaResponse;
                        resultObj.oldHiddenStatus = opeEle.hasClass('hidden');
                        resultObj.newIsHidden = resultObj.html > 0 ? false : true;

                        if(resultObj.oldHiddenStatus != resultObj.newIsHidden){
                            opeEle.toggleClass('hidden');
                        }
                        opeEle.html(resultObj.html);
                    }
                },
                // 共同屬性
                commonAttr:{
                    "show":true,
                    "role":"tab",
                    "dataToggle":"tab",
                    "hrefType":"page",
                    "showBadge":false,
                    "isVueCompoment" : false,
                    "loadBadgeToshow" : true
                },
                 pageCache: {
                    pages: []
                },
                LiEle : {},
                TabContentEle : {}
            };
        },
        created : function(){
            // li元素_TAB組件
            this.LiEle = Vue.extend({
                template : '<li><a :data-href ="tab.dataHref" :href = "\'#\'+tab.href" :href-type="tab.hrefType" :data-toggle = "tab.dataToggle" :data-href = "tab.dataHref" @click = "$emit(\'getTabContent\', $event)">'
                    + '{{ tab.text}}'
                    + '<span v-if = "tab.showBadge" class = "badge hidden" style = "background:red"></span>'
                    + '</a></li>'
                ,
                props : {
                    tab : { type : Object }                
                }
            });  
            
            // 標籤內容組件
            this.TabContentEle = Vue.extend({
                template : '<div :id="tab.href" role="tabpanel" class="tab-pane fade"></div>',
                props : {
                    tab : { type : Object }                
                }
            });
        },
        mounted:function(){
            var self = this;
            self.initTabLI();
            self.initTabHrefContent();
            
            this.activeTab($(self.$refs.tabUL).find('a[data-toggle="tab"]:eq(0)'));
                      
            // 遍歷tab,看看屬性是否有馬上顯示個數            
            $.each(self.tabs, function(idxOne, itemOne){
                var loadBadgeToshowFlag = itemOne.loadBadgeToshow || self.commonAttr.loadBadgeToshow;                            
                if (loadBadgeToshowFlag && itemOne.requestBadge) {
                    self.updateBadge($(self.$refs.tabUL).find('a[data-href="'+itemOne.dataHref+'"]'));
                }                                
            }); 
        },
        methods:{
            getTabPage:function(event){
                this.activeTab($(event.target));
            },
            // tab相關事件
            activeTab:function($target){
                var self = this;
                var href = $target.attr('href');
                var includePage = $target.attr('data-href');
                if(!includePage){
                    $target.tab('show');
                    return;
                }
                var $loading = $target.find('i.icon-spinner').removeClass('hidden');
                var cacheData = {};
                cacheData.docId = self.value;
                cacheData.docSeq = self.docSeq;
                if (cacheData.docId != null && href != null) {
                    if (!self.pageCache.pages.contains(href)) { // 判斷是否已經加載過也頁面，加載過就不加載了。
                       if($target.find('span').length >= 1){
                            self.updateBadge($target);
                        }
                        $.get(includePage, cacheData, function(html, status) {
                            $(href).html($('<div></div>').append(html).html());
                            $target.tab('show');
                            $loading.addClass('hidden');
                            // 緩存起相同docId的頁面數據
                            self.pageCache.pages.push(href);
                        });
                    } else {
                        $target.tab('show');
                    }
                } else {
                    $(href).html('');
                    $target.tab('show');
                }

            },// 獲取tabs下 警示/駕照限制 數目
            updateBadge: function($target) {
                var self = this;
                
                var href = $target.attr("href");
                // 比對 匹配 顯示結果
                $.each(self.judgeTab.tabArr,function(idx,item){
                    var isJudge = item.showBadge || false;
                   if(!isJudge){
                       return;
                   }
                   if(href.indexOf(item.requestBadge.judgeStr)>-1){
                       var requestData = item.requestBadge.data||{docId: self.value};
                       $.get(item.requestBadge.requestUrl,requestData,function(pdaResponse){
                           self.judgeTab.showResult($target,pdaResponse);
                       });
                   }
                });
                
            },
            // 初始化標籤LI
            initTabLI : function(){
                var self = this;
                // 遍歷tabs
                $.each(self.tabs, function(idx, item){
                    $(self.$refs.tabUL).append("<liEle></liEle>");  
                    var liCompoment = new self.LiEle({    
                        propsData : {
                            tab : {
                                href : item.href,
                                dataHref : item.dataHref,
                                hrefType : item.hrefType || self.commonAttr.hrefType,
                                dataToggle : item.dataToggle || self.commonAttr.dataToggle,
                                text : item.text,
                                showBadge : item.showBadge || self.commonAttr.showBadge
                            }
                        }
                    });
                    liCompoment.$on("getTabContent", self.getTabPage);
                    liCompoment.$mount('liEle');
                });
            },
            // 初始化TAB鏈接內容(div塊)
            initTabHrefContent : function(){
                var self = this;
                $.each(self.tabs, function(idx, item){
                    // 掛載DIV元素
                    $(self.$refs.showContent).append("<TabContentEle></TabContentEle>");  
                    var contentCompoment = new self.TabContentEle({
                        propsData : {
                            tab : item
                        }
                    });  
                    contentCompoment.$mount('TabContentEle');
                    
                    // 如果是組件, 掛載vue的組件進div
                    var isVueCompoment = item.isVueCompoment ? item.isVueCompoment : self.commonAttr.isVueCompoment;
                    if (isVueCompoment) {
                        $(contentCompoment.$el).append("<TabCompomentContentEle></TabCompomentContentEle>");
                        var CustomComponent = Vue.component(item.compomentInfo.componentName);       
                        contentCompoment = new CustomComponent({
                            propsData : item.compomentInfo.compomentProp
                        });  
                        contentCompoment.$mount('TabCompomentContentEle');
                    }
                
                });
            }            
        }
    });  

    Vue.component('exl-other-show-tabs',otherShowTabs);
});
</script>