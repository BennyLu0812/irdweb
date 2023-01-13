package com.ird.portal.sys.service.impl;

import com.ird.portal.audit.annotation.LoginAudit;
import com.ird.portal.audit.annotation.LogoutAudit;
import com.ird.portal.common.user.enums.UserTypeEnum;
import com.ird.portal.sys.entity.ParamsEntity;
import com.ird.portal.sys.service.LoginService;
import com.ird.portal.sys.service.ParamsService;
import com.ird.portal.user.User;
import com.ird.portal.user.UserContext;
import com.ird.portal.user.entity.UserEntity;
import com.ird.portal.user.service.UserService;
import com.ird.portal.user.util.ADAuthUtil;
import com.ird.portal.user.util.ConstantUtil;
import com.ird.portal.user.util.IpAddressUtil;
import com.ird.portal.web.interceptor.AuthenticationInterceptor;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * login检验.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 2021/9/7 14:43<br/>
 *
 * @author Vincent
 * @version 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class LoginServiceImpl implements LoginService {
    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private UserService userService;
    @Autowired
    private ParamsService sysParamService;

    /**
     * 登錄
     * @param loginUser
     * @param request
     * @return
     */
    @LoginAudit(funcCode = "USER-LOGIN")
    @Override
    public int login(User loginUser, HttpServletRequest request) {
        int checkFlag = -1;
        if(StringUtils.isNotBlank(loginUser.getUserId()) && StringUtils.isNotBlank(loginUser.getPassword())){
            UserEntity userEntity = userService.getById(loginUser.getUserId().trim().toUpperCase());
            if(userEntity == null){
                checkFlag = -2;
            }else{
                if(!(ConstantUtil.USER_STATUS_ACTIVE.equalsIgnoreCase(userEntity.getStatus()))){
                    checkFlag = -3;
                }else{
                    if(UserTypeEnum.LOCAL.getCode().equals(userEntity.getUserType())){
                        logger.info("Local mode");
                        UserEntity entity=userService.getUser(loginUser.getUserId(),DigestUtils.md5DigestAsHex(loginUser.getPassword().getBytes()));
                        if(entity != null){
                            checkFlag = 1;
                        }
                    }else{
                        logger.info("LDAP mode");
                        ParamsEntity paramEntity1 = sysParamService.getByName("LDAP_URL");
                        ParamsEntity paramEntity2 = sysParamService.getByName("LDAP_DOMAIN_NAME");
                        String LDAP_URL = null;
                        String LDAP_DOMAIN_NAME = null;
                        if(paramEntity1 != null && StringUtils.isNotBlank(paramEntity1.getParamValue()) &&
                                paramEntity2 != null && StringUtils.isNotBlank(paramEntity2.getParamValue())){
                            LDAP_URL = paramEntity1.getParamValue().trim();
                            LDAP_DOMAIN_NAME = paramEntity2.getParamValue().trim();
                        }else{
                            LDAP_URL = ADAuthUtil.getLdapUrl();
                            LDAP_DOMAIN_NAME = ADAuthUtil.getLdapDomainName();
                        }
                        checkFlag = ADAuthUtil.auth(loginUser.getUserId().trim(), loginUser.getPassword().trim(),LDAP_URL,LDAP_DOMAIN_NAME);
                    }
                }
            }
            logger.info("Login success");
            if(userEntity != null && checkFlag == 1){
                User user = new User();
                user.setUserId(userEntity.getUserId());
                user.setUserName(userEntity.getCnName());
                user.setUserNameEn(userEntity.getEnName());
                user.setIp(IpAddressUtil.getIpAddress(request));
                user.setLocale(new AuthenticationInterceptor().resolveLocale(request));
                user.setUserType(userEntity.getUserType());

                HttpSession session = request.getSession();
                session.setAttribute(UserContext.USER_SESSION,user);
                UserContext.setUser(user);
            }
        }
        return checkFlag;
    }


     /**
     　　* @description: 登出
     　　* @return  Boolean
     　　* @throws
     　　* @author Vincent
     　　* @date 2021/9/22 16:11
     　　*/
     @LogoutAudit(funcCode = "USER-LOGOUT")
     @Override
    public Boolean logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute(UserContext.USER_SESSION);
        session.invalidate();
        UserContext.removeUser();
        if(UserContext.getUser() != null){
            return false;
        }

        return true;
    }


}
