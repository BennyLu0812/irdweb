/**
 * jobCtrlController.js
 */
require(['jquery','atosBaseController', 'Vue', 'axios', 'atosUtil', 'axios.config', 'bootstrapValidator.config'],
    function ($,atosBaseController, Vue, axios,atosUtil) {

        'use strict'; // 使用JS嚴格模式.

        var controller = atosBaseController({}, {
            init: function () {
                var self = this;
                atosUtil.getI18nByModules('global,validation', function() {
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
                        }
                    }
                });
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
                            isSync: "",
                            jobType: "",
                            dataDir: "",
                            dataDays: "",
                            enabled: ""

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