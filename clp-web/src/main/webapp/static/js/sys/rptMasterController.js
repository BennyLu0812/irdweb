

require([ 'jquery', 'atosBaseController', 'moment.config','axios', 'axios.config', 'jquery.config', 'datatables', 'datatables.config', 'fancybox', 'fancybox.config', 'Noty', 'noty.config' ],
        function($, atosBaseController, momentConfig,axios) {

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
                    ajax : {
                        url : basePath + "/sys/rpt/master/list",
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
                        "data" : "id",
                        "width" : "10%"
                    }, {
                        "data" : "cname",
                        "width" : "10%"
                    }, {
                        "data" : "descCn",
                        "width" : "20%"
                    }, {
                        "data" : "status",
                        "width" : "6%"
                    }, {
                        "data" : "rptType",
                        width : '6%'
                    }, {
                        "data" : "url",
                        "width" : "10%"
                    },  {
                        "data" : "lastUpdUser",
                        "width" : "10%"
                    }, {
                        "data" : "lastUpdDate",
                        "width" : "10%"
                    }, {
                        "data" : "action",
                        "width" : "20%",
                        "orderable" : false
                    } ],
                    columnDefs : [ {
                        render : function(data, type, row) {
                            if(row.pname != null){
                                return data + '</br>' + row.pname;
                            }
                            return data;
                        },
                        targets : 1
                    }, {
                        render : function(data, type, row) {
                            if(row.descPt != null){
                                return data + '</br>' + row.descPt;
                            }
                            return data;
                        },
                        targets : 2
                    }, {
                        render : function(data, type, row) {
                            var html = '<a href="edit.html?roleId=' + row.id + '" class="btn btn-sm btn-primary fancybox fancybox.iframe" '
                                    + 'data-fancybox-width="80%" data-fancybox-height="80%"><i class="glyphicon glyphicon-detail"></i>' + i18n.update+'</a>';
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
	        doDelete : function(id){
	            $.confirm('確定刪除 編號為'+id+' 的記錄？', function(yes) {
	                if(yes) {
	                    axios.delete(basePath + '/sys/rpt/master/'+id).then(function(response) {
                            controller.showResult(response);
                            controller.closeFancybox();
                            controller.doSearch();
                        });
	                }
	            });
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

