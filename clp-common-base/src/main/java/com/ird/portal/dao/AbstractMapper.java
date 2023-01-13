package com.ird.portal.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractMapper<T> {
    
    @SuppressWarnings("rawtypes")
    private Class clazz;

    @SuppressWarnings("unchecked")
    public AbstractMapper() {
        ParameterizedType type = ((ParameterizedType)this.getClass().getGenericSuperclass());
        clazz = (Class<T>)type.getActualTypeArguments()[0];
    }

    public Object insert(T obj) {
        getDao().insert(obj);
        return obj;
    }
    
    public Object insertExcludeCustomerInfo(T obj) {
        getDao().insertExcludeCustomerInfo(obj);
        return obj;
    }
    
    public Object update(T obj) {
        return getDao().update(obj);
    }
    
    public void delete(T obj) {
        getDao().delete(obj);
    }
    
    public void deleteById(Object primaryKey) {
        getDao().delete(getSingle(primaryKey));
    }

    public void flush() {
        getDao().flush();
    }

    @SuppressWarnings("unchecked")
    public T getSingle(Object primaryKey) {
        return (T)getDao().getSingle(clazz, primaryKey);
    }
    
    public List<T> getList(DaoCmd cmd) {
        return getDao().getList(cmd, clazz);
    }
    
    protected abstract AbstractCommonDao getDao();
    
}
