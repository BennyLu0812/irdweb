package com.ird.portal.common.sys.data;

import java.util.Date;

/**
 * 
 * 統計圖.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 16/11/2021 09:58:05<br/>
 * 
 * @author Deft
 * @version 1.0
 */
public class StatisticsDTO {

   private Date date;

   private Integer total;


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "StatisticsDTO{" +
                "date=" + date +
                ", total=" + total +
                '}';
    }
}
