
package com.ird.portal.fds.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 								Photo
 * 							
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Photo", propOrder = {
    "uid",
    "incomeIP",
    "taxiCertNo",
    "spTxnNo",
    "base64Data"
})
public class Photo {

    @XmlElement(required = true)
    protected String uid;
    @XmlElement(required = true)
    protected String incomeIP;
    protected long taxiCertNo;
    @XmlElement(required = true)
    protected String spTxnNo;
    @XmlElement(required = true)
    protected String base64Data;

    /**
     * \u83b7\u53d6uid\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUid() {
        return uid;
    }

    /**
     * \u8bbe\u7f6euid\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUid(String value) {
        this.uid = value;
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
     * \u83b7\u53d6taxiCertNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public long getTaxiCertNo() {
        return taxiCertNo;
    }

    /**
     * \u8bbe\u7f6etaxiCertNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setTaxiCertNo(long value) {
        this.taxiCertNo = value;
    }

    /**
     * \u83b7\u53d6spTxnNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpTxnNo() {
        return spTxnNo;
    }

    /**
     * \u8bbe\u7f6espTxnNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpTxnNo(String value) {
        this.spTxnNo = value;
    }

    /**
     * \u83b7\u53d6base64Data\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBase64Data() {
        return base64Data;
    }

    /**
     * \u8bbe\u7f6ebase64Data\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBase64Data(String value) {
        this.base64Data = value;
    }

}
