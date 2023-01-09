<template>
    <div  class="container-fluid">
        <!-- SCREEN ID -->
        <div class="content-header">
            <legend>
                <label class="h3" v-text="funcName">功能名稱</label>

                <div class="screen-id pull-right">
                    <small v-text="screenId">screen ID</small>
                </div>
            </legend>
        </div>
    </div>
</template>
<script>
    define(['Vue'],function(Vue){
        // 定義組件
        var FragmentLayout = Vue.extend({
            template:template,
            props:{
                funcName : { type : String },
                screenId : { type : String }
            },
            data : function() {
                return {};    
            }
        });
        // 註冊組件    
        Vue.component('fragment-layout',FragmentLayout);
    });        
</script>