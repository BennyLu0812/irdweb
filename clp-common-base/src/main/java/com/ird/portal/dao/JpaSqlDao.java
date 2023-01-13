/**
 * @Project Name: dsat-exl-core
 * @File Name: ExlDao.java
 * @Date: 15/12/2017 12:16:01
 * @Copyright: Copyright (c) 2016 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.dao;

import javax.persistence.EntityManager;

/**
 * 
 * EXL DAO.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 15/12/2017 12:16:01<br/>
 * @author Jim
 * @version 1.0
 */
public class JpaSqlDao extends AbstractCommonDao {

    private EntityManager entityManager;

    public JpaSqlDao(){ }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
