package com.ird.portal.user.process.role;

import com.ird.portal.common.user.data.RoleDTO;
import com.ird.portal.exception.RecordNotFoundException;
import com.ird.portal.user.dao.UserDao;
import com.ird.portal.user.entity.FuncEntity;
import com.ird.portal.user.entity.RoleEntity;
import com.ird.portal.user.process.func.FuncQueryProcess;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.TreeSet;

/**
 * 
 * 角色管理-更新. <br/>
 * <br/>
 * <b>Date:</b> 12/12/2017 14:35:43<br/>
 * 
 * @author Deft
 * @version 1.0
 */
@Component
public class RoleUpdateProcess {
    
    @Autowired
    private UserDao dao;
    
    @Autowired
    private FuncQueryProcess funcQueryProcess;
    
    public void update(RoleDTO dto) {
        RoleEntity entity = dao.getSingle(RoleEntity.class, dto.getRoleId());
        if (entity == null) {
            throw new RecordNotFoundException("roleId=" + dto.getRoleId());
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
        
        if (dto.getFuncIds() != null && dto.getFuncIds().length > 0) {
            List<FuncEntity> list = funcQueryProcess.getFuncByIds(dto.getFuncIds());
            entity.getFuncs().clear();
            entity.setFuncs(new TreeSet<FuncEntity>(list));
        }
        else {
            entity.getFuncs().clear();
        }
        
        dao.update(entity);
    }
}
