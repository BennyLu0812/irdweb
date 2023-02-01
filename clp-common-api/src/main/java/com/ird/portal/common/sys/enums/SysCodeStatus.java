package com.ird.portal.common.sys.enums;

import com.ird.portal.enums.BaseEnum;
import com.ird.portal.enums.EnumUtil;

import java.util.List;
import java.util.Locale;
import java.util.Map;


/**
 * 
 * 系統代碼的狀態枚舉類
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 23/06/2018 15:21:32<br/>
 * @author: Crystal Zhao
 * @version 1.0
 */
public enum SysCodeStatus implements BaseEnum<String> {
    
    ACTIVE("A", "A - Active - 有效"),
    INVALID("I", "I - Invalid - 失效"),
    DELETE("D", "D - Delete - 删除");
    
    private String code;
    private String text;
    
    private SysCodeStatus(String code, String text) {
        this.code = code;
        this.text = text;
    }
    
    @Override
    public String getCode() {
        return code;
    }
    
    public String getText() {
        return text;
    }
    
    @Override
    public String getText(Locale locale) {
        return EnumUtil.getText(this, locale);
    }
    
    public static String getTextByCode(String code, Locale locale) {
        return EnumUtil.getTextByCode(SysCodeStatus.values(), code, locale);
    }
    
    public static List<Map<String, String>> getItems(Locale locale) {
        return EnumUtil.getItems(SysCodeStatus.values(), locale);
    }
    
    public static String getTextByCode(String code) {
        for (SysCodeStatus enumItem : SysCodeStatus.values()) {
            if (enumItem.code.equals(code)) {
                return enumItem.getText();
            }
        }
        return "";
    }
    
}
