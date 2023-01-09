package com.ird.portal.datatable;

import com.ird.portal.model.Page;

import java.util.Collection;
import java.util.Collections;

/**
 * 专为datatables提供数据的类,
 * 在返回数据时，返回该类即可.
 */
public class DataTablePage implements Page {
    private static final long serialVersionUID = -7099816727008531820L;

    /**
     * 框架必须的三个字段.
     */
    private int pageSize;
    private int startForm;
    private Collection<?> data;

    public DataTablePage(AbstractDatatableDTO datatableDTO){
        setDraw(datatableDTO.getDraw());
        setStartForm(datatableDTO.getStart());
        setPageSize(datatableDTO.getLength());
    }
    /**
     * Datatables 必须返回的字段.
     */
    private String error;
    private int draw;
    private long recordsTotal;
    private long recordsFiltered;


    public int getDraw() {
        return draw;
    }

    public DataTablePage setDraw(int draw) {
        this.draw = draw;
        return this;
    }

    public long getRecordsTotal() {
        return recordsTotal;
    }

    public DataTablePage setRecordsTotal(long recordsTotal) {
        this.recordsTotal = recordsTotal;
        return this;
    }

    public long getRecordsFiltered() {
        return recordsFiltered;
    }

    public DataTablePage setRecordsFiltered(long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
        return this;
    }

    public Collection<?> getData() {
        if (data == null) {
            data = Collections.emptyList();
        }
        return data;
    }

    public void setData(Collection<?> data) {
        this.data = data;
    }

    @Override
    public long getTotal() {
        return recordsTotal;
    }

    @Override
    public void setTotal(long total) {
        recordsTotal = total;
        recordsFiltered = total;
    }

    @Override
    public int getPageSize() {
        return pageSize;
    }

    @Override
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public int getStartForm() {
        return startForm;
    }

    @Override
    public void setStartForm(int startForm) {
        this.startForm = startForm;
    }

    public String getError() {
        return error;
    }

    public DataTablePage setError(String error) {
        this.error = error;
        return this;
    }

    @Override
    public String toString() {
        return "DataTablePage{" +
                "pageSize=" + pageSize +
                ", startForm=" + startForm +
                ", data=" + data +
                ", error='" + error + '\'' +
                ", draw=" + draw +
                ", recordsTotal=" + recordsTotal +
                ", recordsFiltered=" + recordsFiltered +
                '}';
    }
}
