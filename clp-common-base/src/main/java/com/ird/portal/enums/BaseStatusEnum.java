package com.ird.portal.enums;

import java.util.Locale;

/**
 * <br/> 基礎狀態枚舉類 （sysCode：915002）
 * <br/>
 * <b>Date:</b> 2021/9/28 15:07<br/>
 *
 * @author Zack
 * @version 1.0
 */
public enum BaseStatusEnum implements BaseEnum<String>{
    ACTIVE("A", "A - Active - 有效"),
    INVAILD("I", "I - Invaild - 失效"),
    CANCEL("C", "C - Cancel - 取消"),
    DELETE("D", "D - Delete - 刪除")
    ;

    private String code;
    private String text;

    BaseStatusEnum(){

    }

    BaseStatusEnum(String code, String text){
        this.code = code;
        this.text = text;
    }


    public String getText() {
        return text;
    }


    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getText(Locale locale) {
        return null;
    }
}
