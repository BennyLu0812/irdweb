package com.ird.portal.select2;

import com.ird.portal.model.Page;

import java.util.Collection;
import java.util.Collections;

public class Select2Page implements Page {
     
    private static final long serialVersionUID = 94985795779247367L;

    private int pageSize;
    private int startForm;    
    private Collection<?> data;
    
    private long totalElements;
    private int totalPages;
    private int pageNumber;
    
    public Select2Page(int pageSize, int pageNumber) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }
    
    public Select2Page(int pageSize, int pageNumber, Collection<?> data, int totalElements) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.data = data;
        this.totalElements = totalElements;
        this.totalPages = (totalElements + pageSize - 1) / pageSize;
    }
    
    
    @Override
    public Collection<?> getData() {
        if (data == null) {
            data = Collections.emptyList();
        }
        return data;
    }

    @Override
    public void setData(Collection<?> data) {
        this.data = data;
    }

    @Override
    public long getTotal() {
        return totalElements;
    }

    @Override
    public void setTotal(long total) {
        this.totalElements = total;
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
    	if (pageNumber <= 0) return 0;
        return (pageNumber -1)*pageSize;
    }

    @Override
    public void setStartForm(int startForm) {
        this.startForm = startForm;
    }

    public long getTotalElements() {
        return totalElements;
    }
    
    public int getTotalPages() {
        return (int)((totalElements + pageSize - 1) / pageSize);
    }
   
    public int getPageNumber() {
        return pageNumber;
    }
   
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
    
}
