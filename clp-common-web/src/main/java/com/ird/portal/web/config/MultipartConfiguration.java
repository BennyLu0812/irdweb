package com.ird.portal.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.MultipartProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.MultipartFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.MultipartConfigElement;

//import org.springframework.boot.web.support.ErrorPageFilter;
//import org.springframework.core.annotation.Order;

/**
 * 
 * 文件上傳的配置.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 29/03/2018 14:56:48<br/>
 * 
 * @author Jim
 * @version 1.0
 */
@Configuration
@ConfigurationProperties(prefix = "spring.http", ignoreUnknownFields = true)
public class MultipartConfiguration {
    
	
	@Value("${cas.isWeblogic}")
	private boolean isWeblogic;
	
	private static final int WEBLOGIC_FILTER_ORDER_INDEX_FINAL= -999999;
	private static int TOMCAT_FILTER_ORDER_INDEX = 999999;
	private static int WEBLOGIC_FILTER_ORDER_INDEX = WEBLOGIC_FILTER_ORDER_INDEX_FINAL;
	
	private int getFilterOrder(){
		return isWeblogic ? WEBLOGIC_FILTER_ORDER_INDEX : TOMCAT_FILTER_ORDER_INDEX;
	}
	
    private MultipartProperties multipart = new MultipartProperties();
    
    public MultipartProperties getMultipart() {
        return multipart;
    }
    
    public void setMultipart(MultipartProperties multipart) {
        this.multipart = multipart;
    }
    
    @Bean
    public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
        ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet);
        registration.addUrlMappings("/");
        registration.setLoadOnStartup(1);
        return registration;
    }
    
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        return this.multipart.createMultipartConfig();
    }
    
    @Bean(name = DispatcherServlet.MULTIPART_RESOLVER_BEAN_NAME)
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setResolveLazily(this.multipart.isResolveLazily());
        multipartResolver.setMaxUploadSizePerFile(parseSize(multipart.getMaxFileSize()));
        multipartResolver.setMaxUploadSize(parseSize(this.multipart.getMaxRequestSize()));
        return multipartResolver;
    }
    
//    @Bean
//    @Order(0)
//    public MultipartFilter multipartFilter() {
//        MultipartFilter multipartFilter = new MultipartFilter();
//        multipartFilter.setMultipartResolverBeanName(DispatcherServlet.MULTIPART_RESOLVER_BEAN_NAME);
//        
//        return multipartFilter;
//    }
    
    
	@Bean("multipartFilter")
	public FilterRegistrationBean errorPageFilter() {
		FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        MultipartFilter multipartFilter = new MultipartFilter();
        multipartFilter.setMultipartResolverBeanName(DispatcherServlet.MULTIPART_RESOLVER_BEAN_NAME);
		filterRegistration.setFilter(multipartFilter);
		filterRegistration.setEnabled(true);
		filterRegistration.setName("multipartFilter");
		filterRegistration.setOrder(getFilterOrder());
		return filterRegistration;
	}
    
    
    private long parseSize(String size) {
        Assert.hasLength(size, "Size must not be empty");
        size = size.toUpperCase();
        if (size.endsWith("KB")) {
            return Long.valueOf(size.substring(0, size.length() - 2)) * 1024;
        }
        if (size.endsWith("MB")) {
            return Long.valueOf(size.substring(0, size.length() - 2)) * 1024 * 1024;
        }
        return Long.valueOf(size);
    }
    
}
