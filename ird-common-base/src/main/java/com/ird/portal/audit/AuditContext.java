package com.ird.portal.audit;

/**
 * 將用戶請求信息綁定到當前線程
 * <p>
 * Author: Gavin Date: Jul 19, 2016 12:00:11 PM Version: 1.0
 */
public class AuditContext implements IAuditContext {

    public static final String SYSTEM_DEFAULT_USER = "system";

    private static final ThreadLocal<AuditContext> MAP = new ThreadLocal<AuditContext>();

    private AuditContext() {
    }

    public static AuditContext getInstance() {
        AuditContext context = MAP.get();
        if (context == null) {
            context = new AuditContext();
            MAP.set(context);
        }
        return context;
    }

    public void set(AuditContext context) {
        MAP.set(context);
    }

    public void remove() {
        MAP.remove();
    }

    private Long logId;

    private String userId;



    private String funcCode;

    private String hostIP;

    private String hostName;

    private String requestURL;

    private String remark;

    private boolean isAudited = false;

    // 是否為AuditGroupBy標記
    private boolean auditGroupBy = false;

    private String spNo;

    private Long docId;
    private Integer docSeq;
    private Long examYear;
    private Long examNo;

    /** 警示序號 */
    private Long altSeq;
    /** 警示年份 */
    private Long altYear;


    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getFuncCode() {
        return funcCode;
    }

    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode;
    }

    public String getHostIP() {
        return hostIP;
    }

    public void setHostIP(String hostIP) {
        this.hostIP = hostIP;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getRequestURL() {
        return requestURL;
    }

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public boolean isAudited() {
        return isAudited;
    }

    public void setIsAudited(boolean isAudited) {
        this.isAudited = isAudited;
    }

    /**
     * 是否為AuditGroupBy標記.
     *
     * @return the auditGroupBy
     */
    public boolean isAuditGroupBy() {
        return auditGroupBy;
    }

    /**
     * 是否為AuditGroupBy標記.
     *
     * @param auditGroupBy the auditGroupBy to set
     */
    public void setAuditGroupBy(boolean auditGroupBy) {
        this.auditGroupBy = auditGroupBy;
    }

    @Override
    public String getSpNo() {
        return spNo;
    }

    public void setSpNo(String spNo) {
        this.spNo = spNo;
    }

    @Override
    public Long getDocId() {
        return docId;
    }

    @Override
    public Integer getDocSeq() {
        return this.docSeq;
    }

    public void setDocSeq(Integer docSeq) {
        this.docSeq = docSeq;
    }

    public void setDocId(Long docId) {
        this.docId = docId;
    }
    public Long getAltSeq() {
        return this.altSeq;
    }

    public void setAltSeq(Long altSeq) {
        this.altSeq = altSeq;
    }

    public Long getAltYear() {
        return this.altYear;
    }

    public void setAltYear(Long altYear) {
        this.altYear = altYear;
    }


    public Long getExamYear() {
        return this.examYear;
    }

    public void setExamYear(Long examYear) {
        this.examYear = examYear;
    }

    public Long getExamNo() {
        return this.examNo;
    }

    public void setExamNo(Long examNo) {
        this.examNo = examNo;
    }


    @Override
    public String toString() {
        return "AuditContext{" +
                "logId=" + logId +
                ", userId='" + userId + '\'' +
                ", funcCode='" + funcCode + '\'' +
                ", hostIP='" + hostIP + '\'' +
                ", hostName='" + hostName + '\'' +
                ", requestURL='" + requestURL + '\'' +
                ", remark='" + remark + '\'' +
                ", isAudited=" + isAudited +
                ", auditGroupBy=" + auditGroupBy +
                ", spNo='" + spNo + '\'' +
                ", docId=" + docId +
                '}';
    }
}
