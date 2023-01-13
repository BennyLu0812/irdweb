package com.ird.portal.enums;

import java.util.Locale;

/**
 * <br/> 出場統計方式ENUM
 * <br/>
 * <b>Date:</b> 2021/10/2 17:29<br/>
 *
 * @author Zack
 * @version 1.0
 */
public enum ExitStatisticsModeEnum implements BaseEnum<String> {
    LEAVE("B", "閘機出場"),
    RESULT("I", "驗車結果生成")
    ;

    private String code;
    private String text;

    ExitStatisticsModeEnum(){

    }

    ExitStatisticsModeEnum(String code, String text){
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
