package com.ird.portal.user.mapper;

import com.ird.portal.common.user.data.ModuleDTO;
import com.ird.portal.dao.AbstractCommonDao;
import com.ird.portal.dao.AbstractMapper;
import com.ird.portal.datatable.DatatableDaoCmd;
import com.ird.portal.model.Page;
import com.ird.portal.user.dao.UserDao;
import com.ird.portal.user.dao.UserDaoCmd;
import com.ird.portal.user.entity.ModuleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ModuleMapper extends AbstractMapper<ModuleEntity> {
    
    @Autowired
    private UserDao userDao;
    
    public Page getPage(ModuleDTO dto) {
        DatatableDaoCmd cmd = new DatatableDaoCmd("getModuleList", dto);
        return getDao().getPage(cmd, ModuleEntity.class);
    }
    
    public ModuleEntity getById(Long moduleId) {
        return getDao().getSingle(ModuleEntity.class, moduleId);
    }
    
    public List<ModuleEntity> getList(ModuleDTO dto) {
        UserDaoCmd cmd = new UserDaoCmd("getModuleList", dto);
        return getDao().getList(cmd, ModuleEntity.class);
    }
    
    public List<ModuleEntity> getChildren(Long moduleId) {
        Map<String, Object> map = new HashMap<>();
        ModuleEntity parent = getDao().getSingle(ModuleEntity.class, moduleId);
        map.put("parent", parent);
        UserDaoCmd cmd = new UserDaoCmd("getModuleChildren", map);
        return getDao().getList(cmd, ModuleEntity.class);
    }
    
    public List<ModuleEntity> getTop(Long moduleId) {
        UserDaoCmd cmd = new UserDaoCmd("getTopModule");
        return getDao().getList(cmd, ModuleEntity.class);
    }
    
    public List<ModuleEntity> buildParent(Long moduleId) {
        Map<String, Object> map = new HashMap<>();
        map.put("moduleId", moduleId);
        UserDaoCmd cmd = new UserDaoCmd("buildModuleParent", map);
        return getDao().getList(cmd, ModuleEntity.class);
    }
    
    @Override
    protected AbstractCommonDao getDao() {
        return userDao;
    }
    
}
