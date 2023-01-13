package com.ird.portal.sch.service;

import com.ird.portal.model.Page;
import com.ird.portal.sch.data.SchCtrlDTO;
import com.ird.portal.sch.entity.SchCtrlEntity;

import java.util.List;

/**
 * 
 * 排程管理接口. 方法：分頁查詢  新增  更新  根據id查詢  獲取全部  刪除  暫停  開始  重啓動  運行一次  恢復重新開始.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 2017年11月16日<br/>
 * 
 * @author Allen
 * @version 1.0
 */
public interface JobCtrlService {
    
    
    Page getPage(SchCtrlDTO schCtrlDTO);
    
    SchCtrlEntity add(SchCtrlEntity schCtrlEntity);
    
    SchCtrlEntity update(SchCtrlEntity schCtrlEntity);
    
    SchCtrlEntity getById(Long id);
    
    List<SchCtrlDTO> getList();
    
    void delete(Long id);
    
    void pause(Long id);
    
    void start(Long id);
    
    void restart(Long id);
    
    void runOnce(Long id);
    
    void resume(Long id);
}
