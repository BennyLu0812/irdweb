package com.ird.portal.sys.mapper;

import com.ird.portal.common.sys.data.CodeMasterDTO;
import com.ird.portal.dao.AbstractCommonDao;
import com.ird.portal.dao.AbstractMapper;
import com.ird.portal.datatable.DataTablePage;
import com.ird.portal.datatable.DatatableDaoCmd;
import com.ird.portal.model.Page;
import com.ird.portal.sys.dao.SysDao;
import com.ird.portal.sys.entity.CodeMasterEntity;
import com.ird.portal.util.BeanMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * TODO 請給CodeMasterMapper說明一下吧!
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 21/05/2018 15:44:41<br/>
 * @author James
 * @version 1.0
 */
@Repository
public class CodeMasterMapper extends AbstractMapper<CodeMasterEntity> {

    private static final  Logger LOG = LoggerFactory.getLogger(CodeMasterMapper.class);
    
    @Autowired
    private SysDao adminDao;

    @Autowired
    private BeanMapper beanMapper;
    
    public CodeMasterEntity getById(Integer codeMasterType) {
        LOG.debug("Entering query: (codeMasterType={})", codeMasterType);
        return (CodeMasterEntity)adminDao.getSingle(CodeMasterEntity.class, codeMasterType);
    }
    
    public Page getPage(CodeMasterDTO codeMasterDto) {
        if (StringUtils.isNotBlank(codeMasterDto.getCodeMasterCname())) {
            codeMasterDto.setCodeMasterCname("%" + codeMasterDto.getCodeMasterCname() + "%");
        }
        if (StringUtils.isNotBlank(codeMasterDto.getCodeMasterPname())) {
            codeMasterDto.setCodeMasterPname("%" + codeMasterDto.getCodeMasterPname().toLowerCase() + "%");
        }
        codeMasterDto.setLength(0);
        DatatableDaoCmd daoCmd = new DatatableDaoCmd("getCodeMaster", codeMasterDto);
        Long recordsTotal = adminDao.getCount(daoCmd);
        DataTablePage page = (DataTablePage)adminDao.getPage(daoCmd, CodeMasterEntity.class);
        page.setRecordsTotal(recordsTotal);
        return page;
    };
    
    public CodeMasterEntity update(CodeMasterEntity codeMasterEntity) {
        CodeMasterEntity newEntity = adminDao.getSingle(CodeMasterEntity.class, codeMasterEntity.getCodeMasterType());
        if (newEntity != null) {
            beanMapper.map(codeMasterEntity, newEntity);
            return (CodeMasterEntity)adminDao.update(newEntity);
        }
        return null;
    }
    
    @Override
    protected AbstractCommonDao getDao() {
        return null;
    }
    
}
