/**
 * bootstrapValidator全局配置.
 */
define(['jquery', 'bootstrap', 'bootstrapValidator', 'bootstrapValidator.i18n.' + _LANGUAGE], function ($) {

    'use strict'; // 使用JS嚴格模式.

    $(':input.form-control').closest('.form-group, [class*="col-"]').addClass('form-validator');
    $("v-select").closest('.form-group, [class*="col-"]').addClass('form-validator');
    $.fn.bootstrapValidator.DEFAULT_OPTIONS = $.extend({}, $.fn.bootstrapValidator.DEFAULT_OPTIONS, {
        group: '.form-validator',
        verbose: false,
        container: null,
        /**
         *  指定不验证的情况
         *  值可设置为以下三种类型：
         *  1、String  ':disabled, :hidden, :not(:visible)'
         *  2、Array  默认值  [':disabled', ':hidden', ':not(:visible)']
         *  3、带回调函数  
             [':disabled', ':hidden', function($field, validator) {
                 // $field 当前验证字段dom节点
                // validator 验证实例对象 
                // 可以再次自定义不要验证的规则
                // 必须要return，return true or false; 
                return !$field.is(':visible');
            }]
        */
        excluded: [':disabled', ':hidden', ':not(:visible)'],
        /**
         * 为每个字段指定通用错误提示语
         */
        message: '請輸入有效的值',
        /**
         * 指定验证后验证字段的提示字体图标。（默认是bootstrap风格）
         * Bootstrap 版本 >= 3.1.0
         * 也可以使用任何自定义风格，只要引入好相关的字体文件即可
         * 默认样式 
             .form-horizontal .has-feedback .form-control-feedback {
                 top: 0;
                right: 15px;
            }
        * 自定义该样式覆盖默认样式
            .form-horizontal .has-feedback .form-control-feedback {
                top: 0;
                right: -15px;
            }
            .form-horizontal .has-feedback .input-group .form-control-feedback {
                top: 0;
                right: -30px;
            }
        */
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        /**
         * 生效规则（三选一）
         * enabled 字段值有变化就触发验证
         * disabled,submitted 当点击提交时验证并展示错误信息
         */
        live: 'enabled'
    });

    
    $.extend({
        formValidator : function (form) {
            var $validator = $(form).data('bootstrapValidator');
            if(!$validator) {
                return false;
            }
            var isValid = $validator.validate().isValid();
            if (!isValid) {
                $('.has-error:first :input').focus();
            }
            return isValid;
        },
        isExistAsValid : function(data){
            var isValid = '${isValid}'.split(",");
            for(var i=0;i<isValid.length;i++){
                if(isValid[i] === data){
                    return false;
                }
            }
            return true;
        }
    });
    
    $('.form-control.required').each(function(){
        $('label.control-label[for="'+this.id+'"]').addClass('control-label-required');
    });
});


