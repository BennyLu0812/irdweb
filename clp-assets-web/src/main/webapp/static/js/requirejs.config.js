/**
 * require config配置.2019051603
 */
'use strict'; //使用JS嚴格模式.

require.config({
    
    urlArgs: 'v=${buildTime}', //DLS的項目啓動會-重要時刻.
    baseUrl: '${web-prefix}/assets/bower',
    paths : {
        jquery: 'jquery/jquery.min',
        'jquery.config': '../static/js/jquery.config',
        jqueryUi: 'jquery-ui-1.11.4.custom/jquery-ui.min',
        jqueryQrcode: 'jquery-qrCode/jquery.qrcode.min',

        bootstrap: 'bootstrap/js/bootstrap.min',
        bootstrapValidator: 'bootstrapValidator/js/bootstrapValidator.min',
        'bootstrapValidator.i18n.en': 'bootstrapValidator/js/language/en_US',
        'bootstrapValidator.i18n.pt': 'bootstrapValidator/js/language/pt_PT',
        'bootstrapValidator.i18n.zh_TW': 'bootstrapValidator/js/language/zh_TW',
        'bootstrapValidator.config': '../static/js/bootstrapValidator.config',
        
        atosUtil : '../static/js/atos.util',
        'jsonViewer' : '../static/js/jquery.json-viewer',
        formUtil : '../static/js/form.util',
        axios: 'axios/axios.min',
        'axios.config': '../static/js/axios.config',
        
        datetimepicker: 'bootstrap-datetimepicker/js/bootstrap-datetimepicker.min',
        'datetimepicker.i18n.en': 'bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.en',
        'datetimepicker.i18n.pt': 'bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.pt',
        'datetimepicker.i18n.zh_TW': 'bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-TW',
        'datetimepicker.config': '../static/js/datetimepicker.config',
        
        'datatables.net': 'datatables.net/jquery.dataTables.min',
        'datatables.select': 'datatables.net/select/js/dataTables.select.min',
        datatables: 'datatables.net/bootstrap/js/dataTables.bootstrap.min',
        'datatables.i18n.en': 'datatables.net/i18n/en',
        'datatables.i18n.pt': 'datatables.net/i18n/pt',
        'datatables.i18n.zh_TW': 'datatables.net/i18n/zh_TW',
        'datatables.config': '../static/js/datatables.config',
        
        fancybox: 'fancybox/source/jquery.fancybox.pack',
        'fancybox.config': '../static/js/fancybox.config',
        
        moment: 'moment/moment.min',
        'moment.config': '../static/js/moment.config',
        
        Noty: 'noty/noty',
        'noty.config': '../static/js/noty.config',
        
        select2: 'select2/js/select2.full.min',
        'select2.i18n.en': 'select2/js/i18n/en',
        'select2.i18n.pt': 'select2/js/i18n/pt',
        'select2.i18n.zh_TW': 'select2/js/i18n/zh-TW',
        'select2.config': '../static/js/select2.config',
        
        Vue: 'vue/vue.min',
        vueSelect2:'vue/select/vue-select2',
        vueloader:'vue/vue.require.loader',
        pdmInfo:'vue/componets/pdm-info',
        authDialog:'vue/componets/authDialog',
        licTxnInfo:'vue/componets/license/licTxnInfo',
        licTxnAecInfo:'vue/componets/license/licTxnAecInfo',
        licenseInfo:'vue/componets/license/licenseInfo',
        foreignLicInfo:'vue/componets/license/foreignLicInfo',
        pdmSectionInfo:'vue/componets/pdm/pdmSectionInfo',
        licHealthCert:'vue/componets/license/licHealthCert',
        licSubstitute:'vue/componets/license/licSubstitute',
        licSectionInfo:'vue/componets/license/licSectionInfo',
        licRestriction:'vue/componets/license/restriction/licRestriction',
        licRestrictionBE:'vue/componets/license/restriction/licRestrictionBE',
        licCat:'vue/componets/license/licCat/licCat',
        licComp:'vue/componets/license/lce/compInfo',


        otherShowTabs:'vue/componets/exl/exlOtherShowInfoTabs',
        examinerPhoto:'vue/componets/exl/examinerPhoto',
        examGearboxTypeCheck: 'vue/componets/exl/gearboxTypeCheck',
        
        iview: 'iview/iview.min',
        tinyImgUpload: 'tinyImgUpload/js/tinyImgUpload.requirejs',
        
        
        pdmAddress:'vue/componets/pdm/pdmAddress',
        pdmCertInfo:'vue/componets/pdm/pdmCertInfo',
        pdmCautionCertInfo:'vue/componets/pdm/pdmCautionCertInfo',
        pdmTemporaryCertInfo:'vue/componets/pdm/pdmTemporaryCertInfo',
        pdmMasterInfo:'vue/componets/pdm/pdmMasterInfo',
        pdmCertInfoPhotoList:'vue/componets/pdm/pdmCertInfoPhotoList',
        pdmDriverDetail:'vue/componets/pdm/pdmDriverDetail',

        'vue.config' : '../static/js/vue.config',
        uiTabs:'vue/componets/common/UITabs',
        I18nPlugin: '../static/js/vue/plugin/I18nPlugin',

        atosBaseController: '../static/js/atosBaseController',
        
        'bootstrap-dialog': 'bootstrap3-dialog-master/js/bootstrap-dialog',
        
        jsrender: '../bower/jsrender/jsrender',
        fileinput: 'Bootstrap-fileinput-4.3.2/js/fileinput.min',
        echarts: '../bower/echarts/echarts.min',

        fullcalendar: '../bower/fullcalendar/js/fullcalendar.min',
        'fullcalendar.zh': '../bower/fullcalendar/js/locale/zh-tw',
        'fullcalendar.pt': '../bower/fullcalendar/js/locale/pt',

        base64: 'jquery/jquery.base64'
    },
    shim: {
        'fullcalendar.zh': {
            deps: [
                'fullcalendar'
            ]
        },
        bootstrapValidator: {
            deps: [
                'bootstrap'
            ]
        },
        bootstrap: {
            deps: [
                'jquery'
            ]
        },
        datatables: {
            deps: [
                'jquery',
                'bootstrap',
                'datatables.net',
                'datatables.select'
            ]
        },
        'datatables.i18n.en': {
            deps: [
                'datatables'
            ]
        },
        'datatables.i18n.pt': {
            deps: [
                'datatables'
            ]
        },
        'datatables.i18n.zh_TW': {
            deps: [
                'datatables'
            ]
        },
        iview: {
            deps: [
                'Vue',
                
            ]
        },
        Noty: {
            deps: [
                'jquery'
            ]
        },
        fancybox: {
            deps: [
                'jquery'
            ]
        },
        'select2.i18n.en':{
            deps: [
                'select2'
            ]
        },
        'select2.i18n.pt':{
            deps: [
                'select2'
            ]
        },
        'select2.i18n.zh_TW':{
            deps: [
                'select2'
            ]
        },
        'bootstrapValidator.i18n.en': {
            deps: [
                'bootstrapValidator'
            ]
        },
        'bootstrapValidator.i18n.pt': {
            deps: [
                'bootstrapValidator'
            ]
        },
        'bootstrapValidator.i18n.zh_TW': {
            deps: [
                'bootstrapValidator'
            ]
        },
        'datetimepicker.i18n.en': {
            deps: [
                'datetimepicker'
            ]
        },
        'datetimepicker.i18n.pt': {
            deps: [
                'datetimepicker'
            ]
        },
        'datetimepicker.i18n.zh_TW': {
            deps: [
                'datetimepicker'
            ]
        },
        'bootstrap-dialog':{
            deps: [
                'jquery','bootstrap'
            ]
        },
        echarts:{
            deps: [
                'jquery'
            ]
        },
        fullcalendar: {
            deps: [
                'moment',
                'jquery'
            ]
        }
    }
});