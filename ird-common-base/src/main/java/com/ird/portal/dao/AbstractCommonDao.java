/**
 * @Project Name: dls-common-base
 * @File Name: AbstractCommonBaseDao.java
 * @Date: 2017年10月27日 下午12:49:15
 * @Copyright: Copyright (c) 2017 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.dao;

import com.ird.portal.dao.hibernate.HqlDaoImpl;
import com.ird.portal.entity.AbstractEntity;
import com.ird.portal.user.AnonymousUser;
import com.ird.portal.user.User;
import com.ird.portal.user.UserContext;

import java.util.Date;

/**
 * Title: <br/>
 * Description: <br/>
 * Date: 2017年10月27日 下午12:49:15<br/>
 *
 * @author Jim
 * @version 1.0
 * @since JDK1.8
 */
public abstract class AbstractCommonDao extends HqlDaoImpl {
    
    @Override
    protected Object setCustomerInfo(Object obj) {
        if (obj instanceof AbstractEntity) {
            AbstractEntity entity = (AbstractEntity) obj;
            Date sysDate = new Date();
            User user = UserContext.getUser();
            if (user == null) {
                user = new AnonymousUser();
            }
            if (!getEntityManager().contains(entity)) {
                entity.setCreateDate(sysDate);
                entity.setCreateUser(user.getUserId());
            }
            entity.setLastUpdDate(sysDate);
            entity.setLastUpdUser(user.getUserId());
            return entity;
        }
        return obj;
    }

}
