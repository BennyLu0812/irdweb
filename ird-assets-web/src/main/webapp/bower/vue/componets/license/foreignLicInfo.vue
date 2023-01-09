<template>
  <div v-show="show">
    <div class="form-group">
        <label class="control-label col-sm-1" v-text="label.licNo"></label>
        <div class="col-sm-1_5">
            <span class="text-readonly" style="font-weight:bold;font-size:14px" v-text="license.licNo"></span>
        </div>
        <label class="control-label col-sm-1" v-text="label.foreignLicType"></label>
        <div class="col-sm-2_5">
            <span class="text-readonly" v-text="license.foreignLicTypeDesc"></span>
        </div>
        <label class="control-label col-sm-1" v-text="label.issueDate"></label>
        <div class="col-sm-2">
            <span class="text-readonly" v-text="license.issueDate"></span>
        </div>
        <label class="control-label col-sm-1">{{label.licStatus}}</label>
        <div class="col-sm-2">
            <span v-if="license.licStatus == 'A'" class="green-highlight text-readonly" v-text="license.licStatusDesc"></span>
            <span v-if="license.licStatus == 'C'" class="orange-highlight text-readonly" v-text="license.licStatusDesc"></span>
            <span v-if="license.licStatus == 'I'" class="orange-highlight text-readonly" v-text="license.licStatusDesc"></span>
            <span v-if="license.licStatus == 'P'" class="orange-highlight text-readonly" v-text="license.licStatusDesc"></span>
            <span v-if="license.licStatus == 'T'" class="orange-highlight text-readonly" v-text="license.licStatusDesc"></span>
        </div>
    </div>
  </div>	        
</template>

<script>
define(['jquery',"atosUtil",'Vue','vueloader','bootstrapValidator','bootstrapValidator.config'],function($,atosUtil,Vue){
	var foreignLicInfo = Vue.extend({
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
                    license: {
                        licNo: '',
                        foreignLicType: '',
                        issueDate: '',
                        licStatus:''
                    },
                    label: {
                        licNo: '',
                        foreignLicType: '',
                        issueDate: '',
                        licStatus:''
                    }
                }
            },
            methods:{
                initData:function(){
                    this.label.licNo= atosUtil.getI18nMessage('license.licExchangeNo');
                    this.label.foreignLicType= atosUtil.getI18nMessage('license.issuedBy');
                    this.label.issueDate= atosUtil.getI18nMessage('license.issueDate');
                    this.label.licStatus= atosUtil.getI18nMessage('license.licStatus');
                },
                loadData:function(){
                    var self = this;
                    if(self.value){
                        self.license = self.value;
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
    Vue.component('foreign-lic-info', foreignLicInfo);
});

</script>

