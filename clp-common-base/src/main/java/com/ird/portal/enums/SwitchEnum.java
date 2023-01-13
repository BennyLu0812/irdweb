package com.ird.portal.enums;

import java.util.Locale;

/**
 * <br/> 是否開啓 枚舉類
 * <br/>
 * <b>Date:</b> 2021/9/24 16:04<br/>
 *
 * @author Zack
 * @version 1.0
 */
public enum SwitchEnum implements BaseEnum<String> {
    YES("Y", "開啓"),
    NO("N", "關閉")
    ;


    private String code;
    private String text;

    SwitchEnum(){

    }

    SwitchEnum(String code, String text){
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
