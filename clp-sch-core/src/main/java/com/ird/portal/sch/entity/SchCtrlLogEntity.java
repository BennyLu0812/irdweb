package com.ird.portal.sch.entity;

import com.ird.portal.entity.AbstractEntity;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;


/**
 * 
 * 排程工作日志實體
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 2017年11月16日<br/>
 * 
 * @author Allen
 * @version 1.0
 */
@Entity
@Table(name = "CLP_SCH_CTRL_LOG")
public class SchCtrlLogEntity extends AbstractEntity {
    
    
    private static final long serialVersionUID = -5884722535468982101L;
    
    /** VSS_JOB_CTRL_LOG (sequence no) */
    private Long schCtrlLogId;
    
    /** SCH_CTRL_ID */
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
    
    /** 結束時間 */
    private Date endTime;
    
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
    private String jobCode;
    
    private SchCtrlEntity schCtrl;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLP_SCH_CTRL_LOG_SEQ")
    @SequenceGenerator(name = "CLP_SCH_CTRL_LOG_SEQ", sequenceName = "CLP_SCH_CTRL_LOG_SEQ", allocationSize = 1)
    @Column(name = "SCH_CTRL_LOG_ID")
    public Long getSchCtrlLogId() {
        return schCtrlLogId;
    }

    public void setSchCtrlLogId(Long schCtrlLogId) {
        this.schCtrlLogId = schCtrlLogId;
    }
    
    @Column(name = "SCH_CTRL_ID", columnDefinition = "BIGINT")
    public Long getSchCtrlId() {
        return schCtrlId;
    }
    
    public void setSchCtrlId(Long schCtrlId) {
        this.schCtrlId = schCtrlId;
    }
    
    @Column(name = "REC_PROCESSED", columnDefinition = "INT")
    public Integer getRecProcessed() {
        return recProcessed;
    }
    
    public void setRecProcessed(Integer recProcessed) {
        this.recProcessed = recProcessed;
    }
    
    @Column(name = "REC_PENDING", columnDefinition = "INT")
    public Integer getRecPending() {
        return recPending;
    }
    
    public void setRecPending(Integer recPending) {
        this.recPending = recPending;
    }
    
    @Column(name = "REC_INSERT", columnDefinition = "INT")
    public Integer getRecInsert() {
        return recInsert;
    }
    
    public void setRecInsert(Integer recInsert) {
        this.recInsert = recInsert;
    }
    
    @Column(name = "REC_UPDATE", columnDefinition = "INT")
    public Integer getRecUpdate() {
        return recUpdate;
    }
    
    public void setRecUpdate(Integer recUpdate) {
        this.recUpdate = recUpdate;
    }
    
    @Column(name = "REC_DELETE", columnDefinition = "INT")
    public Integer getRecDelete() {
        return recDelete;
    }
    
    public void setRecDelete(Integer recDelete) {
        this.recDelete = recDelete;
    }
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "START_TIME")
    public Date getStartTime() {
        return startTime;
    }
    
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "END_TIME")
    public Date getEndTime() {
        return endTime;
    }
    
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    
    @Column(name = "STATUS", columnDefinition = "VARCHAR(20)")
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    @Column(name = "LATEST_JOB_IND", columnDefinition = "CHAR(1)")
    @Type(type = "yes_no")
    public Boolean getLatestJobInd() {
        return latestJobInd;
    }
    
    public void setLatestJobInd(Boolean latestJobInd) {
        this.latestJobInd = latestJobInd;
    }
    
    @Column(name = "ERROR_CODE", columnDefinition = "NVARCHAR(20)")
    public String getErrorCode() {
        return errorCode;
    }
    
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
    
    @Column(name = "ERROR_MSG", columnDefinition = "NVARCHAR(2000)")
    public String getErrorMsg() {
        return errorMsg;
    }
    
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
    
    @Column(name = "LOG_FILE_NAME", columnDefinition = "NVARCHAR(200)")
    public String getLogFileName() {
        return logFileName;
    }
    
    public void setLogFileName(String logFileName) {
        this.logFileName = logFileName;
    }
    
    @Column(name = "JOB_CODE", columnDefinition = "NVARCHAR(30)")
    public String getJobCode() {
        return jobCode;
    }
    
    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }
    
    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "SCH_CTRL_ID", columnDefinition = "BIGINT", insertable = false, updatable = false)
    public SchCtrlEntity getSchCtrl() {
        return schCtrl;
    }
    
    public void setSchCtrl(SchCtrlEntity schCtrl) {
        this.schCtrl = schCtrl;
    }
    
}
