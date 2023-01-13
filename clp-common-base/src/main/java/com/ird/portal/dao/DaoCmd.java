package com.ird.portal.dao;

import com.ird.portal.data.BaseDTO;
import com.ird.portal.util.BeanUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dowler
 * @since 16/12/2016 下午3:30
 */
public abstract class DaoCmd {
    /**
     * 查询的Key.
     */
    private String queryKey;

    /**
     * 查询的参数
     */
    private Map<String, Object> params;

    /**
     * 排序的字段. 如  name,age,create_time
     */
    private String orderString;

    public DaoCmd(String queryKey) {
        this(queryKey, new HashMap<String, Object>());
    }

    public DaoCmd(String queryKey, Map<String, Object> params) {
        this.queryKey = queryKey;
        this.params = params;
    }
    
    public DaoCmd(String queryKey, BaseDTO dto) {
        this.queryKey = queryKey;
        this.params = BeanUtil.transBeanToMap(dto, true);
    }

    public String getQueryKey() {
        return queryKey;
    }

    public void setQueryKey(String queryKey) {
        this.queryKey = queryKey;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public String getOrderString() {
        return orderString;
    }

    public void setOrderString(String orderString) {
        this.orderString = orderString;
    }

}
