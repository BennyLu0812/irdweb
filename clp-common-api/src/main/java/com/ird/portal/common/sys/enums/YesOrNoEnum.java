/**
 * @Project Name: dls-common-api
 * @File Name: YesOrNoEnum.java
 * @Date: 13/06/2018 12:25:48
 * @Copyright: Copyright (c) 2018 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.common.sys.enums;


import com.ird.portal.enums.BaseEnum;
import com.ird.portal.enums.EnumUtil;

import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * 是與否類型.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 13/06/2018 12:25:48<br/>
 * @author raysely
 * @version 1.0
 */
public enum YesOrNoEnum implements BaseEnum<String> {
    
    /**
     * 是.
     */
    YES("Y"),
    
    /**
     * 否.
     */
    NO("N");
    
    /**
     * 構造函數.
     * 
     * @param code 代碼
     */
    YesOrNoEnum(final String code) {
        this.code = code;
    }
    
    /**
     * 枚舉代碼.
     */
    private String code;
    private String text;
    
    @Override
    public String getCode() {
        return code;
    }
    
    @Override
    public String getText(Locale locale) {
        return EnumUtil.getText(this, locale);
    }
    
    /**
     * 獲取下拉選擇數據項.
     * @param locale 國際化
     * @return 下拉選擇數據項
     */
    public static List<Map<String, String>> getSelectorItems(Locale locale) {
        return EnumUtil.getItems(YesOrNoEnum.values(), locale);
    }

    @Override
    public String getText() {
        return text;
    }

    }
