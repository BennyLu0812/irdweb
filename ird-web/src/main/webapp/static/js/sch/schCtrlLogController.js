/**
 * 
 * jobCtrlController.js
 */
require([ 'jquery', 'atosBaseController', 'moment.config', 'jquery.config', 'datatables', 'datatables.config' ],
    function($, atosBaseController, momentConfig ) {
	
	'use strict'; // 使用JS嚴格模式.
    
    var controller = atosBaseController(momentConfig, {
        init : function() {
            this.initDatatables();
        },
        initDatatables : function() {
        	$('#table').DataTable({
        	    serverSide: true,
                processing: true,
                paging: true,
                info: false,
                ajax : {
                    url : basePath + "/sch/ctrl/log/list",
                    type : "POST",
                    contentType : "application/json; charset=utf-8",
                    data : function(data, settings) {
                        var formData = $('#fm-search').serializeObject();
                        return JSON.stringify($.extend({}, data, formData));
                    },
                    dataType : "json"
                },
                select : {
                    style : 'single',
                    selector : 'td'
                },
                columns: [{
                    data: 'jobCode'
                }, {
                    data: 'recProcessed'
                }, {
                    data: 'recPending'
                }, {
                    data: 'recInsert'
                }, {
                    data: 'recUpdate'
                }, {
                    data: 'recDelete'
                }, {
                    data: 'startTimeDesc'
                }, {
                    data: 'endTimeDesc'
                }, {
                    data: 'status',
                    render: function (data, type, row) {
                    	if (data == 'PROGRESS') {
                            return '<span th:placeholder="#{jobCtrlLog.status.progress}">处理中</span>';
                        } else if (data == 'COMPLETE') {
                            return '<span th:placeholder="#{jobCtrlLog.status.complete}">完成</span>';
                        } else if (data == 'FAILED') {
                            return '<span th:placeholder="#{jobCtrlLog.status.failed">失敗</span>';
                        }
                    }
                }, {
                    data: 'latestJobInd',
                    render: function (data, type, row) {
                        if (data == true) {
                            return '是';
                        }
                        return '否';
                    }
                }]
            });
        }
    	
    	
    });
	
    controller.init();
    
});