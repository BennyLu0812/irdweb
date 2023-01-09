
package com.ird.portal.fds.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type\u7684 Java \u7c7b\u3002
 * 
 * <p>\u4ee5\u4e0b\u6a21\u5f0f\u7247\u6bb5\u6307\u5b9a\u5305\u542b\u5728\u6b64\u7c7b\u4e2d\u7684\u9884\u671f\u5185\u5bb9\u3002
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="transaction" type="{urn:dsat.gov.mo:fds/ws}Transaction"/&gt;
 *         &lt;element name="callSubmitPaymentAdditional" type="{urn:dsat.gov.mo:fds/ws}CallSubmitPaymentAdditional"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "transaction",
    "callSubmitPaymentAdditional"
})
@XmlRootElement(name = "submitPayment")
public class SubmitPayment {

    @XmlElement(required = true)
    protected Transaction transaction;
    @XmlElement(required = true)
    protected CallSubmitPaymentAdditional callSubmitPaymentAdditional;

    /**
     * \u83b7\u53d6transaction\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Transaction }
     *     
     */
    public Transaction getTransaction() {
        return transaction;
    }

    /**
     * \u8bbe\u7f6etransaction\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Transaction }
     *     
     */
    public void setTransaction(Transaction value) {
        this.transaction = value;
    }

    /**
     * \u83b7\u53d6callSubmitPaymentAdditional\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link CallSubmitPaymentAdditional }
     *     
     */
    public CallSubmitPaymentAdditional getCallSubmitPaymentAdditional() {
        return callSubmitPaymentAdditional;
    }

    /**
     * \u8bbe\u7f6ecallSubmitPaymentAdditional\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link CallSubmitPaymentAdditional }
     *     
     */
    public void setCallSubmitPaymentAdditional(CallSubmitPaymentAdditional value) {
        this.callSubmitPaymentAdditional = value;
    }

}
