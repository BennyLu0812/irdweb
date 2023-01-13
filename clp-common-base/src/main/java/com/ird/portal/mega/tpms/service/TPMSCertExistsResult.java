
package com.ird.portal.mega.tpms.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>TPMSCertExistsResult complex type\u7684 Java \u7c7b\u3002
 * 
 * <p>\u4ee5\u4e0b\u6a21\u5f0f\u7247\u6bb5\u6307\u5b9a\u5305\u542b\u5728\u6b64\u7c7b\u4e2d\u7684\u9884\u671f\u5185\u5bb9\u3002
 * 
 * <pre>
 * &lt;complexType name="TPMSCertExistsResult"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="exists" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="invalidCode" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="renew" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TPMSCertExistsResult", propOrder = {
    "exists",
    "invalidCode",
    "renew"
})
public class TPMSCertExistsResult {

    protected boolean exists;
    protected Integer invalidCode;
    protected boolean renew;

    /**
     * \u83b7\u53d6exists\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public boolean isExists() {
        return exists;
    }

    /**
     * \u8bbe\u7f6eexists\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setExists(boolean value) {
        this.exists = value;
    }

    /**
     * \u83b7\u53d6invalidCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getInvalidCode() {
        return invalidCode;
    }

    /**
     * \u8bbe\u7f6einvalidCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setInvalidCode(Integer value) {
        this.invalidCode = value;
    }

    /**
     * \u83b7\u53d6renew\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public boolean isRenew() {
        return renew;
    }

    /**
     * \u8bbe\u7f6erenew\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setRenew(boolean value) {
        this.renew = value;
    }

}
