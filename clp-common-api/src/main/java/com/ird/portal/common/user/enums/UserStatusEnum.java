package com.ird.portal.common.user.enums;

import com.ird.portal.enums.BaseEnum;
import com.ird.portal.enums.EnumUtil;

import java.util.List;
import java.util.Locale;
import java.util.Map;

public enum UserStatusEnum implements BaseEnum<String> {
    
    ACTIVE("A","A - Active - 有效"), DELETED("D","D - Deleted - 删除"), STOPPED("I","I - Invalid - 失效");
    
    private String code;
    private String text;
    
    private UserStatusEnum(String code,String text) {
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
       return EnumUtil.getTextByCode(UserStatusEnum.values(), code, locale);
    }
    
    public static List<Map<String, String>> getItems(Locale locale) {
        return EnumUtil.getItems(UserStatusEnum.values(), locale);
    }
    
}
