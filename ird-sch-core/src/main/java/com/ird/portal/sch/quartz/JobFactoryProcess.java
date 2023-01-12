/**
 * @Project Name: dls-sch-core
 * @File Name: JobFactoryProcess.java
 * @Date: Nov 21, 2017
 * @Copyright: Copyright (c) 2017 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.sch.quartz;

import com.ird.portal.exception.BaseException;
import com.ird.portal.sch.BatchResult;
import com.ird.portal.sch.Constants;
import com.ird.portal.sch.JobStatus;
import com.ird.portal.sch.Task;
import com.ird.portal.sch.data.SchCtrlDTO;
import com.ird.portal.sch.entity.SchCtrlLogEntity;
import com.ird.portal.sch.exception.ScheduleException;
import com.ird.portal.sch.service.JobCtrlLogService;
import com.ird.portal.user.User;
import com.ird.portal.user.UserContext;
import com.ird.portal.util.SpringContextUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;

import java.util.Date;

/**
 * 排程管理
 *
 * <br/>
 * <br/>
 * <b>Date:</b> Nov 21, 2017<br/>
 * 
 * @author Allen
 * @version 1.0
 */
public class JobFactoryProcess {
    
    public static final String USER_ID = "IRDJOB";

	private static final Logger LOG = LoggerFactory.getLogger(JobFactoryProcess.class);
    
    private static final String SCHEDULE_USER_ID = USER_ID; 
    
    public static void execute(SchCtrlDTO schCtrlDTO) {
        if (schCtrlDTO == null) {
            LOG.error("{} 獲取的值為空.", Constants.JOB_PARAM_KEY);
             throw new ScheduleException(Constants.JOB_PARAM_KEY + " 獲取的值為空.");
        }
        switch (schCtrlDTO.getJobType()) {
            case SchCtrlDTO.JOB_TYPE_JAVA:
            case SchCtrlDTO.JOB_TYPE_JAVA_NOLOG:
                executeByClass(schCtrlDTO);
                break;
            case SchCtrlDTO.JOB_TYPE_PLSQL:
                 executeByPLSQL(schCtrlDTO);
                break;
            default:
                LOG.error("job type is {}, no execute.", schCtrlDTO.getJobType());
                break;
        }
    }
    
    private static void executeByClass(SchCtrlDTO schCtrlDTO) {
        LOG.debug("加載類：{}", schCtrlDTO.getClsName());
        Class<?> requiredType = null;
        try {
            requiredType = Class.forName(StringUtils.trim(schCtrlDTO.getClsName()));
        }
        catch (ClassNotFoundException e) {
            LOG.error("類：{} 不存在系統中.", schCtrlDTO.getClsName());
            return;
        }
        
        //TODO base on job type to write audit log
//        String jobType = schCtrlDTO.getJobType();
        
        //Check if task is ready to execute
        JobCtrlLogService jobCtrlLogService = SpringContextUtil.getBean(JobCtrlLogService.class);
        if (!isReadyToExecute(schCtrlDTO, jobCtrlLogService)) {
        	return;
        }

        User user = new User();
    	user.setUserId(USER_ID);
    	user.setUserName(USER_ID);
		UserContext.setUser(user);
        
        Task task = null;
        try {
            task = (Task)SpringContextUtil.getBean(requiredType);
        }
        catch (Exception e) {
            if (e instanceof BeansException) {
                LOG.error("{} 不是Spring Bean，可能沒有加入@Component或者沒有被Spring掃描到該類.", requiredType.getName());
                try {
                    task = (Task)requiredType.newInstance();
                }
                catch (InstantiationException | IllegalAccessException e1) {
                    LOG.error("實例化類 {} 出錯.", requiredType.getName());
                }
            }
            else {
                LOG.error("獲取類{} 的Spring bean報錯.", requiredType.getName());
            }
            throw new RuntimeException("獲取Task報錯.", e);
        }
        
        // Set new schCtrlLog
        
        SchCtrlLogEntity schCtrlLogEntity = new SchCtrlLogEntity();
        schCtrlLogEntity.setSchCtrlId(schCtrlDTO.getId());
        schCtrlLogEntity.setJobCode(schCtrlDTO.getJobCode());
        schCtrlLogEntity.setCreateUser(SCHEDULE_USER_ID);
        schCtrlLogEntity.setCreateDate(new Date());
        schCtrlLogEntity.setLatestJobInd(true);
        schCtrlLogEntity.setStartTime(new Date());
        schCtrlLogEntity.setStatus(JobStatus.PROGRESS.toString());
        jobCtrlLogService.save(schCtrlLogEntity);
        
        // execute
        BatchResult result = null;
        try {
            result = task.execute(schCtrlDTO);
            
        }
        catch (Exception e) {
			schCtrlLogEntity.setStatus(JobStatus.FAILED.toString());
			if (e instanceof BaseException) {
				schCtrlLogEntity.setErrorCode(((BaseException) e).getErrorCode());
				schCtrlLogEntity.setErrorMsg(((BaseException) e).getMessage());
			} else {
				schCtrlLogEntity.setErrorMsg(e.getMessage());
			}
        } finally {
        	if (result != null) {
        		if (result.getException() != null) {
        			LOG.error("Execute job name:{}, job class:{} job ctrl id:{} FAIL.", schCtrlDTO.getJobCode(), schCtrlDTO.getClsName(), schCtrlDTO.getId());
        			schCtrlLogEntity.setStatus(JobStatus.FAILED.toString());
        			schCtrlLogEntity.setErrorCode(result.getException().getErrorCode());
        			schCtrlLogEntity.setErrorMsg(result.getException().getMessage());        			
        		} else if (!StringUtils.equals(schCtrlLogEntity.getStatus(), JobStatus.FAILED.toString())) {
                    LOG.info("Execute job name:{}, job class:{} job ctrl id:{} SUCCESS.", schCtrlDTO.getJobCode(), schCtrlDTO.getClsName(), schCtrlDTO.getId());
        			schCtrlLogEntity.setStatus(JobStatus.COMPLETE.toString());        			
        		}
        		schCtrlLogEntity.setEndTime(new Date());
        		schCtrlLogEntity.setRecDelete(result.getCountDelete());
        		schCtrlLogEntity.setRecInsert(result.getCountInsert());
        		schCtrlLogEntity.setRecPending(result.getPendingTotal());
        		schCtrlLogEntity.setRecProcessed(result.getCountProcess());
        		schCtrlLogEntity.setRecUpdate(result.getCountUpdate());
        	}
        	
        	jobCtrlLogService.update(schCtrlLogEntity);
        }
        
    }
    
    private static void executeByPLSQL(SchCtrlDTO schCtrlDTO) {
        LOG.debug("加載PLSQL：{}", schCtrlDTO.getClsName());

        JobCtrlLogService jobCtrlLogService = SpringContextUtil.getBean(JobCtrlLogService.class);
        if (isReadyToExecute(schCtrlDTO, jobCtrlLogService)) {
	        // execute PLSQL
        	// check if ClsName exists and throw exception
	        try {
	        	if (StringUtils.isBlank(schCtrlDTO.getClsName())) {
	                LOG.error("Class Name is empty.");
	                return;
	        	}
	            jobCtrlLogService.executePLSQL(schCtrlDTO.getClsName());
	        } catch (Exception e) {
//	            LOG.error("execute job name:" + schCtrlDTO.getJobCode() + "  job class:" + schCtrlDTO.getClsName() + " is error.", e);
				LOG.error("Execute PLSQL job name:" + schCtrlDTO.getJobCode() + "  job class:" + schCtrlDTO.getClsName() + " FAIL.", e);
	        }
			LOG.info("Execute PLSQL job name:" + schCtrlDTO.getJobCode() + "  job class:" + schCtrlDTO.getClsName() + " COMPLETE.");
        }
    }
    
    private static boolean isReadyToExecute(SchCtrlDTO schCtrlDTO, JobCtrlLogService jobCtrlLogService) {
    	boolean ready = false;
    	
        SchCtrlLogEntity _jobCtrlLog = jobCtrlLogService.getLatestJobByJobCtrlId(schCtrlDTO.getId());
        
        if (_jobCtrlLog != null) {
            if (JobStatus.COMPLETE.toString().equals(_jobCtrlLog.getStatus())) {
                _jobCtrlLog.setLatestJobInd(false);
                jobCtrlLogService.update(_jobCtrlLog);
                ready = true;
                LOG.info("Update previous job {} latest job ind to {} ", schCtrlDTO.getJobCode(), false);
            } else if (JobStatus.PROGRESS.toString().equals(_jobCtrlLog.getStatus())) {
                LOG.info("Previous job {} is still in processing. ", schCtrlDTO.getJobCode());
                LOG.info("Job Name:{} has not executed. Exit now.", schCtrlDTO.getJobCode());
            } else {
                LOG.warn("Previous job {} has not finished, Job Start Failed,Job status {}. jobCtrlDTO.getId()={}", schCtrlDTO.getJobCode(), _jobCtrlLog.getStatus(), schCtrlDTO.getId());
            }
        } else {
        	//1st job instance, no previous job log
        	ready = true;
        }
    	
    	return ready;
    }
    
}
