package com.ird.portal.sch.aspect;

import com.ird.portal.audit.AuditContext;
import com.ird.portal.audit.annotation.AuditRequest;
import com.ird.portal.sch.Task;
import com.ird.portal.sch.quartz.JobFactoryProcess;
import com.ird.portal.user.User;
import com.ird.portal.user.UserContext;
import com.ird.portal.util.IPUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class AuditAspect {
    
    private static final Logger logger = LoggerFactory.getLogger(AuditAspect.class);
    
    @Around("@annotation(AuditRequest)")
    public Object aroundProcess(ProceedingJoinPoint pjp, AuditRequest AuditRequest)
        throws Throwable {
        String funcCode = (AuditRequest != null) ? AuditRequest.funcCode() : null;
        Class<?> clazz = pjp.getSignature().getDeclaringType();
        
        logger.info("funcCode: {}", funcCode);
        
        if (StringUtils.isNoneBlank(funcCode) && Task.class.isAssignableFrom(clazz)) {
            AuditContext auditContext = AuditContext.getInstance();
            User user = UserContext.getUser();
			auditContext.setUserId(user != null ? user.getUserId() : JobFactoryProcess.USER_ID);
            auditContext.setFuncCode(funcCode);
            auditContext.setIsAudited(true);
            auditContext.setHostIP(IPUtils.getHostName());
            auditContext.setHostName(IPUtils.getIpAddress());
        }
        return pjp.proceed();
    }
    
    
}
