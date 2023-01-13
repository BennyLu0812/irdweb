

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
                ExcelFileName: {
                    "1": "ASM檢測數據統計.xlsx",
                    "2": "Lugdown檢測數據統計.xlsx",
                    "3": "摩托車怠速檢測數據統計.xlsx",
                    "4": "汽車雙怠速檢測數據統計.xlsx"
                }
            },
            init : function() {
                this.initVue();
                this.initDatetimepicker();
                this.initVaildate();
            },
            initVue: function() {
                var self = this;
                this.vue = new Vue({
                    el: '#app',
                    data: {
                        centerOption: [],
                        centerUrl: basePath + '/ctr/center/select2/centerList',
                        typeOptions: [
                            {id: "1", text: "ASM檢測數據統計"},
                            {id: "2", text: "Lugdown檢測數據統計"},
                            {id: "3", text: "摩托車怠速檢測數據統計"},
                            {id: "4", text: "汽車雙怠速檢測數據統計"}
                        ],
                        typeValue: "0"
                    },
                    mounted: function () {
                        this.initDatatables();
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
                            if (!!controller.variables.datatable) {
                                controller.variables.datatable.clear();
                                controller.variables.datatable.state.clear();
                                controller.variables.datatable.destroy(false);
                            }
                            var that = this
                            that.typeValue = $('#type').val()
                            this.$nextTick(() => {
                                that.initDatatables();
                                controller.doSearch();
                            })
                        },
                        exportData: function() {
                            if (!$.formValidator('#fm-search')) { // 驗證
                                return false;
                            }
                            controller.doDerive(this.typeValue);
                        },
                        initDatatables :function(){
                            var that = this;
                            var columns = [
                                {
                                    "data" : "inspMasterId",
                                    "width": "180px",
                                },{
                                    "data" : "noOfTimesInsp",
                                    "width": "100px"
                                },{
                                    "data" : "centerNameCn",
                                    "width": "100px"
                                },{
                                    "data" : "plateNo",
                                    "width": "100px"
                                },{
                                    "data" : "vehType",
                                    "width": "100px"
                                },{
                                    "data" : "vin",
                                    "width": "100px"
                                },{
                                    "data" : "engineNo",
                                    "width": "100px"
                                },{
                                    "data" : "vehBrandCode",
                                    "width": "100px"
                                },{
                                    "data" : "vehModel",
                                    "width": "100px"
                                },{
                                    "data" : "vehBuildYear",
                                    "width": "100px"
                                },{
                                    "data" : "vtaYear",
                                    "width": "100px"
                                },{
                                    "data" : "vehRegDate",
                                    "width": "100px"
                                },{
                                    "data" : "maxPower",
                                    "width": "100px"
                                },{
                                    "data" : "powerUnitType",
                                    "width": "100px"
                                },{
                                    "data" : "cylinderVol",
                                    "width": "100px"
                                },{
                                    "data" : "fuelType",
                                    "width": "100px"
                                },{
                                    "data" : "fuelTypeCn",
                                    "width": "100px"
                                },{
                                    "data" : "fuelTypePt",
                                    "width": "100px"
                                },{
                                    "data" : "fuelSupplyType",
                                    "width": "100px"
                                },{
                                    "data" : "vehCategory",
                                    "width": "100px"
                                },{
                                    "data" : "vehCategoryCn",
                                    "width": "100px"
                                },{
                                    "data" : "vehCategoryPt",
                                    "width": "100px"
                                },{
                                    "data" : "vehUsageCode",
                                    "width": "100px"
                                },{
                                    "data" : "vehUsageCodeCn",
                                    "width": "100px"
                                },{
                                    "data" : "vehUsageCodePt",
                                    "width": "100px"
                                },{
                                    "data" : "vehBuildCtryCode",
                                    "width": "100px"
                                },{
                                    "data" : "vehWeight",
                                    "width": "100px"
                                },{
                                    "data" : "vehGrossWeight",
                                    "width": "100px"
                                },{
                                    "data" : "inspTime",
                                    "width": "100px"
                                },
                                {
                                    "data" : "eeCo5025",
                                    "width": "200px",
                                    "visible": that.typeValue === "1"
                                },
                                {
                                    "data" : "eeCo5025Result",
                                    "width": "200px",
                                    "visible": that.typeValue === "1"
                                },
                                {
                                    "data" : "eeHc5025",
                                    "width": "200px",
                                    "visible": that.typeValue === "1"
                                },
                                {
                                    "data" : "eeHc5025Result",
                                    "width": "200px",
                                    "visible": that.typeValue === "1"
                                },
                                {
                                    "data" : "eeNo5025",
                                    "width": "200px",
                                    "visible": that.typeValue === "1"
                                },
                                {
                                    "data" : "eeNo5025Result",
                                    "width": "200px",
                                    "visible": that.typeValue === "1"
                                },
                                {
                                    "data" : "eeCo2540",
                                    "width": "200px",
                                    "visible": that.typeValue === "1"
                                },
                                {
                                    "data" : "eeCo2540Result",
                                    "width": "200px",
                                    "visible": that.typeValue === "1"
                                },
                                {
                                    "data" : "eeHc2540",
                                    "width": "200px",
                                    "visible": that.typeValue === "1"
                                },
                                {
                                    "data" : "eeHc2540Result",
                                    "width": "200px",
                                    "visible": that.typeValue === "1"
                                },
                                {
                                    "data" : "eeNo2540",
                                    "width": "200px",
                                    "visible": that.typeValue === "1"
                                },
                                {
                                    "data" : "eeNo2540Result",
                                    "width": "200px",
                                    "visible": that.typeValue === "1"
                                },
                                {
                                    "data" : "eeOverallResult",
                                    "width": "100px",
                                    "visible": that.typeValue === "1"
                                },
                                {
                                    "data" : "ffHsu100",
                                    "width": "200px",
                                    "visible": that.typeValue === "2"
                                },
                                {
                                    "data" : "ffHsu90",
                                    "width": "200px",
                                    "visible": that.typeValue === "2"
                                },
                                {
                                    "data" : "ffHsu80",
                                    "width": "200px",
                                    "visible": that.typeValue === "2"
                                },
                                {
                                    "data" : "ffMaxWp",
                                    "width": "200px",
                                    "visible": that.typeValue === "2"
                                },
                                {
                                    "data" : "ffOverallResult",
                                    "width": "100px",
                                    "visible": that.typeValue === "2"
                                },
                                {
                                    "data" : "ddCoIdle",
                                    "width": "200px",
                                    "visible": that.typeValue === "3"
                                },
                                {
                                    "data" : "ddHcIdle",
                                    "width": "200px",
                                    "visible": that.typeValue === "3"
                                },
                                {
                                    "data" : "ddOverallResult",
                                    "width": "100px",
                                    "visible": that.typeValue === "3"
                                },
                                {
                                    "data" : "bbCoIdle",
                                    "width": "200px",
                                    "visible": that.typeValue === "4"
                                },
                                {
                                    "data" : "bbHcIdle",
                                    "width": "200px",
                                    "visible": that.typeValue === "4"
                                },
                                {
                                    "data" : "bbCoHighIdle",
                                    "width": "200px",
                                    "visible": that.typeValue === "4"
                                },
                                {
                                    "data" : "bbHcHighIdle",
                                    "width": "200px",
                                    "visible": that.typeValue === "4"
                                },
                                {
                                    "data" : "bbOverallResult",
                                    "width": "100px",
                                    "visible": that.typeValue === "4"
                                }
                            ]
                            controller.variables.datatable = $('#table').DataTable({
                                scrollX: true,
                                serverSide : true,
                                processing : true,
                                deferLoading: 0,
                                ajax : {
                                    url : basePath + "/rpt/export/getBenExhaustStatisticsPage",
                                    type : "POST",
                                    contentType : "application/json; charset=utf-8",
                                    data : function(data, settings) {
                                        var formData = $('#fm-search').serializeObject();
                                        return JSON.stringify($.extend({}, data, formData));
                                    },
                                    dataType : "json"
                                },
                                columns: columns
                            });
                        }
                    }
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
                        },
                        type: {
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
            doDerive: function (type) {
                var dto = JSON.stringify($('#fm-search').serializeObject());
                atosUtil.showLoading();
                var fileName =
                axios({
                    method: 'post',
                    url: basePath + "/rpt/export/exportBenExhaustStatistics",
                    data: dto,
                    loading: true,
                    responseType: 'blob'
                }).then(function (response) {
                    atosUtil.downloadPDF(response, controller.variables.ExcelFileName[type]);
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

