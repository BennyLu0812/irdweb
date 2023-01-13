/**
 * 
 * jobCtrlController.js
 */
require([
    'jquery',
    'atosBaseController',
    'moment.config',
    'Vue',
    'axios',
    'axios.config',
    'jquery.config',
    'datatables',
    'datatables.config'
],
    function ($, atosBaseController, momentConfig, Vue, axios) {

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

                }
            },
            init: function () {
                this.initVue();
                this.initDatatables();
            },
            initDatatables: function () {
                var self = this;
                $('#table').DataTable({
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
                                return '<span>处理中</span>';
                            } else if (data == 'COMPLETE') {
                                return '<span>完成</span>';
                            } else if (data == 'FAILED') {
                                return '<span>失敗</span>';
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
