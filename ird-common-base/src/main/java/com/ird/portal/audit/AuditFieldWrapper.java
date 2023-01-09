package com.ird.portal.audit;

import java.io.Serializable;
import java.util.List;

public class AuditFieldWrapper implements Serializable {

    private static final long serialVersionUID = -7736484343590186705L;
    
    private List<AuditField> auditFields;

    public AuditFieldWrapper() {
    }

    public AuditFieldWrapper(List<AuditField> auditFields) {
        this.auditFields = auditFields;
    }

    public List<AuditField> getAuditFields() {
        return auditFields;
    }

    public void setAuditFields(List<AuditField> auditFields) {
        this.auditFields = auditFields;
    }
}
