/**
 * @Project Name: dsat-rpt-core
 * @File Name: RptDaoCmd.java
 * @Date: 15/12/2017 12:26:02
 * @Copyright: Copyright (c) 2016 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.rpt.dao;

import com.ird.portal.dao.DaoCmd;

import java.util.Map;

/**
 * 
 * RPT DAO CMD.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 15/12/2017 12:26:02<br/>
 * @author Jim
 * @version 1.0
 */
public class RptDaoCmd extends DaoCmd {

    public RptDaoCmd(String queryKey) {
        super(queryKey);
    }

    public RptDaoCmd(String queryKey, Map<String, Object> params) {
        super(queryKey, params);
    }
}