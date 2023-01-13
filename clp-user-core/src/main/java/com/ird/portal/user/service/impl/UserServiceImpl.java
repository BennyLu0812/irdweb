package com.ird.portal.user.service.impl;

import com.ird.portal.common.user.data.UserDTO;
import com.ird.portal.common.user.enums.UserStatusEnum;
import com.ird.portal.common.user.service.UserServiceApi;
import com.ird.portal.exception.ParameterIsEmptyException;
import com.ird.portal.exception.RecordExistException;
import com.ird.portal.exception.RecordNotFoundException;
import com.ird.portal.model.Page;
import com.ird.portal.select2.Select2Page;
import com.ird.portal.user.User;
import com.ird.portal.user.entity.RoleEntity;
import com.ird.portal.user.entity.UserEntity;
import com.ird.portal.user.entity.UserRoleEntity;
import com.ird.portal.user.entity.UserRolePK;
import com.ird.portal.user.mapper.UserMapper;
import com.ird.portal.user.mapper.UserRoleMapper;
import com.ird.portal.user.service.RoleService;
import com.ird.portal.user.service.UserService;
import com.ird.portal.user.util.ConstantUtil;
import com.ird.portal.user.util.UserModuleUtil;
import com.ird.portal.util.BeanMapper;
import com.ird.portal.util.SysParamsConstant;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * 
 * 用戶管理.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 01/12/2017 11:01:26<br/>
 * 
 * @author Deft
 * @version 1.0
 */
@Service
@Transactional
public class UserServiceImpl implements UserServiceApi, UserService {
    
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;
    
    @Autowired
    private BeanMapper beanMapper;
    
    @Autowired
    private RoleService roleService;
    
    @Override
    @Transactional(readOnly = true)
    public User getUserById(String userId) {
        UserEntity userEntity = userMapper.getSingle(userId.toUpperCase());
        User user = null;
        if(userEntity != null){
        	user = new User();
        	user.setUserId(userEntity.getUserId());
        	user.setUserName(userEntity.getUserId());
        	user.setUserName(userEntity.getCnName());
        }
        return user;
    }

    @Override
    @Transactional(readOnly = true)
    public User getActiveUserById(String userId) {
        UserEntity userEntity = userMapper.getSingle(userId.toUpperCase());
        User user = null;
        if(userEntity != null && UserStatusEnum.ACTIVE.getCode().equals(userEntity.getStatus())){
            user = new User();
            user.setUserId(userEntity.getUserId());
            user.setUserName(userEntity.getUserId());
            user.setUserName(userEntity.getCnName());
        }
        return user;
    }

    private UserEntity getUserEntityById(String userId) {
        if (StringUtils.isEmpty(userId)) {
            throw new ParameterIsEmptyException("userId");
        }
        return userMapper.getSingle(userId.toUpperCase());
    }
    
    @Override
    public void add(UserDTO dto) {
        UserEntity temp = getUserEntityById(dto.getUserId());
        if (temp != null) {
            throw new RecordExistException("userId=" + dto.getUserId());
        }


        UserEntity entity = beanMapper.map(dto, UserEntity.class);

        if("L".equals(dto.getUserType())){
            entity.setPassword(DigestUtils.md5DigestAsHex(SysParamsConstant.getParamValue("USER_DEFAULT_PWD").getBytes()));
        }
        
        if (dto.getRoleIds() != null && dto.getRoleIds().length > 0) {
            List<RoleEntity> list = roleService.getRoleByIds(dto.getRoleIds());
            entity.setRoles(new TreeSet<RoleEntity>(list));
        } else {
            entity.getRoles().clear();
        }
        entity.setStatus(ConstantUtil.USER_STATUS_ACTIVE);
        userMapper.insert(entity);
    }
    
    @Override
    public void update(UserDTO dto) {
        UserEntity entity = getUserEntityById(dto.getUserId());
        
        if (entity == null) {
            throw new RecordNotFoundException("userId=" + dto.getUserId());
        }
        if (StringUtils.isNotBlank(dto.getCnName())) {
            entity.setCnName(dto.getCnName());
        }
        if (StringUtils.isNotBlank(dto.getEnName())) {
            entity.setEnName(dto.getEnName());
        }
        if (StringUtils.isNotBlank(dto.getStatus())) {
            entity.setStatus(dto.getStatus());
        }
        if(StringUtils.isNotBlank(dto.getUserType())){
            if("L".equals(dto.getUserType())){
                entity.setPassword(DigestUtils.md5DigestAsHex(SysParamsConstant.getParamValue("USER_DEFAULT_PWD").getBytes()));
            }else{
                entity.setPassword(null);
            }
            entity.setUserType(dto.getUserType());
        }

        // 處理用戶和角色關聯
        final List<RoleEntity> roleEntityList = new ArrayList<RoleEntity>(entity.getRoles());
        if (dto.getRoleIds() != null && dto.getRoleIds().length > 0) {
            final List<RoleEntity> newRoleList = roleService.getRoleByIds(dto.getRoleIds());
            //先判斷頁面新賦予的權限有哪些，做新增處理
            for (RoleEntity roleEntity : newRoleList) {
                if (!UserModuleUtil.myRoleListContains(roleEntityList, roleEntity)) {
                    this.addUserRole(dto.getUserId(), roleEntity.getRoleId());
                }
            }
            //再判斷頁面有哪些權限被刪除，做刪除處理
            for (RoleEntity roleEntity : roleEntityList) {
                if(!UserModuleUtil.myRoleListContains(newRoleList, roleEntity)) {
                    this.deleteUserRole(dto.getUserId(), roleEntity.getRoleId());
                }
            }
        } else {
            if(CollectionUtils.isNotEmpty(roleEntityList)) {
                for(RoleEntity funcEntity : roleEntityList) {
                    this.deleteUserRole(dto.getUserId(), funcEntity.getRoleId());
                }
            }
        }

        userMapper.update(entity);
    }

    /**
     * 根據角色id和用戶id添加一個關聯記錄
     * @param userId
     * @param roleId
     */
    private void addUserRole(String userId, Long roleId){
        if(roleId == null){
            throw new ParameterIsEmptyException("roleId is null");
        }
        if(StringUtils.isBlank(userId)){
            throw new ParameterIsEmptyException("userId is null");
        }
        UserRoleEntity userRoleEntity = new UserRoleEntity();
        userRoleEntity.setRoleId(roleId);
        userRoleEntity.setUserId(userId);
        userRoleMapper.insert(userRoleEntity);
    }

    /**
     * 根據角色id和功能id刪除一個關聯記錄
     * @param roleId
     * @param userId
     */
    private void deleteUserRole(String userId, Long roleId){
        if(roleId == null){
            throw new ParameterIsEmptyException("roleId is null");
        }
        if(StringUtils.isBlank(userId)){
            throw new ParameterIsEmptyException("userId is null");
        }
        UserRolePK userRolePK = new UserRolePK(userId, roleId);
        UserRoleEntity userRoleEntity = userRoleMapper.getSingle(userRolePK);
        if(userRoleEntity != null){
            userRoleMapper.delete(userRoleEntity);
        }else{
            throw new RecordNotFoundException("userRoleEntity is null");
        }

    }

    @Override
    public void delete(String id) {
        userMapper.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Page getPage(UserDTO dto) {
        return userMapper.getPage(dto);
    }
    
    @Override
    public UserEntity getById(String userId) {
        return userMapper.getSingle(userId);
    }

    @Override
    public Select2Page getUserNameQuotaSelectPage(String keyword, int pageSize, int pageNumber) {
        return userMapper.getUserNameQuotaSelectPage(keyword,pageSize,pageNumber);
    }

    @Override
    public Select2Page getAuthorizedBatchPrintUsers(String keyword, int pageSize, int pageNumber, List<String> funcList, List<String> excludeUsers) {
        return userMapper.getAuthorizedUsers(keyword,pageSize,pageNumber, funcList, excludeUsers);
    }



    /**
 　　* @description: 根据查询账号密码用户
 　　* @return UserEntity
 　　* @throws
 　　* @author Vincent
 　　* @date 2021/9/22 10:45
 　　*/
    @Override
    public UserEntity getUser(String userId,String password){
        return userMapper.getUser(userId,password);
    }


    @Override
    public void updatePwd(UserEntity userEntity){
        userMapper.update(userEntity);
    }
}
