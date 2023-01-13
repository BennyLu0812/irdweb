package com.ird.portal.common.sys.data;


import com.ird.portal.common.user.enums.AuditIndexActionlEnum;
import com.ird.portal.data.BaseDTO;

public class AuditDetailDTO extends BaseDTO {
    
    /**
     * 序列號
     */
    private static final long serialVersionUID = 5937893694296164666L;
    
    private Long auditIndexId;

    private Long auditMasterId;

    private String action;
    
    private String actionDesc;
    
    private String tableName;

    private String rowId;
    
    private Long coachId;
    
    private String columnName;
    
    private String columnCname;
    
    private String columnPname;
    
    private String valueBefore;
    
    private String valueAfter;
    
    public Long getAuditIndexId() {
        return auditIndexId;
    }
    
    public void setAuditIndexId(Long auditIndexId) {
        this.auditIndexId = auditIndexId;
    }
    
    public String getAction() {
        return action;
    }
    
    public void setAction(String action) {
        this.action = action;
        this.actionDesc = AuditIndexActionlEnum.getTextByCode(action, null);
    }
    
    public String getActionDesc() {
        return actionDesc;
    }
    
    public void setActionDesc(String actionDesc) {
        this.actionDesc = actionDesc;
    }
    
    public String getTableName() {
        return tableName;
    }
    
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
    
    public String getRowId() {
        return rowId;
    }
    
    public void setRowId(String rowId) {
        this.rowId = rowId;
    }
    
    public Long getCoachId() {
        return coachId;
    }
    
    public void setCoachId(Long coachId) {
        this.coachId = coachId;
    }

    public String getColumnName() {
        return columnName;
    }
    
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
    
    public String getColumnCname() {
        return columnCname;
    }
    
    public void setColumnCname(String columnCname) {
        this.columnCname = columnCname;
    }
    
    public String getColumnPname() {
        return columnPname;
    }
    
    public void setColumnPname(String columnPname) {
        this.columnPname = columnPname;
    }
    
    public String getValueBefore() {
        return valueBefore;
    }
    
    public void setValueBefore(String valueBefore) {
        this.valueBefore = valueBefore;
    }
    
    public String getValueAfter() {
        return valueAfter;
    }
    
    public void setValueAfter(String valueAfter) {
        this.valueAfter = valueAfter;
    }

    public Long getAuditMasterId() {
        return auditMasterId;
    }

    public void setAuditMasterId(Long auditMasterId) {
        this.auditMasterId = auditMasterId;
    }
}
