/**
 * @Project Name: dsat-sch-core
 * @File Name: SchBaseDao.java
 * @Date: 06/04/20166:06:09 PM
 * @Copyright: Copyright (c) 2016 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.sch.dao;

import com.ird.portal.dao.AbstractCommonDao;

import javax.persistence.EntityManager;

/**
 * Title: <br/>
 * Description: <br/>
 * Date: 06/04/2016 6:06:09 PM<br/>
 *
 * @author Jim
 * @version 1.0
 * @since JDK1.8
 */
public class SchDao extends AbstractCommonDao {

	private EntityManager entityManager;

	SchDao() {}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
