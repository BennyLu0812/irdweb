<template>
    <div>
        <div class="row" v-if="hzmbQuota.showCurrentComp">
            <label class="control-label col-sm-1"></label>
            <label class="col-sm-10"><span style="margin-right: 10px;" v-text="hzmbQuota.compStatusDesc">當前公司</span><span v-text="hzmbQuota.compNameDesc"></span></label>
        </div>
        <div class="row">
        <label class="control-label col-sm-2"><span style="margin-right: 10px;" v-text="label.quotaInTotal">總配額數</span><span v-text="hzmbQuota.hzmbQuotaInTotal"></span></label>
        <label class="control-label col-sm-2"><span style="margin-right: 10px;" v-text="label.quotaInUse">使用中</span><span class="badge" style="background-color: green" v-text="hzmbQuota.hzmbQuotaInUse"></span></label>
        <label class="control-label col-sm-2"><span style="margin-right: 10px;" v-text="label.quotaInProcess">考試中</span><span class="badge" style="background-color: orange" v-text="hzmbQuota.hzmbQuotaInProcess"></span></label>
        <label class="control-label col-sm-2"><span style="margin-right: 10px;" v-text="label.quotaRemains">未使用</span><span class="badge" style="background-color: #46b8da" v-text="hzmbQuota.hzmbQuotaRemains"></span></label>
        <label class="control-label col-sm-2"><span style="margin-right: 10px;" v-text="label.quotaReexamInProcess">90日內可重考</span><span class="badge" style="background-color: blue" v-text="hzmbQuota.hzmbQuotaReexamInProcess"></span></label>
        </div>
    </div>
</template>

<script>
    define(['jquery',"atosUtil",'Vue', 'axios', 'axios.config','vueloader', 'bootstrapValidator','bootstrapValidator.config'],function($,atosUtil,Vue,axios){
        var compQuotas = Vue.extend({
            template:template,
            props:{
                value:{
                    type:Object
                },
            },
            data:function(){
              return{
                    hzmbQuota:{
                        compStatusDesc:"",
                        showCurrentComp:true,
                        showTotalQuota:true,
                        compNameDesc:'',
                        hzmbQuotaInTotal:0,
                        hzmbQuotaInUse:0,
                        hzmbQuotaInProcess:0,
                        hzmbQuotaRemains:0,
                        hzmbQuotaReexamInProcess:0
                },
                 label: {
                     compCname:'',
                         changeComp:'',
                         currentComp:'',
                         quotaInTotal:'',
                         quotaInUse:'',
                         quotaInProcess:'',
                         quotaRemains:'',
                         quotaReexamInProcess:'',
                 }
              }
            },
            created:function () {
                this.initLabel();
                this.loadData();
            },
            methods:{
                loadData:function () {
                    this.hzmbQuota = this.value;
                },
                initLabel:function () {
                    this.label.quotaInTotal = atosUtil.getI18nMessage("global.comp.quotaInTotal");
                    this.label.quotaInUse = atosUtil.getI18nMessage("global.comp.quotaInUse");
                    this.label.quotaInProcess = atosUtil.getI18nMessage("global.comp.quotaInProcess");
                    this.label.quotaRemains = atosUtil.getI18nMessage("global.comp.quotaRemains");
                    this.label.quotaReexamInProcess = atosUtil.getI18nMessage("global.comp.quotaReexamInProcess");
                    this.label.currentComp = atosUtil.getI18nMessage("global.comp.currentComp");
                    this.label.changeComp = atosUtil.getI18nMessage("global.comp.changeComp");
                    this.label.compCname = atosUtil.getI18nMessage("global.comp.compCname");
                    console.log('text: ' + atosUtil.getI18nMessage("global.comp.quotaInTotal"));
                },
            },
            watch:{
                value:function(val){
                    if (val) {
                        this.loadData();
                    }
                },
                showCurrentComp:function (val) {
                }
            },
            mounted:function () {
                
            }
            
        })
        Vue.component("lic-comp-quotas",compQuotas)
    })
</script>

<style scoped>

</style>