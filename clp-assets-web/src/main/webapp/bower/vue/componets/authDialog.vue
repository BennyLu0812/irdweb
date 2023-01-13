<template>
  <div v-show="show">
	        <div class="modal fade" role="dialog" tabindex="-1" id="authDialog" @click.self="clickMask">
				<div class="modal-dialog" role="document">
				<form class="form-horizontal row-sm" id="authForm" role="form">
	                <div class="modal-content">
	                    <!--Header-->
	                    <div class="modal-header btn-primary">
	                        <slot name="header">
	                            <a type="button" class="close" @click="cancel">x</a>
	                            <h4 class="modal-title">
	                                <slot name="title">
	                                    {{title}}
	                                </slot>
	                            </h4>
	                        </slot>
	                    </div>
	                    <!--Container-->
	                    <div class="modal-body">
								<div class=" alert alert-danger" v-if="showArtDiv"><span>{{alertMsg}}</span></div>
							  <div class="form-group">
								  <label for="firstname" class="col-sm-2 control-label">{{modal.userName}}</label>
							    <div class="col-sm-10">
							      <input type="text" class="form-control" id= "username" name="username" placeholder="用戶名">
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="password" class="col-sm-2 control-label">{{modal.password}}</label>
							    <div class="col-sm-10">
							      <input type="password" id="password" autocomplete="false" class="form-control" name="password" placeholder="密碼">
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="remark" class="col-sm-2 control-label">{{modal.remark}}</label>
							    <div class="col-sm-10">
							     <textarea id="remark" name="remark" class="form-control" rows="3" ></textarea>
							    </div>
							  </div>
	                    </div>
	                    <!--Footer-->
	                    <div class="modal-footer">
	                        <slot name="footer">
								<button type="button" :class="resetClass" type="reset" @click="resetForm"><i class="glyphicon glyphicon-refresh">{{resetText}}</i></button>
	                            <button type="button" :class="cancelClass" @click="cancel">{{cancelText}}</button>
	                            <button type="button" :class="okClass" @click="ok">{{okText}}</button>
	                        </slot>
	                    </div>
	                </div>
				</form>
				</div>
	        </div>
	        <div class="modal-backdrop in"></div>
	    </div>
</template>
<style scoped>
</style>

<script>
define(['jquery',"atosUtil",'Vue','axios','axios.config','vueloader','bootstrap','bootstrapValidator','bootstrapValidator.config'],function($,atosUtil,Vue,axios){
	var authDialog = Vue.extend({
		template:template,
		 props: {
	            show: {
	                type: Boolean,
	                default: false
	            },
	            title: {
	                type: String,
	                default: '您的操作必須得到授權，請輸入以下授權人資料:'
	            },
	            small: {
	                type: Boolean,
	                default: false
	            },
	            large: {
	                type: Boolean,
	                default: false
	            },
	            full: {
	                type: Boolean,
	                default: false
	            },
	            // 为true时无法通过点击遮罩层关闭modal
	            force: {
	                type: Boolean,
	                default: false
	            },
	            // 确认按钮text
	            okText: {
	                type: String,
	                default: '確定'
	            },
	            // 取消按钮text
	            cancelText: {
	                type: String,
	                default: '取消'
	            },
	            // 确认按钮className
	            okClass: {
	                type: String,
	                default: 'btn blue'
	            },
	            // 取消按钮className
	            cancelClass: {
	                type: String,
	                default: 'btn red btn-outline'
	            },
			    resetText:{
	                type:String,
					default: '重置'
				},
			 	resetClass: {
	                typ:String,
					default: 'btn btn-sm btn-default'
				},

	            // 点击确定时关闭Modal
	            // 默认为false，由父组件控制prop.show来关闭
	            closeWhenOK: {
	                type: Boolean,
	                default: false
				},
				authParams:{
					type:Object
				}
	        },
	        data:function() {
	            return {
	                duration: null,
                    showArtDiv:false,
                    alertMsg:'',
	                modal:{
	                	userName:'',
	                	password:'',
	                	remark:'',
	                }
	            };
	        },
	        mounted:function(){
	        	this.init();
	        },
	        computed: {
	            modalClass:function () {
	                return {
	                    'modal-lg': this.large,
	                    'modal-sm': this.small,
	                    'modal-full': this.full
	                }
	            }
	        },
	        created :function() {
	        	//this.init();
	            if (this.show) {
                    $("#authDialog").modal('show');
	            }
	        },
	        beforeDestroy:function () {
	            document.body.className = document.body.className.replace(/\s?modal-open/, '');
                $("#authDialog").modal('hide');
	        },
	        watch: {
	            show :function(value,oldValue) {
	                // 在显示时去掉body滚动条，防止出现双滚动条
	                if (value) {
	                  //  document.body.className += ' modal-open';
                        $("#authDialog").modal('show');
	                }
	                // 在modal动画结束后再加上body滚动条
	                else {
                        $("#authDialog").modal('hide');
	                }
	            }
	        },
	        methods: {
	            ok :function() {
					// call auth
					var self = this;
					if (!$.formValidator('#authForm')) {
                        return false;
                    }
                    self.authorizationHanlder(function(){
						self.$emit('ok');
					});
	                if (self.closeWhenOK) {
	                    self.show = false;
					}
				},

	            resetForm:function(){
					$("#authForm")[0].reset();
	                $("#authForm").data('bootstrapValidator').resetForm();
                    this.showArtDiv = false;
                    this.alertMsg = "";
				},
				authorizationHanlder:function(callback){
					var self = this;
					var authParams = self.authParams;
					authParams.authUser = $("#username").val();
					authParams.password = $("#password").val();
					authParams.remark = $("#remark").val();
                    atosUtil.showLoading();
                    $.ajax({
	            		url:basePath +'/sys/auth/user',
						//data:form.serialize(),
						type:'POST',
						data:authParams,
	            		success: function(response) {
                            atosUtil.hideLoading();
							//添加成功後的回調
							if (callback && response === 'SUCCESS'){
                                self.resetForm();
								callback();
							}else{
							    self.showArtDiv = true;
								self.alertMsg = response;
							}
	            		},
						error:function (e) {
                            atosUtil.hideLoading();
                            //self.showArtDiv = true;
                            $.showResult(e);
                        }
	            	})
				},
	            init:function(){
	            	this.initLabel();
	            	$("#authForm").bootstrapValidator({
                         fields: {
                             username: {
                                 validators: {
                                     notEmpty: {
                                         message: atosUtil.getI18nMessage('model.validate.username.notEmpty')
                                     }
                                 }
                             },
                             password: {
                                 validators: {
                                     notEmpty: {
                                         message: atosUtil.getI18nMessage('model.validate.password.notEmpty')
                                     }
                                 }
                             },
                         }
	            	})

					$("#authDialog").on('shown.bs.modal', function (e) {
                        // 关键代码，如没将modal设置为 block，则$modala_dialog.height() 为零
                        $(this).css('display', 'block');
                        var modalHeight=$(window).height() / 2 - $('#authDialog .modal-dialog').height() / 2;
                        $(this).find('.modal-dialog').css({
                            'margin-top': modalHeight
                        });
                    });
                  $('#authForm :input.form-control').closest('.form-group, [class*="col-"]').addClass('form-validator has-feedback');
	            },
	            initLabel:function(){
	                var self = this;
	                atosUtil.getLocalI18nByModules("comps",function (pdaResponse) {
                        self.modal.userName = pdaResponse['modal.label.user.userName'];
                        self.modal.password = pdaResponse['modal.label.user.password'];
                        self.modal.remark = pdaResponse['modal.label.user.remark'];
                        self.cancelText = pdaResponse['modal.label.cancelText'];
                        self.okText = pdaResponse["modal.label.okText"];
                        self.resetText = pdaResponse["modal.label.reset"];

                    })


                },
	            cancel:function () {
	                this.$emit('cancel');
	                this.show = false;
	                this.showArtDiv = false;
	            },
	            // 点击遮罩层
	            clickMask:function() {
	                if (!this.force) {
	                    this.cancel();
	                }
	            }
	        }

	})
    Vue.component('auth-dialog', authDialog);
});

</script>
