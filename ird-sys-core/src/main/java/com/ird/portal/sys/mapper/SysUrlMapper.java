package com.ird.portal.sys.mapper;

import com.ird.portal.common.sys.data.SysUrlDTO;
import com.ird.portal.dao.AbstractCommonDao;
import com.ird.portal.dao.AbstractMapper;
import com.ird.portal.entity.AbstractEntity;
import com.ird.portal.sys.dao.SysDao;
import com.ird.portal.sys.dao.SysDaoCmd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class SysUrlMapper extends AbstractMapper<AbstractEntity> {
    
    @Autowired
    private SysDao dao;
    
    @Override
    protected AbstractCommonDao getDao() {
        return dao;
    }
    
    public SysUrlDTO getSysUrlById(Long urlId) {
        Map<String, Object> map = new HashMap<>();
        map.put("urlId", urlId);
        return getDao().getSingle(new SysDaoCmd("getSysUrlById", map), SysUrlDTO.class, true);
    }
    
    public SysUrlDTO getSysStartUrlByProcessIdAndStageId(Integer processId, Integer stageId) {
        Map<String, Object> map = new HashMap<>();
        map.put("processId", processId);
        map.put("stageId", stageId);
        return getDao().getSingle(new SysDaoCmd("getSysStartUrlByProcessIdAndStageId", map), SysUrlDTO.class, true);
    }
    
    public SysUrlDTO getSysUrlByProcessCodeAndStageIdAndTag(SysUrlDTO paramDTO) {
        return getDao().getSingle(new SysDaoCmd("getSysUrlByProcessCodeAndStageIdAndTag", paramDTO), SysUrlDTO.class, true);
    }

    public SysUrlDTO getSysUrlBySpNoAndUrl(String spNo, String urlLink) {
        Map<String, Object> map = new HashMap<>();
        map.put("spNo", spNo);
        map.put("urlLink", urlLink);
        return getDao().getSingle(new SysDaoCmd("getSysUrlBySpNoAndUrl", map), SysUrlDTO.class, true);
    }

    public SysUrlDTO getPreviousSysUrl(Long urlId) {
        Map<String, Object> map = new HashMap<>();
        map.put("urlId", urlId);
        return getDao().getSingle(new SysDaoCmd("getPreviousSysUrl", map), SysUrlDTO.class, true);
    }
    
}
