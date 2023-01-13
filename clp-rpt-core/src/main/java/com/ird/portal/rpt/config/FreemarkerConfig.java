package com.ird.portal.rpt.config;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

import freemarker.template.Configuration;

/**
 * 
 * 報表模板對應的freemarker配置BEAN 
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 23/06/2018 16:04:30<br/>
 * @author: Crystal Zhao
 * @version 1.0
 */
@org.springframework.context.annotation.Configuration
public class FreemarkerConfig {
    
    @Value("${report.templates}")
    private String template;
    
    @Value("${report.isRelativePath}")
    private boolean isRelativePath;
    
    @Bean
    public Configuration freemarkerConfiguration() throws Exception {
        FreeMarkerConfigurationFactoryBean factoryBean = new FreeMarkerConfigurationFactoryBean();
        factoryBean.setConfigLocation(new ClassPathResource("/freemarker.properties"));
        Configuration configuration = factoryBean.createConfiguration();
        if (!isRelativePath) {
            configuration.setDirectoryForTemplateLoading(new File(template));
        } else {
            configuration.setClassForTemplateLoading(this.getClass(), template);
        }
        
        return configuration;
    }
    
    
}
