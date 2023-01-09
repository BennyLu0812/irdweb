package com.ird.portal.audit;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Author: Gavin
 * Date: Jul 27, 2016 9:00:11 AM
 * Version: 1.0
 */
public class AuditField implements Serializable {

    private static final long serialVersionUID = 20160727L;

    private String propertyName;
    private String columnName;
    private String valueBefore;
    private String valueAfter;

    // 是否為AuditGroupBy標記 
    private boolean auditGroupBy = false;

    public AuditField() {
    }

    public AuditField(String propertyName, String columnName,
                      String valueBefore, String valueAfter, boolean auditGroupBy) {
        this.propertyName = propertyName;
        this.columnName = columnName;
        this.valueBefore = valueBefore;
        this.valueAfter = valueAfter;
        this.auditGroupBy = auditGroupBy;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    /**
     * 是否為AuditGroupBy標記 .
     * @return
     */
    public boolean isAuditGroupBy() {
        return auditGroupBy;
    }

    /**
     * 是否為AuditGroupBy標記 .
     * @param auditGroupBy the auditGroupBy to set
     */
    public void setAuditGroupBy(boolean auditGroupBy) {
        this.auditGroupBy = auditGroupBy;
    }
    
    
}
