package com.ird.portal.model;

import java.io.Serializable;
import java.util.Collection;

/**
 * 分页的Model.
 *
 * @author Jim
 * @since 20/03/2017 11:44 AM
 */
public interface Page extends Serializable {

    /**
     * 数据.
     *
     * @return
     */
    Collection<?> getData();

    void setData(Collection<?> data);

    /**
     * 总记录数.
     *
     * @return
     */
    long getTotal();

    void setTotal(long total);

    /**
     * 分页大小.
     *
     * @return
     */
    int getPageSize();

    void setPageSize(int pageSize);

    /**
     * 分页索引从哪里开始.
     *
     * @return
     */
    int getStartForm();

    void setStartForm(int startForm);

}
