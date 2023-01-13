

require([ 'jquery',
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
          'noty.config' ],
        function($, atosBaseController,atosUtil,Vue,momentConfig,axios) {

	  var controller = atosBaseController(momentConfig, {
	        //統一定義變量.
	        variables : {
	            datatable : null
	        },
	        params:{
	            
	        },
	        init : function() {
                this.initVue();
            },
          initVue : function() {
              var self =this;
              this.vue = new Vue({
                  el : '#app',
                  data : {
                      sysParam : {}
                  },
                  created : function() {
                      var self = this;
                      axios.get(
                          basePath +'/sys/params/getSysParamsContrast'
                      ).then(function(response){
                          if(response == null || response == ''){
                              $('#showDiv').show();
                              $('#titleDiv').hide();
                          }else{
                              $.each(response, function(index, obj){
                                  //map.put(obj.paramName,obj.paramValue);
                                  if(obj.paramName==null || obj.paramName == 'null'){
                                      obj.paramName='';
                                  }
                                  if(obj.paramValue==null || obj.paramValue == 'null'){
                                      obj.paramValue='';
                                  }
                                  if(obj.redisParamValue==null || obj.redisParamValue == 'null'){
                                      obj.redisParamValue='';
                                  }
                                  if(obj.paramDesc==null || obj.paramDesc == 'null'){
                                      obj.paramDesc='';
                                  }
                                  $('#content-div').append(
                                      '<div class="row form-group">'+
                                      '<label class="control-label col-sm-3">'+obj.paramName+'</label>'+
                                      '<label class="control-label col-sm-3">'+obj.paramValue+'</label>'+
                                      '<label class="control-label col-sm-3">'+obj.redisParamValue+'</label>'+
                                      '<label class="control-label col-sm-3">'+obj.paramDesc+'</label>'+
                                      '</div>'
                                  )
                              });

                          }
                      }).catch(function(error){
                          $.showResult(error);
                      });

                      /*$.ajax({
                          url:basePath +'/sys/params/getSysParamsContrast',
                          type:'GET',
                          success: function(response) {
                                if(response == null || response == ''){
                                    $('#showDiv').show();
                                    $('#titleDiv').hide();
                                }else{
                                    $.each(response, function(index, obj){
                                        //map.put(obj.paramName,obj.paramValue);
                                        if(obj.paramName==null || obj.paramName == 'null'){
                                            obj.paramName='';
                                        }
                                        if(obj.paramValue==null || obj.paramValue == 'null'){
                                            obj.paramValue='';
                                        }
                                        if(obj.redisParamValue==null || obj.redisParamValue == 'null'){
                                            obj.redisParamValue='';
                                        }
                                        if(obj.paramDesc==null || obj.paramDesc == 'null'){
                                            obj.paramDesc='';
                                        }
                                        $('#content-div').append(
                                            '<div class="row form-group">'+
                                            '<label class="control-label col-sm-3">'+obj.paramName+'</label>'+
                                            '<label class="control-label col-sm-3">'+obj.paramValue+'</label>'+
                                            '<label class="control-label col-sm-3">'+obj.redisParamValue+'</label>'+
                                            '<label class="control-label col-sm-3">'+obj.paramDesc+'</label>'+
                                            '</div>'
                                        )
                                    });

                                }
                          },
                          error:function (e) {
                              $.showResult(e);
                          }
                      });*/
                  }
              });
          }
		});
	    controller.init();
	    window.controller = controller;
});

