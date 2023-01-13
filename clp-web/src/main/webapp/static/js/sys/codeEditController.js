require([ 'jquery', 'atosBaseController', 'Vue', 'axios', 'axios.config', 'bootstrap', 'select2.config',
        'bootstrapValidator.config' ], function($, atosBaseController, Vue, axios) {

    var controller = atosBaseController({}, {
        // 統一定義變量.
        variables : {
            vue : null
        },
        init : function() {
            this.initVue();
            this.checkout();
            $(".content-header label").append(" : ( " + vModel.codeType + " ) - " + vModel.codePname + " - "
                    + vModel.codeCname);
        },

        initVue : function() {
            this.vue = new Vue({
                // debugger;
                el : '#app',
                data : {
                    code : {
                        codeId : vModel.codeId,
                        codeType : vModel.codeType,
                        codekey : "",
                        codeStatus : "",
                        codeCname : "",
                        codePname : "",
                        codePrintCname : "",
                        codePrintPname : ""
                    }
                },
                methods : {
                    doSave : function() {
                        var self = this;
                        // 表單校驗
                        if (!$.formValidator('#param-form')) {
                            return false;
                        }
                        axios.post(basePath + '/sys/code/', self.code).then(function(response) {
                            parent.controller.showResult(response);
                            parent.controller.doSearch();
                            parent.controller.closeFancybox();
                        });
                    },
                    doUpdate : function() {
                        var self = this;
                        // 表單校驗
                        if (!$.formValidator('#param-form')) {
                            return false;
                        }
                        axios.put(basePath + '/sys/code/' + self.code.codeId, self.code).then(function(response) {
                            parent.controller.showResult(response);
                            parent.controller.doSearch();
                            parent.controller.closeFancybox();

                        });
                    },
                    doClose : function() {
                        parent.controller.closeFancybox();
                    }
                },
                created : function() {
                    var self = this;
                    if (self.code.codeId) {
                        axios.get(basePath + '/sys/code/' + self.code.codeId).then(function(response) {
                            self.code = response;
                        });
                    }
                }

            });
        },

        checkout : function() {
            $('#param-form').bootstrapValidator(
                    {
                        feedbackIcons : {
                            valid : 'glyphicon glyphicon-ok',
                            invalid : 'glyphicon glyphicon-remove',
                            validating : 'glyphicon glyphicon-refresh'
                        },
                        fields : {
                            codeKey : {
                                validators : {
                                    notEmpty : {
                                        message : '此欄不能為空'
                                    }
                                }
                            },
                            codePname : {
                                validators : {
                                    callback : {
                                        callback : function(value, validator) {
                                            var codeCname = $("#codeCname").val();
                                            var codePname = $("#codePname").val();
                                            if ((codeCname == null || codeCname == "")
                                                    && (codePname == null || codePname == "")) {
                                                validator.updateStatus('codeCname', 'NOT_VALIDATED');
                                                return false;
                                            }
                                            validator.updateStatus('codeCname', 'VALID');
                                            return true;
                                        },
                                        message : '中文和葡文描述必填其一'
                                    }
                                }
                            },
                            codeCname : {
                                validators : {
                                    callback : {
                                        callback : function(value, validator) {
                                            var codeCname = $("#codeCname").val();
                                            var codePname = $("#codePname").val();
                                            if ((codeCname == null || codeCname == "")
                                                    && (codePname == null || codePname == "")) {
                                                validator.updateStatus('codePname', 'NOT_VALIDATED');
                                                return false;
                                            }
                                            validator.updateStatus('codePname', 'VALID');
                                            return true;
                                        },
                                        message : '中文和葡文描述必填其一'
                                    }
                                }
                            }
                        }
                    });
        }
    });
    controller.init();
});
