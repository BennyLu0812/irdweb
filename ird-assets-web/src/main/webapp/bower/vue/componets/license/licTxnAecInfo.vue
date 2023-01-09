<template>
  <div v-show="true">
      <div  class="form-group">
          <label class="control-label col-sm-1" v-text="label.driverLicNo"> </label>
          <div class="col-sm-8">
              <span class="text-readonly" v-text="licTxn.driverLicNo"></span>
          </div>                    
          <label class="control-label col-sm-1" v-text="label.officialLetterNo"></label>
          <div class="col-sm-2">
              <span class="text-readonly" v-text="licTxn.officialLetterNo"></span>
          </div>   
      </div>
      <div class="form-group">            
		  <label class="control-label col-sm-1" v-text="label.issuePlace"></label>
          <div class="col-sm-8">
              <span class="text-readonly" v-text="licTxn.driverLicIssuePlaceDesc"></span>
          </div>
          <label class="control-label col-sm-1" v-text="label.officialLetterDate" ></label>
          <div class="col-sm-2">
              <span class="text-readonly" v-text="licTxn.officialLetterDate"></span>
          </div>  
      </div>
  </div>
</template>

<script>
define(['jquery',"atosUtil",'Vue','vueloader','bootstrapValidator','bootstrapValidator.config'],function($,atosUtil,Vue){
	var licTxnAecInfo = Vue.extend({
		template:template,
		 props: {
	            show: {
	                type: Boolean,
	                default: false
	            },
	            value:{type:Object},
	        },
	        created:function(){
                this.initData();
            },
	        data:function(){
                return {
                    licTxn: {
                        officialLetterNo: '',
                        officialLetterDate: '',
                        licNo: '',
                        issuePlace: '',
                        licTxnCat:''
                    },
                    label: {
                        officialLetterNo: '',
                        officialLetterDate: '',
                        driverLicNo: '',
                        licCat: '',
                        issuePlace:''
                    }
                }
            },
            methods:{
                initData:function(){
                    this.label.officialLetterNo= atosUtil.getI18nMessage('lic.aec.officialLetterNo');
                    this.label.officialLetterDate= atosUtil.getI18nMessage('lic.aec.officialLetterDate');
                    this.label.driverLicNo= atosUtil.getI18nMessage('lic.aec.driverLicNo');
                    this.label.issuePlace= atosUtil.getI18nMessage('lic.aec.driverLicIssuePlace');
                    this.label.licCat= atosUtil.getI18nMessage('lce.licCat2');
                },
                loadData:function(){
                    var self = this;
                    if(self.value){
                        self.licTxn = self.value;
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
    Vue.component('lic-txn-aec-info', licTxnAecInfo);
});

</script>

