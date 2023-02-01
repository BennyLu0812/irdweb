package com.ird.portal.sch.data;

import com.ird.portal.data.BaseDTO;
import com.ird.portal.util.DateUtil;

import java.util.Date;


/**
 * 
 * 排程日志DTO
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 2017年11月16日<br/>
 * @author Allen
 * @version 1.0
 */
public class SchCtrlLogDTO extends BaseDTO {
    
    
    private static final long serialVersionUID = 1L;
    
    /** VSS_JOB_CTRL_LOG (sequence no) */
    private Long schCtrlLogId;
    
    /** VSS_JOB_CTRL */
    private Long schCtrlId;
    
    /** 處理記錄數 */
    private Integer recProcessed;
    
    /** 未處理記錄數 */
    private Integer recPending;
    
    /** 新增記錄數 */
    private Integer recInsert;
    
    /** 更新記錄數 */
    private Integer recUpdate;
    
    /** 刪除記錄數 */
    private Integer recDelete;
    
    /** 開始時間 */
    private Date startTime;

    private String startTimeDesc;

    /** 結束時間 */
    private Date endTime;

    private String endTimeDesc;

    /** 工作狀態 */
    private String status;

    /** 是否最新工作 */
    private Boolean latestJobInd;
    
    /** 異常狀態碼 */
    private String errorCode;
    
    /** 異常詳細信息 */
    private String errorMsg;
    
    /** 日誌文件名稱 */
    private String logFileName;
    
    /** Job Name */
    private String jobName;

    private String jobCode;

    private SchCtrlDTO jobCtrl;

    public Long getSchCtrlLogId() {
        return schCtrlLogId;
    }

    public void setSchCtrlLogId(Long schCtrlLogId) {
        this.schCtrlLogId = schCtrlLogId;
    }

    public Long getSchCtrlId() {
        return schCtrlId;
    }
    
    public void setSchCtrlId(Long schCtrlId) {
        this.schCtrlId = schCtrlId;
    }
    
    public Integer getRecProcessed() {
        return recProcessed;
    }
    
    public void setRecProcessed(Integer recProcessed) {
        this.recProcessed = recProcessed;
    }
    
    public Integer getRecPending() {
        return recPending;
    }
    
    public void setRecPending(Integer recPending) {
        this.recPending = recPending;
    }
    
    public Integer getRecInsert() {
        return recInsert;
    }
    
    public void setRecInsert(Integer recInsert) {
        this.recInsert = recInsert;
    }
    
    public Integer getRecUpdate() {
        return recUpdate;
    }
    
    public void setRecUpdate(Integer recUpdate) {
        this.recUpdate = recUpdate;
    }
    
    public Integer getRecDelete() {
        return recDelete;
    }
    
    public void setRecDelete(Integer recDelete) {
        this.recDelete = recDelete;
    }
    
    public Date getStartTime() {
        return startTime;
    }
    
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    
    public Date getEndTime() {
        return endTime;
    }
    
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public Boolean getLatestJobInd() {
        return latestJobInd;
    }
    
    public void setLatestJobInd(Boolean latestJobInd) {
        this.latestJobInd = latestJobInd;
    }
    
    public String getErrorCode() {
        return errorCode;
    }
    
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
    
    public String getErrorMsg() {
        return errorMsg;
    }
    
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
    
    public String getLogFileName() {
        return logFileName;
    }
    
    public void setLogFileName(String logFileName) {
        this.logFileName = logFileName;
    }
    
    public String getJobName() {
        return jobName;
    }
    
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
    
    public SchCtrlDTO getJobCtrl() {
        return jobCtrl;
    }
    
    public void setJobCtrl(SchCtrlDTO jobCtrl) {
        this.jobCtrl = jobCtrl;
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public String getStartTimeDesc() {
        if (startTime != null){
           return DateUtil.format(startTime,DateUtil.DATE_FORMAT);
        }
        return startTimeDesc;
    }

    public void setStartTimeDesc(String startTimeDesc) {
        this.startTimeDesc = startTimeDesc;
    }

    public String getEndTimeDesc() {
        if (endTime != null){
            return DateUtil.format(endTime,DateUtil.DATE_FORMAT);
        }
        return endTimeDesc;
    }

    public void setEndTimeDesc(String endTimeDesc) {
        this.endTimeDesc = endTimeDesc;
    }

    @Override
    public String toString() {
        return "SchCtrlLogDTO [schCtrlId=" + schCtrlId + ", jobCtrlId=" + schCtrlId + ", recProcessed=" + recProcessed
            + ", recPending=" + recPending + ", recInsert=" + recInsert + ", recUpdate=" + recUpdate + ", recDelete="
            + recDelete + ", startTime=" + startTime + ", endTime=" + endTime + ", status=" + status + ", latestJobInd="
            + latestJobInd + ", errorCode=" + errorCode + ", errorMsg=" + errorMsg + ", logFileName=" + logFileName
            + ", jobName=" + jobName + ", jobCtrl=" + jobCtrl + "]";
    }
    
}
