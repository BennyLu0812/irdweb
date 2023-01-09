package com.ird.portal.api.service;


import com.ird.portal.common.api.data.ApiUserDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 *
 * SYS模塊管理的接口-校驗、查詢、新增、更新、刪除等.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 2021/9/7 14:43<br/>
 *
 * @author Zack
 * @version 1.0
 */
public interface SysService {

    /**
     * 登錄
     * @param loginUser
     * @param request
     * @return
     */
    Map<String, String> login(ApiUserDTO loginUser, HttpServletRequest request);

    /**
     * 登出
     * @param request
     * @return
     */
    Boolean logout(HttpServletRequest request);

}
