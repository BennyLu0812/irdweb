<template>
  <div v-show="show">
    <div class="form-group">
        <label class="control-label col-sm-1" style="padding-right:0px;" v-text="label.licSubstituteNo"></label>
        <div class="col-sm-1" style="padding-right:0px"><span class="text-readonly" v-text="spTxn.caseNo"><br></span></div>
        <label class="control-label col-sm-1_5" v-text="label.applyDate"></label>
        <div class="col-sm-2"><span class="text-readonly" v-text="spTxn.createDate"></span></div>
        <label class="control-label col-sm-1_5 control-label-required"  for="substituteValidDate" v-text="label.validDate"></label>
        <div class="col-sm-2 validClass">
            <input type="text" id="substituteValidDate" name="substituteValidDate" class="form-control datepicker" value="" v-model="spTxn.substituteValidDate">
        </div>
        <label class="control-label col-sm-1" ></label>
        <!-- 因不需要改為動態收費，因此亦無須輸入此欄位 -->
        <div v-show="showcheckbox" class="col-sm-2" style="padding-left:0px">
            <input type="checkbox"  true-value="Y"
                   false-value="N" v-model="spTxn.isLicLost" value="N" >
            <span v-text="label.isLicLost"></span>
        </div>
    </div>
  </div>	        
</template>

<script>
define(['jquery',"atosUtil",'Vue','vueloader','bootstrapValidator','bootstrapValidator.config','datetimepicker.config'],function($,atosUtil,Vue){
	var licSubstitute = Vue.extend({
		template:template,
		 props: {
	            show: {
	                type: Boolean,
	                default: false
	            },
             showcheckbox: {
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
                    spTxn: {
                        spNo: '',
                        caseNo: '',
                        createDate: '',
                        substituteValidDate: '',
                        licRemark: '',
                        isLicLost: ''
                    },
                    label: {
                        licSubstituteNo: '',
                        createDate: '',
                        validDate: '',
                        isLicLost: ''
                    }
                }
            },
            methods:{
                initData:function(){
                    this.label.licSubstituteNo = atosUtil.getI18nMessage('licSubstitute.licSubstituteNo');
                    this.label.applyDate = atosUtil.getI18nMessage('licSubstitute.applyDate');
                    this.label.validDate= atosUtil.getI18nMessage('licSubstitute.validDate');
                    this.label.isLicLost= atosUtil.getI18nMessage('licSubstitute.isLicLost');
                },
                loadData:function(){
                    var self = this;
                    if(self.value){
                        self.spTxn = self.value;
                        if(self.spTxn.isLicLost == null || self.spTxn.isLicLost == ''){
                            self.spTxn.isLicLost = 'N'
                        }
                    }
                },
                initDatePicker:function(){
                  var self = this;
                  $('#substituteValidDate').datetimepicker({
                  }).on('changeDate',function(ev){
                    self.spTxn.substituteValidDate = $("#substituteValidDate").val();
                  });                  
                }
            },
            watch:{
                value:function(val){
                    var self = this;
                    if (val){
                        this.loadData();
                    }
                }
            },
            mounted: function () {
                this.loadData();
                $(".validClass").addClass("form-validator has-feedback");
            }
	})	
    Vue.component('lic-substitute', licSubstitute);
});

</script>

