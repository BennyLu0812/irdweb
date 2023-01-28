package com.ird.portal.core.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Benny
 * @description:
 * @date 2023/1/16
 */
@Configuration
public class PortalDaoConfig  {
    private static final Logger LOG = LoggerFactory.getLogger(PortalDaoConfig.class);

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Exl Query文件跟徑.
     */
    private static final String QUERY_RESOURCES_PATH = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + "/query/portal-*-query.xml";

    @Bean("portalDao")
    public PortalDao portalDao(ApplicationContext applicationContext) throws Exception {
        PortalDao dao = new PortalDao();
        dao.setEntityManager(entityManager);
        dao.setQueryFiles(applicationContext.getResources(QUERY_RESOURCES_PATH));
        LOG.info("PortalDaoConfig configured.");
        return dao;
    }
}
