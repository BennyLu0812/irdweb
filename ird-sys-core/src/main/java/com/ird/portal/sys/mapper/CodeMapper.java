package com.ird.portal.sys.mapper;

import com.ird.portal.common.sys.data.CodeDTO;
import com.ird.portal.common.sys.enums.SysCodeStatus;
import com.ird.portal.dao.AbstractCommonDao;
import com.ird.portal.dao.AbstractMapper;
import com.ird.portal.data.ParamDTO;
import com.ird.portal.datatable.DataTablePage;
import com.ird.portal.datatable.DatatableDaoCmd;
import com.ird.portal.exception.CodeTypeNotUniqueException;
import com.ird.portal.exception.RecordNotFoundException;
import com.ird.portal.exception.StatusValidationException;
import com.ird.portal.model.Page;
import com.ird.portal.sys.dao.SysDao;
import com.ird.portal.sys.dao.SysDaoCmd;
import com.ird.portal.sys.entity.CodeEntity;
import com.ird.portal.util.BeanMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class CodeMapper extends AbstractMapper<CodeEntity> {
    
    private static final  Logger LOG = LoggerFactory.getLogger(CodeMapper.class);
    
    @Autowired
    private SysDao adminDao;

    @Autowired
    private BeanMapper beanMapper;
    
    public CodeEntity add(CodeEntity codeEntity) {
        LOG.debug("Entering add: ({})", codeEntity);
        codeEntity.setCodeStatus(SysCodeStatus.ACTIVE.getCode());
        return (CodeEntity)adminDao.insert(codeEntity);
    }
    
    public CodeEntity getById(Integer id) {
        return (CodeEntity)adminDao.getSingle(CodeEntity.class, id);
    }
    
    public Page getPage(CodeDTO codeDto) {
        if(StringUtils.isNotBlank(codeDto.getCodeCname())) {
            codeDto.setCodeCname("%"+codeDto.getCodeCname()+"%");
        }
        if(StringUtils.isNotBlank(codeDto.getCodePname())) {
            codeDto.setCodePname("%"+codeDto.getCodePname().toLowerCase()+"%");
        }
        if(StringUtils.isNotBlank(codeDto.getCodePrintCname())) {
            codeDto.setCodePrintCname("%"+codeDto.getCodePrintCname().toLowerCase()+"%");
        }
        if(StringUtils.isNotBlank(codeDto.getCodePrintPname())) {
            codeDto.setCodePrintPname("%"+codeDto.getCodePrintPname().toLowerCase()+"%");
        }
        DatatableDaoCmd daoCmd = new DatatableDaoCmd("getCode", codeDto);
        Long recordsTotal = adminDao.getCount(daoCmd);
        DataTablePage page = (DataTablePage)adminDao.getPage(daoCmd, CodeEntity.class);
        page.setRecordsTotal(recordsTotal);
        return page;
    };
    
    public void typeOnly(CodeEntity codeEntity) {
        ParamDTO paramDTO = new ParamDTO();
        paramDTO.put("codeId", codeEntity.getCodeId());
        paramDTO.put("codeType", codeEntity.getCodeType());
        paramDTO.put("codeKey", codeEntity.getCodeKey());
        SysDaoCmd sysDaoCmd = new SysDaoCmd("getCodeByTypeAndKey", paramDTO);
        CodeEntity oldCodeEntity = (CodeEntity)adminDao.getSingle(sysDaoCmd, CodeEntity.class);
        if (oldCodeEntity != null) {
            throw new CodeTypeNotUniqueException("F-0017");
        }
    }
    
    public CodeEntity update(CodeEntity codeEntity) {
        CodeEntity newEntity = adminDao.getSingle(CodeEntity.class, codeEntity.getCodeId());
        if (newEntity != null) {
            beanMapper.map(codeEntity, newEntity);
            return (CodeEntity)adminDao.update(newEntity);
        }
        return null;
    }
    
    public CodeDTO process(Integer codeId, String originalStatus, String updateStatus) throws StatusValidationException {
        CodeEntity oldEntity = adminDao.getSingle(CodeEntity.class, codeId);
        if(oldEntity==null){
            throw new RecordNotFoundException(codeId);
        }
        
        if(!originalStatus.equals(oldEntity.getCodeStatus())){
            throw new StatusValidationException("F-0016");
        }else{
            oldEntity.setCodeStatus(updateStatus);
            adminDao.update(oldEntity);
        }         
        
        return (CodeDTO)beanMapper.map(oldEntity, CodeDTO.class);
    }
    
    public CodeDTO getCodeByTypeAndKey(Integer codeType, String codeKey) {
    	ParamDTO paramDTO = new ParamDTO();
        paramDTO.put("codeType", codeType);
        paramDTO.put("codeKey", codeKey);

        CodeEntity entity = adminDao.getSingle(new SysDaoCmd("getCodeByTypeAndKey" , paramDTO), CodeEntity.class);
        if(entity == null)
        	return null;
        
        return (CodeDTO)beanMapper.map(entity, CodeDTO.class);
    }
    
    public List<CodeEntity> getListByCodeType(Integer codeType){
        ParamDTO paramDTO = new ParamDTO();
        paramDTO.put("codeType", codeType);
        paramDTO.put("codeStatus", SysCodeStatus.ACTIVE.getCode());

        SysDaoCmd cmd = new SysDaoCmd("getCode", paramDTO);
        List<CodeEntity> list = adminDao.getList(cmd, CodeEntity.class);
        LOG.debug("code list : {}", list==null?"null":list.size());
        return list;
    }

    @Deprecated
    public List<CodeDTO> listVssSysCodeByCodeType(Integer codeType) {
        Map<String, Object> params = new HashMap<>(1);
        params.put("codeType", codeType);
        SysDaoCmd cmd = new SysDaoCmd("listVssSysCodeByCodeType", params);
        return adminDao.getList(cmd, CodeDTO.class, true);
    }

    public List<CodeDTO> batchGetSysCodeByCodeTypes(List<Integer> codeTypes) {
        Map<String, Object> params = new HashMap<>(1);
        params.put("codeTypes", codeTypes);
        return adminDao.getList(new SysDaoCmd("batchGetSysCodeByCodeTypes", params), CodeDTO.class, true);
    }
    
    @Override
    protected AbstractCommonDao getDao() {
        return adminDao;
    }

    
}
