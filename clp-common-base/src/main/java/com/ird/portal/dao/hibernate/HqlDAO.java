package com.ird.portal.dao.hibernate;

import com.ird.portal.dao.SqlType;
import org.hibernate.transform.ResultTransformer;

import java.util.List;
import java.util.Map;


/**
 * 直接运用sql 或 hql语句嵌套在程序中，简单方便，对于复杂的语句还是建议放到xml中.
 *
 * @author dowler
 * @since 19/04/2017 9:16 PM
 */
public interface HqlDAO {

    <T> T getSingle(String hqlOrSql, SqlType type, Map<String, Object> params);

    <T> T getSingle(String hqlOrSql, SqlType type, Map<String, Object> params, Class<?> resultType, boolean aliasToBean);


    <T> T getSingle(String hqlOrSql, SqlType type, Map<String, Object> params, Class<?> resultType, ResultTransformer transformer);

    /**
     * @param hqlOrSql hql 语句或sql语句
     * @param type
     * @param params
     * @return
     */
    int executeUpdate(String hqlOrSql, SqlType type, Map<String, Object> params);

    <T> List<T> getList(String hqlOrSql, SqlType type, Map<String, Object> params);
    
    <T> List<T> getList(String hqlOrSql, SqlType type, Map<String, Object> params, ResultTransformer transformer);

    <T> List<T> getList(String hqlOrSql, SqlType type, Map<String, Object> params, Class<?> resultType, boolean aliasToBean);

    <T> List<T> getList(String hqlOrSql, SqlType type, Map<String, Object> params, Integer maxResult, Integer startFrom, Class<?> resultType, boolean aliasToBean);

    <T> List<T> getList(String hqlOrSql, SqlType type, Map<String, Object> params, Integer maxResult, Integer startFrom,
                        ResultTransformer transformer);
    
    long getCount(String hqlOrSql, SqlType type, Map<String, Object> params);
}
