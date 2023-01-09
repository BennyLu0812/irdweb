/**
 * fancybox全局配置.
 */
define(['jquery', 'fancybox'], function ($) {

    'use strict'; // 使用JS嚴格模式.

    // fancybox
    $.extend($.fancybox.defaults, {
        width: 800,
        height: 600,
        minWidth: 100,
        minHeight: 100,
        maxWidth: 9999,
        maxHeight: 9999,
        openEffect: 'none',
        closeEffect: 'none',
        autoSize: false,
        fitToView: false,
        closeClick: false,
        helpers: {
            // 點擊彈出框外空白處窗口不關閉
            overlay: {
                closeClick: false
            },
            title: true
        },
        beforeLoad: $.noop(),
        afterClose: $.noop(),
        afterShow: function () {
            $('.fancybox-skin')
                .append('<a title="Print" id="fancy_print"  href="javascript:;"><i class="glyphicon glyphicon-print"></i></a>')
                .on('click', '#fancy_print', function () {
                    var $iframe = $(this).parent('div.fancybox-skin').find('iframe.fancybox-iframe');
                    if ($iframe.length > 0) { // find iframe and print
                        $iframe.get(0).contentWindow.focus();
                        $iframe.get(0).contentWindow.print();
                    } else { // find and print non iframe item
                       var $content = $(this).parent('div.fancybox-skin').find('div.fancybox-inner');
                        if ($content.length > 0) {
                            var win = window.open('width=' + $(window).width() + ',height=' + $(window).height());
                            win.document.open();
                            win.document.write('<html><head>');
                            win.document.write($('head').html());
                            win.document.write('</head><body>');
                            win.document.write($content.html());
                            win.document.write('</body></html>');
                            win.document.close();
                            win.focus();
                            var printAndClose = function () {
                                if (win.document.readyState == 'complete') {
                                    clearInterval(sched);
                                    win.print();
                                    win.close();
                                }
                            }
                            var sched = setInterval(printAndClose, 200);
                        }
                    }
                });// on

        }// afterShow

    });

    // fancybox
    $('a.fancybox').fancybox({
        afterLoad: function () {
            this.width = $(this.element).data('fancybox-width') || $.fancybox.defaults.width;
            this.height = $(this.element).data('fancybox-height') || $.fancybox.defaults.height;
        }
    });

});
