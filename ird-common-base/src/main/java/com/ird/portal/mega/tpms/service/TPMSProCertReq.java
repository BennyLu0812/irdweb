
package com.ird.portal.mega.tpms.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>TPMSProCertReq complex type\u7684 Java \u7c7b\u3002
 * 
 * <p>\u4ee5\u4e0b\u6a21\u5f0f\u7247\u6bb5\u6307\u5b9a\u5305\u542b\u5728\u6b64\u7c7b\u4e2d\u7684\u9884\u671f\u5185\u5bb9\u3002
 * 
 * <pre>
 * &lt;complexType name="TPMSProCertReq"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="expiryDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="issueCertRemark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="licNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="licType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="sendDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="taxAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="taxiProCertLabelNo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="taxiProCertNo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="taxiProCertPrintNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="txnNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TPMSProCertReq", propOrder = {
    "expiryDate",
    "issueCertRemark",
    "licNo",
    "licType",
    "sendDate",
    "taxAmount",
    "taxiProCertLabelNo",
    "taxiProCertNo",
    "taxiProCertPrintNo",
    "txnNo"
})
public class TPMSProCertReq {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expiryDate;
    protected String issueCertRemark;
    protected String licNo;
    protected String licType;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar sendDate;
    protected Double taxAmount;
    protected Long taxiProCertLabelNo;
    protected Long taxiProCertNo;
    protected String taxiProCertPrintNo;
    protected String txnNo;

    /**
     * \u83b7\u53d6expiryDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpiryDate() {
        return expiryDate;
    }

    /**
     * \u8bbe\u7f6eexpiryDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpiryDate(XMLGregorianCalendar value) {
        this.expiryDate = value;
    }

    /**
     * \u83b7\u53d6issueCertRemark\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssueCertRemark() {
        return issueCertRemark;
    }

    /**
     * \u8bbe\u7f6eissueCertRemark\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssueCertRemark(String value) {
        this.issueCertRemark = value;
    }

    /**
     * \u83b7\u53d6licNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicNo() {
        return licNo;
    }

    /**
     * \u8bbe\u7f6elicNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicNo(String value) {
        this.licNo = value;
    }

    /**
     * \u83b7\u53d6licType\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicType() {
        return licType;
    }

    /**
     * \u8bbe\u7f6elicType\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicType(String value) {
        this.licType = value;
    }

    /**
     * \u83b7\u53d6sendDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSendDate() {
        return sendDate;
    }

    /**
     * \u8bbe\u7f6esendDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSendDate(XMLGregorianCalendar value) {
        this.sendDate = value;
    }

    /**
     * \u83b7\u53d6taxAmount\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTaxAmount() {
        return taxAmount;
    }

    /**
     * \u8bbe\u7f6etaxAmount\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTaxAmount(Double value) {
        this.taxAmount = value;
    }

    /**
     * \u83b7\u53d6taxiProCertLabelNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTaxiProCertLabelNo() {
        return taxiProCertLabelNo;
    }

    /**
     * \u8bbe\u7f6etaxiProCertLabelNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTaxiProCertLabelNo(Long value) {
        this.taxiProCertLabelNo = value;
    }

    /**
     * \u83b7\u53d6taxiProCertNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTaxiProCertNo() {
        return taxiProCertNo;
    }

    /**
     * \u8bbe\u7f6etaxiProCertNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTaxiProCertNo(Long value) {
        this.taxiProCertNo = value;
    }

    /**
     * \u83b7\u53d6taxiProCertPrintNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaxiProCertPrintNo() {
        return taxiProCertPrintNo;
    }

    /**
     * \u8bbe\u7f6etaxiProCertPrintNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxiProCertPrintNo(String value) {
        this.taxiProCertPrintNo = value;
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

}
