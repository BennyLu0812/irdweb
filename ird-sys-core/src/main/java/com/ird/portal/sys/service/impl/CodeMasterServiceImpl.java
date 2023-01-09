package com.ird.portal.sys.service.impl;

import com.ird.portal.common.sys.data.CodeMasterDTO;
import com.ird.portal.model.Page;
import com.ird.portal.sys.entity.CodeMasterEntity;
import com.ird.portal.sys.mapper.CodeMasterMapper;
import com.ird.portal.sys.service.CodeMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * 系統參數Master表對應的服務接口實現類
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 03/05/2018 15:32:56<br/>
 * @author Ada Yu
 * @version 1.0
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class CodeMasterServiceImpl implements CodeMasterService {
    
    @Autowired
    private CodeMasterMapper codeMasterMapper;

    @Override
    public CodeMasterEntity update(CodeMasterEntity codeMasterEntity) {
        return codeMasterMapper.update(codeMasterEntity);
    }

    @Override
    @Transactional(readOnly=true)
    public CodeMasterEntity getById(Integer codeMasterType) {
        return codeMasterMapper.getById(codeMasterType);
    }

    @Override
    @Transactional(readOnly=true)
    public Page getPage(CodeMasterDTO codeMasterDTO) {
        return codeMasterMapper.getPage(codeMasterDTO);
    }

    
}
