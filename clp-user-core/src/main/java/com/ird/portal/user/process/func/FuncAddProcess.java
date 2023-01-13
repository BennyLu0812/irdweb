package com.ird.portal.user.process.func;

import com.ird.portal.common.user.data.FuncDTO;
import com.ird.portal.user.dao.UserDao;
import com.ird.portal.user.entity.FuncEntity;
import com.ird.portal.user.entity.ModuleEntity;
import com.ird.portal.user.util.ConstantUtil;
import com.ird.portal.util.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * 功能管理-新增.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 01/12/2017 15:45:52<br/>
 * 
 * @author Deft
 * @version 1.0
 */
@Component
public class FuncAddProcess {
    
    @Autowired
    private UserDao dao;
    
    @Autowired
    private BeanMapper beanMapper;
    
   public void add(FuncDTO dto) {
       FuncEntity entity = new FuncEntity();
       entity = beanMapper.mapTo(dto, FuncEntity.class);
       entity.setStatus(ConstantUtil.FUNC_STATUS_ACTIVE);
       if(dto.getParentId() != null){
           FuncEntity parent = dao.getSingle(FuncEntity.class, dto.getParentId());
           entity.setParent(parent);
       }
       if(dto.getModuleId()!=null) {
           ModuleEntity module = dao.getSingle(ModuleEntity.class, dto.getModuleId());
           entity.setModule(module);
       }
       dao.insert(entity);
   }
}
