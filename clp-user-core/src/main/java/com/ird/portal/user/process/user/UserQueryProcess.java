package com.ird.portal.user.process.user;

import com.ird.portal.common.user.data.UserDTO;
import com.ird.portal.datatable.DataTablePage;
import com.ird.portal.datatable.DatatableDaoCmd;
import com.ird.portal.model.Page;
import com.ird.portal.user.dao.UserDao;
import com.ird.portal.user.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * 用戶管理-查詢.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 30/11/2017 12:03:18<br/>
 * 
 * @author Deft
 * @version 1.0
 */
@Component
public class UserQueryProcess {
    
    @Autowired
    private UserDao dao;
    
    public Page getPage(UserDTO dto) {
        DatatableDaoCmd cmd = new DatatableDaoCmd("getUserList", dto);
        DataTablePage page = (DataTablePage)dao.getPage(cmd, UserEntity.class);
        return page;
    }
    
    public UserEntity getById(String id) {
        UserEntity entity = dao.getSingle(UserEntity.class, id);
        if (entity == null) {
            return null;
        }
        return entity;
    }
}
