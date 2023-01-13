/**
 * @Project Name: clp-web
 * @File Name: DLSApp.java
 * @Date: 2017年10月27日 下午4:08:02
 * @Copyright: Copyright (c) 2017 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.MultipartAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.WebApplicationInitializer;

/**
 * 
 * Spring Boot的啓動入口.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 14/11/2017 15:42:48<br/>
 * @author Jim
 * @version 1.0
 */
@EnableCaching
@SpringBootApplication
@ComponentScan(basePackages = "com.ird.portal")
@EnableConfigurationProperties
@EnableAspectJAutoProxy(proxyTargetClass=true, exposeProxy=true)
@EnableAutoConfiguration(exclude = {MultipartAutoConfiguration.class})
public class CLPWebApplication extends SpringBootServletInitializer implements WebApplicationInitializer {
    
    
    public static void main(String[] args) {
        SpringApplication.run(CLPWebApplication.class, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CLPWebApplication.class);
    }
}
