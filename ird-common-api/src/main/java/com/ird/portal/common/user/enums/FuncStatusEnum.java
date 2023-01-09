package com.ird.portal.common.user.enums;

import com.ird.portal.enums.BaseEnum;
import com.ird.portal.enums.EnumUtil;

import java.util.List;
import java.util.Locale;
import java.util.Map;


public enum FuncStatusEnum implements BaseEnum<String> {
    
    ACTIVE("A"), STOPPED("S");
    
    private String code;
    private String text;
    
    private FuncStatusEnum(String code) {
        this.code = code;
    }
    
    @Override
    public String getCode() {
        return code;
    }
    
    @Override
    public String getText(Locale locale) {
        return EnumUtil.getText(this, locale);
    }
    
    public static String getTextByCode(String code, Locale locale) {
       return EnumUtil.getTextByCode(FuncStatusEnum.values(), code, locale);
    }
    
    public static List<Map<String, String>> getItems(Locale locale) {
        return EnumUtil.getItems(FuncStatusEnum.values(), locale);
    }

    @Override
    public String getText() {
        return text;
    }

}
