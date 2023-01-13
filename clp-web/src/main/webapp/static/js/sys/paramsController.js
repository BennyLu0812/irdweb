

require([ 'jquery', 'atosBaseController', 'moment.config','axios', 'atosUtil', 'axios.config', 'jquery.config', 'datatables', 'datatables.config', 'fancybox', 'fancybox.config', 'Noty', 'noty.config' ],
    function($, atosBaseController, momentConfig, axios, atosUtil) {
    'use strict'; // 使用JS嚴格模式.

    var controller = atosBaseController(momentConfig, {
        // 統一定義變量.
        variables : {
            datatable : null
        },
        params:{
            
        },
        init : function() {
        	var self = this;
            atosUtil.getI18nByModules('global, lic', function() {
                self.initDatatables();
                self.initEvent();
            });
        },
        initDatatables : function(){
            this.variables.datatable = $('#table').DataTable({
                serverSide : true,
                processing : true,
                ajax : {
                    url : basePath + "/sys/params/list",
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
                    "data" : "paramName",
                    "width" : "12%"
                }, {
                    "data" : "paramValue",
                    className : 'dt-nowrap',
                    "width" : "20%"
                }, {
                    "data" : "paramDesc",
                    className : 'dt-nowrap'
                }, {
                    "data" : "lastUpdUser",
                    "width" : "15%"
                }, {
                    "data" : "lastUpdDate",
                    "width" : "15%"
                }, {
                    "data" : "action",
                    "width" : "8%",
                    "orderable" : false
                } ],
                columnDefs : [ {
                    render : function(data, type, row) {
                        /*var html = '<a href="edit.html?paramName=' + row.paramName + '" class="btn btn-sm btn-default fancybox fancybox.iframe " '
                                + 'data-fancybox-width="60%" data-fancybox-height="60%"><i class="iconfont icon-bianji"></i>' + atosUtil.getI18nMessage('global.update') + '</a>';*/
                        var html = atosUtil.formatHtml('param-edit', [row.paramName]);
                        return html;
                    },
                    targets : 5
                } ]
            });
	  	},
        // 初始化綁定事件
        initEvent : function() {
            var slef = this;
            
            $("#btn-search").click(function() {
                slef.doSearch();
            });
            //點擊重置按鈕的功能
                $("#btn-refresh").click(function(){
                    $("#paramName").val("");
                });
            //回車事件
            $('.input-field').bind('keypress',function (event){
                if(event.keyCode == "13"){
                    event.preventDefault();
                    $('#btn-search').click();
                }
            });

            $("#reloadSysParam").click(function(){
                //清除浏览器中存储的權限list
                //sessionStorage.removeItem("roleFuncList");
                axios.get(basePath + '/sys/params/reloadSysParamCache').then(function (response) {
                    slef.showResult(response);
                })
            });
        },
	    doSearch : function() {
            var datatable = this.variables.datatable;
            datatable.ajax.reload();
	    },
	      // 關閉fancybox
	    closeFancybox : function (){
	        $.fancybox.close();
	    },
       // 操作提醒
        showResult:function (result){
        	$.showResult(result);
        }
	});

    function funcName(){

    };
    
    controller.init();
    window.controller = controller;
});

