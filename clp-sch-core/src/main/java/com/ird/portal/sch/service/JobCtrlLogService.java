package com.ird.portal.sch.service;

import com.ird.portal.model.Page;
import com.ird.portal.sch.data.SchCtrlDTO;
import com.ird.portal.sch.entity.SchCtrlLogEntity;

/**
 * 
 * 排程日志管理接口. 方法：分頁查詢  新增  更新 根據id查詢  根據jobCtrlId分頁查詢  獲取最新工作日子  执行PLSQL 刪除.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 2017年11月16日<br/>
 * 
 * @author Allen
 * @version 1.0
 */
public interface JobCtrlLogService {
    
    
     Page getPage(SchCtrlDTO schCtrlDTO);
    
     SchCtrlLogEntity save(SchCtrlLogEntity schCtrlLogEntity);
    
     SchCtrlLogEntity update(SchCtrlLogEntity schCtrlLogEntity);
    
     SchCtrlLogEntity getById(Long id);
    
     Page getJobCtrlLogPageByJobCtrlId(SchCtrlDTO schCtrlDTO);
    
     SchCtrlLogEntity getLatestJobByJobCtrlId(Long jobCtrlId);
     
     void executePLSQL(String plsqlName);
     
     void deleteById(Long id);
}
