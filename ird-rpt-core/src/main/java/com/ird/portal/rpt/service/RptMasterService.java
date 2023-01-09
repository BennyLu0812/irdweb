package com.ird.portal.rpt.service;

import com.ird.portal.common.rpt.data.RptMasterDTO;
import com.ird.portal.model.Page;
import com.ird.portal.rpt.entity.RptMasterEntity;
/**
 * 
 * 报表管理.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 04/01/2018 16:58:09<br/>
 * @author Deft
 * @version 1.0
 */
public interface RptMasterService {
    /**
     * 分頁查詢.
     * 
     * @param dto
     * @return
     */
    Page getPage(RptMasterDTO dto);
    
    /**
     * 根據ID查詢.
     * 
     * @param id
     * @return RptMasterEntity
     */
    RptMasterEntity getById(String id);


}
