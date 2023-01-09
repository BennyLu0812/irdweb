
package com.ird.portal.be.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * 
 * 								A TPMS Driving License Record in TPMS-BE
 * 							
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TaxiDrivingLicense")
public class TaxiDrivingLicense {

    @XmlAttribute(name = "taxiProCertNo")
    protected String taxiProCertNo;
    @XmlAttribute(name = "certLabelNo")
    protected String certLabelNo;
    @XmlAttribute(name = "certLabelYear")
    protected String certLabelYear;
    @XmlAttribute(name = "sendDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar sendDate;
    @XmlAttribute(name = "examDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar examDate;
    @XmlAttribute(name = "status")
    protected String status;
    @XmlAttribute(name = "createUid")
    protected String createUid;
    @XmlAttribute(name = "createTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createTime;
    @XmlAttribute(name = "updateUid")
    protected String updateUid;
    @XmlAttribute(name = "updateTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar updateTime;
    @XmlAttribute(name = "detailsURL")
    protected String detailsURL;
    @XmlAttribute(name = "effectiveDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar effectiveDate;

    /**
     * \u83b7\u53d6taxiProCertNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaxiProCertNo() {
        return taxiProCertNo;
    }

    /**
     * \u8bbe\u7f6etaxiProCertNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxiProCertNo(String value) {
        this.taxiProCertNo = value;
    }

    /**
     * \u83b7\u53d6certLabelNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCertLabelNo() {
        return certLabelNo;
    }

    /**
     * \u8bbe\u7f6ecertLabelNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCertLabelNo(String value) {
        this.certLabelNo = value;
    }

    /**
     * \u83b7\u53d6certLabelYear\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCertLabelYear() {
        return certLabelYear;
    }

    /**
     * \u8bbe\u7f6ecertLabelYear\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCertLabelYear(String value) {
        this.certLabelYear = value;
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
     * \u83b7\u53d6examDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExamDate() {
        return examDate;
    }

    /**
     * \u8bbe\u7f6eexamDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExamDate(XMLGregorianCalendar value) {
        this.examDate = value;
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
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreateTime() {
        return createTime;
    }

    /**
     * \u8bbe\u7f6ecreateTime\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreateTime(XMLGregorianCalendar value) {
        this.createTime = value;
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

    /**
     * \u83b7\u53d6updateTime\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUpdateTime() {
        return updateTime;
    }

    /**
     * \u8bbe\u7f6eupdateTime\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUpdateTime(XMLGregorianCalendar value) {
        this.updateTime = value;
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

    /**
     * \u83b7\u53d6effectiveDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * \u8bbe\u7f6eeffectiveDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEffectiveDate(XMLGregorianCalendar value) {
        this.effectiveDate = value;
    }

}
