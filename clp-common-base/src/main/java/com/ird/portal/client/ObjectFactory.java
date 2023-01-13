
package com.ird.portal.client;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the dsat.smswebservices package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: dsat.smswebservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Echo }
     * 
     */
    public Echo createEcho() {
        return new Echo();
    }

    /**
     * Create an instance of {@link EchoResponse }
     * 
     */
    public EchoResponse createEchoResponse() {
        return new EchoResponse();
    }

    /**
     * Create an instance of {@link SendSms }
     * 
     */
    public SendSms createSendSms() {
        return new SendSms();
    }

    /**
     * Create an instance of {@link SendSmsResponse }
     * 
     */
    public SendSmsResponse createSendSmsResponse() {
        return new SendSmsResponse();
    }

    /**
     * Create an instance of {@link SendSmsBatch }
     * 
     */
    public SendSmsBatch createSendSmsBatch() {
        return new SendSmsBatch();
    }

    /**
     * Create an instance of {@link SendSmsBatchResponse }
     * 
     */
    public SendSmsBatchResponse createSendSmsBatchResponse() {
        return new SendSmsBatchResponse();
    }

    /**
     * Create an instance of {@link SendSmsByAppType }
     * 
     */
    public SendSmsByAppType createSendSmsByAppType() {
        return new SendSmsByAppType();
    }

    /**
     * Create an instance of {@link SendSmsByAppTypeResponse }
     * 
     */
    public SendSmsByAppTypeResponse createSendSmsByAppTypeResponse() {
        return new SendSmsByAppTypeResponse();
    }

    /**
     * Create an instance of {@link SendSmsBatchByAppType }
     * 
     */
    public SendSmsBatchByAppType createSendSmsBatchByAppType() {
        return new SendSmsBatchByAppType();
    }

    /**
     * Create an instance of {@link SendSmsBatchByAppTypeResponse }
     * 
     */
    public SendSmsBatchByAppTypeResponse createSendSmsBatchByAppTypeResponse() {
        return new SendSmsBatchByAppTypeResponse();
    }

    /**
     * Create an instance of {@link QueryStatus }
     * 
     */
    public QueryStatus createQueryStatus() {
        return new QueryStatus();
    }

    /**
     * Create an instance of {@link QueryStatusResponse }
     * 
     */
    public QueryStatusResponse createQueryStatusResponse() {
        return new QueryStatusResponse();
    }

}
