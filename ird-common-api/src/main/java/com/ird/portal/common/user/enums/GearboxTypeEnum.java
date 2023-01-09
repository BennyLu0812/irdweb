package com.ird.portal.common.user.enums;

import com.ird.portal.enums.BaseEnum;
import com.ird.portal.enums.EnumUtil;

import java.util.Locale;

/**
 * <br/> 變數箱種類
 * <br/>
 * <b>Date:</b> 2021/10/31 11:24<br/>
 *
 * @author Zack
 * @version 1.0
 */
public enum GearboxTypeEnum implements BaseEnum<String> {
    A("A"),
    M("M");

    private String code;
    private String text;


    GearboxTypeEnum(String code){
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
        return EnumUtil.getText(this, locale);
    }

}
