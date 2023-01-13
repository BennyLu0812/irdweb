/**
 * @Project Name: dls-sch-core
 * @File Name: JobCtrlUpdateStatusProcess.java
 * @Date: Nov 21, 2017
 * @Copyright: Copyright (c) 2017 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.sch.process.jobctrl;

import com.ird.portal.sch.Constants;
import com.ird.portal.sch.dao.SchDao;
import com.ird.portal.sch.data.SchCtrlDTO;
import com.ird.portal.sch.entity.SchCtrlEntity;
import com.ird.portal.sch.quartz.JobFactory;
import com.ird.portal.sch.quartz.JobFactoryProcess;
import com.ird.portal.sch.util.ScheduleUtils;
import com.ird.portal.util.BeanMapper;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 排程工作任務：啓動,暫停,重啓動,運行一次;
 *
 * <br/>
 * <br/>
 * <b>Date:</b> Nov 21, 2017<br/>
 * 
 * @author Allen
 * @version 1.0
 */
@Component
public class JobCtrlUpdateStatusProcess {
    
    
    private static final Logger log = LoggerFactory.getLogger(JobFactory.class);
    
    @Autowired
    private SchDao dao;
    
    @Autowired
    private BeanMapper beanMapper;
    
    @Autowired
    private Scheduler scheduler;
    
    public SchCtrlDTO startJob(Long id) {
        SchCtrlEntity entity = dao.getSingle(SchCtrlEntity.class, id);
        if (entity == null) {
            // throw new RecordNotFoundException(dto.getId());
            log.error(" startJob id is {},no execute", id);
            return null;
        }
        SchCtrlDTO schCtrlDTO = beanMapper.map(entity, SchCtrlDTO.class);
        schCtrlDTO.setJobGroup(Constants.JOB_GROUP);
        
        try {
            // 先暫停 再恢復
            ScheduleUtils.pauseJob(scheduler, entity.getJobCode(), Constants.JOB_GROUP);
        }
        catch (Exception e) {
            log.error("暫停 job name:{} 錯誤.", schCtrlDTO.getJobCode());
            log.error(String.format("暫停 job name:%s 錯誤.", schCtrlDTO.getJobCode()), e);
        }
        try {
            Thread.sleep(20 * 1000L);
        }
        catch (InterruptedException e) {
            log.error("Thread.sleep(20 * 1000L) is error.", e);
            Thread.currentThread().interrupt();
        }
        try {
            ScheduleUtils.createOrUpdateScheduleJob(scheduler, schCtrlDTO);
        }
        catch (SchedulerException e) {
            log.error("初始化job:{} 錯誤.", schCtrlDTO.getJobCode());
            log.error(String.format("初始化job: %s 錯誤.", schCtrlDTO.getJobCode()), e);
        }
        return schCtrlDTO;
    }
    
    public SchCtrlDTO pauseJob(Long id) {
        SchCtrlEntity entity = dao.getSingle(SchCtrlEntity.class, id);
        if (entity == null) {
            log.error(" jobCtrl id is {},no execute", id);
            return null;
        }
        ScheduleUtils.pauseJob(scheduler, entity.getJobCode(), Constants.JOB_GROUP);
        return beanMapper.map(entity, SchCtrlDTO.class);
    }
    
    public SchCtrlDTO restartJob(Long id) {
        SchCtrlEntity entity = dao.getSingle(SchCtrlEntity.class, id);
        if (entity == null) {
            log.error(" restartJob id is {},no execute", id);
            return null;
        }
        // 先暫停 再恢復
        ScheduleUtils.pauseJob(scheduler, entity.getJobCode(), Constants.JOB_GROUP);
        try {
            Thread.sleep(20 * 1000L);
            Thread.currentThread().interrupt();
        }
        catch (InterruptedException e) {
            log.error("Thread.sleep(20 * 1000L) is error.", e);
            Thread.currentThread().interrupt();
        }
        
        SchCtrlDTO schCtrlDTO = beanMapper.map(entity, SchCtrlDTO.class);
        schCtrlDTO.setJobGroup(Constants.JOB_GROUP);
        ScheduleUtils.updateScheduleJob(scheduler, schCtrlDTO);
        return schCtrlDTO;
    }
    
    public SchCtrlDTO runOnce(Long id) {
        SchCtrlEntity entity = dao.getSingle(SchCtrlEntity.class, id);
        if (entity == null) {
            log.error(" runOnce id is {},no execute", id);
            return null;
        }
        SchCtrlDTO schCtrlDTO = beanMapper.map(entity, SchCtrlDTO.class);
        JobFactoryProcess.execute(schCtrlDTO);
        return schCtrlDTO;
    }
    
    public SchCtrlDTO resumeJob(Long id) {
        SchCtrlEntity entity = dao.getSingle(SchCtrlEntity.class, id);
        if (entity == null) {
            log.error(" resumeJob id is {},no execute", id);
            return null;
        }
        SchCtrlDTO schCtrlDTO = beanMapper.map(entity, SchCtrlDTO.class);
        schCtrlDTO.setJobGroup(Constants.JOB_GROUP);
        
        ScheduleUtils.resumeJob(scheduler, entity.getJobCode(), Constants.JOB_GROUP);
        ScheduleUtils.updateScheduleJob(scheduler, schCtrlDTO);
        return schCtrlDTO;
    }
    
}
