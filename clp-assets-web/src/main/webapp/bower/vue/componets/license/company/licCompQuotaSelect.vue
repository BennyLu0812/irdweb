<template>
    <div>
        <div class="form-group">
            <label class="control-label col-sm-1 required"  v-text="label.compCname">公司名稱</label>
                <div class="col-sm-10">
                    <div class="selectClass">
                    <v-select  @change="changeHandler" @selected="selectedCompCode" v-model="selectParam.compIdentTypeAndNo" lazy="true"
                              :url="selectParam.licPecCompIdUrl" :options="selectParam.pecCompOptions"></v-select>
                    </div>
                </div>
        </div>
        <div class="form-group">
        <lic-comp-quotas v-if="currentShow" v-model="hzmbQuota"></lic-comp-quotas>
        </div>
        <div class="form-group">
        <lic-comp-quotas v-if="isChangedComp" v-model="selectedHzmbQuota"></lic-comp-quotas>
        </div>
    </div>

</template>

<script>
    define(['jquery',"atosUtil",'Vue','axios', 'axios.config','vueloader','select2.config','vueSelect2',
        'bootstrapValidator','bootstrapValidator.config',
        'vueloader!vue/componets/license/company/licCompQuotas'], function($,atosUtil,Vue,axios){
        var compQuotaSelect = Vue.extend({
            template: template,
            props: {
                value:Object,
                selectedValue:{
                    type:String
                },
                name:{
                    type:String,
                    default:'compIdentTypeAndNo',
                }
            },
            data: function () {
                return {
                        comp:null,
                        isChangedComp:false,
                        oldCompTypeAndCode:'',
                        currentShow:true,
                        hzmbQuota: {
                            compStatusDesc:"",
                            showCurrentComp:true,
                            compNameDesc: '',
                            hzmbQuotaInTotal: 0,
                            hzmbQuotaInUse: 0,
                            hzmbQuotaInProcess: 0,
                            hzmbQuotaRemains: 0,
                            hzmbQuotaReexamInProcess: 0
                        },
                        selectedHzmbQuota: {
                            compStatusDesc:"",
                            showCurrentComp:true,
                            compNameDesc: '',
                            showTotalQuota:true,
                            hzmbQuotaInTotal: 0,
                            hzmbQuotaInUse: 0,
                            hzmbQuotaInProcess: 0,
                            hzmbQuotaRemains: 0,
                            hzmbQuotaReexamInProcess: 0
                        },
                        selectParam: {
                            licPecCompIdUrl:basePath + "/lic/comp/getCompPECQuotaSelectPage",
                            pecCompOptions:[],
                            compIdentTypeAndNo:''
                        },
                        label: {
                            compCname:'',
                        }
                }
            },
            mounted:function (){
                // 添加上bootstrapValidator 样式
                this.setUpProps();
                $(".selectClass").addClass("form-validator");
            },
            created:function(){
                this.initLabel();
                this.loadData();
            },
            watch:{
                value:function (val) {
                    if (val) {
                        this.loadData();
                    }
                }
            },
            methods:{
                setUpProps:function () {
                    // this.$el 是編譯渲染完成的元素
                   $(this.$el).find("select").attr("name",this.name);
                },
                initLabel:function () {
                    this.label.compCname = atosUtil.getI18nMessage("global.compName");
                },
                loadChanged:function (data,showChangedComp){
                    //獲取公司的配額
                    var self = this;
                    axios.post(basePath + '/lic/comp/hzmb_quota_summary', data).then(function(response) {
                        self.selectedHzmbQuota = response;
                        self.selectedHzmbQuota.compNameDesc = data.selectedCompNameDesc;
                        self.isChangedComp = showChangedComp;
                        self.selectedHzmbQuota.showCurrentComp = true;
                        self.selectedHzmbQuota.showTotalQuota = true;
                        self.selectedHzmbQuota.compStatusDesc = atosUtil.getI18nMessage("global.comp.changeComp");
                    });
                },
                loadLastSavedData:function (data){
                    var self = this;
                    axios.post(basePath + '/lic/comp/hzmb_quota_summary', data).then(function(response) {
                        self.hzmbQuota = response;
                        self.hzmbQuota.compNameDesc = data.compNameDesc;
                        self.hzmbQuota.showCurrentComp = true; // 顯示公司說明
                        self.hzmbQuota.showTotalQuota = true;//  顯示總總配額數
                        self.hzmbQuota.compStatusDesc = atosUtil.getI18nMessage("global.comp.currentComp");
                    });
                },
                selectedCompCode:function () {
                    var self = this;
                    if (self.selectParam.compIdentTypeAndNo != self.oldCompTypeAndCode) {
                        self.isChangedComp = true;
                    } else {
                        self.isChangedComp = false;
                    }
                    self.value.compIdentTypeAndNo = self.selectParam.compIdentTypeAndNo;
                    if (!self.comp) self.comp = self.value;
                    
                    var parts = self.comp.compIdentTypeAndNo.split('#');
                    
                    axios.get(basePath + '/lic/comp/getCompByCompIdentTypeAndNo?compIdentType=' + parts[0] + '&compIdentNo=' + parts[1]).then(function(response) {
                        self.value.compIdentNo = response.compIdentNo;
                        self.value.compIdentType = response.compIdentType;
                        self.value.compIdentTypeAndNo = self.selectParam.compIdentTypeAndNo;
                        self.value.selectedCompNameDesc = self.getCompDesc(response.compIdentNo,response.compIdentType,response.compPname,response.compCname);
                        self.loadChanged(self.value, self.isChangedComp);
                    });

                },
                changeHandler:function (){
                    var self = this;
                    // 清空後 隱藏當前改變的配額顯示
                    if (!self.selectParam.compIdentTypeAndNo) {
                        self.isChangedComp = false;
                        return;
                    }
                },
                getCompDesc:function (compIdentNo,compIdentType,compPname,compCname) {
                    return  compIdentType + ' - ' +compIdentNo+' - '+ (compPname?compPname:"") + ' - ' + (compCname? compCname:"");
                },
                loadData:function () {
                    var self = this;
                    var lastSavedComp = {};
                    self.comp = self.value;
                    if (self.comp){
                        // 原來已經保存完成公司的數據
                        if (self.comp.licPecComp) {
                            lastSavedComp.comp = self.comp.licPecComp;
                            lastSavedComp.comp.compNameDesc =  self.getCompDesc(lastSavedComp.comp.compIdentType,lastSavedComp.comp.compIdentNo,lastSavedComp.comp.compEname,lastSavedComp.comp.compCname);
                            self.convertCompIdentity(lastSavedComp.comp);
                            self.oldCompTypeAndCode = lastSavedComp.comp.compIdentType + '#' + lastSavedComp.comp.compIdentNo;
                        }else{
                            lastSavedComp.comp = {};
                            self.currentShow = false; // 隱藏當前公司顯示區
                        }
                    
                        self.selectParam.compIdentTypeAndNo = self.comp.compIdentTypeAndNo; // 賦值下拉選中值
                        if (lastSavedComp.comp.compIdentTypeAndNo &&　 lastSavedComp.comp.compIdentTypeAndNo　== self.comp.compIdentTypeAndNo ) {
                            self.isChangedComp = false;  // 兩次一樣，就表示選擇的和上次的是一樣的，隱藏改變後的內容
                            self.loadLastSavedData(lastSavedComp.comp);
                        }else if (self.comp.compIdentTypeAndNo && self.comp.compIdentTypeAndNo !=lastSavedComp.comp.compIdentTypeAndNo) {
                            // 初始選中
                            if (self.currentShow) {
                                self.loadLastSavedData(lastSavedComp.comp);
                            }
                            
							var parts = self.comp.compIdentTypeAndNo.split('#');
                            
                            axios.get(basePath + '/lic/comp/getCompByCompIdentTypeAndNo?compIdentType=' + parts[0] + '&compIdentNo=' + parts[1]).then(function(response) {
                                self.value.compIdentNo = response.compIdentNo;
                                self.value.compIdentType = response.compIdentType;
                                self.value.compIdentTypeAndNo = self.selectParam.compIdentTypeAndNo;
                                //self.value.selectedCompNameDesc = response.compCode + ' - ' + response.compPname + ' - ' + response.compCname;
                                self.value.selectedCompNameDesc = self.getCompDesc(response.compIdentNo,response.compIdentType,response.compPname,response.compCname);
                                //獲取公司的配額
                                self.loadChanged(self.value,true);
                            });
                        } 
                    }else{
                        self.currentShow = false; // 隱藏當前公司顯示區
                    }
                },
                convertCompIdentity: function(comp) {
                    comp.compIdentTypeAndNo = comp.compIdentType + '#' + comp.compIdentNo;
                }

            }

        })
        Vue.component("lic-comps-quotas-select",compQuotaSelect)
    })
</script>

<style scoped>
    
</style>