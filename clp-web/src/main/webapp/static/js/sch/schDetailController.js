/**
 * 
 * jobCtrlController.js
 */
require([
    'jquery',
    'atosBaseController',
    'atosUtil',
    'moment.config',
    'Vue',
    'axios',
    'axios.config',
    'jquery.config',
    'datatables',
    'datatables.config'
],
    function ($, atosBaseController, atosUtil, momentConfig, Vue, axios) {

        'use strict'; // 使用JS嚴格模式.

        var controller = atosBaseController(momentConfig, {
            variables : {
                schCtrl: {
                    id: vModel.id,
                    sysCode: "",
                    jobUse: "",
                    jobCode: "",
                    cronChar: "",
                    clsName: "",
                    isSync: "",
                    jobType: "",
                    dataDir: "",
                    dataDays: "",
                    enabled: ""

                },
                i18n: {}
            },
            init: function () {
                var self = this;
                atosUtil.getI18nByModules('sys, sch',function (result) {
                    self.variables.i18n = result;
                    self.initVue();
                    self.initDatatables();
                });
            },
            initDatatables: function () {
                var self = this;
                $('#jobDetailTable').DataTable({
                    serverSide: true,
                    processing: true,
                    paging: true,
                    info: false,
                    ajax: {
                        url: basePath + "/sch/ctrl/log/by/jobCtrlId",
                        type: "POST",
                        contentType: "application/json; charset=utf-8",
                        data: function (data, settings) {
                            return JSON.stringify($.extend({}, data, controller.variables.schCtrl));
                        },
                        dataType: "json"
                    },
                    select: {
                        style: 'single',
                        selector: 'td'
                    },
                    columns: [{
                        data: 'jobCode'
                    }, {
                        data: 'recProcessed'
                    }, {
                        data: 'recPending'
                    }, {
                        data: 'startTimeDesc'
                    }, {
                        data: 'endTimeDesc'
                    }, {
                        data: 'status',
                        render: function (data, type, row) {
                            var workStatusText;
                            if (data == 'PROGRESS') {
                                workStatusText = self.variables.i18n['jobCtrlLog.status.progress'];
                            } else if (data == 'COMPLETE') {
                                workStatusText = self.variables.i18n['jobCtrlLog.status.complete'];
                            } else if (data == 'FAILED') {
                                workStatusText = self.variables.i18n['jobCtrlLog.status.failed'];
                            } else {
                                workStatusText = '--';
                            }
                            return '<span>' + workStatusText + '</span>';
                        }
                    }]
                });
            },
            initVue: function () {
                var self = this;
                this.vue = new Vue({
                    el: '#app',
                    data: {
                        schCtrl: {
                            id: vModel.id,
                            sysCode: "",
                            jobUse: "",
                            jobCode: "",
                            cronChar: "",
                            clsName: "",
                            isSync: "",
                            jobType: "",
                            dataDir: "",
                            dataDays: "",
                            enabled: ""

                        }
                    },
                    created: function () {
                        var self = this;
                        if (self.schCtrl.id)
                            axios.get(basePath + '/sch/ctrl/' + self.schCtrl.id).then(function (response) {
                                self.schCtrl = response;
                            });
                    },
                    methods: {
                        doBack : function(){
                            window.history.go(-1);
                        },
                    }
                });
            }
        });

        controller.init();

    });
