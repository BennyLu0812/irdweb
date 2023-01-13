package com.ird.portal.user.mapper;

import com.ird.portal.common.user.data.RoleDTO;
import com.ird.portal.dao.AbstractCommonDao;
import com.ird.portal.dao.AbstractMapper;
import com.ird.portal.datatable.DataTablePage;
import com.ird.portal.datatable.DatatableDaoCmd;
import com.ird.portal.model.Page;
import com.ird.portal.user.dao.UserDao;
import com.ird.portal.user.dao.UserDaoCmd;
import com.ird.portal.user.entity.RoleEntity;
import com.ird.portal.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RoleMapper extends AbstractMapper<RoleEntity> {
    
    @Autowired
    private UserDao userDao;
    
    public List<RoleEntity> getByIds(Long[] ids) {
        Map<String, Object> map = new HashMap<>();
        map.put("ids", ids);
        UserDaoCmd userDaoCmd = new UserDaoCmd("getRoleByIds", map);
        List<RoleEntity> roleList = getDao().getList(userDaoCmd, RoleEntity.class);
        return roleList;
    }
    
    public Page getPage(RoleDTO dto) {
        dto.setCreateDate_start(DateUtil.format(DateUtil.parse(dto.getCreateDate_start(),"dd/MM/yyyy HH:mm:ss"),"yyyy-MM-dd HH:mm:ss"));
        dto.setCreateDate_end(DateUtil.format(DateUtil.parse(dto.getCreateDate_end(),"dd/MM/yyyy HH:mm:ss"),"yyyy-MM-dd HH:mm:ss"));
        dto.setLastUpdDate_start(DateUtil.format(DateUtil.parse(dto.getLastUpdDate_start(),"dd/MM/yyyy HH:mm:ss"),"yyyy-MM-dd HH:mm:ss"));
        dto.setLastUpdDate_end(DateUtil.format(DateUtil.parse(dto.getLastUpdDate_end(),"dd/MM/yyyy HH:mm:ss"),"yyyy-MM-dd HH:mm:ss"));
        DatatableDaoCmd cmd = new DatatableDaoCmd("getRoleList", dto);
        DataTablePage page = (DataTablePage)getDao().getPage(cmd, RoleEntity.class);
        return page;
    }

    public List<RoleEntity> getList(RoleDTO dto) {
        UserDaoCmd cmd = new UserDaoCmd("getRoleList", dto);
        return getDao().getList(cmd, RoleEntity.class);
    }
   

    public RoleEntity getRoleByCode(String roleCode) {
        Map<String, Object> params = new HashMap<>();
        params.put("roleCode", roleCode);
        return getDao().getSingle(new UserDaoCmd("getRoleByCode", params), RoleEntity.class);
    }
    
    @Override
    protected AbstractCommonDao getDao() {
        return userDao;
    }

    
}
