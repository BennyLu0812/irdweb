/**
 * moment全局配置.
 */
define(['moment'], function (moment) {

    'use strict'; // 使用JS嚴格模式.

    /**
     * exports DLS常用的JS方法.
     * 基礎配置信息.
     */
    var baseConfig = {
        datePattern: 'DD/MM/YYYY',
        timePattern: 'HH:mm:ss',
        datetimePattern: 'DD/MM/YYYY HH:mm:ss',
        timeFormat: 'HH:mm',
        datetimeFormat: 'DD/MM/YYYY HH:mm:ss',
        locale: _LANGUAGE,

        dateTimeFormat: function (dateTime, sourceFormat, targetFormat) {
            if (!dateTime) {
                return '';
            }
            sourceFormat = sourceFormat || this.datetimePattern;
            targetFormat = targetFormat || this.datetimeFormat;
            return moment(dateTime, sourceFormat).format(targetFormat);
        },
        dateFormat: function (dateTime, sourceFormat, targetFormat) {
            if (!dateTime) {
                return '';
            }
            sourceFormat = sourceFormat || this.datePattern;
            targetFormat = targetFormat || this.datePattern;
            return moment(dateTime, sourceFormat).format(targetFormat);
        },
        currentDate: function (targetFormat) {
            targetFormat = targetFormat || this.datePattern;
            return moment().startOf('day').format(targetFormat);
        },
        dateFormatToString: function (dateTime, targetFormat) {
            if (!dateTime) {
                return '';
            }
            targetFormat = targetFormat || this.datetimePattern;
            return moment(dateTime).format(targetFormat);
        },
        defaultFormat: function(){
            Date.prototype.format = function (fmt) {
                var o = {
                    "M+": this.getMonth() + 1,                 //月份 
                    "d+": this.getDate(),                    //日 
                    "h+": this.getHours(),                   //小时 
                    "m+": this.getMinutes(),                 //分 
                    "s+": this.getSeconds(),                 //秒 
                    "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
                    "S": this.getMilliseconds()             //毫秒 
                };
                if (/(y+)/.test(fmt)) {
                    fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
                }
                for (var k in o) {
                    if (new RegExp("(" + k + ")").test(fmt)) {
                        fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
                    }
                }
                return fmt;
            }
        },
        isBeforeCurrentDate : function(dateTime){
            return moment().isBefore(dateTime);
        }
    };

    //注入默認的format
    baseConfig.defaultFormat();

    return baseConfig;

});
