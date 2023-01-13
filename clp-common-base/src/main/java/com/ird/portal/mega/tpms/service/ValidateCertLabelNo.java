
package com.ird.portal.mega.tpms.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>validateCertLabelNo complex type\u7684 Java \u7c7b\u3002
 * 
 * <p>\u4ee5\u4e0b\u6a21\u5f0f\u7247\u6bb5\u6307\u5b9a\u5305\u542b\u5728\u6b64\u7c7b\u4e2d\u7684\u9884\u671f\u5185\u5bb9\u3002
 * 
 * <pre>
 * &lt;complexType name="validateCertLabelNo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="certLabelNo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="spTxnno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="isReprint" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "validateCertLabelNo", propOrder = {
    "certLabelNo",
    "spTxnno",
    "isReprint"
})
public class ValidateCertLabelNo {

    protected Long certLabelNo;
    protected String spTxnno;
    protected boolean isReprint;

    /**
     * \u83b7\u53d6certLabelNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCertLabelNo() {
        return certLabelNo;
    }

    /**
     * \u8bbe\u7f6ecertLabelNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCertLabelNo(Long value) {
        this.certLabelNo = value;
    }

    /**
     * \u83b7\u53d6spTxnno\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpTxnno() {
        return spTxnno;
    }

    /**
     * \u8bbe\u7f6espTxnno\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpTxnno(String value) {
        this.spTxnno = value;
    }

    /**
     * \u83b7\u53d6isReprint\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public boolean isIsReprint() {
        return isReprint;
    }

    /**
     * \u8bbe\u7f6eisReprint\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setIsReprint(boolean value) {
        this.isReprint = value;
    }

}
