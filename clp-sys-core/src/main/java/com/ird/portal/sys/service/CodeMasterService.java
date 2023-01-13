package com.ird.portal.sys.service;

import com.ird.portal.common.sys.data.CodeMasterDTO;
import com.ird.portal.model.Page;
import com.ird.portal.sys.entity.CodeMasterEntity;

/**
 * 
 * 系統代碼Master的相關服務接口
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 03/05/2018 15:36:03<br/>
 * @author Jim
 * @version 1.0
 */
public interface CodeMasterService {   
    
    /**
     * 更新實體
     * 
     * @param codeMasterEntity
     * @return
     */
    CodeMasterEntity update(CodeMasterEntity codeMasterEntity);
    
    /**
     * 獲取實體
     * 
     * @param codeMasterType
     * @return
     */
    CodeMasterEntity getById(Integer codeMasterType);
    
    /**
     * 分頁查詢列表
     * 
     * @param codeMasterDTO: 包含所有查詢條件
     * @return
     */
    Page getPage(CodeMasterDTO codeMasterDTO);
}
