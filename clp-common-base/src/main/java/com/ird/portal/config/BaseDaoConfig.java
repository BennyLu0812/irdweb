/**
 * @Project Name: dls-common-base
 * @File Name: BaseDaoConfig.java
 * @Date: 2017年10月27日 上午11:55:16
 * @Copyright: Copyright (c) 2017 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.config;

import com.ird.portal.dao.JpaSqlDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;

/**
 * Title: <br/>
 * Description: <br/>
 * Date: 2017年10月27日 上午11:55:16<br/>
 *
 * @author Jim
 * @version 1.0
 * @since JDK1.8
 */
@Configuration
@EntityScan(basePackages = "com.ird.portal.**.entity")
@EnableJpaRepositories(basePackages = "com.ird.portal.**.repository")
@EnableTransactionManagement(proxyTargetClass = true) // 開啓事物，等同于xml配置文件中的 <tx:annotation-driven proxy-target-class="true"/>
public class BaseDaoConfig {
    private static final Logger LOG = LoggerFactory.getLogger(BaseDaoConfig.class);

    @PersistenceContext
    private EntityManager entityManager;

    private static final String QUERY_RESOURCES_PATH = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + "/query/*-*-query.xml";

    @Bean
    public JpaSqlDao jpaSqlDao(ApplicationContext applicationContext) throws IOException {
        JpaSqlDao dao = new JpaSqlDao();
        dao.setEntityManager(entityManager);
        dao.setQueryFiles(applicationContext.getResources(QUERY_RESOURCES_PATH));
        LOG.info("JpaSqlAutoConfiguration configured.");
        return dao;
    }

}
