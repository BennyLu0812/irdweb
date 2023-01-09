package com.ird.portal.common.api.data;

/**
 *
 * 報到校驗、進場校驗、手動放行、出場校驗的請求數據 DTO
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 2021/9/19 14:43<br/>
 *
 * @author Zack
 * @version 1.0
 */
public class QueRequestDTO {

    /**
     * 車牌編號
     */
    private String plateNo;

    /**
     * 車輛級別（A-汽車，M-摩托車）
     */
    private String vehCat;

    /**
     * 預約方式
     */
    private String bookingType;

    /**
     * 驗車中心Code
     */
    private String centerCode;

    /**
     * 設備ID
     */
    private Integer machineId;
    /**
     * 閘機code（用於傳值）
     */
    private String gateCode;

    /**
     * 車輛類別
     */
    private String vehType;

    /**
     * 指定查詢時間
     */
    private String targetDate;

    private Long processId;

    private String codeParamP;

    private String codeParamV;

    private String checkInTime;
    private String entryTime;

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getVehCat() {
        return vehCat;
    }

    public void setVehCat(String vehCat) {
        this.vehCat = vehCat;
    }

    public String getBookingType() {
        return bookingType;
    }

    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
    }

    public String getCenterCode() {
        return centerCode;
    }

    public void setCenterCode(String centerCode) {
        this.centerCode = centerCode;
    }

    public Integer getMachineId() {
        return machineId;
    }

    public void setMachineId(Integer machineId) {
        this.machineId = machineId;
    }

    public String getGateCode() {
        return gateCode;
    }

    public void setGateCode(String gateCode) {
        this.gateCode = gateCode;
    }

    public String getVehType() {
        return vehType;
    }

    public void setVehType(String vehType) {
        this.vehType = vehType;
    }

    public String getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(String targetDate) {
        this.targetDate = targetDate;
    }

    public Long getProcessId() {
        return processId;
    }

    public void setProcessId(Long processId) {
        this.processId = processId;
    }

    public String getCodeParamP() {
        return codeParamP;
    }

    public void setCodeParamP(String codeParamP) {
        this.codeParamP = codeParamP;
    }

    public String getCodeParamV() {
        return codeParamV;
    }

    public void setCodeParamV(String codeParamV) {
        this.codeParamV = codeParamV;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    @Override
    public String toString() {
        return "QueRequestDTO{" +
                "plateNo='" + plateNo + '\'' +
                ", vehCat='" + vehCat + '\'' +
                ", bookingType='" + bookingType + '\'' +
                ", centerCode=" + centerCode +
                ", machineId=" + machineId +
                ", gateCode=" + gateCode +
                ", vehType=" + vehType +
                ", targetDate=" + targetDate +
                ", processId=" + processId +
                ", codeParamP=" + codeParamP +
                ", codeParamV=" + codeParamV +
                ", checkInTime=" + checkInTime +
                ", entryTime=" + entryTime +
                '}';
    }
}
