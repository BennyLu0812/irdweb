/**
 * 考試日曆查詢控制器.
 * @param $
 * @param atosBaseController
 * @param momentConfig
 * @param axios
 * @returns
 */
require([ 
    'jquery', 
    'atosBaseController',
    'Vue',
    'moment',
    'moment.config', 
    'axios', 
    'atosUtil',
    'jquery.config', 
    'axios.config', 
    'datatables',
    'datatables.config', 
    'fancybox',
    'fancybox.config', 
    'vueSelect2',
    'select2',
    'select2.config',
    'bootstrapValidator',
    'bootstrapValidator.config',
    'datetimepicker.config',
    'datetimepicker.i18n.zh_TW'
    ],
    function($, atosBaseController, Vue, moment, momentConfig,axios, atosUtil) {

    'use strict'; // 使用JS嚴格模式.
    
      var controller = atosBaseController(momentConfig, {
            //統一定義變量.
            variables : {
                vue : null,
                datatable : null,
                temp:{},
                exlAdjustCalendarValiCurrentDate:null,
                exlExamTypeTMaxQuota:null,
                exlExamTypeAMaxQuota:null,
                exlExamminerNoraml:null,
                exlExamminerMax:null,
                exlScaleA:null,
                exlScaleB:null,
                exlScaleC:null,
                exlScaleD:null,
                exlScaleE:null,
                tempMap : null,
                tempArr : null,
                flag : null,
                row : null,
                nowDate : null,
                mondayFlag : null,
                sundayFlag : null,
                quotaCalendarMap : null,
                monQuotaOld : null,
                tueQuotaOld : null,
                wedQuotaOld : null,
                thuQuotaOld : null,
                friQuotaOld : null,
                satQuotaOld : null,
                sunQuotaOld : null,
                weekDay : null,
                examTypeConditions:null,
                quotaTypeConditions:null,
                examSessionConditions:null,
            },
            params:{

            },
            init : function() {
                var that= this;
                atosUtil.getI18nByModules('global, enum, exl', function() {
                    that.initVue();
                    that.bindEvent();
                });
            },

            /**
             * 初始化Vue.
             */
            initVue: function () {
                this.vue = new Vue({
                    el: '#app',
                    data: {
                        quotaTypeOptions: [{"id":"1","text":"北區驗車中心"},{"id":"2","text":"南區驗車中心"}],
                        examSessionOptions: [{"id":"1","text":"區域統計"},{"id":"2","text":"狀態統計"}]
                    },
                    mounted: function () {

                    },
                    methods: {

                    }
                });
            },
            bindEvent : function(){
                $("#btn-search").bind("click", this.onQueryEvent.bind(this)); //查询
                $("#btn-reset").bind("click", this.onResetEvent.bind(this)); //重置
            },
            onQueryEvent: function () {

                var quotaType2=$("#quotaType2").val();
                if(quotaType2 == 1){
                    $("#content-div3").show();
                    $("#content-div").show();
                    $("#content-div4").hide();
                    $("#content-div2").hide();
                }else if(quotaType2 == 2){
                    $("#content-div3").hide();
                    $("#content-div").hide();
                    $("#content-div4").show();
                    $("#content-div2").show();
                }else{
                    $("#content-div3").show();
                    $("#content-div").hide();
                    $("#content-div4").show();
                    $("#content-div2").hide();
                }
            },
            /**
            * 清空查詢條件
            */
            onResetEvent: function () {
              $("#quotaType").val("").trigger("change");
              $("#quotaType2").val("").trigger("change");
            },

      });
      controller.init();
      window.controller = controller;
});

