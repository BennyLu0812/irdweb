package com.ird.portal.common.user.enums;


import com.ird.portal.enums.BaseEnum;
import com.ird.portal.enums.EnumUtil;

import java.util.Locale;

/**
 * 工作模式
 *
 * @author Tim
 */
public enum AssignModeEnum implements BaseEnum<String> {

    /**
     * 自動
     */
    AUTOMATIC("A", "A-自動"),

    /**
     * 手動
     */
    MANUAL("M", "M-手動");

    private String code;
    private String text;

    AssignModeEnum(String code, String text) {
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
}
