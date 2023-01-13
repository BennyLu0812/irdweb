

require([
        'jquery',
        'atosBaseController',
        'atosUtil',
        'Vue',
        'moment.config',
        'axios',
        'axios.config',
        'jquery.config',
        'vueSelect2',
        'select2',
        'select2.config',
        'datatables',
        'datatables.config',
        'fancybox',
        'fancybox.config',
        'Noty',
        'noty.config',
        'datetimepicker.config',
        'bootstrapValidator.config'
    ],
    function($, atosBaseController, atosUtil, Vue, momentConfig, axios) {
        'use strict';
        atosUtil.getI18nByModules('global, sys, que');

        var controller = atosBaseController(momentConfig, {
            //統一定義變量.
            variables : {
                datatable : null,
            },
            init : function() {
                this.initVue();
                this.initDatetimepicker();
                this.initDatatables();
                this.initVaildate();
            },
            initVue: function() {
                var self = this;
                this.vue = new Vue({
                    el: '#app',
                    data: {
                        centerOption: [],
                        centerUrl: basePath + '/ctr/center/select2/centerList',
                    },
                    methods: {
                        reset: function() {
                            $("#centerCode").val("").trigger("change");
                            $("#startDate").val("").trigger("change");
                            $("#endDate").val("").trigger("change");
                        },
                        searchFunc: function () {
                            if (!$.formValidator('#fm-search')) { // 驗證
                                return false;
                            }
                            controller.doSearch();
                        },
                        exportData: function() {
                            if (!$.formValidator('#fm-search')) { // 驗證
                                return false;
                            }
                            controller.doDerive();
                        }
                    }
                });
            },
            initDatatables :function(){
                this.variables.datatable = $('#table').DataTable({
                    // scrollX: true,
                    serverSide : true,
                    processing : true,
                    deferLoading: 0,
                    ajax : {
                        url : basePath + "/rpt/export/getPdaLoginLogoutLogPage",
                        type : "POST",
                        contentType : "application/json; charset=utf-8",
                        data : function(data, settings) {
                            var formData = $('#fm-search').serializeObject();
                            return JSON.stringify($.extend({}, data, formData));
                        },
                        dataType : "json"
                    },
                    columns : [{
                        "data" : "userId"
                    },{
                        "data" : "workStatus"
                    }, {
                        "data" : "createDate"
                    }, {
                        "data" : "centerCodeCn"
                    }, {
                        "data" : "workTimeType"
                    }
                    ]
                });
            },

            doSearch: function () {
                this.variables.datatable.ajax.reload();
            },
            initDatetimepicker: function () {
                var self = this;
                $('#startDate').datetimepicker({
                    minView: "month", // 设置只显示到月份
                    defaultDate: new Date(),
                    format: "dd/mm/yyyy", // 日期格式
                    autoclose: true, // 选中关闭
                    todayBtn: true, // 今日按钮
                    clearBtn: true, // 清除按钮
                    todayHighlight: 1,
                    startView: 2,
                    forceParse: 0
                }).on('changeDate', function (ev) {
                    var starttime = $("#startDate").val();
                    $("#endDate").datetimepicker('setStartDate', starttime);
                    $("#startDate").datetimepicker('hide');
                });
                $('#startDate').datetimepicker("setDate",new Date());

                $('#endDate').datetimepicker({
                    minView: "month", // 设置只显示到月份
                    defaultDate: new Date(),
                    format: "dd/mm/yyyy", // 日期格式
                    autoclose: true, // 选中关闭
                    todayBtn: true, // 今日按钮
                    clearBtn: true, // 清除按钮
                    todayHighlight: 1,
                    startView: 2,
                    forceParse: 0
                }).on('changeDate', function (ev) {
                    var endtime = $("#endDate").val();
                    $("#startDate").datetimepicker('setEndDate', endtime);
                    $("#endDate").datetimepicker('hide');
                });
                $('#endDate').datetimepicker("setDate",new Date());
            },
            initVaildate: function() {
                $("#fm-search").bootstrapValidator({
                    fields: {
                        centerCode: {
                            validators: {
                                notEmpty: {
                                    message: " "
                                }
                            }
                        },
                        startDate: {
                            trigger: 'change',
                            validators: {
                                notEmpty: {
                                    message: " "
                                }
                            }
                        },
                        endDate: {
                            trigger: 'change',
                            validators: {
                                notEmpty: {
                                    message: " "
                                }
                            }
                        }
                    }
                });
            },
            //導出
            doDerive: function () {
                var dto = JSON.stringify($('#fm-search').serializeObject());
                atosUtil.showLoading();
                axios({
                    method: 'post',
                    url: basePath + "/rpt/export/exportPdaLoginLogoutLog",
                    data: dto,
                    loading: true,
                    responseType: 'blob'
                }).then(function (response) {
                    atosUtil.downloadPDF(response, 'pda_login_logout_log.xlsx');
                    atosUtil.hideLoading();
                }).catch(function (response) {
                    console.log(response);
                    atosUtil.hideLoading();
                })
            },
            //關閉fancybox
            closeFancybox : function fancyboxClose(){
                $.fancybox.close();
            },
            //操作提醒
            showResult:function showResult(result){
                $.showResult(result);
            }
        });
        controller.init();
        window.controller = controller;
    });

