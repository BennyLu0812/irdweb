
package com.ird.portal.be.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * 
 * 								An International Driving License Record in BE
 * 							
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InterDrivingLicRecord")
public class InterDrivingLicRecord {

    @XmlAttribute(name = "txnNo")
    protected String txnNo;
    @XmlAttribute(name = "interPrintNo")
    protected String interPrintNo;
    @XmlAttribute(name = "interIssueDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar interIssueDate;
    @XmlAttribute(name = "interExpiryDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar interExpiryDate;
    @XmlAttribute(name = "workflowstatus")
    protected String workflowstatus;
    @XmlAttribute(name = "storageStatus")
    protected String storageStatus;
    @XmlAttribute(name = "zoneCode")
    protected String zoneCode;
    @XmlAttribute(name = "zoneName")
    protected String zoneName;
    @XmlAttribute(name = "licenseIssueDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar licenseIssueDate;
    @XmlAttribute(name = "detailsURL")
    protected String detailsURL;

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
     * \u83b7\u53d6interPrintNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterPrintNo() {
        return interPrintNo;
    }

    /**
     * \u8bbe\u7f6einterPrintNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterPrintNo(String value) {
        this.interPrintNo = value;
    }

    /**
     * \u83b7\u53d6interIssueDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getInterIssueDate() {
        return interIssueDate;
    }

    /**
     * \u8bbe\u7f6einterIssueDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setInterIssueDate(XMLGregorianCalendar value) {
        this.interIssueDate = value;
    }

    /**
     * \u83b7\u53d6interExpiryDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getInterExpiryDate() {
        return interExpiryDate;
    }

    /**
     * \u8bbe\u7f6einterExpiryDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setInterExpiryDate(XMLGregorianCalendar value) {
        this.interExpiryDate = value;
    }

    /**
     * \u83b7\u53d6workflowstatus\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkflowstatus() {
        return workflowstatus;
    }

    /**
     * \u8bbe\u7f6eworkflowstatus\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkflowstatus(String value) {
        this.workflowstatus = value;
    }

    /**
     * \u83b7\u53d6storageStatus\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStorageStatus() {
        return storageStatus;
    }

    /**
     * \u8bbe\u7f6estorageStatus\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStorageStatus(String value) {
        this.storageStatus = value;
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
     * \u83b7\u53d6zoneName\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZoneName() {
        return zoneName;
    }

    /**
     * \u8bbe\u7f6ezoneName\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZoneName(String value) {
        this.zoneName = value;
    }

    /**
     * \u83b7\u53d6licenseIssueDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLicenseIssueDate() {
        return licenseIssueDate;
    }

    /**
     * \u8bbe\u7f6elicenseIssueDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLicenseIssueDate(XMLGregorianCalendar value) {
        this.licenseIssueDate = value;
    }

    /**
     * \u83b7\u53d6detailsURL\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDetailsURL() {
        return detailsURL;
    }

    /**
     * \u8bbe\u7f6edetailsURL\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDetailsURL(String value) {
        this.detailsURL = value;
    }

}
