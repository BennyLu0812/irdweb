package com.ird.portal.dao;

import com.ird.portal.model.Page;

import java.util.Map;

/**
 * Title: 用於分頁查詢.<br/>
 * Description: <br/>
 * Date: 2017年10月31日 上午11:51:51<br/>
 *
 * @author Jim
 * @version 1.0
 * @since JDK1.8
 */
public abstract class PageDaoCmd extends DaoCmd {

    private Page page;

//    public PageDaoCmd(String queryKey) {
//        super(queryKey);
//    }

//    public PageDaoCmd(String queryKey, Map<String, Object> params) {
//        super(queryKey, params);
//    }

    public PageDaoCmd(String queryKey, Map<String, Object> params, Page page) {
        super(queryKey, params);
        setPage(page);
    }

    public Page getPage() {
        return page;
    }

    protected void setPage(Page page) {
        this.page = page;
    }
}
