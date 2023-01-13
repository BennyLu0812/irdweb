package com.ird.portal.user.process.func;

import com.ird.portal.exception.RecordNotFoundException;
import com.ird.portal.user.dao.UserDao;
import com.ird.portal.user.entity.FuncEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 * 
 * 功能管理-刪除.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 12/12/2017 16:11:47<br/>
 * @author Deft
 * @version 1.0
 */
@Component("deleteFuncProcess")
public class FuncDeleteProcess {
    
    @Autowired
    private UserDao dao;
    
    public void delete(Long id) {
        FuncEntity entity = dao.getSingle(FuncEntity.class, id);
        if (entity == null) {
            throw new RecordNotFoundException("roleId=" + id);
        }
        else {
            dao.delete(entity);
        }
    }
    
}
