package com.ird.portal.common.sys.data;

import com.ird.portal.data.BaseDTO;

import java.util.Date;


public class AuditEnqDTO extends BaseDTO {
    
    private static final long serialVersionUID = 3842038790413870440L;

    private Long auditEnqId;
    private String queryType;
    private String qInentType;
    private String qInentNo;
    private String qLicType;
    private String qLicNo;
    private String qSpNo;
    private String qIdentFullNameCn;
    private String qIdentFullNameEn;
    private Date qBirthDate;
    private String rHasResult;
    private String operatorId;
    private Date operationTime;
    
    public Long getAuditEnqId() {
        return auditEnqId;
    }
    
    public void setAuditEnqId(Long auditEnqId) {
        this.auditEnqId = auditEnqId;
    }
    
    public String getQueryType() {
        return queryType;
    }
    
    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }
    
    public String getqInentType() {
        return qInentType;
    }
    
    public void setqInentType(String qInentType) {
        this.qInentType = qInentType;
    }
    
    public String getqInentNo() {
        return qInentNo;
    }
    
    public void setqInentNo(String qInentNo) {
        this.qInentNo = qInentNo;
    }
    
    public String getqLicType() {
        return qLicType;
    }
    
    public void setqLicType(String qLicType) {
        this.qLicType = qLicType;
    }
    
    public String getqLicNo() {
        return qLicNo;
    }
    
    public void setqLicNo(String qLicNo) {
        this.qLicNo = qLicNo;
    }
    
    public String getqSpNo() {
        return qSpNo;
    }
    
    public void setqSpNo(String qSpNo) {
        this.qSpNo = qSpNo;
    }
    
    public String getrHasResult() {
        return rHasResult;
    }
    
    public void setrHasResult(String rHasResult) {
        this.rHasResult = rHasResult;
    }
    
    public String getOperatorId() {
        return operatorId;
    }
    
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }
    
    public Date getOperationTime() {
        return operationTime;
    }
    
    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getqIdentFullNameCn() {
        return qIdentFullNameCn;
    }

    public void setqIdentFullNameCn(String qIdentFullNameCn) {
        this.qIdentFullNameCn = qIdentFullNameCn;
    }

    public String getqIdentFullNameEn() {
        return qIdentFullNameEn;
    }

    public void setqIdentFullNameEn(String qIdentFullNameEn) {
        this.qIdentFullNameEn = qIdentFullNameEn;
    }

    public Date getqBirthDate() {
        return qBirthDate;
    }

    public void setqBirthDate(Date qBirthDate) {
        this.qBirthDate = qBirthDate;
    }
}
