require([ 'jquery', 
          'atosBaseController',
          'jquery.config'],
      function($, atosBaseController, momentConfig,axios) {

	  var controller = atosBaseController(momentConfig, {
	        init : function() {
	            this.initEvent();
	        },
	        // 初始化綁定事件
	        initEvent : function() {
	            var slef = this;
	            if (window != top) {  
	                top.location.href = location.href;  
	            }
	            $("#loginBtnId").bind("click", function(){
	            	controller.login();
		        });
				$(window).keydown( function(e) {
					var key = window.event ? e.keyCode : e.which;
					if (typeof(key) != 'undefined' && key.toString() == '13') {
						controller.login();
					}
				});
	        },

	        enterSubmit:function(event) {
	        	var theEvent = event || window.event;
	            var code = theEvent.keyCode || theEvent.which || theEvent.charCode;
	            if (code == 13) {
	                controller.login();
	            }
	        },
	        
	        login:function() {
	        	$("#loginBtnId").prop('disabled',true);
            	if($.trim($("#userId").val()) == ''){
            		$("#msgId").html('<p>提示：登錄用戶名不能為空!</p>');		
            		$("#loginBtnId").prop('disabled',false);
            		return false; 
            	}
            	if($.trim($("#password").val()) == ''){
            		$("#msgId").html('<p>提示：登錄密碼不能為空!</p>');	
            		$("#loginBtnId").prop('disabled',false);
            		return false;
            	}
            	$("#msgId").empty();
            	var formData = $('#fm1').serializeObject();
            	var data = JSON.stringify(formData);
            	$.ajax({
         		   type: "POST",
         		   dataType:"json",
         		   async:true,
         		   contentType : "application/json; charset=utf-8",
         		   url : basePath + "/login/login",
         		   data : data,
         		   success: function(json){
         			   $("#loginBtnId").prop('disabled',false);
         			   var key = json.checkFlag;
         			   switch (key) {
         			   	case '-3':
							$("#msgId").html('<p>提示：該用戶名不是系統有效的用戶，有疑問請聯繫管理員!</p>');
							break;
         			   	case '-2':
							$("#msgId").html('<p>提示：該用戶名不是系統的用戶，有疑問請聯繫管理員!</p>');
							break;
						case '-1':
							$("#msgId").html('<p>提示：用戶名或密碼錯誤!</p>');
							break;
						case '0':
							$("#msgId").html('<p>提示：無法AD認證!</p>');
							break;
						case '1':
							if(json.url != null && json.url != ''){
                                window.location.href=json.url;
							}else{
                                window.location.href=basePath + "/index.html";
							}
							break;
						case '2':
							$("#msgId").html('<p>提示：用戶名或密碼不能為空!</p>');
							break;
						case '3':
							$("#msgId").html('<p>提示：LDAP_URL 獲取失敗!</p>');
							break;
						case '4':
							$("#msgId").html('<p>提示：LDAP_DOMAIN_NAME 認證的域名獲取失敗 !</p>');
							break;
						case '5':
							$("#msgId").html('<p>提示：AD沒有該用戶或密碼錯誤!');
							break;
						case '6':
							$("#msgId").html('<p>提示：AD沒有該用戶或密碼錯誤!');
							break;
						default:
							break;
						}
         		   }
         	   });
	        }
		});
	    controller.init();
	    window.controller = controller;
});
