package com.ird.portal.user.process.module;

import com.ird.portal.common.user.data.ModuleDTO;
import com.ird.portal.user.dao.UserDao;
import com.ird.portal.user.entity.ModuleEntity;
import com.ird.portal.util.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * 模塊管理-新增.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 01/12/2017 15:45:52<br/>
 * 
 * @author Deft
 * @version 1.0
 */
@Component
public class ModulesAddProcess {
    
    @Autowired
    private UserDao dao;
    
    @Autowired
    private BeanMapper beanMapper;
    
    public void add(ModuleDTO dto) {
        ModuleEntity entity = new ModuleEntity();
        entity =beanMapper.mapTo(dto, ModuleEntity.class);
        
        if(dto.getParentId()!= null){
            ModuleEntity parent = dao.getSingle(ModuleEntity.class, dto.getParentId());
            entity.setParent(parent);
        }
        
        dao.insert(entity);
    }
}
