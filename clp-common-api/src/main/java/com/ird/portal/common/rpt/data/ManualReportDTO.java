package com.ird.portal.common.rpt.data;


import com.ird.portal.data.BaseDTO;

/**
 * 手動打印報表對象
 * @author AugusChen
 */
public class ManualReportDTO extends BaseDTO {

    /**
     * 檢驗主檔編號
     */
    private String inspMasterId;

    /**
     * 檢驗次數
     */
    private Integer noOfTimesInsp;

    /**
     * 報表編碼
     */
    private String reportCode;

    /**
     * 驗車類型
     */
    private String cvicInspType;

    /**
     * 驗車子類別
     */
    private String inspSubTypeId;

    public String getInspMasterId() {
        return inspMasterId;
    }

    public void setInspMasterId(String inspMasterId) {
        this.inspMasterId = inspMasterId;
    }

    public Integer getNoOfTimesInsp() {
        return noOfTimesInsp;
    }

    public void setNoOfTimesInsp(Integer noOfTimesInsp) {
        this.noOfTimesInsp = noOfTimesInsp;
    }

    public String getReportCode() {
        return reportCode;
    }

    public void setReportCode(String reportCode) {
        this.reportCode = reportCode;
    }

    public String getCvicInspType() {
        return cvicInspType;
    }

    public void setCvicInspType(String cvicInspType) {
        this.cvicInspType = cvicInspType;
    }

    public String getInspSubTypeId() {
        return inspSubTypeId;
    }

    public void setInspSubTypeId(String inspSubTypeId) {
        this.inspSubTypeId = inspSubTypeId;
    }
}
