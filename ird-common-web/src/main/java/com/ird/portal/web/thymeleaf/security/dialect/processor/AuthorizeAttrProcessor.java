package com.ird.portal.web.thymeleaf.security.dialect.processor;

import com.ird.portal.user.UserContext;
import com.ird.portal.web.thymeleaf.security.auth.AuthUtils;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.context.IWebContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.exceptions.ConfigurationException;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.standard.processor.AbstractStandardConditionalVisibilityTagProcessor;
import org.thymeleaf.templatemode.TemplateMode;

/**
 * Renders the element children (*tag content*) if the authenticated user is authorized to see it according to the
 * specified <i>Spring Security expression</i>.
 * 
 * @author Daniel Fern&aacute;ndez
 */
public final class AuthorizeAttrProcessor extends AbstractStandardConditionalVisibilityTagProcessor {
    
    public static final int ATTR_PRECEDENCE = 300;
    
    public static final String ATTR_NAME = "authorize";
    
    public AuthorizeAttrProcessor(final TemplateMode templateMode, final String dialectPrefix, final String attrName) {
        super(templateMode, dialectPrefix, attrName, ATTR_PRECEDENCE);
    }
    
    @Override
    protected boolean isVisible(final ITemplateContext context, final IProcessableElementTag tag, final AttributeName attributeName, final String attributeValue) {
        
        final String attrValue = (attributeValue == null ? null : attributeValue.trim());
        
        if (attrValue == null || attrValue.length() == 0) {
            return false;
        }
        
        if (!(context instanceof IWebContext)) {
            throw new ConfigurationException(
                "Thymeleaf execution context is not a web context (implementation of " + IWebContext.class.getName() + "). Spring Security integration can only be used in "
                    + "web environments.");
        }
        boolean result = AuthUtils.authorizeUsingAccessExpression(attrValue, UserContext.getUser());
        
        return result;
    }
    
}