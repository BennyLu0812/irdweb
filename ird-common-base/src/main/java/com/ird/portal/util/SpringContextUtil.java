/**
 * @Project Name: dls-common-base
 * @File Name: SpringContextUtil.java
 * @Date: Nov 29, 2017
 * @Copyright: Copyright (c) 2017 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 
 * 获取Spring Bean的Utils类.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 17/12/2017 16:47:25<br/>
 * @author Jim
 * @version 1.0
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {
    
    private static ApplicationContext applicationContext;
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
        throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }
    
    public static Object getBean(String name) {
        return applicationContext.getBean(name);
    }
    
    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }
    
    public static <T> T getBean(String name, Class<T> clazz) {
        return applicationContext.getBean(name, clazz);
    }
}
