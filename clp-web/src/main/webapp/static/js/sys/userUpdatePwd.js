

require([
    'jquery', 
    'atosBaseController',
    'atosUtil',
    'Vue',
    'moment.config',
    'axios',
    'axios.config',
    'jquery.config',
    'datatables',
    'datatables.config',
    'fancybox',
    'fancybox.config', 
    'Noty',
    'noty.config',
    'vueSelect2',
    'select2',
    'select2.config',
    'datetimepicker.config',
    'bootstrapValidator.config'
 ],
     function($, atosBaseController, atosUtil, Vue, momentConfig, axios) {
     'use strict';
     atosUtil.getI18nByModules('global, sys,validation');

     var controller = atosBaseController(momentConfig, {
        //統一定義變量.
        variables : {
            datatable : null,
            vue: null,
            userStatus: [],
        },
        params:{
            
        },
        init : function() {
        },

        doUpdate : function() {
            $.fancybox.open({
                href : 'edit.html',
                type : 'iframe',
                padding : 5,
                width : '100%',
                height : '100s%'
            });
        },
		});
	    controller.init();
	    window.controller = controller;
});

