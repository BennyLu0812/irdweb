package com.ird.portal.common.rpt.data;

import java.util.ArrayList;
import java.util.List;

/**
 * 自動打印DTO
 * @author AugusChen
 */
public class AutoPrintDTO {

    /**
     * 驗車中心編碼
     */
    private String centerCode;

    /**
     * 驗車線
     */
    private List<String> inspLineNoList = new ArrayList<>();

    /**
     * 需要打印的Report的編碼集合
     */
    private List<String> printReportList = new ArrayList<>();

    public String getCenterCode() {
        return centerCode;
    }

    public void setCenterCode(String centerCode) {
        this.centerCode = centerCode;
    }

    public List<String> getInspLineNoList() {
        return inspLineNoList;
    }

    public void setInspLineNoList(List<String> inspLineNoList) {
        this.inspLineNoList = inspLineNoList;
    }

    public List<String> getPrintReportList() {
        return printReportList;
    }

    public void setPrintReportList(List<String> printReportList) {
        this.printReportList = printReportList;
    }

    @Override
    public String toString() {
        return "AutoPrintDTO{" +
                "centerCode='" + centerCode + '\'' +
                ", inspLineNoList=" + inspLineNoList +
                ", printReportList=" + printReportList +
                '}';
    }
}
