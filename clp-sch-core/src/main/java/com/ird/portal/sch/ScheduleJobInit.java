/**
 * @Project Name: dls-sch-core
 * @File Name: ScheduleJobInit.java
 * @Date: Nov 29, 2017
 * @Copyright: Copyright (c) 2017 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.sch;

import com.ird.portal.sch.data.SchCtrlDTO;
import com.ird.portal.sch.service.JobCtrlService;
import com.ird.portal.sch.util.ScheduleUtils;
import org.apache.commons.lang3.StringUtils;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

//import org.quartz.JobKey;
//import org.quartz.impl.matchers.GroupMatcher;

/**
 * 排程管理初始化
 *
 * <br/>
 * <br/>
 * <b>Date:</b> Nov 29, 2017<br/>
 * 
 * @author Allen
 * @version 1.0
 */
@Component
public class ScheduleJobInit {
    
    private static final Logger logger = LoggerFactory.getLogger(ScheduleJobInit.class);
    
    @Autowired
    private JobCtrlService jobCtrlService;
    
    @Autowired
    private Scheduler scheduler;
    
    @PostConstruct
    public void init()
        throws SchedulerException {
        
//        List<String> jobGroupNames = scheduler.getJobGroupNames();
//        for (String jobGroup : jobGroupNames) {
//            for (JobKey jobKey : scheduler.getJobKeys(GroupMatcher.jobGroupEquals(jobGroup))) {
//                logger.debug("Current JOB : {}", jobKey);
//                scheduler.deleteJob(jobKey);
//            }
//        }
        
        List<SchCtrlDTO> list = jobCtrlService.getList();
        logger.info("job size: {}", list.size());
        
        if (list.isEmpty()) {
            return;
        }
        for (SchCtrlDTO job : list) {
            if (SchCtrlDTO.JOB_TYPE_TRIGGER.equals(job.getJobType())) {
                logger.info("job name:{} is trigger,don't execute.", job.getJobCode());
                continue;
            }
            if (job.getEnabled() != null && !job.getEnabled().booleanValue()) {
                logger.info("job name:{} , job id:{} is disabled.", job.getJobCode(), job.getId());
                continue;
            }
            if (StringUtils.isBlank(job.getCronChar())) {
                logger.error("job name:{} cronChar is null,don't execute.", job.getJobCode());
                continue;
            }
            job.setJobGroup(Constants.JOB_GROUP);
            try {
                ScheduleUtils.createOrUpdateScheduleJob(scheduler, job);
                logger.info("job name:{} , job id:{} is initialized.", job.getJobCode(), job.getId());
            }
            catch (Exception e) {
                logger.error("初始化job:{} 錯誤.", job.getJobCode());
                logger.error(String.format("初始化job: %s 錯誤.", job.getJobCode()), e);
            }
        }
        
        if (logger.isInfoEnabled()) {
            logger.info("End 初始化定時任務.");
        }
    }
}
