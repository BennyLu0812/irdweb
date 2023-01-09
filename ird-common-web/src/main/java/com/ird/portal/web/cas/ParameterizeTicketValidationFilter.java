package com.ird.portal.web.cas;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.jasig.cas.client.configuration.ConfigurationKey;
import org.jasig.cas.client.util.CommonUtils;
import org.jasig.cas.client.validation.Assertion;
import org.jasig.cas.client.validation.TicketValidationException;
import org.jasig.cas.client.validation.TicketValidator;

public class ParameterizeTicketValidationFilter extends AbstractCasFilter {
    
    private TicketValidator ticketValidator;
    
    private boolean redirectAfterValidation = true;
    
    private boolean exceptionOnValidationFailure = true;
    
    private boolean useSession = true;
    
    private String invalidServicePattern;
    
    private static String parameterPattern = "?";
    
    protected TicketValidator getTicketValidator(FilterConfig filterConfig) {
        return this.ticketValidator;
    }
    
//    protected HostnameVerifier getHostnameVerifier(FilterConfig filterConfig) {
//        String className = getPropertyFromInitParams(filterConfig, "hostnameVerifier", null);
//        this.log.trace("Using hostnameVerifier parameter: " + className);
//        String config = getPropertyFromInitParams(filterConfig, "hostnameVerifierConfig", null);
//        this.log.trace("Using hostnameVerifierConfig parameter: " + config);
//        if (className != null) {
//            if (config != null) {
//                return (HostnameVerifier)ReflectUtils.newInstance(className, new Object[] {config});
//            }
//            return (HostnameVerifier)ReflectUtils.newInstance(className, new Object[0]);
//        }
//        return null;
//    }
    
    protected void initInternal(FilterConfig filterConfig)
        throws ServletException {
        setInvalidServicePattern(getString(new ConfigurationKey<String>("invalidServicePattern")));
        this.log.trace("Loaded invalidServicePattern parameter: " + this.invalidServicePattern);
        setExceptionOnValidationFailure(getBoolean(new ConfigurationKey<Boolean>("exceptionOnValidationFailure", Boolean.TRUE)));
//        setExceptionOnValidationFailure(parseBoolean(getPropertyFromInitParams(filterConfig, "exceptionOnValidationFailure", "true")));
        this.log.trace("Setting exceptionOnValidationFailure parameter: " + this.exceptionOnValidationFailure);
        setRedirectAfterValidation(getBoolean(new ConfigurationKey<Boolean>("redirectAfterValidation", Boolean.TRUE)));
//        setRedirectAfterValidation(parseBoolean(getPropertyFromInitParams(filterConfig, "redirectAfterValidation", "true")));
        this.log.trace("Setting redirectAfterValidation parameter: " + this.redirectAfterValidation);
        setUseSession(getBoolean(new ConfigurationKey<Boolean>("useSession", Boolean.TRUE)));
//        setUseSession(parseBoolean(getPropertyFromInitParams(filterConfig, "useSession", "true")));
        this.log.trace("Setting useSession parameter: " + this.useSession);
        setTicketValidator(getTicketValidator(filterConfig));
        super.initInternal(filterConfig);
    }
    
    public void init() {
        super.init();
        CommonUtils.assertNotNull(this.ticketValidator, "ticketValidator cannot be null.");
    }
    
    protected boolean preFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
        throws IOException, ServletException {
        return true;
    }
    
    protected void onSuccessfulValidation(HttpServletRequest request, HttpServletResponse response, Assertion assertion) {
    }
    
    public final void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
        throws IOException, ServletException {
               
        if (!preFilter(servletRequest, servletResponse, filterChain)) {
            return;
        }
        
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        
        //Check url, if match exclude pattern, skip and proceed to next filter
        if (isUrlExcluded(request.getRequestURI())) {
            if (log.isInfoEnabled()) {
                log.info("isUrlExcluded::{}", isUrlExcluded(request.getRequestURI()));
            }
            filterChain.doFilter(request, response);
            return;
        }
        
//        HttpServletRequest request = (HttpServletRequest)servletRequest;
//        HttpServletResponse response = (HttpServletResponse)servletResponse;
        
        // String contextPath = request.getContextPath();
        // String casServiceKey = "cas3.service." + StringUtils.substring(contextPath, 1);
        // String service = ConfigProperties.getProperty(casServiceKey);
        // setService(service);
        
        final String ticket = CommonUtils.safeGetParameter(request, getArtifactParameterName());
        if (CommonUtils.isNotBlank(ticket)) {
            if (this.log.isDebugEnabled()) {
                this.log.debug("Attempting to validate ticket: " + ticket);
            }
            try {
                // String constructServiceUrl =
                // request.getRequestURL().toString();
                // int blIndex = constructServiceUrl.indexOf(":80/");
                // if (blIndex > 0) {
                // constructServiceUrl = constructServiceUrl.substring(0,
                // blIndex) + constructServiceUrl.substring(blIndex +
                // ":80/".length() - 1);
                // if (this.log.isDebugEnabled()) {
                // this.log.debug("Constructed constructServiceUrl url: " +
                // constructServiceUrl);
                // }
                // }
                // String protocol =
                // ConfigProperties.getProperty("cas3.protocol");
                // int httpIndex = constructServiceUrl.indexOf("://");
                // if (httpIndex > 0) {
                // constructServiceUrl = protocol +
                // constructServiceUrl.substring(httpIndex);
                // }
                // String queryString = request.getQueryString();
                // if (CommonUtils.isNotBlank(queryString)) {
                // constructServiceUrl =
                // constructServiceUrl.replaceAll(queryString, "");
                // }
                
                String constructServiceUrl = CommonUtils.constructServiceUrl(request, response, this.service, this.serverName, this.artifactParameterName, this.encodeServiceUrl);
                log.info("serviceUrl: {}", constructServiceUrl);
                
                int invalidServicePatternIndex = StringUtils.indexOf(constructServiceUrl, this.invalidServicePattern);
                if (invalidServicePatternIndex > 0) {
                    String removedPart = constructServiceUrl.substring(invalidServicePatternIndex);
                	constructServiceUrl = constructServiceUrl.substring(0, invalidServicePatternIndex);
                    int parameterPatternIndex = StringUtils.indexOf(removedPart, parameterPattern);
                    if (parameterPatternIndex > 0) {
                    	constructServiceUrl += removedPart.substring(parameterPatternIndex);
                    }
                	log.info("Remove invalidServicePattern: {}, modified constructServiceUrl:{}", this.invalidServicePattern, constructServiceUrl);
                }
                
                Assertion assertion = this.ticketValidator.validate(ticket, constructServiceUrl);
                if (this.log.isDebugEnabled()) {
                    this.log.debug("Successfully authenticated user: " + assertion.getPrincipal().getName());
                }
                request.setAttribute(CONST_CAS_ASSERTION, assertion);
                if (this.useSession) {
                    log.info("useSession ::{}", assertion);
                    request.getSession().setAttribute(CONST_CAS_ASSERTION, assertion);
                }
                onSuccessfulValidation(request, response, assertion);
                if (this.redirectAfterValidation) {
                    this.log.debug("Redirecting after successful ticket validation.");
                    response.sendRedirect(constructServiceUrl);
                    return;
                }
            }
            catch (TicketValidationException e) {
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                response.sendError(HttpServletResponse.SC_FORBIDDEN);
                
                log.warn("TicketValidationException is error.", e);
                return;
//                throw new ServletException(e);
            }
        }
        filterChain.doFilter(request, response);
    }
    
    public final void setTicketValidator(TicketValidator ticketValidator) {
        this.ticketValidator = ticketValidator;
    }
    
    public final void setRedirectAfterValidation(boolean redirectAfterValidation) {
        this.redirectAfterValidation = redirectAfterValidation;
    }
    
    public final void setExceptionOnValidationFailure(boolean exceptionOnValidationFailure) {
        this.exceptionOnValidationFailure = exceptionOnValidationFailure;
    }
    
    public final void setUseSession(boolean useSession) {
        this.useSession = useSession;
    }
    
	public final String getInvalidServicePattern() {
		return invalidServicePattern;
	}

	public final void setInvalidServicePattern(String invalidServicePattern) {
		this.invalidServicePattern = invalidServicePattern;
	}
}
