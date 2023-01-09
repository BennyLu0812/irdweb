require([ 'jquery', 'atosBaseController', 'moment.config', 'axios', 'atosUtil', 'axios.config', 'jquery.config', 'datatables',
        'datatables.config', 'fancybox', 'fancybox.config', 'Noty', 'noty.config' ], function($, atosBaseController,
        momentConfig, axios, atosUtil) {
    'use strict'; // 使用JS嚴格模式.

    var controller = atosBaseController(momentConfig, {
        // 統一定義變量.
        variables : {
            datatable : null
        },
        params : {

        },
        init : function() {
            var self = this;
            atosUtil.getI18nByModules('global', function(){
                self.initDatatables();
                self.initEvent();
            });
        },
        initDatatables : function() {
            // debugger;
            this.variables.datatable = $('#table').DataTable(
                    {
                        // serverSide : false,
                        processing : true,
                        dom : '<"wrapper"<"col-sm-5"><"col-sm-7"f>>rt<"bottom"<"col-sm-5"i><"col-sm-7"p>>',
                        searching : true,
                        ajax : {
                            url : basePath + "/sys/codeMaster/list",
                            type : "POST",
                            data : function(data, settings) {
                                var formData = $('#fm-search').serializeObject();
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
                            "data" : "codeMasterType",
                            "width" : "12%"
                        }, {
                            "data" : "codeMasterCname",
                            "width" : "20%"
                        }, {
                            "data" : "codeMasterPname",
                            className : 'dt-nowrap',
                            width : '22%'
                        }, {
                            "data" : "action",
                            "width" : "10%",
                            "orderable" : false
                        } ],
                        columnDefs : [ {
                            render : function(data, type, row) {
                                var html =atosUtil.formatHtml('code-edit', [row.codeMasterType,(encodeURI(row.codeMasterCname)),(encodeURI(row.codeMasterPname)),]);
                                return html;
                            },
                            targets : 3
                        } ]
                    });
        },
        // 初始化綁定事件
        initEvent : function() {
            var slef = this;
            $("#btn-create").click(function() {
                slef.doCreate();
            });

            $("#btn-search").click(function() {
                slef.doSearch();
            });
        },
        doCreate : function() {
            $.fancybox.open({
                href : 'edit.html',
                type : 'iframe',
                padding : 3,
                width : '80%',
                height : '80%'
            });
        },
        doSearch : function() {
            var datatable = this.variables.datatable;
            datatable.ajax.reload();
        }, // 關閉fancybox
        closeFancybox : function fancyboxClose() {
            $.fancybox.close();
        },
        // 操作提醒
        showResult : function showResult(result) {
            $.showResult(result);
        }
    });
    controller.init();
    window.controller = controller;
});
