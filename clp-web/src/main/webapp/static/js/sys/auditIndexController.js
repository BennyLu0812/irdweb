require([ 
    'jquery',
    'atosBaseController',
    'moment.config',
    'axios',
    'atosUtil',
    'axios.config',
    'jquery.config',
    'datatables',
    'datatables.config',
    'fancybox',
    'fancybox.config',
    'Noty',
    'noty.config'
    ],
    function($, atosBaseController,
        momentConfig, axios, atosUtil) {

    var controller = atosBaseController(momentConfig, {
        // 統一定義變量.
        variables : {
            datatable : null
        },
        params : {},
        init : function() {
            var self = this;
            atosUtil.getI18nByModules('global', function(){
                self.initDatatables();
                
            });
        },
        initDatatables : function() {
        	 var that = this;
            this.variables.datatable = $('#table').DataTable(
                    {                      
                        processing : true,
                        searching : true,
                        serverSide : true,
                        ajax : {
                            url : basePath + "/sys/auditlog/getAuditIndexPage",
                            type : "POST",
                            data : function(data, settings) {
                                var formData = $('#fm-search').serializeObject();
                                formData.docId = vModel.docId;
                                formData.licType = vModel.licType;
                                formData.licNo = vModel.licNo;
                                formData.examNo = vModel.examNo;
                                formData.examYear = vModel.examYear;
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
                            "data" : "sysFuncDesc",
                            "width" : "15%",
                            "render": function(data, type, row,meta){
                                var html = '';
                                if (row.sysFuncDesc) {
                                    html = row.sysFuncDesc;
                                } else {
                                    html = row.sysFuncCode;
                                }
                                return html;
                            } 
                        }, {
                            "data" : "sysOperatorId",
                            "width" : "8%"
                        }, {
                            "data" : "sysOperationTime",
                            "width" : "15%",
                            "render" : function(data, type, row,meta) {
                                return row.sysOperationTimeDesc;
                            }
                        }, {
                            "data" : "sysRemark",
                            "width" : "10%",
//                           
                        } , {
                            "data" : "serviceId",
                            "width" : "20%",
                            "render": function(data,type,row,meta){
                            	var html = '';
                            	if(row.serviceId){
                            	    html = row.serviceCname;
                            	}
                            	return html;
                            }
                        }, {
                            "data" : "processId",
                            "width" : "15%",
                            "render": function(data,type,row,meta){
                            	var html = '';
                            	if(row.processId){
//                            		html = row.processCode + '-' + row.processCname + '-' + row.processPname;
                            	    html = row.processCname;
                            	}
                            	return html;	
                            	
                            }
                        }, {
                            "data" : "hostIP",
                            "width" : "10%",
                            
                        }],
                        columnDefs : [ 
                            {
                            render : function(data, type, row) {
                                var html = '' + atosUtil.formatHtml('audit-detail-div', [row.auditMasterId]);
                                return html;
                            },
                            targets: 7
                        } ]
                    });
        },
    	
    });
    controller.init();
    window.controller = controller;
});
