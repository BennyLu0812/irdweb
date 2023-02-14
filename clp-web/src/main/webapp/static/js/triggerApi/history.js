/**
 * 控制器.
 * @param $
 * @param dlsBaseController
 * @param momentConfig
 * @param axios
 * @returns
 */
require([
        'jquery',
        'Vue',
        'atosBaseController',
        'moment',
        'moment.config',
        'atosUtil',
        'axios',
        'tinyImgUpload',
        'jquery.config',
        'axios.config',
        'datatables.config',
        'vueSelect2',
        'select2',
        'select2.config',
        'bootstrapValidator.config',
        'datetimepicker.config',
        'fileinput'
    ],
    function($, Vue, atosBaseController, moment, momentConfig, atosUtil, axios, tinyImgUpload) {

        'use strict'; // 使用JS嚴格模式.
        var controller = atosBaseController(momentConfig, {
            variables: {
                vue: null,
                i18n: {},
            },
            init: function() {
                var self = this;
                atosUtil.getI18nByModules('global, enum, api', function(result) {
                    self.variables.i18n = result;
                    self.initVue(); // 初始化vue
                    self.initEvent(); // 初始化事件
                    self.vaildate();
                    self.initDatatables();
                });
            },
            // 初始化vue
            initVue: function() {
                var self = this;
                this.vue = new Vue({
                    el: '#historyApp',
                    data: {
                        createDateFrom: '',
                        createDateTo: '',
                        createUser: '',
                        apiName: '',
                        apiNameOptions: [{
                            "id": "",
                            "text": ""
                        },{
                            "id": "M",
                            "text": "M"
                        },{
                            "id": "T",
                            "text": "T"
                        }]
                    },
                    methods: {
                        doSave: function() {
                            var self = this;
                            if (!$.formValidator('#historyForm')) { // 驗證
                                return false;
                            }
                        }
                    },
                    computed: {
                        examNoAndYear: function() {
                            return this.examDetail.examNo + '/' + this.examDetail.examYear;
                        }
                    },
                    watch: {

                    },
                    mounted:function(){
                        var self = this;
                        /*setTimeout(function(){
                            controller.vaildate(); // vue 初始化結束后啓動校驗
                        },1000);*/
                    },
                    created: function() { // 初始化页面
                    }
                });
            },
            initDatatables : function() {
                var that = this;
                this.variables.datatable = $('#historyTable').DataTable(
                    {
                        serverSide : true,
                        processing : true,
                        pageLength : 5, // 每頁顯示5行
                        deferLoading : 0,
                        ajax : {
                            url : "#",
                            type : "POST",
                            data : function(data, settings) {
                                var formData = $('#historyForm').serializeObject();
                                return JSON.stringify($.extend({}, data, formData));
                            },
                            contentType : "application/json; charset=utf-8",
                            dataType : "json"
                        },
                        select : {
                            style : 'single',
                            selector : 'td'
                        },
                        columns : [ {
                            "data" : "createUser",
                            "width" : "10%"
                        }, {
                            "data" : "apiName",
                            "width" : "20%"
                        }, {
                            "data" : "createDate",
                            "width" : "15%"
                        }, {
                            "data" : "apiRequestParams",
                            "width" : "40%"
                        }, {
                            "data" : "apiResponseStatus",
                            "width" : "5%"
                        }, {
                            "data" : "column6",
                            "width" : "10%"
                        } ],
                        columnDefs : [{
                            render : function(data, type, row) {
                                if (row.apiName == 'renewCert') {
                                    return atosUtil.formatHtml('historyDiv_enable_Download', [row.apiHistoryId]);
                                } else {
                                    return atosUtil.formatHtml('historyDiv_not_Download', [row.apiHistoryId]);
                                }
                            },
                            targets : 5
                        }]
                    });
                // 操作栏点击获取詳情图标的id
                $(document).on("click", 'a[name="btn-details"]', function() {
                    var id = $(this).attr("id");
                    that.onDetailsBtnEvent(id);
                });
                // 下載證書
                $(document).on("click", 'a[name="btn-download"]', function() {
                    var id = $(this).attr("id");
                    that.doDownloadFile(id);
                });
            },
            // 初始化事件
            initEvent: function() {
                var self = this;

                $('#apiName').select2({data:[{
                        "id": "",
                        "text": ""
                    },{
                        "id": "alertBlackoutAPICreateRequest",
                        "text": "alertBlackoutAPICreateRequest"
                    },{
                        "id": "alertBlackoutAPIUpdateRequest",
                        "text": "alertBlackoutAPIUpdateRequest"
                    },{
                        "id": "alertBlackoutAPIQueryRequest",
                        "text": "alertBlackoutAPIQueryRequest"
                    },{
                        "id": "alertBlackoutRequestOutput",
                        "text": "alertBlackoutRequestOutput"
                    },{
                        "id": "alertBlackoutAPICancelRequest",
                        "text": "alertBlackoutAPICancelRequest"
                    },{
                        "id": "serviceFailureEventAPIRequest",
                        "text": "serviceFailureEventAPIRequest"
                    },{
                        "id": "securityEventAPIRequest",
                        "text": "securityEventAPIRequest"
                    },{
                        "id": "renewCert",
                        "text": "renewCert"
                    },{
                        "id": "heartBeatAPIRequest",
                        "text": "heartBeatAPIRequest"
                    }]});

                $('#createDateFrom').datetimepicker({
                    //language:  'cn',
                    //minView: "month",//设置只显示到月份
                    defaultDate: new Date(),
                    format: "yyyy-mm-dd hh:ii:ss",//日期格式  yyyy-MM-dd'T'HH:mm:ss.SSS+08:00
                    autoclose: true,//选中关闭
                    todayBtn: true,//今日按钮
                    clearBtn: true,//清除按钮
                    todayHighlight: true,
                    startView: 1,
                    //forceParse: 0
                }).on('changeDate', function (ev) {
                    var starttime = $("#createDateFrom").val();
                    $("#createDateTo").datetimepicker('setStartDate', starttime);
                    $("#createDateFrom").datetimepicker('hide');
                    self.createDateFrom = starttime;
                });

                $('#createDateTo').datetimepicker({
                    //language:  'cn',
                    //minView: "month",//设置只显示到月份
                    defaultDate: new Date(),
                    format: "yyyy-mm-dd hh:ii:ss",//日期格式
                    autoclose: true,//选中关闭
                    todayBtn: true,//今日按钮
                    clearBtn: true,//清除按钮
                    todayHighlight: true,
                    startView: 1,
                    //forceParse: 0
                }).on('changeDate', function (ev) {
                    var endtime = $("#createDateTo").val();
                    $("#createDateFrom").datetimepicker('setEndDate', endtime);
                    $("#createDateTo").datetimepicker('hide');
                    self.createDateTo = endtime;
                });

                // 查詢
                $("#historySearch").click(function() {
                    self.doSearch();
                });

                // 重置
                $("#historyRefresh").click(function() {
                    self.doReset();
                });

            },
            // 初始化校驗
            vaildate: function() {
                var that = this;

            },
            // 顯示明細詳細
            onDetailsBtnEvent : function(id) {
                $.fancybox.open({
                    href : basePath + '/triggerApi/historyDetail.html?apiHistoryId=' + id,
                    type : 'iframe',
                    width : '100%',
                    height : '100%'
                });
            },
            // 下載證書
            doDownloadFile: function(apiHistoryId){
                /*if(window.navigator.userAgent.indexOf("Chrome") > -1){
                    $.fancybox.open({
                        href : basePath + '/triggerApi/downloadFile/'+apiHistoryId,
                        type : 'iframe',
                        padding : 14,
                        width : '100%',
                        height : '100%',
                    });
                }else {
                    window.location.href = basePath + '/triggerApi/downloadFile/'+apiHistoryId;
                }*/


                axios({
                    method: 'get',
                    url: basePath + '/triggerApi/downloadFile/'+apiHistoryId,
                    responseType: 'blob',
                    data : $('#fm-search').serializeObject(),
                    contentType : "application/json; charset=utf-8",
                    dataType : "json",
                    handleResponse : false,
                    loading : true
                }).then(function(response){
                    atosUtil.download(response);
                });
            },
            // 查詢
            doSearch : function() {
                // 重载ajaxUrl 因为初始化不显示数据
                this.variables.datatable.ajax.url(basePath + "/triggerApi/apiHistory/list").load();
            },
            doReset : function() {
                var self = this;
                $("#historyForm").find(":input").val("");
                $("#apiName").val("").trigger("change");
                self.variables.vue.$refs.apiName.clearField();
            },
            /**
             * 根據模組簡稱及參數（可選），格式化國際化資源消息
             * @param code 模組簡稱
             * @param args 數組參數，比如確定刪除{0}嗎？，args代表佔位符{0}
             */
            getI18nMessage: function(code, args) {
                var that = this;
                var message = that.variables.i18n[code];
                if (message) {
                    if (!args) {
                        return message;
                    }
                    return message.format(args);
                } else {
                    return code;
                }
            },
            // 操作提醒
            showResult: function showResult(result) {
                $.showResult(result);
            },
            // 返回
            doBack: function() {
                parent.$.fancybox.close();
            },
            // 關閉 fancyBox
            closeFancybox: function() {
                $.fancybox.close();
            }
        });
        controller.init();
        // 如果有子窗口調用父窗口必須加入下面這句，子窗口調用父窗口使用 parent.controller.methodName
        window.controller = controller;
    });