/**
 * 控制器.
 * @param $
 * @param dlsBaseController
 * @param momentConfig
 * @param axios
 * @returns
 */
require([
        'jquery',
        'Vue',
        'atosBaseController',
        'moment',
        'moment.config',
        'atosUtil',
        'axios',
        'tinyImgUpload',
        'jquery.config',
        'axios.config',
        'datatables.config',
        'vueSelect2',
        'select2',
        'select2.config',
        'bootstrapValidator.config',
        'datetimepicker.config',
        'fileinput'
    ],
    function($, Vue, atosBaseController, moment, momentConfig, atosUtil, axios, tinyImgUpload) {

        'use strict'; // 使用JS嚴格模式.
        var controller = atosBaseController(momentConfig, {
            variables: {
                vue: null,
                i18n: {},
            },
            init: function() {
                var self = this;
                atosUtil.getI18nByModules('global, enum, api', function(result) {
                    self.variables.i18n = result;
                    self.initVue(); // 初始化vue
                    self.initEvent(); // 初始化事件
                    self.vaildate();
                });
            },
            // 初始化vue
            initVue: function() {
                var self = this;
                this.vue = new Vue({
                    el: '#serviceFailureEventAPIRequestApp',
                    data: {
                        dataCentreId: '',
                        severity: '',
                        failure: '',
                        servicesAffected: '',
                        timeStampEvent:'',
                        responseResult:'',
                        severityOptions: []
                    },
                    methods: {
                        doSave: function() {
                            var self = this;
                            if (!$.formValidator('#serviceFailureEventAPIRequestForm')) { // 驗證
                                return false;
                            }
                        }
                    },
                    computed: {
                        examNoAndYear: function() {
                            return this.examDetail.examNo + '/' + this.examDetail.examYear;
                        }
                    },
                    watch: {

                    },
                    mounted:function(){
                        var self = this;
                        /*setTimeout(function(){
                            controller.vaildate(); // vue 初始化結束后啓動校驗
                        },1000);*/
                    },
                    created: function() { // 初始化页面
                    }
                });
            },
            // 初始化事件
            initEvent: function() {
                var self = this;

            },
            // 初始化校驗
            vaildate: function() {
                var that = this;
                $("#serviceFailureEventAPIRequestForm").bootstrapValidator({
                    fields: {
                        dataCentreId: {
                            validators: {
                                notEmpty: {
                                    enabled : true,
                                    message: that.getI18nMessage('api.vaildate.msg.notEmpty')
                                },
                                stringLength : {
                                    min : 7,
                                    max : 15,
                                    message : that.getI18nMessage('api.vaildate.msg.errorLength',['7~15'])
                                }
                            }
                        },
                        failure: {
                            validators: {
                                notEmpty: {
                                    message: that.getI18nMessage('api.vaildate.msg.notEmpty')
                                },
                                stringLength : {
                                    min : 1,
                                    max : 4000,
                                    message : that.getI18nMessage('api.vaildate.msg.errorLength',['1~4000'])
                                }
                            }
                        },
                        servicesAffected: {
                            validators: {
                                notEmpty: {
                                    message: that.getI18nMessage('api.vaildate.msg.notEmpty')
                                },
                                stringLength : {
                                    min : 1,
                                    max : 4000,
                                    message : that.getI18nMessage('api.vaildate.msg.errorLength',['1~4000'])
                                }
                            }
                        }

                    }
                });
            },
            /**
             * 根據模組簡稱及參數（可選），格式化國際化資源消息
             * @param code 模組簡稱
             * @param args 數組參數，比如確定刪除{0}嗎？，args代表佔位符{0}
             */
            getI18nMessage: function(code, args) {
                var that = this;
                var message = that.variables.i18n[code];
                if (message) {
                    if (!args) {
                        return message;
                    }
                    return message.format(args);
                } else {
                    return code;
                }
            },
            // 操作提醒
            showResult: function showResult(result) {
                $.showResult(result);
            },
            // 返回
            doBack: function() {
                parent.$.fancybox.close();
            },
            // 關閉 fancyBox
            closeFancybox: function() {
                $.fancybox.close();
            }
        });
        controller.init();
        // 如果有子窗口調用父窗口必須加入下面這句，子窗口調用父窗口使用 parent.controller.methodName
        window.controller = controller;
    });