
package com.ird.portal.be.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * 
 * 								A TPMS Exam Arragement From TPMS-BE
 * 							
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExamSchedules")
public class ExamSchedules {

    @XmlAttribute(name = "examNameZh")
    protected String examNameZh;
    @XmlAttribute(name = "examNamePt")
    protected String examNamePt;
    @XmlAttribute(name = "examType")
    protected String examType;
    @XmlAttribute(name = "examDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar examDate;
    @XmlAttribute(name = "examSessionCode")
    protected String examSessionCode;
    @XmlAttribute(name = "remainingQuota")
    protected String remainingQuota;

    /**
     * \u83b7\u53d6examNameZh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExamNameZh() {
        return examNameZh;
    }

    /**
     * \u8bbe\u7f6eexamNameZh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExamNameZh(String value) {
        this.examNameZh = value;
    }

    /**
     * \u83b7\u53d6examNamePt\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExamNamePt() {
        return examNamePt;
    }

    /**
     * \u8bbe\u7f6eexamNamePt\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExamNamePt(String value) {
        this.examNamePt = value;
    }

    /**
     * \u83b7\u53d6examType\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExamType() {
        return examType;
    }

    /**
     * \u8bbe\u7f6eexamType\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExamType(String value) {
        this.examType = value;
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
     * \u83b7\u53d6remainingQuota\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemainingQuota() {
        return remainingQuota;
    }

    /**
     * \u8bbe\u7f6eremainingQuota\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemainingQuota(String value) {
        this.remainingQuota = value;
    }

}
