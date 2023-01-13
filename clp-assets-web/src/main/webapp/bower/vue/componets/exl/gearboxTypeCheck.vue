<template>
    <input type="checkbox" :checked = "isChecked" ref = "editGearboxTypeCheckbox" 
        true-value="A" false-value="M" :disabled="isDisabled" :style="typeStyle" v-model="gearboxtype">
</template>

<script>
    define(['jquery','Vue'], function ($,Vue) {
        var gearboxTypeCheck = Vue.extend({
            template: template,
            props: {
                // 变速箱类型 默认为手动‘M’
                gearboxtype: {
                    type : String,
                    default : 'M'
                },
                // 是否禁用控件
                isDisabled : {
                    type : Boolean,
                    default : true
                }
            },
            watch : {
                // 當勾選時,gearboxtype 會改變,更新 父組件的值
                'gearboxtype' : function(val,oldval){
                    this.$emit('update:gearboxtype', val);
                }
            },
            data : function(){
                return {
                    // 複選框樣式
                    typeStyle : {
                        marginTop : '10px'
                    },
                }
            },
            // 计算属性
            computed : {
                // 是否选中
                'isChecked' : function(){
                    return this.gearboxtype === 'A';
                }
            }
        });
        Vue.component('exl-gearbox-type-check',gearboxTypeCheck);
    });

</script>

<style scoped>

</style>