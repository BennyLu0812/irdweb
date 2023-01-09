/**
 * @Project Name: dls-common-api
 * @File Name: UserService.java
 * @Date: 2017年11月10日 下午2:07:16
 * @Copyright: Copyright (c) 2017 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.common.user.service;

import com.ird.portal.user.User;

/**
 * 
 * 用戶信息管理的接口.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 13/12/2017 10:33:40<br/>
 * 
 * @author Deft
 * @version 1.0
 */
public interface UserServiceApi {
    
    /**
     * 根據userId獲取用戶.
     * 
     * @param userId 用戶ID
     * @return User
     */
    User getUserById(String userId);

    User getActiveUserById(String userId);
}
