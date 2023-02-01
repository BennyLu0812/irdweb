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
    ], function($,
        atosBaseController, atosUtil, Vue, axios) {
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
                    user : {
                        userId : vModel.userId,
                        cnName : "",
                        ptNme : "",
                        status : "",
                        createDate : "",
                        roleIds : [],
                        userType : "L"
                    },
                    statusUrl: basePath + '/sys/user/status',
                    statusOptions: [],
                    typeUrl: basePath + '/sys/user/type',
                    typeOptions: [],
                    roleList: []
                },
                methods : {
                    doSave : function() {
                        var self = this;
                        if (!$.formValidator('#param-form')) { // 驗證
                            return false;
                        }
                        axios.post(basePath + '/sys/user', self.user).then(function(response) {
                            parent.controller.showResult(response);
                            parent.controller.doSearch();
                            parent.controller.closeFancybox();
                        });
                    },
                    doUpdate : function() {
                        var self = this;
                        axios.put(basePath + '/sys/user/' + self.user.userId, self.user).then(function(response) {
                            console.log(self.user);
                            parent.controller.showResult(response);
                            parent.controller.doSearch();
                            parent.controller.closeFancybox();

                        });
                    }
                },
                created : function() {
                    var self = this;
                    var userId = self.user.userId;
                    if (userId != 'undefined' && userId != null && userId != '') {
                    	axios.post(basePath + '/sys/user/getById/',self.user).then(function(response) {
                            self.user = response;
                            var roles = response.roles;
                            var temp = new Array();
                            for(var i=0;i<roles.length;i++){
                                temp.push(roles[i].roleId);
                            }
                            self.user.roleIds = temp;
                        });
                    }

                    axios.get(basePath + '/sys/user/listRole').then(function(response) {
                        self.roleList = response;
                        $("#status").select2().on('change', function(e) {
                            self.user.status = $(this).val();
                        });
                    });

                }

            });
        } ,          // 初始化校驗
        vaildate: function() {
            var that = this;
            $("#param-form").bootstrapValidator({
                fields: {
                    userId: {
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
                    userPname: {
                        validators: {
                            stringLength: {
                                min: 0,
                                max: 20,
                                message: atosUtil.getI18nMessage('validation.stringLengthMaxium', [20])
                            },
                        }
                    },
                    userCname: {
                        validators: {
                            stringLength: {
                                min: 0,
                                max: 20,
                                message: atosUtil.getI18nMessage('validation.stringLengthMaxium', [20])
                            },
                        }
                    }
                    /*,
                    userType: {
                        validators: {
                            notEmpty: {
                                message: atosUtil.getI18nMessage('validation.inputRequried')
                            },
                        }
                    }*/
                }
            });
        },

    });
    controller.init();
});
