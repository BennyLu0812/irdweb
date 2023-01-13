package com.ird.portal.sch.process.jobctrllog;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ird.portal.datatable.DataTablePage;
import com.ird.portal.datatable.DatatableDaoCmd;
import com.ird.portal.model.Page;
import com.ird.portal.sch.dao.Queries;
import com.ird.portal.sch.dao.SchDao;
import com.ird.portal.sch.dao.SchDaoCmd;
import com.ird.portal.sch.data.SchCtrlDTO;
import com.ird.portal.sch.data.SchCtrlLogDTO;
import com.ird.portal.sch.entity.SchCtrlLogEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 
 * 排程工作日志管理-查詢
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 2017年11月16日<br/>
 * 
 * @author Allen
 * @version 1.0
 */
@Component
public class JobCtrlLogQueryProcess {
    
    
    @Autowired
    private SchDao dao;
    
    public Page getPage(SchCtrlDTO schCtrlDTO) {
        DatatableDaoCmd daoCmd = new DatatableDaoCmd(Queries.SQL_FIND_SCHCTRLLOG_PAGE, schCtrlDTO);
        DataTablePage page = (DataTablePage) dao.getPage(daoCmd, SchCtrlLogDTO.class, true);
        return page;
    }
    
    public Page getPageByJobCtrlId(SchCtrlDTO schCtrlDTO) {
        DatatableDaoCmd daoCmd = new DatatableDaoCmd(Queries.SQL_FIND_SCHCTRLLOG_BY_SCHCTRLID_PAGE, schCtrlDTO);
        DataTablePage page = (DataTablePage)dao.getPage(daoCmd, SchCtrlLogDTO.class,true);
        return page;
    }
    
    public SchCtrlLogEntity getLatestJobByJobCtrlId(Long jobCtrlId) {
        final Map<String, Object> params = new HashMap<String, Object>();
        params.put("schCtrlId", jobCtrlId);
        SchDaoCmd cmd = new SchDaoCmd(Queries.HQL_FIND_SCHCTRLLOG_BY_SCHCTRLID, params);
        SchCtrlLogEntity entity = dao.getSingle(cmd, SchCtrlLogEntity.class, true);
        return entity;
    }
    
    public SchCtrlLogEntity getById(Long id) {
        return dao.getSingle(SchCtrlLogEntity.class, id);
    }
}
