/**
 * 控制器.
 * @param $
 * @param AuditLogController
 * @param momentConfig
 * @param axios
 * @returns
 */
require([ 
    'jquery',
    'atosBaseController',
    'Vue',
    'atosUtil',
    'moment.config',
    'axios', 
    'axios.config',
    'jquery.config',
    'datatables',
    'datatables.config',
    'fancybox', 
    'fancybox.config',
    'Noty', 
    'noty.config',
    'vueSelect2',
    'select2',
    'select2.config'
    ],
    function($, atosBaseController,momentConfig,  axios, atosUtil) {
        var controller = atosBaseController(momentConfig, {
            variables: {
                vue: null  
            },
            init : function() {
                this.initDatatables();
            },
            initDatatables : function() {
                 var that = this;
                this.variables.datatable = $('#table').DataTable(
                    {
                        processing : true,
                        searching : true,
                        serverSide : true,
                        ajax : {
                            url : basePath + "/sys/auditlog/getAuditDetailPage",
                            type : "POST",
                            data : function(data, settings) {
                                var formData = $('#fm-search').serializeObject();
                                formData.auditMasterId = vModel.auditMasterId;
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
                            "data" : "action",  
                            "width" : "5%"
                        }, {
                            "data" : "tableName",
                            "width" : "10%"
                        }, {
                            "data" : "columnName",
                            "width" : "10%"
                        }, {
                            "data" : "valueBefore",
                            "width" : "8%"
                        }, {
                            "data" : "valueAfter",
                            "width" : "8%"
                        } ],
                });
            },           
          
        });
        controller.init();
        // 如果有子窗口調用父窗口必須加入下面這句，子窗口調用父窗口使用 parent.controller.methodName
        window.controller = controller;
    });