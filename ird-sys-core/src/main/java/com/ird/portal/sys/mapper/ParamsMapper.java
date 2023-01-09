package com.ird.portal.sys.mapper;

import com.ird.portal.common.sys.data.SysParamDTO;
import com.ird.portal.common.sys.enums.SysCodeStatus;
import com.ird.portal.dao.AbstractCommonDao;
import com.ird.portal.dao.AbstractMapper;
import com.ird.portal.datatable.DataTablePage;
import com.ird.portal.datatable.DatatableDaoCmd;
import com.ird.portal.exception.RecordExistException;
import com.ird.portal.exception.RecordNotFoundException;
import com.ird.portal.model.Page;
import com.ird.portal.sys.dao.SysDao;
import com.ird.portal.sys.dao.SysDaoCmd;
import com.ird.portal.sys.entity.ParamsEntity;
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
 * TODO 請給ParamsMapper說明一下吧!
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 21/05/2018 15:56:34<br/>
 * @author James
 * @version 1.0
 */
@Repository
public class ParamsMapper extends AbstractMapper<ParamsEntity> {

    private static final  Logger LOG = LoggerFactory.getLogger(ParamsMapper.class);
    
    @Autowired
    private SysDao adminDao;

    @Autowired
    private BeanMapper beanMapper;
    
    public ParamsEntity add(ParamsEntity entity) {
        LOG.debug("Entering add: ({})", entity);
        Map<String, Object> map = new HashMap<>();
        map.put("paramName", entity.getParamName());
        SysDaoCmd cmd = new SysDaoCmd("getParamByName", map);
        ParamsEntity obj = adminDao.getSingle(cmd,ParamsEntity.class);
        if(obj!=null) {
            throw new RecordExistException("paramName = "+entity.getParamName());
        }
        entity.setParamStatus(SysCodeStatus.ACTIVE.getCode());
        return (ParamsEntity)adminDao.insert(entity);
    }
    
    public void deleteByName(String paramName) {
        Map<String, Object> map = new HashMap<>();
        map.put("paramName", paramName);
        SysDaoCmd cmd = new SysDaoCmd("getParamByName", map);
        ParamsEntity obj = adminDao.getSingle(cmd,ParamsEntity.class);
        if(obj==null) {
            throw new RecordNotFoundException("paramName = "+paramName);
        }
        adminDao.delete(obj);
    }
    
    /**
     * 分頁.
     * @param sysParamDto dto對象
     * @return page對象
     * */
    public Page getSysParam(SysParamDTO sysParamDto) {
    	if(StringUtils.isNotBlank(sysParamDto.getKeyword())) {
    		sysParamDto.setKeyword("%"+sysParamDto.getKeyword().toUpperCase()+"%");
    	}
    	
        DatatableDaoCmd daoCmd = new DatatableDaoCmd("getSysParam", sysParamDto);
        Long recordsTotal = adminDao.getCount(daoCmd);
        DataTablePage page = (DataTablePage) adminDao.getPage(daoCmd, ParamsEntity.class);
        page.setRecordsTotal(recordsTotal);
        return page;
    }
    
    /**
     * 通過paraName獲取實例對象.
     * @param paramName 參數名
     * @return 實體對象
     * */
    public ParamsEntity getByName(String paramName) {
        Map<String, Object> map = new HashMap<>();
        map.put("paramName", paramName);
        SysDaoCmd cmd = new SysDaoCmd("getParamByName", map);
        ParamsEntity obj = adminDao.getSingle(cmd, ParamsEntity.class);
        return obj;
    }
    
    /**
     * 獲取dto對象.
     * @param paramName 參數
     * @return dto對象
     * */
    public SysParamDTO getDTOByName(String paramName) {
        ParamsEntity entity = getByName(paramName); // 調用上面的定義好的方法
        SysParamDTO dto = new SysParamDTO();
        if(entity != null) {
            beanMapper.map(entity, dto); // 轉換為DTO返回
            return dto;
        }else{
            return null;
        }
    }
    
    @Override
    public ParamsEntity update(ParamsEntity entity) {
        ParamsEntity newEntity = adminDao.getSingle(ParamsEntity.class, entity.getParamName());
        if (newEntity != null) {
            newEntity.setParamDesc(entity.getParamDesc());
            newEntity.setParamValue(entity.getParamValue());
            //newEntity.setParamName(entity.getParamName()); //这里不能拿查询条件来修改 ,  注释者:jaylen
            return (ParamsEntity)adminDao.update(newEntity);
        }
        return null;
    }
    
    @Override
    protected AbstractCommonDao getDao() {
        return null;
    }
    
    public List<SysParamDTO> getAllParams() {
        SysDaoCmd cmd = new SysDaoCmd("getAllParams");
        List<SysParamDTO> list = adminDao.getList(cmd, SysParamDTO.class, true);
        return list;
    }
    
}
