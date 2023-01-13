/**
 * @Project Name: dls-common-web
 * @File Name: AuthUtils.java
 * @Date: 17/12/2017 20:30:42
 * @Copyright: Copyright (c) 2017 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.web.thymeleaf.security.auth;

import com.ird.portal.common.user.service.AuthorizeServiceApi;
import com.ird.portal.user.User;
import com.ird.portal.util.SpringContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * Auth Util類,使用 SPEL執行AuthorizeServiceApi的方法,此處以後豐富擴展,先暫時call對象，以後添加 or and 複雜邏輯.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 17/12/2017 20:30:42<br/>
 * 
 * @author Jim
 * @version 1.0
 */
public class AuthUtils {
    
    private static final Logger logger = LoggerFactory.getLogger(AuthUtils.class);
    
    public static final String AUTHORIZE_SERVICE = "AuthorizeServiceApi";
    
    private static StandardEvaluationContext evaluationContext;
    
    private static ExpressionParser expressionParser = new SpelExpressionParser();
    
    public static boolean authorizeUsingAccessExpression(final String accessExpression, final User authentication) {
        if (evaluationContext == null) {
            evaluationContext = new StandardEvaluationContext();
            evaluationContext.setVariable(AUTHORIZE_SERVICE, SpringContextUtil.getBean(AuthorizeServiceApi.class));
        }
        try {
            boolean evaluatedResult = expressionParser.parseExpression("#" + AUTHORIZE_SERVICE + "." + accessExpression)
                .getValue(evaluationContext, Boolean.class)
                .booleanValue();
            
            logger.info("System evaluates user '{}' with expression {} as {}",
                authentication.getUserId(),
                accessExpression,
                evaluatedResult);
            
            return evaluatedResult;
        }
        catch (Exception e) {
            logger.error("DLS安全框架在執行表達式 " + accessExpression + " 錯誤.", e);
            return false;
        }
        
    }
}
