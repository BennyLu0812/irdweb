/**
 * @Project Name: dls-common-web
 * @File Name: HandlerInterceptorAdapter.java
 * @Date: 20/12/2017 00:15:17
 * @Copyright: Copyright (c) 2017 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.web.interceptor;


import com.ird.portal.audit.AuditContext;
import com.ird.portal.user.User;
import com.ird.portal.user.UserContext;
import com.ird.portal.web.error.ErrorRestResponseController;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 抽象的HandlerInterceptorAdapter，作一些公共的處理之用
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 20/12/2017 00:15:17<br/>
 * 
 * @author Jim
 * @version 1.0
 */
public abstract class AbstractHandlerInterceptorAdapter
    extends org.springframework.web.servlet.handler.HandlerInterceptorAdapter {

    /**
     * This implementation always returns {@code true}.
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        HttpStatus status = ErrorRestResponseController.getStatus(request);
        if (status.value() != HttpStatus.OK.value()) {
            response.setStatus(status.value());
            return true;
        }

        return preHandleTwo(request, response, handler);
    }

    public abstract boolean preHandleTwo(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception;

    /**
     * 攔截器處理完畢時回調此方法
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        super.afterCompletion(request, response, handler, ex);

        // 從ThreadLocal<User>中取得當前線程的User，然後request.setAttribute("user", user)，則下個View可取得${user}
        User user = UserContext.getUser();
        request.setAttribute("user", user);

        // 清除ThreadLocal<User>內佔用的資源
        UserContext.removeUser();
        AuditContext.getInstance().remove();
    }
}
