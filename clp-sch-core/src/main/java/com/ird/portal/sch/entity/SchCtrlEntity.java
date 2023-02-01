package com.ird.portal.sch.entity;

import com.ird.portal.audit.annotation.Audited;
import com.ird.portal.entity.AbstractEntity;
import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * 
 * 排程工作實體
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 2017年11月16日<br/>
 * 
 * @author Allen
 * @version 1.0
 */
@Entity
@Audited
@Table(name = "CLP_SCH_CTRL")
public class SchCtrlEntity extends AbstractEntity {
    
    
    private static final long serialVersionUID = 8440401682609672488L;
    
    /** JOB_CTRL (sequence no) */
    private Long id;
    
    /** 模組名 */
    private String sysCode;
    
    /** Cron用途 */
    private String jobUse;
    
    /** Cron代碼 也作Job Name */
    private String jobCode;
    
    /** 以Cron格式定義Job的運營時間 */
    private String cronChar;
    
    /** 以數字的形式定義Job的運行間隔 (單位爲毫秒) */
    private Integer cronNum;
    
    /** ‘yyyy-MM-dd’，以日期格式定義Job的運行日子（特用於每年隻運行一次的任務） */
    private String cronDate;
    
    /** 執行class類的全路徑 */
    private String clsName;
    
    /** TXT文件存放路徑。導入時從此路徑讀取txt文件，導出時生成的txt文件放到此路徑 */
    private String dataDir;
    
    /** 是否同步任務 Y 同步任務 N 非同步任務 */
    private Boolean isSync;
    
    /** Job類型：JAVA,PLSQL,job_type = 'TRIGGER'不用调用 */
    private String jobType;
    
    /** 導出最近幾天的更新數據 */
    private Integer dataDays;
    
    /** 是否啓用JOB */
    private Boolean enabled;

    /** 工作狀態 */
    private String workStatus;

    /**
     * API 入參dataCentreId
     * */
    private String dataCentreId;

    
    @Id
    @Column(name = "SCH_CTRL_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(name = "SYS_CODE", columnDefinition = "VARCHAR(20)")
    public String getSysCode() {
        return sysCode;
    }
    
    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }
    
    @Column(name = "JOB_USE", columnDefinition = "NVARCHAR(100)")
    public String getJobUse() {
        return jobUse;
    }
    
    public void setJobUse(String jobUse) {
        this.jobUse = jobUse;
    }
    
    @Column(name = "JOB_CODE", columnDefinition = "NVARCHAR(100)")
    public String getJobCode() {
        return jobCode;
    }
    
    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }
    
    @Column(name = "CRON_CHAR", columnDefinition = "NVARCHAR(50)")
    public String getCronChar() {
        return cronChar;
    }
    
    public void setCronChar(String cronChar) {
        this.cronChar = cronChar;
    }
    
    @Column(name = "CRON_NUM", columnDefinition = "INT")
    public Integer getCronNum() {
        return cronNum;
    }
    
    public void setCronNum(Integer cronNum) {
        this.cronNum = cronNum;
    }
    
    @Column(name = "CRON_DATE", columnDefinition = "NVARCHAR(20)")
    public String getCronDate() {
        return cronDate;
    }
    
    public void setCronDate(String cronDate) {
        this.cronDate = cronDate;
    }
    
    @Column(name = "CLS_NAME", columnDefinition = "NVARCHAR(100)")
    public String getClsName() {
        return clsName;
    }
    
    public void setClsName(String clsName) {
        this.clsName = clsName;
    }
    
    @Column(name = "DATA_DIR", columnDefinition = "NVARCHAR(60)")
    public String getDataDir() {
        return dataDir;
    }
    
    public void setDataDir(String dataDir) {
        this.dataDir = dataDir;
    }
    
    @Column(name = "IS_SYNC", columnDefinition = "CHAR(1)")
    @Type(type = "yes_no")
    public Boolean getIsSync() {
        return isSync;
    }
    
    public void setIsSync(Boolean isSync) {
        this.isSync = isSync;
    }
    
    @Column(name = "JOB_TYPE", columnDefinition = "VARCHAR(20)")
    public String getJobType() {
        return jobType;
    }
    
    public void setJobType(String jobType) {
        this.jobType = jobType;
    }
    
    @Column(name = "DATA_DAYS", columnDefinition = "INT")
    public Integer getDataDays() {
        return dataDays;
    }
    
    public void setDataDays(Integer dataDays) {
        this.dataDays = dataDays;
    }
    
    @Column(name = "ENABLED", columnDefinition = "CHAR(1)")
    @Type(type = "yes_no")
    public Boolean getEnabled() {
        return enabled;
    }
    
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Column(name = "WORK_STATUS", columnDefinition = "CHAR(1)")
    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

    @Column(name = "DATA_CENTRE_ID")
    public String getDataCentreId() {
        return dataCentreId;
    }

    public void setDataCentreId(String dataCentreId) {
        this.dataCentreId = dataCentreId;
    }
}
