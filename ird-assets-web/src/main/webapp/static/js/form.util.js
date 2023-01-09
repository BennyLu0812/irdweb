/**
 * 处理处理工具类
 * author: ｋent long
 * date: 2018-07-19
 * note: 
 */

define([ 'jquery' ], function($) {
'use strict'; // 使用JS嚴格模式.
    return  {
        //值回写方法
        set:function(obj){
            var attr;
            for(attr in obj){
                var element=$("#"+attr)[0];
                var nodeName;
                if (element && element.nodeName) {
                    nodeName = element.nodeName;
                }
                if(nodeName=="INPUT"){
                    this.judgeType($(element).attr("type"),attr,obj[attr]);
                }else if(nodeName=="SELECT"){
                    this.setSelect(attr,obj[attr]);
                }else if(nodeName=="TEXTAREA"){
                    this.setValue(attr,obj[attr]);
                }else if(nodeName=="SPAN"){
                    $("#"+attr).text(obj[attr]);
                }
            }
        },
        //设置文本框 文本域 密码框 隐藏框
        setValue:function(key,value){
            $("#"+key).val(value);
        },
        //设置下拉框
        setSelect:function(key,value){
            $("#"+key+" option").each(function(){
                if(this.value==value){
                    $(this).attr("selected","selected");
                }
            });
        },
        //设置radio
        setRadio:function(key,value){
            $(":radio[name='"+key+"']").attr("checked",false);
            $(":radio[value='"+value+"']").attr("checked",true);
        },
        //设置checkbox
        setCheckbox:function(key,value,isDefault){
            $(":checkbox[name='"+key+"']").attr("checked",false);
            if(isDefault){
                var vs=value.split("");
                for(var i=vs.length-1;i>=0;i--){
                    if(vs[i]=="1"){
                        $(":checkbox[name='"+key+"']").filter(":eq("+(vs.length-1-i)+")").attr("checked",true);
                    }
                }
            }else {

            }
        },
        //input类型判断
        judgeType:function(type,key,value){
            if(type=="text"||type=="password"||type=="hidden"){
                this.setValue(key,value);
            }else if(type=="radio"){
                this.setRadio(key,value);
            }else if(type=="checkbox"){
                this.setCheckbox(key,value,true);
            }
        }

    }
});

    

