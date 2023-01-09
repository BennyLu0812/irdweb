package com.ird.portal.common.mobile;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * <br/> 驗車流程狀態手機端對外
 * <br/>
 * <b>Date:</b> 2021/11/04 09:29<br/>
 *
 * @author Vincent
 * @version 1.0
 */
public class InspProcessMobileDTO {

    private Long processId;
    /**
     *車輛類別 - 全稱
     */
    private String vehTypeDesc;
    /**
     *車牌編號
     */
    private String plateNo;
    /**
     * 預約時間
     */
    private String bookingTime;
    /**
     * 驗車中心簡稱
     */
    private String centerShortName;
    /**
     * 驗車中心名稱中文
     */
    private String centerNameCn;

    /**
     * 驗車中心名稱中文葡文
     */
    private String centerNamePt;
    /**
     *驗車流程狀態
     *  P : P-ProcessIng-進行中
     *  F: F-Finished-已完成
     *  R: R-Reinspection-重測
     *  C: C-Canceled-已取消
     */
    private String processStatus;
    /**
     *報到ID
     */
    private Integer checkInId;
    /**
     *報到時間
     */
    private Date checkInTime;
    /**
     *進場時間
     */
     private Date entryTime;
    /**
     * 建議停車區域
     */
    private String suggestParkingArea;
    /**
     *VSS登錄時間
     */
    private Date vssLoginTime;
    /**
     *目視檢驗開始時間
     */
    private Date vasualInspStartTime;
    /**
     *目視檢測員
     */
    private String vasualInspector;
    /**
     *目視檢測員 - 中
     */
    private String vasualInspectorCNName;

    /**
     *目視檢測員 - 葡
     */
    private String vasualInspectorPTName;
    /**
     *機械性檢驗開始時間
     */
    private Date mechanicalInspStartTime;
    /**
     *機械性檢驗驗車線
     */
    private String inspectorLine;

    /**
     *機械性檢驗員
     */
    private String mechanicalInspector;
    /**
     *機械性檢驗員-中
     */
    private String mechanicalInspectorCNName;
    /**
     *機械性檢驗員-葡
     */
    private String mechanicalInspectorPTName;

    /**
     *预约方式
     */
    private String isVta;

    /**
     *是否重測
     */
    private String isReinspection;

    /**
     * 分配驗車員
     */
    private String assignInspector;

    /**
     * 分配驗車員時間
     */
    private Date assignInspectorTime;

    /**
     * 關閉機械性檢驗驗車員
     */
    private String closeMechanicalInspector;
    private String closeMechanicalInspectorCName;
    private String closeMechanicalInspectorPName;

    /**
     * 關閉機械性檢驗時間
     */
    private Date closeMechanicalTime;

    /**
     * 檢錄時間
     */
    private Date enrollTime;

    /**
     * 檢錄方式
     */
    private String enrollMode;


    /**
     * 檢錄方式名稱
     */
    private String enrollModeName;
    /**
     * 是否使用舊工控
     */
    private String isUseOldIndustrialControl;
    /**
     * 報道後同步進場（Y/N）
     */
    private String checkInSyncEntry;
    /**
     * 当前车辆时间
     */
    private String targetDate;

    /**
     * 是否是新车
     */
    private String isNewCar;

    public Long getProcessId() {
        return processId;
    }

    public void setProcessId(Long processId) {
        this.processId = processId;
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

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getCenterShortName() {
        return centerShortName;
    }

    public void setCenterShortName(String centerShortName) {
        this.centerShortName = centerShortName;
    }

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus;
    }

    public Integer getCheckInId() {
        return checkInId;
    }

    public void setCheckInId(Integer checkInId) {
        this.checkInId = checkInId;
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

    public String getSuggestParkingArea() {
        return suggestParkingArea;
    }

    public void setSuggestParkingArea(String suggestParkingArea) {
        this.suggestParkingArea = suggestParkingArea;
    }
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss",timezone="GMT+8")
    public Date getVssLoginTime() {
        return vssLoginTime;
    }

    public void setVssLoginTime(Date vssLoginTime) {
        this.vssLoginTime = vssLoginTime;
    }
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss",timezone="GMT+8")
    public Date getVasualInspStartTime() {
        return vasualInspStartTime;
    }

    public void setVasualInspStartTime(Date vasualInspStartTime) {
        this.vasualInspStartTime = vasualInspStartTime;
    }

    public String getVasualInspector() {
        return vasualInspector;
    }

    public void setVasualInspector(String vasualInspector) {
        this.vasualInspector = vasualInspector;
    }
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss",timezone="GMT+8")
    public Date getMechanicalInspStartTime() {
        return mechanicalInspStartTime;
    }

    public void setMechanicalInspStartTime(Date mechanicalInspStartTime) {
        this.mechanicalInspStartTime = mechanicalInspStartTime;
    }

    public String getInspectorLine() {
        return inspectorLine;
    }

    public void setInspectorLine(String inspectorLine) {
        this.inspectorLine = inspectorLine;
    }

    public String getIsVta() {
        return isVta;
    }

    public void setIsVta(String isVta) {
        this.isVta = isVta;
    }

    public String getIsReinspection() {
        return isReinspection;
    }

    public void setIsReinspection(String isReinspection) {
        this.isReinspection = isReinspection;
    }

    public String getMechanicalInspector() {
        return mechanicalInspector;
    }

    public void setMechanicalInspector(String mechanicalInspector) {
        this.mechanicalInspector = mechanicalInspector;
    }

    public String getVasualInspectorCNName() {
        return vasualInspectorCNName;
    }

    public void setVasualInspectorCNName(String vasualInspectorCNName) {
        this.vasualInspectorCNName = vasualInspectorCNName;
    }

    public String getVasualInspectorPTName() {
        return vasualInspectorPTName;
    }

    public void setVasualInspectorPTName(String vasualInspectorPTName) {
        this.vasualInspectorPTName = vasualInspectorPTName;
    }

    public String getMechanicalInspectorCNName() {
        return mechanicalInspectorCNName;
    }

    public void setMechanicalInspectorCNName(String mechanicalInspectorCNName) {
        this.mechanicalInspectorCNName = mechanicalInspectorCNName;
    }

    public String getMechanicalInspectorPTName() {
        return mechanicalInspectorPTName;
    }

    public void setMechanicalInspectorPTName(String mechanicalInspectorPTName) {
        this.mechanicalInspectorPTName = mechanicalInspectorPTName;
    }

    public String getAssignInspector() {
        return assignInspector;
    }

    public void setAssignInspector(String assignInspector) {
        this.assignInspector = assignInspector;
    }
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss",timezone="GMT+8")
    public Date getAssignInspectorTime() {
        return assignInspectorTime;
    }

    public void setAssignInspectorTime(Date assignInspectorTime) {
        this.assignInspectorTime = assignInspectorTime;
    }

    public String getCloseMechanicalInspector() {
        return closeMechanicalInspector;
    }

    public void setCloseMechanicalInspector(String closeMechanicalInspector) {
        this.closeMechanicalInspector = closeMechanicalInspector;
    }
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss",timezone="GMT+8")
    public Date getCloseMechanicalTime() {
        return closeMechanicalTime;
    }

    public void setCloseMechanicalTime(Date closeMechanicalTime) {
        this.closeMechanicalTime = closeMechanicalTime;
    }

    public String getCloseMechanicalInspectorCName() {
        return closeMechanicalInspectorCName;
    }

    public void setCloseMechanicalInspectorCName(String closeMechanicalInspectorCName) {
        this.closeMechanicalInspectorCName = closeMechanicalInspectorCName;
    }

    public String getCloseMechanicalInspectorPName() {
        return closeMechanicalInspectorPName;
    }

    public void setCloseMechanicalInspectorPName(String closeMechanicalInspectorPName) {
        this.closeMechanicalInspectorPName = closeMechanicalInspectorPName;
    }
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss",timezone="GMT+8")
    public Date getEnrollTime() {
        return enrollTime;
    }

    public void setEnrollTime(Date enrollTime) {
        this.enrollTime = enrollTime;
    }

    public String getEnrollMode() {
        return enrollMode;
    }

    public void setEnrollMode(String enrollMode) {
        this.enrollMode = enrollMode;
    }

    public String getEnrollModeName() {
        return enrollModeName;
    }

    public void setEnrollModeName(String enrollModeName) {
        this.enrollModeName = enrollModeName;
    }

    public String getIsUseOldIndustrialControl() {
        return isUseOldIndustrialControl;
    }

    public void setIsUseOldIndustrialControl(String isUseOldIndustrialControl) {
        this.isUseOldIndustrialControl = isUseOldIndustrialControl;
    }

    public String getCheckInSyncEntry() {
        return checkInSyncEntry;
    }

    public void setCheckInSyncEntry(String checkInSyncEntry) {
        this.checkInSyncEntry = checkInSyncEntry;
    }

    public String getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(String targetDate) {
        this.targetDate = targetDate;
    }

    public String getIsNewCar() {
        return isNewCar;
    }

    public void setIsNewCar(String isNewCar) {
        this.isNewCar = isNewCar;
    }

    public String getCenterNameCn() {
        return centerNameCn;
    }

    public void setCenterNameCn(String centerNameCn) {
        this.centerNameCn = centerNameCn;
    }

    public String getCenterNamePt() {
        return centerNamePt;
    }

    public void setCenterNamePt(String centerNamePt) {
        this.centerNamePt = centerNamePt;
    }

    @Override
    public String toString() {
        return "InspProcessMobileDTO{" +
                "processId=" + processId +
                ", vehTypeDesc='" + vehTypeDesc + '\'' +
                ", plateNo='" + plateNo + '\'' +
                ", bookingTime='" + bookingTime + '\'' +
                ", centerShortName='" + centerShortName + '\'' +
                ", centerNameCn='" + centerNameCn + '\'' +
                ", centerNamePt='" + centerNamePt + '\'' +
                ", processStatus='" + processStatus + '\'' +
                ", checkInId=" + checkInId +
                ", checkInTime=" + checkInTime +
                ", entryTime=" + entryTime +
                ", suggestParkingArea='" + suggestParkingArea + '\'' +
                ", vssLoginTime=" + vssLoginTime +
                ", vasualInspStartTime=" + vasualInspStartTime +
                ", vasualInspector='" + vasualInspector + '\'' +
                ", vasualInspectorCNName='" + vasualInspectorCNName + '\'' +
                ", vasualInspectorPTName='" + vasualInspectorPTName + '\'' +
                ", mechanicalInspStartTime=" + mechanicalInspStartTime +
                ", inspectorLine='" + inspectorLine + '\'' +
                ", mechanicalInspector='" + mechanicalInspector + '\'' +
                ", mechanicalInspectorCNName='" + mechanicalInspectorCNName + '\'' +
                ", mechanicalInspectorPTName='" + mechanicalInspectorPTName + '\'' +
                ", isVta='" + isVta + '\'' +
                ", isReinspection='" + isReinspection + '\'' +
                ", assignInspector='" + assignInspector + '\'' +
                ", assignInspectorTime=" + assignInspectorTime +
                ", closeMechanicalInspector='" + closeMechanicalInspector + '\'' +
                ", closeMechanicalInspectorCName='" + closeMechanicalInspectorCName + '\'' +
                ", closeMechanicalInspectorPName='" + closeMechanicalInspectorPName + '\'' +
                ", closeMechanicalTime=" + closeMechanicalTime +
                ", enrollTime=" + enrollTime +
                ", enrollMode='" + enrollMode + '\'' +
                ", enrollModeName='" + enrollModeName + '\'' +
                ", isUseOldIndustrialControl='" + isUseOldIndustrialControl + '\'' +
                ", checkInSyncEntry='" + checkInSyncEntry + '\'' +
                ", targetDate='" + targetDate + '\'' +
                ", isNewCar='" + isNewCar + '\'' +
                '}';
    }
}
