/**
 * @Project Name: dsat-rpt-core
 * @File Name: RptDaoConfig.java
 * @Date: 15/12/2017 12:26:31
 * @Copyright: Copyright (c) 2016 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.rpt.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * RPT DAO的配置.
 * 
 * <br/>
 * <br/>
 * <b>Date:</b> 15/12/2017 12:26:31<br/>
 * 
 * @author Jim
 * @version 1.0
 */
@Configuration
public class RptDaoConfig {
    
    private static final Logger LOG = LoggerFactory.getLogger(RptDaoConfig.class);
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Bean("rptDao")
    public RptDao schDao(ApplicationContext applicationContext)
        throws Exception {
        RptDao dao = new RptDao();
        dao.setEntityManager(entityManager);
        dao.setQueryFiles(applicationContext.getResources(ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + "/query/rpt-*-query.xml"));
        LOG.info("RptDaoConfig configured.");
        return dao;
    }
}
