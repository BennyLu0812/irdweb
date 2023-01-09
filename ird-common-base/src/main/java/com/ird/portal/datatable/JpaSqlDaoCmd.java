package com.ird.portal.datatable;


import com.ird.portal.dao.DaoCmd;
import com.ird.portal.data.BaseDTO;

import java.util.Map;

public class JpaSqlDaoCmd extends DaoCmd {

    public JpaSqlDaoCmd(String queryKey) {
        super(queryKey);
    }

    public JpaSqlDaoCmd(String queryKey, Map<String, Object> params) {
        super(queryKey, params);
    }

    public JpaSqlDaoCmd(String queryKey, BaseDTO dto) {
        super(queryKey, dto);
    }
}
