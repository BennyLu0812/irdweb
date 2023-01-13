
require([ 'atosBaseController', 'Vue','atosUtil', 'axios', 'axios.config'],
	function(atosBaseController, Vue,atosUtil, axios) {

	  var controller = atosBaseController({}, {
	        init : function() {
	        	var self = this;
	        	atosUtil.getI18nByModules("sys,global",function () {
                    self.initVue();
                })
	        },
	        
	        initVue:function(){
        	    new Vue({
        	        el : '#app',
        	        data : {
        	            params : {
        	                paramName : vModel.paramName,
        	                paramDesc : "",
        	                paramValue : "",
        	                createDate : ""
        	            }
        	        },
        	        methods : {
        	            doSave : function() {
        	                var self = this;
        	                axios.post(basePath + '/sys/params', self.params).then(function(response) {
        	                	parent.controller.showResult(response);
        	                	parent.controller.doSearch();
        	                	parent.controller.closeFancybox();
        	                });
        	            },
        	            doUpdate : function() {
        	                var self = this;
                            var options = {
                                text :atosUtil.getI18nMessage("params.confirmSave")
                            };
                            $.confirm(options, function(yes) {
                            	if (yes) {
                                    axios.put(basePath + '/sys/params/' + self.params.paramName, self.params).then(function(response) {
                                        parent.controller.showResult(response);
                                        parent.controller.doSearch();
                                        parent.controller.closeFancybox();
                                    });
								}

							})

        	            }
        	        },
        	        created : function() {
        	            var self = this;
        	            if (self.params.paramName){
        	                axios.get(basePath + '/sys/params/' + self.params.paramName).then(function(response) {
        	                    self.params = response;
        	                });
        	            }
        	        }

	        	});
	        }
	  	
		});
	    controller.init();
});

