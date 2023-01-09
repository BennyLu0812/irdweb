package com.ird.portal.sys.mapper;

import com.ird.portal.audit.entity.AuditDetailEntity;
import com.ird.portal.common.sys.data.AuditDetailDTO;
import com.ird.portal.dao.AbstractCommonDao;
import com.ird.portal.dao.AbstractMapper;
import com.ird.portal.datatable.DataTablePage;
import com.ird.portal.datatable.DatatableDaoCmd;
import com.ird.portal.model.Page;
import com.ird.portal.sys.dao.SysDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AuditDetailMapper extends AbstractMapper<AuditDetailEntity> {

	@Autowired
	private SysDao dao;

	public Page getAuditDetails(AuditDetailDTO auditDetailDTO) {
		DatatableDaoCmd daoCmd = new DatatableDaoCmd("getAuditDetailByMasterId", auditDetailDTO);
		DataTablePage page = (DataTablePage) dao.getPage(daoCmd, AuditDetailDTO.class, true);
		return page;
	}

	@Override
	protected AbstractCommonDao getDao() {
		return dao;
	}

}
