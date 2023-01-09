package com.ird.portal.user.process.user;

import com.ird.portal.exception.RecordNotFoundException;
import com.ird.portal.user.dao.UserDao;
import com.ird.portal.user.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



/**
 * 
 * 用戶管理-刪除.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 12/12/2017 15:47:45<br/>
 * 
 * @author Deft
 * @version 1.0
 */
@Component
public class UserDeleteProcess {
    
    @Autowired
    private UserDao dao;
    
    public void delete(String userId) {
        UserEntity entity = dao.getSingle(UserEntity.class, userId);
        if (entity == null) {
            throw new RecordNotFoundException("userId=" + userId);
        }
        else {
            dao.delete(entity);
        }
    }
    
}
