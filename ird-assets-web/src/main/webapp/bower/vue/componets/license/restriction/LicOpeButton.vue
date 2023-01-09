<template>
  <div class="btn-group">
    <a class="btn btn-default btn-sm" @click = "doLicJudge">{{buttonText}}</a>
  </div>
</template>

<script>
define(['Vue','vueloader'],function(Vue){
	var LicOpeButton = Vue.extend({
		template:template,
		 props: {
	            buttonText: {
	                type: String
	            },
	            alertText : {
	               type: String
	            },
	            requestUrl : {
	               type: String
	            }
	        },
            methods:{
                doLicJudge : function (){
                    var self = this;
                    var options = {
                            text: self.alertText
                    };
                    $.confirm(options, function(yes){
                        if(yes){
                            $.ajax({
                                type: "get",
                                url: self.requestUrl,
                                async:false,
                                contentType: "application/json",
                                success: function(data){
                                    $.showResult({status : 200});
                                    // 父級重載表格
                                    self.$emit("sucessChange");
                                },
                                error:function(data){
                                    $.showResult(data);
                                }
                            });
                        }
                    });
                }
            }
	})	
    Vue.component('lic-ope-button', LicOpeButton);
});

</script>

