/**
 * @Project Name: dsat-rpt-core
 * @File Name: Queries.java
 * @Date: 15/12/2017 11:34:26
 * @Copyright: Copyright (c) 2016 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.rpt.dao;

/**
 * <p>
 * query.xml的HQL, SQL 的queryKey定義類
 * </p>
 * <p>
 * 變量命名規則: SQL類型 + _ + query name(每個單詞使用下劃綫分開)
 * </p>
 * <p>
 * SQL語句: SQL_GET_BY_USER_ID = "getByUserId"
 * </p>
 * <p>
 * HQL: HQL_GET_BY_USER_ID = "getByUserId" 
 * </p>
 *
 * <b>Date:</b> 15/12/2017 11:34:26<br/>
 * 
 * @author Jim
 * @version 1.0
 */
public interface Queries {
    
    String HQL_GET_TEMPLATE = "getTemplate";
    
    String HQL_GET_RPT_MASTER = "getRptMaster";
}
