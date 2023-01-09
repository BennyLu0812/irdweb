package com.ird.portal.dao.hibernate;

import com.ird.portal.dao.SqlType;
import com.ird.portal.exception.DatabaseException;
import org.apache.commons.collections.MapUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.ResultTransformer;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;


/**
 * 可以直接运用hql 或 sql 的DAO.
 *
 * @author Jim
 * @since 20/04/2017 10:06 AM
 */
public abstract class HqlDaoImpl extends PageDaoImpl implements HqlDAO {

    @Override
    public <T> T getSingle(String hqlOrSql, SqlType type, Map<String, Object> params) {
        return getSingle(hqlOrSql, type, params, null, false);
    }

    @Override
    public <T> T getSingle(String hqlOrSql, SqlType type, Map<String, Object> params, Class<?> resultType, boolean aliasToBean) {
        return getSingle(hqlOrSql, type, params, resultType, aliasToBean ? getTransformerAdapter(resultType) : null);
    }

    @SuppressWarnings({ "unchecked" })
    @Override
    public <T> T getSingle(String hqlOrSql, SqlType type, Map<String, Object> params, Class<?> resultType, ResultTransformer transformer) {
        Query query = createQuery(hqlOrSql, type, params);
        if (transformer != null) {
            query.setResultTransformer(transformer);
        }

        return (T) query.uniqueResult();
    }

    @Override
    public int executeUpdate(String hqlOrSql, SqlType type, Map<String, Object> params) {
        Query query = createQuery(hqlOrSql, type, params);
        if (MapUtils.isNotEmpty(params)) {
            query.setProperties(params);
        }
        return query.executeUpdate();
    }

    @Override
    public <T> List<T> getList(String hqlOrSql, SqlType type, Map<String, Object> params) {
        return getList(hqlOrSql, type, params, null, null, null);
    }

    @Override
    public <T> List<T> getList(String hqlOrSql, SqlType type, Map<String, Object> params, ResultTransformer transformer) {
        return getList(hqlOrSql, type, params, null, null, transformer);
    }

    @Override
    public <T> List<T> getList(String hqlOrSql, SqlType type, Map<String, Object> params, Class<?> resultType, boolean aliasToBean) {
        return getList(hqlOrSql, type, params, null, null, aliasToBean ? getTransformerAdapter(resultType) : null);
    }

    @Override
    public <T> List<T> getList(String hqlOrSql, SqlType type, Map<String, Object> params, Integer maxResult, Integer startFrom, Class<?> resultType, boolean aliasToBean) {
        return getList(hqlOrSql, type, params, maxResult, startFrom, aliasToBean ? getTransformerAdapter(resultType) : null);
    }

    @SuppressWarnings({ "unchecked" })
    @Override
    public <T> List<T> getList(String hqlOrSql, SqlType type, Map<String, Object> params, Integer maxResult, Integer startFrom, ResultTransformer transformer) {
        Query query = createQuery(hqlOrSql, type, params);
        if (maxResult != null) {
            query.setMaxResults(maxResult);
        }
        if (startFrom != null) {
            query.setFirstResult(startFrom);
        }
        if (transformer != null) {
            query.setResultTransformer(transformer);
        }
        return query.list();
    }

    protected <T> Query createQuery(String hqlOrSql, SqlType type, Map<String, Object> params) {
        Session session = getSession();
        Query query;
        if (SqlType.HQL.equals(type)) {
            query = session.createQuery(hqlOrSql);
        } else if (SqlType.SQL.equals(type)) {
            query = session.createSQLQuery(hqlOrSql);
        } else {
            throw new DatabaseException("Unknown query type: " + type);
        }

        if (MapUtils.isNotEmpty(params)) {
            query.setProperties(params);
        }
        return query;
    }

    protected <T> Query createQuery(String hqlOrSql, SqlType type, Object... params) {
        Session session = getSession();
        Query query;
        if (SqlType.HQL.equals(type)) {
            query = session.createQuery(hqlOrSql);
        } else if (SqlType.SQL.equals(type)) {
            query = session.createSQLQuery(hqlOrSql);
        } else {
            throw new DatabaseException("Unknown query type: " + type);
        }

        if (params.length > 0) {
            for (int position = 0; position < params.length; position++) {
                query.setParameter(position, params[position]);
            }
        }

        return query;
    }

    @Override
    public long getCount(String hqlOrSql, SqlType type, Map<String, Object> params) {
        String queryString = createCountQuery(hqlOrSql, type);

        Query query = createQuery(queryString, type, params);
        return new BigInteger(query.uniqueResult().toString()).longValue();
    }

    private String createCountQuery(String hqlOrSql, SqlType type) {

        String queryString;

        if (SqlType.HQL.equals(type)) {
            queryString = processCountHql(hqlOrSql);
        } else if (SqlType.SQL.equals(type)) {
            queryString = processCountSQL(hqlOrSql);
        } else {
            throw new DatabaseException("Unknown query type: " + type);
        }
        return queryString;
    }

}
