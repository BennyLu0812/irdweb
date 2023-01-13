package com.ird.portal.sch.aspect;

import com.ird.portal.audit.annotation.LoginAudit;
import com.ird.portal.common.audit.service.AuditMasterServiceApi;
import com.ird.portal.common.sys.data.LoginAuditDTO;
import com.ird.portal.sch.quartz.JobFactoryProcess;
import com.ird.portal.user.User;
import com.ird.portal.user.UserContext;
import com.ird.portal.util.IPUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class LoginAuditAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoginAuditAspect.class);

    @Autowired
    private AuditMasterServiceApi auditMasterServiceApi;

    @After("@annotation(LoginAudit)")
    public void aroundProcess(JoinPoint joinPoint, LoginAudit LoginAudit)
            throws Throwable {
        String funcCode = (LoginAudit != null) ? LoginAudit.funcCode() : null;
        Class<?> clazz = joinPoint.getSignature().getDeclaringType();
        logger.info("funcCode: {}", funcCode);
        LoginAuditDTO loginAuditDTO = new LoginAuditDTO();
        loginAuditDTO.setFuncCode(funcCode);
        loginAuditDTO.setHostIP(IPUtils.getHostName());
        loginAuditDTO.setHostName(IPUtils.getIpAddress());
        loginAuditDTO.setOperationTime(new Date());
        User user = UserContext.getUser();
        loginAuditDTO.setOperatorId(user != null ? user.getUserId() : JobFactoryProcess.USER_ID);
        auditMasterServiceApi.saveLoginAudit(loginAuditDTO);
    }
}
