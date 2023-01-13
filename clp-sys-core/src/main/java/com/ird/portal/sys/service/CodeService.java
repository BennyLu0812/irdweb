package com.ird.portal.sys.service;

import com.ird.portal.common.sys.data.CodeDTO;
import com.ird.portal.model.Page;
import com.ird.portal.sys.entity.CodeEntity;

import java.util.List;

/**
 * 
 * 系統代碼管理. 方法: 新增、更新、刪除、分頁查詢.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 16/11/2017 10:14:46<br/>
 * 
 * @author Deft
 * @version 1.0
 */
public interface CodeService {
       
    /**
     * 保存實體
     * 
     * @param codeEntity
     * @return
     */
    CodeEntity add(CodeEntity codeEntity);
    
    /**
     * 更新實體
     * 
     * @param codeEntity
     * @return
     */
    CodeEntity update(CodeEntity codeEntity);
    
    /**
     * 獲取實體
     * 
     * @param id
     * @return
     */
    CodeEntity getById(Integer id);
   
    /**
     * 分頁查詢列表
     * 
     * @param codeDTO
     * @return
     */
    Page getPage(CodeDTO codeDTO);
    /**
     * 更新代碼狀態
     * @param codeId
     * @param originalStatus
     * @param updateStatus
     * @return
     */
    CodeDTO UpdateCodesStatus(Integer codeId, String originalStatus, String updateStatus);
    /**
     * 驗證代碼類型唯一
     * @param codeEntity
     */
    void CodeTypeOnlyProcess(CodeEntity codeEntity);
    
    CodeDTO getCodeByTypeAndCode(Integer codeType, String codeKey);
    
    /**
     * 根據系統代碼查詢有效記錄 
     * @param codeType
     * @return
     */
    public List<CodeEntity> getListByCodeType(Integer codeType);
}
