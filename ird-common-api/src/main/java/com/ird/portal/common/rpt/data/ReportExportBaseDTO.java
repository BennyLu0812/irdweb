package com.ird.portal.common.rpt.data;


import com.ird.portal.data.BaseDTO;

import java.util.Date;

/**
 * @author Tim
 * @version 1.0
 * @date 24/01/2022 9:34
 */
public class ReportExportBaseDTO extends BaseDTO {

    /**
     * 驗車中心code
     */
    private String centerCode;

    /**
     * 開始時間
     */
    private Date startDate;

    /**
     * 結束時間
     */
    private Date endDate;

    public String getCenterCode() {
        return centerCode;
    }

    public void setCenterCode(String centerCode) {
        this.centerCode = centerCode;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "ReportExportBaseDTO{" +
                "centerCode='" + centerCode + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
