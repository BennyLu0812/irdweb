/**
 * @Project Name: dls-user-core
 * @File Name: AuthorizeServiceApiImpl.java
 * @Date: 17/12/2017 21:50:39
 * @Copyright: Copyright (c) 2017 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.user.service.impl;

import com.ird.portal.common.user.service.AuthorizeServiceApi;
import com.ird.portal.user.UserContext;
import com.ird.portal.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * AuthorizeServiceApi 安全授權 權限類.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 17/12/2017 21:50:39<br/>
 * 
 * @author Jim
 * @version 1.0
 */
@Service
public class AuthorizeServiceApiImpl implements AuthorizeServiceApi {
    
    @Autowired
    private UserMapper userMapper;
    
    @Override
    public boolean isAuthenticated() {
        return UserContext.getUser() != null;
    }
    
    @Override
    public boolean isAnonymous() {
        return !isAuthenticated();
    }
    
    @Override
    @Transactional(readOnly = true)
    public boolean hasRole(String role) {
        return userMapper.hasRole(role);
    }
    
    @Override
    @Transactional(readOnly = true)
    public boolean hasAnyRole(String... roles) {
        return userMapper.hasAnyRole(roles);
    }
    
    @Override
    @Transactional(readOnly = true)
    public boolean hasPermission(String permission) {
        return userMapper.hasPermission(permission);
    }
    
    @Override
    public Set<String> getFuncCodesByUserId(String userId) {
        List<String> _funcCodes = userMapper.getFuncCodesByUserId(userId);
        return new HashSet<>(_funcCodes);
    }
    
}
