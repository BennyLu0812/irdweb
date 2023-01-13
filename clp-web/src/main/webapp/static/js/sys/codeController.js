require(
        [ 'jquery', 'atosBaseController', 'moment.config', 'axios', 'atosUtil', 'axios.config', 'jquery.config', 'datatables',
                'datatables.config', 'fancybox', 'fancybox.config', 'Noty', 'noty.config', 'select2', 'select2.config' ],
        function($, atosBaseController, momentConfig, axios, atosUtil) {
            'use strict'; // 使用JS嚴格模式.

            var controller = atosBaseController(
                    momentConfig,
                    {
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
                                $(".content-header").find("label").append(
                                        " : ( " + vModel.codeType + " ) - " + vModel.codePname + " - " + vModel.codeCname);
                            });
                        },
                        initDatatables : function() {
                            var that = this;
                            this.variables.datatable = $('#table')
                                    .DataTable(
                                            {
                                                serverSide : true,
                                                processing : true,
                                                ajax : {
                                                    url : basePath + "/sys/code/list",
                                                    type : "POST",
                                                    data : function(data, settings) {
                                                        var formData = $("#fm-search").serializeObject();
                                                        formData.codeType = vModel.codeType;
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
                                                    "data" : "codeKey",
                                                    "width" : "8%"
                                                }, {
                                                    "data" : "codeCname"
                                                },{
                                                    "data" : "codePrintCname",
                                                    "width" : "10%"
                                                },{
                                                    "data" : "codeStatus",
                                                    "width" : "8%"
                                                }, {
                                                    "data" : "lastUpdUser",
                                                    "width" : "10%"
                                                }, {
                                                    "data" : "action",
                                                    "width" : "10%",
                                                    "orderable" : false
                                                } ],
                                                columnDefs : [ {
                                                    render : function(data, type, row) {
                                                        var html = row.codeCname?row.codeCname:"";
                                                        html +="<br><div class='text text-muted'>"+(row.codePname?row.codePname:'')+"</div>";
                                                        return html;
                                                    },
                                                    targets : 1
                                                },{
                                                    render : function(data, type, row) {
                                                        var html = row.codePrintCname?row.codePrintCname:"";
                                                        html +="<br><div class='text text-muted'>"+(row.codePrintPname?row.codePrintPname:'')+"</div>";
                                                        return html;
                                                    },
                                                    targets : 2
                                                },{
                                                    render : function(data, type, row) {
                                                        var html = row.lastUpdDate?row.lastUpdDate:"";
                                                        html +="<br><div class='text text-muted'>"+(row.lastUpdUser?row.lastUpdUser:'')+"</div>";
                                                        return html;
                                                    },
                                                    targets : 4
                                                },{
                                                    render : function(data, type, row) {
                                                        var html = '<div class="btn-group">'
                                                                + '<a href="detail.html?codeId='
                                                                + row.codeId
                                                                + '&codeType='
                                                                + vModel.codeType
                                                                + '&codeCname='
                                                                + vModel.codeCname
                                                                + '&codePname='
                                                                + vModel.codePname
                                                                + '" class="btn btn-sm btn-default fancybox"  data-fancybox-type="iframe" data-fancybox-width="80%" data-fancybox-height="80%" >'
                                                                + atosUtil.getI18nMessage('global.detail')
                                                                + '</a>'
                                                                + '<a href="#" class="btn btn-sm btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">'
                                                                + '<span class="caret"></span>' + '</a>'
                                                                + '<ul class="dropdown-menu">';
                                                        if (row.codeStatus == 'A') {
                                                            html += '<li>'
                                                                    + '<a href="edit.html?codeId='
                                                                    + row.codeId
                                                                    + '&codeType='
                                                                    + vModel.codeType
                                                                    + '&codeCname='
                                                                    + vModel.codeCname
                                                                    + '&codePname='
                                                                    + vModel.codePname
                                                                    + '" class="fancybox"  data-fancybox-type="iframe" data-fancybox-width="80%" data-fancybox-height="80%" >'
                                                                    + atosUtil.getI18nMessage('global.update')
                                                                    + '</a>'
                                                                    + '</li>'
                                                                    + '<li>'
                                                                    + '<a class="deleteBtn" href="javascript:void(0)" codeId="'
                                                                    + row.codeId + '" codeKey="'+row.codeKey+'">' + atosUtil.getI18nMessage('global.cancelled')
                                                                    + '</a></li>';
                                                        }
                                                        if (row.codeStatus == 'C') {
                                                            html += '<li>'
                                                                    + '<a class="reactivateBtn"  href="javascript:void(0)" codeId="'
                                                                    + row.codeId + '" codeKey="'+row.codeKey+'">' + atosUtil.getI18nMessage('global.reactivate') + '</a>'
                                                                    + '</li>';
                                                        }
                                                        html += '</ul></div>';
                                                        return html;
                                                    },
                                                    targets : 5
                                                } ]
                                            });
                            $('#table tbody').on('click', '.deleteBtn', function() {
                                var codeId = $(this).attr("codeId");
                                var codeKey = $(this).attr("codeKey");
                                that.fnDelete(codeKey,codeId);
                            });
                            $('#table tbody').on('click', '.reactivateBtn', function() {
                                var codeId = $(this).attr("codeId");
                                var codeKey = $(this).attr("codeKey");
                                that.fnReactivate(codeKey,codeId);
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
                            
                            $("#btn-reset").click(function() {
                                slef.doReset();
                            });
                        },

                        initSelect2 : function() {
                            $(".simpleselect").select2();
                        },

                        doCreate : function() {
                            $.fancybox.open({
                                href : 'edit.html?codeType=' + vModel.codeType + '&codeCname=' + vModel.codeCname
                                        + '&codePname=' + vModel.codePname,
                                type : 'iframe',
                                padding : 8,
                                width : '80%',
                                height : '80%'
                            });
                        },
                        doSearch : function() {
                            var datatable = this.variables.datatable;
                            datatable.ajax.reload();
                        },
                        doReset : function() {
                            $("#codeStatus").val("").trigger("change");
                            
                        },
                        // 關閉fancybox
                        closeFancybox : function fancyboxClose() {
                            $.fancybox.close();
                        },
                        // 操作提醒
                        showResult : function showResult(result) {
                            $.showResult(result);
                        },

                        fnReactivate : function(codeKey, codeId) {
                            var options = {
                                text : '確定復原當前代碼類型編號[' + codeKey + ']?'
                            };
                            $.confirm(options, function(yes) {
                                if (yes) {
                                    axios.post(basePath + '/sys/code/reactivate/' + codeId).then(function(response) {
                                        controller.showResult(response);
                                        var datatable = controller.variables.datatable;
                                        datatable.ajax.reload();
                                    });
                                }
                            });
                        },

                        fnDelete : function(codeKey, codeId) {
                            var options = {
                                text : '確定失效當前代碼類型編號[' + codeKey + ']?'
                            };
                            $.confirm(options, function(yes) {
                                if (yes) {
                                    axios.post(basePath + '/sys/code/cancelStatus/' + codeId).then(function(response) {
                                        controller.showResult(response);
                                        var datatable = controller.variables.datatable;
                                        datatable.ajax.reload();
                                    });
                                }
                            });
                        },
                        fnReload : function() {
                            $datatable.ajax.reload();
                        }
                    });
            controller.init();
            window.controller = controller;
        });
