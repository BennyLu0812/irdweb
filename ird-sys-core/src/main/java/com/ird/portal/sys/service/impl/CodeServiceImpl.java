package com.ird.portal.sys.service.impl;

import com.ird.portal.common.sys.data.CodeDTO;
import com.ird.portal.common.sys.service.SysCodeServiceApi;
import com.ird.portal.model.Page;
import com.ird.portal.sys.entity.CodeEntity;
import com.ird.portal.sys.mapper.CodeMapper;
import com.ird.portal.sys.service.CodeService;
import com.ird.portal.util.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 
 * 系統代碼管理.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 16/11/2017 10:16:21<br/>
 * 
 * @author Deft
 * @version 1.0
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class CodeServiceImpl implements CodeService, SysCodeServiceApi {
    
    @Autowired
    private CodeMapper codeMapper;
    
    @Autowired
    private BeanMapper beanMapper;
    
    @Override
    public CodeEntity add(CodeEntity codeEntity) {
        return codeMapper.add(codeEntity);
    }
    
    @Override
    public CodeEntity update(CodeEntity codeEntity) {
        return codeMapper.update(codeEntity);
    }
    
    @Override
    @Transactional(readOnly=true)
    public CodeEntity getById(Integer id) {
        return codeMapper.getById(id);
    }
    
    @Override
    @Transactional(readOnly=true)
    public Page getPage(CodeDTO codeDto) {
        return codeMapper.getPage(codeDto);
    }

    @Override
    public CodeDTO UpdateCodesStatus(Integer codeId, String originalStatus, String updateStatus) {
        return (CodeDTO)codeMapper.process(codeId, originalStatus, updateStatus);
    }

    @Override
    public void CodeTypeOnlyProcess(CodeEntity codeEntity) {
        codeMapper.typeOnly(codeEntity);
    }

    @Override
    public CodeDTO getCodeByTypeAndCode(Integer codeType, String codeKey) {
        return codeMapper.getCodeByTypeAndKey(codeType, codeKey);
    }

    @Override
    @Deprecated
    public List<CodeDTO> listVssSysCodeByCodeType(Integer codeType) {
        return codeMapper.listVssSysCodeByCodeType(codeType);
    }

    @Override
    public Map<Integer, List<CodeDTO>> batchGetSysCodeMapByCodeTypes(List<Integer> codeTypes) {
        return codeMapper.batchGetSysCodeByCodeTypes(codeTypes).stream().collect(Collectors.groupingBy(CodeDTO::getCodeType));
    }

    @Override
    public List<CodeEntity> getListByCodeType(Integer codeType) {
        return codeMapper.getListByCodeType(codeType);
    }

    @Override
    public Map<String, CodeDTO> getCodesInMap(Integer codeType) {
        Map<String, CodeDTO> map = new HashMap<String, CodeDTO>();
        List<CodeEntity> list = codeMapper.getListByCodeType(codeType);
        for(CodeEntity code : list) {
            map.put(code.getCodeKey(), beanMapper.map(code, CodeDTO.class));
        }
        return map;
    }
    
}
