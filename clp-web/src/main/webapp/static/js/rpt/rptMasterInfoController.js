require([
    'jquery', 
    'atosBaseController',
    'Vue', 
    'axios', 
    'atosUtil', 
    'axios.config', 
    'bootstrap', 
    'select2.config',
    'bootstrapValidator.config',
    'moment.config', 
    'jquery.config', 
    'datatables',
    'datatables.config',
    'fancybox', 
    'fancybox.config', 
    'Noty', 
    'noty.config', 
    'select2' 
], 
function($, atosBaseController, Vue, axios, atosUtil) {
    var controller = atosBaseController({}, {
        // 統一定義變量.
        variables : {
            vue : null,
        },
        init : function() {
            var self = this;
            atosUtil.getI18nByModules('global', function() {
                self.initVue();
            });
        },
        initVue : function() {
            this.vue = new Vue({
                el : '#app',
                data : {
                    rptMaster : {
                        rptId : vModel.rptId
                    },
                    webPrefix: webPrefix
                },
                created : function() {
                    var self = this;
                    $.get(basePath + '/rpt/master/getRptMasterByRptId', {rptId: vModel.rptId}, function (result) {
                        self.rptMaster = result;
                    });
                }
            });

        },
        // 初始化綁定事件
        initEvent : function() {
            var self = this;
        },
        // 操作提醒
        showResult : function showResult(result) {
            $.showResult(result);
        },

    });
    controller.init();
    window.controller = controller;
});
