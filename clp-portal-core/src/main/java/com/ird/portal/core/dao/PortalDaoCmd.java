package com.ird.portal.core.dao;

import com.ird.portal.dao.DaoCmd;

import java.util.Map;

/**
 * @author Benny
 * @description:
 * @date 2023/1/16
 */
public class PortalDaoCmd extends DaoCmd {

    public PortalDaoCmd(String queryKey) {
        super(queryKey);
    }

    public PortalDaoCmd(String queryKey, Map<String, Object> params) {
        super(queryKey, params);
    }
}
