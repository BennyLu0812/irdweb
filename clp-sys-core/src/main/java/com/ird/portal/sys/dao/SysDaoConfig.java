/**
 * @Project Name: dsat-sys-core
 * @File Name: SysDaoConfig.java
 * @Date: 15/12/2017 12:30:59
 * @Copyright: Copyright (c) 2016 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.sys.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * SYS DAO的配置.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 15/12/2017 12:31:32<br/>
 * @author Jim
 * @version 1.0
 */
@Configuration
public class SysDaoConfig  {
    
    private static final Logger LOG = LoggerFactory.getLogger(SysDaoConfig.class);

    @PersistenceContext
    private EntityManager entityManager;
    
    @Bean("sysDao")
    public SysDao adminDao(ApplicationContext applicationContext) throws Exception {
        SysDao dao = new SysDao();
        dao.setEntityManager(entityManager);
        dao.setQueryFiles(applicationContext.getResources(ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + "/query/sys-*-query.xml"));
        LOG.info("SysDaoConfig configured.");
        return dao;
    }
}
