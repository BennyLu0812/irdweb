package com.ird.portal.enums;

import java.util.Locale;

/**
 * <br/> 驗車流程狀態枚舉類
 * <br/>
 * <b>Date:</b> 2021/9/28 14:32<br/>
 *
 * @author Zack
 * @version 1.0
 */
public enum ProcessStatusEnum implements BaseEnum<String> {
    PRORESSING("P","P-ProcessIng-進行中"),
    FINISHED("F","F-Finished-已完成"),
    REINSPECTION("R","R-Reinspection-重測"),
    CANCELED("C","C-Canceled-已取消")
    ;


    private String code;
    private String text;

    ProcessStatusEnum(){

    }

    ProcessStatusEnum(String code, String text){
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
