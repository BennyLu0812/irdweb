package com.ird.portal.datatable;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Transient;


/**
 * data tables 的封装类,在需要使用分页的地方 将接受数据继承此父类.
 *
 * @author Jim
 */
public abstract class AbstractDatatableDTO implements Serializable {
    private static final long serialVersionUID = 7152194160690903992L;
    //默认分页大小
    public static final int DEFAULT_PAGE_SIZE = 15;
    // 大長度分頁
    public static final int LARGE_PAGE_SIZE = 100;

    private int draw = 0;
    private List<Columns> columns;
    private List<Order> order;
    private int start = 0;
    private int length = DEFAULT_PAGE_SIZE;
    private Search search;

    @Transient
    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    @Transient
    public List<Columns> getColumns() {
        return columns;
    }

    public void setColumns(List<Columns> columns) {
        this.columns = columns;
    }

    @Transient
    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    @Transient
    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    @Transient
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Transient
    public Search getSearch() {
        return search;
    }

    public void setSearch(Search search) {
        this.search = search;
    }

}
