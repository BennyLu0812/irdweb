/**
 * jquery全局配置.
 */
define([ 'jquery' ], function($) {
    
    'use strict'; // 使用JS嚴格模式.
    
    $.fn.extend({
        // 將表單序列化為以name為key,value為值的js對象. {name:value,name1:value1,name2:value2}
        serializeObject : function() {
            var obj = {};
            var arr = this.serializeArray();
            $.each(arr, function() {
                if (obj[this.name] !== undefined) {
                    if (!obj[this.name].push) {
                        obj[this.name] = [ obj[this.name] ];
                    }
                    obj[this.name].push(this.value || '');
                } else {
                    obj[this.name] = this.value || '';
                }
            });
            return obj;
        }
    });
});
