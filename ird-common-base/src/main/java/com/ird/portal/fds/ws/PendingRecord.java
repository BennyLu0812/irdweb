
package com.ird.portal.fds.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 								PendingRecord is to being deal with record
 * 							
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PendingRecord")
public class PendingRecord {

    @XmlAttribute(name = "uid")
    protected String uid;
    @XmlAttribute(name = "userName")
    protected String userName;
    @XmlAttribute(name = "ip")
    protected String ip;
    @XmlAttribute(name = "status")
    protected String status;
    @XmlAttribute(name = "helpDepositUrl")
    protected String helpDepositUrl;
    @XmlAttribute(name = "receiptCount")
    protected Integer receiptCount;
    @XmlAttribute(name = "receiptAmount")
    protected Double receiptAmount;

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
     * \u83b7\u53d6userName\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserName() {
        return userName;
    }

    /**
     * \u8bbe\u7f6euserName\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserName(String value) {
        this.userName = value;
    }

    /**
     * \u83b7\u53d6ip\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIp() {
        return ip;
    }

    /**
     * \u8bbe\u7f6eip\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIp(String value) {
        this.ip = value;
    }

    /**
     * \u83b7\u53d6status\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * \u8bbe\u7f6estatus\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * \u83b7\u53d6helpDepositUrl\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHelpDepositUrl() {
        return helpDepositUrl;
    }

    /**
     * \u8bbe\u7f6ehelpDepositUrl\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHelpDepositUrl(String value) {
        this.helpDepositUrl = value;
    }

    /**
     * \u83b7\u53d6receiptCount\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getReceiptCount() {
        return receiptCount;
    }

    /**
     * \u8bbe\u7f6ereceiptCount\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setReceiptCount(Integer value) {
        this.receiptCount = value;
    }

    /**
     * \u83b7\u53d6receiptAmount\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getReceiptAmount() {
        return receiptAmount;
    }

    /**
     * \u8bbe\u7f6ereceiptAmount\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setReceiptAmount(Double value) {
        this.receiptAmount = value;
    }

}
