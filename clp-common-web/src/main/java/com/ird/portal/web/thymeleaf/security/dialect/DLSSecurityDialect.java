package com.ird.portal.web.thymeleaf.security.dialect;

import com.ird.portal.web.thymeleaf.security.dialect.processor.AuthorizeAttrProcessor;
import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.dialect.IProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.templatemode.TemplateMode;

import java.util.LinkedHashSet;
import java.util.Set;


/**
 * 
 * DLS的權限安全框架.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 15/12/2017 20:06:53<br/>
 * @author Jim
 * @version 1.0
 */
public class DLSSecurityDialect extends AbstractDialect implements IProcessorDialect {
    
    public static final String NAME = "DLSSecurity";
    
    /**
     * 權限標籤的前綴
     */
    public static final String DEFAULT_PREFIX = "sec";
    
    public static final int PROCESSOR_PRECEDENCE = 800;
    
    public DLSSecurityDialect() {
        super(NAME);
    }
    
    public String getPrefix() {
        return DEFAULT_PREFIX;
    }
    
    public int getDialectProcessorPrecedence() {
        return PROCESSOR_PRECEDENCE;
    }
    
    @Override
    public Set<IProcessor> getProcessors(String dialectPrefix) {
        
        Set<IProcessor> processors = new LinkedHashSet<IProcessor>();
        
        TemplateMode[] templateModes = new TemplateMode[] {TemplateMode.HTML, TemplateMode.XML, TemplateMode.TEXT,
            TemplateMode.JAVASCRIPT, TemplateMode.CSS};
        
        for (final TemplateMode templateMode : templateModes) {
            
            // synonym (sec:authorize = sec:authorize-expr) for similarity with
            // "authorize-url" and "autorize-acl"
            processors.add(new AuthorizeAttrProcessor(templateMode, dialectPrefix, AuthorizeAttrProcessor.ATTR_NAME));
            
        }
        
        return processors;
    }
    
}
