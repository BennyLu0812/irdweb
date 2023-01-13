
package com.ird.portal.mega.tpms.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>TPMSExamRecord complex type\u7684 Java \u7c7b\u3002
 * 
 * <p>\u4ee5\u4e0b\u6a21\u5f0f\u7247\u6bb5\u6307\u5b9a\u5305\u542b\u5728\u6b64\u7c7b\u4e2d\u7684\u9884\u671f\u5185\u5bb9\u3002
 * 
 * <pre>
 * &lt;complexType name="TPMSExamRecord"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="examAppDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="examDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="examResultCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="examSessionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="examStateCode" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="issueDeadline" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="resultIssueDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TPMSExamRecord", propOrder = {
    "examAppDate",
    "examDate",
    "examResultCode",
    "examSessionCode",
    "examStateCode",
    "issueDeadline",
    "resultIssueDate"
})
public class TPMSExamRecord {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar examAppDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar examDate;
    protected String examResultCode;
    protected String examSessionCode;
    protected Integer examStateCode;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar issueDeadline;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar resultIssueDate;

    /**
     * \u83b7\u53d6examAppDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExamAppDate() {
        return examAppDate;
    }

    /**
     * \u8bbe\u7f6eexamAppDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExamAppDate(XMLGregorianCalendar value) {
        this.examAppDate = value;
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
     * \u83b7\u53d6examResultCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExamResultCode() {
        return examResultCode;
    }

    /**
     * \u8bbe\u7f6eexamResultCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExamResultCode(String value) {
        this.examResultCode = value;
    }

    /**
     * \u83b7\u53d6examSessionCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExamSessionCode() {
        return examSessionCode;
    }

    /**
     * \u8bbe\u7f6eexamSessionCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExamSessionCode(String value) {
        this.examSessionCode = value;
    }

    /**
     * \u83b7\u53d6examStateCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getExamStateCode() {
        return examStateCode;
    }

    /**
     * \u8bbe\u7f6eexamStateCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setExamStateCode(Integer value) {
        this.examStateCode = value;
    }

    /**
     * \u83b7\u53d6issueDeadline\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getIssueDeadline() {
        return issueDeadline;
    }

    /**
     * \u8bbe\u7f6eissueDeadline\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setIssueDeadline(XMLGregorianCalendar value) {
        this.issueDeadline = value;
    }

    /**
     * \u83b7\u53d6resultIssueDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getResultIssueDate() {
        return resultIssueDate;
    }

    /**
     * \u8bbe\u7f6eresultIssueDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setResultIssueDate(XMLGregorianCalendar value) {
        this.resultIssueDate = value;
    }

}
