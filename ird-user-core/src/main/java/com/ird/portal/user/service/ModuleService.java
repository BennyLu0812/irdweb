package com.ird.portal.user.service;

import com.ird.portal.common.user.data.ModuleDTO;
import com.ird.portal.model.Page;
import com.ird.portal.user.entity.ModuleEntity;

import java.util.List;

/**
 * 
 * 模塊信息管理的接口-查詢、新增、更新、刪除.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 13/12/2017 10:33:40<br/>
 * 
 * @author Deft
 * @version 1.0
 */
public interface ModuleService {
    
    /**
     * 根據moduleId獲取模塊.
     * 
     * @param moduleId
     */
    ModuleEntity getById(Long moduleId);
    
    /**
     * 新增模塊記錄.
     * 
     * @param dto
     */
    void add(ModuleDTO dto);
    
    /**
     * 更新模塊記錄.
     * 
     * @param dto
     */
    void update(ModuleDTO dto);
    
    /**
     * 刪除.
     * 
     * @param id
     */
    void delete(Long id);
    
    /**
     * 分頁查詢.
     * 
     * @param dto
     * @return 模塊記錄列表
     */
    Page getPage(ModuleDTO dto);
    
    /**
     * 查詢所有.
     * 
     * @param dto
     * @return
     */
    List<ModuleEntity> getList(ModuleDTO dto);
    
    /**
     * 查询子节点.
     * 
     * @param moduleId
     * @return
     */
    List<ModuleEntity> getChildren(Long moduleId);
    
    /**
     * 查询父节点.
     * 
     * @param moduleId
     * @return
     */
    List<ModuleEntity> getTop(Long moduleId);
    
    /**
     * 
     * @param moduleId
     * @return
     */
    List<ModuleEntity> buildParent(Long moduleId);
}
