

require([ 'jquery',
          'atosBaseController',
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
          'noty.config' ],
        function($, atosBaseController,atosUtil,momentConfig,axios) {

	  var controller = atosBaseController(momentConfig, {
	        //統一定義變量.
	        variables : {
	            datatable : null
	        },
	        params:{
	            
	        },
	        init : function() {
	            this.initDatatables();
	            this.initEvent();	
	        },
	  initDatatables :function(){
		  this.variables.datatable = $('#table').DataTable({
                    serverSide : true,
                    processing : true,
                    deferLoading : 0,
                    ajax : {
                        url : basePath + "/sys/func/page",
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
                    columns : [{
                        "data" : "funcCode",
                        "width" : "15%"
                    }, {
                        "data" : "funcDesc",
                        "width" : '10%'
                    }, {
                        "data" : "module",
                        "width" : "10%"
                    },{
                        "data" : "menu",
                        "width" : "10%"
                    }, {
                        "data" : "createUser",
                        "width" : "10%"
                    }, {
                        "data" : "createDate",
                        "width" : "15%"
                    },  {
                        "data" : "lastUpdUser",
                        "width" : "10%"
                    }, {
                        "data" : "lastUpdDate",
                        "width" : "15%"
                    },  {
                        "data" : "action",
                        "width" : "5%",
                        "orderable" : false
                    } ],
                    columnDefs : [{
                        render : function(data, type, row) {
                            var str = "";
                            if (row.module) {
                                str = row.module.moduleName;
                            }
                            return str;
                        },
                        targets : 2
                    },{
                        render : function(data, type, row) {
                            var str = "";
                            if (row.parent) {
                                str = row.parent.funcDesc;
                            }
                            return str;
                        },
                        targets : 3
                    },{
                        render : function(data, type, row) {
                            var html =  '' + atosUtil.formatHtml('func-update-div', [row.funcId]);
                            return html;
                        },
                        targets : 8
                    }]
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
                    padding : 5,
                    width : '80%',
                    height : '80%'
                });
	        },
	        doSearch : function() {
	            var datatable = this.variables.datatable;
	            datatable.ajax.reload();
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

