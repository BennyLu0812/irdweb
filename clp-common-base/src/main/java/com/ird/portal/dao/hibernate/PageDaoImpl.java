package com.ird.portal.dao.hibernate;

import com.ird.portal.dao.DaoCmd;
import com.ird.portal.dao.PageDaoCmd;
import com.ird.portal.datatable.DatatableDaoCmd;
import com.ird.portal.exception.DatabaseException;
import com.ird.portal.model.Page;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.ResultTransformer;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 * 分页的DAO.
 * @author dowler
 * @since 20/03/2017 2:39 PM
 */
public abstract class PageDaoImpl extends HibernateDAO implements PageDAO {

    @Override
    public <T> Page getPage(PageDaoCmd cmd, Class<?> resultType) {
        return getPage(cmd, resultType, null);
    }

    @Override
    public <T> Page getPage(PageDaoCmd cmd, Class<?> resultType, boolean aliasToBean) {
        return getPage(cmd, resultType, aliasToBean ? getTransformerAdapter(resultType) : null);
    }

    @Override
    public <T> Page getPage(PageDaoCmd cmd, Class<?> resultType, ResultTransformer transformer) {
        List<T> data = getList(cmd, resultType, cmd.getPage().getPageSize(), cmd.getPage().getStartForm(), transformer);
        long total = getCount(cmd);
        cmd.getPage().setData(data);
        cmd.getPage().setTotal(total);
        return cmd.getPage();
    }

    @Override
    public long getCount(PageDaoCmd cmd) {
        Query query = createCountQuery(cmd);
        return new BigInteger(query.uniqueResult().toString()).longValue();
    }

    private Query createCountQuery(DaoCmd cmd) {
        Session session = getSession();

        String queryType = getQueryType(cmd);
        if (queryType == null) {
            queryType = HQL;
        }

        Query query;
        if (HQL.equals(queryType)) {

            String queryString = processTemplate(cmd);
            queryString = processCountHql(queryString);
            query = session.createQuery(queryString);

        } else if (SQL.equals(queryType)) {
            String queryString = processTemplate(cmd);
            String countString = processCountSQL(queryString);
            query = session.createSQLQuery(countString);
        } else {
            throw new DatabaseException("Unknown query type: " + queryType);
        }
        Map<String, Object> params = cmd.getParams();
        if (MapUtils.isNotEmpty(params)) {
            query.setProperties(params);
        }
        return query;
    }

    protected String processCountHql(String orgHql) {
        String fromHql = orgHql;
        fromHql = StringUtils.substring(fromHql, StringUtils.indexOf(fromHql.toLowerCase(), "from"));
        int indexof = StringUtils.lastIndexOf(fromHql.toLowerCase(), "order by");
        if (indexof > -1) {
            fromHql = StringUtils.substring(fromHql, 0, indexof);
        }
        return "SELECT COUNT(*) " + fromHql;
    }

    protected String processCountSQL(String orgSql) {
        String fromSql = orgSql;
//        int indexof = StringUtils.lastIndexOf(fromSql.toLowerCase(), "order by");
//        if (indexof > -1) {
//            fromSql = StringUtils.substring(fromSql, 0, indexof);
//        }
        String countSql = "SELECT COUNT(*) FROM (" + fromSql + ") T$COUNT";
        return countSql;
    }
    
    /******************************************************************/
    // add getPageByNativeSQL TODO(Jim 20160831)
    /******************************************************************/
    /**
     * oracle pagination params,rownum
     */
    private static final String PARAMS_ROWNUM_START = "_rownumStart";
    private static final String PARAMS_ROWNUM_END = "_rownumEnd";
    
    @Override
    public <T extends Serializable> Page getPageByNativeSQL(DatatableDaoCmd cmd, Class<?> clazz, boolean aliasToBean) {
        int startForm = cmd.getDatatableDTO().getStart();
        int maxResult = cmd.getDatatableDTO().getLength();
        Map<String, Object> params = (Map<String, Object>) cmd.getParams();
        params.put(PARAMS_ROWNUM_START, startForm);
        params.put(PARAMS_ROWNUM_END, startForm + maxResult);
        cmd.setParams(params);
        List<T> entities = getList(cmd, clazz, null, null, aliasToBean);

        params.put(PARAMS_ROWNUM_START, null);
        params.put(PARAMS_ROWNUM_END, null);
        cmd.setParams(params);
//        long count = getCount(cmd);
        cmd.getPage().setData(entities);
//        cmd.getPage().setTotal(count);
        return cmd.getPage();
    }

    @Override
    public <T extends Serializable> Page getPageByNativeSQL(DatatableDaoCmd cmd, Class<?> clazz, ResultTransformer transformer) {
        int startForm = cmd.getDatatableDTO().getStart();
        int maxResult = cmd.getDatatableDTO().getLength();
        Map<String, Object> params = (Map<String, Object>) cmd.getParams();
        params.put(PARAMS_ROWNUM_START, startForm);
        params.put(PARAMS_ROWNUM_END, startForm + maxResult);
        cmd.setParams(params);
        List<T> entities = getList(cmd, clazz, null, null, transformer);

        params.put(PARAMS_ROWNUM_START, null);
        params.put(PARAMS_ROWNUM_END, null);
        cmd.setParams(params);
        cmd.setParams(params);
        long count = getCount(cmd);
        cmd.getPage().setData(entities);
        cmd.getPage().setTotal(count);
        return cmd.getPage();
    }
}
