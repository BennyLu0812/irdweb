package com.ird.portal.dao;

import com.ird.portal.data.BaseDTO;
import com.ird.portal.datatable.DataTablePage;
import com.ird.portal.datatable.DatatableDaoCmd;
import com.ird.portal.model.Page;

public abstract class AbstractPageMapper<T> extends AbstractMapper<T> {
    
    /**
     * 基礎Datatable插件分頁實現
     * 
     * @param querySql
     * @param typeDTO
     * @return
     */
    protected Page baseDataTablePage(final String querySql, BaseDTO typeDTO) {
        DatatableDaoCmd cmd = new DatatableDaoCmd(querySql, typeDTO);
        DataTablePage page = (DataTablePage)this.getDao().getPage(cmd, typeDTO.getClass(), true);
        return page;
    }
}
