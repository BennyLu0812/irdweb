/**
 * @Project Name: dsat-sch-api
 * @File Name: JobCtrlDTO.java
 * @Date: 18/04/20166:14:14 PM
 * @Copyright: Copyright (c) 2016 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.sch.data;

import com.ird.portal.data.BaseDTO;

/**
 * Title: <br/>
 * Description: <br/>
 * Date: 18/04/2016 6:14:14 PM<br/>
 *
 * @author Jim
 * @version 1.0
 * @since JDK1.8
 */
public class SchCtrlDTO extends BaseDTO {
    private static final long serialVersionUID = 1651213111759312485L;

    /**
     * JOB_TYPE.Job類型： TRIGGER
     */
    public static final String JOB_TYPE_TRIGGER = "TRIGGER";
    /**
     * JOB_TYPE.Job類型： JAVA
     */    
    public static final String JOB_TYPE_JAVA = "JAVA";
    /**
     * JOB_TYPE.Job類型： PLSQL
     */
    public static final String JOB_TYPE_PLSQL = "PLSQL";
    /**
     * JOB_TYPE.Job類型： JAVA_NOLOG
     * NOLOG mean no audit log, but schedule/job job still exists
     */
    public static final String JOB_TYPE_JAVA_NOLOG = "JAVA_NOLOG";

    /** JOB_CTRL (sequence no) */
    private Long id;
    /** 模組名 */
    private String sysCode;
    /** Cron用途 */
    private String jobUse;
    /** Cron代碼 也作Job Name */
    private String jobCode;
    /** Job Group */
    private String jobGroup;
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
    /** 任務的狀態 */
    private String workStatus;
    /** Job類型：JAVA PLSQL */
    private String jobType;
    /** 導出最近幾天的更新數據 */
    private Integer dataDays;
    /** 是否啓用JOB */
    private Boolean enabled;
    /**
     * API 入參dataCentreId
     * */
    private String dataCentreId;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    public String getJobUse() {
        return jobUse;
    }

    public void setJobUse(String jobUse) {
        this.jobUse = jobUse;
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getCronChar() {
        return cronChar;
    }

    public void setCronChar(String cronChar) {
        this.cronChar = cronChar;
    }

    public Integer getCronNum() {
        return cronNum;
    }

    public void setCronNum(Integer cronNum) {
        this.cronNum = cronNum;
    }

    public String getCronDate() {
        return cronDate;
    }

    public void setCronDate(String cronDate) {
        this.cronDate = cronDate;
    }

    public String getClsName() {
        return clsName;
    }

    public void setClsName(String clsName) {
        this.clsName = clsName;
    }

    public String getDataDir() {
        return dataDir;
    }

    public void setDataDir(String dataDir) {
        this.dataDir = dataDir;
    }

    public Boolean getIsSync() {
        if (isSync == null) {
            isSync = Boolean.FALSE;
        }
        return isSync;
    }

    public void setIsSync(Boolean isSync) {
        this.isSync = isSync;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public Integer getDataDays() {
        return dataDays;
    }

    public void setDataDays(Integer dataDays) {
        this.dataDays = dataDays;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getDataCentreId() {
        return dataCentreId;
    }

    public void setDataCentreId(String dataCentreId) {
        this.dataCentreId = dataCentreId;
    }
}
