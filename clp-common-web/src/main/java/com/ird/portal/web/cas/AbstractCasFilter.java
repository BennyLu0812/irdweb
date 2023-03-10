package com.ird.portal.web.cas;

import java.util.List;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.jasig.cas.client.configuration.ConfigurationKey;
import org.jasig.cas.client.util.AbstractConfigurationFilter;
import org.jasig.cas.client.util.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  Abstract filter that contains code that is common to all CAS filters.
 *  <p>
 * The following filter options can be configured (either at the context-level or filter-level).
 * <ul>
 * <li><code>serverName</code> - the name of the CAS client server, in the format: localhost:8080 or localhost:8443 or localhost or https://localhost:8443</li>
 * <li><code>service</code> - the completely qualified service url, i.e. https://localhost/cas-client/app</li>
 * </ul>
 * <p>Please note that one of the two above parameters must be set.</p>
 *
 * @author Scott Battaglia
 * @version $Revision$ $Date$
 * @since 3.1
 */
public abstract class AbstractCasFilter extends AbstractConfigurationFilter {

    /** Represents the constant for where the assertion will be located in memory. */
    public static final String CONST_CAS_ASSERTION = "_const_cas_assertion_";

    /** Instance of commons logging for logging purposes. */
    protected final Logger log = LoggerFactory.getLogger(getClass());

    /** Defines the parameter to look for for the artifact. */
    protected String artifactParameterName = "ticket";

    /** Defines the parameter to look for for the service. */
    protected String serviceParameterName = "service";
    
    /** Sets where response.encodeUrl should be called on service urls when constructed. */
    protected boolean encodeServiceUrl = true;

    /**
     * The name of the server.  Should be in the following format: {protocol}:{hostName}:{port}.
     * Standard ports can be excluded. */
    protected String serverName;

    /** The exact url of the service. */
    protected String service;
    
    protected List<String> excludeUrls;

    public void init(final FilterConfig filterConfig) throws ServletException {
        super.init(filterConfig);
        if (!isIgnoreInitConfiguration()) {
            setServerName(getString(new ConfigurationKey<String>("serverName")));
//            setServerName(getPropertyFromInitParams(filterConfig, "serverName", null));
            log.trace("Loading serverName property: " + this.serverName);
            setService(getString(new ConfigurationKey<String>("service")));
//            setService(getPropertyFromInitParams(filterConfig, "service", null));
            log.trace("Loading service property: " + this.service);
            setArtifactParameterName(getString(new ConfigurationKey<String>("artifactParameterName", "ticket")));
//            setArtifactParameterName(getPropertyFromInitParams(filterConfig, "artifactParameterName", "ticket"));
            log.trace("Loading artifact parameter name property: " + this.artifactParameterName);
            setServiceParameterName(getString(new ConfigurationKey<String>("serviceParameterName", "service")));
//            setServiceParameterName(getPropertyFromInitParams(filterConfig, "serviceParameterName", "service"));
            log.trace("Loading serviceParameterName property: " + this.serviceParameterName);
            setEncodeServiceUrl(getBoolean(new ConfigurationKey<Boolean>("encodeServiceUrl", Boolean.TRUE)));
//            setEncodeServiceUrl(parseBoolean(getPropertyFromInitParams(filterConfig, "encodeServiceUrl", "true")));
            log.trace("Loading encodeServiceUrl property: " + this.encodeServiceUrl);

            initInternal(filterConfig);
        }
        init();
        
    }

    /** Controls the ordering of filter initialization and checking by defining a method that runs before the init.
     * @param filterConfig the original filter configuration.
     * @throws ServletException if there is a problem.
     *
     */
    protected void initInternal(final FilterConfig filterConfig) throws ServletException {
        // template method
    }

    /**
     * Initialization method.  Called by Filter's init method or by Spring.  Similar in concept to the InitializingBean interface's
     * afterPropertiesSet();
     */
    public void init() {
        CommonUtils.assertNotNull(this.artifactParameterName, "artifactParameterName cannot be null.");
        CommonUtils.assertNotNull(this.serviceParameterName, "serviceParameterName cannot be null.");
        CommonUtils.assertTrue(CommonUtils.isNotEmpty(this.serverName) || CommonUtils.isNotEmpty(this.service), "serverName or service must be set.");
        CommonUtils.assertTrue(CommonUtils.isBlank(this.serverName) || CommonUtils.isBlank(this.service), "serverName and service cannot both be set.  You MUST ONLY set one.");
    }

    // empty implementation as most filters won't need this.
    public void destroy() {
        // nothing to do
    }

    protected final String constructServiceUrl(final HttpServletRequest request, final HttpServletResponse response) {
        return CommonUtils.constructServiceUrl(request, response, this.service, this.serverName, this.artifactParameterName, this.encodeServiceUrl);
    }

    /**
     * Note that trailing slashes should not be used in the serverName.  As a convenience for this common misconfiguration, we strip them from the provided
     * value.
     *
     * @param serverName the serverName. If this method is called, this should not be null.  This AND service should not be both configured.
     */
    public final void setServerName(final String serverName) {
        if (serverName != null && serverName.endsWith("/")) {
            this.serverName = serverName.substring(0, serverName.length()-1);
            log.info(String.format("Eliminated extra slash from serverName [%s].  It is now [%s]", serverName, this.serverName));
        } else {
            this.serverName = serverName;
        }
    }

    public final void setService(final String service) {
        this.service = service;
    }

    public final void setArtifactParameterName(final String artifactParameterName) {
        this.artifactParameterName = artifactParameterName;
    }

    public final void setServiceParameterName(final String serviceParameterName) {
        this.serviceParameterName = serviceParameterName;
    }
    
    public final void setEncodeServiceUrl(final boolean encodeServiceUrl) {
    	this.encodeServiceUrl = encodeServiceUrl;
    }

    public final String getArtifactParameterName() {
        return this.artifactParameterName;
    }

    public final String getServiceParameterName() {
        return this.serviceParameterName;
    }
    
    public List<String> getExcludeUrls() {
        return excludeUrls;
    }

    public void setExcludeUrls(List<String> excludeUrls) {
        this.excludeUrls = excludeUrls;
    }

    public final Boolean isUrlExcluded(String url) {
        for (String excludeUrl : this.excludeUrls) {
            if (StringUtils.contains(url, excludeUrl)) {
                return true;
            }
        }
        return false;
    }
}
