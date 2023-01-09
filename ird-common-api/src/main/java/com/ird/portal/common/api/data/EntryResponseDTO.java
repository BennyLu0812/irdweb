package com.ird.portal.common.api.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 *
 * 進場校驗的返回數據 DTO
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 2021/9/19 14:43<br/>
 *
 * @author Zack
 * @version 1.0
 */
public class EntryResponseDTO {
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
     * 驗車中心CODE
     */
    private String centerCode;

    /**
     * 停車區域
     */
    private String parkingName;

    /**
     * 報到時間
     */
    private Date checkInTime;

    /**
     * 預約方式
     */
    private String bookingType;

    /**
     * 預約時間
     */
    private String bookingTime;

    /**
     * 進場時間
     */
    private Date entryTime;

    /**
     * 開閘方式
     */
    private String openType;

    /**
     * 校驗結果代碼
     */
    private String result;

    /**
     * 校驗結果描述
     */
    private String resultMsg;

    private Long processId;

    public String getVehType() {
        return vehType;
    }

    public void setVehType(String vehType) {
        this.vehType = vehType;
    }

    public String getVehTypeDesc() {
        return vehTypeDesc;
    }

    public void setVehTypeDesc(String vehTypeDesc) {
        this.vehTypeDesc = vehTypeDesc;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getCenterCode() {
        return centerCode;
    }

    public void setCenterCode(String centerCode) {
        this.centerCode = centerCode;
    }

    public String getParkingName() {
        return parkingName;
    }

    public void setParkingName(String parkingName) {
        this.parkingName = parkingName;
    }

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss",timezone="GMT+8")
    public Date getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Date checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getBookingType() {
        return bookingType;
    }

    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
    }

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss",timezone="GMT+8")
    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss",timezone="GMT+8")
    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public String getOpenType() {
        return openType;
    }

    public void setOpenType(String openType) {
        this.openType = openType;
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

    @JsonIgnore
    public Long getProcessId() {
        return processId;
    }

    public void setProcessId(Long processId) {
        this.processId = processId;
    }

    @Override
    public String toString() {
        return "EntryResponseDTO{" +
                "vehType='" + vehType + '\'' +
                ", vehTypeDesc='" + vehTypeDesc + '\'' +
                ", plateNo='" + plateNo + '\'' +
                ", centerCode='" + centerCode + '\'' +
                ", parkingName='" + parkingName + '\'' +
                ", checkInTime=" + checkInTime +
                ", bookingType='" + bookingType + '\'' +
                ", bookingTime='" + bookingTime + '\'' +
                ", entryTime=" + entryTime +
                ", openType='" + openType + '\'' +
                ", result='" + result + '\'' +
                ", resultMsg='" + resultMsg + '\'' +
                '}';
    }
}
