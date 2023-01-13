package com.ird.portal.user.process.module;

import com.ird.portal.common.user.data.ModuleDTO;
import com.ird.portal.datatable.DatatableDaoCmd;
import com.ird.portal.model.Page;
import com.ird.portal.user.dao.Queries;
import com.ird.portal.user.dao.UserDao;
import com.ird.portal.user.dao.UserDaoCmd;
import com.ird.portal.user.entity.ModuleEntity;
import com.ird.portal.util.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 模塊管理-查詢.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 01/12/2017 15:45:52<br/>
 * 
 * @author Deft
 * @version 1.0
 */
@Component
public class ModulesQueryProcess {
    
    @Autowired
    private UserDao dao;
    
    @Autowired
    private BeanMapper beanMapper;
    
    public Page getPage(ModuleDTO dto) {
        DatatableDaoCmd cmd = new DatatableDaoCmd(Queries.HQL_GET_MODULE_LIST, dto);
        return dao.getPage(cmd, ModuleEntity.class);
        
    }
    
    public ModuleEntity getById(Long moduleId) {
        ModuleEntity moduleEntity = dao.getSingle(ModuleEntity.class, moduleId);
        if (moduleEntity == null) {
            return null;
        }
        return moduleEntity;
    }
    
    public List<ModuleEntity> getList(ModuleDTO dto) {
        Map<String, Object> map = beanMapper.map(dto, HashMap.class);
        UserDaoCmd cmd = new UserDaoCmd(Queries.HQL_GET_MODULE_LIST, map);
        return dao.getList(cmd, ModuleEntity.class);
    }
    
    public List<ModuleEntity> getChildren(Long moduleId) {
        Map<String, Object> map = new HashMap<>();
        ModuleEntity parent = dao.getSingle(ModuleEntity.class, moduleId);
        map.put("parent", parent);
        UserDaoCmd cmd = new UserDaoCmd(Queries.HQL_GET_MODULE_CHILDREN, map);
        return dao.getList(cmd, ModuleEntity.class);
    }
    
    public List<ModuleEntity> getTop(Long moduleId) {
        UserDaoCmd cmd = new UserDaoCmd(Queries.HQL_GET_MODULE_TOP);
        return dao.getList(cmd, ModuleEntity.class);
    }
    
    public List<ModuleEntity> buildParent(Long moduleId) {
        Map<String, Object> map = new HashMap<>();
        map.put("moduleId", moduleId);
        UserDaoCmd cmd = new UserDaoCmd(Queries.HQL_BUILT_MODULE_PARENT, map);
        return dao.getList(cmd, ModuleEntity.class);
    }
}
