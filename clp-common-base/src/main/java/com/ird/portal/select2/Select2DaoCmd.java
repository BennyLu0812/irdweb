package com.ird.portal.select2;

import com.ird.portal.dao.PageDaoCmd;
import com.ird.portal.model.Page;

import java.util.Map;

public class Select2DaoCmd extends PageDaoCmd {
    
    public Select2DaoCmd(String queryKey, Map<String, Object> params, int pageSize, int pageNumber) {
        super(queryKey, params, new Select2Page(pageSize, pageNumber));
    }
    
    public Select2DaoCmd(String queryKey, Map<String, Object> params, Page page) {
        super(queryKey, params, page);
    }
    
}
