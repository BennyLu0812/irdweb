/**
 * noty全局配置.
 */
define(['jquery', 'Noty', 'fancybox', 'fancybox.config'], function ($,Noty) {

    'use strict'; // 使用JS嚴格模式.

    // 打印logger.
    var logger = function (msg) {
        console.log(msg);
    };

    // 彈出登陸窗口.
    var loginWindow = function (loginUrl) {
        $.fancybox.open({
            href: loginUrl,
            type: 'iframe',
            padding: '15px',
            width: '60%',
            height: '60%'
        });
    };


    String.format = function() {
    	if (arguments.length == 0) {
    		return null;
    	}
    	var str = arguments[0];
    	for (var i = 1; i < arguments.length; i++) {
    		var reg = new RegExp('\\{' + (i - 1) + '\\}', 'gm');
    		str = str.replace(reg, arguments[i]);
    	}
    	return str;
    };

    $.extend({
        showResult: function (result,timeout) {
            if (!timeout) {
                timeout = 3000;
            }
            switch (result.status) {
                case 200:
                    $.message(String.format('<p><strong>提示信息: 操作成功！</strong></p><p>{0}</p>', (result['errorMsg'] || '')),
                        true);
                    break;
                case 401:
                    $.message(String.format('<p><strong>提示信息: 操作失敗！</strong></p><p>{0}</p>',
                        ((result['errorMsg'] + '，3秒後將跳轉到CAS登錄頁面.') || '未登录')), false,timeout);
                    // 3秒后跳轉.
                    setTimeout(function () {
                        loginWindow(result.redirectUrl);
                    }, 3 * 1000);
                    logger(result);
                    logger(result['sysErrorMsg'])
                    break;
                case 403:
                    $.message(String.format('<p><strong>提示信息: 操作失敗！</strong></p><p>{0}</p>',
                        (result['errorMsg'] || '功能未授權')), false,timeout);
                    logger(result);
                    logger(result['sysErrorMsg'])
                    break
                case 500:
                	if (result.responseText){
                		$.message(String.format('<p><strong>提示信息: 操作失敗！</strong></p><p>錯誤代碼: {0}</p><p>錯誤消息: {1}</p>',
                				result.responseJSON.errorCode || '9999', result.responseJSON.errorMsg || result.responseJSON.arguments ||'未知異常'), false,timeout);
                		logger(result);
                		logger(result.responseJSON.errorCode);
                	}else {
	                    $.message(String.format('<p><strong>提示信息: 操作失敗！</strong></p><p>錯誤代碼: {0}</p><p>錯誤消息: {1}</p>',
	                        result['errorCode'] || '9999', result['errorMsg'] || '未知異常'), false,timeout);
	                    logger(result);
	                    logger(result['sysErrorMsg'])
                	}
                    break;
                default:
                    $.message(String.format('<p><strong>提示信息: 操作失敗！</strong></p><p>錯誤代碼: {0}</p><p>錯誤消息: {1}</p>',
                        result['errorCode'] || '9999', result['errorMsg'] || '未知異常'), false,timeout);
                    logger(result);
                    logger(result['sysErrorMsg'])
            }

        },
        message: function (msg, success, seconds) {
            if (typeof success !== 'boolean') {
                success = true;
            }
            var timeout = 3000;
            if (seconds != null)
                timeout = seconds;
            if (success) {
                // 使用Noty彈框.
                new Noty({
                    text: msg,
                    type: 'success',
                    layout: 'bottomRight',
                    modal: false,
                    timeout: timeout,
                    theme: "relax"
                }).show();
            } else {
                new Noty({
                    text: msg,
                    type: 'error',
                    layout: 'bottomRight',
                    modal: false,
                    timeout: false
                }).show();
            }
        },
        confirm: function (options, callback,callback2) {
            var opts = options || {};
            var icon = '';//'<i class="fa fa-info-circle" aria-hidden="true"></i>';
            var title = opts.title ? opts.title : '確認提示';
            var text = String.format('{0} <strong class="h4">{1}：</strong><br><br><strong class="h5">{2}</strong><br><br>', icon, title, opts.text || '');
            var n = new Noty({
                text: text,
                type: 'alert',
                layout: 'topCenter',
                modal: true,
                theme: 'relax',
                buttons: [
                    Noty.button(opts.btnOk ? opts.btnOk : '確 定',
                        'btn btn-primary btn-sm pull-right', function () {
                            if ($(this).attr("disabled")) return;// 防止连击发多次请求
                            n.close();
                            $(this).attr("disabled",true);
                            if (typeof opts.success === 'function') {
                                opts.success('ok');
                            }
                            if(typeof callback === 'function') {
                                callback(true);
                            }
                        }, { style: 'margin-left:15px;' }),

                    Noty.button(opts.btnCancel ? opts.btnCancel : '取 消',
                        opts.btnCancelCss ? opts.btnCancelCss:'btn btn-default btn-sm pull-right', function () {
                            if ($(this).attr("disabled")) return; // 防止连击发多次请求
                            n.close();
                            $(this).attr("disabled",true);
                            if (typeof opts.success === 'function') {
                                opts.success('cancel');
                            }
                            if(typeof callback2 === 'function') {
                                callback2(true);
                            }
                        }, { style: 'margin-left:15px;' })
                ],
                closeWith: []
            }).show();
        },
        alert: function (options, callback) {
            var opts = options || {};
            if(typeof(opts.timeout) == 'undefined'||opts.timeout==true){
                opts.timeout = 3000;
            }
            var icon = '';
            var title = opts.title ? opts.title : '提示信息';
            var text = String.format('{0} <strong class="h6">{1}：<br> {2}</strong>', icon, title, opts.text || '');
            var n = new Noty({
                text: text,
                type: 'alert',
                timeout:opts.timeout,
                layout: 'topCenter',
                modal: false,
                theme: 'relax',
                buttons: [
                    Noty.button(opts.btnOk ? opts.btnOk : '確 定',
                        'btn btn-primary btn-sm pull-right', function () {
                            n.close();
                            if (typeof opts.success === 'function') {
                                opts.success('ok');
                            }
                            if(typeof callback === 'function') {
                                callback(true);
                            }
                        }, { style: 'margin-left:auto;' }),
                   
                ],
                closeWith: []
            }).show();
        }
        ,
        processing: function (msg) {
            var noty = new Noty({
                text: String.format('<i class="fa fa-spinner fa-spin fa-2x"></i> {0}', msg || '正在處理中...'),
                type: 'alert',
                layout: 'center',
                progressBar: true,
                theme: 'mint',
                closeWith: []
            });
            noty.show();
            return noty;
        }

    });

});
