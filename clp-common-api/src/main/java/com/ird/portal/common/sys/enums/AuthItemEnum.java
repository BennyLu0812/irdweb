package com.ird.portal.common.sys.enums;

import com.ird.portal.enums.BaseEnum;
import com.ird.portal.enums.EnumUtil;

import java.util.List;
import java.util.Locale;
import java.util.Map;



/**
 * 可授權項目的枚舉類
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 31/05/2018 14:57:12<br/>
 * @author: Crystal Zhao
 * @version 1.0
 */
public enum AuthItemEnum implements BaseEnum<String> {
    PRINT_NAME_UPDATE("PRINT_NAME_UPDATE"),
    AUTH_ALERT("AUTH_ALERT");

    private String code;
    private String text;
    
    private AuthItemEnum(String code) {
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
        return EnumUtil.getTextByCode(AuthItemEnum.values(), code, locale);
    }
    
    public static List<Map<String, String>> getItems(Locale locale) {
        return EnumUtil.getItems(AuthItemEnum.values(), locale);
    }

    @Override
    public String getText() {
        return text;
    }
}
