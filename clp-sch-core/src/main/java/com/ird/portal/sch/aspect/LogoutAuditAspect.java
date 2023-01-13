package com.ird.portal.sch.aspect;

import com.ird.portal.audit.annotation.LogoutAudit;
import com.ird.portal.common.audit.service.AuditMasterServiceApi;
import com.ird.portal.common.sys.data.LoginAuditDTO;
import com.ird.portal.sch.quartz.JobFactoryProcess;
import com.ird.portal.user.User;
import com.ird.portal.user.UserContext;
import com.ird.portal.util.IPUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class LogoutAuditAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogoutAuditAspect.class);

    @Autowired
    private AuditMasterServiceApi auditMasterServiceApi;

    @Around("@annotation(LogoutAudit)")
    public Object aroundProcess(ProceedingJoinPoint pjp, LogoutAudit LogoutAudit)
            throws Throwable {
        String funcCode = (LogoutAudit != null) ? LogoutAudit.funcCode() : null;
        Class<?> clazz = pjp.getSignature().getDeclaringType();

        logger.info("funcCode: {}", funcCode);

        LoginAuditDTO loginAuditDTO = new LoginAuditDTO();
        loginAuditDTO.setFuncCode(funcCode);
        loginAuditDTO.setHostIP(IPUtils.getHostName());
        loginAuditDTO.setHostName(IPUtils.getIpAddress());
        loginAuditDTO.setOperationTime(new Date());
        User user = UserContext.getUser();
        loginAuditDTO.setOperatorId(user != null ? user.getUserId() : JobFactoryProcess.USER_ID);
        auditMasterServiceApi.saveLoginAudit(loginAuditDTO);

        return pjp.proceed();
    }
}
