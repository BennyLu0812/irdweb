package com.ird.portal.user.mapper;

import com.ird.portal.common.sys.data.Select2DTO;
import com.ird.portal.common.user.data.UserDTO;
import com.ird.portal.dao.AbstractCommonDao;
import com.ird.portal.dao.AbstractMapper;
import com.ird.portal.datatable.DataTablePage;
import com.ird.portal.datatable.DatatableDaoCmd;
import com.ird.portal.model.Page;
import com.ird.portal.select2.Select2DaoCmd;
import com.ird.portal.select2.Select2Page;
import com.ird.portal.user.UserContext;
import com.ird.portal.user.dao.Queries;
import com.ird.portal.user.dao.UserDao;
import com.ird.portal.user.dao.UserDaoCmd;
import com.ird.portal.user.entity.UserEntity;
import com.ird.portal.util.DateUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserMapper extends AbstractMapper<UserEntity> {
    
    @Autowired
    private UserDao userDao;
    
    public Page getPage(UserDTO dto) {
        dto.setCreateDate_start(DateUtil.format(DateUtil.parse(dto.getCreateDate_start(),"dd/MM/yyyy HH:mm:ss"),"yyyy-MM-dd HH:mm:ss"));
        dto.setCreateDate_end(DateUtil.format(DateUtil.parse(dto.getCreateDate_end(),"dd/MM/yyyy HH:mm:ss"),"yyyy-MM-dd HH:mm:ss"));
        dto.setLastUpdDate_start(DateUtil.format(DateUtil.parse(dto.getLastUpdDate_start(),"dd/MM/yyyy HH:mm:ss"),"yyyy-MM-dd HH:mm:ss"));
        dto.setLastUpdDate_end(DateUtil.format(DateUtil.parse(dto.getLastUpdDate_end(),"dd/MM/yyyy HH:mm:ss"),"yyyy-MM-dd HH:mm:ss"));
        DatatableDaoCmd cmd = new DatatableDaoCmd("getUserList", dto);
        DataTablePage page = (DataTablePage)getDao().getPage(cmd, UserEntity.class);
        return page;
    }
    
    public Boolean hasRole(String role) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userId", UserContext.getUser().getUserId());
        params.put("role", role);
        UserDaoCmd cmd = new UserDaoCmd(Queries.HAS_ROLE, params);
        BigDecimal result = getDao().getSingle(cmd, BigDecimal.class);
        
        if (result != null && result.intValue() > 0) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
    
    public Boolean hasAnyRole(String[] roles) {
        return this.hasAnyRole(UserContext.getUser().getUserId(), roles);
    }

    public Boolean hasAnyRole(String userId, String[] roles) {
        Map<String, Object> params = new HashMap<String, Object>(2);
        params.put("roles", roles);
        params.put("userId", userId);
        UserDaoCmd cmd = new UserDaoCmd(Queries.HAS_ANY_ROLE, params);
        BigDecimal result = getDao().getSingle(cmd, BigDecimal.class);

        if (result != null && result.intValue() > 0) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
    
    public Boolean hasPermission(String funcCode) {
        return this.hasPermission(UserContext.getUser().getUserId(), funcCode);
    }

    public Boolean hasPermission(String userId, String funcCode) {
        Map<String, Object> params = new HashMap<>(2);
        params.put("funcCode", funcCode);
        params.put("userId", userId);
        UserDaoCmd cmd = new UserDaoCmd(Queries.HAS_PERMISSION, params);
        BigDecimal result = getDao().getSingle(cmd, BigDecimal.class);
        if (result != null && result.intValue() > 0) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }


    
    @Override
    protected AbstractCommonDao getDao() {
        return userDao;
    }
    
    public Select2Page getUserNameQuotaSelectPage(String keyword, int pageSize, int pageNumber) {
        Map<String, Object> params = new HashMap<>();
        if (StringUtils.isNotBlank(keyword)) {
            params.put("keyword", keyword);
        }
        Select2DaoCmd daoCmd = new Select2DaoCmd("getUserNameQuotaSelectPage", params, pageSize, pageNumber);
        Select2Page page = (Select2Page)getDao().getPage(daoCmd, Select2DTO.class, true);
        return page;
    }
    
    public List<String> getFuncCodesByUserId(String userId) {
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        return getDao().getList(new UserDaoCmd("getFuncCodesByUserId", params), ArrayList.class);
    }

    public Select2Page getAuthorizedUsers(String keyword, int pageSize, int pageNumber, List<String> funcList, List<String> excludeUsers) {
        Map<String,Object> paramDTO = new HashMap<String, Object>();
        if (StringUtils.isNotBlank(keyword)) {
            paramDTO.put("keyword",keyword);
        }
        if (CollectionUtils.isNotEmpty(funcList)) {
            paramDTO.put("funcList",funcList);
        }
        if (CollectionUtils.isNotEmpty(excludeUsers)) {
            paramDTO.put("excludeUsers",excludeUsers);
        }
        Select2DaoCmd daoCmd = new Select2DaoCmd("getAuthorizedBatchPrintUsers",paramDTO,pageSize,pageNumber);
        Select2Page page = (Select2Page) getDao().getPage(daoCmd,Select2DTO.class,true);
        return page;
    }


    public UserEntity getUser(String userId, String password){
        Map<String, Object> params = new HashMap<>(1);
        params.put("userId", userId);
        params.put("password", password);
        return getDao().getSingle(new UserDaoCmd("geUser", params), UserEntity.class, true);
    }

}

