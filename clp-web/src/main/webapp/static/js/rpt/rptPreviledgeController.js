require(
        [ 'jquery', 'atosBaseController', 'moment.config', 'axios', 'atosUtil', 'axios.config', 'jquery.config',
                'datatables', 'datatables.config', 'fancybox', 'fancybox.config', 'Noty', 'noty.config', 'select2',
                'select2.config' ],
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
                            atosUtil.getI18nByModules('global', function() {
                                self.initDatatables();
                            });
                        },
                        initDatatables : function() {
                            this.variables.datatable = $('#table-rptMaster')
                                    .DataTable(
                                            {
                                                serverSide : true,
                                                processing : true,
                                                ajax : {
                                                    url : basePath + "/rpt/master/getRptPreviledgePage",
                                                    type : "POST",
                                                    data : function(data, settings) {
                                                        var formData = {funcCode : vModel.rptPreviledge};
                                                        return JSON.stringify($.extend({}, data, formData));
                                                    },
                                                    contentType : "application/json; charset=utf-8",
                                                    dataType : "json"
                                                },
                                                columns : [ {
                                                    "data" : "funcCode",
                                                }, {
                                                    "data" : "funcDesc",
                                                }, {
                                                    "data" : "moduleName",
                                                }],
                                                
                                            });

                        },
                        // 操作提醒
                        showResult : function showResult(result) {
                            $.showResult(result);
                        },

                    });
            controller.init();
            window.controller = controller;
        });
