package com.ird.portal.dao.hibernate;

import com.ird.portal.dao.PageDaoCmd;
import com.ird.portal.datatable.DatatableDaoCmd;
import com.ird.portal.model.Page;
import org.hibernate.transform.ResultTransformer;

import java.io.Serializable;


/**
 * 分页的DAO.
 * @author dowler
 * @since 20/03/2017 2:23 PM
 */
public interface PageDAO {

    <T> Page getPage(PageDaoCmd cmd, Class<?> resultType);

    <T> Page getPage(PageDaoCmd cmd, Class<?> resultType, boolean aliasToBean);

    <T> Page getPage(PageDaoCmd cmd, Class<?> resultType, ResultTransformer transformer);

    long getCount(PageDaoCmd cmd);
    
    /**
     * 不使用hibernate 的分頁，使用 SQL自己進行分頁設置.
     * 
     * @param cmd
     * @param clazz
     * @param maxResult
     *            分頁大小
     * @param startFrom
     *            起始位置
     * @return
     */
    public <T extends Serializable> Page getPageByNativeSQL(DatatableDaoCmd cmd, Class<?> clazz, boolean aliasToBean);

    public <T extends Serializable> Page getPageByNativeSQL(DatatableDaoCmd cmd, Class<?> clazz, ResultTransformer transformer);
}
