package com.ird.portal.core.dao;

import com.ird.portal.dao.AbstractCommonDao;

import javax.persistence.EntityManager;

/**
 * @author Benny
 * @description:
 * @date 2023/1/16
 */
public class PortalDao extends AbstractCommonDao {

    private EntityManager entityManager;

    PortalDao(){ }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
