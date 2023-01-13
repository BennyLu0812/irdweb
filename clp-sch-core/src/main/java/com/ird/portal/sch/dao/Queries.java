/**
 * @Project Name: dsat-sch-core
 * @File Name: Queries.java
 * @Date: 19/04/201610:45:44 AM
 * @Copyright: Copyright (c) 2016 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.sch.dao;

/**
 * Title: <br/>
 * Description: <br/>
 * Date: 19/04/2016 10:45:44 AM<br/>
 *
 * @author Jim
 * @version 1.0
 * @since JDK1.8
 */
public interface Queries {
    
    String HQL_FIND_SCHCTRL_LIST = "findSchCtrlList";
    
    String HQL_FIND_SCHCTRLLOG_BY_SCHCTRLID = "findSchCtrlLogBySchCtrlId";
    
    String HQL_FIND_SCHCTRL_PAGE = "findSchCtrlPage";
    
    String SQL_FIND_SCHCTRLLOG_PAGE = "findSchCtrlLogPage";
    
    String SQL_FIND_SCHCTRLLOG_BY_SCHCTRLID_PAGE = "findSchCtrlLogPageBySchCtrlId";
}
