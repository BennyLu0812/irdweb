package com.ird.portal.common.api.data;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * <br/> 離場返回數據實體
 * <br/>
 * <b>Date:</b> 2021/10/4 17:13<br/>
 *
 * @author Zack
 * @version 1.0
 */
public class LeaveResponseDTO {

    private String plateNo;

    private String vehType;
    private String vehTypeDesc;

    private String bookingTime;

    private Date checkInTime;

    private Date entryTime;

    private Date leaveTime;

    /**
     * 校驗結果代碼
     */
    private String result;

    /**
     * 校驗結果描述
     */
    private String resultMsg;

    private Long processId;

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getVehType() {
        return vehType;
    }

    public void setVehType(String vehType) {
        this.vehType = vehType;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss",timezone="GMT+8")
    public Date getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Date checkInTime) {
        this.checkInTime = checkInTime;
    }

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss",timezone="GMT+8")
    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss",timezone="GMT+8")
    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String getVehTypeDesc() {
        return vehTypeDesc;
    }

    public void setVehTypeDesc(String vehTypeDesc) {
        this.vehTypeDesc = vehTypeDesc;
    }

    public Long getProcessId() {
        return processId;
    }

    public void setProcessId(Long processId) {
        this.processId = processId;
    }

    @Override
    public String toString() {
        return "LeaveResponseDTO{" +
                "plateNo='" + plateNo + '\'' +
                ", vehType='" + vehType + '\'' +
                ", vehTypeDesc='" + vehTypeDesc + '\'' +
                ", bookingTime='" + bookingTime + '\'' +
                ", checkInTime=" + checkInTime +
                ", entryTime=" + entryTime +
                ", leaveTime=" + leaveTime +
                ", result='" + result + '\'' +
                ", resultMsg='" + resultMsg + '\'' +
                '}';
    }
}
