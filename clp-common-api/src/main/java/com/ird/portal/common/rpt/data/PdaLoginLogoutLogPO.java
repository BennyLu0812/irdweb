package com.ird.portal.common.rpt.data;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;

import java.util.Date;

/**
 * @author Tim
 * @version 1.0
 * @date 27/01/2022 17:08
 */
@ColumnWidth(30)
public class PdaLoginLogoutLogPO {

    /**
     * 驗車員編號
     */
    @ExcelProperty("驗車員編號")
    private String userId;

    /**
     * 驗車員狀態中文名
     */
    @ExcelProperty("驗車員狀態")
    private String workStatus;

    /**
     * 創建時間
     */
    @ExcelProperty("創建時間")
    @DateTimeFormat("dd/MM/yyyy hh:mm:ss")
    private Date createDate;

    /**
     * 驗車中心名稱
     */
    @ExcelProperty("驗車中心名稱")
    private String centerCodeCn;

    /**
     * 更次中文名稱
     */
    @ExcelProperty("更次")
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

    public Date getCreateDate() {
        return createDate;
    }

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
        return "PdaLoginLogoutLogPO{" +
                "userId='" + userId + '\'' +
                ", workStatus='" + workStatus + '\'' +
                ", createDate=" + createDate +
                ", centerCodeCn='" + centerCodeCn + '\'' +
                ", workTimeType='" + workTimeType + '\'' +
                '}';
    }
}
