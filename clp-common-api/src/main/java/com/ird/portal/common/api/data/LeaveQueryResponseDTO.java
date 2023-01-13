package com.ird.portal.common.api.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ird.portal.datatable.AbstractDatatableDTO;

import java.util.Date;

/**
 *
 * 出場查詢的返回數據 DTO
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 2021/10/12 16:54<br/>
 *
 * @author Aaron
 * @version 1.0
 */
public class LeaveQueryResponseDTO extends AbstractDatatableDTO {

    /**
     *  驗車中心
     */
    private String centerCode;

    /**
     * 車輛級別
     */
    private String vehType;
    private String vehTypeDesc;

    /**
     * 車牌編號
     */
    private String plateNo;

    /**
     * 開閘時間
     */
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date leaveTime;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date leaveStartTime;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date leaveEndTime;

    public String getCenterCode() {
        return centerCode;
    }

    public void setCenterCode(String centerCode) {
        this.centerCode = centerCode;
    }

    public String getVehType() {
        return vehType;
    }

    public void setVehType(String vehType) {
        this.vehType = vehType;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }

    public Date getLeaveStartTime() {
        return leaveStartTime;
    }

    public void setLeaveStartTime(Date leaveStartTime) {
        this.leaveStartTime = leaveStartTime;
    }

    public Date getLeaveEndTime() {
        return leaveEndTime;
    }

    public void setLeaveEndTime(Date leaveEndTime) {
        this.leaveEndTime = leaveEndTime;
    }

    public String getVehTypeDesc() {
        return vehTypeDesc;
    }

    public void setVehTypeDesc(String vehTypeDesc) {
        this.vehTypeDesc = vehTypeDesc;
    }

    @Override
    public String toString() {
        return "LeaveQueryResponseDTO{" +
                "centerCode='" + centerCode + '\'' +
                ", vehType='" + vehType + '\'' +
                ", vehTypeDesc='" + vehTypeDesc + '\'' +
                ", plateNo='" + plateNo + '\'' +
                ", leaveTime=" + leaveTime +
                ", leaveStartTime=" + leaveStartTime +
                ", leaveEndTime=" + leaveEndTime +
                '}';
    }
}
