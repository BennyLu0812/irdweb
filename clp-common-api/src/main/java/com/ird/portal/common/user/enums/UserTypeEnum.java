package com.ird.portal.common.user.enums;

import com.ird.portal.enums.BaseEnum;
import com.ird.portal.enums.EnumUtil;

import java.util.List;
import java.util.Locale;
import java.util.Map;

public enum UserTypeEnum implements BaseEnum<String> {

    AD("A","A - AD服務器 - AD服務器"),  LOCAL("L","L - LOCAL - 本地");

    private String code;
    private String text;

    UserTypeEnum(String code,String text) {
        this.code = code;
        this.text = text;
    }
    
    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getText(Locale locale) {
        return EnumUtil.getText(this, locale);
    }

    @Override
    public String getText() {
        return text;
    }

    public static String getTextByCode(String code, Locale locale) {
       return EnumUtil.getTextByCode(UserTypeEnum.values(), code, locale);
    }
    
    public static List<Map<String, String>> getItems(Locale locale) {
        return EnumUtil.getItems(UserTypeEnum.values(), locale);
    }
    
}
