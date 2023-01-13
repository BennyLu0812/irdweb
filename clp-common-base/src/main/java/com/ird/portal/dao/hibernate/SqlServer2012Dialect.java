/**
 * @Project Name: dashboard-common-base
 * @File Name: SqlServer2008Dialect.java
 * @Date: 2018年12月17日
 * @Copyright: Copyright (c) 2018 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.dao.hibernate;

import org.hibernate.dialect.SQLServer2012Dialect;
import org.hibernate.type.StandardBasicTypes;

import java.sql.Types;

/**
 * 
 * <br/>
 * <br/>
 * <b>Date:</b>2018年12月17日<br/>
 * @author linwood
 * @version 1.0
 */
public class SqlServer2012Dialect extends SQLServer2012Dialect {

	public SqlServer2012Dialect() {

        super();  
        
        registerHibernateType(Types.NVARCHAR, StandardBasicTypes.STRING.getName());
        registerHibernateType(Types.INTEGER, StandardBasicTypes.BIG_DECIMAL.getName());
        registerHibernateType(Types.NCHAR, StandardBasicTypes.STRING.getName());
    }

}
