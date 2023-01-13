package com.ird.portal.audit.entity;

import com.ird.portal.audit.IAuditContext;
import com.ird.portal.audit.annotation.Audited;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Audited
@Entity
@Table(name = "CLP_AUDIT_MASTER")
public class AuditMasterEntity implements IAuditContext, Serializable {

    private static final long serialVersionUID = 20160717L;

    private Long id;
    private String funcCode;
    private String operatorId;
    private Date operationTime;

    private String hostIP;
    private String hostName;
    private String remark;

    private Set<AuditIndexEntity> auditIndexEntities;

    public AuditMasterEntity() {
    }

    public AuditMasterEntity(String funcCode, String operatorId, Date operationTime, String hostIP, String hostName, String remark) {
        this.funcCode = funcCode;
        this.operatorId = operatorId;
        this.operationTime = operationTime;
        this.hostIP = hostIP;
        this.hostName = hostName;
        this.remark = remark;
    }

    @Id
    @Column(name = "AUDIT_MASTER_ID", columnDefinition = "NUMBER(20, 0)")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "FUNC_CODE", columnDefinition = "VARCHAR2(24 CHAR)", nullable = false)
    public String getFuncCode() {
        return funcCode;
    }

    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode;
    }

    @Column(name = "OPERATOR_ID", columnDefinition = "VARCHAR2(20 CHAR)", nullable = false)
    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    @Column(name = "OPERATION_TIME", nullable = false)
    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }


    @Column(name = "HOST_IP", columnDefinition = "VARCHAR2(20 CHAR)")
    public String getHostIP() {
        return hostIP;
    }

    public void setHostIP(String hostIP) {
        this.hostIP = hostIP;
    }

    @Column(name = "HOST_NAME", columnDefinition = "VARCHAR2(20 CHAR)")
    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    @Column(name = "REMARK", columnDefinition = "VARCHAR2(200 CHAR)")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, mappedBy = "auditMasterEntity")
    public Set<AuditIndexEntity> getAuditIndexEntities() {
        return auditIndexEntities;
    }

    public void setAuditIndexEntities(Set<AuditIndexEntity> auditIndexEntities) {
        this.auditIndexEntities = auditIndexEntities;
    }


    @Override
    @Transient
    public String getSpNo() {
        return null;
    }

    @Override
    @Transient
    public Long getDocId() {
        return null;
    }

    @Override
    @Transient
    public Integer getDocSeq() {
        return null;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("remark", remark)
                .append("id", id)
                .append("funcCode", funcCode)
                .append("operatorId", operatorId)
                .append("operationTime", operationTime)
                .append("hostIP", hostIP)
                .append("hostName", hostName)
                .toString();
    }
}
