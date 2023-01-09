/**
 * licenseController.js
 * require的[''] 部分使用到的模塊才依賴，沒有使用的不用依賴.
 */
require([
        'jquery',
        'atosBaseController',
        'Vue',
        'moment.config',
        'atosUtil',
        'axios',
        'tinyImgUpload',
        'echarts',
        'jquery.config',
        'axios.config',
        'datatables.config',
        'fancybox.config',
        'vueSelect2',
        'select2',
        'select2.config',
        'bootstrapValidator.config',
        'datetimepicker.config',
        'vueloader!vue/componets/pdm-info',
        'vueloader!vue/componets/exl/exlOtherShowInfoTabs',
        'vueloader!vue/componets/license/restriction/licRestriction'

    ],
    function($, atosBaseController, Vue, momentConfig, atosUtil, axios, tinyImgUpload, echarts) {

        'use strict'; // 使用JS嚴格模式.

        var i18nArr = {};
        var controller = atosBaseController(momentConfig, {
            // 統一定義變量.
            variables: {
                vue: null
            },
            // 统一传参
            params: {},
            //所有初始化的入口處
            init: function() {
                var self = this;
                atosUtil.getI18nByModules('global,sys,validation', function(result) {
                    i18nArr = result;
                    self.initVue();
                    self.initDateTimePacker();
                    self.initEvent();

                });

            },
            initVue: function() {
                this.vue = new Vue({
                    el: '#app',
                    data: {
                        isUseOldIndustrialControl: vModel.isUseOldIndustrialControl,
                        centerUrl: basePath + '/ctr/center/select2/centerList',
                        centerCode: "CIVA",
                        inspectionDate: atosUtil.getSysDate(),
                        entryTimeTotals: [],
                        completeTimeTotals: [],
                        workDates: [],
                        detectTotal:[],
                        detectPass:[],
                        detectNotPass:[],
                        citizenAvgMin:0,
                        citizenAvgMinCount:0,
                        carAvgMin:0,
                        carAvgMinCount:0,
                        searchData:{
                        }
                    },
                    created: function () {
                        this.initData();
                    },
                    methods: {
                        initData : function () {
                            this.getTableSumTotal();
                            //图三
                            this.getSortSumTotal();
                            //公民平均等待時間
                            this.getCitizenAvgData();
                            //公民平均等待時間
                            this.getCarAvgData();
                        },
                        getTableSumTotal : function(){
                            var self = this;
                            if (!this.isUseOldIndustrialControl) {
                                var url = basePath + '/sys/dashboard/getTableSumTotal/' + this.centerCode + '?inspectionDate=' + this.inspectionDate;
                                axios.post(url).then(function (response) {
                                    self.detectTotal = new Array();
                                    self.detectPass = new Array();
                                    self.detectNotPass = new Array();
                                    for(let i = 0;i<response.length;i++){
                                        self.detectTotal.push(response[i]);
                                        self.detectPass.push(response[i].pass);
                                        self.detectNotPass.push(response[i].noPass);
                                    }
                                    //图一
                                    // 基于准备好的dom，初始化echarts实例
                                    var myChart = echarts.init(document.getElementById("main"));
                                    var option = {
                                        title: {
                                            text: i18nArr['sys.detect.title']
                                        },
                                        tooltip: {},
                                        legend: {
                                            data:["pass","notPass"]
                                        },
                                        xAxis: {
                                            data: [i18nArr['sys.detect.total'],i18nArr['sys.detect.car'],i18nArr['sys.detect.special'],i18nArr['sys.detect.out'],i18nArr['sys.detect.regular'],i18nArr['sys.detect.regularCar']]
                                        },
                                        yAxis: {},
                                        series: [   {
                                            name: "notPass",
                                            type: 'bar',
                                            stack: i18nArr['sys.detect.warn'],
                                            data: self.detectNotPass,
                                            label:{show:true},
                                        },{
                                            name: "pass",
                                            type: 'bar',
                                            stack: i18nArr['sys.detect.warn'],
                                            data: self.detectPass,
                                            label:{show:true},
                                            color:'#27B40A',
                                        }
                                        ]
                                    };
                                    myChart.setOption(option);
                                });
                            }
                        },
                        //图三
                        getSortSumTotal : function(){
                            var self = this;
                            var url = basePath + '/sys/dashboard/getSortSumTotal/' + this.centerCode + '?inspectionDate=' + this.inspectionDate;
                            axios.post(url).then(function (response) {
                                self.entryTimeTotals = new Array();
                                self.completeTimeTotals = new Array();
                                self.workDates = new Array();


                                self.entryTimeTotals = response.entryTimeTotal;
                                self.completeTimeTotals = response.completeTimeTotal;
                                self.workDates = response.workDate;
                                console.log(self.entryTimeTotals);
                                console.log(self.completeTimeTotals);
                                console.log(self.workDates);
                                var myChart2 = echarts.init(document.getElementById("main2"));
                                // var option2 = {
                                //     tooltip: {
                                //         trigger: 'axis',
                                //         position: function (pt) {
                                //             return [pt[0], '10%'];
                                //         }
                                //     },
                                //     title: {
                                //         text: i18nArr['sys.detect.sumTotal']
                                //     },
                                //     legend: {
                                //         data: [ i18nArr['sys.detect.entryTimeTotals'], i18nArr['sys.detect.completeTimeTotals']]
                                //     },
                                //     xAxis: {
                                //         type: 'category',
                                //         boundaryGap: false,
                                //         data: self.workDates
                                //     },
                                //     yAxis: {
                                //         type: 'value',
                                //         color:'#5470c6',
                                //         boundaryGap: [0, '100%']
                                //     },
                                //     dataZoom: [
                                //         {
                                //             type: 'inside',
                                //             start: 0,
                                //             end: 10
                                //         },
                                //         {
                                //             start: 0,
                                //             end: 10
                                //         }
                                //     ],
                                //     series: [
                                //         {
                                //             name: i18nArr['sys.detect.entryTimeTotals'],
                                //             type: 'line',
                                //             symbol: 'none',
                                //             sampling: 'lttb',
                                //             itemStyle: {
                                //                 color: 'rgb(255, 70, 131)'
                                //             },
                                //             areaStyle: {
                                //                 color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                                //                     {
                                //                         offset: 0,
                                //                         color: 'rgb(255, 158, 68)'
                                //                     },
                                //                     {
                                //                         offset: 1,
                                //                         color: 'rgb(255, 70, 131)'
                                //                     }
                                //                 ])
                                //             },
                                //             data: self.entryTimeTotals,
                                //         },
                                //         {
                                //             name: i18nArr['sys.detect.completeTimeTotals'],
                                //             type: 'line',
                                //             symbol: 'none',
                                //             sampling: 'lttb',
                                //             itemStyle: {
                                //                 color: 'rgb(255, 70, 131)'
                                //             },
                                //             areaStyle: {
                                //                 color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                                //                     {
                                //                         offset: 0,
                                //                         color: 'rgb(255, 158, 68)'
                                //                     },
                                //                     {
                                //                         offset: 1,
                                //                         color: 'rgb(255, 70, 131)'
                                //                     }
                                //                 ])
                                //             },
                                //             data: self.completeTimeTotals,
                                //         }
                                //     ]
                                // };
                                var option2 = {
                                    title: {
                                        text: i18nArr['sys.detect.sumTotal']
                                    },
                                    legend: {
                                        data: [ i18nArr['sys.detect.entryTimeTotals'], i18nArr['sys.detect.completeTimeTotals']]
                                    },
                                    xAxis: {
                                        type: 'category',
                                        data: self.workDates
                                    },
                                    yAxis: {
                                        type: 'value',
                                        color:'#5470c6'
                                    },
                                    series: [
                                        {
                                            name: i18nArr['sys.detect.entryTimeTotals'],
                                            type: 'line',
                                            color:'#5470c6',
                                            data: self.entryTimeTotals,
                                            show: true,

                                        },
                                        {
                                            name: i18nArr['sys.detect.completeTimeTotals'],
                                            type: 'line',
                                            stack: 'Total',
                                            data: self.completeTimeTotals,
                                            show: true, //开启显示
                                        }
                                    ],
                                    tooltip : {
                                        trigger: 'axis'
                                    }
                                };
                                myChart2.setOption(option2);
                            });
                        },
                        //公民平均等待時間
                        getCitizenAvgData : function(){
                            var self = this;
                            var url = basePath + '/sys/dashboard/getCitizenAvgData/' + this.centerCode + '?inspectionDate=' + this.inspectionDate;
                            axios.post(url).then(function (response) {
                                self.citizenAvgMin = response.citizenAvgMin;
                                self.citizenAvgMinCount = response.citizenAvgMinCount;
                            });
                        },
                        //公民平均等待時間
                        getCarAvgData: function(){
                            var self = this;
                            var url = basePath + '/sys/dashboard/getCarAvgData/' + this.centerCode + '?inspectionDate=' + this.inspectionDate;
                            axios.post(url).then(function (response) {
                                self.carAvgMin = response.carAvgMin;
                                self.carAvgMinCount = response.carAvgMinCount;
                            });
                        }
                    },
                });
            },
            initEvent: function(){
                $("#inspectionDate").on("change", function(){
                    console.log($("#inspectionDate").val());
                    controller.vue.inspectionDate = $("#inspectionDate").val();
                    controller.vue.initData();
                });
            },
            initDateTimePacker: function () {
                $('#inspectionDate').datetimepicker({
                    //language:  'cn',
                    minView: "month",//设置只显示到月份
                    defaultDate: new Date(),
                    format: "dd/mm/yyyy",//日期格式
                    autoclose: true,//选中关闭
                    todayBtn: true,//今日按钮
                    clearBtn: true,//清除按钮
                    todayHighlight: 1,
                    startView: 2,
                    forceParse: 0
                });
            },

        });
        controller.init();
        // 如果有子窗口調用父窗口必須加入下面這句，子窗口調用父窗口使用 parent.controller.methodName
        window.controller = controller;
    });