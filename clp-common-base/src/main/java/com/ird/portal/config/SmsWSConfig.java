package com.ird.portal.config;

import org.apache.http.auth.Credentials;
import org.apache.http.auth.NTCredentials;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.springframework.ws.transport.WebServiceMessageSender;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

@Configuration
public class SmsWSConfig {
    
    @Value("${spring.baseServiceWS.sms.wsdl}")
    private String ws_sms_wsdl;
    
    @Value("${spring.baseServiceWS.sms.username}")
    private String username;
    
    @Value("${spring.baseServiceWS.sms.password}")
    private String password;
    
    @Value("${spring.baseServiceWS.sms.domain}")
    private String domain;
    
    @Bean
    public WebServiceTemplate webServiceTemplate() {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setMessageFactory(messageFactory());
        webServiceTemplate.setMarshaller(jaxb2Marshaller());
        webServiceTemplate.setUnmarshaller(jaxb2Marshaller());
        webServiceTemplate.setMessageSender(messageSender());
        webServiceTemplate.setDefaultUri(ws_sms_wsdl);
        return webServiceTemplate;
    }
    
    @Bean
    public WebServiceMessageSender messageSender() {
        HttpComponentsMessageSender messageSender = new HttpComponentsMessageSender();
        messageSender.setCredentials(credentials());
        return messageSender;
    }

    @Bean
    public SaajSoapMessageFactory messageFactory() {
        SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory();
        messageFactory.setSoapVersion(org.springframework.ws.soap.SoapVersion.SOAP_12);
        return messageFactory;
    }
    
    @Bean
    public Jaxb2Marshaller jaxb2Marshaller() {
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        
        // Soap 客戶端類所在package
        jaxb2Marshaller.setContextPath("com.ird.portal.client");
        return jaxb2Marshaller;
    }
    
    @Bean
    public Credentials credentials() {
        NTCredentials credentials = new NTCredentials(username, password, null, domain);
		return credentials;
    }
    
}
