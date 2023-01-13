/**
 * @Project Name: dsat-sch-core
 * @File Name: SchBaseDao.java
 * @Date: 06/04/20166:06:09 PM
 * @Copyright: Copyright (c) 2016 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.sch.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * Title: <br/>
 * Description: <br/>
 * Date: 06/04/2016 6:06:09 PM<br/>
 *
 * @author Jim
 * @version 1.0
 * @since JDK1.8
 */
@Configuration
public class SchDaoConfig  {
    
    private static final Logger LOG = LoggerFactory.getLogger(SchDaoConfig.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Bean("schDao")
    public SchDao schDao(ApplicationContext applicationContext) throws Exception {
        SchDao dao = new SchDao();
        dao.setEntityManager(entityManager);
        dao.setQueryFiles(applicationContext.getResources(ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + "/query/sch-*-query.xml"));
        LOG.info("SchDaoConfig configured.");
        return dao;
    }
}
