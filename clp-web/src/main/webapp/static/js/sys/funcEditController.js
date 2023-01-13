require([ 'jquery', 'atosBaseController','atosUtil', 'Vue', 'axios', 'axios.config', 'bootstrap', 'select2.config', 'bootstrapValidator.config' ],
    function($, atosBaseController, atosUtil, Vue, axios) {

    var controller = atosBaseController({}, {
        // 統一定義變量.
        variables : {
            vue : null
        },
        init : function() {
            var self = this;
            atosUtil.getI18nByModules('global,validation,sys', function() {
                self.initVue();
            });
        },

        initVue : function() {
            this.vue = new Vue({
                el : '#app',
                data : {
                    item: {},
                    func : {
                        funcId : vModel.funcId,
                        moduleDesc : "",
                        funcCode : "",
                        funcDesc : "",
                        funcType: "",
                        funcResource: "",
                        module : {},
                        parent: {
                            funcId: ""
                        }
                    },
                    moduleItems : [],
                    menuMap: {},
                    menuList: []
                },
                methods : {
                    doSave : function() {
                        var self = this;
                        if (!$.formValidator('#param-form')) { // 驗證
                            return false;
                        }
                        axios.post(basePath + '/sys/func/save', self.func).then(function(response) {
                            parent.controller.showResult(response);
                            parent.controller.doSearch();
                            parent.controller.closeFancybox();
                        });
                    },
                    doUpdate : function() {
                        var self = this;
                        if (!$.formValidator('#param-form')) { // 驗證
                            return false;
                        }
                        axios.put(basePath + '/sys/func/' + self.func.funcId, self.func).then(function(response) {
                            parent.controller.showResult(response);
                            parent.controller.doSearch();
                            parent.controller.closeFancybox();

                        });
                    },
                    initModuleSelect2() {
                        var self = this;
                        $("#moduleId").select2().on('change', function(e) {
                            if($(this).val() && $(this).val() != "") {
                                self.func.module = self.moduleItems.find(m => m.moduleId == $(this).val());
                            } else {
                                self.func.module.moduleId = "";
                            }
                            self.menuList = self.menuMap[self.func.module.moduleId]?.filter(m => m.funcId != self.func.funcId);
                            self.func.parent.funcId = "";
                            self.initParentIdSelect2();
                        });
                    },
                    initParentIdSelect2() {
                        var self = this;
                        $("#parentId").select2().on('change', function(e) {
                            self.func.parent.funcId = $(this).val();
                        });
                    },
                    initFuncTypeSelect2() {
                        var self = this;
                        $("#funcType").select2().on('change', function(e) {
                            self.func.funcType = $(this).val();
                            if (self.func.funcType === 'F') {
                                setTimeout(function(){
                                    self.initParentIdSelect2()
                                    $("#param-form").bootstrapValidator("destroy");
                                    self.vaildate();
                                },100);
                            } else if(self.func.funcType === 'M') {
                                $("#parentId").select2();
                                $("#parentId").select2("destroy");
                                setTimeout(function (){
                                    $("#param-form").bootstrapValidator("destroy");
                                    self.vaildate();
                                }, 100);
                            }
                        });
                    },
                    vaildate: function() {
                        $("#param-form").bootstrapValidator({
                            fields: {
                                moduleId: {
                                    validators: {
                                        notEmpty: {
                                            message: atosUtil.getI18nMessage('validation.inputRequried')
                                        },
                                        stringLength: {
                                            min: 1,
                                            max: 20,
                                            message: atosUtil.getI18nMessage('validation.stringLengthMaxium', [20])
                                        },
                                    }
                                },
                                funcType: {
                                    validators: {
                                        notEmpty: {
                                            message: atosUtil.getI18nMessage('validation.inputRequried')
                                        },
                                        stringLength: {
                                            min: 0,
                                            max: 20,
                                            message: atosUtil.getI18nMessage('validation.stringLengthMaxium', [20])
                                        },
                                    }
                                },
                                parentId: {
                                    validators: {
                                        notEmpty: {
                                            message: atosUtil.getI18nMessage('validation.inputRequried')
                                        },
                                        stringLength: {
                                            min: 0,
                                            max: 20,
                                            message: atosUtil.getI18nMessage('validation.stringLengthMaxium', [20])
                                        },
                                    }
                                },
                                funcCode: {
                                    validators: {
                                        notEmpty: {
                                            message: atosUtil.getI18nMessage('validation.inputRequried')
                                        },
                                        stringLength: {
                                            min: 0,
                                            max: 30,
                                            message: atosUtil.getI18nMessage('validation.stringLengthMaxium', [20])
                                        },
                                    }
                                },
                                funcDesc: {
                                    validators: {
                                        notEmpty: {
                                            message: atosUtil.getI18nMessage('validation.inputRequried')
                                        },
                                        stringLength: {
                                            min: 0,
                                            max: 20,
                                            message: atosUtil.getI18nMessage('validation.stringLengthMaxium', [20])
                                        },
                                    }
                                },
                                funcResource: {
                                    validators: {
                                        notEmpty: {
                                            message: atosUtil.getI18nMessage('validation.inputRequried')
                                        },

                                    }
                                }
                            }
                        });
                    }
                },
                created : function() {
                },
                mounted: function () {
                    var self = this;

                    self.initFuncTypeSelect2();

                    if (self.func.funcId) {
                        axios.get(basePath + '/sys/func/' + self.func.funcId).then(function(response) {
                            self.func = response;
                            if(!self.func.parent){
                                self.func.parent = {funcId:""};
                            }

                            setTimeout(function(){self.initFuncTypeSelect2()},100);
                        });
                    }

                    axios.post(basePath + '/sys/module/list').then(function(response) {
                        self.moduleItems = response;
                        self.initModuleSelect2();

                        axios.post(basePath + '/sys/func/menuList').then(function (response) {
                            if (!!response) {
                                response.forEach(menu => {
                                    let menuList = self.menuMap[menu.module.moduleId];
                                    if (!menuList) {
                                        menuList = []
                                        self.menuMap[menu.module.moduleId] = menuList;
                                    }
                                    menuList.push(menu);
                                });
                            }

                            if (self.func.module.moduleId) {
                                self.menuList = self.menuMap[self.func.module.moduleId]?.filter(m => m.funcId != self.func.funcId);
                            }

                            self.initParentIdSelect2();
                        });

                    });

                    self.vaildate();
                }

            });
        }

    });
    controller.init();
});
