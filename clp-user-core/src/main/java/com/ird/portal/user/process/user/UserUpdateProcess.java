package com.ird.portal.user.process.user;

import com.ird.portal.common.user.data.UserDTO;
import com.ird.portal.exception.RecordNotFoundException;
import com.ird.portal.user.User;
import com.ird.portal.user.UserContext;
import com.ird.portal.user.dao.UserDao;
import com.ird.portal.user.entity.RoleEntity;
import com.ird.portal.user.entity.UserEntity;
import com.ird.portal.user.process.role.RoleQueryProcess;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.TreeSet;

/**
 * 
 * 用戶管理-跟新.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 12/12/2017 15:48:04<br/>
 * 
 * @author Deft
 * @version 1.0
 */
@Component("updateRoleProcess")
public class UserUpdateProcess {
    
    @Autowired
    private UserDao dao;
    
    @Autowired
    private RoleQueryProcess roleQueryProcess;
    
    public void update(UserDTO dto) {
        
        UserEntity entity = dao.getSingle(UserEntity.class, dto.getUserId());
        
        if (entity == null) {
            throw new RecordNotFoundException("userId=" + dto.getUserId());
        }
        if (StringUtils.isNotBlank(dto.getCnName())) {
            entity.setCnName(dto.getCnName());
        }
        if (StringUtils.isNotBlank(dto.getEnName())) {
            entity.setEnName(dto.getEnName());
        }
        if (StringUtils.isNotBlank(dto.getStatus())) {
            entity.setStatus(dto.getStatus());
        }
        User user = UserContext.getUser();
        if (user != null) {
            entity.setLastUpdUser(user.getUserId());
        }
        entity.setLastUpdDate(new Date());
        
        if (dto.getRoleIds() != null && dto.getRoleIds().length > 0) {
            List<RoleEntity> list = roleQueryProcess.getByIds(dto.getRoleIds());
            entity.getRoles().clear();
            entity.setRoles(new TreeSet<RoleEntity>(list));
        }
        else {
            entity.getRoles().clear();
        }
        
        dao.update(entity);
    }
    
    public void setRoleProcess(UserDTO dto) {
        UserEntity entity = dao.getSingle(UserEntity.class, dto.getUserId());
        if (dto.getRoleIds() != null && dto.getRoleIds().length > 0) {
            List<RoleEntity> list = roleQueryProcess.getByIds(dto.getRoleIds());
            entity.setRoles(new TreeSet<RoleEntity>(list));
        }
        else {
            entity.getRoles().clear();
        }
        dao.update(entity);
    }
    
}
