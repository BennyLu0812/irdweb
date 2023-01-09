package com.ird.portal.enums;

import java.util.Locale;

/**
 * <br/> 預約方式枚舉類
 * <br/>
 * <b>Date:</b> 2021/9/28 14:40<br/>
 *
 * @author Zack
 * @version 1.0
 */
public enum BookingTypeEnum implements BaseEnum<String>{
    NORMAL_APPOINTMENT("N","N - normal appointment - 正常預約", "正常預約", "normal appointment"),
    MODEL_APPROVAL("V","V - model approval - 型號認可", "型號認可", "model approval"),
    ESCORT("D","D - escort - 押解", "押解", "escort"),
    OTHER("O","O - other - 其他", "其他", "other")
    ;

    private String code;
    private String text;
    private String textCn;
    private String textPt;

    BookingTypeEnum(){

    }

    BookingTypeEnum(String code, String text){
        this.code = code;
        this.text = text;
    }

    BookingTypeEnum(String code, String text, String textCn, String textPt){
        this.code = code;
        this.text = text;
        this.textCn = textCn;
        this.textPt = textPt;
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
        return null;
    }

    public String getTextCn() {
        return textCn;
    }


    public static String getTextByCode(String code) {
        for (BookingTypeEnum enumItem : BookingTypeEnum.values()) {
            if (enumItem.code.equals(code)) {
                return enumItem.getText();
            }
        }
        return "";
    }

    public static String getTextCnByCode(String code) {
        for (BookingTypeEnum enumItem : BookingTypeEnum.values()) {
            if (enumItem.code.equals(code)) {
                return enumItem.getTextCn();
            }
        }
        return "";
    }
}
