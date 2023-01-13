package com.ird.portal.common.rpt.enums;


import com.ird.portal.enums.BaseEnum;
import com.ird.portal.enums.EnumUtil;

import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * 報表編碼
 * @author AugusChen
 */
public enum ReportCodeEnum implements BaseEnum<String> {

    R05901("05901", "複驗通知書"),
    R05902("05902", "複驗通知書"),
    R05903("05903", "新車複驗通知書"),
    R059DT("059DT", "代替登記摺"),
    R07101("07101", "特別檢驗通知書"),
    R07102("07102", "特別檢驗通知書"),
    R07103("07103", "新車特別檢驗通知書"),
    R071DT("071DT", "代替登記摺"),
    R08401("08401", "重驗通知書"),
    R08402("08402", "重驗通知書"),
    R08403("08403", "新車重驗通知書"),
    R084DT("084DT", "代替登記摺"),
    RP01("P01", "車輛檢驗結果表");

    private String code;
    private String text;

    private ReportCodeEnum(String code, String text) {
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
        return EnumUtil.getTextByCode(ReportCodeEnum.values(), code, locale);
    }

    public static List<Map<String, String>> getItems(Locale locale) {
        return EnumUtil.getItems(ReportCodeEnum.values(), locale);
    }

    public static String getTextByCode(String code) {
        for (ReportCodeEnum enumItem : ReportCodeEnum.values()) {
            if (enumItem.code.equals(code)) {
                return enumItem.getText();
            }
        }
        return "";
    }


}
