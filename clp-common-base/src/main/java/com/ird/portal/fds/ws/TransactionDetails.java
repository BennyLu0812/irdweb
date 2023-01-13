
package com.ird.portal.fds.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 								TransactionDetails
 * 							
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionDetails", propOrder = {
    "txnNo",
    "clientName",
    "clientNamePt",
    "clientIdTypeCode",
    "clientIdNo",
    "clientTel",
    "clientOtherTel",
    "clientEmail",
    "language",
    "agentName",
    "agentNamePt",
    "agentIdTypeCode",
    "agentIdNo",
    "agentTel",
    "agentOtherTel",
    "agentEmail",
    "agentLanguage",
    "smsClient",
    "smsAgent",
    "updateUid"
})
public class TransactionDetails {

    @XmlElement(required = true)
    protected String txnNo;
    @XmlElement(required = true)
    protected String clientName;
    @XmlElement(required = true)
    protected String clientNamePt;
    @XmlElement(required = true)
    protected String clientIdTypeCode;
    @XmlElement(required = true)
    protected String clientIdNo;
    @XmlElement(required = true)
    protected String clientTel;
    @XmlElement(required = true)
    protected String clientOtherTel;
    @XmlElement(required = true)
    protected String clientEmail;
    @XmlElement(required = true)
    protected String language;
    @XmlElement(required = true)
    protected String agentName;
    @XmlElement(required = true)
    protected String agentNamePt;
    @XmlElement(required = true)
    protected String agentIdTypeCode;
    @XmlElement(required = true)
    protected String agentIdNo;
    @XmlElement(required = true)
    protected String agentTel;
    @XmlElement(required = true)
    protected String agentOtherTel;
    @XmlElement(required = true)
    protected String agentEmail;
    @XmlElement(required = true)
    protected String agentLanguage;
    @XmlElement(name = "SMSClient")
    protected boolean smsClient;
    @XmlElement(name = "SMSAgent")
    protected boolean smsAgent;
    @XmlElement(required = true)
    protected String updateUid;

    /**
     * \u83b7\u53d6txnNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTxnNo() {
        return txnNo;
    }

    /**
     * \u8bbe\u7f6etxnNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTxnNo(String value) {
        this.txnNo = value;
    }

    /**
     * \u83b7\u53d6clientName\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * \u8bbe\u7f6eclientName\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientName(String value) {
        this.clientName = value;
    }

    /**
     * \u83b7\u53d6clientNamePt\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientNamePt() {
        return clientNamePt;
    }

    /**
     * \u8bbe\u7f6eclientNamePt\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientNamePt(String value) {
        this.clientNamePt = value;
    }

    /**
     * \u83b7\u53d6clientIdTypeCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientIdTypeCode() {
        return clientIdTypeCode;
    }

    /**
     * \u8bbe\u7f6eclientIdTypeCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientIdTypeCode(String value) {
        this.clientIdTypeCode = value;
    }

    /**
     * \u83b7\u53d6clientIdNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientIdNo() {
        return clientIdNo;
    }

    /**
     * \u8bbe\u7f6eclientIdNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientIdNo(String value) {
        this.clientIdNo = value;
    }

    /**
     * \u83b7\u53d6clientTel\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientTel() {
        return clientTel;
    }

    /**
     * \u8bbe\u7f6eclientTel\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientTel(String value) {
        this.clientTel = value;
    }

    /**
     * \u83b7\u53d6clientOtherTel\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientOtherTel() {
        return clientOtherTel;
    }

    /**
     * \u8bbe\u7f6eclientOtherTel\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientOtherTel(String value) {
        this.clientOtherTel = value;
    }

    /**
     * \u83b7\u53d6clientEmail\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientEmail() {
        return clientEmail;
    }

    /**
     * \u8bbe\u7f6eclientEmail\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientEmail(String value) {
        this.clientEmail = value;
    }

    /**
     * \u83b7\u53d6language\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * \u8bbe\u7f6elanguage\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * \u83b7\u53d6agentName\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgentName() {
        return agentName;
    }

    /**
     * \u8bbe\u7f6eagentName\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgentName(String value) {
        this.agentName = value;
    }

    /**
     * \u83b7\u53d6agentNamePt\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgentNamePt() {
        return agentNamePt;
    }

    /**
     * \u8bbe\u7f6eagentNamePt\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgentNamePt(String value) {
        this.agentNamePt = value;
    }

    /**
     * \u83b7\u53d6agentIdTypeCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgentIdTypeCode() {
        return agentIdTypeCode;
    }

    /**
     * \u8bbe\u7f6eagentIdTypeCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgentIdTypeCode(String value) {
        this.agentIdTypeCode = value;
    }

    /**
     * \u83b7\u53d6agentIdNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgentIdNo() {
        return agentIdNo;
    }

    /**
     * \u8bbe\u7f6eagentIdNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgentIdNo(String value) {
        this.agentIdNo = value;
    }

    /**
     * \u83b7\u53d6agentTel\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgentTel() {
        return agentTel;
    }

    /**
     * \u8bbe\u7f6eagentTel\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgentTel(String value) {
        this.agentTel = value;
    }

    /**
     * \u83b7\u53d6agentOtherTel\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgentOtherTel() {
        return agentOtherTel;
    }

    /**
     * \u8bbe\u7f6eagentOtherTel\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgentOtherTel(String value) {
        this.agentOtherTel = value;
    }

    /**
     * \u83b7\u53d6agentEmail\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgentEmail() {
        return agentEmail;
    }

    /**
     * \u8bbe\u7f6eagentEmail\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgentEmail(String value) {
        this.agentEmail = value;
    }

    /**
     * \u83b7\u53d6agentLanguage\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgentLanguage() {
        return agentLanguage;
    }

    /**
     * \u8bbe\u7f6eagentLanguage\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgentLanguage(String value) {
        this.agentLanguage = value;
    }

    /**
     * \u83b7\u53d6smsClient\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public boolean isSMSClient() {
        return smsClient;
    }

    /**
     * \u8bbe\u7f6esmsClient\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setSMSClient(boolean value) {
        this.smsClient = value;
    }

    /**
     * \u83b7\u53d6smsAgent\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public boolean isSMSAgent() {
        return smsAgent;
    }

    /**
     * \u8bbe\u7f6esmsAgent\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setSMSAgent(boolean value) {
        this.smsAgent = value;
    }

    /**
     * \u83b7\u53d6updateUid\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpdateUid() {
        return updateUid;
    }

    /**
     * \u8bbe\u7f6eupdateUid\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpdateUid(String value) {
        this.updateUid = value;
    }

}
