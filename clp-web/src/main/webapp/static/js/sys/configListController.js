/**
 * sp管理.
 *
 * @param $
 * @param atosBaseController
 * @param momentConfig
 * @param axios
 * @returns
 */
require([
        'jquery',
        'atosBaseController',
        'Vue',
        'moment.config',
        'atosUtil',
        'axios',
        'jquery.config',
        'axios.config',
        'tinyImgUpload',
        'datatables.config',
        'fancybox.config',
        'bootstrapValidator.config',
        'datetimepicker.config'
    ],
    function ($, atosBaseController, Vue, momentConfig, atosUtil, axios, tinyImgUpload) {

        'use strict'; // 使用JS嚴格模式.
        var controller = atosBaseController(momentConfig, {
            // 統一定義變量.
            variables: {
                datatable: null,
                vue: null
            },
            params: {},
            init: function () {
                var self = this;
                atosUtil.getI18nByModules('global,validation,sys', function () {
                    self.initVue();
                    self.initEvent();
                    self.initDatatables();
                  /*  self.initDatetimepicker();
                    self.vaildate();
                    self.reloadPage();*/
                });
            },
            reloadPage : function(){
                $("#examListTable").DataTable();
            },

            initDatatables: function () {
                var that = this;
                this.variables.datatable = $('#configListTable').DataTable({
                    processing: true,
                    searching: true,
                    serverSide: true,
                    paging: false,
                    info: true,
                    select: {
                        style: 'single',
                        selector: 'td'
                    },
                    ajax: {
                        url:basePath + "/sys/service/getConfigList",
                        type: "GET",
                        dataType: "json"
                    },
                    columns: [{
                        "data": "profileName",
                        "width": "30%"
                    }, {
                        "data": "",
                        "width": "80%"
                    }],
                    columnDefs: [
                        {
                            render: function (data, type, row) {
                                var html = '<strong>'+row.profileName+'</strong>';

                                return html;
                            },
                            targets: 0
                        },
                        {
                            render: function (data, type, row) {
                                var html = '';
                                $.map(row.map,function (v,k) {
                                    html +='<div class="cursor_pointer" style="border-bottom: 1px solid #ddd; padding: 5px; margin: -1px;"><strong>'+k+":</strong><span class='text " +
                                        "green-highlight'>"+v+"</span></div>";
                                })
                                return html;
                            },
                            targets: 1
                        }]
                });
            },
            initDatetimepicker: function () {
                var self = this;
                $('#sysOperationTimeStart').datetimepicker({
                    minView: "day", // 设置只显示到月份
                    defaultDate: new Date(),
                    format: "dd/mm/yyyy hh:ii:ss", // 日期格式
                    autoclose: true, // 选中关闭
                    todayBtn: true, // 今日按钮
                    clearBtn: true, // 清除按钮
                    todayHighlight: 1,
                    startView: 2,
                    forceParse: 0
                }).on('changeDate', function (ev) {
                    var starttime = $("#sysOperationTimeStart").val();
                    $("#sysOperationTimeEnd").datetimepicker('setStartDate', starttime);
                    $("#sysOperationTimeStart").datetimepicker('hide');
                });

                $('#sysOperationTimeEnd').datetimepicker({
                    minView: "day", // 设置只显示到月份
                    defaultDate: new Date(),
                    format: "dd/mm/yyyy hh:ii:ss", // 日期格式
                    autoclose: true, // 选中关闭
                    todayBtn: true, // 今日按钮
                    clearBtn: true, // 清除按钮
                    todayHighlight: 1,
                    startView: 2,
                    forceParse: 0
                }).on('changeDate', function (ev) {
                    var endtime = $("#sysOperationTimeEnd").val();
                    $("#sysOperationTimeStart").datetimepicker('setEndDate', endtime);
                    $("#sysOperationTimeEnd").datetimepicker('hide');
                });
            },

            initVue: function () {
                var ctrlSelf = this;
                this.variables.vue = new Vue({
                    el: '#app',
                    data: {
                        func: {
                            funcId: '',
                            sysOperationTimeDesc: '',
                            userId: ''
                        },
                        funcIdOptions: [],
                        userIdOptions: [],
                        licTypeOptions: [],
                        funcIdUrl: basePath + "/sys/func/getFuncQuotaSelectPage",
                        userIdUrl: basePath + "/sys/user/getUserNameQuotaSelectPage"
                    },
                    mounted: function() {
                        console.log('mounted');
                        var start = new Date();//獲取當前時間的
                        var fromDate = new Date(start.setHours(0,0,0) + 3600 * 24  * 1000);
                        $("#sysOperationTimeEnd").val(fromDate.format('dd/MM/yyyy hh:mm:ss'));
                        $("#sysOperationTimeStart").val(start.format('dd/MM/yyyy hh:mm:ss'));
                    },
                    created: function() {
                        console.log('created');
                    }
                });
            },

            //校驗
            vaildate: function () {
                var that = this;
                $("#queryForm").bootstrapValidator({
                    fields: {
                        sysOperationTimeStart: {
                            trigger: 'change',
                            validators: {
                                notEmpty : {
                                        message : atosUtil.getI18nMessage('validation.inputRequried')
                                },
                                regexp: {
                                    regexp:/^(((0[1-9]|1[0-9]|2[0-8])([/])(0[1-9]|1[0-2])|(29|30)([/])(0[13-9]|1[0-2])|31([/])(0[13578]|1[02]))([/])(?!0000)[0-9]{4}|29([/])02([/])(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)) (?:(?:[0-2][0-3])|(?:[0-1][0-9])):[0-5][0-9]:[0-5][0-9]$/,
                                    message: atosUtil.getI18nMessage('validation.invalidDateFormat')
                                },

                            }
                        },
                        sysOperationTimeEnd: {
                            trigger: 'change',
                            validators: {
                                notEmpty : {
                                        message : atosUtil.getI18nMessage('validation.inputRequried')
                                },
                                regexp: {
                                    regexp: /^(((0[1-9]|1[0-9]|2[0-8])([/])(0[1-9]|1[0-2])|(29|30)([/])(0[13-9]|1[0-2])|31([/])(0[13578]|1[02]))([/])(?!0000)[0-9]{4}|29([/])02([/])(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)) (?:(?:[0-2][0-3])|(?:[0-1][0-9])):[0-5][0-9]:[0-5][0-9]$/,
                                    message: atosUtil.getI18nMessage('validation.invalidDateFormat')
                                },

                            }
                        },
                        docId: {
                            validators: {
                                regexp: {
                                    regexp: /^[0-9]*$/,
                                    message: atosUtil.getI18nMessage('validation.invaliNumber')
                                },
                            }
                        },
                        examYear: {
                            validators: {
                                regexp: {
                                    regexp: /^([1-9]{1})\d{3}$/,
                                    message: atosUtil.getI18nMessage('validation.invaliYearFormat')
                                },
                            }
                        }
                    }
                });
            },

            // 初始化綁定事件
            initEvent: function () {
                var slef = this;
                // 查詢按鈕綁定事件
                $("#examListSearch").click(function () {
                    slef.doSearch();
                });
                // 重置
                $("#examListRefresh").click(function () {
                    slef.doReset();
                });
                //導出
                $("#examListDerive").click(function () {
                    slef.doDerive();
                });

            },
            doReset: function () {
                $("#queryForm").find(":input").val("");
                $("#funcId").val("").trigger("change");
                $("#userId").val("").trigger("change");
                $("#licType").val("").trigger("change");
            },
            // 查詢
            doSearch: function () {
                if (!$.formValidator('#queryForm')) {
                    return false;
                }

                if (!this.variables.datatable) {
                    $("#examListTable").DataTable().destroy();
                    this.initDatatables();
                } else {
                    this.variables.datatable.ajax.reload();
                }

            },
            //導出
            doDerive: function () {
                if (!atosUtil.isNotEmpty($("#sysOperationTimeStart").val())) {
                    $('#sysOperationTimeStart').focus();
                    return false;
                }
                if (!atosUtil.isNotEmpty($("#sysOperationTimeEnd").val())) {
                    $('#sysOperationTimeEnd').focus();
                    return false;
                }
                if (($("#sysOperationTimeStart").val().substring(0,10)) == ($("#sysOperationTimeEnd").val().substring(0,10))) {
                    var dto = JSON.stringify($('#queryForm').serializeObject());
                    axios({
                        method: 'post',
                        url: basePath + "/sys/auditlog/export",
                        data: dto,
                        loading: true,
                        responseType: 'blob'
                    }).then(function (response) {
                        atosUtil.downloadPDF(response, 'audit_log_csv.csv');
                    }).catch(function (response) {
                        console.log(response);
                    })
                }else{
                	var options = {
                            text: atosUtil.getI18nMessage('sys.auditLogExporterTime')
                        };
                        $.confirm(options, function (yes) {

                        });
                }
            },
            // 關閉fancybox
            closeFancybox: function fancyboxClose() {
                $.fancybox.close();
            },
            // 返回条件表单信息
            getQueryDTO:function() {
                var dto = JSON.stringify($('#queryForm').serializeObject());
                return dto;
            },

        });
        controller.init();
        window.controller = controller;
    });