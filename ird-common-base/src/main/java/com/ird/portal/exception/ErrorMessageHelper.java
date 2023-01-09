package com.ird.portal.exception;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * 
 * 異常消息獲取!
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 16/11/2017 18:09:50<br/>
 * 
 * @author Deft
 * @version 1.0
 */
public final class ErrorMessageHelper {
    
    /**
     * 資源文件名稱. 實現error國際化.
     */
    private static final String BASE_NAME = "exception/errorMsg";
    
    private static final String DEFAULT_MESSAGE_TEMPLATE = "錯誤%s";
    
    private static ResourceBundleMessageSource messageSource;
    
    static {
        messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename(BASE_NAME);
        messageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());
    }
    
    /**
     * 通过errorCode获取对应的errorMsg.
     * 
     * @param errorCode 错误代码
     * @return 返回errorCode对应的errorMsg.
     */
    public static String getErrorMsgByCode(String errorCode) {
        return getErrorMsgByCode(errorCode, new Object[] {});
    }
    
    /**
     * 通过errorCode获取对应的errorMsg,通过字符串{0},{1},{2}动态生成errorMsg.
     * 
     * @param errorCode
     * @param args 变量数组,通过字符串{0},{1},{2}动态生成errorMsg.
     * @return 返回errorCode对应的动态errorMsg.
     */
    public static String getErrorMsgByCode(String errorCode, Object... args) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(errorCode, args, String.format(DEFAULT_MESSAGE_TEMPLATE, errorCode), locale);
    }
    
    public static String getErrorMessageWithCode(String errorCode, String msg) {
        Locale locale = LocaleContextHolder.getLocale();
        Object[] args = new Object[] {msg};        
        return errorCode +": " + messageSource.getMessage(errorCode, args, String.format(DEFAULT_MESSAGE_TEMPLATE, errorCode), locale);
    }

    
    public static String getErrorMessageWithCode(String errorCode, Object... args) {
        Locale locale = LocaleContextHolder.getLocale();
        return errorCode +": " + messageSource.getMessage(errorCode, args, String.format(DEFAULT_MESSAGE_TEMPLATE, errorCode), locale);
    }
}
