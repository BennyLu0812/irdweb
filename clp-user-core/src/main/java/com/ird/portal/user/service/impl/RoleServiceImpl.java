package com.ird.portal.user.service.impl;

import com.ird.portal.common.user.data.RoleDTO;
import com.ird.portal.exception.ParameterIsEmptyException;
import com.ird.portal.exception.RecordExistException;
import com.ird.portal.exception.RecordNotFoundException;
import com.ird.portal.model.Page;
import com.ird.portal.user.entity.FuncEntity;
import com.ird.portal.user.entity.RoleEntity;
import com.ird.portal.user.entity.RoleFuncEntity;
import com.ird.portal.user.entity.RoleFuncPK;
import com.ird.portal.user.mapper.RoleFuncMapper;
import com.ird.portal.user.mapper.RoleMapper;
import com.ird.portal.user.service.FuncService;
import com.ird.portal.user.service.RoleService;
import com.ird.portal.user.util.ConstantUtil;
import com.ird.portal.user.util.UserModuleUtil;
import com.ird.portal.util.BeanMapper;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * 
 * 角色信息管理-查詢、新增、更新、刪除等.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 13/12/2017 15:54:29<br/>
 * 
 * @author Deft
 * @version 1.0
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    
    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleFuncMapper roleFuncMapper;
    
    @Autowired
    private BeanMapper beanMapper;
    
    @Autowired
    private FuncService funcService;
    
    @Override
    @Transactional(readOnly = true)
    public List<RoleEntity> getRoleList(RoleDTO dto) {
        return roleMapper.getList(dto);
    }
    
    @Override
    @Transactional(readOnly = true)
    public RoleEntity getById(Long id) {
        return roleMapper.getSingle(id);
    }
    
    @Override
    public void add(RoleDTO dto) {
        RoleEntity temp = getRoleByCode(dto.getRole());
        if (temp != null) {
            throw new RecordExistException("roleCode=" + dto.getRole());
        }
        
        RoleEntity entity = beanMapper.mapTo(dto, RoleEntity.class);
        if (dto.getFuncIds() != null && dto.getFuncIds().length > 0) {
            List<FuncEntity> list = funcService.getFuncByIds(dto.getFuncIds());
            entity.setFuncs(new TreeSet<FuncEntity>(list));
        }
        entity.setStatus(ConstantUtil.ROLE_STATUS_ACTIVE);
        roleMapper.insert(entity);
    }
    
    private RoleEntity getRoleByCode(String roleCode) {
        return roleMapper.getRoleByCode(roleCode);
    }
    
    @Override
    public void update(RoleDTO dto) {
        RoleEntity entity = getById(dto.getRoleId());
        if (entity == null) {
            throw new RecordNotFoundException("roleId=" + dto.getRoleId());
        }
        RoleEntity temp = getRoleByCode(dto.getRole());
        if (temp != null && !temp.getRoleId().equals(dto.getRoleId())) {
            throw new RecordExistException("roleCode=" + dto.getRole());
        }
        
        if (StringUtils.isNotBlank(dto.getRole())) {
            entity.setRole(dto.getRole());
        }
        if (StringUtils.isNotBlank(dto.getStatus())) {
            entity.setStatus(dto.getStatus());
        }
        if (StringUtils.isNotBlank(dto.getRoleDesc())) {
            entity.setRoleDesc(dto.getRoleDesc());
        }

        // 處理角色和功能代碼關聯
        final List<FuncEntity> funcEntityList = new ArrayList<FuncEntity>(entity.getFuncs());
        if (dto.getFuncIds() != null && dto.getFuncIds().length > 0) {
            final List<FuncEntity> newFuncList = funcService.getFuncByIds(dto.getFuncIds());
            //先判斷頁面新賦予的權限有哪些，做新增處理
            for (FuncEntity funcEntity : newFuncList) {
                if (!UserModuleUtil.myFuncListContains(funcEntityList, funcEntity)) {
                    this.addRoleFunc(dto.getRoleId(), funcEntity.getFuncId());
                }
            }
            //再判斷頁面有哪些權限被刪除，做刪除處理
            for (FuncEntity funcEntity : funcEntityList) {
                if(!UserModuleUtil.myFuncListContains(newFuncList, funcEntity)) {
                    this.deleteRoleFunc(dto.getRoleId(), funcEntity.getFuncId());
                }
            }
        } else {
            if(CollectionUtils.isNotEmpty(funcEntityList)) {
                for(FuncEntity funcEntity : funcEntityList) {
                    this.deleteRoleFunc(dto.getRoleId(), funcEntity.getFuncId());
                }
            }
        }

        roleMapper.update(entity);
    }

    /**
     * 根據角色id和功能id添加一個關聯記錄
     * @param roleId
     * @param funcId
     */
    private void addRoleFunc(Long roleId, Long funcId){
        if(roleId == null){
            throw new ParameterIsEmptyException("roleId is null");
        }
        if(funcId == null){
            throw new ParameterIsEmptyException("funcId is null");
        }
        final RoleFuncEntity roleFuncEntity = new RoleFuncEntity();
        roleFuncEntity.setRoleId(roleId);
        roleFuncEntity.setFuncId(funcId);
        roleFuncMapper.insert(roleFuncEntity);
    }

    /**
     * 根據角色id和功能id刪除一個關聯記錄
     * @param roleId
     * @param funcId
     */
    private void deleteRoleFunc(Long roleId, Long funcId){
        if(roleId == null){
            throw new ParameterIsEmptyException("roleId is null");
        }
        if(funcId == null){
            throw new ParameterIsEmptyException("funcId is null");
        }
        final RoleFuncPK roleFuncPK = new RoleFuncPK(roleId, funcId);
        final RoleFuncEntity roleFuncEntity = roleFuncMapper.getSingle(roleFuncPK);
        if(roleFuncEntity != null){
            roleFuncMapper.delete(roleFuncEntity);
        }else{
            throw new RecordNotFoundException("roleFuncEntity is null");
        }

    }
    
    @Override
    public void delete(Long id) {
        roleMapper.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Page getRolePage(RoleDTO dto) {
        return roleMapper.getPage(dto);
    }
    
    @Override
    public List<RoleEntity> getRoleByIds(Long[] roleIds) {
        return roleMapper.getByIds(roleIds);
    }
    
}
