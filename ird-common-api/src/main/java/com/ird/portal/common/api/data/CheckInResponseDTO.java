package com.ird.portal.common.api.data;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 *
 * 報到校驗的返回數據實體
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 2021/9/19 14:43<br/>
 *
 * @author Zack
 * @version 1.0
 */
public class CheckInResponseDTO {
    /**
     * 報到ID
     */
    private int checkInId;

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
     * 停車區域
     */
    private String parkingName;

    /**
     * 驗車預約時段
     */
    private String bookingTime;

    /**
     * 報到時間
     */
    private Date checkInTime;

    /**
     * 預約方式
     */
    private String bookingType;

    /**
     * 校驗結果代碼
     */
    private String result;

    /**
     * 校驗結果描述
     */
    private String resultMsg;

    private String qrCodeString;

    public int getCheckInId() {
        return checkInId;
    }

    public void setCheckInId(int checkInId) {
        this.checkInId = checkInId;
    }

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

    public String getParkingName() {
        return parkingName;
    }

    public void setParkingName(String parkingName) {
        this.parkingName = parkingName;
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

    public String getBookingType() {
        return bookingType;
    }

    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
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

    public String getQrCodeString() {
        return qrCodeString;
    }

    public void setQrCodeString(String qrCodeString) {
        this.qrCodeString = qrCodeString;
    }

    @Override
    public String toString() {
        return "CheckInResponseDTO{" +
                "checkInId=" + checkInId +
                ", vehType='" + vehType + '\'' +
                ", vehTypeDesc='" + vehTypeDesc + '\'' +
                ", plateNo='" + plateNo + '\'' +
                ", parkingName='" + parkingName + '\'' +
                ", bookingTime='" + bookingTime + '\'' +
                ", checkInTime=" + checkInTime +
                ", bookingType='" + bookingType + '\'' +
                ", result='" + result + '\'' +
                ", resultMsg='" + resultMsg + '\'' +
                ", qrCodeString='" + qrCodeString + '\'' +
                '}';
    }
}
