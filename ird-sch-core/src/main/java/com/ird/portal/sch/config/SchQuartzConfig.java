/**
 * @Project Name: dls-sch-core
 * @File Name: SchQuartzConfig.java
 * @Date: Nov 20, 2017
 * @Copyright: Copyright (c) 2017 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.sch.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * Quartz Scheduler配置.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> Nov 20, 2017<br/>
 * @author Allen
 * @version 1.0
 */
@Configuration
public class SchQuartzConfig {
    
    @Value("${sch.quartzProperties.quartz.scheduler.instanceName}")
    private String instanceName;
    
    @Value("${sch.quartzProperties.quartz.scheduler.instanceId}")
    private String instanceId;
    
    @Value("${sch.quartzProperties.quartz.threadPool.class}")
    private String threadPoolClass;
    
    @Value("${sch.quartzProperties.quartz.threadPool.threadCount}")
    private String threadCount;
    
    @Value("${sch.quartzProperties.quartz.threadPool.threadPriority}")
    private String threadPriority;
    
    @Value("${sch.quartzProperties.quartz.jobStore.class}")
    private String jobStoreClass;
    
    @Value("${sch.quartzProperties.quartz.jobStore.isClustered}")
    private String isClustered;
    
    @Value("${sch.quartzProperties.quartz.jobStore.clusterCheckinInterval}")
    private String clusterCheckinInterval;
    
    @Value("${sch.quartzProperties.quartz.jobStore.maxMisfiresToHandleAtATime}")
    private String maxMisfiresToHandleAtATime;
    
    @Value("${sch.quartzProperties.quartz.jobStore.misfireThreshold}")
    private String misfireThreshold;
    
    @Value("${sch.quartzProperties.quartz.jobStore.tablePrefix}")
    private String tablePrefix;

    @Value("${sch.quartzProperties.quartz.jobStore.driverDelegateClass}")
    private String driverDelegateClass;
    
    @Value("${sch.schedulerName}")
    private String schedulerName;
    
    @Value("${sch.startupDelay}")
    private int startupDelay;
    
    @Value("${sch.applicationContextSchedulerContextKey}")
    private String applicationContextSchedulerContextKey;
    
    @Value("${sch.overwriteExistingJobs}")
    private boolean overwriteExistingJobs;
    
    @Value("${sch.autoStartup}")
    private boolean autoStartup;
    
    @Autowired
    private DataSource dataSource;
    
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(){
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setDataSource(dataSource);
        
        Properties quartzProperties = new Properties();
        quartzProperties.setProperty("org.quartz.scheduler.instanceName", instanceName);
        quartzProperties.setProperty("org.quartz.scheduler.instanceId", instanceId);
        quartzProperties.setProperty("org.quartz.threadPool.class", threadPoolClass);
        quartzProperties.setProperty("org.quartz.threadPool.threadCount", threadCount);
        quartzProperties.setProperty("org.quartz.threadPool.threadPriority", threadPriority);
        quartzProperties.setProperty("org.quartz.jobStore.class", jobStoreClass);
        quartzProperties.setProperty("org.quartz.jobStore.isClustered", isClustered);
        quartzProperties.setProperty("org.quartz.jobStore.clusterCheckinInterval", clusterCheckinInterval);
        quartzProperties.setProperty("org.quartz.jobStore.maxMisfiresToHandleAtATime", maxMisfiresToHandleAtATime);
        quartzProperties.setProperty("org.quartz.jobStore.misfireThreshold", misfireThreshold);
        quartzProperties.setProperty("org.quartz.jobStore.tablePrefix", tablePrefix);
        quartzProperties.setProperty("org.quartz.jobStore.driverDelegateClass", driverDelegateClass);
        schedulerFactoryBean.setQuartzProperties(quartzProperties);;
        
        schedulerFactoryBean.setSchedulerName(schedulerName);
        schedulerFactoryBean.setStartupDelay(startupDelay);
        schedulerFactoryBean.setApplicationContextSchedulerContextKey(applicationContextSchedulerContextKey);
        schedulerFactoryBean.setOverwriteExistingJobs(overwriteExistingJobs);
        schedulerFactoryBean.setAutoStartup(autoStartup);
        return schedulerFactoryBean;
    }
   
    
}
