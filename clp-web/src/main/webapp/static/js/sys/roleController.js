

require([
    'jquery', 
    'atosBaseController',
    'atosUtil',
    'Vue',
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
    'select2.config',
    'datetimepicker.config',
    'bootstrapValidator.config'
 ],
     function($, atosBaseController, atosUtil, Vue, momentConfig,axios) {
     'use strict';
     atosUtil.getI18nByModules('global, sys');
     
	 var controller = atosBaseController(momentConfig, {
	        //統一定義變量.
	        variables : {
	            datatable : null,
	            vue: null,
	            status: [],
	        },
	        params:{
	            
	        },
	        init : function() {
	            var self = this;
	            this.initData(function() {
	                self.initVue();
	                self.initDatatables();
	                self.initDatetimepicker();
	                self.initEvent();
	            });
	        },
	        initData: function(callback) {
	            var self = this;
                axios.get(
                    basePath + '/sys/role/status'
                ).then(function(result){
                    console.log(result);
                    self.variables.status = result;
                    if (callback) {
                        callback();
                    }
                }).catch(function(error){

                });
	            /*$.ajax({
	                url: basePath + '/sys/role/status',
	                type: 'GET',
	                data: '',
	                success:function (result) {
	                    console.log(result);
	                    self.variables.status = result;
	                    if (callback) {
	                        callback();
	                    }
	                }
	            });*/
	        },
	        initVue: function(result) {
	            var self = this;
	            this.vue = new Vue({
	                el: '#app',
	                data: {
	                    role: {
	                    },
	                    statusOptions: self.variables.status,
	                },
	                mounted: function() {
	                    console.log('mounted');
	                },
	                created: function() {
	                    console.log('created');
	                    
	                }
	            });
	        },
    	  initDatatables :function(){
    	      var self = this;
    		  this.variables.datatable = $('#table').DataTable({
                        serverSide : true,
                        processing : true,
                        ajax : {
                            url : basePath + "/sys/role/list",
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
                            "data" : "role"
                        }, {
                            "data" : "status"
                        }, {
                            "data" : "createUser"
                        }, {
                            "data" : "createDate"
                        },  {
                            "data" : "lastUpdUser"
                        }, {
                            "data" : "lastUpdDate"
                        }, {
                            "data" : "roleDesc"
                        },  {
                            "data" : "action",
                            "orderable" : false
                        } ],
                        columnDefs : [
                            {
                                render : function(data, type, row) {
                                    return atosUtil.getEnumText(self.variables.status, row.status);
                                },
                                targets : 1
                            },
                            {
                                render : function(data, type, row) {
                                    var html = '<a href="detail.html?roleId=' + row.roleId + '" class="btn btn-sm btn-primary fancybox fancybox.iframe" data-fancybox-width="100%" data-fancybox-height="100%"><i class="glyphicon glyphicon-detail"></i>' + i18n.detail+'</a>';
                                    	html +=  '' + atosUtil.formatHtml('role-update-div', [row.roleId]);
                                    return html;
                                },
                                targets : 7
                            }
                        ]
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
                
                $("#status").select2();
            },
            doCreate : function() {
                $.fancybox.open({
                    href : 'edit.html',
                    type : 'iframe',
                    padding : 5,
                    width : '100%',
                    height : '100%'
                });
	        },
	        doSearch : function() {
	            var datatable = this.variables.datatable;
	            datatable.ajax.reload();
	        },
	        doDelete : function(name){
	            $.confirm('確定刪除 '+name+' 該記錄？', function(yes) {
	                if(yes) {
	                    axios.delete(basePath + '/sys/role/'+name).then(function(response) {
                            controller.showResult(response);
                            controller.closeFancybox();
                            controller.doSearch();
                        });
	                }
	            });
	        },
            initDatetimepicker: function () {
             var self = this;
             $('#createDate_start').datetimepicker({
                 minView: "day", // 设置只显示到月份
                 defaultDate: new Date(),
                 format: "dd/mm/yyyy hh:ii:ss", // 日期格式
                 autoclose: true, // 选中关闭
                 todayBtn: true, // 今日按钮
                 clearBtn: true, // 清除按钮
                 todayHighlight: 1,
                 startView: 2,
                 forceParse: 0
             }).on('changeDate', function (ev) {
                 var starttime = $("#createDate_start").val();
                 $("#createDate_end").datetimepicker('setStartDate', starttime);
                 $("#createDate_start").datetimepicker('hide');
             });

             $('#createDate_end').datetimepicker({
                 minView: "day", // 设置只显示到月份
                 defaultDate: new Date(),
                 format: "dd/mm/yyyy hh:ii:ss", // 日期格式
                 autoclose: true, // 选中关闭
                 todayBtn: true, // 今日按钮
                 clearBtn: true, // 清除按钮
                 todayHighlight: 1,
                 startView: 2,
                 forceParse: 0
             }).on('changeDate', function (ev) {
                 var endtime = $("#createDate_end").val();
                 $("#createDate_start").datetimepicker('setEndDate', endtime);
                 $("#createDate_end").datetimepicker('hide');
             });


             $('#lastUpdDate_start').datetimepicker({
                 minView: "day", // 设置只显示到月份
                 defaultDate: new Date(),
                 format: "dd/mm/yyyy hh:ii:ss", // 日期格式
                 autoclose: true, // 选中关闭
                 todayBtn: true, // 今日按钮
                 clearBtn: true, // 清除按钮
                 todayHighlight: 1,
                 startView: 2,
                 forceParse: 0
             }).on('changeDate', function (ev) {
                 var starttime = $("#lastUpdDate_start").val();
                 $("#lastUpdDate_end").datetimepicker('setStartDate', starttime);
                 $("#lastUpdDate_start").datetimepicker('hide');
             });

             $('#lastUpdDate_end').datetimepicker({
                 minView: "day", // 设置只显示到月份
                 defaultDate: new Date(),
                 format: "dd/mm/yyyy hh:ii:ss", // 日期格式
                 autoclose: true, // 选中关闭
                 todayBtn: true, // 今日按钮
                 clearBtn: true, // 清除按钮
                 todayHighlight: 1,
                 startView: 2,
                 forceParse: 0
             }).on('changeDate', function (ev) {
                 var endtime = $("#lastUpdDate_end").val();
                 $("#lastUpdDate_start").datetimepicker('setEndDate', endtime);
                 $("#lastUpdDate_end").datetimepicker('hide');
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

