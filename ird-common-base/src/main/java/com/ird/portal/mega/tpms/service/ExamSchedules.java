
package com.ird.portal.mega.tpms.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>examSchedules complex type\u7684 Java \u7c7b\u3002
 * 
 * <p>\u4ee5\u4e0b\u6a21\u5f0f\u7247\u6bb5\u6307\u5b9a\u5305\u542b\u5728\u6b64\u7c7b\u4e2d\u7684\u9884\u671f\u5185\u5bb9\u3002
 * 
 * <pre>
 * &lt;complexType name="examSchedules"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="examDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="examNamePt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="examNameZh" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="examSessionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="examType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="remainingQuota" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "examSchedules", propOrder = {
    "examDate",
    "examNamePt",
    "examNameZh",
    "examSessionCode",
    "examType",
    "remainingQuota"
})
public class ExamSchedules {

    protected String examDate;
    protected String examNamePt;
    protected String examNameZh;
    protected String examSessionCode;
    protected String examType;
    protected Integer remainingQuota;

    /**
     * \u83b7\u53d6examDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExamDate() {
        return examDate;
    }

    /**
     * \u8bbe\u7f6eexamDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExamDate(String value) {
        this.examDate = value;
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
     * \u83b7\u53d6remainingQuota\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRemainingQuota() {
        return remainingQuota;
    }

    /**
     * \u8bbe\u7f6eremainingQuota\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRemainingQuota(Integer value) {
        this.remainingQuota = value;
    }

}
