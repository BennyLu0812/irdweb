package com.ird.portal.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.transform.ResultTransformer;

/**
 * 通用DAO接口.
 *
 * @author Jim
 * @since 14/12/2016 下午9:40
 */
public interface DAO {
    /**
     * 获取一条数据库记录。
     *
     * @param cmd
     * @param resultType
     * @param <T>
     * @return
     */
    <T> T getSingle(DaoCmd cmd, Class<?> resultType);

    /**
     * 是否需要转换类型 例如一般type=sql 需要将object[] 类型转换为resultType指定的类型。
     *
     * @param cmd
     * @param resultType
     * @param aliasToBean true 将转换为resultType指定的类型.
     * @param <T>
     * @return
     */
    <T> T getSingle(DaoCmd cmd, Class<?> resultType, boolean aliasToBean);

    /**
     * 根据主键获取实体对象.
     *
     * @param entityClass
     * @param primaryKey
     * @param <T>
     * @return
     */
    <T extends Serializable> T getSingle(Class<T> entityClass, Object primaryKey);

    <T> List<T> getList(DaoCmd cmd, Class<?> resultType);
    
    /**
     * 
     * @param cmd
     * @param resultType
     * @param aliasToBean  true: 将转换为resultType指定的类型;false: 不转换，使用默认的类型返回.
     * @return
     */
    <T> List<T> getList(DaoCmd cmd, Class<?> resultType, boolean aliasToBean);

    <T> List<T> getList(DaoCmd cmd, Class<?> resultType, Integer maxResult, Integer startFrom);

    <T> List<T> getList(DaoCmd cmd, Class<?> resultType, Integer maxResult, Integer startFrom,
                        ResultTransformer transformer);

    Object insert(Object obj);

    Object update(Object obj);

    void delete(Object obj);

    int execute(DaoCmd cmd);

    void flush();

}
