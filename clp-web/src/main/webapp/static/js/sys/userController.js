

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
     function($, atosBaseController, atosUtil, Vue, momentConfig, axios) {
     'use strict';
     atosUtil.getI18nByModules('global, sys,validation');

     var controller = atosBaseController(momentConfig, {
        //統一定義變量.
        variables : {
            datatable : null,
            vue: null,
            userStatus: [],
        },
        params:{
            
        },
        init : function() {
            var self = this;
            this.initData(function() {
                self.initVue();
                self.initDatatables();
                self.initEvent();
                self.initDatetimepicker();
                self.vaildate();
            });
        },
        initData: function(callback) {
            var self = this;
            axios.get(
                basePath + '/sys/user/status'
            ).then(function(result){
                self.variables.userStatus = result;
                if (callback) {
                    callback();
                }
            }).catch(function(error){

            });
            /*$.ajax({
                url: basePath + '/sys/user/status',
                type: 'GET',
                data: '',
                success:function (result) {
                    self.variables.userStatus = result;
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
                    user: {
                    },
                    statusOptions: self.variables.userStatus,
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
                        url : basePath + "/sys/user/list",
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
                        "data" : "userId"
                    }, {
                        "data" : ""
                    }, {
                        "data" : "status"
                    }, {
                        "data" : "roles"
                    }, {
                        "data" : ""
                    },{
                        "data" : ""
                    }, {
                        "data" : "action",
                        "orderable" : false
                    } ],
                    columnDefs : [
						{
						    render : function(data, type, row) {
						    	var html = row.cnName != null ? '<div>'+row.cnName+'</div>' : '<div>&nbsp;</div>';
	                                html += row.enName != null ? '<div>'+row.enName+'</div>' : '';
	                            return html;
						    },
						    targets : 1
						},
                        {
                            render : function(data, type, row) {
                                return atosUtil.getEnumText(self.variables.userStatus, row.status);
                            },
                            targets : 2
                        },
                        {
                            render : function(data, type, row) {
                               var html = "";
                               var roles = row.roles;
                               
                               if (roles && roles.length > 0) {
                                   for(var i = 0; i < roles.length; i++){
                                       html += "<div><span>" + roles[i].role + "-" + roles[i].roleDesc + "</span></div>";
                                   }
                               }
                               return html;
                            },
                            targets : 3
                        }, 
                        {
						    render : function(data, type, row) {
						        var html = row.createUser != null ? '<div>'+row.createUser+'</div>' : '<div>&nbsp;</div>';
	                                html += row.createDate != null ? '<div>'+row.createDate+'</div>' : '';    
	                            return html;
						        
						    },
						    targets : 4
						},
						{
						    render : function(data, type, row) {
						        var html = row.lastUpdUser != null ? '<div>'+row.lastUpdUser+'</div>' : '<div>&nbsp;</div>';
	                                html += row.lastUpdDate != null ? '<div>'+row.lastUpdDate+'</div>' : '';    
	                            return html;
						    },
						    targets : 5
						},
                        {
                            render : function(data, type, row) {
                            var html = '<a href="detail.html?userId='+row.userId+'" class="btn btn-sm btn-default fancybox fancybox.iframe" data-fancybox-width="100%" data-fancybox-height="100%"><i class="glyphicon glyphicon-detail"></i>'+i18n.detail+'</a>'
                            	html += '' + atosUtil.formatHtml('user-update-div', [row.userId]);
                            return html;
                        },
                        targets : 6
                    }]
                });
	  	    },
	  	    
	  	  initDatetimepicker: function () {
              var self = this;
              $('#createDate_start').datetimepicker({
                  minView: "month",//设置只显示到月份
                  defaultDate: new Date(),
                  format: "dd/mm/yyyy",//日期格式
                  autoclose: true,//选中关闭
                  todayBtn: true,//今日按钮
                  clearBtn: true,//清除按钮
                  todayHighlight: 1,
                  startView: 2,
                  forceParse: 0
              }).on('changeDate', function (ev) {
                  var starttime = $("#createDate_start").val();
                  $("#createDate_end").datetimepicker('setStartDate', starttime);
                  $("#createDate_start").datetimepicker('hide');
              });

              $('#createDate_end').datetimepicker({
                  minView: "month",//设置只显示到月份
                  defaultDate: new Date(),
                  format: "dd/mm/yyyy",//日期格式
                  autoclose: true,//选中关闭
                  todayBtn: true,//今日按钮
                  clearBtn: true,//清除按钮
                  todayHighlight: 1,
                  startView: 2,
                  forceParse: 0
              }).on('changeDate', function (ev) {
                  var endtime = $("#createDate_end").val();
                  $("#createDate_start").datetimepicker('setEndDate', endtime);
                  $("#createDate_end").datetimepicker('hide');
              });
              
              
              $('#lastUpdDate_start').datetimepicker({
                  minView: "month",//设置只显示到月份
                  defaultDate: new Date(),
                  format: "dd/mm/yyyy",//日期格式
                  autoclose: true,//选中关闭
                  todayBtn: true,//今日按钮
                  clearBtn: true,//清除按钮
                  todayHighlight: 1,
                  startView: 2,
                  forceParse: 0
              }).on('changeDate', function (ev) {
                  var starttime = $("#lastUpdDate_start").val();
                  $("#lastUpdDate_end").datetimepicker('setStartDate', starttime);
                  $("#lastUpdDate_start").datetimepicker('hide');
              });

              $('#lastUpdDate_end').datetimepicker({
                  minView: "month",//设置只显示到月份
                  defaultDate: new Date(),
                  format: "dd/mm/yyyy",//日期格式
                  autoclose: true,//选中关闭
                  todayBtn: true,//今日按钮
                  clearBtn: true,//清除按钮
                  todayHighlight: 1,
                  startView: 2,
                  forceParse: 0
              }).on('changeDate', function (ev) {
                  var endtime = $("#lastUpdDate_end").val();
                  $("#lastUpdDate_start").datetimepicker('setEndDate', endtime);
                  $("#lastUpdDate_end").datetimepicker('hide');
              });
          },
          
        //校驗
          vaildate: function () {
        	  var that = this;
              $("#fmsearch").bootstrapValidator({
                  fields: {
                      enName : {
                          validators : {
                              stringLength : {
                                  min : 0,
                                  max : 50,
                                  message : atosUtil.getI18nMessage(
                                          'validation.stringLengthMaxium', [ 50 ])
                              },
                          }
                      }
                  }
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
                
                //監聽回車按鈕
                $(document).keyup(function(event){  
                  if(event.keyCode == 13){ 
                      slef.doSearch();
                  }  
                });
                
                $("#status").select2()
            },
            doCreate : function() {
                $.fancybox.open({
                    href : 'edit.html',
                    type : 'iframe',
                    padding : 5,
                    width : '100%',
                    height : '100s%'
                });
            },
            doSearch : function() {
                var datatable = this.variables.datatable;
                datatable.ajax.reload();
            },
            doDelete : function(name){
                $.confirm('確定刪除 '+name+' 該記錄？', function(yes) {
                    if(yes) {
                        axios.delete(basePath + '/sys/params/'+name).then(function(response) {
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

