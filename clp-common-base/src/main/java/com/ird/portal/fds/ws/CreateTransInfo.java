
package com.ird.portal.fds.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * 
 * 								CreateTransInfo is the info to AutoCreateTransaction
 * 							
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateTransInfo", propOrder = {
    "serviceOperationCode",
    "paymentMethodValue",
    "issueZoneCode",
    "issueDate",
    "jobDate",
    "loginId",
    "smsClient",
    "smsAgent",
    "incomeIP",
    "txnno"
})
public class CreateTransInfo {

    @XmlElement(required = true)
    protected String serviceOperationCode;
    @XmlElement(required = true)
    protected String paymentMethodValue;
    @XmlElement(required = true)
    protected String issueZoneCode;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar issueDate;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar jobDate;
    @XmlElement(required = true)
    protected String loginId;
    protected boolean smsClient;
    protected boolean smsAgent;
    @XmlElement(required = true)
    protected String incomeIP;
    @XmlElement(required = true)
    protected String txnno;

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
     * \u83b7\u53d6paymentMethodValue\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentMethodValue() {
        return paymentMethodValue;
    }

    /**
     * \u8bbe\u7f6epaymentMethodValue\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentMethodValue(String value) {
        this.paymentMethodValue = value;
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
     * \u83b7\u53d6issueDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getIssueDate() {
        return issueDate;
    }

    /**
     * \u8bbe\u7f6eissueDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setIssueDate(XMLGregorianCalendar value) {
        this.issueDate = value;
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
     * \u83b7\u53d6txnno\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTxnno() {
        return txnno;
    }

    /**
     * \u8bbe\u7f6etxnno\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTxnno(String value) {
        this.txnno = value;
    }

}
