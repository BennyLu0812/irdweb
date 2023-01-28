/**
 * @Project Name: dsat-exl-core
 * @File Name: Queries.java
 * @Package Name: mo.gov.dsat.dls.exl.dao
 * @Date: 15/12/2017 11:34:26
 * @Copyright: Copyright (c) 2016 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.core.dao;

/**
 * 
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

    String SQL_GET_GROUP_LIST = "getGroupList";
    String SQL_GET_GROUP_BY_ID = "getGroupById";
    String SQL_GET_QUEUE_BY_ID = "getQueueById";
    String SQL_GET_QUEUE_LIST = "getQueueList";
}
