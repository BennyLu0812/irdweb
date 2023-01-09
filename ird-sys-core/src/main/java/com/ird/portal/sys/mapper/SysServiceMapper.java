package com.ird.portal.sys.mapper;

import com.ird.portal.common.sys.data.SysProcessDTO;
import com.ird.portal.common.sys.data.SysServiceDTO;
import com.ird.portal.dao.AbstractCommonDao;
import com.ird.portal.dao.AbstractMapper;
import com.ird.portal.sys.dao.SysDao;
import com.ird.portal.sys.dao.SysDaoCmd;
import com.ird.portal.sys.entity.ParamsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SysServiceMapper extends AbstractMapper<ParamsEntity> {
    
    @Autowired
    private SysDao dao;
    
    @Override
    protected AbstractCommonDao getDao() {
        return dao;
    }
    
    public List<SysServiceDTO> getSysServiceList(SysServiceDTO queryDTO) {
        return getDao().getList(new SysDaoCmd("getSysServiceList", queryDTO), SysServiceDTO.class, true);
    }
    
    public List<SysServiceDTO> getSysServiceByOperationCodes(SysServiceDTO queryDTO) {
        return getDao().getList(new SysDaoCmd("getSysServiceByOperationCodes", queryDTO), SysServiceDTO.class, true);
    }
    
    public List<SysProcessDTO> getSysProcessList(SysProcessDTO queryDTO) {
        return getDao().getList(new SysDaoCmd("getSysProcessList", queryDTO), SysProcessDTO.class, true);
    }

    public List<SysProcessDTO> getSysProcessByOperationCodes(SysProcessDTO queryDTO) {
        return getDao().getList(new SysDaoCmd("getSysProcessByOperationCodes", queryDTO), SysProcessDTO.class, true);
    }
    
    
    
}
