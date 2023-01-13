(function(factory) {

    if (typeof module === "object" && typeof module.exports === "object") {
        module.exports = factory();
    } else {
        factory();
    }
}(function() {

    'use strict';

    var i18n = {
        "processing" : "處理中...",
        "loadingRecords" : "載入中...",
        "lengthMenu" : "顯示 _MENU_ 項結果",
        "zeroRecords" : "暫無數據",
        "info" : "顯示第 _START_ 至 _END_ 項結果，共 _TOTAL_ 項",
        "infoEmpty" : "顯示第 0 至 0 項結果，共 0 項",
        "infoFiltered" : "(從 _MAX_ 項結果中過濾)",
        "infoPostFix" : "",
        "search" : "過濾:",
        "paginate" : {
            "first" : "第一頁",
            "previous" : "上一頁",
            "next" : "下一頁",
            "last" : "最後一頁"
        },
        "aria" : {
            "sortAscending" : ": 升冪排列",
            "sortDescending" : ": 降冪排列"
        },
        "sEmptyTable" : "暫無數據",
        "select" : {
            "rows" : {
                "_" : "已選 %d 行",
                "0" : "",
                "1" : "已選 1 行"
            }
        }
    };

    if (typeof define === "function" && define.amd) {
        define([], function() {
            return i18n;
        });
    }

    return i18n;
}));
