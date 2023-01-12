package com.ird.portal.sys.service.impl;

import com.ird.portal.audit.entity.AuditMasterEntity;
import com.ird.portal.common.audit.service.AuditMasterServiceApi;
import com.ird.portal.common.sys.data.AuditIndexDTO;
import com.ird.portal.common.sys.data.LoginAuditDTO;
import com.ird.portal.common.sys.service.AuditLogServiceApi;
import com.ird.portal.model.Page;
import com.ird.portal.sys.mapper.AuditMasterMapper;
import com.ird.portal.sys.service.AuditMasterService;
import com.ird.portal.util.BeanMapper;
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
public class AuditMasterServiceImpl implements AuditMasterService, AuditLogServiceApi, AuditMasterServiceApi {
	
    private Logger logger = LoggerFactory.getLogger(AuditMasterServiceImpl.class);
    
    @Autowired
    private AuditMasterMapper auditLogMasterMapper;

	@Autowired
	private BeanMapper beanMapper;

	@Override
	public Page getAuditIndexPage(AuditIndexDTO auditIndexDTO) {
	    logger.info("auditIndexDTO: {}", auditIndexDTO);
		return auditLogMasterMapper.getPage(auditIndexDTO);
	}


	@Override
	public LoginAuditDTO saveLoginAudit(LoginAuditDTO dto) {
		logger.info("save Login Audit 。AuditMasterDTO:{}", beanMapper.mapTo(dto, AuditMasterEntity.class).toString());
		AuditMasterEntity entity = beanMapper.mapTo(dto, AuditMasterEntity.class);
		entity = (AuditMasterEntity) auditLogMasterMapper.insert(entity);
		return  beanMapper.mapTo(entity, LoginAuditDTO.class);
	}
}
