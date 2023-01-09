/**
 * @Project Name: dsat-sys-core
 * @File Name: SysDao.java
 * @Date: 15/12/2017 12:30:29
 * @Copyright: Copyright (c) 2016 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.sys.dao;

import com.ird.portal.dao.AbstractCommonDao;

import javax.persistence.EntityManager;

/**
 * 
 * SYS DAO.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 15/12/2017 12:30:29<br/>
 * @author Jim
 * @version 1.0
 */
public class SysDao extends AbstractCommonDao {

    /**
     * 防止new SysDao()的實例出現.
     */
    SysDao(){ }
    
    private EntityManager entityManager;

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    protected void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
