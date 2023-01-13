
package com.ird.portal.fds.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * 
 * 								Transaction is an encapsulation for all data
 * 								submitted from the Client App (for example, DAVIS) to the
 * 								Service Portal.
 * 							
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Transaction", propOrder = {
    "serviceFeeRequest",
    "externalTxnNo",
    "txnNo",
    "targetDTSLocationZh",
    "sourceDTSLocationZh",
    "sendDTSOnComplete",
    "zoneZh",
    "licenseIssueZoneZh",
    "expectedLicenseIssueDate",
    "exemptReason",
    "feeRemark",
    "docRemark",
    "payment",
    "lastModifyLog",
    "lastChangeFeeLog",
    "transactionDocuments",
    "feeEntries",
    "onCreateDTSUrl",
    "onCompleteUrl",
    "onViewUrl",
    "onEditUrl",
    "onVoidUrl",
    "onTerminateUrl",
    "selectDocsUrl",
    "selectFeesUrl",
    "browseDetailsUrl",
    "entryPointUrl",
    "resumeUrl",
    "reprintReceiptUrl",
    "chatLogsUrl",
    "postSelectFeeUrl",
    "postCompleteUrl",
    "externalUrl",
    "transactionActions",
    "phoneCallHistories",
    "licenseIssueZoneCode",
    "type",
    "requiringDocsTime",
    "completeRequiringDocsTime",
    "postSelectPayments",
    "skipSelectFees",
    "skipDownloadBusinessDoc",
    "skipDownloadBusinessDocIndexes",
    "updateFeeRequests",
    "businessDocName",
    "businessDocName2",
    "businessDocName3",
    "serviceCode",
    "serviceOperationCode",
    "serviceNameZh",
    "serviceNamePt",
    "serviceOperationNameZh",
    "serviceOperationNamePt",
    "updateIssueZone",
    "needIssueLicense",
    "createUid",
    "createTime",
    "needCreateDTS",
    "extraRemark",
    "smsClient",
    "smsAgent"
})
public class Transaction {

    @XmlElement(name = "ServiceFeeRequest")
    protected List<ServiceFeeRequest> serviceFeeRequest;
    @XmlElement(name = "ExternalTxnNo")
    protected List<ExternalTxnNo> externalTxnNo;
    @XmlElement(required = true)
    protected String txnNo;
    @XmlElement(required = true)
    protected String targetDTSLocationZh;
    @XmlElement(required = true)
    protected String sourceDTSLocationZh;
    protected boolean sendDTSOnComplete;
    @XmlElement(required = true)
    protected String zoneZh;
    @XmlElement(required = true)
    protected String licenseIssueZoneZh;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expectedLicenseIssueDate;
    @XmlElement(required = true)
    protected String exemptReason;
    @XmlElement(required = true)
    protected String feeRemark;
    @XmlElement(required = true)
    protected String docRemark;
    @XmlElement(required = true)
    protected Payment payment;
    @XmlElement(required = true)
    protected AuthorizationLog lastModifyLog;
    @XmlElement(required = true)
    protected AuthorizationLog lastChangeFeeLog;
    protected List<TransactionDocument> transactionDocuments;
    protected List<FeeEntry> feeEntries;
    @XmlElement(required = true)
    protected String onCreateDTSUrl;
    @XmlElement(required = true)
    protected String onCompleteUrl;
    @XmlElement(required = true)
    protected String onViewUrl;
    @XmlElement(required = true)
    protected String onEditUrl;
    @XmlElement(required = true)
    protected String onVoidUrl;
    @XmlElement(required = true)
    protected String onTerminateUrl;
    @XmlElement(required = true)
    protected String selectDocsUrl;
    @XmlElement(required = true)
    protected String selectFeesUrl;
    @XmlElement(required = true)
    protected String browseDetailsUrl;
    @XmlElement(required = true)
    protected String entryPointUrl;
    @XmlElement(required = true)
    protected String resumeUrl;
    @XmlElement(required = true)
    protected String reprintReceiptUrl;
    @XmlElement(required = true)
    protected String chatLogsUrl;
    @XmlElement(required = true)
    protected String postSelectFeeUrl;
    @XmlElement(required = true)
    protected String postCompleteUrl;
    @XmlElement(required = true)
    protected String externalUrl;
    protected List<TransactionAction> transactionActions;
    protected List<PhoneCallHistory> phoneCallHistories;
    @XmlElement(required = true)
    protected String licenseIssueZoneCode;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected TransactionType type;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar requiringDocsTime;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar completeRequiringDocsTime;
    @XmlElement(required = true)
    protected String postSelectPayments;
    protected boolean skipSelectFees;
    protected boolean skipDownloadBusinessDoc;
    @XmlElement(required = true)
    protected String skipDownloadBusinessDocIndexes;
    @XmlElement(defaultValue = "true")
    protected boolean updateFeeRequests;
    @XmlElement(required = true)
    protected String businessDocName;
    @XmlElement(required = true)
    protected String businessDocName2;
    @XmlElement(required = true)
    protected String businessDocName3;
    @XmlElement(required = true)
    protected String serviceCode;
    @XmlElement(required = true)
    protected String serviceOperationCode;
    @XmlElement(required = true)
    protected String serviceNameZh;
    @XmlElement(required = true)
    protected String serviceNamePt;
    @XmlElement(required = true)
    protected String serviceOperationNameZh;
    @XmlElement(required = true)
    protected String serviceOperationNamePt;
    protected boolean updateIssueZone;
    protected boolean needIssueLicense;
    @XmlElement(required = true)
    protected String createUid;
    @XmlElement(required = true)
    protected String createTime;
    protected boolean needCreateDTS;
    @XmlElement(required = true)
    protected String extraRemark;
    protected boolean smsClient;
    protected boolean smsAgent;

    /**
     * Gets the value of the serviceFeeRequest property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceFeeRequest property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceFeeRequest().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceFeeRequest }
     * 
     * 
     */
    public List<ServiceFeeRequest> getServiceFeeRequest() {
        if (serviceFeeRequest == null) {
            serviceFeeRequest = new ArrayList<ServiceFeeRequest>();
        }
        return this.serviceFeeRequest;
    }

    /**
     * Gets the value of the externalTxnNo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the externalTxnNo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExternalTxnNo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExternalTxnNo }
     * 
     * 
     */
    public List<ExternalTxnNo> getExternalTxnNo() {
        if (externalTxnNo == null) {
            externalTxnNo = new ArrayList<ExternalTxnNo>();
        }
        return this.externalTxnNo;
    }

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
     * \u83b7\u53d6targetDTSLocationZh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetDTSLocationZh() {
        return targetDTSLocationZh;
    }

    /**
     * \u8bbe\u7f6etargetDTSLocationZh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetDTSLocationZh(String value) {
        this.targetDTSLocationZh = value;
    }

    /**
     * \u83b7\u53d6sourceDTSLocationZh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceDTSLocationZh() {
        return sourceDTSLocationZh;
    }

    /**
     * \u8bbe\u7f6esourceDTSLocationZh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceDTSLocationZh(String value) {
        this.sourceDTSLocationZh = value;
    }

    /**
     * \u83b7\u53d6sendDTSOnComplete\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public boolean isSendDTSOnComplete() {
        return sendDTSOnComplete;
    }

    /**
     * \u8bbe\u7f6esendDTSOnComplete\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setSendDTSOnComplete(boolean value) {
        this.sendDTSOnComplete = value;
    }

    /**
     * \u83b7\u53d6zoneZh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZoneZh() {
        return zoneZh;
    }

    /**
     * \u8bbe\u7f6ezoneZh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZoneZh(String value) {
        this.zoneZh = value;
    }

    /**
     * \u83b7\u53d6licenseIssueZoneZh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicenseIssueZoneZh() {
        return licenseIssueZoneZh;
    }

    /**
     * \u8bbe\u7f6elicenseIssueZoneZh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicenseIssueZoneZh(String value) {
        this.licenseIssueZoneZh = value;
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
     * \u83b7\u53d6exemptReason\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExemptReason() {
        return exemptReason;
    }

    /**
     * \u8bbe\u7f6eexemptReason\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExemptReason(String value) {
        this.exemptReason = value;
    }

    /**
     * \u83b7\u53d6feeRemark\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeRemark() {
        return feeRemark;
    }

    /**
     * \u8bbe\u7f6efeeRemark\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeRemark(String value) {
        this.feeRemark = value;
    }

    /**
     * \u83b7\u53d6docRemark\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocRemark() {
        return docRemark;
    }

    /**
     * \u8bbe\u7f6edocRemark\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocRemark(String value) {
        this.docRemark = value;
    }

    /**
     * \u83b7\u53d6payment\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Payment }
     *     
     */
    public Payment getPayment() {
        return payment;
    }

    /**
     * \u8bbe\u7f6epayment\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Payment }
     *     
     */
    public void setPayment(Payment value) {
        this.payment = value;
    }

    /**
     * \u83b7\u53d6lastModifyLog\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link AuthorizationLog }
     *     
     */
    public AuthorizationLog getLastModifyLog() {
        return lastModifyLog;
    }

    /**
     * \u8bbe\u7f6elastModifyLog\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link AuthorizationLog }
     *     
     */
    public void setLastModifyLog(AuthorizationLog value) {
        this.lastModifyLog = value;
    }

    /**
     * \u83b7\u53d6lastChangeFeeLog\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link AuthorizationLog }
     *     
     */
    public AuthorizationLog getLastChangeFeeLog() {
        return lastChangeFeeLog;
    }

    /**
     * \u8bbe\u7f6elastChangeFeeLog\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link AuthorizationLog }
     *     
     */
    public void setLastChangeFeeLog(AuthorizationLog value) {
        this.lastChangeFeeLog = value;
    }

    /**
     * Gets the value of the transactionDocuments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transactionDocuments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransactionDocuments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransactionDocument }
     * 
     * 
     */
    public List<TransactionDocument> getTransactionDocuments() {
        if (transactionDocuments == null) {
            transactionDocuments = new ArrayList<TransactionDocument>();
        }
        return this.transactionDocuments;
    }

    /**
     * Gets the value of the feeEntries property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the feeEntries property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFeeEntries().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FeeEntry }
     * 
     * 
     */
    public List<FeeEntry> getFeeEntries() {
        if (feeEntries == null) {
            feeEntries = new ArrayList<FeeEntry>();
        }
        return this.feeEntries;
    }

    /**
     * \u83b7\u53d6onCreateDTSUrl\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnCreateDTSUrl() {
        return onCreateDTSUrl;
    }

    /**
     * \u8bbe\u7f6eonCreateDTSUrl\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnCreateDTSUrl(String value) {
        this.onCreateDTSUrl = value;
    }

    /**
     * \u83b7\u53d6onCompleteUrl\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnCompleteUrl() {
        return onCompleteUrl;
    }

    /**
     * \u8bbe\u7f6eonCompleteUrl\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnCompleteUrl(String value) {
        this.onCompleteUrl = value;
    }

    /**
     * \u83b7\u53d6onViewUrl\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnViewUrl() {
        return onViewUrl;
    }

    /**
     * \u8bbe\u7f6eonViewUrl\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnViewUrl(String value) {
        this.onViewUrl = value;
    }

    /**
     * \u83b7\u53d6onEditUrl\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnEditUrl() {
        return onEditUrl;
    }

    /**
     * \u8bbe\u7f6eonEditUrl\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnEditUrl(String value) {
        this.onEditUrl = value;
    }

    /**
     * \u83b7\u53d6onVoidUrl\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnVoidUrl() {
        return onVoidUrl;
    }

    /**
     * \u8bbe\u7f6eonVoidUrl\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnVoidUrl(String value) {
        this.onVoidUrl = value;
    }

    /**
     * \u83b7\u53d6onTerminateUrl\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnTerminateUrl() {
        return onTerminateUrl;
    }

    /**
     * \u8bbe\u7f6eonTerminateUrl\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnTerminateUrl(String value) {
        this.onTerminateUrl = value;
    }

    /**
     * \u83b7\u53d6selectDocsUrl\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSelectDocsUrl() {
        return selectDocsUrl;
    }

    /**
     * \u8bbe\u7f6eselectDocsUrl\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSelectDocsUrl(String value) {
        this.selectDocsUrl = value;
    }

    /**
     * \u83b7\u53d6selectFeesUrl\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSelectFeesUrl() {
        return selectFeesUrl;
    }

    /**
     * \u8bbe\u7f6eselectFeesUrl\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSelectFeesUrl(String value) {
        this.selectFeesUrl = value;
    }

    /**
     * \u83b7\u53d6browseDetailsUrl\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrowseDetailsUrl() {
        return browseDetailsUrl;
    }

    /**
     * \u8bbe\u7f6ebrowseDetailsUrl\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrowseDetailsUrl(String value) {
        this.browseDetailsUrl = value;
    }

    /**
     * \u83b7\u53d6entryPointUrl\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntryPointUrl() {
        return entryPointUrl;
    }

    /**
     * \u8bbe\u7f6eentryPointUrl\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntryPointUrl(String value) {
        this.entryPointUrl = value;
    }

    /**
     * \u83b7\u53d6resumeUrl\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResumeUrl() {
        return resumeUrl;
    }

    /**
     * \u8bbe\u7f6eresumeUrl\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResumeUrl(String value) {
        this.resumeUrl = value;
    }

    /**
     * \u83b7\u53d6reprintReceiptUrl\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReprintReceiptUrl() {
        return reprintReceiptUrl;
    }

    /**
     * \u8bbe\u7f6ereprintReceiptUrl\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReprintReceiptUrl(String value) {
        this.reprintReceiptUrl = value;
    }

    /**
     * \u83b7\u53d6chatLogsUrl\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChatLogsUrl() {
        return chatLogsUrl;
    }

    /**
     * \u8bbe\u7f6echatLogsUrl\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChatLogsUrl(String value) {
        this.chatLogsUrl = value;
    }

    /**
     * \u83b7\u53d6postSelectFeeUrl\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostSelectFeeUrl() {
        return postSelectFeeUrl;
    }

    /**
     * \u8bbe\u7f6epostSelectFeeUrl\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostSelectFeeUrl(String value) {
        this.postSelectFeeUrl = value;
    }

    /**
     * \u83b7\u53d6postCompleteUrl\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostCompleteUrl() {
        return postCompleteUrl;
    }

    /**
     * \u8bbe\u7f6epostCompleteUrl\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostCompleteUrl(String value) {
        this.postCompleteUrl = value;
    }

    /**
     * \u83b7\u53d6externalUrl\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalUrl() {
        return externalUrl;
    }

    /**
     * \u8bbe\u7f6eexternalUrl\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalUrl(String value) {
        this.externalUrl = value;
    }

    /**
     * Gets the value of the transactionActions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transactionActions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransactionActions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransactionAction }
     * 
     * 
     */
    public List<TransactionAction> getTransactionActions() {
        if (transactionActions == null) {
            transactionActions = new ArrayList<TransactionAction>();
        }
        return this.transactionActions;
    }

    /**
     * Gets the value of the phoneCallHistories property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the phoneCallHistories property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPhoneCallHistories().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PhoneCallHistory }
     * 
     * 
     */
    public List<PhoneCallHistory> getPhoneCallHistories() {
        if (phoneCallHistories == null) {
            phoneCallHistories = new ArrayList<PhoneCallHistory>();
        }
        return this.phoneCallHistories;
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
     * \u83b7\u53d6type\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link TransactionType }
     *     
     */
    public TransactionType getType() {
        return type;
    }

    /**
     * \u8bbe\u7f6etype\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionType }
     *     
     */
    public void setType(TransactionType value) {
        this.type = value;
    }

    /**
     * \u83b7\u53d6requiringDocsTime\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRequiringDocsTime() {
        return requiringDocsTime;
    }

    /**
     * \u8bbe\u7f6erequiringDocsTime\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRequiringDocsTime(XMLGregorianCalendar value) {
        this.requiringDocsTime = value;
    }

    /**
     * \u83b7\u53d6completeRequiringDocsTime\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCompleteRequiringDocsTime() {
        return completeRequiringDocsTime;
    }

    /**
     * \u8bbe\u7f6ecompleteRequiringDocsTime\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCompleteRequiringDocsTime(XMLGregorianCalendar value) {
        this.completeRequiringDocsTime = value;
    }

    /**
     * \u83b7\u53d6postSelectPayments\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostSelectPayments() {
        return postSelectPayments;
    }

    /**
     * \u8bbe\u7f6epostSelectPayments\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostSelectPayments(String value) {
        this.postSelectPayments = value;
    }

    /**
     * \u83b7\u53d6skipSelectFees\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public boolean isSkipSelectFees() {
        return skipSelectFees;
    }

    /**
     * \u8bbe\u7f6eskipSelectFees\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setSkipSelectFees(boolean value) {
        this.skipSelectFees = value;
    }

    /**
     * \u83b7\u53d6skipDownloadBusinessDoc\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public boolean isSkipDownloadBusinessDoc() {
        return skipDownloadBusinessDoc;
    }

    /**
     * \u8bbe\u7f6eskipDownloadBusinessDoc\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setSkipDownloadBusinessDoc(boolean value) {
        this.skipDownloadBusinessDoc = value;
    }

    /**
     * \u83b7\u53d6skipDownloadBusinessDocIndexes\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSkipDownloadBusinessDocIndexes() {
        return skipDownloadBusinessDocIndexes;
    }

    /**
     * \u8bbe\u7f6eskipDownloadBusinessDocIndexes\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSkipDownloadBusinessDocIndexes(String value) {
        this.skipDownloadBusinessDocIndexes = value;
    }

    /**
     * \u83b7\u53d6updateFeeRequests\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public boolean isUpdateFeeRequests() {
        return updateFeeRequests;
    }

    /**
     * \u8bbe\u7f6eupdateFeeRequests\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setUpdateFeeRequests(boolean value) {
        this.updateFeeRequests = value;
    }

    /**
     * \u83b7\u53d6businessDocName\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessDocName() {
        return businessDocName;
    }

    /**
     * \u8bbe\u7f6ebusinessDocName\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessDocName(String value) {
        this.businessDocName = value;
    }

    /**
     * \u83b7\u53d6businessDocName2\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessDocName2() {
        return businessDocName2;
    }

    /**
     * \u8bbe\u7f6ebusinessDocName2\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessDocName2(String value) {
        this.businessDocName2 = value;
    }

    /**
     * \u83b7\u53d6businessDocName3\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessDocName3() {
        return businessDocName3;
    }

    /**
     * \u8bbe\u7f6ebusinessDocName3\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessDocName3(String value) {
        this.businessDocName3 = value;
    }

    /**
     * \u83b7\u53d6serviceCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceCode() {
        return serviceCode;
    }

    /**
     * \u8bbe\u7f6eserviceCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceCode(String value) {
        this.serviceCode = value;
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
     * \u83b7\u53d6serviceNameZh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceNameZh() {
        return serviceNameZh;
    }

    /**
     * \u8bbe\u7f6eserviceNameZh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceNameZh(String value) {
        this.serviceNameZh = value;
    }

    /**
     * \u83b7\u53d6serviceNamePt\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceNamePt() {
        return serviceNamePt;
    }

    /**
     * \u8bbe\u7f6eserviceNamePt\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceNamePt(String value) {
        this.serviceNamePt = value;
    }

    /**
     * \u83b7\u53d6serviceOperationNameZh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceOperationNameZh() {
        return serviceOperationNameZh;
    }

    /**
     * \u8bbe\u7f6eserviceOperationNameZh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceOperationNameZh(String value) {
        this.serviceOperationNameZh = value;
    }

    /**
     * \u83b7\u53d6serviceOperationNamePt\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceOperationNamePt() {
        return serviceOperationNamePt;
    }

    /**
     * \u8bbe\u7f6eserviceOperationNamePt\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceOperationNamePt(String value) {
        this.serviceOperationNamePt = value;
    }

    /**
     * \u83b7\u53d6updateIssueZone\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public boolean isUpdateIssueZone() {
        return updateIssueZone;
    }

    /**
     * \u8bbe\u7f6eupdateIssueZone\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setUpdateIssueZone(boolean value) {
        this.updateIssueZone = value;
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
     * \u83b7\u53d6createUid\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreateUid() {
        return createUid;
    }

    /**
     * \u8bbe\u7f6ecreateUid\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreateUid(String value) {
        this.createUid = value;
    }

    /**
     * \u83b7\u53d6createTime\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * \u8bbe\u7f6ecreateTime\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreateTime(String value) {
        this.createTime = value;
    }

    /**
     * \u83b7\u53d6needCreateDTS\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public boolean isNeedCreateDTS() {
        return needCreateDTS;
    }

    /**
     * \u8bbe\u7f6eneedCreateDTS\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setNeedCreateDTS(boolean value) {
        this.needCreateDTS = value;
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
     * 
     * 												ExternalTxnNo is a Transaction Number generated
     * 												by the Client app.
     * 											
     * 
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class ExternalTxnNo {

        @XmlAttribute(name = "content")
        protected String content;
        @XmlAttribute(name = "getMobileNoUrl")
        protected String getMobileNoUrl;
        @XmlAttribute(name = "onDeliverUrl")
        protected String onDeliverUrl;
        @XmlAttribute(name = "onCreateDTSUrl")
        protected String onCreateDTSUrl;

        /**
         * \u83b7\u53d6content\u5c5e\u6027\u7684\u503c\u3002
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getContent() {
            return content;
        }

        /**
         * \u8bbe\u7f6econtent\u5c5e\u6027\u7684\u503c\u3002
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setContent(String value) {
            this.content = value;
        }

        /**
         * \u83b7\u53d6getMobileNoUrl\u5c5e\u6027\u7684\u503c\u3002
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getGetMobileNoUrl() {
            return getMobileNoUrl;
        }

        /**
         * \u8bbe\u7f6egetMobileNoUrl\u5c5e\u6027\u7684\u503c\u3002
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setGetMobileNoUrl(String value) {
            this.getMobileNoUrl = value;
        }

        /**
         * \u83b7\u53d6onDeliverUrl\u5c5e\u6027\u7684\u503c\u3002
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOnDeliverUrl() {
            return onDeliverUrl;
        }

        /**
         * \u8bbe\u7f6eonDeliverUrl\u5c5e\u6027\u7684\u503c\u3002
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOnDeliverUrl(String value) {
            this.onDeliverUrl = value;
        }

        /**
         * \u83b7\u53d6onCreateDTSUrl\u5c5e\u6027\u7684\u503c\u3002
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOnCreateDTSUrl() {
            return onCreateDTSUrl;
        }

        /**
         * \u8bbe\u7f6eonCreateDTSUrl\u5c5e\u6027\u7684\u503c\u3002
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOnCreateDTSUrl(String value) {
            this.onCreateDTSUrl = value;
        }

    }


    /**
     * 
     * 												ServiceFeeRequest from Service Portal
     * 											
     * 
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class ServiceFeeRequest {

        @XmlAttribute(name = "serviceFeeCode")
        protected String serviceFeeCode;
        @XmlAttribute(name = "remarkZh")
        protected String remarkZh;
        @XmlAttribute(name = "remarkPt")
        protected String remarkPt;
        @XmlAttribute(name = "defaultQty")
        protected Integer defaultQty;
        @XmlAttribute(name = "unitPrize")
        protected Double unitPrize;
        @XmlAttribute(name = "groupCode")
        protected String groupCode;
        @XmlAttribute(name = "groupName")
        protected String groupName;
        @XmlAttribute(name = "exempt")
        protected Boolean exempt;
        @XmlAttribute(name = "exemptTax")
        protected Boolean exemptTax;

        /**
         * \u83b7\u53d6serviceFeeCode\u5c5e\u6027\u7684\u503c\u3002
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getServiceFeeCode() {
            return serviceFeeCode;
        }

        /**
         * \u8bbe\u7f6eserviceFeeCode\u5c5e\u6027\u7684\u503c\u3002
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setServiceFeeCode(String value) {
            this.serviceFeeCode = value;
        }

        /**
         * \u83b7\u53d6remarkZh\u5c5e\u6027\u7684\u503c\u3002
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRemarkZh() {
            return remarkZh;
        }

        /**
         * \u8bbe\u7f6eremarkZh\u5c5e\u6027\u7684\u503c\u3002
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRemarkZh(String value) {
            this.remarkZh = value;
        }

        /**
         * \u83b7\u53d6remarkPt\u5c5e\u6027\u7684\u503c\u3002
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRemarkPt() {
            return remarkPt;
        }

        /**
         * \u8bbe\u7f6eremarkPt\u5c5e\u6027\u7684\u503c\u3002
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRemarkPt(String value) {
            this.remarkPt = value;
        }

        /**
         * \u83b7\u53d6defaultQty\u5c5e\u6027\u7684\u503c\u3002
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getDefaultQty() {
            return defaultQty;
        }

        /**
         * \u8bbe\u7f6edefaultQty\u5c5e\u6027\u7684\u503c\u3002
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setDefaultQty(Integer value) {
            this.defaultQty = value;
        }

        /**
         * \u83b7\u53d6unitPrize\u5c5e\u6027\u7684\u503c\u3002
         * 
         * @return
         *     possible object is
         *     {@link Double }
         *     
         */
        public Double getUnitPrize() {
            return unitPrize;
        }

        /**
         * \u8bbe\u7f6eunitPrize\u5c5e\u6027\u7684\u503c\u3002
         * 
         * @param value
         *     allowed object is
         *     {@link Double }
         *     
         */
        public void setUnitPrize(Double value) {
            this.unitPrize = value;
        }

        /**
         * \u83b7\u53d6groupCode\u5c5e\u6027\u7684\u503c\u3002
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getGroupCode() {
            return groupCode;
        }

        /**
         * \u8bbe\u7f6egroupCode\u5c5e\u6027\u7684\u503c\u3002
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setGroupCode(String value) {
            this.groupCode = value;
        }

        /**
         * \u83b7\u53d6groupName\u5c5e\u6027\u7684\u503c\u3002
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getGroupName() {
            return groupName;
        }

        /**
         * \u8bbe\u7f6egroupName\u5c5e\u6027\u7684\u503c\u3002
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setGroupName(String value) {
            this.groupName = value;
        }

        /**
         * \u83b7\u53d6exempt\u5c5e\u6027\u7684\u503c\u3002
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isExempt() {
            return exempt;
        }

        /**
         * \u8bbe\u7f6eexempt\u5c5e\u6027\u7684\u503c\u3002
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setExempt(Boolean value) {
            this.exempt = value;
        }

        /**
         * \u83b7\u53d6exemptTax\u5c5e\u6027\u7684\u503c\u3002
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isExemptTax() {
            return exemptTax;
        }

        /**
         * \u8bbe\u7f6eexemptTax\u5c5e\u6027\u7684\u503c\u3002
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setExemptTax(Boolean value) {
            this.exemptTax = value;
        }

    }

}
