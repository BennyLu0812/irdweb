package com.ird.portal.common.api.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ird.portal.datatable.AbstractDatatableDTO;

import java.util.Date;

/**
 *
 * 進場查詢的返回數據 DTO
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 2021/10/12 16:54<br/>
 *
 * @author Aaron
 * @version 1.0
 */
public class EntryQueryResponseDTO extends AbstractDatatableDTO {

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
     * 停車區域
     */
    private String parkingName;

    /**
     * 報到時間
     */
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date checkInTime;

    /**
     * 預約方式
     */
    private String bookingType;
    private String bookingTypeDesc;

    /**
     * 預約時間
     */
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date bookingTime;

    /**
     * 進場時間
     */
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date entryTime;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date entryStartTime;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date entryEndTime;


    /**
     * 開閘方式
     */
    private String openType;
    private String openTypeDesc;

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

    public String getParkingName() {
        return parkingName;
    }

    public void setParkingName(String parkingName) {
        this.parkingName = parkingName;
    }

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

    public Date getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Date bookingTime) {
        this.bookingTime = bookingTime;
    }

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

    public Date getEntryStartTime() {
        return entryStartTime;
    }

    public void setEntryStartTime(Date entryStartTime) {
        this.entryStartTime = entryStartTime;
    }

    public Date getEntryEndTime() {
        return entryEndTime;
    }

    public void setEntryEndTime(Date entryEndTime) {
        this.entryEndTime = entryEndTime;
    }

    public String getVehTypeDesc() {
        return vehTypeDesc;
    }

    public void setVehTypeDesc(String vehTypeDesc) {
        this.vehTypeDesc = vehTypeDesc;
    }

    public String getBookingTypeDesc() {
        return bookingTypeDesc;
    }

    public void setBookingTypeDesc(String bookingTypeDesc) {
        this.bookingTypeDesc = bookingTypeDesc;
    }

    public String getOpenTypeDesc() {
        return openTypeDesc;
    }

    public void setOpenTypeDesc(String openTypeDesc) {
        this.openTypeDesc = openTypeDesc;
    }

    @Override
    public String toString() {
        return "EntryQueryResponseDTO{" +
                "vehType='" + vehType + '\'' +
                ", plateNo='" + plateNo + '\'' +
                ", parkingName='" + parkingName + '\'' +
                ", checkInTime='" + checkInTime + '\'' +
                ", bookingType='" + bookingType + '\'' +
                ", bookingTime='" + bookingTime + '\'' +
                ", entryTime='" + entryTime + '\'' +
                ", entryStartTime=" + entryStartTime +
                ", entryEndTime=" + entryEndTime +
                ", openType='" + openType + '\'' +
                '}';
    }
}
