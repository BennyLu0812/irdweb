/**
 * @Project Name: dls-common-api
 * @File Name: AuthorizeServiceApi.java
 * @Date: 17/12/2017 20:47:53
 * @Copyright: Copyright (c) 2017 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.common.user.service;

import java.util.Set;

/**
 * 授權-安全權限的API.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 17/12/2017 20:47:53<br/>
 * 
 * @author Jim
 * @version 1.0
 */
public interface AuthorizeServiceApi {
    
    /**
     * 表示當前用戶是否已經登陸認證成功. HTML用法:
     * 
     * <pre>
     * &ltdiv sec:authorize="isAuthenticated()"&gt
     *     用戶登陸認證成功
     * &lt/div&gt
     * </pre>
     * 
     * @return true: 已經登陸認證成功; false: 授權認證失敗.
     */
    boolean isAuthenticated();
    
    /**
     * 當前用戶是否是一個匿名用戶.
     * 
     * <pre>
     * &ltdiv sec:authorize="isAnonymous()"&gt
     *     匿名用戶
     * &lt/div&gt
     * </pre>
     * 
     * @return true: 當前用戶是匿名的;否則不是.
     */
    boolean isAnonymous();
    
    /**
     * 當前用戶是否擁有指定角色. hasRole([role])
     * 
     * <pre>
     * &ltdiv sec:authorize="hasRole('ADMIN')"&gt 用戶有ADMIN角色的權限了 &lt/div&gt
     * </pre>
     * 
     * @param role 角色名稱
     * 
     */
    boolean hasRole(String role);
    
    /**
     * 多個角色是一個以逗號進行分割的字符串，如果當前用戶擁有制定角色中的任意一個則返回ture. hasAnyRole([role1,role2])
     * 
     * <pre>
     * &ltdiv sec:authorize="hasAnyRole('ADMIN','ROLE1','ROLE2',...)"&gt 
     *     當前用戶有ADMIN,ROLE1,ROLE2,... 等角色的權限了 
     * &lt/div&gt
     * </pre>
     * 
     * @param 角色名稱.
     */
    boolean hasAnyRole(String... roles);
    
    /**
     * 檢查當前用戶是否有此功能訪問的權限.
     * 
     * <pre>
     * &ltdiv sec:authorize="hasPermission('permissionName')"&gt 
     *     &ltbutton&gt操作按鈕-新增-更新-刪除&lt/button&gt
     * &lt/div&gt
     * </pre>
     * 
     * @param 權限名稱.
     * @return true: 有權限，否則沒有.
     */
    boolean hasPermission(String permission);
    
    public Set<String> getFuncCodesByUserId(String userId);
    
}
