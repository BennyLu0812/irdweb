/**
 * @Project Name: dls-common-api-test
 * @File Name: AuthorizeServiceImpl.java
 * @Date: 17/12/2017 21:18:57
 * @Copyright: Copyright (c) 2017 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.common.user.service;

import java.util.Set;

/**
 * AuthorizeServiceApi的Mocket類.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 17/12/2017 21:18:57<br/>
 * 
 * @author Jim
 * @version 1.0
 */
public class MockAuthorizeServiceApi implements AuthorizeServiceApi {
    
    @Override
    public boolean isAuthenticated() {
        return true;
    }
    
    @Override
    public boolean isAnonymous() {
        return false;
    }
    
    @Override
    public boolean hasRole(String role) {
        return true;
    }
    
    @Override
    public boolean hasAnyRole(String... roles) {
        return true;
    }
    
    @Override
    public boolean hasPermission(String permission) {
        return true;
    }

    @Override
    public Set<String> getFuncCodesByUserId(String userId) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
