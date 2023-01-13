
package com.ird.portal.fds.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * 
 * 								Create Online Transaction Dto
 * 							
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateOnlineTransDto", propOrder = {
    "txnNo",
    "serviceOperationCode",
    "loginId",
    "incomeIP",
    "completeOnCreation",
    "serviceActionTypes",
    "zoneCode",
    "exAppCode",
    "issueZoneCode",
    "expectedLicenseIssueDate",
    "jobDate",
    "smsClient",
    "smsAgent",
    "extraRemark",
    "transDocsReq",
    "feeEntryReq",
    "paymentReq",
    "procInput"
})
public class CreateOnlineTransDto {

    @XmlElement(required = true)
    protected String txnNo;
    @XmlElement(required = true)
    protected String serviceOperationCode;
    @XmlElement(required = true)
    protected String loginId;
    @XmlElement(required = true)
    protected String incomeIP;
    protected boolean completeOnCreation;
    @XmlElement(nillable = true)
    protected List<String> serviceActionTypes;
    @XmlElement(required = true)
    protected String zoneCode;
    @XmlElement(required = true)
    protected String exAppCode;
    @XmlElement(required = true)
    protected String issueZoneCode;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expectedLicenseIssueDate;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar jobDate;
    protected boolean smsClient;
    protected boolean smsAgent;
    @XmlElement(required = true)
    protected String extraRemark;
    @XmlElement(required = true)
    protected TransDocsReq transDocsReq;
    @XmlElement(required = true)
    protected SubmitFeeEntryReq feeEntryReq;
    @XmlElement(required = true)
    protected SubmitPaymentReq paymentReq;
    @XmlElement(required = true)
    protected ProceInput procInput;

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

    /**
     * Gets the value of the serviceActionTypes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceActionTypes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceActionTypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getServiceActionTypes() {
        if (serviceActionTypes == null) {
            serviceActionTypes = new ArrayList<String>();
        }
        return this.serviceActionTypes;
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
     * \u83b7\u53d6exAppCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExAppCode() {
        return exAppCode;
    }

    /**
     * \u8bbe\u7f6eexAppCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExAppCode(String value) {
        this.exAppCode = value;
    }

    /**
     * \u83b7\u53d6issueZoneCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssueZoneCode() {
        return issueZoneCode;
    }

    /**
     * \u8bbe\u7f6eissueZoneCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssueZoneCode(String value) {
        this.issueZoneCode = value;
    }

    /**
     * \u83b7\u53d6expectedLicenseIssueDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpectedLicenseIssueDate() {
        return expectedLicenseIssueDate;
    }

    /**
     * \u8bbe\u7f6eexpectedLicenseIssueDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpectedLicenseIssueDate(XMLGregorianCalendar value) {
        this.expectedLicenseIssueDate = value;
    }

    /**
     * \u83b7\u53d6jobDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getJobDate() {
        return jobDate;
    }

    /**
     * \u8bbe\u7f6ejobDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setJobDate(XMLGregorianCalendar value) {
        this.jobDate = value;
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
     * \u83b7\u53d6extraRemark\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtraRemark() {
        return extraRemark;
    }

    /**
     * \u8bbe\u7f6eextraRemark\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtraRemark(String value) {
        this.extraRemark = value;
    }

    /**
     * \u83b7\u53d6transDocsReq\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link TransDocsReq }
     *     
     */
    public TransDocsReq getTransDocsReq() {
        return transDocsReq;
    }

    /**
     * \u8bbe\u7f6etransDocsReq\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link TransDocsReq }
     *     
     */
    public void setTransDocsReq(TransDocsReq value) {
        this.transDocsReq = value;
    }

    /**
     * \u83b7\u53d6feeEntryReq\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link SubmitFeeEntryReq }
     *     
     */
    public SubmitFeeEntryReq getFeeEntryReq() {
        return feeEntryReq;
    }

    /**
     * \u8bbe\u7f6efeeEntryReq\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link SubmitFeeEntryReq }
     *     
     */
    public void setFeeEntryReq(SubmitFeeEntryReq value) {
        this.feeEntryReq = value;
    }

    /**
     * \u83b7\u53d6paymentReq\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link SubmitPaymentReq }
     *     
     */
    public SubmitPaymentReq getPaymentReq() {
        return paymentReq;
    }

    /**
     * \u8bbe\u7f6epaymentReq\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link SubmitPaymentReq }
     *     
     */
    public void setPaymentReq(SubmitPaymentReq value) {
        this.paymentReq = value;
    }

    /**
     * \u83b7\u53d6procInput\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link ProceInput }
     *     
     */
    public ProceInput getProcInput() {
        return procInput;
    }

    /**
     * \u8bbe\u7f6eprocInput\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link ProceInput }
     *     
     */
    public void setProcInput(ProceInput value) {
        this.procInput = value;
    }

}
