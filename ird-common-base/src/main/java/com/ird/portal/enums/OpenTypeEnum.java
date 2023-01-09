package com.ird.portal.enums;

import java.util.Locale;

/**
 * <br/> 開閘方式ENUM
 * <br/>
 * <b>Date:</b> 2021/10/2 17:29<br/>
 *
 * @author Zack
 * @version 1.0
 */
public enum OpenTypeEnum implements BaseEnum<String> {
    AUTO("A", "AUTO-自動"),
    MANUAL("M", "Manual-手動")
    ;

    private String code;
    private String text;

    OpenTypeEnum(){

    }

    OpenTypeEnum(String code, String text){
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
        return EnumUtil.getText(this, locale);
    }

    public static String getTextByCode(String code) {
        for (OpenTypeEnum enumItem : OpenTypeEnum.values()) {
            if (enumItem.code.equals(code)) {
                return enumItem.getText();
            }
        }
        return "";
    }
}
