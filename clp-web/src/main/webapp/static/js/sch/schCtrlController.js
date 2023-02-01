/**
 * jobCtrlController.js
 * require的[''] 部分使用到的模塊才依賴，沒有使用的不用依賴.
 */
require([
    'jquery',
    'atosBaseController',
    'atosUtil',
    'Vue',
    'moment.config',
    'axios',
    'datatables',
    'fancybox',
    'jquery.config',
    'axios.config',
    'datatables.config',
    'fancybox.config',
    'select2',
    'select2.config'
],
    function ($, atosBaseController,atosUtil,Vue,  momentConfig, axios) {

        'use strict'; // 使用JS嚴格模式.


        var controller = atosBaseController(momentConfig, {
            // 統一定義變量.
            variables: {
                datatable: null,
                i18n: {}
            },
            // 统一传参
            params: {
            },
            //所有初始化的入口處
            init: function () {
                var self = this;
                atosUtil.getI18nByModules('sys, sch',function (result) {
                    self.variables.i18n = result;
                    self.initDatatables();
                    self.initEvent();
                });
            },
            select2: function () {
            },
            //初始化dataTables
            initDatatables: function () {
                var that = this;

                this.variables.datatable = $('#table').DataTable(
                    {
                        serverSide: true,
                        processing: true,
                        paging: false,
                        info: false,
                        ajax: {
                            url: basePath + "/sch/ctrl/list",
                            type: "POST",
                            data: function (data, settings) {
                                var formData = $('#fm-search').serializeObject();
                                return JSON.stringify($.extend({}, data, formData));
                            },
                            contentType: "application/json; charset=utf-8",
                            dataType: "json"
                        },
                        select: {
                            style: 'single',
                            selector: 'td'
                        },
                        columns: [{
                            "data": "jobCode",
                            className: 'dt-nowrap',
                            "width": "15%"
                        }, {
                            "data": "cronChar",
                            className: 'dt-nowrap',
                            width: '15%'
                        }, {
                            "data": "clsName",
                            className: 'dt-nowrap',
                            "width": "15%"
                        }, {
                            "data": "enabled",
                            render: function (data, type, row) {
                                if (data == true) {
                                    var enableText = that.variables.i18n['schCtrl.enabled.true'];
                                    return '<span>' + enableText + '</span>';
                                } else {
                                    var disableText = that.variables.i18n['schCtrl.enabled.false'];
                                    return '<span>' + disableText + '</span>';
                                }
                            },
                            "width": "10%"
                        }, {
                            "data": "workStatus",
                            render: function (data, type, row) {
                                var workStatusText;
                                if (data == 'NONE') {
                                    workStatusText = that.variables.i18n['schCtrl.status.none'];
                                } else if (data == 'NORMAL') {
                                    workStatusText = that.variables.i18n['schCtrl.status.normal'];
                                } else if (data == 'PAUSED') {
                                    workStatusText = that.variables.i18n['schCtrl.status.paused'];
                                } else if (data == 'COMPLETE') {
                                    workStatusText = that.variables.i18n['schCtrl.status.complete'];
                                } else if (data == 'ERROR') {
                                    workStatusText = that.variables.i18n['schCtrl.status.error'];
                                } else if (data == 'BLOCKED') {
                                    workStatusText = that.variables.i18n['schCtrl.status.blocked'];
                                } else {
                                    workStatusText = '--';
                                }

                                return '<span>' + workStatusText + '</span>';
                            },
                            "width": "10%"
                        }, {
                            "data": "action",
                            "width": "7%",
                            "orderable": false
                        }],
                        columnDefs: [
                            {
                                render: function (data, type, row) {
                                    var html = '<div class="dropdown">'
                                        + '<a href="#" onclick="controller.doUpdate(\''+row.id+'\',\''+row.workStatus+'\')" class="btn btn-sm btn-default" '
                                        + '>'
                                        + i18n.update+'</a>'
                                        + '<button type="button" class="btn btn-sm btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><span class="caret"></span></button>'
                                        + '<ul class="dropdown-menu dropdown-menu-right" role="menu">'
                                        + '<li><a href="sch_detail.html?id=' + row.id + '" >detail</a><li>';
                                    if (row.workStatus == 'NONE') {
                                        html += '<li><a href="#" onclick="controller.doStart(\'' + row.id + '\')" >start</a><li>';
                                    }
                                    if (row.workStatus == 'NORMAL') {
                                        html += '<li><a href="#" onclick="controller.doPause(\'' + row.id + '\')" >pause</a><li>';
                                        html += '<li><a href="#" onclick="controller.doRunOnce(\'' + row.id + '\')" >runOnce</a><li>';
                                    }
                                    if (row.workStatus == 'PAUSED') {
                                        html += '<li><a href="#" onclick="controller.doRestart(\'' + row.id + '\')">restart</a><li>';
                                    }
                                    html += '</ul></div>';
                                    return html;
                                },
                                targets: 5
                            }, {
                                targets: [0, 2],
                                createdCell: function (td, cellData, rowData, row, col) {
                                    $(td).attr({
                                        'data-toggle': 'tooltip',
                                        'title': cellData
                                    });
                                }
                            }]
                    });
            },
            // 初始化綁定事件
            initEvent: function () {
                var slef = this;
                $("#btn-create").click(function () {
                    slef.doCreate();
                    //                slef.select2();
                });

                $("#btn-search").click(function () {
                    slef.doSearch();
                });
            },
            doUpdate:function(id,status){
                if('NORMAL'== status){
                    $.alert({text:atosUtil.getI18nMessage("sys.sch.notUpdate")});
                    return false;
                }
                $.fancybox.open({
                    href: 'edit.html?id='+id,
                    type: 'iframe',
                    padding: 5,
                    width: '80%',
                    height: '80%'
                });
            },
            // 新增
            doCreate: function () {
                $.fancybox.open({
                    href: 'edit.html',
                    type: 'iframe',
                    padding: 5,
                    width: '80%',
                    height: '80%'
                });
            },
            //查詢
            doSearch: function () {
                var datatable = this.variables.datatable;
                datatable.ajax.reload();
            },
            //啓動一個job
            doStart: function (id) {
                var slef = this;
                $("#fullScreenLoading").show(function() {
                    var datatable = slef.variables.datatable;
                    axios.put(basePath + '/sch/ctrl/start/' + id).then(function (response) {
                        slef.showResult(response);
                        $("#fullScreenLoading").hide();
                        datatable.ajax.reload();
                    }).catch(function (error) {
                        console.log(error);
                        $("#fullScreenLoading").hide();
                    });
                })
            },
            //暫停一個job
            doPause: function (id) {
                var slef = this;
                $("#fullScreenLoading").show(function() {
                    var datatable = slef.variables.datatable;
                    axios.put(basePath + '/sch/ctrl/pause/' + id).then(function (response) {
                        slef.showResult(response);
                        $("#fullScreenLoading").hide();
                        datatable.ajax.reload();
                    }).catch(function (error) {
                        console.log(error);
                        $("#fullScreenLoading").hide();
                    });
                })
            },
            //恢復一個job
            doResume: function (id) {
                var slef = this;
                $("#fullScreenLoading").show(function() {
                    var datatable = slef.variables.datatable;
                    axios.put(basePath + '/sch/ctrl/resume/' + id).then(function (response) {
                        slef.showResult(response);
                        $("#fullScreenLoading").hide();
                        datatable.ajax.reload();
                    }).catch(function (error) {
                        console.log(error);
                        $("#fullScreenLoading").hide();
                    });
                })
            },
            //立即運行一個Job
            doRunOnce: function (id) {
                var slef = this;
                $("#fullScreenLoading").show(function() {
                    var datatable = slef.variables.datatable;
                    axios.put(basePath + '/sch/ctrl/runOnce/' + id).then(function (response) {
                        slef.showResult(response);
                        $("#fullScreenLoading").hide();
                        datatable.ajax.reload();
                    }).catch(function (error) {
                        console.log(error);
                        $("#fullScreenLoading").hide();
                    });
                })
            },
            //重啓一個job
            doRestart: function (id) {
                var slef = this;
                var datatable = slef.variables.datatable;
                $("#fullScreenLoading").show(function() {
                    axios.put(basePath + '/sch/ctrl/restart/' + id).then(function (response) {
                        slef.showResult(response);
                        $("#fullScreenLoading").hide();
                        datatable.ajax.reload();
                    }).catch(function (error) {
                        console.log(error);
                        $("#fullScreenLoading").hide();
                    });
                })
            },
            //操作結果提示
            showResult: function (result) {
                $.showResult(result);
            },
            //關閉fancybox
            closeFancybox: function () {
                $.fancybox.close();
            }


        });
        controller.init();

        //如果有子窗口調用父窗口必須加入下面這句，子窗口調用父窗口使用 parent.controller.methodName
        window.controller = controller;
    });