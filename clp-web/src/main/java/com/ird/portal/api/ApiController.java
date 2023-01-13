package com.ird.portal.api;

import com.ird.portal.api.service.SysService;
import com.ird.portal.common.api.data.ApiUserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

/**
 *
 * 對外API controller （與其他模塊無關的API）
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 2021/9/7 14:43<br/>
 *
 * @author Zack
 * @version 1.0
 */
@Controller
@RequestMapping("/api/v1")
public class ApiController {
    private static final Logger logger = LoggerFactory.getLogger(ApiController.class);

    @Autowired
    private SysService sysService;



    /**
     * 登錄
     * @param user
     * @param request
     * @param response
     */
    @PostMapping(path = "/login")
    @ResponseBody
    public Map<String, String> login(@RequestBody ApiUserDTO user, HttpServletRequest request, HttpServletResponse response) {
        logger.debug("login start : {}", new Date());
        Map<String, String> returnUser = sysService.login(user, request);
        logger.debug("login end : {}", new Date());
        return returnUser;
    }

    /**
     * 登出
     * @param request
     * @return
     */
    @GetMapping(path = "/logout")
    @ResponseBody
    public Boolean logout(HttpServletRequest request) {
        logger.debug("logout start : {}", new Date());
        boolean isSuccess = sysService.logout(request);
        logger.debug("logout end : {}", new Date());

        return isSuccess;
    }






}
