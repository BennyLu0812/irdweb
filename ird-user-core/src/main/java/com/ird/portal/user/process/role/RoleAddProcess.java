package com.ird.portal.user.process.role;

import com.ird.portal.common.user.data.RoleDTO;
import com.ird.portal.user.dao.UserDao;
import com.ird.portal.user.entity.FuncEntity;
import com.ird.portal.user.entity.RoleEntity;
import com.ird.portal.user.process.func.FuncQueryProcess;
import com.ird.portal.user.util.ConstantUtil;
import com.ird.portal.util.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.TreeSet;

/**
 * 
 * 角色管理-新增. <br/>
 * <br/>
 * <b>Date:</b> 12/12/2017 14:35:43<br/>
 * 
 * @author Deft
 * @version 1.0
 */
@Component
public class RoleAddProcess {
    
    @Autowired
    private UserDao dao;
    
    @Autowired
    private FuncQueryProcess funcQueryProcess;
    
    @Autowired
    private BeanMapper beanMapper;
    
    public void add(RoleDTO dto) {
        
        RoleEntity entity = new RoleEntity();
        entity = beanMapper.mapTo(dto, RoleEntity.class);
        if (dto.getFuncIds() != null && dto.getFuncIds().length > 0) {
            List<FuncEntity> list = funcQueryProcess.getFuncByIds(dto.getFuncIds());
            entity.setFuncs(new TreeSet<FuncEntity>(list));
        }
        entity.setStatus(ConstantUtil.ROLE_STATUS_ACTIVE);
        dao.insert(entity);
    }
}
