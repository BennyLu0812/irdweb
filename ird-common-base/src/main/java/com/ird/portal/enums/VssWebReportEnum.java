package com.ird.portal.enums;

import java.util.Locale;

/**
 * <br/> VSSWEB report Enum
 * <br/>
 * <b>Date:</b> 2022/09/19 17:29<br/>
 *
 * @author Zack
 * @version 1.0
 */
public enum VssWebReportEnum implements BaseEnum<String> {
    SUB("SUB", "SUB - 代替登記摺"),
    REG("REG", "REG - 車輛登記資料")
    ;

    private String code;
    private String text;

    VssWebReportEnum(){

    }

    VssWebReportEnum(String code, String text){
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
        for (VssWebReportEnum enumItem : VssWebReportEnum.values()) {
            if (enumItem.code.equals(code)) {
                return enumItem.getText();
            }
        }
        return "";
    }
}
