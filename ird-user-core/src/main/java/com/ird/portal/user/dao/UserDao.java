/**
 * @Project Name: dls-user-core
 * @File Name: UserDao.java
 * @Date: 15/12/2017 12:33:09
 * @Copyright: Copyright (c) 2017 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.user.dao;

import com.ird.portal.dao.AbstractCommonDao;

import javax.persistence.EntityManager;

/**
 * USER DAO.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 30/11/2017 10:07:41<br/>
 * 
 * @author Deft
 * @version 1.0
 */
public class UserDao extends AbstractCommonDao {
    
    /**
     * 防止new UserDao()的實例出現.
     */
    UserDao() { }
    
    private EntityManager entityManager;
    
    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
    
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
}
