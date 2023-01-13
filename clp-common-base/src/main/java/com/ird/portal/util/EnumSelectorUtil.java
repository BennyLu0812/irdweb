/**
 * @Project Name: dls-common-base
 * @File Name: EnumSelectorUtil.java
 * @Date: 22/05/2018 15:07:53
 * @Copyright: Copyright (c) 2018 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.util;

import com.ird.portal.enums.BaseEnum;
import org.springframework.context.MessageSource;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.*;

/**
 * 枚舉選擇器工具類.
 * 
 * 主要用于封裝枚舉類用于頁面下拉顯示相關一些通用方法。
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 22/05/2018 15:07:53<br/>
 * @author raysely
 * @version 1.0
 */
public final class EnumSelectorUtil {
    
    /**
     * 私有构造函数.
     */
    private EnumSelectorUtil() {
    }
    
    /**
     * 獲取MessageSource.
     * @return MessageSource
     */
    private static MessageSource getMessageSource() {
        return SpringContextUtil.getBean(MessageSource.class);
    }
    
    /**
     * 根據className獲取Prefix.
     * @param className 類名
     * @return Prefix
     */
    private static String getPrefix(final String className) {
        return className.substring(className.lastIndexOf(".") + 1).concat(".");
    }
        
    /**
     * 獲取枚舉顯示值.
     * 
     * @param enumClassName 枚舉類ClassName
     * @param enumName 枚舉名稱
     * @param locale 國際化語言
     * @return 枚舉顯示值
     */
    public static String getText(final String enumClassName, final String enumName, final Locale locale) {
        final String perfix = getPrefix(enumClassName);
        return getMessageSource().getMessage(perfix.concat(enumName), null, locale);
    }
    
    /**
     * 獲取枚舉下拉摟據.
     * @param c 枚舉類
     * @param locale 國際化語言
     * @param codeKey 代碼key
     * @param textKey 顯示值key
     * @param <X> 自定義枚舉類
     * @param <Y> 自定義枚舉類code的數據類型
     * @return 枚舉下拉摟據
     */
    @SuppressWarnings("unchecked")
    public static <X extends BaseEnum<Y>, Y> List<Map<String, String>> getItems(
        Class<X> c, Locale locale, String codeKey, String textKey) {
        final Class<X> xclazz = (Class<X>) (((ParameterizedType) c.getGenericSuperclass()).getActualTypeArguments())[0];
        final List<Map<String, String>> items = new ArrayList<>();
        try {
            final Method valuesMethod = xclazz.getMethod("values");
            final X[] values = (X[]) valuesMethod.invoke(null);
            for (X x : values) {
                Map<String, String> item = new HashMap<>();
                item.put(codeKey, (String) x.getCode());
                item.put(textKey, x.getText(locale));
                items.add(item);
            }
        }
        catch (Exception e) {
            throw new RuntimeException("Enum getItems error:" + e.getMessage());
        }
        return items;
    }
}
