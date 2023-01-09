/**
 * @Project Name: dsat-rpt-core
 * @File Name: RptDao.java
 * @Date: 15/12/2017 12:25:48
 * @Copyright: Copyright (c) 2016 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.rpt.dao;

import com.ird.portal.dao.AbstractCommonDao;

import javax.persistence.EntityManager;

/**
 * 
 * RPT DAO.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 15/12/2017 12:25:48<br/>
 * @author Jim
 * @version 1.0
 */
public class RptDao extends AbstractCommonDao {

    private EntityManager entityManager;
    
    RptDao(){ }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
