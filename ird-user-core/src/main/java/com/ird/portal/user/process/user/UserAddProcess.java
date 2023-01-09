package com.ird.portal.user.process.user;

import com.ird.portal.common.user.data.UserDTO;
import com.ird.portal.exception.RecordExistException;
import com.ird.portal.user.User;
import com.ird.portal.user.UserContext;
import com.ird.portal.user.dao.UserDao;
import com.ird.portal.user.entity.RoleEntity;
import com.ird.portal.user.entity.UserEntity;
import com.ird.portal.user.process.role.RoleQueryProcess;
import com.ird.portal.user.util.ConstantUtil;
import com.ird.portal.util.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.TreeSet;


/**
 * 
 * 
 * 用戶管理-新增. <br/>
 * <br/>
 * <b>Date:</b> 30/11/2017 12:04:51<br/>
 * 
 * @author Deft
 * @version 1.0
 */
@Component
public class UserAddProcess {
    
    @Autowired
    private BeanMapper beanmMapper;
    
    @Autowired
    private UserDao dao;
    
    @Autowired
    private RoleQueryProcess roleQueryProcess;
    
    
    public void add(UserDTO dto) {
		
        UserEntity temp = dao.getSingle(UserEntity.class, dto.getUserId());
        if (temp != null) {
            throw new RecordExistException("userId=" + dto.getUserId());
        }
        
        UserEntity entity = beanmMapper.map(dto, UserEntity.class);
		User user = UserContext.getUser();
        if(user !=null){
        	entity.setCreateUser(user.getUserId());
        	entity.setLastUpdUser(user.getUserId());
        }
        entity.setCreateDate(new Date());
		entity.setLastUpdDate(new Date());

		if (dto.getRoleIds() != null && dto.getRoleIds().length > 0) {
    		List<RoleEntity> list = roleQueryProcess.getByIds(dto.getRoleIds());
    		entity.setRoles(new TreeSet<RoleEntity>(list));
    	}else{
    		entity.getRoles().clear();
    	}
		entity.setStatus(ConstantUtil.USER_STATUS_ACTIVE);
		dao.insert(entity);
	}

}
