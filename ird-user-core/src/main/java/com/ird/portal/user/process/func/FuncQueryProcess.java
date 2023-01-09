package com.ird.portal.user.process.func;

import com.ird.portal.common.user.data.FuncDTO;
import com.ird.portal.datatable.DatatableDaoCmd;
import com.ird.portal.model.Page;
import com.ird.portal.user.dao.Queries;
import com.ird.portal.user.dao.UserDao;
import com.ird.portal.user.dao.UserDaoCmd;
import com.ird.portal.user.entity.FuncEntity;
import com.ird.portal.util.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 功能管理-查詢.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 01/12/2017 15:45:52<br/>
 * 
 * @author Deft
 * @version 1.0
 */
@Component
public class FuncQueryProcess {
    
    @Autowired
    private UserDao dao;
    
    @Autowired
    private BeanMapper beanMapper;
    
    public Page getPage(FuncDTO dto) {
        DatatableDaoCmd cmd = new DatatableDaoCmd(Queries.HQL_GET_FUNC_LIST, dto);
        return dao.getPage(cmd, FuncEntity.class);
        
    }
    
    public FuncEntity getById(Long id) {
        FuncEntity funcEntity = dao.getSingle(FuncEntity.class, id);
        if(funcEntity == null){
            return null;
        }
        return funcEntity;
    }
    
    public List<FuncEntity> getFuncByIds(Long[] ids) {
        Map<String, Object> params = new HashMap<>();
        params.put("ids", ids);
        UserDaoCmd cmd = new UserDaoCmd(Queries.HQL_GET_FUNC_BY_IDS, params);
        return dao.getList(cmd, FuncEntity.class);
    }

    public List<FuncDTO> getList(FuncDTO dto) {
        Map<String, Object> map = beanMapper.map(dto, HashMap.class);
        UserDaoCmd cmd = new UserDaoCmd(Queries.HQL_GET_FUNC_LIST, map);
        List<FuncEntity> list =  dao.getList(cmd, FuncEntity.class);
        return beanMapper.mapList(list, FuncDTO.class);
    }

    public List<FuncEntity> getTop(FuncDTO dto) {
        UserDaoCmd cmd = new UserDaoCmd(Queries.HQL_GET_FUNC_TOP);
        return  dao.getList(cmd, FuncEntity.class);
    }

    public List<FuncEntity> buildParent(Long funcId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("funcId", funcId);
        UserDaoCmd cmd = new UserDaoCmd(Queries.HQL_BUILD_FUNC_PARENT, params);
        return dao.getList(cmd, FuncEntity.class);
    }

    public List<FuncEntity> getFuncByFuncCode(String funcCode) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("funcCode", funcCode);
        UserDaoCmd cmd = new UserDaoCmd(Queries.HQL_GET_FUNC_BY_FUNC_CODE, params);
        return dao.getList(cmd, FuncEntity.class);
    }
}
