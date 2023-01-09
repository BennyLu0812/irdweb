
package com.ird.portal.user.service;

import com.ird.portal.common.user.data.RoleDTO;
import com.ird.portal.model.Page;
import com.ird.portal.user.entity.RoleEntity;

import java.util.List;

/**
 * 
 * 角色信息管理的接口-查詢、新增、更新、刪除.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 13/12/2017 10:33:40<br/>
 * 
 * @author Deft
 * @version 1.0
 */
public interface RoleService {
    
    /**
     * 查詢全部.
     * 
     * @param dto
     * @return
     */
    List<RoleEntity> getRoleList(RoleDTO dto);
    
    /**
     * Id單個查詢.
     * 
     * @param id
     * @return
     */
    RoleEntity getById(Long id);
    
    /**
     * 新增.
     * 
     * @param dto
     */
    void add(RoleDTO dto);
    
    /**
     * 更新.
     * 
     * @param dto
     */
    void update(RoleDTO dto);
    
    /**
     * 刪除.
     * 
     * @param id
     */
    void delete(Long id);
    
    /**
     * 分頁查詢
     * 
     * @param dto
     * @return
     */
    Page getRolePage(RoleDTO dto);

    List<RoleEntity> getRoleByIds(Long[] roleIds);
    
}
