/**
 * selecr2 config配置.
 */
define([ 'jquery', 'select2.i18n.' + _LANGUAGE ], function($) {
    'use strict'; //使用JS嚴格模式.
    
    /**
     * 支持  $.fn.select2.defaults.set("language", "zh-TW");
     * 不支持 $.fn.select2.defaults.set("language", "zh_TW");
     */
    var language = _LANGUAGE;
    if(_LANGUAGE.indexOf('_') > 0) {
        var languageParts = _LANGUAGE.split('_');
        language = languageParts[0] + "-" + languageParts[1];
    }    
    // 如果是中文開頭的，默認轉爲繁體。
    if (language.indexOf('zh') != -1) {
        language = "zh-TW";
    }
    
    // 全局默認配置
    $.fn.select2.defaults.set("language", language);
    $.fn.select2.defaults.set("width", "100%");
    $.fn.select2.defaults.set('tags', false);
    $.fn.select2.defaults.set('multiple', false);
    $.fn.select2.defaults.set('allowClear', true);
    $.fn.select2.defaults.set('minimumInputLength', 0);
    $.fn.select2.defaults.set('theme', 'bootstrap');
    $.fn.select2.defaults.set('placeholder', '請選擇...');

    //如果在modal窗下使用select2，解決IE下無法切換輸入法的問題
    if ($.fn.modal) {
        $.fn.modal.Constructor.prototype.enforceFocus = function() {};
    }

    $.fn.select2Remote = function (options) {
        var opts = $.extend({}, $.fn.select2Remote.defaults, options);
        return this.select2({
            ajax: {
                url: opts.url,
                type: opts.type,
                data: opts.data,
                delay: opts.delay,
                cache: opts.cache,
                dataType: opts.dataType,
                processResults: opts.processResults
            },
            multiple:opts.multiple,
            placeholder:opts.placeholder,
            escapeMarkup: opts.escapeMarkup,
            templateResult: opts.templateResult,
            templateSelection: opts.templateSelection,
            minimumInputLength: opts.minimumInputLength
        });
    };
    
    
    $.fn.select2Remote.defaults = {
            url: '',
            delay: 250,
            cache: true,
            type: 'GET',
            dataType: 'json',
            data: function (params) {
                return {
                    'codeType': $(this).attr('data-codeType') || $(this).attr('sys-code-type') || params.codeType || ''  ,
                    'keyword': params && params.term? ($(this).attr("codeTypeFilter") == 'true')? params.term+'%':'%' + params.term + '%' : '',
                    'pageNumber': params.page || 1,
                    'codeTypeFilter':$(this).attr("codeTypeFilter"),
                    'includeCancel':$(this).attr("includeCancel"),
                    'filterCodeKeys' : $(this).attr('filter-code-keys'),
                    'codeId':$(this).attr('codeId'),
                    'licCatType':$(this).attr('licCatType'),
                    'coachLicStatus':$(this).attr('coachLicStatus'),
                    'qualifyStatus':$(this).attr('qualifyStatus'),
                    'initCoachId':$(this).attr('initCoachId'), 
                    'pageSize': 30
                };
            },
            processResults: function (data, params) {
                 var results = [];
                 var tmpData;
                 if((data.data)){
                	 tmpData = data.data;
                 }else{
                	 tmpData = data;                
                 }
                 $.each(tmpData, function(index, obj){
                     var text = obj.text;
                     if(text&&text.length>0){

                     }else{
                         text = obj.description;
                     }
                     // 適應與枚舉類型的數據
                     if (!(obj.id) && (obj.code)) {
     					obj.id = obj.code;
     				 }
                     results.push({id: obj.id, text: text});
                 });

                return {
                    results: results,
                    pagination: {
                        // more: false
                        more: (params.page || 1) * 30 < (data['totalElements'] || 10)
                    }
                };
            },
            escapeMarkup: function (markup) {   // Let custom formatter work
                return markup;
            },
            templateResult: function (repo) {
                return repo.text;
            },
            templateSelection: function (repo) {
                // return repo.id || repo.text;
                return repo.text;
            }
        };

//        $('.simpleselect').select2();
    
//    $('select.select, .sysselect').select2Remote({
//        url: basePath + '/select2/page'
//    });
});
