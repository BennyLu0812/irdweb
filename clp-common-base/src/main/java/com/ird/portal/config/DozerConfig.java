/**
 * @Project Name: dls-common-base
 * @File Name: DozerConfig.java
 * @Date: 2017年10月27日 下午12:36:45
 * @Copyright: Copyright (c) 2017 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.config;

import com.ird.portal.util.BeanMapper;
import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Title: <br/>
 * Description: <br/>
 * Date: 2017年10月27日 下午12:36:45<br/>
 *
 * @author Jim
 * @version 1.0
 * @since JDK1.8
 */
@Configuration
public class DozerConfig {

    @Autowired
    private DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean;
    
    @Bean("dozerBeanMapperFactoryBean")
    public DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean(ApplicationContext applicationContext) throws Exception {
        DozerBeanMapperFactoryBean mapper = new DozerBeanMapperFactoryBean();
        mapper.setMappingFiles(applicationContext.getResources("classpath*:dozer-*-mapping.xml"));
        return mapper;
    }

    @Bean("beanMapper")
    public BeanMapper beanMapper(ApplicationContext applicationContext) throws Exception {
        BeanMapper beanMapper = new BeanMapper(dozerBeanMapperFactoryBean.getObject());
        return beanMapper;

    }
}
