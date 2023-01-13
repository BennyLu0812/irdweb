package com.ird.portal.audit.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="AUDIT_ENQ")
public class AuditEnqEntity implements  Serializable {
    private static final long serialVersionUID = 20160721L;
    
    private Long auditEnqId;
    /**查詢類型 A-進階查詢;Q-綜合查詢**/
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
    

    @Id
    @Column(name="AUDIT_ENQ_ID",columnDefinition="NUMBER(20 CHAR)")
    @SequenceGenerator(name = "AUDIT_ENQ_SEQ", sequenceName = "AUDIT_ENQ_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "AUDIT_ENQ_SEQ")
    public Long getAuditEnqId() {
        return auditEnqId;
    }


    
    public void setAuditEnqId(Long auditEnqId) {
        this.auditEnqId = auditEnqId;
    }


    @Column(name="QUERY_TYPE",columnDefinition="CHAR(1 CHAR)")
    public String getQueryType() {
        return queryType;
    }

    
    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    @Column(name="Q_IDENT_TYPE",columnDefinition="VARCHAR2(6 CHAR)")
    public String getqInentType() {
        return qInentType;
    }

    
    public void setqInentType(String qInentType) {
        this.qInentType = qInentType;
    }

    @Column(name="Q_IDENT_NO",columnDefinition="VARCHAR2(50 CHAR)")
    public String getqInentNo() {
        return qInentNo;
    }

    
    public void setqInentNo(String qInentNo) {
        this.qInentNo = qInentNo;
    }

    @Column(name="Q_LIC_TYPE",columnDefinition="VARCHAR2(1 CHAR)")
    public String getqLicType() {
        return qLicType;
    }

    
    public void setqLicType(String qLicType) {
        this.qLicType = qLicType;
    }

    @Column(name="Q_LIC_NO",columnDefinition="VARCHAR2(30 CHAR)")
    public String getqLicNo() {
        return qLicNo;
    }

    
    public void setqLicNo(String qLicNo) {
        this.qLicNo = qLicNo;
    }

    @Column(name="Q_SP_NO",columnDefinition="VARCHAR2(20 CHAR)")
    public String getqSpNo() {
        return qSpNo;
    }

    
    public void setqSpNo(String qSpNo) {
        this.qSpNo = qSpNo;
    }

    @Column(name="R_HAS_RESULT",columnDefinition="CHAR(1 CHAR)")
    public String getrHasResult() {
        return rHasResult;
    }

    
    public void setrHasResult(String rHasResult) {
        this.rHasResult = rHasResult;
    }

    @Column(name="OPERATOR_ID",columnDefinition="VARCHAR2(20 CHAR)")
    public String getOperatorId() {
        return operatorId;
    }

    
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    @Column(name="OPERATION_TIME")
    public Date getOperationTime() {
        return operationTime;
    }

    
    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    @Column(name = "Q_IDENT_FULL_NAME_CN", columnDefinition = "VARCHAR2(200 CHAR)")
    public String getqIdentFullNameCn() {
        return qIdentFullNameCn;
    }

    public void setqIdentFullNameCn(String qIdentFullNameCn) {
        this.qIdentFullNameCn = qIdentFullNameCn;
    }
    @Column(name = "Q_IDENT_FULL_NAME_EN", columnDefinition = "VARCHAR2(200 CHAR)")
    public String getqIdentFullNameEn() {
        return qIdentFullNameEn;
    }

    public void setqIdentFullNameEn(String qIdentFullNameEn) {
        this.qIdentFullNameEn = qIdentFullNameEn;
    }

    @Column(name="Q_BIRTH_DATE")
    public Date getqBirthDate() {
        return qBirthDate;
    }

    public void setqBirthDate(Date qBirthDate) {
        this.qBirthDate = qBirthDate;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

 
}
