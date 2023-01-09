package com.ird.portal.sys.service.impl;

import com.ird.portal.common.sys.data.AuditIndexDTO;
import com.ird.portal.common.sys.service.AuditLogServiceApi;
import com.ird.portal.model.Page;
import com.ird.portal.sys.mapper.AuditMasterMapper;
import com.ird.portal.sys.service.AuditMasterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * 系統代碼日志接口的相關服務接口
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 03/05/2018 15:36:03<br/>
 * @author georgia
 * @version 1.0
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class AuditMasterServiceImpl implements AuditMasterService, AuditLogServiceApi {
	
    private Logger logger = LoggerFactory.getLogger(AuditMasterServiceImpl.class);
    
    @Autowired
    private AuditMasterMapper auditLogMasterMapper;

	@Override
	public Page getAuditIndexPage(AuditIndexDTO auditIndexDTO) {
	    logger.info("auditIndexDTO: {}", auditIndexDTO);
		return auditLogMasterMapper.getPage(auditIndexDTO);
	}

	
}
