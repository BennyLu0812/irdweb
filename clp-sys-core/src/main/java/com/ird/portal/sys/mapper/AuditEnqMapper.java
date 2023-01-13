package com.ird.portal.sys.mapper;

import com.ird.portal.audit.entity.AuditEnqEntity;
import com.ird.portal.dao.AbstractCommonDao;
import com.ird.portal.dao.AbstractMapper;
import com.ird.portal.sys.dao.SysDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 * 
 * TODO 請給AuditEnqMapper說明一下吧!
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 29/06/2018 16:56:39<br/>
 * @author Jason
 * @version 1.0
 */
@Repository
public class AuditEnqMapper extends AbstractMapper<AuditEnqEntity> {
    
    @Autowired
    private SysDao dao;
    

    @Override
    protected AbstractCommonDao getDao() {
        return dao;
    }

  
    
}
