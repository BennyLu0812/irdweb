<template>
  <div v-show="show">
    <div class="form-group">
        <label class="control-label col-sm-1" v-text="label.licNo"></label>
        <div class="col-sm-1_5">
            <span class="text-readonly" style="font-weight:bold;font-size:14px" v-text="license.licNo"></span>
        </div>
        <label class="control-label col-sm-1" v-text="label.licType"></label>
        <div class="col-sm-2_5">
            <span class="text-readonly" v-text="license.licTypeDesc"></span>
        </div>
        <label class="control-label col-sm-1" v-text="label.validDate"></label>
        <div class="col-sm-2">
             <span v-if="!license.licExpired" class="text-readonly green-highlight" style="width: auto;" v-text="license.validDate"></span>
             <span v-else  class="text-readonly orange-highlight" style="width: auto;" v-text="license.validDate"></span>
             &nbsp;&nbsp;&nbsp;&nbsp;
             <span v-if="license.validDateCalMethod!=null" class="badge" style="display:inline;text-align:left" 
             	v-text="license.validDateCalMethod" :title="license.validDateCalMethodDesc"></span>
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
	var licenseInfo = Vue.extend({
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
                        licType: '',
                        validDate: '',
                        licStatus:''
                    },
                    label: {
                        licNo: '',
                        licType: '',
                        validDate: '',
                        licStatus:''
                    }
                }
            },
            methods:{
                initData:function(){
                    this.label.licNo= atosUtil.getI18nMessage('license.licNo');
                    this.label.licType= atosUtil.getI18nMessage('license.licType');
                    this.label.validDate= atosUtil.getI18nMessage('license.validDate');
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
    Vue.component('license-info', licenseInfo);
});

</script>

