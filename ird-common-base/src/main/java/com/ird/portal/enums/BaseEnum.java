/**
 * @Project Name: dls-common-api
 * @File Name: BaseEnum.java
 * @Date: 17/05/2018 13:41:19
 * @Copyright: Copyright (c) 2018 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.enums;

import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

/**
 * 系統枚舉基類.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 17/05/2018 13:41:19<br/>
 * @author raysely
 * @version 1.0
 * @param <Y> 對應DB值的類型
 */
public interface BaseEnum<Y> {
    
    /**
     * 枚舉代碼.
     */
    String CODE_KEY = "code";
    
    /**
     * 枚舉顯示值.
     */
    String TEXT_KEY = "text";
    
    /**
     * 獲取枚舉代碼.
     * @return 枚舉代碼
     */
    Y getCode();
    
    /**
     * 獲取枚舉顯示值.
     * @return 枚舉顯示值
     */
    String getText(Locale locale);

    /**
     * 獲取枚舉顯示值.
     * @return 枚舉顯示值
     */
    String getText();

    
    /**
     * 比較輸入的code 是否和枚舉的code 一樣
     * @param code
     * @return
     */
    default Boolean codeEquals(Y code) {
    	if (code == null) {
    		return (getCode() == null);
    	}
        if (getCode() instanceof String) {
            return StringUtils.equals((String)getCode(), (String)code);
        } else {
            return code.equals(getCode());
        }
    }
    
    /**
     * 比較輸入的code 是否和枚舉的code 不同
     * @param code
     * @return
     */
    default Boolean codeNotEquals(Y code) {
        return !codeEquals(code);
    }
}
