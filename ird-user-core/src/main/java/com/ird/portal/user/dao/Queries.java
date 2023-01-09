/**
 * @Project Name: dsat-sch-core
 * @File Name: Queries.java
 * @Date: 19/04/201610:45:44 AM
 * @Copyright: Copyright (c) 2016 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.user.dao;

/**
 * Title: Query的常量存放處.<br/>
 * Description: 命名規則: 若果是hql語句的:HQL+下劃線+功能名稱==>HQL_GET_SYS_PARAMS;如果是sql語句: SQL+下劃線+功能名稱==>SQL_GET_SYS_PARAMS<br/>
 * Date: 19/04/2016 10:45:44 AM<br/>
 *
 * @author Jim
 * @version 1.0
 * @since JDK1.8
 */
public interface Queries {
    
    public static final String HQL_GET_ROLE_BY_IDS = "getRoleByIds";
    
    public static final String HQL_GET_ROLE_LIST = "getRoleList";
    
    public static final String HQL_GET_MODULE_LIST = "getModuleList";
    
    public static final String HQL_GET_MODULE_TOP = "getTopModule";
    
    public static final String HQL_GET_MODULE_CHILDREN = "getModuleChildren";
    
    public static final String HQL_BUILT_MODULE_PARENT = "buildModuleParent";
    
    public static final String HQL_GET_USER_LIST = "getUserList";
    
    public static final String HQL_GET_FUNC_LIST = "getFuncList";
    
    public static final String HQL_GET_FUNC_BY_IDS = "getFuncByIds";
    
    public static final String HQL_GET_FUNC_TOP = "getTopFunc";
    
    public static final String HQL_BUILD_FUNC_PARENT = "buildFuncParent";
    
    public static final String HQL_GET_FUNC_BY_FUNC_CODE = "getFuncByFuncCode";

    public static final String HAS_ROLE = "hasRole";
    
    public static final String HAS_ANY_ROLE = "hasAnyRole";
    
    public static final String HAS_PERMISSION = "hasPermission";
    
}
