/**
 * @Project Name: dsat-sch-core
 * @File Name: SchBaseDaoCmd.java
 * @Date: 19/04/201610:44:42 AM
 * @Copyright: Copyright (c) 2016 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.sch.dao;

import com.ird.portal.dao.DaoCmd;

import java.util.Map;


/**
 * Title: <br/>
 * Description: <br/>
 * Date: 19/04/2016 10:44:42 AM<br/>
 *
 * @author Jim
 * @version 1.0
 * @since JDK1.8
 */
public class SchDaoCmd extends DaoCmd {

    public SchDaoCmd(String queryKey) {
        super(queryKey);
    }

    public SchDaoCmd(String queryKey, Map<String, Object> params) {
        super(queryKey, params);
    }
}