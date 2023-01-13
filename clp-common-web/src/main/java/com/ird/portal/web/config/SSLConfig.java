/**
 * @Project Name: dls-common-web
 * @File Name: SSLConfig.java
 * @Date: 2017年11月9日 下午5:22:00
 * @Copyright: Copyright (c) 2017 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.web.config;

import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

/**
 * 
 * SSL的配置，主要用於https的訪問配置.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 29/03/2018 14:57:41<br/>
 * 
 * @author Jim
 * @version 1.0
 */
@Configuration
@ConfigurationProperties(prefix = "ssl")
public class SSLConfig {
    
    private boolean skip = false;
    
    private List<KeyStoreInfo> keyStoreInfo = new ArrayList<>();
    
    public List<KeyStoreInfo> getKeyStoreInfo() {
        return keyStoreInfo;
    }
    
    public void setKeyStoreInfo(List<KeyStoreInfo> keyStoreInfo) {
        this.keyStoreInfo = keyStoreInfo;
    }
    
    public boolean isSkip() {
        return skip;
    }
    
    public void setSkip(boolean skip) {
        this.skip = skip;
    }
    
    @PostConstruct
    public void httpsInit()
        throws Exception {
        if (!isSkip()) {
            SSLContext sslcontext = SSLContext.getInstance("TLS");
            
            List<TrustManager> trustManagerList = new ArrayList<>();
            List<String> hostnameList = new ArrayList<>();
            for (KeyStoreInfo info : keyStoreInfo) {
                
                TrustManager trustManager = new MyX509TrustManager(info.getKeystorePath(), info.getKeyPassword());
                trustManagerList.add(trustManager);
                
                hostnameList.add(info.getHostname());
                
            }
            
            sslcontext.init(null, trustManagerList.toArray(new TrustManager[trustManagerList.size()]), null);
            HttpsURLConnection.setDefaultSSLSocketFactory(sslcontext.getSocketFactory());
            
            // 实例化主机名验证接口
            HostnameVerifier hnv = new MyHostnameVerifier(hostnameList.toArray(new String[hostnameList.size()]));
            HttpsURLConnection.setDefaultHostnameVerifier(hnv);
        } else {
            SSLContext sslcontext = SSLContext.getInstance("TLS");
            sslcontext.init(null, new TrustManager[] {new SkipX509TrustManager()}, null);
            HttpsURLConnection.setDefaultSSLSocketFactory(sslcontext.getSocketFactory());
            
            // 实例化主机名验证接口
            HostnameVerifier hnv = new SkipHostnameVerifier();
            HttpsURLConnection.setDefaultHostnameVerifier(hnv);
        }
        
    }
    
    public static class MyHostnameVerifier implements HostnameVerifier {
        
        private String[] hostnames;
        
        public MyHostnameVerifier(String[] hostnames) {
            this.hostnames = hostnames;
        }
        
        @Override
        public boolean verify(String hostname, SSLSession session) {
            if (hostnames != null && hostnames.length > 0) {
                for (String hn : hostnames) {
                    if (StringUtils.isNotBlank(hn) && hn.equals(hostname)) {
                        return true;
                    }
                }
            }
            return false;
            // return true;
        }
        
    }
    
    public static class SkipHostnameVerifier implements HostnameVerifier {
        
        @Override
        public boolean verify(String hostname, SSLSession session) {
            if(hostname != null && session != null ){
                return true;
            }else{
                return false;
            }

        }
    }
    
    public static class MyX509TrustManager implements X509TrustManager {
        
        X509TrustManager sunJSSEX509TrustManager;
        
        public MyX509TrustManager(String keyStorePath, String keyPassword)
            throws Exception {
            KeyStore ks = KeyStore.getInstance("JKS");
            
            ks.load(ResourceUtils.getURL(keyStorePath).openStream(), keyPassword.toCharArray());
            
            TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509", "SunJSSE");
            tmf.init(ks);
            TrustManager tms[] = tmf.getTrustManagers();
            
            for (int i = 0; i < tms.length; i++) {
                if (tms[i] instanceof X509TrustManager) {
                    sunJSSEX509TrustManager = (X509TrustManager)tms[i];
                    return;
                }
            }
            
            throw new Exception("Couldn't initialize");
        }
        
        @Override
        public void checkClientTrusted(X509Certificate certificates[], String authType)
            throws CertificateException {
            sunJSSEX509TrustManager.checkClientTrusted(certificates, authType);
        }
        
        @Override
        public void checkServerTrusted(X509Certificate[] ax509certificate, String authType)
            throws CertificateException {
            sunJSSEX509TrustManager.checkServerTrusted(ax509certificate, authType);
        }
        
        @Override
        public X509Certificate[] getAcceptedIssuers() {
            // return new X509Certificate[0];
            
            return sunJSSEX509TrustManager.getAcceptedIssuers();
        }
    }
    
    public static class SkipX509TrustManager implements X509TrustManager {
        
        @Override
        public void checkClientTrusted(
            java.security.cert.X509Certificate[] paramArrayOfX509Certificate, String paramString) throws CertificateException {
            if(paramArrayOfX509Certificate == null || StringUtils.isBlank(paramString)){
                throw new CertificateException();
            }
        }
        
        @Override
        public void checkServerTrusted(
            java.security.cert.X509Certificate[] paramArrayOfX509Certificate, String paramString) throws CertificateException {
            if(paramArrayOfX509Certificate == null || StringUtils.isBlank(paramString)){
                throw new CertificateException();
            }
        }
        
        @Override
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }
    
    public static class KeyStoreInfo {
        
        public KeyStoreInfo() {
        }
        
        private String keystorePath;
        
        private String keyPassword;
        
        private String hostname;
        
        public String getKeystorePath() {
            return keystorePath;
        }
        
        public void setKeystorePath(String keystorePath) {
            this.keystorePath = keystorePath;
        }
        
        public String getKeyPassword() {
            return keyPassword;
        }
        
        public void setKeyPassword(String keyPassword) {
            this.keyPassword = keyPassword;
        }
        
        public String getHostname() {
            return hostname;
        }
        
        public void setHostname(String hostname) {
            this.hostname = hostname;
        }
        
    }
}
