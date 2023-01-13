package com.ird.portal.common.sys.service;

import com.ird.portal.common.sys.data.AuditIndexDTO;
import com.ird.portal.model.Page;


public interface AuditLogServiceApi {
    
    Page getAuditIndexPage(AuditIndexDTO auditIndexDTO);
    
}
