package com.ird.portal.user.process.module;

import com.ird.portal.exception.RecordNotFoundException;
import com.ird.portal.user.dao.UserDao;
import com.ird.portal.user.entity.ModuleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



/**
 * 
 * 模塊管理-刪除.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 01/12/2017 15:45:52<br/>
 * 
 * @author Deft
 * @version 1.0
 */
@Component
public class ModulesDeleteProcess {
    
    @Autowired
    private UserDao dao;
    
    public void delete(Long id) {
        
        ModuleEntity entity = dao.getSingle(ModuleEntity.class, id);
        if (entity == null) {
            throw new RecordNotFoundException("moduleId=" + id);
        }
        dao.delete(entity);
    }
}
