package com.ird.portal.sys.service;

import com.ird.portal.common.sys.data.SysParamDTO;
import com.ird.portal.model.Page;
import com.ird.portal.sys.entity.ParamsEntity;

import java.util.List;

/**
 * 
 * 系統參數管理. 方法: 新增、更新、刪除、分頁查詢.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 16/11/2017 10:16:04<br/>
 * 
 * @author Deft
 * @version 1.0
 */
public interface ParamsService {
    
    /**
     * 新增.
     * 
     * @param entity
     * @return
     */
    ParamsEntity add(ParamsEntity entity);
    
    
    /**
     * 更新.
     * 
     * @param entity
     * @return
     */
    ParamsEntity update(ParamsEntity entity);
    
    /**
     * 分頁查詢.
     * 
     * @param dto
     * @return
     */
    Page getPage(SysParamDTO dto);
    
    /**
     * 根據ID查詢.
     * 
     * @param paramName
     * @return ParamEntity
     */
    ParamsEntity getByName(String paramName);
    
    /**
     * 刪除-根據系統參數.
     * @param paramName
     */
    void delete(String paramName);

    List<SysParamDTO> getAllParams();

    /**
     * 由DB重新加載值到redis
     */
    void reloadSysParams();
    
}
