/**
 * DLS全局配置.
 */
define([ 'jquery', 'atosUtil' ], function($, atosUtil) {
    'use strict'; // 使用JS嚴格模式.

    var controller = function(baseController, childrenController) {
        $(window).keydown( function(e) {
            var key = window.event ? e.keyCode : e.which;
            if (typeof(key) != 'undefined' && key.toString() == '13') {
                return false;
            }
        });

        if (childrenController) {
            childrenController.handleNextStep = handleNextStep;
            childrenController.handlePreviousStep = handlePreviousStep;
        }
        return $.extend({}, baseController, childrenController);
    };
    
    
    var handleNextStep = function(params) {
        console.log('nextUrlLink: ' + params.nextUrlLink);
        atosUtil.showLoading();
        location.href = params.nextUrlLink;
    }

    var handlePreviousStep = function(params) {
        console.log('previousUrlLink: ' + params.previousUrlLink);
        atosUtil.showLoading();
        location.href = params.previousUrlLink;
    }
    
    return controller;
});
