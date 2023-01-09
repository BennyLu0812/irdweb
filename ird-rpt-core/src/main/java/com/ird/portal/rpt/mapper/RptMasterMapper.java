package com.ird.portal.rpt.mapper;

import com.ird.portal.common.rpt.data.RptMasterDTO;
import com.ird.portal.dao.AbstractCommonDao;
import com.ird.portal.dao.AbstractMapper;
import com.ird.portal.datatable.DataTablePage;
import com.ird.portal.datatable.DatatableDaoCmd;
import com.ird.portal.model.Page;
import com.ird.portal.rpt.dao.RptDao;
import com.ird.portal.rpt.entity.RptMasterEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * RptMaster對應Mapper
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 23/06/2018 17:45:18<br/>
 * @author: Crystal Zhao
 * @version 1.0
 */
@Repository
public class RptMasterMapper extends AbstractMapper<RptMasterEntity> {
    @Autowired
    private RptDao dao;
    private static final Logger LOG = LoggerFactory.getLogger(RptMasterMapper.class);
    
    public RptMasterEntity getById(String id) {
        return dao.getSingle(RptMasterEntity.class, id);
    }
    
    @Override
    protected AbstractCommonDao getDao() {
        return dao;
    }

    public Page getPage(RptMasterDTO dto) {
        LOG.debug("分頁查詢報表記錄參數： {}", dto.toString());
        DatatableDaoCmd daoCmd = new DatatableDaoCmd("getRptMasterPage", dto);
        DataTablePage page = (DataTablePage)dao.getPage(daoCmd, RptMasterDTO.class, true);
        return page;
    }

    
    
}
