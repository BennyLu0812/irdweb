package com.ird.portal.audit.entity;

import com.ird.portal.audit.Action;
import com.ird.portal.audit.IAuditEntry;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "CLP_AUDIT_INDEX")
public class AuditIndexEntity implements IAuditEntry, Serializable {

    private static final long serialVersionUID = 20160721L;

    private Long id;
    private String rowId;
    private Action action;
    private String tableName;


    private Set<AuditDetailEntity> auditDetailEntities;
    private AuditMasterEntity auditMasterEntity;

    public AuditIndexEntity() {
    }

    public AuditIndexEntity(AuditMasterEntity auditMasterEntity) {
        this.auditMasterEntity = auditMasterEntity;
    }

    @Id
    @Column(name = "AUDIT_INDEX_ID", columnDefinition = "NUMBER(20, 0)")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "ROW_ID", columnDefinition = "VARCHAR2(20 CHAR)", nullable = false)
    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    @Column(name = "ACTION", columnDefinition = "CHAR(1 CHAR)", nullable = false)
    @Enumerated(EnumType.STRING)
    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    @Column(name = "TABLE_NAME", columnDefinition = "VARCHAR2(30 CHAR)", nullable = false)
    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = true)
    @JoinColumn(name = "AUDIT_MASTER_ID", nullable = false)
    public AuditMasterEntity getAuditMasterEntity() {
        return auditMasterEntity;
    }

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, mappedBy = "auditIndexEntity")
    public Set<AuditDetailEntity> getAuditDetailEntities() {
        return auditDetailEntities;
    }



    public void setAuditMasterEntity(AuditMasterEntity auditMasterEntity) {
        this.auditMasterEntity = auditMasterEntity;
    }

    public void setAuditDetailEntities(Set<AuditDetailEntity> auditDetailEntities) {
        this.auditDetailEntities = auditDetailEntities;
    }


}
