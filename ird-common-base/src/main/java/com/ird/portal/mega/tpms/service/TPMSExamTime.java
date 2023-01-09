
package com.ird.portal.mega.tpms.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>TPMSExamTime complex type\u7684 Java \u7c7b\u3002
 * 
 * <p>\u4ee5\u4e0b\u6a21\u5f0f\u7247\u6bb5\u6307\u5b9a\u5305\u542b\u5728\u6b64\u7c7b\u4e2d\u7684\u9884\u671f\u5185\u5bb9\u3002
 * 
 * <pre>
 * &lt;complexType name="TPMSExamTime"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="candidateInfoId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="courseCompeleteDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="examAddrPt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="examAddrZh" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="examCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="examSeatNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="examSequence" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="examTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="examTimeId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TPMSExamTime", propOrder = {
    "candidateInfoId",
    "courseCompeleteDate",
    "examAddrPt",
    "examAddrZh",
    "examCode",
    "examSeatNo",
    "examSequence",
    "examTime",
    "examTimeId"
})
public class TPMSExamTime {

    protected Long candidateInfoId;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar courseCompeleteDate;
    protected String examAddrPt;
    protected String examAddrZh;
    protected String examCode;
    protected String examSeatNo;
    protected Integer examSequence;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar examTime;
    protected Long examTimeId;

    /**
     * \u83b7\u53d6candidateInfoId\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCandidateInfoId() {
        return candidateInfoId;
    }

    /**
     * \u8bbe\u7f6ecandidateInfoId\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCandidateInfoId(Long value) {
        this.candidateInfoId = value;
    }

    /**
     * \u83b7\u53d6courseCompeleteDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCourseCompeleteDate() {
        return courseCompeleteDate;
    }

    /**
     * \u8bbe\u7f6ecourseCompeleteDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCourseCompeleteDate(XMLGregorianCalendar value) {
        this.courseCompeleteDate = value;
    }

    /**
     * \u83b7\u53d6examAddrPt\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExamAddrPt() {
        return examAddrPt;
    }

    /**
     * \u8bbe\u7f6eexamAddrPt\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExamAddrPt(String value) {
        this.examAddrPt = value;
    }

    /**
     * \u83b7\u53d6examAddrZh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExamAddrZh() {
        return examAddrZh;
    }

    /**
     * \u8bbe\u7f6eexamAddrZh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExamAddrZh(String value) {
        this.examAddrZh = value;
    }

    /**
     * \u83b7\u53d6examCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExamCode() {
        return examCode;
    }

    /**
     * \u8bbe\u7f6eexamCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExamCode(String value) {
        this.examCode = value;
    }

    /**
     * \u83b7\u53d6examSeatNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExamSeatNo() {
        return examSeatNo;
    }

    /**
     * \u8bbe\u7f6eexamSeatNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExamSeatNo(String value) {
        this.examSeatNo = value;
    }

    /**
     * \u83b7\u53d6examSequence\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getExamSequence() {
        return examSequence;
    }

    /**
     * \u8bbe\u7f6eexamSequence\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setExamSequence(Integer value) {
        this.examSequence = value;
    }

    /**
     * \u83b7\u53d6examTime\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExamTime() {
        return examTime;
    }

    /**
     * \u8bbe\u7f6eexamTime\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExamTime(XMLGregorianCalendar value) {
        this.examTime = value;
    }

    /**
     * \u83b7\u53d6examTimeId\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getExamTimeId() {
        return examTimeId;
    }

    /**
     * \u8bbe\u7f6eexamTimeId\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setExamTimeId(Long value) {
        this.examTimeId = value;
    }

}
