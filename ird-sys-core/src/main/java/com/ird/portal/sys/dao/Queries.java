/**
 * @Project Name: dsat-sys-core
 * @File Name: Queries.java
 * @Date: 15/12/2017 12:29:34
 * @Copyright: Copyright (c) 2016 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.sys.dao;

/**
 * Title: Query的常量存放處.<br/>
 * Description: 命名規則: 若果是hql語句的:HQL+下劃線+功能名稱==>HQL_GET_SYS_PARAMS;如果是sql語句: SQL+下劃線+功能名稱==>SQL_GET_SYS_PARAMS<br/>
 * Date: 19/04/2016 10:45:44 AM<br/>
 *
 * @author Jim
 * @version 1.0
 * @since JDK1.8
 */

/**
 * 
 * <p>Query的常量定義</p>
 * <p>命名規則: 若果是hql語句的:HQL+下劃線+功能名稱==>HQL_GET_SYS_PARAMS;如果是sql語句: SQL+下劃線+功能名稱==>SQL_GET_SYS_PARAMS</p>
 * <br/>
 * <br/>
 * <b>Date:</b> 15/12/2017 12:29:34<br/>
 * @author Jim
 * @version 1.0
 */
public interface Queries {
    
    public static final String HQL_GET_SYS_PARAMS = "getSysParam";
    
    public static final String HQL_GET_CODE = "getCode";
    
    public static final String HQL_GET_CODE_MASTER = "getCodeMaster";
    
    public static final String HQL_GET_COMP = "getComp";

    public static final String GET_CODE_BY_CODE_TYPES = "getCodeByCodeTypes";

    public static final String HQL_GET_PARAM_BY_NAME = "getParamByName";
    
    public static final String HQL_GET_CODE_BY_TYPE_AND_KEY = "getCodeByTypeAndKey";
    
    /* ========================== select2 =======================  */
    public static final String HQL_SELECT_SYS_CODE = "selectSysCode";
    
    public static final String SQL_SELECT_SYS_CODE = "selectSysCodeList";
    
    
}
