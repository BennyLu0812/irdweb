/**
 * jobCtrlController.js
 */
require(['jquery','atosBaseController', 'Vue', 'axios', 'atosUtil', 'axios.config', 'bootstrapValidator.config'],
    function ($,atosBaseController, Vue, axios,atosUtil) {

        'use strict'; // 使用JS嚴格模式.

        var controller = atosBaseController({}, {
            // 統一定義變量.
            variables: {
                datatable: null,
                i18n: {}
            },
            init: function () {
                var self = this;
                atosUtil.getI18nByModules('global,validation, api', function(result) {
                    self.variables.i18n = result;
                    self.initVue();
                    // self.vaildate();
                });

            },
            vaildate: function() {
                var that = this;
                $("#fm-jobctrl").bootstrapValidator({
                    fields: {
                        sysCode: {
                            validators: {
                                notEmpty : {
                                    message : atosUtil.getI18nMessage('validation.inputRequried')
                                },
                                stringLength: {
                                    min: 1,
                                    max: 20,
                                    message: atosUtil.getI18nMessage('validation.stringLengthMaxium', [20])
                                },
                            }
                        },
                        jobCode: {
                            validators: {
                                notEmpty : {
                                    message : atosUtil.getI18nMessage('validation.inputRequried')
                                },
                                stringLength: {
                                    min: 1,
                                    max: 30,
                                    message: atosUtil.getI18nMessage('validation.stringLengthMaxium', [30])
                                },
                                regexp: {
                                    regexp: /^[a-zA-Z0-9_\.]+$/,
                                    message: atosUtil.getI18nMessage('validation.invalidNaming')
                                }
                            }
                        },
                        dataCentreId: {
                            validators: {
                                stringLength : {
                                    min : 7,
                                    max : 15,
                                    message : that.getI18nMessage('api.vaildate.msg.errorLength',['7~15'])
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
            initVue: function () {
                new Vue({
                    el: '#app',
                    data: {
                        schCtrl: {
                            id: vModel.id,
                            sysCode: "",
                            jobUse: "",
                            jobCode: "",
                            cronChar: "",
                            clsName: "",
                            isSync: "true",
                            jobType: "JAVA",
                            dataDir: "",
                            dataDays: "",
                            enabled: "",
                            dataCentreId:""

                        }
                    },
                    methods: {
                        doSave: function () {
                            var self = this;
                            if (!$.formValidator('#fm-jobctrl')) { // 驗證
                                return false;
                            }
                            axios.post(basePath + '/sch/ctrl', self.schCtrl).then(function (response) {
                                parent.controller.showResult(response);
                                parent.controller.doSearch();
                                parent.controller.closeFancybox();
                            });

                        },
                        doUpdate: function () {
                            var self = this;
                            if (!$.formValidator('#fm-jobctrl')) { // 驗證
                                return false;
                            }
                            axios.put(basePath + '/sch/ctrl/' + self.schCtrl.id, self.schCtrl).then(function (response) {
                                parent.controller.showResult(response);
                                parent.controller.doSearch();
                                parent.controller.closeFancybox();
                            });
                        }
                    },
                    created: function () {
                        var self = this;
                        if (self.schCtrl.id)
                            axios.get(basePath + '/sch/ctrl/' + self.schCtrl.id).then(function (response) {
                                self.schCtrl = response;
                            });
                        setTimeout(function() {
                            controller.vaildate(); // vue 初始化結束后啓動校驗
                        }, 1000);
                    }

                });
            }
        });

        controller.init();
    });