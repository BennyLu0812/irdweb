package com.ird.portal.sys.service;

import com.ird.portal.common.sys.data.AuditEnqDTO;

public interface AuditEnqService {
    /**
     * 插入查询日志
     * @param auditEnqDto
     */
    void add(AuditEnqDTO auditEnqEntity);

    
}
