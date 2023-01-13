package com.ird.portal.sys.service.impl;

import com.ird.portal.common.sys.data.SysProcessDTO;
import com.ird.portal.common.sys.data.SysServiceDTO;
import com.ird.portal.common.sys.data.SysServiceProcessDTO;
import com.ird.portal.sys.mapper.SysServiceMapper;
import com.ird.portal.sys.service.SysServiceService;
import com.ird.portal.util.DateUtil;
import com.ird.portal.util.SysParamsConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("sysServiceService")
public class SysServiceServiceImpl implements SysServiceService {

    private Logger logger = LoggerFactory.getLogger(SysServiceServiceImpl.class);

    @Autowired
    private SysServiceMapper sysServiceMapper;
    
    @Override
    public List<SysServiceDTO> getSysServiceList(SysServiceDTO queryDTO) {
        return sysServiceMapper.getSysServiceList(queryDTO);
    }
    
    @Override
    public List<SysProcessDTO> getSysProcessList(SysProcessDTO queryDTO) {
        return sysServiceMapper.getSysProcessList(queryDTO);
    }
    
    /**
     * 獲取系統時間.
     */
    @Override
    public String getSysDate() {
        return DateUtil.format(new Date(), DateUtil.DATE_PATTERN);
    }
    
    /**
     * 獲取系統時間.
     */
    @Override
    public String getSysDateTime() {
        return DateUtil.format(new Date(), DateUtil.DATE_TIME_PATTERN);
    }
    
//    @Cacheable(value = "getSysServiceByUserId", key = "'getSysServiceByUserId_USER_ID:'+#queryDTO.userId")
    @Override
    public List<SysServiceDTO> getSysServiceByUserId(SysServiceDTO queryDTO) {
        List<SysServiceDTO> sysServiceList = getSysServiceList(queryDTO);
        
        if (!isAuthByPass()) {
            try {
                sysServiceList = sysServiceMapper.getSysServiceByOperationCodes(queryDTO);

            }
            catch (Exception e) {
                logger.error("auth sysServiceList=" + e.getMessage(), e);
            }
        }
        return sysServiceList;
    }
    
//    @Cacheable(value = "getSysProcessByUserId", key = "'getSysProcessByUserId_USER_ID:'+#queryDTO.userId + '_' + #queryDTO.serviceId")
    @Override
    public List<SysProcessDTO> getSysProcessByUserId(SysProcessDTO queryDTO) {
        List<SysProcessDTO> sysProcessList = getSysProcessList(queryDTO);
        
        if (!isAuthByPass()) {
            try {
                sysProcessList = sysServiceMapper.getSysProcessByOperationCodes(queryDTO);
            }
            catch (Exception e) {
                logger.error("auth sysProcessList="+ e.getMessage(), e);
            } 
        }
        return sysProcessList;
    }


    @Override
    public SysServiceProcessDTO getSysServiceProcessByUserId(SysServiceDTO queryDTO){
        SysServiceProcessDTO dto = new SysServiceProcessDTO();
        //查詢USER全部的Service
        dto.setServiceList(getSysServiceByUserId(queryDTO));
        //查詢USER全部的process
        SysProcessDTO processQueryDTO = new SysProcessDTO();
        processQueryDTO.setUserId(queryDTO.getUserId());
        return dto;
    }

    /**
     * 是否繞過權限驗證
     * @return
     */
    private boolean isAuthByPass() {
        Integer authByPassValue = SysParamsConstant.getParamIntValue("SYS_AUTH_BYPASS");
        logger.info("authByPassValue: {}", authByPassValue);
        return authByPassValue != null && (authByPassValue == 1);
    }
    
}
