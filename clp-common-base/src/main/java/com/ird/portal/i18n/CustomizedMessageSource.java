package com.ird.portal.i18n;

import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * 
 * 自定義的MessageSource，可根據basename取得關於該basename相關的message，再put進指定的Map中
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 23/05/2018 10:17:38<br/>
 * @author Parko
 * @version 1.0
 */
public class CustomizedMessageSource extends ResourceBundleMessageSource {
    
    public void putCodeAndMessages(String basename, Locale locale, Map<String, String> codeAndMessages) {
        ResourceBundle resourceBundle = getResourceBundle(basename, locale);
        Set<String> keySet = resourceBundle.keySet();
        
        for (String key : keySet) {
            codeAndMessages.put(key, getStringOrNull(resourceBundle, key));
        }
    }
    
}
