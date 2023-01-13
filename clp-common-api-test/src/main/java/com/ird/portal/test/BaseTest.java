package com.ird.portal.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * 測試父類,啟動SpringApplication.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 16/11/2017 10:17:26<br/>
 * 
 * @author Jim
 * @version 1.0
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.ird.portal")
@EnableConfigurationProperties
@EnableAspectJAutoProxy(proxyTargetClass=true, exposeProxy=true)
@EnableTransactionManagement(proxyTargetClass = true)
public class BaseTest {
    
    public static void main(String[] args) {
        SpringApplication.run(BaseTest.class, args);
    }
    
}
