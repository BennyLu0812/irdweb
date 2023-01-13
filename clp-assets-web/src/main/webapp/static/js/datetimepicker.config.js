define([
    'jquery',
    'bootstrap',
    'datetimepicker',
    'datetimepicker.i18n.' + _LANGUAGE
], function ($) {

    'use strict'; // 使用JS嚴格模式.

    /**
     * 支持  $.fn.datetimepicker.defaults.set("language", "zh-TW");
     * 不支持 $.fn.datetimepicker.defaults.set("language", "zh_TW");
     */
    var language = _LANGUAGE;
    if (_LANGUAGE.indexOf('_') > 0) {
        var languageParts = _LANGUAGE.split('_');
        language = languageParts[0] + "-" + languageParts[1];
    }
    var date1900 = new Date();
    date1900.setFullYear(1900,0,1);
    var date9999 = new Date();
    date9999.setFullYear(9999,11,31);

    $.fn.datetimepicker.defaults = {
        language: language,
        autoclose: true,
        format: 'dd/mm/yyyy',
        minView: 2,
        maxView: 4,
        todayBtn: true,
        todayHighlight: true,
        startView: 2,
        clearBtn:true,//清除按钮
        placeholder: 'DD/MM/YYYY',
        startDate : date1900,
        endDate : date9999
    }
    
//    $('[data-provide="datepicker"]').datetimepicker({
//        format: 'dd/mm/yyyy'
//    }).attr('placeholder', 'DD/MM/YYYY'); 
});

