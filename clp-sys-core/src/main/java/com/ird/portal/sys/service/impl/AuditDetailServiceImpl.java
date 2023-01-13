package com.ird.portal.sys.service.impl;

import com.ird.portal.common.sys.data.AuditDetailDTO;
import com.ird.portal.model.Page;
import com.ird.portal.sys.mapper.AuditDetailMapper;
import com.ird.portal.sys.service.AuditDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuditDetailServiceImpl implements AuditDetailService {

	@Autowired
	private AuditDetailMapper auditDetailMapper;

	@Override
	public Page getAuditDetailPage(AuditDetailDTO auditDetailDTO) {

		return auditDetailMapper.getAuditDetails(auditDetailDTO);
	}

}
