
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
 *         &lt;element name="serviceOperationCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="loginId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="incomeIP" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="completeOnCreation" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
    "serviceOperationCode",
    "loginId",
    "incomeIP",
    "completeOnCreation"
})
@XmlRootElement(name = "createTransaction")
public class CreateTransaction {

    @XmlElement(required = true)
    protected String serviceOperationCode;
    @XmlElement(required = true)
    protected String loginId;
    @XmlElement(required = true)
    protected String incomeIP;
    @XmlElement(defaultValue = "true")
    protected boolean completeOnCreation;

    /**
     * \u83b7\u53d6serviceOperationCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceOperationCode() {
        return serviceOperationCode;
    }

    /**
     * \u8bbe\u7f6eserviceOperationCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceOperationCode(String value) {
        this.serviceOperationCode = value;
    }

    /**
     * \u83b7\u53d6loginId\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * \u8bbe\u7f6eloginId\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoginId(String value) {
        this.loginId = value;
    }

    /**
     * \u83b7\u53d6incomeIP\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIncomeIP() {
        return incomeIP;
    }

    /**
     * \u8bbe\u7f6eincomeIP\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIncomeIP(String value) {
        this.incomeIP = value;
    }

    /**
     * \u83b7\u53d6completeOnCreation\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public boolean isCompleteOnCreation() {
        return completeOnCreation;
    }

    /**
     * \u8bbe\u7f6ecompleteOnCreation\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setCompleteOnCreation(boolean value) {
        this.completeOnCreation = value;
    }

}
