
package com.ird.portal.mega.tpms.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>TPMSProCertFine complex type\u7684 Java \u7c7b\u3002
 * 
 * <p>\u4ee5\u4e0b\u6a21\u5f0f\u7247\u6bb5\u6307\u5b9a\u5305\u542b\u5728\u6b64\u7c7b\u4e2d\u7684\u9884\u671f\u5185\u5bb9\u3002
 * 
 * <pre>
 * &lt;complexType name="TPMSProCertFine"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="actualAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="debateDocSubDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="debateDocumentSign" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="fineId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="finePayDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="fineReasonCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fineReasonNameZh" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="indictmentNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="indictmentSentDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="issueDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="newLaw" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="operator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="penaltyNoticeDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="penaltyNoticeDateSec" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="penaltyNoticeNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="penaltyNoticeNoSec" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="reduceEffectiveDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="special" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="statusCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="uniqueryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TPMSProCertFine", propOrder = {
    "actualAmount",
    "amount",
    "debateDocSubDate",
    "debateDocumentSign",
    "fineId",
    "finePayDate",
    "fineReasonCode",
    "fineReasonNameZh",
    "indictmentNo",
    "indictmentSentDate",
    "issueDate",
    "newLaw",
    "operator",
    "penaltyNoticeDate",
    "penaltyNoticeDateSec",
    "penaltyNoticeNo",
    "penaltyNoticeNoSec",
    "reduceEffectiveDate",
    "special",
    "statusCode",
    "uniqueryCode"
})
public class TPMSProCertFine {

    protected Double actualAmount;
    protected Double amount;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar debateDocSubDate;
    protected Boolean debateDocumentSign;
    protected Long fineId;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar finePayDate;
    protected String fineReasonCode;
    protected String fineReasonNameZh;
    protected String indictmentNo;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar indictmentSentDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar issueDate;
    protected Integer newLaw;
    protected String operator;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar penaltyNoticeDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar penaltyNoticeDateSec;
    protected String penaltyNoticeNo;
    protected String penaltyNoticeNoSec;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar reduceEffectiveDate;
    protected String special;
    protected String statusCode;
    protected String uniqueryCode;

    /**
     * \u83b7\u53d6actualAmount\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getActualAmount() {
        return actualAmount;
    }

    /**
     * \u8bbe\u7f6eactualAmount\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setActualAmount(Double value) {
        this.actualAmount = value;
    }

    /**
     * \u83b7\u53d6amount\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * \u8bbe\u7f6eamount\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAmount(Double value) {
        this.amount = value;
    }

    /**
     * \u83b7\u53d6debateDocSubDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDebateDocSubDate() {
        return debateDocSubDate;
    }

    /**
     * \u8bbe\u7f6edebateDocSubDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDebateDocSubDate(XMLGregorianCalendar value) {
        this.debateDocSubDate = value;
    }

    /**
     * \u83b7\u53d6debateDocumentSign\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDebateDocumentSign() {
        return debateDocumentSign;
    }

    /**
     * \u8bbe\u7f6edebateDocumentSign\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDebateDocumentSign(Boolean value) {
        this.debateDocumentSign = value;
    }

    /**
     * \u83b7\u53d6fineId\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFineId() {
        return fineId;
    }

    /**
     * \u8bbe\u7f6efineId\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFineId(Long value) {
        this.fineId = value;
    }

    /**
     * \u83b7\u53d6finePayDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFinePayDate() {
        return finePayDate;
    }

    /**
     * \u8bbe\u7f6efinePayDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFinePayDate(XMLGregorianCalendar value) {
        this.finePayDate = value;
    }

    /**
     * \u83b7\u53d6fineReasonCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFineReasonCode() {
        return fineReasonCode;
    }

    /**
     * \u8bbe\u7f6efineReasonCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFineReasonCode(String value) {
        this.fineReasonCode = value;
    }

    /**
     * \u83b7\u53d6fineReasonNameZh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFineReasonNameZh() {
        return fineReasonNameZh;
    }

    /**
     * \u8bbe\u7f6efineReasonNameZh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFineReasonNameZh(String value) {
        this.fineReasonNameZh = value;
    }

    /**
     * \u83b7\u53d6indictmentNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndictmentNo() {
        return indictmentNo;
    }

    /**
     * \u8bbe\u7f6eindictmentNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndictmentNo(String value) {
        this.indictmentNo = value;
    }

    /**
     * \u83b7\u53d6indictmentSentDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getIndictmentSentDate() {
        return indictmentSentDate;
    }

    /**
     * \u8bbe\u7f6eindictmentSentDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setIndictmentSentDate(XMLGregorianCalendar value) {
        this.indictmentSentDate = value;
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
     * \u83b7\u53d6newLaw\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNewLaw() {
        return newLaw;
    }

    /**
     * \u8bbe\u7f6enewLaw\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNewLaw(Integer value) {
        this.newLaw = value;
    }

    /**
     * \u83b7\u53d6operator\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperator() {
        return operator;
    }

    /**
     * \u8bbe\u7f6eoperator\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperator(String value) {
        this.operator = value;
    }

    /**
     * \u83b7\u53d6penaltyNoticeDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPenaltyNoticeDate() {
        return penaltyNoticeDate;
    }

    /**
     * \u8bbe\u7f6epenaltyNoticeDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPenaltyNoticeDate(XMLGregorianCalendar value) {
        this.penaltyNoticeDate = value;
    }

    /**
     * \u83b7\u53d6penaltyNoticeDateSec\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPenaltyNoticeDateSec() {
        return penaltyNoticeDateSec;
    }

    /**
     * \u8bbe\u7f6epenaltyNoticeDateSec\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPenaltyNoticeDateSec(XMLGregorianCalendar value) {
        this.penaltyNoticeDateSec = value;
    }

    /**
     * \u83b7\u53d6penaltyNoticeNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPenaltyNoticeNo() {
        return penaltyNoticeNo;
    }

    /**
     * \u8bbe\u7f6epenaltyNoticeNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPenaltyNoticeNo(String value) {
        this.penaltyNoticeNo = value;
    }

    /**
     * \u83b7\u53d6penaltyNoticeNoSec\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPenaltyNoticeNoSec() {
        return penaltyNoticeNoSec;
    }

    /**
     * \u8bbe\u7f6epenaltyNoticeNoSec\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPenaltyNoticeNoSec(String value) {
        this.penaltyNoticeNoSec = value;
    }

    /**
     * \u83b7\u53d6reduceEffectiveDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getReduceEffectiveDate() {
        return reduceEffectiveDate;
    }

    /**
     * \u8bbe\u7f6ereduceEffectiveDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setReduceEffectiveDate(XMLGregorianCalendar value) {
        this.reduceEffectiveDate = value;
    }

    /**
     * \u83b7\u53d6special\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecial() {
        return special;
    }

    /**
     * \u8bbe\u7f6especial\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecial(String value) {
        this.special = value;
    }

    /**
     * \u83b7\u53d6statusCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusCode() {
        return statusCode;
    }

    /**
     * \u8bbe\u7f6estatusCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusCode(String value) {
        this.statusCode = value;
    }

    /**
     * \u83b7\u53d6uniqueryCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUniqueryCode() {
        return uniqueryCode;
    }

    /**
     * \u8bbe\u7f6euniqueryCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUniqueryCode(String value) {
        this.uniqueryCode = value;
    }

}
