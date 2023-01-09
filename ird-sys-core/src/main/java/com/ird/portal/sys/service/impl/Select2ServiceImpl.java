package com.ird.portal.sys.service.impl;

import com.ird.portal.common.sys.data.Select2DTO;
import com.ird.portal.ehcahe.EhcacheKeyConst;
import com.ird.portal.ehcahe.EhcacheNameConst;
import com.ird.portal.select2.Select2DaoCmd;
import com.ird.portal.select2.Select2Page;
import com.ird.portal.sys.dao.SysDao;
import com.ird.portal.sys.dao.SysDaoCmd;
import com.ird.portal.sys.service.Select2Service;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * select2
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 22/12/2017 13:20:06<br/>
 *
 * @author Allen
 * @version 1.0
 */
@CacheConfig(cacheNames = EhcacheNameConst.SYSTEM)
@Service
@Transactional(rollbackFor = Exception.class)
public class Select2ServiceImpl implements Select2Service {
    private static final  Logger LOG = LoggerFactory.getLogger(Select2ServiceImpl.class);

    @Autowired
    private SysDao dao;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Select2DTO> selectSysCodeData(String codeType, String queryString) {

        Map<String, Object> params = new HashMap<>();
        params.put("codeType", codeType);
        params.put("queryString", queryString);
        convertCodeTypeParam(params);

        SysDaoCmd cmd = new SysDaoCmd("selectSysCode", params);
        return dao.getList(cmd, Select2DTO.class);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Select2DTO> getForeignLicNoBySpNo(String spNo, String keyword) {

        Map<String, Object> params = new HashMap<>();
        params.put("spNo", spNo);
        params.put("keyword", keyword);

        SysDaoCmd cmd = new SysDaoCmd("getForeignLicNoBySpNo", params);
        return dao.getList(cmd, Select2DTO.class, true);
    }

    @Override
    public Select2Page selectSysCodeData(Map<String, Object> params, int pageSize, int pageNumber) {
        LOG.debug("codeType: {}", params.get("codeType"));
        convertCodeTypeParam(params);

        return getPage(params, "selectSysCodeList", pageSize, pageNumber);
    }

    private void convertCodeTypeParam(Map<String, Object> params) {
        if(params.get("codeType") !=null) {
            String codeType = params.get("codeType").toString();
            if(StringUtils.contains(codeType, ",")){
                List<Integer> codetypes = new ArrayList<Integer>();

                String[] split = StringUtils.split(codeType, ",");
                for(String cd : split){
                    codetypes.add(Integer.parseInt(cd));
                }
                params.put("codeTypes", codetypes);
                params.remove("codeType");
            }
        }

        if(params.get("filterCodeKeys") !=null) {
            params.put("filterCodeKeys", StringUtils.split(String.valueOf(params.get("filterCodeKeys")), ","));
        }

        /**
         * 从codeId中读取参数0,6,7，放入codeIds集合中
         */
        if(params.get("codeId") !=null) {
            String codeId = params.get("codeId").toString();
            if(StringUtils.contains(codeId, ",")){
                List<String> codeIds = new ArrayList<String>();

                String[] split = StringUtils.split(codeId, ",");
                for(String cd : split){
                    codeIds.add(cd);
                }
                params.put("codeIds", codeIds);
                params.remove("codeId");
            }
        }
    }

    private Select2Page getPage(Map<String, Object> params, String queryKey, int pageSize, int pageNumber) {
        Select2DaoCmd daoCmd = new Select2DaoCmd(queryKey, params, pageSize, pageNumber);
        Select2Page page = (Select2Page)dao.getPage(daoCmd, Select2DTO.class, true);
        return page;
    }

    @Override
    public Select2Page selectLocation(Map<String, Object> params, int pageSize, int pageNumber) {
        return getPage(params, "selectLocation", pageSize, pageNumber);
    }

    @Override
    public Select2Page selectStreet(Map<String, Object> params, int pageSize, int pageNumber) {
        return getPage(params, "selectStreet", pageSize, pageNumber);
    }

    @Override
    public Select2Page selectBuilding(Map<String, Object> params, int pageSize, int pageNumber) {
        return getPage(params, "selectBuilding", pageSize, pageNumber);
    }

    /**
     *
     * 根據codeType從redis拿出數據
     */
    @Cacheable(key = EhcacheKeyConst.SYSCODE_ANNOTATION)
    @Override
    public List<Select2DTO> selectCodeByType(String codeType) {
        Map<String, Object> params = new HashMap<>();
        params.put("codeType", codeType);
        SysDaoCmd cmd = new SysDaoCmd("selectSysCodeList", params);
        return dao.getList(cmd, Select2DTO.class, true);
    }

    /**
     *
     * 根據codeType更新redis相關值
     */
    @CachePut(key = EhcacheKeyConst.SYSCODE_ANNOTATION)
    @Override
    public List<Select2DTO> updateRedisCodeByType(String codeType) {
        Map<String, Object> params = new HashMap<>();
        params.put("codeType", codeType);
        SysDaoCmd cmd = new SysDaoCmd("selectSysCodeList", params);
        List<Select2DTO> list = dao.getList(cmd, Select2DTO.class, true);
        return list;
    }

    @Override
    public List<Select2DTO> selectSysCodeData4show(String codeType, String queryString) {
        Map<String, Object> params = new HashMap<>();
        params.put("codeType", codeType);
        params.put("queryString", queryString);
        convertCodeTypeParam(params);

        SysDaoCmd cmd = new SysDaoCmd("selectSysCode4show", params);
        return dao.getList(cmd, Select2DTO.class);
    }



    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Select2Page getLicNoList(String licType, String licStatus, String keyword, int pageSize, int pageNumber) {
        Map<String, Object> params = new HashMap<>();
        params.put("licType", licType);
        params.put("licStatus", licStatus);
        params.put("keyword", keyword);
        return getPage(params, "getLicNoList", pageSize, pageNumber);
    }

    @Override
    public Select2Page selectForeignLicType(Map<String, Object> params, int pageSize, int pageNumber) {
        convertCodeTypeParam(params);
        return getPage(params, "selectForeignLicType", pageSize, pageNumber);
    }

    @Override
    public List<String> getIdentTypeSysCode(){
        Map<String, Object> params = new HashMap<>();
        SysDaoCmd cmd = new SysDaoCmd("getIdentTypeSysCode",params);
        List<String> list = dao.getList(cmd,String.class,false);
        return list;
    }

    @Override
    public List<String> getLangSysCode(){
        Map<String, Object> params = new HashMap<>();
        SysDaoCmd cmd = new SysDaoCmd("getLangSysCode",params);
        List<String> list = dao.getList(cmd,String.class,false);
        return list;
    }

    /**
     * 獲取預約方式
     * @return
     */
    @Override
    public List<Map<String, Object>> getBookingType() {
        Map<String, Object> params = new HashMap<>();
        SysDaoCmd cmd = new SysDaoCmd("getSysCodeForAppointment",params);
        return dao.getList(cmd, HashMap.class,true);
    }
}
