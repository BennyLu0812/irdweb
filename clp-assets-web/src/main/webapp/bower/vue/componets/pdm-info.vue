<template>
  <div class="form-group" v-show="show">
		    	<input type="hidden" :vaule="value" >
				<div class="col-sm-12" v-show="titleshow">
				    <legend>
				        <label class="h4" v-text="label.pdmTitle"></label>
				    </legend>
				</div>
	  			<div v-if="hideIdentityDetail">
					<div class="form-group">
						<label class="control-label col-sm-1" v-text="label.cName">中文名</label>
						<div class="col-sm-1_5"><span class="text-readonly" v-text="personalProfile.cName"></span></div><label class="control-label col-sm-1">英文名</label>
						<div class="col-sm-5_5"><span class="text-readonly" v-text="personalProfile.enName"></span></div>
						<label class="control-label col-sm-1" v-text="label.identStatus">證件狀態</label>
						<div class="col-sm-2"><span  :class="statusCls"  v-text="personalProfile.identityStatus"></span></div>
					</div>
				</div>
	  			<div v-else>
					<div class="form-group">
						<label class="control-label col-sm-1" v-text="label.cName">中文名</label>
						<div class="col-sm-1_5"><span class="text-readonly" v-text="personalProfile.cName"></span></div><label class="control-label col-sm-1">英文名</label>
						<div class="col-sm-5_5"><span class="text-readonly" v-text="personalProfile.eName"></span></div><label class="control-label col-sm-1" v-text="label.birthDate">出生日期</label>
						<div class="col-sm-2"><span class="text-readonly" v-cloak>{{personalProfile.birthDate}}&nbsp;&nbsp;<strong v-cloak>({{personalProfile.age}}{{label.annum}})</strong></span></div>
					</div>
					<div class="form-group"><label class="control-label col-sm-1" v-text="label.personalIdentNo">證件編號</label>
						<div class="col-sm-1_5"><span class="text-readonly">{{personalProfile.personalIdentityNo}} </span></div><label class="control-label col-sm-1" v-text="label.personalIdentType">證件類型</label>
						<div class="col-sm-5_5"><span class="text-readonly" style="padding-right:0px" v-text="personalProfile.personalIdentityType"></span></div><label class="control-label col-sm-1" v-text="label.identStatus">證件狀態</label>
						<div class="col-sm-2"><span  :class="statusCls"  v-text="personalProfile.identityStatus"></span></div>
					</div>
				</div>


	</div>
</template>
<style scoped>

</style>

<script>
define(['jquery',"atosUtil",'Vue','vueloader'],function($,atosUtil,Vue){
	var pdmInfo = Vue.extend({
            template:template,
            props:{
				value:{type:Object},
				show:{
					type:Boolean,
					default:true
				},
				titleshow:{
					type:Boolean,
					default:false
				},
				docseq:{
					type:String
				},
				statusCls:{
				    type:String,
				    default:'green-highlight text-readonly'
				},
                hideIdentityDetail:{
				    type:Boolean,
					default:false
				}

			},
	        created:function(){
		    	this.initData();
		    },
		    data:function(){
		    	return {
		    		 personalProfile: {
			                cName: '',
			                enName: '',
			                birthDate: '',
			                age:'',
			                personalIdentityNo: '',
			                personalIdentityType: '',
			                identityStatus: '',
			        },
			    	label:{
		        		cName:'',
		        		enName:'',
		        		birthDate:'',
		        		age:'',
		        		personalIdentNo:'',
		        		personalIdentType:'',
		        		identStatus:'',
		        		annum:''
		        	}
		    }
		    },
		    methods:{
		    	initData:function(){
		    		this.label.cName= atosUtil.getI18nMessage('global.fullNameCN');
		    		this.label.enName= atosUtil.getI18nMessage('global.fullNameEN');
		    		this.label.birthDate= atosUtil.getI18nMessage('global.birthDate');
		    		this.label.age= atosUtil.getI18nMessage('global.age');
		    		this.label.personalIdentNo= atosUtil.getI18nMessage('global.personalIdentNo');
		    		this.label.personalIdentType= atosUtil.getI18nMessage('global.personalIdentType');
		    		this.label.identStatus= atosUtil.getI18nMessage('global.identStatus');
		    		this.label.pdmTitle = atosUtil.getI18nMessage('global.pdmTitle');
		    		this.label.annum=atosUtil.getI18nMessage('global.anos');

		    	},
		    	renderSpan:function(identityStatus){
		    	     if (identityStatus &&  typeof identityStatus === 'string'){
		    	         identityStatus = identityStatus.substring(0,1);
		    	         if (identityStatus == 'A'){
		    	             this.statusCls = 'green-highlight text-readonly';
		    	         }else{
		    	             this.statusCls = 'orange-highlight text-readonly';
		    	         }
		    	     }
		    	},
		    	loadData:function(){
		    		var self = this;
		    		if(self.value){
		    			var url = basePath+"/pdm/componet/getPdmInfo?docId="+self.value;
		    			if (self.docseq) {
                            url +='&docSeq='+self.docseq;
                        }
		    			$.ajax({
		    				url:url,
		    				type:'GET',
		    				success:function(response){
		    					self.personalProfile = response;
		    					self.renderSpan(self.personalProfile.identityStatus);
		    				}
		    			})
			    	}
		    	}
		    },
		    watch:{
		    	value:function(val){
		    		if (val){
		    			this.loadData();
		    		}
		    	},
		    	/*
                docseq:function(docseq){
                    this.loadData();
               }
               */

		    },
		    mounted: function () {
		    	this.loadData();
                if ($(this.$el).attr("hideIdentityDetail")) {
                    this.hideIdentityDetail = true;
                }
		    }
	})
	Vue.component('pdm-info', pdmInfo);
});

</script>
