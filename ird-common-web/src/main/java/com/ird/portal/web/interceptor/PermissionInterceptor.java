package com.ird.portal.web.interceptor;

import com.ird.portal.audit.AuditContext;
import com.ird.portal.audit.annotation.AuditRequest;
import com.ird.portal.exception.AuthorizationException;
import com.ird.portal.user.User;
import com.ird.portal.user.UserAccessResourceContext;
import com.ird.portal.user.UserContext;
import com.ird.portal.util.HttpServletRequestUtil;
import com.ird.portal.util.SysParamsConstant;
import com.ird.portal.web.security.annotion.PreAuthorize;
import com.ird.portal.web.thymeleaf.security.auth.AuthUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 權限攔截器，一般地，在Controller的方法上使用@PreAuthorize("hasPermission('DLS-USER-ADD')")，即可實現對方法的權限控制
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 05/12/2017 10:39:53<br/>
 * 
 * @author Deft
 * @version 1.0
 */
public class PermissionInterceptor extends AbstractHandlerInterceptorAdapter {
    
    private static final Logger logger = LoggerFactory.getLogger(PermissionInterceptor.class);
    
    private static final int AUTH_BYPASS_TRUE_VALUE = 1;
    private static final String SYS_AUTH_BYPASS = "SYS_AUTH_BYPASS";
    
    @Override
    public boolean preHandleTwo(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {
        
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        
        AuditRequest auditedRequest = handlerMethod.getMethodAnnotation(AuditRequest.class);
        logger.info("handlerMethod: {} is present annotation 'auditedRequest': {}",
            handlerMethod,
            (auditedRequest != null));
        
        if (auditedRequest != null) {
            String funcCode = auditedRequest.funcCode();
            AuditContext auditContext = AuditContext.getInstance();
            auditContext.setUserId(UserContext.getUser() != null ? UserContext.getUser().getUserId() : null);
            auditContext.setFuncCode(funcCode);
            auditContext.setIsAudited(true);
            auditContext.setHostIP(request.getRemoteAddr());
            auditContext.setHostName(request.getRemoteHost());
        }
        
        PreAuthorize authorize = handlerMethod.getMethodAnnotation(PreAuthorize.class);
        if (authorize != null && StringUtils.isNotBlank(authorize.value())) {
            User authentication = UserContext.getUser();
            
            if (isAuthByPass()) {
                return true;
            }
            
            boolean result = AuthUtils.authorizeUsingAccessExpression(authorize.value(), authentication);
            if (result) {
                // 有權限->放行
                return true;
            }
            
            UserAccessResourceContext.set(authorize.value());
            
            String funcCode = authorize.value().replaceAll("\\w+\\(", "").replaceAll("\\)\\w?", "");
            logger.warn("The system denies user '{}' access to resource {}", authentication.getUserId(), funcCode);
            
            if (HttpServletRequestUtil.isAjaxRequest(request)) {
                throw new AuthorizationException(authentication.getUserId(), authorize.value());
            } else {
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                response.sendError(HttpServletResponse.SC_FORBIDDEN);
                return false;
            }
        }
        return true;
    }
    
    /**
     * 是否繞過權限驗證
     * @return
     */
    private boolean isAuthByPass() {
        Integer authByPassValue = SysParamsConstant.getParamIntValue(SYS_AUTH_BYPASS);
        logger.info("authByPassValue: {}", authByPassValue);
        return authByPassValue == null ? false : (authByPassValue.intValue() == AUTH_BYPASS_TRUE_VALUE);
    }
    
}
