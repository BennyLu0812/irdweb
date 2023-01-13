package com.ird.portal.sys.service;

import com.ird.portal.common.sys.data.AuditDetailDTO;
import com.ird.portal.model.Page;

public interface AuditDetailService {

	 Page getAuditDetailPage(AuditDetailDTO auditDetailDTO);
	
}
