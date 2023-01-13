<template>
  <div v-show="show">
                <div class="form-group">
                    <label class="control-label col-sm-1" v-text="label.licNo">駕照編號 </label>
                    <div class="col-sm-1_5">
                        <span class="text-readonly" style="font-weight:bold;font-size:14px" v-text="license.licNo"></span>
                    </div>
                    <label class="control-label col-sm-1" v-text="label.licType">駕照類型</label>
                    <div class="col-sm-2_5">
                        <span class="text-readonly" v-text="license.licTypeDesc"></span>
                    </div>
                    <label class="control-label col-sm-1" v-text="label.validDate">駕照有效期</label>
                    <div class="col-sm-2">
                         <span :class="validDateFieldCss" style="width:auto" v-text="license.validDate">		
                         </span>
                         &nbsp;&nbsp;&nbsp;&nbsp;
                         <span v-if="license.validDateCalMethod!=null" class="badge" style="display:inline;text-align:left" 
                         	v-text="license.validDateCalMethod" :title="license.validDateCalMethodDesc"></span>
                    </div>
                    <label class="control-label col-sm-1" v-text="label.licStatus">駕照狀態 </label>
                    <div class="col-sm-2">
                        <span v-if="license.licStatus == 'A'" class="green-highlight text-readonly"  v-text="license.licStatusDesc"></span>
                        <span v-if="license.licStatus == 'C'" class="orange-highlight text-readonly" v-text="license.licStatusDesc"></span>
                        <span v-if="license.licStatus == 'I'" class="orange-highlight text-readonly" v-text="license.licStatusDesc"></span>
                        <span v-if="license.licStatus == 'P'" class="orange-highlight text-readonly" v-text="license.licStatusDesc"></span>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-1" style="padding-left:0px" v-text="label.firstIssueDate">首次簽發日期 </label>
                    <div class="col-sm-1_5">
                        <span class="text-readonly" v-text="license.firstIssueDate"></span>
                    </div>
                    <label class="control-label col-sm-1"  style="padding-left:0px" v-text="label.lastIssueDate"> 最後簽發日期</label>
                    <div class="col-sm-2_5">
                        <span class="text-readonly" v-text="license.lastIssueDate"></span>
                    </div>
                    <label class="control-label col-sm-1"> 其他駕照</label>
                    <div class="col-sm-5">
                        <a sec:authorize="hasPermission('DLS-LIC-LICENSE-DETAIL')" class="btn btn-primary btn-sm fancybox fancybox.iframe" role="button" :href="'to_related_lic?docId='+license.docId+'&licType='+license.licType+'&licNo='+license.licNo+'&changeUrl='+changeUrl" data-fancybox-width="80%" data-fancybox-height="50%">相關澳門駕照 </a>&nbsp;
                        <a v-if="license.detailsURL !=null" class="btn btn-info btn-sm fancybox fancybox.iframe" role="button" :href="license.detailsURL" data-fancybox-width="80%" data-fancybox-height="50%">的士專業工作證 </a>&nbsp;
                        <a v-if="license.coachLicStatus =='A'" class="btn btn-info btn-sm fancybox fancybox.iframe" role="button" :href="'/dls/web/dis/coach/coachDetail.html?coachId='+license.coachId" data-fancybox-width="90%" data-fancybox-height="90%">教練員准照 </a>&nbsp;
                    </div>
                </div>
                <div class="form-group" v-if="license.licStatus=='I'">
                	<label class="control-label col-sm-1" v-text="label.officialLetterNo">批示編號</label>
                    <div class="col-sm-1_5">
                        <span class="text-readonly" v-text="license.officialLetterNo"></span>
                    </div>
                    <label class="control-label col-sm-1" v-text="label.invalidReason">失效原因</label>
                    <div class="col-sm-8_5">
                        <span class="text-readonly" v-text="license.invalidReasonDesc"></span>
                    </div>
                    
                </div>
  </div>	        
</template>

<script>
define(['jquery',"atosUtil",'Vue','vueloader','bootstrapValidator','bootstrapValidator.config'],function($,atosUtil,Vue){
	var licSectionInfo = Vue.extend({
		template:template,
		 props: {
	            show: {
	                type: Boolean,
	                default: false
	            },
	            value:{type:Object},
	            changeUrl: {
                    type: Boolean,
                    default: false
                },
	        },
	        created:function(){
                this.initData();
            },
	        data:function(){
                return {
                    validDateFieldCss:'',
                    license: {
                        licNo: '',
                        licTypeDesc: '',
                        validDate:'',
                        licStatus:'',
                        licStatusDesc: '',
                        firstIssueDate:'',
                        lastIssueDate: '',
                        invalidReasonDesc: '',
                        officialLetterNo: '',
                        docId:'',
                        detailsURL:'',
                        coachLicStatus:'',
                        coachId:''
                    },
                    label: {
                        nameCN: '',
                        namePT: '',
                        birthDate:'',
                        personalIdentNo: '',
                        identType:'',
                        identStatus: '',
                        compCode: '',
                        compCname: '',
                        compPname:''
                    }
                }
            },
            methods:{
                initData:function(){
                    this.label.licNo= atosUtil.getI18nMessage('license.licNo');
                    this.label.licType= atosUtil.getI18nMessage('license.licType');
                    this.label.licStatus= atosUtil.getI18nMessage('license.licStatus');
                    this.label.validDate= atosUtil.getI18nMessage('license.validDate');
                    this.label.firstIssueDate= atosUtil.getI18nMessage('license.firstIssueDate');
                    this.label.lastIssueDate= atosUtil.getI18nMessage('license.lastIssueDate');
                    this.label.invalidReason= atosUtil.getI18nMessage('license.invalidReason');
                    this.label.officialLetterNo= atosUtil.getI18nMessage('license.officialLetterNo');
                },
                loadData:function(){
                    var self = this;
                    if(self.value){
                        self.license = self.value;
                        if(self.license.docId != null && self.license.docId != ''){
                             $.get(basePath + '/lic/license/getTaxiDriving', {docId: self.license.docId}, function (pdaResponse) {
                                self.license.detailsURL = pdaResponse[0].detailsURL;
                            });
                        }
                        if (self.license.licExpired) {
                                        self.validDateFieldCss = 'text-readonly orange-highlight';
                                    }else
                                        self.validDateFieldCss = 'text-readonly green-highlight';
                    }
                }
            },
            watch:{
                value:function(val){
                    if (val){
                        this.loadData();
                    }
                }
            },
            mounted: function () {
                this.loadData();
            }
	})	
    Vue.component('lic-section-info', licSectionInfo);
});

</script>

