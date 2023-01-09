package com.ird.portal.common.user.enums;


import com.ird.portal.enums.BaseEnum;

import java.util.Locale;

/**
 * <br/> 車輛種類
 * <br/>
 * <b>Date:</b> 2021/10/31 11:24<br/>
 *
 * @author Zack
 * @version 1.0
 */
public enum VehCategoryEnum implements BaseEnum<String> {
    P("P"),
    X("X"),
    M("M"),
    ES("ES"),
    EP("EP"),
    EX("EX"),
    EM("EM"),
    ;

    private String code;
    private String text;

    VehCategoryEnum(String code){
        this.code = code;
    }


    @Override
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
