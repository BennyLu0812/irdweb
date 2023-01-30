package com.ird.portal.web.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.ird.portal.util.DateUtil;
import com.ird.portal.web.interceptor.AuthenticationInterceptor;
import com.ird.portal.web.interceptor.LocaleInterceptor;
import com.ird.portal.web.interceptor.PermissionInterceptor;
import com.ird.portal.web.thymeleaf.security.dialect.DLSSecurityDialect;
import com.ird.portal.web.xss.XssFilter;
import com.ird.portal.web.xss.XssStringJsonDeserializer;
import org.jasig.cas.client.validation.Assertion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.thymeleaf.spring4.SpringTemplateEngine;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

/**
 *
 * WEB的公共配置.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 16/12/2017 20:46:17<br/>
 * @author Jim
 * @version 1.0
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private SpringTemplateEngine templateEngine;

    @Value("#{'${filter.excludeUrls}'.split(',')}")
    private String[] excludeUrls;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /**
         * 將src/main/webapp加入資源目錄映射.
         */
        registry.addResourceHandler("/**").addResourceLocations("/");
        super.addResourceHandlers(registry);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/login/login.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }

    @Bean
    public AuthenticationInterceptor authenticationInterceptor() {
        return new AuthenticationInterceptor();
    }
    @Bean
    public PermissionInterceptor permissionInterceptor() {
        return new PermissionInterceptor();
    }



    /**
     * 添加攔截器處.
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(authenticationInterceptor()).addPathPatterns("/**")
                .excludePathPatterns(excludeUrls);
        registry.addInterceptor(permissionInterceptor());
        registry.addInterceptor(localeChangeInterceptor());
        super.addInterceptors(registry);
    }

    /**
     * 統一Controller中返回的數據為UTF-8編碼，避免中文亂碼問題.
     */
    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(StandardCharsets.UTF_8);
        return converter;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        converters.add(responseBodyConverter());
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleInterceptor localInterceptor = new LocaleInterceptor();
        return localInterceptor;
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        //設置默認區域 EN
        Locale.setDefault(Locale.ENGLISH);
        return slr;
    }


    @Bean
    public HttpSessionListener httpSessionListener() {
        return new HttpSessionListener() {

            private Logger logger = LoggerFactory.getLogger("com.ird.portal.web.cas.HttpSessionListener");
            @Override
            public void sessionCreated(HttpSessionEvent se) {
                if (logger.isTraceEnabled()) {
                    HttpSession hse = se.getSession();
                    if (hse instanceof HttpSession) {
                        Assertion assertion = (Assertion) hse.getAttribute("_const_cas_assertion_");
                        String name = assertion != null ? assertion.getPrincipal().getName() : "assertion_null";
                        logger.trace("session created with [session_id:{} , name:{}]", hse.getId(), name);
                    }
                }
            }

            @Override
            public void sessionDestroyed(HttpSessionEvent se) {
                if (logger.isTraceEnabled()) {
                    HttpSession hse = se.getSession();
                    if (hse instanceof HttpSession) {
                        Assertion assertion = (Assertion) hse.getAttribute("_const_cas_assertion_");
                        String name = assertion != null ? assertion.getPrincipal().getName() : "assertion_null";
                        logger.trace("session destroyed with [session_id:{} , name:{}]", hse.getId(), name);
                    }
                }
            }
        };
    }

    @Bean
    public FilterRegistrationBean xssFiltrRegister() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new XssFilter());
        registration.addUrlPatterns("/*");
        registration.setName("XssFilter");
        registration.setOrder(7);
        return registration;
    }


    @Bean
    @Primary
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        SimpleModule module = new SimpleModule();
        module.addDeserializer(String.class, new XssStringJsonDeserializer());
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().timeZone("GMT+8")
                .dateFormat(new SimpleDateFormat(DateUtil.DATE_FORMAT)).build();
        objectMapper.registerModule(module);
        return new MappingJackson2HttpMessageConverter(objectMapper);
    }


    /**
     * 添加 Thymeleaf 權限安全標簽.
     */
    @Autowired
    public void addSecurityDialect() {
        templateEngine.addDialect(new DLSSecurityDialect());
    }

}