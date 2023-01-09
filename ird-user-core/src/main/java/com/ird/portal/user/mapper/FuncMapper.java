package com.ird.portal.user.mapper;

import com.ird.portal.common.sys.data.Select2DTO;
import com.ird.portal.common.user.data.FuncDTO;
import com.ird.portal.dao.AbstractCommonDao;
import com.ird.portal.dao.AbstractMapper;
import com.ird.portal.datatable.DataTablePage;
import com.ird.portal.datatable.DatatableDaoCmd;
import com.ird.portal.model.Page;
import com.ird.portal.select2.Select2DaoCmd;
import com.ird.portal.select2.Select2Page;
import com.ird.portal.user.dao.UserDao;
import com.ird.portal.user.dao.UserDaoCmd;
import com.ird.portal.user.entity.FuncEntity;
import com.ird.portal.util.BeanMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class FuncMapper extends AbstractMapper<FuncEntity> {
    
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private BeanMapper beanMapper;
    
    public Page getPage(FuncDTO dto) {
        DatatableDaoCmd cmd = new DatatableDaoCmd("getFuncList", dto);
        return getDao().getPage(cmd, FuncEntity.class);
    }
    
    public FuncEntity getById(Long id) {
        return getDao().getSingle(FuncEntity.class, id);
    }
    
    public List<FuncEntity> getFuncByIds(Long[] ids) {
        Map<String, Object> params = new HashMap<>();
        params.put("ids", ids);
        UserDaoCmd cmd = new UserDaoCmd("getFuncByIds", params);
        return getDao().getList(cmd, FuncEntity.class);
    }

    public List<FuncDTO> getList(FuncDTO dto) {
        UserDaoCmd cmd = new UserDaoCmd("getFuncList", dto);
        return beanMapper.mapList(getDao().getList(cmd, FuncEntity.class), FuncDTO.class);
    }

    public List<FuncEntity> getTop(FuncDTO dto) {
        UserDaoCmd cmd = new UserDaoCmd("getTopFunc");
        return  getDao().getList(cmd, FuncEntity.class);
    }

    public List<FuncEntity> buildParent(Long funcId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("funcId", funcId);
        UserDaoCmd cmd = new UserDaoCmd("buildFuncParent", params);
        return getDao().getList(cmd, FuncEntity.class);
    }

    public FuncEntity getFuncByFuncCode(String funcCode) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("funcCode", funcCode);
        UserDaoCmd cmd = new UserDaoCmd("getFuncByFuncCode", params);
        return getDao().getSingle(cmd, FuncEntity.class);
    }   
    
    public Page getRptPreviledgePage(FuncDTO dto) {
        DatatableDaoCmd cmd = new DatatableDaoCmd("getRptPreviledgePage", dto);
        DataTablePage page = (DataTablePage)userDao.getPage(cmd, FuncDTO.class, true);
        return page;
    }
    @Override
    protected AbstractCommonDao getDao() {
        return userDao;
    }

 
    public Select2Page getFuncQuotaSelectPageData(String keyword, int pageSize, int pageNumber) {
        Map<String, Object> params = new HashMap<>();
        if (StringUtils.isNotBlank(keyword)) {
            params.put("keyword", keyword);
        }
        Select2DaoCmd daoCmd = new Select2DaoCmd("getFuncQuotaSelectPageData", params, pageSize, pageNumber);
        Select2Page page = (Select2Page) getDao().getPage(daoCmd, Select2DTO.class, true);
        return page;
    }

    public List<FuncDTO> findFuncByUser(String userId, Integer centerId) {
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        if (centerId != null) {
            params.put("centerId", centerId);
        }
        UserDaoCmd cmd = new UserDaoCmd("findFuncByUser", params);
        return getDao().getList(cmd, FuncDTO.class, true);
    }

    public List<FuncDTO> findAllMenuFunc() {
        UserDaoCmd cmd = new UserDaoCmd("findAllMenuFunc");
        return beanMapper.mapList(getDao().getList(cmd, FuncEntity.class), FuncDTO.class);
    }

    public List<FuncEntity> findMenuList() {
        UserDaoCmd cmd = new UserDaoCmd("findMenuList");
        return getDao().getList(cmd, FuncEntity.class);
    }
    
}
