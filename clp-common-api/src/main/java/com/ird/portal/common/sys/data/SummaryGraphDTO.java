package com.ird.portal.common.sys.data;


import java.util.List;

/**
 * 
 * 業務分類數量統計圖.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 16/11/2021 09:58:05<br/>
 * 
 * @author Deft
 * @version 1.0
 */
public class SummaryGraphDTO {

   //入场线
   private List<Integer> entryTimeTotal;

   //出场线
   private List<Integer> completeTimeTotal;

   //上班时间
   private List<String> workDate;

    public List<Integer> getEntryTimeTotal() {
        return entryTimeTotal;
    }

    public void setEntryTimeTotal(List<Integer> entryTimeTotal) {
        this.entryTimeTotal = entryTimeTotal;
    }

    public List<Integer> getCompleteTimeTotal() {
        return completeTimeTotal;
    }

    public void setCompleteTimeTotal(List<Integer> completeTimeTotal) {
        this.completeTimeTotal = completeTimeTotal;
    }

    public List<String> getWorkDate() {
        return workDate;
    }

    public void setWorkDate(List<String> workDate) {
        this.workDate = workDate;
    }

    @Override
    public String toString() {
        return "SummaryGraphDTO{" +
                "entryTimeTotal=" + entryTimeTotal +
                ", completeTimeTotal=" + completeTimeTotal +
                ", workDate=" + workDate +
                '}';
    }
}
