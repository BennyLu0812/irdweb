
package com.ird.portal.fds.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 								TransactionForIssue is the detailse to SP-IN
 * 							
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionForIssue", propOrder = {
    "serviceZh",
    "serviceOperationZh",
    "servicePt",
    "serviceOperationPt",
    "needIssueLicense",
    "spTxnNo",
    "nameZh",
    "namePt",
    "usingLanguage",
    "idType",
    "idNo",
    "contactPhone",
    "agentPhone",
    "smsAgent",
    "smsClient",
    "serviceZoneCode",
    "licenseIssueZoneCode",
    "fileTypeCode",
    "fleNo"
})
public class TransactionForIssue {

    @XmlElement(required = true)
    protected String serviceZh;
    @XmlElement(required = true)
    protected String serviceOperationZh;
    @XmlElement(required = true)
    protected String servicePt;
    @XmlElement(required = true)
    protected String serviceOperationPt;
    protected boolean needIssueLicense;
    @XmlElement(required = true)
    protected String spTxnNo;
    @XmlElement(required = true)
    protected String nameZh;
    @XmlElement(required = true)
    protected String namePt;
    @XmlElement(required = true)
    protected String usingLanguage;
    @XmlElement(required = true)
    protected String idType;
    @XmlElement(required = true)
    protected String idNo;
    @XmlElement(required = true)
    protected String contactPhone;
    @XmlElement(required = true)
    protected String agentPhone;
    protected boolean smsAgent;
    protected boolean smsClient;
    @XmlElement(required = true)
    protected String serviceZoneCode;
    @XmlElement(required = true)
    protected String licenseIssueZoneCode;
    @XmlElement(required = true)
    protected String fileTypeCode;
    @XmlElement(required = true)
    protected String fleNo;

    /**
     * \u83b7\u53d6serviceZh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceZh() {
        return serviceZh;
    }

    /**
     * \u8bbe\u7f6eserviceZh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceZh(String value) {
        this.serviceZh = value;
    }

    /**
     * \u83b7\u53d6serviceOperationZh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceOperationZh() {
        return serviceOperationZh;
    }

    /**
     * \u8bbe\u7f6eserviceOperationZh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceOperationZh(String value) {
        this.serviceOperationZh = value;
    }

    /**
     * \u83b7\u53d6servicePt\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServicePt() {
        return servicePt;
    }

    /**
     * \u8bbe\u7f6eservicePt\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServicePt(String value) {
        this.servicePt = value;
    }

    /**
     * \u83b7\u53d6serviceOperationPt\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceOperationPt() {
        return serviceOperationPt;
    }

    /**
     * \u8bbe\u7f6eserviceOperationPt\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceOperationPt(String value) {
        this.serviceOperationPt = value;
    }

    /**
     * \u83b7\u53d6needIssueLicense\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public boolean isNeedIssueLicense() {
        return needIssueLicense;
    }

    /**
     * \u8bbe\u7f6eneedIssueLicense\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setNeedIssueLicense(boolean value) {
        this.needIssueLicense = value;
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
     * \u83b7\u53d6nameZh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameZh() {
        return nameZh;
    }

    /**
     * \u8bbe\u7f6enameZh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameZh(String value) {
        this.nameZh = value;
    }

    /**
     * \u83b7\u53d6namePt\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNamePt() {
        return namePt;
    }

    /**
     * \u8bbe\u7f6enamePt\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNamePt(String value) {
        this.namePt = value;
    }

    /**
     * \u83b7\u53d6usingLanguage\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsingLanguage() {
        return usingLanguage;
    }

    /**
     * \u8bbe\u7f6eusingLanguage\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsingLanguage(String value) {
        this.usingLanguage = value;
    }

    /**
     * \u83b7\u53d6idType\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdType() {
        return idType;
    }

    /**
     * \u8bbe\u7f6eidType\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdType(String value) {
        this.idType = value;
    }

    /**
     * \u83b7\u53d6idNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdNo() {
        return idNo;
    }

    /**
     * \u8bbe\u7f6eidNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdNo(String value) {
        this.idNo = value;
    }

    /**
     * \u83b7\u53d6contactPhone\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactPhone() {
        return contactPhone;
    }

    /**
     * \u8bbe\u7f6econtactPhone\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactPhone(String value) {
        this.contactPhone = value;
    }

    /**
     * \u83b7\u53d6agentPhone\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgentPhone() {
        return agentPhone;
    }

    /**
     * \u8bbe\u7f6eagentPhone\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgentPhone(String value) {
        this.agentPhone = value;
    }

    /**
     * \u83b7\u53d6smsAgent\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public boolean isSmsAgent() {
        return smsAgent;
    }

    /**
     * \u8bbe\u7f6esmsAgent\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setSmsAgent(boolean value) {
        this.smsAgent = value;
    }

    /**
     * \u83b7\u53d6smsClient\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public boolean isSmsClient() {
        return smsClient;
    }

    /**
     * \u8bbe\u7f6esmsClient\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setSmsClient(boolean value) {
        this.smsClient = value;
    }

    /**
     * \u83b7\u53d6serviceZoneCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceZoneCode() {
        return serviceZoneCode;
    }

    /**
     * \u8bbe\u7f6eserviceZoneCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceZoneCode(String value) {
        this.serviceZoneCode = value;
    }

    /**
     * \u83b7\u53d6licenseIssueZoneCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicenseIssueZoneCode() {
        return licenseIssueZoneCode;
    }

    /**
     * \u8bbe\u7f6elicenseIssueZoneCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicenseIssueZoneCode(String value) {
        this.licenseIssueZoneCode = value;
    }

    /**
     * \u83b7\u53d6fileTypeCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileTypeCode() {
        return fileTypeCode;
    }

    /**
     * \u8bbe\u7f6efileTypeCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileTypeCode(String value) {
        this.fileTypeCode = value;
    }

    /**
     * \u83b7\u53d6fleNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFleNo() {
        return fleNo;
    }

    /**
     * \u8bbe\u7f6efleNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFleNo(String value) {
        this.fleNo = value;
    }

}
