

require([ 'jquery', 'atosBaseController', 'moment.config','axios', 'atosUtil', 'axios.config', 'jquery.config', 'datatables', 'datatables.config', 'fancybox', 'fancybox.config', 'Noty', 'noty.config' ],
    function($, atosBaseController, momentConfig, axios, atosUtil) {
    'use strict'; // 使用JS嚴格模式.

    var controller = atosBaseController(momentConfig, {
        // 統一定義變量.
        variables : {
            datatable : null
        },
        params:{
            
        },
        init : function() {
        	var self = this;
            atosUtil.getI18nByModules('global, lic', function() {
                self.initEvent();
            });
        },
        // 初始化綁定事件
        initEvent : function() {
            var slef = this;
            var uid = atosUtil.getUrlParam("uid");
            axios.get(
                basePath+"/sys/params/operationCodes"
            ).then(function(response){
                console.log(response);
                if(response != null && response != ''){
                    $.each(response, function(index, obj){
                        $('#content-div').append(
                            '<label class="control-label col-sm-3">'+obj+'</label>'
                        )
                    });
                }
            }).catch(function(error){

            });
            /*$.ajax({
                url:basePath+"/sys/params/operationCodes",
                type:"GET",
                data:{"uid":uid},
                dataType:"json",
                async:false,
                success:function(response){
                    console.log(response);
                    if(response != null && response != ''){
                        $.each(response, function(index, obj){
                            $('#content-div').append(
                                '<label class="control-label col-sm-3">'+obj+'</label>'
                            )
                        });
                    }
                }
            });*/

        },
        // 關閉fancybox
	    closeFancybox : function (){
	        $.fancybox.close();
	    },
        // 操作提醒
        showResult:function (result){
        	$.showResult(result);
        }
	});

    function funcName(){

    };
    
    controller.init();
    window.controller = controller;
});

