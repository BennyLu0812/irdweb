package com.ird.portal.config;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContexts;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

/**
 * httpClinet 配置
 * @author Benny
 * @date 2022/10/20
 */
@Configuration
public class HttpClientConfig {

    /*@Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory factory){
        return new RestTemplate(factory);
    }

    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory(){
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(30000);
        factory.setConnectTimeout(5000);
        return factory;
    }*/

    @Bean
    public RestTemplate restTemplate() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory());

        // 解決中文亂碼
        for (int i = 0; i < restTemplate.getMessageConverters().size(); i++) {
            if (restTemplate.getMessageConverters().get(i) instanceof StringHttpMessageConverter) {
                restTemplate.getMessageConverters().set(i, new StringHttpMessageConverter(StandardCharsets.UTF_8));
            }
        }

        return restTemplate;
    }

    /**
     * 客户端请求链接策略
     *
     * @return
     */
    public ClientHttpRequestFactory clientHttpRequestFactory() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        HttpClient httpClient = httpClientBuilder().build();
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        // 连接超时时间/毫秒
        clientHttpRequestFactory.setConnectTimeout(30000);
        // 读写超时时间/毫秒
        clientHttpRequestFactory.setReadTimeout(30000);
        // 请求超时时间/毫秒
        clientHttpRequestFactory.setConnectionRequestTimeout(30000);
        return clientHttpRequestFactory;
    }

    /**
     * 设置HTTP连接管理器,连接池相关配置管理
     *
     * @return 客户端链接管理器
     */
    public HttpClientBuilder httpClientBuilder() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        httpClientBuilder.evictIdleConnections(60L, TimeUnit.SECONDS);
        httpClientBuilder.setMaxConnTotal(50);
        httpClientBuilder.setMaxConnPerRoute(50);
        TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;
        HostnameVerifier hostnameVerifier = (s, sslSession) -> true;
        SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy).build();
        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext, hostnameVerifier);
        httpClientBuilder.setSSLSocketFactory(csf);
        httpClientBuilder.setRetryHandler(new DefaultHttpRequestRetryHandler());
        return httpClientBuilder;
    }
}

