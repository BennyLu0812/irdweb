package com.ird.portal.common.rpt.data;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author Tim
 * @version 1.0
 * @date 27/01/2022 17:08
 */
public class PdaLoginLogoutLogDTO extends ReportExportBaseDTO{

    /**
     * 驗車員編號
     */
    private String userId;

    /**
     * 驗車眼狀態中文名
     */
    private String workStatus;

    /**
     * 創建時間
     */
    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss",timezone="GMT+8")
    private Date createDate;

    /**
     * 驗車中心名稱
     */
    private String centerCodeCn;

    /**
     * 更次中文名稱
     */
    private String workTimeType;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

    @Override
    public Date getCreateDate() {
        return createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCenterCodeCn() {
        return centerCodeCn;
    }

    public void setCenterCodeCn(String centerCodeCn) {
        this.centerCodeCn = centerCodeCn;
    }

    public String getWorkTimeType() {
        return workTimeType;
    }

    public void setWorkTimeType(String workTimeType) {
        this.workTimeType = workTimeType;
    }

    @Override
    public String toString() {
        return "PdaLoginLogoutLogDTO{" +
                "userId='" + userId + '\'' +
                ", workStatus='" + workStatus + '\'' +
                ", createDate=" + createDate +
                ", centerCodeCn='" + centerCodeCn + '\'' +
                ", workTimeType='" + workTimeType + '\'' +
                '}';
    }
}
