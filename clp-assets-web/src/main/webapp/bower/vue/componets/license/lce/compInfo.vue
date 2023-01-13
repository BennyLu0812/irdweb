<template>
  <div v-show="show">
    <div>
        <div class="form-group">
            <label class="control-label col-sm-1">{{label.compIdentType}}</label>
            <div class="col-sm-1">
                <span class="text-readonly"  :title="comp.compIdentTypeDesc" v-text="comp.compIdentType"></span>
            </div>
            <label class="control-label col-sm-1">{{label.compIdentNo}}</label>
            <div class="col-sm-1_5">
                <span class="text-readonly" v-text="comp.compIdentNo"></span>
            </div>
            <label class="control-label col-sm-1" >{{label.compAbrev}}</label>
            <div class="col-sm-1_5">
                <span class="text-readonly" v-text="comp.compAbrev"></span>
            </div>
            <label class="control-label col-sm-1"  v-if="!showcomppepr">{{label.compBranchCode}}</label>
            <div class="col-sm-1_5"  v-if="!showcomppepr">
                <span class="text-readonly" v-text="comp.compBranchCode"></span>
            </div>
            <label class="control-label col-sm-1" th:text="#{comp.compStatus}">{{label.compStatus}}</label>
            <div class="col-sm-1_5">
                <span v-if="comp.compStatus == 'A'" class="green-highlight text-readonly" v-text="comp.compStatusDesc"></span> <span
                    v-if="comp.compStatus == 'C'" class="orange-highlight text-readonly" v-text="comp.compStatusDesc"></span>
            </div>
            
        </div>
        <div class="form-group">
            <label class="control-label col-sm-1">{{label.compCname}}</label>
            <div class="col-sm-3_5">
                <span class="text-readonly" v-text="comp.compCname"> </span>
            </div>
            <label class="control-label col-sm-1">{{label.compEname}}</label>
            <div class="col-sm-6_5">
                <span class="text-readonly" v-text="comp.compEname"><br></span>
            </div>
        </div>
        
        <div class="form-group" v-if="showcomppepr">
            <label class="control-label col-sm-1">{{label.compReprCname}}</label>
            <div class="col-sm-3_5">
                <span class="text-readonly" v-text="comp.compReprCname"> </span>
            </div>
            <label class="control-label col-sm-1">{{label.compReprPname}}</label>
            <div class="col-sm-6_5">
                <span class="text-readonly" v-text="comp.compReprPname"><br></span>
            </div>
        </div>
        
        <div class="form-group">
            <label class="control-label col-sm-1">{{label.compAddrCN}}</label>
            <div class="col-sm-11">
                <span class="text-readonly" v-text="comp.compAddrCN"></span>
            </div>
        </div>
        <!-- 母公司資料 -->
        <div class="form-group" v-if="comp.child">
            <label class="control-label col-sm-1" style="padding-left: 0px">{{label.parentCompCname}}</label>
            <div class="col-sm-3_5">
                <span class="text-readonly" v-text="comp.parentCompCname"></span>
            </div>
            <label class="control-label col-sm-1" style="padding-left: 0px">{{label.parentCompPname}}</label>
            <div class="col-sm-6_5">
                <span class="text-readonly" v-text="comp.parentCompPname"><br></span>
            </div>
        </div>
        <!-- END OF 母公司資料 -->
    
        <!-- 公司負責人資料 -->
    
        <!-- END OF 公司負責人資料 -->
    </div>
  </div>	        
</template>

<script>
define(['jquery',"atosUtil",'Vue','vueloader','bootstrapValidator','bootstrapValidator.config'],function($,atosUtil,Vue){
	var compInfo = Vue.extend({
		template:template,
		 props: {
	            show: {
	                type: Boolean,
	                default: false
	            },
                showcomppepr: {
                    type: Boolean,
                    default: false
                },
                lce:{
                	type: Boolean,
                	default: false
                },
	            value:{type:Object}
	        },
	        created:function(){
                this.initData();
            },
	        data:function(){
                return {
                    comp: {
                        compCode : '',
                        compIdentType : '',
                        compIdentNo : '',
                        compAbrev:'',
                        compBranchCode : '',
                        compStatus:'',
                        compCname:'',
                        compPname:'',
                        compAddrCN:'',
                        parentCompCname:'',
                        parentCompPname:''
                    },
                    label: {
                        compIdentType: '',
                        compIdentNo: '',
                        compAbrev:'',
                        compBranchCode:'',
                        compStatus:'',
                        compCname:'',
                        compPname:'',
                        compAddrCN:'',
                        parentCompCname:'',
                        parentCompPname:''
                    }
                }
            },
            methods:{
                initData:function(){
                	var self = this;
                    this.label.compIdentType= atosUtil.getI18nMessage('comp.compIdentType');
                    this.label.compIdentNo= atosUtil.getI18nMessage('comp.compIdentNo');
                    if(self.lce){
                    	this.label.compAbrev= atosUtil.getI18nMessage('comp.compAbrev');
                    }else{
                    	this.label.compAbrev= atosUtil.getI18nMessage('comp.macauCompIdentNo');
                    }
                    
                    this.label.compBranchCode= atosUtil.getI18nMessage('comp.compBranchCode');
                    this.label.compReprCname = atosUtil.getI18nMessage('comp.compReprCname');
                    this.label.compReprPname = atosUtil.getI18nMessage('comp.compReprPname');
                    
                    this.label.compStatus= atosUtil.getI18nMessage('comp.compStatus');                 
                    this.label.compCname= atosUtil.getI18nMessage('comp.compCname');
                    this.label.compPname= atosUtil.getI18nMessage('comp.compEname');
                    this.label.compAddrCN= atosUtil.getI18nMessage('comp.compAddrCN');
                    this.label.parentCompCname= atosUtil.getI18nMessage('comp.parentCompCname');
                    this.label.parentCompPname= atosUtil.getI18nMessage('comp.parentCompPname');
                    console.info("-----------------");
                    console.info(atosUtil.getI18nMessage('comp.compPeprPname'));
                    
                },
                loadData:function(){
                    var self = this;
                    if(self.value){
                        self.comp = self.value;
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
    Vue.component('comp-info', compInfo);
});

</script>

