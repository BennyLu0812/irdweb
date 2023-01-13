package com.ird.portal.sys.service;

import com.ird.portal.user.User;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * 登录，登出校验.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 2021/9/22 <br/>
 *
 * @author Vincent
 * @version 1.0
 */
public interface LoginService {

    /**
     * 登錄
     * @param user
     * @param request
     * @return
     */
    int login(User user, HttpServletRequest request);

     /**
     　　* @description: 登出
     　　* @return
     　　* @throws
     　　* @author Vincent
     　　* @date 2021/9/22 16:10
     　　*/
    Boolean logout(HttpServletRequest request);
}
