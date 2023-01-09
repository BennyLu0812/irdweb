require([ 'jquery', 'atosBaseController', 'moment.config', 'axios', 'atosUtil', 'axios.config', 'jquery.config', 'datatables',
        'datatables.config', 'fancybox', 'fancybox.config', 'Noty', 'noty.config', 'select2', 'select2.config' ],
        function($, atosBaseController, momentConfig, axios, atosUtil) {
            'use strict'; // 使用JS嚴格模式.

            var controller = atosBaseController(momentConfig, {
                // 統一定義變量.
                variables : {
                    datatable : null
                },
                init : function() {
                    var self = this;
                    atosUtil.getI18nByModules('global', function(){
                        self.initDatatables();
                        self.initEvent();
                        self.initSelect2();
                    });
                },
                initDatatables : function() {
                    this.variables.datatable = $('#table-rptMaster').DataTable({
                                serverSide : true,
                                processing : true,
                                ajax : {
                                    url : basePath + "/rpt/master/data",
                                    type : "POST",
                                    data : function(data, settings) {
                                        var formData = $("#fm-search").serializeObject();
                                        return JSON.stringify($.extend({}, data, formData));
                                    },
                                    contentType : "application/json; charset=utf-8",
                                    dataType : "json"
                                },
                                columns : [ {
                                    "data" : "cname",
                                }, {
                                    "data" : "descCn",
                                }, {
                                    "data" : "statusDesc",
                                }, {
                                    "data" : "rptType",
                                }, {
                                    "data" : "url"
                                },{ "data": "action"}],
                                columnDefs : [ {
                                    render : function(data, type, row) {
                                        var html = row.cname;
                                        if(row.pname!=null && row.pname != ''){
                                            html += '<br><span class="text text-muted">'+row.pname+'</span>';
                                        }
                                        return html;
                                    },
                                    targets : 0
                                }, {
                                    render : function(data, type, row) {
                                        var html = row.descCn;
                                        if(row.descPt!=null && row.descPt != ''){
                                            html += '<br><span class="text text-muted">'+row.descPt+'</span>';
                                        }
                                        return html;
                                    },
                                    targets : 1
                                }, {
                                    render : function(data, type, row) {
                                        if(row.status=='A'){
                                            return '<span class="text green-highlight">'+row.statusDesc+'</span>';
                                        }else if(row.status=='C'){
                                            return '<span class="text orange-highlight">'+row.statusDesc+'</span>';
                                        }else{
                                            return row.statusDesc;
                                        }
                                    },
                                    targets : 2
                                }
                                , {
                                    render : function(data, type, row) {
                                            var html = '<div class="btn-group">'
                                                +'<a  class="btn btn-default" href="rpt_master_info.html?rptId='+row.id+'">詳情</a>';
                                            if(row.rptPreviledge!=null && row.rptPreviledge != ''){
                                               html += '<button class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false" type="button">'
                                                       +'<span class="caret"></span></button><ul  class="dropdown-menu" role="menu">'
                                                       +'<li role="presentation"><a class="btn btn-default fancybox fancybox.iframe" data-fancybox-width="80%" data-fancybox-height="80%" href="rpt_previledge.html?rptPreviledge='+row.rptPreviledge+'">所需權限 </a></li></ul>';
                                            }
                                            html += '</div>';
                                            return html;
                                        
                                    },
                                    targets : 5
                                }]
                            });

                },
                // 初始化綁定事件
                initEvent : function() {
                    var self = this;

                    $("#btn-search").click(function() {
                        self.doSearch();
                    });
                    $(".reset").click(function(){
                        $("#rptType").val("").trigger("change");
                        $("#status").val("").trigger("change");
                       $("#fm-search")[0].reset(); 
                    });
                    
                    $("#fm-search").keyup(function(event){
                        if(event.keyCode == "13"){
                            self.doSearch();
                        }
                    });
                },

                initSelect2 : function() {
                    $('.sysselect').select2Remote({
                        url: basePath + '/select2/page'
                    });
                    $(".simpleselect").select2();
                },
                doSearch : function() {
                    var datatable = this.variables.datatable;
                    //默認不顯示任何數據，因此第一次點擊查詢按鈕時，需要destroy datatable；再重新init
                    if(datatable == null){
                        $("#table-comp").DataTable().destroy();
                        this.initDatatables();
                    }else{
                        datatable.ajax.reload();
                    }                   
                }, // 關閉fancybox
                closeFancybox : function fancyboxClose() {
                    $.fancybox.close();
                },
                // 操作提醒
                showResult : function showResult(result) {
                    $.showResult(result);
                },

            });
            controller.init();
            window.controller = controller;
        });
