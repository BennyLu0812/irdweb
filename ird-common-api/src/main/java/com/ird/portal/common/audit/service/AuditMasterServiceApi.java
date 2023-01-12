package com.ird.portal.common.audit.service;

import com.ird.portal.common.sys.data.LoginAuditDTO;

public interface AuditMasterServiceApi {

    LoginAuditDTO saveLoginAudit(LoginAuditDTO dto);
}
