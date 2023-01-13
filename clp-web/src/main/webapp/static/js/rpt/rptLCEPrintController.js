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
            'select2',
            'select2.config',
            'vueSelect2',
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
                    atosUtil.getI18nByModules('global,validation,sys,rpt', function () {
                    	self.initEvent();
                    	self.vaildate();
                    	self.initDatetimepicker();
                    });
                },
                //校驗
                vaildate: function () {
                    var that = this;
                    $("#queryForm").bootstrapValidator({
                        fields: {
                            date: {
                                validators: {
                                    notEmpty : {
                                    	message : atosUtil.getI18nMessage('validation.inputRequried')
                                    },
                                    date: {
                                        format: 'DD/MM/YYYY',
                                        message : atosUtil.getI18nMessage('rpt.lceQuota.dateFormat')
                                    }
                                }
                            }
                        }
                    });
                },
                initDatetimepicker: function () {
                    var self = this;
                    $('#date').datetimepicker({
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
                        $("#date").datetimepicker('hide');
                        $.formValidator('#queryForm');
                        $("#queryForm").data('bootstrapValidator').updateStatus('date', 'VALID');
                    });
                },

                // 初始化綁定事件
                initEvent: function () {
                    var slef = this;
                    //導出
                    $("#export").click(function () {
                        slef.doDerive();
                    });
                    //監聽回車按鈕
                    $(document).keyup(function(event){  
                        if(event.keyCode ==13){  
                        	slef.doDerive();
                        }  
                      });
                },
                //導出
                doDerive: function () {
                	var date = $("#date").val().split('/');
                	date = date[2] + date[1] + date[0];
                	
                	var dto = {
                			date : date
                	};
                	if (!$.formValidator('#queryForm')) {
                        return false;
                    }
                	var params = encodeURIComponent(JSON.stringify(dto), 'utf-8');
                	window.location.href = basePath + "/lic/lcequota/getList?date=" + dto.date;
                    /*axios({
                        method: 'post',
                        url: basePath + "/lic/lcequota/getList",
                        data: dto,
                        loading: true,
                        responseType: 'blob'
                    }).then(function (response) {
                        atosUtil.downloadPDF(response, 'LCE_MontnlyRpt_' + dto.date + '.xlsx');
                    }).catch(function (response) {
                        console.log(response);
                    })*/
                },
            });
            controller.init();
            window.controller = controller;
        });