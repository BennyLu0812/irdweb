<template>
    <div>
        <slot name="testSlot"></slot>
        <ul id="service-tabs" class="nav nav-tabs" role="tablist" ref="tabUL">
            <slot name="compomentLi"></slot>
        </ul>
        <div id="service-tab-content" class="tab-content" ref="showContent">
            <slot name="compomentContent"></slot>
        </div>
    </div>
</template>
<script>
    define(['jquery', 'Vue', 'atosUtil', 'bootstrap', 'vue.config'], function ($, Vue, atosUtil) {
        var otherShowTabs = Vue.extend({
            template: template,
            props: {
                startLoad: {
                    type: Boolean,
                    default: false
                },
                tabs: {
                    type: Object
                }
            },
            data: function () {
                return {
                    tabCache: atosUtil.createMapInstance(),
                    // 共同屬性
                    commonAttr: {
                        "show": true,
                        "role": "tab",
                        "dataToggle": "tab",
                        "showBadge": false,
                        "isVueCompoment": false,
                        "loadBadgeToshow": true
                    },
                    pageCache: {
                        pages: []
                    },
                    LiEle: {},
                    TabContentEle: {}
                };
            },

            methods: {
                showDefault : function() {
                   var self = this;
                    console.log('UL-TABS COMPOMENT SHOW DEFAULT TAB');
                    $(this.$refs.tabUL).find('a[data-toggle="tab"]:visible:eq(0)').get(0).click();
                },
                reset: function () {
                    if (!this.tabCache.isEmpty()) {
                        var tabList = this.tabCache.getAll()
                        for (var i = 0; i < tabList.length; i++) {
                            $(tabList[i]).html('')
                        }
                    }
                    this.tabCache.clear()
                },
                clickTab: function (event) {
                    var $target = $(event.target);
                    var itemName = $target.data('itemname');
                    var item = this.tabs[itemName];
                    if (this.startLoad) {
                        this.renderTab(item);
                        $target.tab('show');
                    }
                },
                // 渲染tab數據
                renderTab: function (item) {
                    // 如果已經渲染過了, 不在渲染
                    if (this.isRendered(item.href)) {
                        return;
                    }
                    // 需要進行渲染了
                    this.tabCache.put(item.href, '#' + item.href)
                    var isVueCompoment = item.isVueCompoment ? item.isVueCompoment : this.commonAttr.isVueCompoment;
                    if (isVueCompoment) {
                        this.loadVueCompoment(item, $('#' + item.href).get(0))
                        return;
                    }

                    this.loadHtml(item)
                },
                // 是否渲染過
                isRendered: function (key) {
                    if (this.tabCache.get(key)) {
                        return true;
                    }
                    return false;
                },
                // 初始化標籤LI
                initTabLI: function () {
                    var self = this;
                    // 遍歷tabs
                    $.each(self.tabs, function (idx, item) {
                        $(self.$refs.tabUL).append("<liEle></liEle>");
                        var liCompoment = new self.LiEle({
                            propsData: {
                                tab: {
                                    itemName: idx,
                                    href: item.href,
                                    dataToggle: item.dataToggle || self.commonAttr.dataToggle,
                                    text: item.text,
                                    authExp : item.auth
                                }
                            }
                        });
                        liCompoment.$on("getTabContent", self.clickTab);
                        liCompoment.$mount('liEle');
                    });
                },
                // 初始化TAB鏈接內容(div塊)
                initTabHrefContent: function () {
                    var self = this;
                    $.each(self.tabs, function (idx, item) {
                        // 掛載DIV元素
                        $(self.$refs.showContent).append("<TabContentEle></TabContentEle>");
                        var contentCompoment = new self.TabContentEle({
                            propsData: {
                                tab: item
                            }
                        });
                        contentCompoment.$mount('TabContentEle');
                    });
                },
                loadHtml: function (item) {
                    var dataHref = item.dataHref
                    $.get(dataHref, {}, function (html, status) {
                        var htmlDiv = $('<div></div>').append(html).html();
                        $('#' + item.href).html('<div>'+htmlDiv+'</div>');
                    });
                },
                loadVueCompoment: function (info, mountEle) {
                    var self = this;
                    // 如果是組件, 掛載vue的組件進div
                    $(mountEle).append("<TabCompomentContentEle></TabCompomentContentEle>");
                    var CustomComponent = Vue.component(info.compomentInfo.componentName);
                    contentCompoment = new CustomComponent({
                        propsData: info.compomentInfo.compomentProp()
                    });
                    contentCompoment.$mount('TabCompomentContentEle');
                }
            },
            created: function () {
                // li元素_TAB組件
                this.LiEle = Vue.extend({
                    template: '<li><a v-authorize = "tab.authExp" :data-itemname="tab.itemName" :href = "\'#\'+tab.href" :data-toggle = "tab.dataToggle"  @click = "$emit(\'getTabContent\', $event)">'
                        + '{{tab.text}}'
                        + '</a></li>'
                    ,
                    props: {
                        tab: {type: Object}
                    }
                });

                // 標籤內容組件
                this.TabContentEle = Vue.extend({
                    template: '<div :id="tab.href" role="tabpanel" class="tab-pane fade"></div>',
                    props: {
                        tab: {type: Object}
                    }
                });
            },
            mounted: function () {
                this.initTabLI();
                this.initTabHrefContent();
            },
        });

        Vue.component('ul-tabs', otherShowTabs);
    });
</script>