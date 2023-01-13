package com.ird.portal.sys.mapper;

import com.ird.portal.audit.entity.AuditMasterEntity;
import com.ird.portal.common.sys.data.AuditIndexDTO;
import com.ird.portal.common.sys.data.AuditMasterDTO;
import com.ird.portal.dao.AbstractCommonDao;
import com.ird.portal.dao.AbstractMapper;
import com.ird.portal.datatable.DataTablePage;
import com.ird.portal.datatable.DatatableDaoCmd;
import com.ird.portal.model.Page;
import com.ird.portal.sys.dao.SysDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * TODO 請給CodeMapper說明一下吧!
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 21/05/2018 14:34:51<br/>
 * @author James
 * @version 1.0
 */
@Repository
public class AuditMasterMapper extends AbstractMapper<AuditMasterEntity> {
	
	@Autowired
	private SysDao dao;
	
    /**
     * 分頁.
     * @param auditIndexDTO dto對象
     * @return page對象
     * */
//    public Page getPage(AuditMasterDTO auditMasterDTO ) {
//        DatatableDaoCmd daoCmd = new DatatableDaoCmd("getAuditLogMaster", auditMasterDTO);
//        DataTablePage page = (DataTablePage) dao.getPage(daoCmd, AuditMasterDTO.class, true);
//        return page;
//    }
    
    public Page getPage(AuditIndexDTO auditIndexDTO) {
        DatatableDaoCmd daoCmd = new DatatableDaoCmd("getAuditIndexList", auditIndexDTO);
        DataTablePage page = (DataTablePage) dao.getPage(daoCmd, AuditMasterDTO.class, true);
        return page;
    }
    
    
	@Override
	protected AbstractCommonDao getDao() {
		return dao;
	}
}
