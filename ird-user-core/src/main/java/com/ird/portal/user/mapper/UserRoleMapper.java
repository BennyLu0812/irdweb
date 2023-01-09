package com.ird.portal.user.mapper;

import com.ird.portal.dao.AbstractCommonDao;
import com.ird.portal.dao.AbstractMapper;
import com.ird.portal.user.dao.UserDao;
import com.ird.portal.user.entity.UserRoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRoleMapper extends AbstractMapper<UserRoleEntity> {
    
    @Autowired
    private UserDao userDao;
    
    @Override
    protected AbstractCommonDao getDao() {
        return userDao;
    }

}
