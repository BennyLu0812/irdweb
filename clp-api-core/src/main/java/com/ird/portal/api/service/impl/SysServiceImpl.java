package com.ird.portal.api.service.impl;

import com.ird.portal.api.service.SysService;
import com.ird.portal.common.api.data.ApiUserDTO;
import com.ird.portal.sys.service.LoginService;
import com.ird.portal.user.User;
import com.ird.portal.user.UserContext;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
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
@Service
@Transactional(rollbackFor = Exception.class)
public class SysServiceImpl implements SysService {
    private static final Logger logger = LoggerFactory.getLogger(SysServiceImpl.class);

    @Autowired
    private LoginService loginService;

    /**
     * 登錄
     * @param loginUser
     * @param request
     * @return
     */
    @Override
    public Map<String, String> login(ApiUserDTO loginUser, HttpServletRequest request) {
        Map<String, String> returnUser = new HashMap<>();
        returnUser.put("result", "200");
        //校驗參數是否爲空
        if(StringUtils.isBlank(loginUser.getUserId()) || StringUtils.isBlank(loginUser.getPassword())){
            returnUser.put("result", "500");
            returnUser.put("resultMsg", "參數爲空");
            return returnUser;
        }
        logger.info("loginUser:{}", loginUser.toString());

        User user = UserContext.getUser();
        HttpSession session = request.getSession();
        session.setAttribute(UserContext.USER_SESSION,user);
        returnUser.put("userId", user.getUserId());
        returnUser.put("usernameCn", user.getUserName());
        returnUser.put("usernameEn", user.getUserNameEn());

        return returnUser;
    }

    @Override
    public Boolean logout(HttpServletRequest request) {
        return loginService.logout(request);
    }

    /**
     * 登錄user參數轉換成實際user
     * @param userDTO
     * @return
     */
    public User mapToUser(ApiUserDTO userDTO){
        User user = new User();
        user.setUserId(userDTO.getUserId());
        user.setPassword(userDTO.getPassword());
        return user;
    }
}
