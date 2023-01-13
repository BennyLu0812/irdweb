package com.ird.portal.sch.service.impl;

import com.ird.portal.audit.AuditContext;
import com.ird.portal.model.Page;
import com.ird.portal.sch.dao.SchDao;
import com.ird.portal.sch.data.SchCtrlDTO;
import com.ird.portal.sch.entity.SchCtrlEntity;
import com.ird.portal.sch.process.jobctrl.*;
import com.ird.portal.sch.service.JobCtrlService;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 
 * 排程日志管理.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 2017年11月16日<br/>
 * 
 * @author Allen
 * @version 1.0
 */
@Service
@Transactional
public class JobCtrlServiceImpl implements JobCtrlService {
    
    
    @Autowired
    private JobCtrlQueryProcess jobCtrlQueryProcess;
    
    @Autowired
    private JobCtrlAddProcess jobCtrlAddProcess;
    
    @Autowired
    private JobCtrlDelProcess jobCtrlDelProcess;
    
    @Autowired
    private JobCtrlUpdateProcess jobCtrlUpdateProcess;
    
    @Autowired
    private JobCtrlUpdateStatusProcess jobCtrlUpdateStatusProcess;

    @Autowired
    private SchDao dao;

    private static String SCH_PAUSE = "P";

    private static String SCH_RUN = "Y";

    private static final String JOB_CODE = "任務名稱：";
	
	private static final Logger LOG = LoggerFactory.getLogger(JobCtrlServiceImpl.class);
    
    @Override
    @Transactional(readOnly = true)
    public Page getPage(SchCtrlDTO schCtrlDTO) {
        return jobCtrlQueryProcess.getPage(schCtrlDTO);
    }
    
    @Override
    public SchCtrlEntity add(SchCtrlEntity schCtrlEntity) {
    	LOG.info("Adding new SchCtrlEntity: {}", ReflectionToStringBuilder.toString(schCtrlEntity));
        AuditContext.getInstance().setRemark(JOB_CODE + schCtrlEntity.getJobCode());
        return jobCtrlAddProcess.add(schCtrlEntity);
    }
    
    @Override
    public SchCtrlEntity update(SchCtrlEntity schCtrlEntity) {
    	LOG.info("Updating schCtrlEntity: {}", ReflectionToStringBuilder.toString(schCtrlEntity));
        AuditContext.getInstance().setRemark(JOB_CODE + schCtrlEntity.getJobCode());
        return jobCtrlUpdateProcess.update(schCtrlEntity);
    }
    
    @Override
    @Transactional(readOnly = true)
    public SchCtrlEntity getById(Long id) {
        return jobCtrlQueryProcess.getById(id);
    }
    
    @Override
    public void delete(Long id) {
        jobCtrlDelProcess.delete(id);
    }
    
    /**
     * 暫停排程工作
     */
    @Override
    public void pause(Long id) {
        this.setAuditRemark(id);
        jobCtrlUpdateStatusProcess.pauseJob(id);
        updateSchCtrlStatus(id, SCH_PAUSE);
    }


    
    /**
     * 開啓排程工作
     */
    @Override
    public void start(Long id) {
        this.setAuditRemark(id);
        jobCtrlUpdateStatusProcess.startJob(id);
        updateSchCtrlStatus(id, SCH_RUN);
    }
    
    
    /**
     * 重啓動排程工作
     */
    @Override
    public void restart(Long id) {
        this.setAuditRemark(id);
        jobCtrlUpdateStatusProcess.restartJob(id);
        updateSchCtrlStatus(id, SCH_RUN);
    }

    private void updateSchCtrlStatus(Long schId, String workStatus) {
        SchCtrlEntity entity = dao.getSingle(SchCtrlEntity.class, schId);
        entity.setWorkStatus(workStatus);
        jobCtrlUpdateProcess.update(entity);
    }
    
    /**
     * 運行一次排程工作
     */
    @Override
    public void runOnce(Long id) {
        this.setAuditRemark(id);
        jobCtrlUpdateStatusProcess.runOnce(id);
    }
    
    /**
     * 恢復-重新運行
     */
    @Override
    public void resume(Long id) {
        jobCtrlUpdateStatusProcess.resumeJob(id);
    }

    /**
     * 獲得全部排程工作
     */
    @Override
    public List<SchCtrlDTO> getList() {
        return jobCtrlQueryProcess.getList();
    }

    /**
     * 記錄audit備註
     * @param id 排程id
     */
    private void setAuditRemark(final Long id) {
        final SchCtrlEntity entity = jobCtrlQueryProcess.getById(id);
        AuditContext.getInstance().setRemark(JOB_CODE + entity.getJobCode());
    }
    
}
