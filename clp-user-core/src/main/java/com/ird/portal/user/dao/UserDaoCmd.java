/**
 * @Project Name: dsat-user-core
 * @File Name: UserDaoCmd.java
 * @Date: 15/12/2017 12:34:14
 * @Copyright: Copyright (c) 2016 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.user.dao;

import com.ird.portal.dao.DaoCmd;
import com.ird.portal.data.BaseDTO;

import java.util.Map;

/**
 * USER DAO CMD.
 * 
 * <br/>
 * <br/>
 * <b>Date:</b> 15/12/2017 12:34:14<br/>
 * @author Jim
 * @version 1.0
 */
public class UserDaoCmd extends DaoCmd {

    public UserDaoCmd(String queryKey) {
        super(queryKey);
    }

    public UserDaoCmd(String queryKey, Map<String, Object> params) {
        super(queryKey, params);
    }

    public UserDaoCmd(String queryKey, BaseDTO dto) {
        super(queryKey, dto);
    }
    
}