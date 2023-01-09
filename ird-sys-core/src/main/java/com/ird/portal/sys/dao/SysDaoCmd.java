/**
 * @Project Name: dsat-sys-core
 * @File Name: SysDaoCmd.java
 * @Date: 15/12/2017 12:30:59
 * @Copyright: Copyright (c) 2016 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.sys.dao;

import com.ird.portal.dao.DaoCmd;
import com.ird.portal.data.BaseDTO;

import java.util.Map;

/**
 * 
 * SYS DAO CMD.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 15/12/2017 12:30:59<br/>
 * @author Jim
 * @version 1.0
 */
public class SysDaoCmd extends DaoCmd {

    public SysDaoCmd(String queryKey) {
        super(queryKey);
    }

    public SysDaoCmd(String queryKey, Map<String, Object> params) {
        super(queryKey, params);
    }

    public SysDaoCmd(String queryKey, BaseDTO dto) {
        super(queryKey, dto);
    }
    
    
}