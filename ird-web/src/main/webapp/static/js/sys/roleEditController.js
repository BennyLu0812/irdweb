require([ 
    'jquery',
    'atosBaseController',
    'atosUtil',
    'Vue',
    'axios',
    'axios.config',
    'bootstrap',
    'vueSelect2',
    'select2',
    'select2.config',
    'bootstrapValidator.config'
 ], function($, atosBaseController, atosUtil, Vue, axios) {
    'use strict';

    var controller = atosBaseController({}, {
        // 統一定義變量.
        variables : {
            vue : null
        },
        init : function() {
            var self = this;
            atosUtil.getI18nByModules('global,validation,sys', function() {
                self.initVue();
                self.vaildate();
            });
        },
        initVue : function() {
            this.vue = new Vue({
                el : '#app',
                data : {
                    role : {
                        roleId : vModel.roleId,
                        role : "",
                        status : "",
                        roleDesc : "",
                        funcIds:[]
                    },
                    statusUrl: basePath + '/sys/role/status',
                    statusOptions: [],
                    checkAll:[],
                    funcMenus : {}
                },
                methods : {
                    doSave : function() {
                        var self = this;
                        if (!$.formValidator('#role-form')) { // 驗證
                            return false;
                        }
                        axios.post(basePath + '/sys/role', self.role).then(function(response) {
                            parent.controller.showResult(response);
                            parent.controller.doSearch();
                            parent.controller.closeFancybox();
                        });
                    },
                    doUpdate : function() {
                        var self = this;
                        axios.put(basePath + '/sys/role/' + self.role.roleId, self.role).then(function(response) {
                            parent.controller.showResult(response);
                            parent.controller.doSearch();
                            parent.controller.closeFancybox();

                        });
                    },
                    setAllChecked : function(e, menu) {
                        var self = this;
                        var isCheck = e.target.checked;

                        let menuIndex = self.role.funcIds.findIndex(f => f === menu.funcId);
                        if (menuIndex === -1 && isCheck) {
                            self.role.funcIds.push(menu.funcId)
                        } else if(menuIndex !== -1 && !isCheck) {
                            self.role.funcIds.splice(menuIndex, 1)
                        }

                        menu.funcList.forEach(func => {
                            let funcIndex = self.role.funcIds.findIndex(f => f === func.funcId);
                            if (funcIndex === -1 && isCheck) {
                                self.role.funcIds.push(func.funcId)
                            } else if(funcIndex !== -1 && !isCheck) {
                                self.role.funcIds.splice(funcIndex, 1)
                            }
                            let el = document.getElementById("func"+func.funcId);
                            el.checked = isCheck;
                        });

                    },
                    funcChecked: function (e, menu) {
                        var self = this;
                        var isCheck = e.target.checked;

                        let el = document.getElementById("menu"+menu.funcId);
                        if (isCheck) {
                            if (!el.checked) {
                                self.role.funcIds.push(menu.funcId)
                                el.checked = true;
                            }
                        } else {
                            if(menu.funcList.every(func => self.role.funcIds.findIndex(f => f === func.funcId) === -1)) {
                                if (el.checked) {
                                    self.role.funcIds.splice(self.role.funcIds.findIndex(f => f === menu.funcId), 1)
                                    el.checked = false;
                                }
                            }
                        }

                    },
                    getArrayIndexOf : function(arr, val) {
                        for (var i = 0; i < arr.length; i++) {
                            if (arr[i] == val)
                                return i;
                        }
                        return -1;
                    },
                    removeArrayEle : function(arr, val) {
                        var index = this.getArrayIndexOf(arr,val);
                        if (index > -1) {
                            arr.splice(index, 1);
                        }
                        return arr;
                    },
                    addArrayEle : function(arr, val) {
                        var index = this.getArrayIndexOf(arr,val);
                        if (index == -1) {
                            arr.push(val);
                        }
                        return arr;
                    }
                },
                created : function() {
                    var self = this;
                    if (self.role.roleId) {
                        axios.get(basePath + '/sys/role/' + self.role.roleId).then(function(response) {
                            self.role = response;
                            var temp = new Array();
                            if (response.funcs != null) {
                                for (var i = 0; i < response.funcs.length; i++) {
                                    temp.push(response.funcs[i].funcId);
                                }
                                self.role.funcIds = temp;
                            }
                        });

                        axios.get(basePath + '/sys/role/listFunc/' + self.role.roleId).then(function(response) {
                            self.funcMenus = response;
                            var temp = new Array();
                            // for (var i in self.funcMenus) {
                            //     var list = self.funcMenus[i];
                            //     var isCheck = true;
                            //     for (var k = 0; k < list.length; k++) {
                            //         var func = list[k];
                            //         if (!func.checked) {
                            //             isCheck = false;
                            //         }
                            //     }
                            //     if (isCheck) {
                            //         temp.push(i);
                            //     }
                            // }
                            // self.role.checkAll = temp;
                            $("#status").select2().on('change', function(e) {
                                self.role.status = $(this).val();
                            });
                        });

                    }else{
                        axios.get(basePath + '/sys/role/listFunc').then(function(response) {
                            self.funcMenus = response;
                            self.role.checkAll=[];
                            $("#status").select2().on('change', function(e) {
                                self.role.status = $(this).val();
                            });
                        });
                        
                    }

                }

            });
        },
        vaildate: function() {
            var that = this;
            $("#role-form").bootstrapValidator({
                fields: {
                    role: {
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
                    roleDesc: {
                        validators: {
                            stringLength: {
                                min: 0,
                                max: 50,
                                message: atosUtil.getI18nMessage('validation.stringLengthMaxium', [50])
                            },
                        }
                    }
                }
            });
        }
    });
    controller.init();
});
