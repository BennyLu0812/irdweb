
package com.ird.portal.fds.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * 
 * 								DayEndInfo is the more information for DayEnd.
 * 							
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DayEndInfo")
public class DayEndInfo {

    @XmlAttribute(name = "receiptNoFull")
    protected String receiptNoFull;
    @XmlAttribute(name = "receiptType")
    protected String receiptType;
    @XmlAttribute(name = "receiptNo")
    protected String receiptNo;
    @XmlAttribute(name = "receiptItemSeq")
    protected Integer receiptItemSeq;
    @XmlAttribute(name = "receiptDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar receiptDate;
    @XmlAttribute(name = "receiptCreator")
    protected String receiptCreator;
    @XmlAttribute(name = "receiptCreateDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar receiptCreateDate;
    @XmlAttribute(name = "incomeAmount")
    protected Double incomeAmount;
    @XmlAttribute(name = "taxAmount")
    protected Double taxAmount;
    @XmlAttribute(name = "paymentType")
    protected String paymentType;
    @XmlAttribute(name = "expandCategoryCode")
    protected String expandCategoryCode;
    @XmlAttribute(name = "processId")
    protected Integer processId;
    @XmlAttribute(name = "uniqueryCode")
    protected String uniqueryCode;
    @XmlAttribute(name = "locationCode")
    protected String locationCode;
    @XmlAttribute(name = "custId")
    protected String custId;
    @XmlAttribute(name = "custName_zh")
    protected String custNameZh;
    @XmlAttribute(name = "custName_pt")
    protected String custNamePt;
    @XmlAttribute(name = "feeItemId")
    protected Integer feeItemId;
    @XmlAttribute(name = "feeItemCode")
    protected String feeItemCode;
    @XmlAttribute(name = "feeItemName_zh")
    protected String feeItemNameZh;
    @XmlAttribute(name = "feeItemName_pt")
    protected String feeItemNamePt;
    @XmlAttribute(name = "feeItemType")
    protected String feeItemType;
    @XmlAttribute(name = "incomeRubricaCode")
    protected String incomeRubricaCode;
    @XmlAttribute(name = "incomeReceitaCode")
    protected String incomeReceitaCode;
    @XmlAttribute(name = "taxRubricaCode")
    protected String taxRubricaCode;
    @XmlAttribute(name = "taxReceitaCode")
    protected String taxReceitaCode;
    @XmlAttribute(name = "departmentCode")
    protected String departmentCode;
    @XmlAttribute(name = "applicationCode")
    protected String applicationCode;
    @XmlAttribute(name = "status")
    protected String status;
    @XmlAttribute(name = "zoneCode")
    protected String zoneCode;
    @XmlAttribute(name = "serviceName")
    protected String serviceName;
    @XmlAttribute(name = "operationName_zh")
    protected String operationNameZh;
    @XmlAttribute(name = "operationName_pt")
    protected String operationNamePt;
    @XmlAttribute(name = "checkSrcName")
    protected String checkSrcName;
    @XmlAttribute(name = "additionalCash")
    protected Double additionalCash;
    @XmlAttribute(name = "depName_zh")
    protected String depNameZh;
    @XmlAttribute(name = "depName_pt")
    protected String depNamePt;
    @XmlAttribute(name = "financialCode")
    protected String financialCode;
    @XmlAttribute(name = "paymentId")
    protected Integer paymentId;
    @XmlAttribute(name = "feeItemRemark_zh")
    protected String feeItemRemarkZh;
    @XmlAttribute(name = "feeItemRemark_pt")
    protected String feeItemRemarkPt;
    @XmlAttribute(name = "exempt")
    protected Boolean exempt;
    @XmlAttribute(name = "exemptTax")
    protected Boolean exemptTax;

    /**
     * \u83b7\u53d6receiptNoFull\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReceiptNoFull() {
        return receiptNoFull;
    }

    /**
     * \u8bbe\u7f6ereceiptNoFull\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReceiptNoFull(String value) {
        this.receiptNoFull = value;
    }

    /**
     * \u83b7\u53d6receiptType\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReceiptType() {
        return receiptType;
    }

    /**
     * \u8bbe\u7f6ereceiptType\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReceiptType(String value) {
        this.receiptType = value;
    }

    /**
     * \u83b7\u53d6receiptNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReceiptNo() {
        return receiptNo;
    }

    /**
     * \u8bbe\u7f6ereceiptNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReceiptNo(String value) {
        this.receiptNo = value;
    }

    /**
     * \u83b7\u53d6receiptItemSeq\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getReceiptItemSeq() {
        return receiptItemSeq;
    }

    /**
     * \u8bbe\u7f6ereceiptItemSeq\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setReceiptItemSeq(Integer value) {
        this.receiptItemSeq = value;
    }

    /**
     * \u83b7\u53d6receiptDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getReceiptDate() {
        return receiptDate;
    }

    /**
     * \u8bbe\u7f6ereceiptDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setReceiptDate(XMLGregorianCalendar value) {
        this.receiptDate = value;
    }

    /**
     * \u83b7\u53d6receiptCreator\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReceiptCreator() {
        return receiptCreator;
    }

    /**
     * \u8bbe\u7f6ereceiptCreator\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReceiptCreator(String value) {
        this.receiptCreator = value;
    }

    /**
     * \u83b7\u53d6receiptCreateDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getReceiptCreateDate() {
        return receiptCreateDate;
    }

    /**
     * \u8bbe\u7f6ereceiptCreateDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setReceiptCreateDate(XMLGregorianCalendar value) {
        this.receiptCreateDate = value;
    }

    /**
     * \u83b7\u53d6incomeAmount\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getIncomeAmount() {
        return incomeAmount;
    }

    /**
     * \u8bbe\u7f6eincomeAmount\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setIncomeAmount(Double value) {
        this.incomeAmount = value;
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
     * \u83b7\u53d6paymentType\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentType() {
        return paymentType;
    }

    /**
     * \u8bbe\u7f6epaymentType\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentType(String value) {
        this.paymentType = value;
    }

    /**
     * \u83b7\u53d6expandCategoryCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpandCategoryCode() {
        return expandCategoryCode;
    }

    /**
     * \u8bbe\u7f6eexpandCategoryCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpandCategoryCode(String value) {
        this.expandCategoryCode = value;
    }

    /**
     * \u83b7\u53d6processId\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getProcessId() {
        return processId;
    }

    /**
     * \u8bbe\u7f6eprocessId\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setProcessId(Integer value) {
        this.processId = value;
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

    /**
     * \u83b7\u53d6locationCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocationCode() {
        return locationCode;
    }

    /**
     * \u8bbe\u7f6elocationCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocationCode(String value) {
        this.locationCode = value;
    }

    /**
     * \u83b7\u53d6custId\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustId() {
        return custId;
    }

    /**
     * \u8bbe\u7f6ecustId\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustId(String value) {
        this.custId = value;
    }

    /**
     * \u83b7\u53d6custNameZh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustNameZh() {
        return custNameZh;
    }

    /**
     * \u8bbe\u7f6ecustNameZh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustNameZh(String value) {
        this.custNameZh = value;
    }

    /**
     * \u83b7\u53d6custNamePt\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustNamePt() {
        return custNamePt;
    }

    /**
     * \u8bbe\u7f6ecustNamePt\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustNamePt(String value) {
        this.custNamePt = value;
    }

    /**
     * \u83b7\u53d6feeItemId\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFeeItemId() {
        return feeItemId;
    }

    /**
     * \u8bbe\u7f6efeeItemId\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFeeItemId(Integer value) {
        this.feeItemId = value;
    }

    /**
     * \u83b7\u53d6feeItemCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeItemCode() {
        return feeItemCode;
    }

    /**
     * \u8bbe\u7f6efeeItemCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeItemCode(String value) {
        this.feeItemCode = value;
    }

    /**
     * \u83b7\u53d6feeItemNameZh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeItemNameZh() {
        return feeItemNameZh;
    }

    /**
     * \u8bbe\u7f6efeeItemNameZh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeItemNameZh(String value) {
        this.feeItemNameZh = value;
    }

    /**
     * \u83b7\u53d6feeItemNamePt\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeItemNamePt() {
        return feeItemNamePt;
    }

    /**
     * \u8bbe\u7f6efeeItemNamePt\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeItemNamePt(String value) {
        this.feeItemNamePt = value;
    }

    /**
     * \u83b7\u53d6feeItemType\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeItemType() {
        return feeItemType;
    }

    /**
     * \u8bbe\u7f6efeeItemType\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeItemType(String value) {
        this.feeItemType = value;
    }

    /**
     * \u83b7\u53d6incomeRubricaCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIncomeRubricaCode() {
        return incomeRubricaCode;
    }

    /**
     * \u8bbe\u7f6eincomeRubricaCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIncomeRubricaCode(String value) {
        this.incomeRubricaCode = value;
    }

    /**
     * \u83b7\u53d6incomeReceitaCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIncomeReceitaCode() {
        return incomeReceitaCode;
    }

    /**
     * \u8bbe\u7f6eincomeReceitaCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIncomeReceitaCode(String value) {
        this.incomeReceitaCode = value;
    }

    /**
     * \u83b7\u53d6taxRubricaCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaxRubricaCode() {
        return taxRubricaCode;
    }

    /**
     * \u8bbe\u7f6etaxRubricaCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxRubricaCode(String value) {
        this.taxRubricaCode = value;
    }

    /**
     * \u83b7\u53d6taxReceitaCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaxReceitaCode() {
        return taxReceitaCode;
    }

    /**
     * \u8bbe\u7f6etaxReceitaCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxReceitaCode(String value) {
        this.taxReceitaCode = value;
    }

    /**
     * \u83b7\u53d6departmentCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartmentCode() {
        return departmentCode;
    }

    /**
     * \u8bbe\u7f6edepartmentCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepartmentCode(String value) {
        this.departmentCode = value;
    }

    /**
     * \u83b7\u53d6applicationCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicationCode() {
        return applicationCode;
    }

    /**
     * \u8bbe\u7f6eapplicationCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicationCode(String value) {
        this.applicationCode = value;
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
     * \u83b7\u53d6serviceName\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * \u8bbe\u7f6eserviceName\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceName(String value) {
        this.serviceName = value;
    }

    /**
     * \u83b7\u53d6operationNameZh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperationNameZh() {
        return operationNameZh;
    }

    /**
     * \u8bbe\u7f6eoperationNameZh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperationNameZh(String value) {
        this.operationNameZh = value;
    }

    /**
     * \u83b7\u53d6operationNamePt\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperationNamePt() {
        return operationNamePt;
    }

    /**
     * \u8bbe\u7f6eoperationNamePt\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperationNamePt(String value) {
        this.operationNamePt = value;
    }

    /**
     * \u83b7\u53d6checkSrcName\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCheckSrcName() {
        return checkSrcName;
    }

    /**
     * \u8bbe\u7f6echeckSrcName\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCheckSrcName(String value) {
        this.checkSrcName = value;
    }

    /**
     * \u83b7\u53d6additionalCash\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getAdditionalCash() {
        return additionalCash;
    }

    /**
     * \u8bbe\u7f6eadditionalCash\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAdditionalCash(Double value) {
        this.additionalCash = value;
    }

    /**
     * \u83b7\u53d6depNameZh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepNameZh() {
        return depNameZh;
    }

    /**
     * \u8bbe\u7f6edepNameZh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepNameZh(String value) {
        this.depNameZh = value;
    }

    /**
     * \u83b7\u53d6depNamePt\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepNamePt() {
        return depNamePt;
    }

    /**
     * \u8bbe\u7f6edepNamePt\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepNamePt(String value) {
        this.depNamePt = value;
    }

    /**
     * \u83b7\u53d6financialCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFinancialCode() {
        return financialCode;
    }

    /**
     * \u8bbe\u7f6efinancialCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFinancialCode(String value) {
        this.financialCode = value;
    }

    /**
     * \u83b7\u53d6paymentId\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPaymentId() {
        return paymentId;
    }

    /**
     * \u8bbe\u7f6epaymentId\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPaymentId(Integer value) {
        this.paymentId = value;
    }

    /**
     * \u83b7\u53d6feeItemRemarkZh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeItemRemarkZh() {
        return feeItemRemarkZh;
    }

    /**
     * \u8bbe\u7f6efeeItemRemarkZh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeItemRemarkZh(String value) {
        this.feeItemRemarkZh = value;
    }

    /**
     * \u83b7\u53d6feeItemRemarkPt\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeItemRemarkPt() {
        return feeItemRemarkPt;
    }

    /**
     * \u8bbe\u7f6efeeItemRemarkPt\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeItemRemarkPt(String value) {
        this.feeItemRemarkPt = value;
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
