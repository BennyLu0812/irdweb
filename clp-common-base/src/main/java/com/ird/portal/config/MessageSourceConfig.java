package com.ird.portal.config;

import com.ird.portal.i18n.CustomizedMessageSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

/**
 * 
 * 國際化資源配置
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 23/05/2018 10:19:04<br/>
 * @author Parko
 * @version 1.0
 */
@Configuration
public class MessageSourceConfig {
    
    @Value("${spring.messages.basename}")
    private String basename;
    
    @Bean
    public CustomizedMessageSource messageSource() {
        CustomizedMessageSource customizedMessageSource = new CustomizedMessageSource();
        customizedMessageSource
            .setBasenames(StringUtils.commaDelimitedListToStringArray(StringUtils.trimAllWhitespace(this.basename)));
        return customizedMessageSource;
    }
    
}
