/**
 * dataTable全局配置.
 */
define([ 'jquery', 'datatables', 'datatables.i18n.' + _LANGUAGE ], function($, datatables, language) {

    'use strict'; // 使用JS嚴格模式.
    
    // datatables
    $.extend($.fn.dataTable.defaults, {
        serverSide : false,
        paging : true,
        lengthChange : false,
        pagingType : 'full_numbers', // numbers|simple|simple_numbers|full|full_numbers
        dom: '<"top">rt<"bottom"<"col-sm-5"i><"col-sm-7"p>>',
        //lengthMenu : [ 10, 20, 50, 100, 200, 500 ],
        displayStart : 0,
        displayLength : 10,
        ordering : false,
        processing : true,
        searching : false,
        deferRender : true,
        language : language
    });

});
