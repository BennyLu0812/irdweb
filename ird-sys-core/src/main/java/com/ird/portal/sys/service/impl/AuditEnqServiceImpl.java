package com.ird.portal.sys.service.impl;


import com.ird.portal.audit.entity.AuditEnqEntity;
import com.ird.portal.common.sys.data.AuditEnqDTO;
import com.ird.portal.sys.mapper.AuditEnqMapper;
import com.ird.portal.sys.service.AuditEnqService;
import com.ird.portal.util.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuditEnqServiceImpl implements AuditEnqService {
    
    @Autowired
    private AuditEnqMapper auditEnqMapper;
    
    @Autowired
    private BeanMapper beanMapper;
    
    @Override
    public void add(AuditEnqDTO auditEnqDTO) {
        AuditEnqEntity enqEntity = beanMapper.map(auditEnqDTO, AuditEnqEntity.class);
        auditEnqMapper.insert(enqEntity);
    }
    
}
