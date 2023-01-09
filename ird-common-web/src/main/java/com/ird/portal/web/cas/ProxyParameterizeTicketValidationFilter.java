package com.ird.portal.web.cas;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.BooleanUtils;
import org.jasig.cas.client.configuration.ConfigurationKey;
import org.jasig.cas.client.proxy.AbstractEncryptedProxyGrantingTicketStorageImpl;
import org.jasig.cas.client.proxy.Cas20ProxyRetriever;
import org.jasig.cas.client.proxy.CleanUpTimerTask;
import org.jasig.cas.client.proxy.ProxyGrantingTicketStorage;
import org.jasig.cas.client.proxy.ProxyGrantingTicketStorageImpl;
import org.jasig.cas.client.util.CommonUtils;
import org.jasig.cas.client.util.ReflectUtils;
import org.jasig.cas.client.validation.Cas20ProxyTicketValidator;
import org.jasig.cas.client.validation.Cas20ServiceTicketValidator;
import org.jasig.cas.client.validation.TicketValidator;

public class ProxyParameterizeTicketValidationFilter extends ParameterizeTicketValidationFilter {
    private static final String[] RESERVED_INIT_PARAMS = { "proxyGrantingTicketStorageClass", "proxyReceptorUrl", "acceptAnyProxy", "allowedProxyChains", "casServerUrlPrefix", "proxyCallbackUrl", "renew",
            "exceptionOnValidationFailure", "redirectAfterValidation", "useSession", "serverName", "service", "artifactParameterName", "serviceParameterName", "encodeServiceUrl", "millisBetweenCleanUps",
            "hostnameVerifier", "encoding", "config" };
    private static final int DEFAULT_MILLIS_BETWEEN_CLEANUPS = 60000;
    private String proxyReceptorUrl;
    private Timer timer;
    private TimerTask timerTask;
    private int millisBetweenCleanUps;
    private ProxyGrantingTicketStorage proxyGrantingTicketStorage = new ProxyGrantingTicketStorageImpl();

    protected void initInternal(FilterConfig filterConfig) throws ServletException {
        setProxyReceptorUrl(getString(new ConfigurationKey<String>("proxyReceptorUrl")));
//        setProxyReceptorUrl(getPropertyFromInitParams(filterConfig, "proxyReceptorUrl", null));

        String proxyGrantingTicketStorageClass = getString(new ConfigurationKey<String>("proxyGrantingTicketStorageClass"));
//        String proxyGrantingTicketStorageClass = getPropertyFromInitParams(filterConfig, "proxyGrantingTicketStorageClass", null);
        if (proxyGrantingTicketStorageClass != null) {
            this.proxyGrantingTicketStorage = ((ProxyGrantingTicketStorage) ReflectUtils.newInstance(proxyGrantingTicketStorageClass, new Object[0]));
            if ((this.proxyGrantingTicketStorage instanceof AbstractEncryptedProxyGrantingTicketStorageImpl)) {
                AbstractEncryptedProxyGrantingTicketStorageImpl p = (AbstractEncryptedProxyGrantingTicketStorageImpl) this.proxyGrantingTicketStorage;
                String cipherAlgorithm = getString(new ConfigurationKey<String>("cipherAlgorithm", "DESede"));
                String secretKey = getString(new ConfigurationKey<String>("secretKey"));
//                String cipherAlgorithm = getPropertyFromInitParams(filterConfig, "cipherAlgorithm", "DESede");
//                String secretKey = getPropertyFromInitParams(filterConfig, "secretKey", null);

                p.setCipherAlgorithm(cipherAlgorithm);
                try {
                    if (secretKey != null) {
                        p.setSecretKey(secretKey);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        this.log.trace("Setting proxyReceptorUrl parameter: " + this.proxyReceptorUrl);
        this.millisBetweenCleanUps = getInt(new ConfigurationKey<Integer>("millisBetweenCleanUps", 60000));
//        this.millisBetweenCleanUps = Integer.parseInt(getPropertyFromInitParams(filterConfig, "millisBetweenCleanUps", Integer.toString(60000)));
        super.initInternal(filterConfig);
    }

    public void init() {
        super.init();
        CommonUtils.assertNotNull(this.proxyGrantingTicketStorage, "proxyGrantingTicketStorage cannot be null.");
        if (this.timer == null) {
            this.timer = new Timer(true);
        }
        if (this.timerTask == null) {
            this.timerTask = new CleanUpTimerTask(this.proxyGrantingTicketStorage);
        }
        this.timer.schedule(this.timerTask, this.millisBetweenCleanUps, this.millisBetweenCleanUps);
    }

    protected final TicketValidator getTicketValidator(FilterConfig filterConfig) {
        String allowAnyProxy = getString(new ConfigurationKey<String>("acceptAnyProxy"));
        String allowedProxyChains = getString(new ConfigurationKey<String>("allowedProxyChains"));
        String casServerUrlPrefix = getString(new ConfigurationKey<String>("casServerUrlPrefix"));
        
//        String allowAnyProxy = getPropertyFromInitParams(filterConfig, "acceptAnyProxy", null);
//        String allowedProxyChains = getPropertyFromInitParams(filterConfig, "allowedProxyChains", null);
//        String casServerUrlPrefix = getPropertyFromInitParams(filterConfig, "casServerUrlPrefix", null);
        Cas20ServiceTicketValidator validator;
        if ((CommonUtils.isNotBlank(allowAnyProxy)) || (CommonUtils.isNotBlank(allowedProxyChains))) {
            Cas20ProxyTicketValidator v = new Cas20ProxyTicketValidator(casServerUrlPrefix);
            v.setAcceptAnyProxy(BooleanUtils.toBoolean(allowAnyProxy));
//            v.setAcceptAnyProxy(parseBoolean(allowAnyProxy));
            v.setAllowedProxyChains(CommonUtils.createProxyList(allowedProxyChains));
            validator = v;
        } else {
            validator = new Cas20ServiceTicketValidator(casServerUrlPrefix);
        }
        validator.setProxyCallbackUrl(getString(new ConfigurationKey<String>("proxyCallbackUrl")));
//        validator.setProxyCallbackUrl(getPropertyFromInitParams(filterConfig, "proxyCallbackUrl", null));
        validator.setProxyGrantingTicketStorage(this.proxyGrantingTicketStorage);
        validator.setProxyRetriever(new Cas20ProxyRetriever(casServerUrlPrefix, getString(new ConfigurationKey<String>("encoding"))));
//        validator.setProxyRetriever(new Cas20ProxyRetriever(casServerUrlPrefix, getPropertyFromInitParams(filterConfig, "encoding", null)));
//        validator.setRenew(parseBoolean(getPropertyFromInitParams(filterConfig, "renew", "false")));
//        validator.setEncoding(getPropertyFromInitParams(filterConfig, "encoding", null));
        
        validator.setRenew(getBoolean(new ConfigurationKey<Boolean>("renew", Boolean.FALSE)));
        validator.setEncoding(getString(new ConfigurationKey<String>("encoding")));

        Map<String, String> additionalParameters = new HashMap();
        List<String> params = Arrays.asList(RESERVED_INIT_PARAMS);

        Enumeration<?> e = filterConfig.getInitParameterNames();
        while (e.hasMoreElements()) {
            String s = (String) e.nextElement();
            if (!params.contains(s)) {
                additionalParameters.put(s, filterConfig.getInitParameter(s));
            }
        }
        validator.setCustomParameters(additionalParameters);
//        validator.setHostnameVerifier(getHostnameVerifier(filterConfig));

        return validator;
    }

    public void destroy() {
        super.destroy();
        this.timer.cancel();
    }

    protected final boolean preFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String requestUri = request.getRequestURI();
        if ((CommonUtils.isEmpty(this.proxyReceptorUrl)) || (!requestUri.endsWith(this.proxyReceptorUrl))) {
            return true;
        }
        try {
            CommonUtils.readAndRespondToProxyReceptorRequest(request, response, this.proxyGrantingTicketStorage);
        } catch (RuntimeException e) {
            this.log.error(e.getMessage(), e);
            throw e;
        }
        return false;
    }

    public final void setProxyReceptorUrl(String proxyReceptorUrl) {
        this.proxyReceptorUrl = proxyReceptorUrl;
    }

    public void setProxyGrantingTicketStorage(ProxyGrantingTicketStorage storage) {
        this.proxyGrantingTicketStorage = storage;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public void setTimerTask(TimerTask timerTask) {
        this.timerTask = timerTask;
    }

    public void setMillisBetweenCleanUps(int millisBetweenCleanUps) {
        this.millisBetweenCleanUps = millisBetweenCleanUps;
    }
}
