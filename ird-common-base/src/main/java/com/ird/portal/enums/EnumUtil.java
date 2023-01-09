package com.ird.portal.enums;

import com.ird.portal.util.SpringContextUtil;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;

import java.text.MessageFormat;
import java.util.*;


public class EnumUtil {
    
    private static final Locale[] DEFAULT_LOCALES = new Locale[] {new Locale("pt", "PT"), new Locale("zh", "TW")};
    private static final String PATTERN = "{0} - {1} - {2}";
    private static final Logger logger = LoggerFactory.getLogger(EnumUtil.class);
    
    /**
     * 根據code值獲取枚舉對象.
     * @param enums 枚舉類
     * @param code 代碼
     * @return 枚舉對象
     */
    public static BaseEnum<?> getEnumByCode(final BaseEnum<?>[] enums, final String code) {
        for (BaseEnum<?> enumItem : enums) {
            if (enumItem.getCode().equals(code)) {
                return enumItem;
            }
        }
        return null;
    }
    
    public static String getTextByCode(BaseEnum<?>[] enums, String code, Locale locale) {
        for (BaseEnum<?> enumItem : enums) {
            if (enumItem.getCode().equals(code)) {
                return getText(enumItem, locale);
            }
        }
        return "";
    }
    
    public static String getText(BaseEnum<?> _enum, Locale locale) {
        try {
            String prefix = getPrefix(_enum);
            
            if  (locale == null) {
                Object[] args = new Object[DEFAULT_LOCALES.length + 1];
                args[0] = _enum.getCode();
                
                for (int i = 1; i <= DEFAULT_LOCALES.length; i++) { 
                    args[i] = getMessageSource().getMessage(prefix.concat(_enum.toString()), null, DEFAULT_LOCALES[i - 1]);
                }
                
                return MessageFormat.format(PATTERN, args);
            }
            return getMessageSource().getMessage(prefix.concat(_enum.toString()), null, locale);
        }
        catch (Exception e) {
            logger.warn("No message found under code: {}", _enum.toString());
            logger.warn("{}", ExceptionUtils.getStackTrace(e));
            return _enum.getCode().toString();
        }
    }
    
    public static List<Map<String, String>> getItems(BaseEnum<?>[] enums, Locale locale) {
        List<Map<String, String>> items = new ArrayList<>();
        
        for (BaseEnum<?> enumItem : enums) {
            Map<String, String> item = new HashMap<>();
            item.put(BaseEnum.CODE_KEY, (String)enumItem.getCode());
            item.put(BaseEnum.TEXT_KEY, enumItem.getText());
            items.add(item);
        }
        
        return items;
    }
    
    
    /**
     * 獲取枚舉摟據項目.
     * @param enums 枚舉類
     * @return 枚舉摟據項目
     */
    public static List<Map<String, String>> getItems(final BaseEnum<?>[] enums) {
        final List<Map<String, String>> items = new ArrayList<>();
        for (BaseEnum<?> enumItem : enums) {
            Map<String, String> item = new HashMap<>();
            item.put(BaseEnum.CODE_KEY, String.valueOf(enumItem.getCode()));
            item.put(BaseEnum.TEXT_KEY, enumItem.getCode().toString());
            items.add(item);
        }
        return items;
    }
    
    private static String getPrefix(BaseEnum<?> _enum) {
        String name = _enum.getClass().getName();
        return name.substring(name.lastIndexOf(".") + 1).concat(".");
    }
    
    private static MessageSource getMessageSource() {
        return SpringContextUtil.getBean(MessageSource.class);
    }
    
}