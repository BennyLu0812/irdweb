package com.ird.portal.common.api.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ird.portal.data.BaseDTO;

import java.util.Date;

/**
 *
 * 登錄提醒sms DTO
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 2021/10/12 16:54<br/>
 *
 * @author Aaron
 * @version 1.0
 */
public class LoginTipSmsDTO extends BaseDTO {

    /**
     *  車輛編號
     */
    private String plateNo;
    /**
     *  車輛類型
     */
    private String vehType;
    private String vehTypeDesc;
    /**
     *  驗車中心編號
     */
    private String centerCode;
    private Date entryTime;
    /**
     *  電話
     */
    private String phone;

    /**
     *  停車區
     */
    private String suggestParkingArea;

    /**
     *  預約超時分鐘
     */
    private Integer minute;
    /**
     * 是否型號認可
     */
    private String isVta;

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

    public String getVehTypeDesc() {
        return vehTypeDesc;
    }

    public void setVehTypeDesc(String vehTypeDesc) {
        this.vehTypeDesc = vehTypeDesc;
    }

    public String getCenterCode() {
        return centerCode;
    }

    public void setCenterCode(String centerCode) {
        this.centerCode = centerCode;
    }

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss",timezone="GMT+8")
    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public String getSuggestParkingArea() {
        return suggestParkingArea;
    }

    public void setSuggestParkingArea(String suggestParkingArea) {
        this.suggestParkingArea = suggestParkingArea;
    }

    public String getIsVta() {
        return isVta;
    }

    public void setIsVta(String isVta) {
        this.isVta = isVta;
    }

    @Override
    public String toString() {
        return "LoginTipSmsDTO{" +
                "plateNo='" + plateNo + '\'' +
                ", vehType='" + vehType + '\'' +
                ", vehTypeDesc='" + vehTypeDesc + '\'' +
                ", centerCode='" + centerCode + '\'' +
                ", entryTime='" + entryTime + '\'' +
                ", phone='" + phone + '\'' +
                ", suggestParkingArea='" + suggestParkingArea + '\'' +
                ", minute='" + minute + '\'' +
                ", isVta='" + isVta + '\'' +
                '}';
    }
}
