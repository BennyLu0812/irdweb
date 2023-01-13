/**
 * @Project Name: dsat-user-core
 * @File Name: UserDaoConfig.java
 * @Date: 06/04/20166:06:09 PM
 * @Copyright: Copyright (c) 2016 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.user.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * User DAO的配置.
 * 
 * <br/>
 * <br/>
 * <b>Date:</b> 15/12/2017 12:34:51<br/>
 * 
 * @author Jim
 * @version 1.0
 */
@Configuration
public class UserDaoConfig {
    
    private static final Logger LOG = LoggerFactory.getLogger(UserDaoConfig.class);
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Bean("userDao")
    public UserDao userDao(ApplicationContext applicationContext)
        throws Exception {
        UserDao dao = new UserDao();
        dao.setEntityManager(entityManager);
        dao.setQueryFiles(applicationContext.getResources(ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + "/query/user-*-query.xml"));
        LOG.info("UserDaoConfig configured.");
        return dao;
    }
}
