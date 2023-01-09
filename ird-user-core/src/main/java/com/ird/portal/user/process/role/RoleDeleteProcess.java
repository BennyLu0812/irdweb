package com.ird.portal.user.process.role;

import com.ird.portal.exception.RecordNotFoundException;
import com.ird.portal.user.dao.UserDao;
import com.ird.portal.user.entity.RoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * 角色管理-刪除.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 30/11/2017 11:37:12<br/>
 * 
 * @author Deft
 * @version 1.0
 */
@Component
public class RoleDeleteProcess {
    
    @Autowired
    private UserDao dao;
    
    public void delete(Long id) {
        RoleEntity roleEntity = dao.getSingle(RoleEntity.class, id);
        if (roleEntity == null) {
            throw new RecordNotFoundException("roleId=" + id);
        }
        dao.delete(roleEntity);
    }
    
}
