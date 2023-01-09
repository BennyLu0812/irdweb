package com.ird.portal.user.process.role;

import com.ird.portal.common.user.data.RoleDTO;
import com.ird.portal.datatable.DataTablePage;
import com.ird.portal.datatable.DatatableDaoCmd;
import com.ird.portal.model.Page;
import com.ird.portal.user.dao.Queries;
import com.ird.portal.user.dao.UserDao;
import com.ird.portal.user.dao.UserDaoCmd;
import com.ird.portal.user.entity.RoleEntity;
import com.ird.portal.util.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * 
 * 角色管理-查詢.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 30/11/2017 11:37:12<br/>
 * 
 * @author Deft
 * @version 1.0
 */
@Component
public class RoleQueryProcess {
    
    @Autowired
    private UserDao dao;
    
    @Autowired
    private BeanMapper beanMapper;
    
    public RoleEntity getById(Long id) {
        RoleEntity roleEntity = dao.getSingle(RoleEntity.class, id);
        if (roleEntity == null) {
            return null;
        }
        else {
            return roleEntity;
        }
    }
    
    public List<RoleEntity> getByIds(Long[] ids) {
        Map<String, Object> map = new HashMap<>();
        map.put("ids", ids);
        UserDaoCmd userDaoCmd = new UserDaoCmd(Queries.HQL_GET_ROLE_BY_IDS, map);
        List<RoleEntity> roleList = dao.getList(userDaoCmd, RoleEntity.class);
        return roleList;
    }
    
    public Page getPage(RoleDTO dto) {
        DatatableDaoCmd cmd = new DatatableDaoCmd(Queries.HQL_GET_ROLE_LIST, dto);
        DataTablePage page = (DataTablePage)dao.getPage(cmd, RoleEntity.class);
        return page;
    }

    public List<RoleEntity> getList(RoleDTO dto) {
        Map<String, Object> map = beanMapper.mapTo(dto, HashMap.class);
        UserDaoCmd cmd = new UserDaoCmd(Queries.HQL_GET_ROLE_LIST, map);
        return dao.getList(cmd, RoleEntity.class);
    }
    
}
