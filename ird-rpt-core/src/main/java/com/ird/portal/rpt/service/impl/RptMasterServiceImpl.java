package com.ird.portal.rpt.service.impl;

import com.ird.portal.common.rpt.data.RptMasterDTO;
import com.ird.portal.model.Page;
import com.ird.portal.rpt.entity.RptMasterEntity;
import com.ird.portal.rpt.mapper.RptMasterMapper;
import com.ird.portal.rpt.service.RptMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RptMasterServiceImpl implements RptMasterService {
    @Autowired
    RptMasterMapper rptMasterMapper;
    
    
    @Override
    public Page getPage(RptMasterDTO dto) {
        return rptMasterMapper.getPage(dto);
    }
    
    @Override
    public RptMasterEntity getById(String id) {
        return rptMasterMapper.getById(id);
    }
    
}
