package com.ird.portal.sch.service.impl;

import com.ird.portal.model.Page;
import com.ird.portal.sch.data.SchCtrlDTO;
import com.ird.portal.sch.entity.SchCtrlLogEntity;
import com.ird.portal.sch.process.jobctrllog.JobCtrlLogAddProcess;
import com.ird.portal.sch.process.jobctrllog.JobCtrlLogDelProcess;
import com.ird.portal.sch.process.jobctrllog.JobCtrlLogQueryProcess;
import com.ird.portal.sch.process.jobctrllog.JobCtrlLogUpdateProcess;
import com.ird.portal.sch.service.JobCtrlLogService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
public class JobCtrlLogServiceImpl implements JobCtrlLogService {
    
    
    @Autowired
    private JobCtrlLogAddProcess jobCtrlLogAddProcess;
    
    @Autowired
    private JobCtrlLogDelProcess jobCtrlLogDelProcess;
    
    @Autowired
    private JobCtrlLogQueryProcess jobCtrlLogQueryProcess;
    
    @Autowired
    private JobCtrlLogUpdateProcess jobCtrlLogUpdateProcess;
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    @Transactional(readOnly = true)
    public Page getPage(SchCtrlDTO schCtrlDTO) {
        return jobCtrlLogQueryProcess.getPage(schCtrlDTO);
    }
    
    @Override
    public SchCtrlLogEntity save(SchCtrlLogEntity schCtrlLogEntity) {
        return jobCtrlLogAddProcess.save(schCtrlLogEntity);
    }
    
    @Override
    public SchCtrlLogEntity update(SchCtrlLogEntity schCtrlLogEntity) {
        return jobCtrlLogUpdateProcess.update(schCtrlLogEntity);
    }
    
    @Override
    @Transactional(readOnly = true)
    public SchCtrlLogEntity getById(Long id) {
        return jobCtrlLogQueryProcess.getById(id);
    }
    
    @Override
    public void deleteById(Long id) {
        jobCtrlLogDelProcess.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Page getJobCtrlLogPageByJobCtrlId(SchCtrlDTO schCtrlDTO) {
        return jobCtrlLogQueryProcess.getPageByJobCtrlId(schCtrlDTO);
    }

    
    @Override
    @Transactional(readOnly = true)
    public SchCtrlLogEntity getLatestJobByJobCtrlId(Long jobCtrlId) {
        return jobCtrlLogQueryProcess.getLatestJobByJobCtrlId(jobCtrlId);
    }

    /**
     * 执行PLSQL 存储过程.
     * 
     * @param plsqlName
     *            PLSQL call proc_stuInfo()
     */
    @Override
    @Transactional(readOnly = true)
    public void executePLSQL(String plsqlName) {
        Session session = (Session) entityManager.getDelegate();
        session.createSQLQuery(String.format("{call %s()}", plsqlName)).executeUpdate();
    }
    
}
