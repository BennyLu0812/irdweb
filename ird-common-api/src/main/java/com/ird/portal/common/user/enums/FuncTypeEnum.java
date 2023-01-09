package com.ird.portal.common.user.enums;


import com.ird.portal.enums.BaseEnum;
import com.ird.portal.enums.EnumUtil;

import java.util.Locale;

/**
 * Function類型枚舉
 *
 * @author Tim
 */
public enum FuncTypeEnum implements BaseEnum<String> {

    /**
     * 按鈕/功能
     */
    FUNCTION("F"),

    /**
     * 菜單
     */
    MENU("M");

    private String code;
    private String text;

    FuncTypeEnum(String code) {
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

    @Override
    public String getText() {
        return text;
    }
}
