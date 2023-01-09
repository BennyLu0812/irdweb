package com.ird.portal.sys.service.impl;

import com.ird.portal.common.sys.data.SysParamDTO;
import com.ird.portal.common.sys.service.ParamsServiceApi;
import com.ird.portal.model.Page;
import com.ird.portal.sys.entity.ParamsEntity;
import com.ird.portal.sys.mapper.ParamsMapper;
import com.ird.portal.sys.service.ParamsService;
import com.ird.portal.util.SysParamsConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 系统参数管理.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 16/11/2017 10:17:00<br/>
 * 
 * @author Deft
 * @version 1.0
 */
@Service
@Transactional
public class ParamsServiceImpl implements ParamsService, ParamsServiceApi {
    
    @Autowired
    private ParamsMapper paramsMapper;
    
    @Override
    @Transactional(readOnly = true)
    public ParamsEntity getByName(String paramName) {
        return paramsMapper.getByName(paramName);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Page getPage(SysParamDTO dto) {
        return paramsMapper.getSysParam(dto);
    }
    
    @Override
    public ParamsEntity add(ParamsEntity entity) {
        return paramsMapper.add(entity);
    }
    
    @Override
    public ParamsEntity update(ParamsEntity entity) {
         ParamsEntity returnEntity = paramsMapper.update(entity);
         Map<String,String> map = SysParamsConstant.getParams();
         // 更新redis裏對應的value
         map.put(returnEntity.getParamName(),returnEntity.getParamValue());
         SysParamsConstant.setParam(map);
        return returnEntity;
    }

    @Override
    public void delete(String paramName) {
        paramsMapper.deleteByName(paramName);
        Map<String,String> map = SysParamsConstant.getParams();
        map.remove(paramName);
        SysParamsConstant.setParam(map);
    }

    @Override
    public SysParamDTO getParamByName(String paramName) {
        return paramsMapper.getDTOByName(paramName);
    }

    @Override
    public List<SysParamDTO> getAllParams() {
        return paramsMapper.getAllParams();
    }

    @Override
    public void reloadSysParams() {
        SysParamsConstant.remove();
        List<SysParamDTO> allParams = this.getAllParams();
        Map<String, String> params = new HashMap<String, String>();
        allParams.stream().forEach(e -> {
            params.put(e.getParamName(),e.getParamValue());
        });
        SysParamsConstant.setParam(params);
    }

}
