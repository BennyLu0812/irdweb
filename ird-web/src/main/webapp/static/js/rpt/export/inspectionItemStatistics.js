

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
                    scrollX: true,
                    serverSide : true,
                    processing : true,
                    deferLoading: 0,
                    ajax : {
                        url : basePath + "/rpt/export/getInspectionItemStatisticsPage",
                        type : "POST",
                        contentType : "application/json; charset=utf-8",
                        data : function(data, settings) {
                            var formData = $('#fm-search').serializeObject();
                            return JSON.stringify($.extend({}, data, formData));
                        },
                        dataType : "json"
                    },
                    columns : [{
                        "data" : "centerNameCn",
                        "width": "100px"
                    },{
                        "data" : "inspectionTime",
                        "width": "100px"
                    }, {
                        "data" : "inspectionCount",
                        "width": "100px"
                    }, {
                        "data" : "inspectionPassCount",
                        "width": "100px"
                    }, {
                        "data" : "inspectionNoPassCount",
                        "width": "120px"
                    },{
                        "data" : "inspectionPassRate",
                        "width": "150px",
                        "render": function(data, type, row, meta) {
                            return (data * 100).toFixed(2) + "%";
                        }
                    },{
                        "data" : "inspectionNoPassRate",
                        "width": "150px",
                        "render": function(data, type, row, meta) {
                            return (data * 100).toFixed(2) + "%";
                        }
                    },{
                        "data" : "aaCount",
                        "width": "200px"
                    },{
                        "data" : "aaPassCount",
                        "width": "200px"
                    },{
                        "data" : "aaNoPassCount",
                        "width": "200px"
                    }, {
                        "data" : "aaPassRate",
                        "width": "200px",
                        "render": function(data, type, row, meta) {
                            return (data * 100).toFixed(2) + "%";
                        }
                    },{
                        "data" : "aaNoPassRate",
                        "width": "200px",
                        "render": function(data, type, row, meta) {
                            return (data * 100).toFixed(2) + "%";
                        }
                    },{
                        "data" : "bbCount",
                        "width": "250px"
                    },{
                        "data" : "bbPassCount",
                        "width": "250px"
                    },{
                        "data" : "bbNoPassCount",
                        "width": "250px"
                    },{
                        "data" : "bbPassRate",
                        "width": "250px",
                        "render": function(data, type, row, meta) {
                            return (data * 100).toFixed(2) + "%";
                        }
                    },{
                        "data" : "bbNoPassRate",
                        "width": "250px",
                        "render": function(data, type, row, meta) {
                            return (data * 100).toFixed(2) + "%";
                        }
                    },{
                        "data" : "ccCount",
                        "width": "200px"
                    },{
                        "data" : "ccPassCount",
                        "width": "200px"
                    },{
                        "data" : "ccNoPassCount",
                        "width": "200px"
                    },{
                        "data" : "ccPassRate",
                        "width": "200px",
                        "render": function(data, type, row, meta) {
                            return (data * 100).toFixed(2) + "%";
                        }
                    },{
                        "data" : "ccNoPassRate",
                        "width": "200px",
                        "render": function(data, type, row, meta) {
                            return (data * 100).toFixed(2) + "%";
                        }
                    },{
                        "data" : "ddCount",
                        "width": "200px"
                    },{
                        "data" : "ddPassCount",
                        "width": "200px"
                    },{
                        "data" : "ddNoPassCount",
                        "width": "200px"
                    },{
                        "data" : "ddPassRate",
                        "width": "200px",
                        "render": function(data, type, row, meta) {
                            return (data * 100).toFixed(2) + "%";
                        }
                    },{
                        "data" : "ddNoPassRate",
                        "width": "200px",
                        "render": function(data, type, row, meta) {
                            return (data * 100).toFixed(2) + "%";
                        }
                    },{
                        "data" : "eeCount",
                        "width": "300px"
                    },{
                        "data" : "eePassCount",
                        "width": "300px"
                    },{
                        "data" : "eeNoPassCount",
                        "width": "300px"
                    },{
                        "data" : "eePassRate",
                        "width": "300px",
                        "render": function(data, type, row, meta) {
                            return (data * 100).toFixed(2) + "%";
                        }
                    },{
                        "data" : "eeNoPassRate",
                        "width": "300px",
                        "render": function(data, type, row, meta) {
                            return (data * 100).toFixed(2) + "%";
                        }
                    },{
                        "data" : "ffCount",
                        "width": "300px"
                    },{
                        "data" : "ffPassCount",
                        "width": "300px"
                    },{
                        "data" : "ffNoPassCount",
                        "width": "300px"
                    },{
                        "data" : "ffPassRate",
                        "width": "300px",
                        "render": function(data, type, row, meta) {
                            return (data * 100).toFixed(2) + "%";
                        }
                    },{
                        "data" : "ffNoPassRate",
                        "width": "300px",
                        "render": function(data, type, row, meta) {
                            return (data * 100).toFixed(2) + "%";
                        }
                    },{
                        "data" : "ggCount",
                        "width": "150px"
                    },{
                        "data" : "ggPassCount",
                        "width": "150px"
                    },{
                        "data" : "ggNoPassCount",
                        "width": "150px"
                    },{
                        "data" : "ggPassRate",
                        "width": "150px",
                        "render": function(data, type, row, meta) {
                            return (data * 100).toFixed(2) + "%";
                        }
                    },{
                        "data" : "ggNoPassRate",
                        "width": "150px",
                        "render": function(data, type, row, meta) {
                            return (data * 100).toFixed(2) + "%";
                        }
                    },{
                        "data" : "hhCount",
                        "width": "200px"
                    },{
                        "data" : "hhPassCount",
                        "width": "200px"
                    },{
                        "data" : "hhNoPassCount",
                        "width": "200px"
                    },{
                        "data" : "hhPassRate",
                        "width": "200px",
                        "render": function(data, type, row, meta) {
                            return (data * 100).toFixed(2) + "%";
                        }
                    },{
                        "data" : "hhNoPassRate",
                        "width": "200px",
                        "render": function(data, type, row, meta) {
                            return (data * 100).toFixed(2) + "%";
                        }
                    },{
                        "data" : "iiCount",
                        "width": "200px"
                    },{
                        "data" : "iiPassCount",
                        "width": "200px"
                    },{
                        "data" : "iiNoPassCount",
                        "width": "200px"
                    },{
                        "data" : "iiPassRate",
                        "width": "200px",
                        "render": function(data, type, row, meta) {
                            return (data * 100).toFixed(2) + "%";
                        }
                    },{
                        "data" : "iiNoPassRate",
                        "width": "200px",
                        "render": function(data, type, row, meta) {
                            return (data * 100).toFixed(2) + "%";
                        }
                    },{
                        "data" : "jjCount",
                        "width": "200px"
                    },{
                        "data" : "jjPassCount",
                        "width": "200px"
                    },{
                        "data" : "jjNoPassCount",
                        "width": "200px"
                    },{
                        "data" : "jjPassRate",
                        "width": "200px",
                        "render": function(data, type, row, meta) {
                            return (data * 100).toFixed(2) + "%";
                        }
                    },{
                        "data" : "jjNoPassRate",
                        "width": "200px",
                        "render": function(data, type, row, meta) {
                            return (data * 100).toFixed(2) + "%";
                        }
                    },{
                        "data" : "kkCount",
                        "width": "200px"
                    },{
                        "data" : "kkPassCount",
                        "width": "200px"
                    },{
                        "data" : "kkNoPassCount",
                        "width": "200px"
                    },{
                        "data" : "kkPassRate",
                        "width": "200px",
                        "render": function(data, type, row, meta) {
                            return (data * 100).toFixed(2) + "%";
                        }
                    },{
                        "data" : "kkNoPassRate",
                        "width": "200px",
                        "render": function(data, type, row, meta) {
                            return (data * 100).toFixed(2) + "%";
                        }
                    },{
                        "data" : "llCount",
                        "width": "150px"
                    },{
                        "data" : "llPassCount",
                        "width": "150px"
                    },{
                        "data" : "llNoPassCount",
                        "width": "150px"
                    },{
                        "data" : "llPassRate",
                        "width": "150px",
                        "render": function(data, type, row, meta) {
                            return (data * 100).toFixed(2) + "%";
                        }
                    },{
                        "data" : "llNoPassRate",
                        "width": "150px",
                        "render": function(data, type, row, meta) {
                            return (data * 100).toFixed(2) + "%";
                        }
                    },{
                        "data" : "mmCount",
                        "width": "150px"
                    },{
                        "data" : "mmPassCount",
                        "width": "150px"
                    },{
                        "data" : "mmNoPassCount",
                        "width": "150px"
                    },{
                        "data" : "mmPassRate",
                        "width": "150px",
                        "render": function(data, type, row, meta) {
                            return (data * 100).toFixed(2) + "%";
                        }
                    },{
                        "data" : "mmNoPassRate",
                        "width": "150px",
                        "render": function(data, type, row, meta) {
                            return (data * 100).toFixed(2) + "%";
                        }
                    },{
                        "data" : "ppCount",
                        "width": "150px"
                    },{
                        "data" : "ppPassCount",
                        "width": "150px"
                    },{
                        "data" : "ppNoPassCount",
                        "width": "150px"
                    },{
                        "data" : "ppPassRate",
                        "width": "150px",
                        "render": function(data, type, row, meta) {
                            return (data * 100).toFixed(2) + "%";
                        }
                    },{
                        "data" : "ppNoPassRate",
                        "width": "150px",
                        "render": function(data, type, row, meta) {
                            return (data * 100).toFixed(2) + "%";
                        }
                    },{
                        "data" : "mechanicalInspectionCount",
                        "width": "150px"
                    },{
                        "data" : "mechanicalInspectionPassCount",
                        "width": "150px"
                    },{
                        "data" : "mechanicalInspectionNoPassCount",
                        "width": "150px"
                    },{
                        "data" : "mechanicalInspectionPassRate",
                        "width": "150px",
                        "render": function(data, type, row, meta) {
                            return (data * 100).toFixed(2) + "%";
                        }
                    },{
                        "data" : "mechanicalInspectionNoPassRate",
                        "width": "150px",
                        "render": function(data, type, row, meta) {
                            return (data * 100).toFixed(2) + "%";
                        }
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
                    url: basePath + "/rpt/export/exportInspectionItemStatistics",
                    data: dto,
                    loading: true,
                    responseType: 'blob'
                }).then(function (response) {
                    atosUtil.downloadPDF(response, 'inspection_item_statistics.xlsx');
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

