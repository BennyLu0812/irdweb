
package com.ird.portal.be.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 								create International License Applicant Request Info
 * 							
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InterLicAppReq")
public class InterLicAppReq {

    @XmlAttribute(name = "txnNo")
    protected String txnNo;
    @XmlAttribute(name = "loginId")
    protected String loginId;
    @XmlAttribute(name = "incomeIP")
    protected String incomeIP;
    @XmlAttribute(name = "clientIdTypeCode")
    protected String clientIdTypeCode;
    @XmlAttribute(name = "clientIdNo")
    protected String clientIdNo;
    @XmlAttribute(name = "clientName")
    protected String clientName;
    @XmlAttribute(name = "clientNamePt")
    protected String clientNamePt;
    @XmlAttribute(name = "clientTel")
    protected String clientTel;
    @XmlAttribute(name = "clientOtherTel")
    protected String clientOtherTel;
    @XmlAttribute(name = "clientEmail")
    protected String clientEmail;
    @XmlAttribute(name = "docId")
    protected Long docId;
    @XmlAttribute(name = "language")
    protected String language;
    @XmlAttribute(name = "driLicType")
    protected String driLicType;
    @XmlAttribute(name = "driLicNo")
    protected String driLicNo;
    @XmlAttribute(name = "zoneCode")
    protected String zoneCode;
    @XmlAttribute(name = "agentName")
    protected String agentName;
    @XmlAttribute(name = "agentNamePt")
    protected String agentNamePt;
    @XmlAttribute(name = "agentIdTypeCode")
    protected String agentIdTypeCode;
    @XmlAttribute(name = "agentIdNo")
    protected String agentIdNo;
    @XmlAttribute(name = "agentTel")
    protected String agentTel;
    @XmlAttribute(name = "agentOtherTel")
    protected String agentOtherTel;
    @XmlAttribute(name = "agentEmail")
    protected String agentEmail;
    @XmlAttribute(name = "agentLanguage")
    protected String agentLanguage;

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
     * \u83b7\u53d6docId\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDocId() {
        return docId;
    }

    /**
     * \u8bbe\u7f6edocId\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDocId(Long value) {
        this.docId = value;
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
     * \u83b7\u53d6driLicType\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDriLicType() {
        return driLicType;
    }

    /**
     * \u8bbe\u7f6edriLicType\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDriLicType(String value) {
        this.driLicType = value;
    }

    /**
     * \u83b7\u53d6driLicNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDriLicNo() {
        return driLicNo;
    }

    /**
     * \u8bbe\u7f6edriLicNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDriLicNo(String value) {
        this.driLicNo = value;
    }

    /**
     * \u83b7\u53d6zoneCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZoneCode() {
        return zoneCode;
    }

    /**
     * \u8bbe\u7f6ezoneCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZoneCode(String value) {
        this.zoneCode = value;
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

}
