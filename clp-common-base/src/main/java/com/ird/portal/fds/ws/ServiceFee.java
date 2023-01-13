
package com.ird.portal.fds.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 								ServiceFee defines a serviceFee from DSCC
 * 							
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceFee")
public class ServiceFee {

    @XmlAttribute(name = "code")
    protected String code;
    @XmlAttribute(name = "zh")
    protected String zh;
    @XmlAttribute(name = "pt")
    protected String pt;
    @XmlAttribute(name = "price")
    protected Double price;
    @XmlAttribute(name = "taxPrice")
    protected Double taxPrice;
    @XmlAttribute(name = "taxRate")
    protected Double taxRate;
    @XmlAttribute(name = "extraPrice")
    protected Double extraPrice;
    @XmlAttribute(name = "editable")
    protected Boolean editable;
    @XmlAttribute(name = "extraEditable")
    protected Boolean extraEditable;
    @XmlAttribute(name = "incomeRubricaCode")
    protected String incomeRubricaCode;
    @XmlAttribute(name = "incomeReceiptaCode")
    protected String incomeReceiptaCode;
    @XmlAttribute(name = "taxRubricaCode")
    protected String taxRubricaCode;
    @XmlAttribute(name = "taxReceiptaCode")
    protected String taxReceiptaCode;
    @XmlAttribute(name = "incomeDepartmentCode")
    protected String incomeDepartmentCode;
    @XmlAttribute(name = "groupCode")
    protected String groupCode;
    @XmlAttribute(name = "groupName")
    protected String groupName;
    @XmlAttribute(name = "displayOrder")
    protected Integer displayOrder;
    @XmlAttribute(name = "category")
    protected ServiceFeeCategory category;
    @XmlAttribute(name = "incomeDepartmentFinancialCode")
    protected String incomeDepartmentFinancialCode;
    @XmlAttribute(name = "feeAmountUnit")
    protected Double feeAmountUnit;
    @XmlAttribute(name = "taxAmountUnit")
    protected Double taxAmountUnit;
    @XmlAttribute(name = "extraAmountUnit")
    protected Double extraAmountUnit;
    @XmlAttribute(name = "totalAmountUnit")
    protected Double totalAmountUnit;
    @XmlAttribute(name = "defaultSelectFee")
    protected Boolean defaultSelectFee;
    @XmlAttribute(name = "effectiveDate")
    protected String effectiveDate;
    @XmlAttribute(name = "expiryDate")
    protected String expiryDate;

    /**
     * \u83b7\u53d6code\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * \u8bbe\u7f6ecode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * \u83b7\u53d6zh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZh() {
        return zh;
    }

    /**
     * \u8bbe\u7f6ezh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZh(String value) {
        this.zh = value;
    }

    /**
     * \u83b7\u53d6pt\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPt() {
        return pt;
    }

    /**
     * \u8bbe\u7f6ept\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPt(String value) {
        this.pt = value;
    }

    /**
     * \u83b7\u53d6price\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPrice() {
        return price;
    }

    /**
     * \u8bbe\u7f6eprice\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPrice(Double value) {
        this.price = value;
    }

    /**
     * \u83b7\u53d6taxPrice\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTaxPrice() {
        return taxPrice;
    }

    /**
     * \u8bbe\u7f6etaxPrice\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTaxPrice(Double value) {
        this.taxPrice = value;
    }

    /**
     * \u83b7\u53d6taxRate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTaxRate() {
        return taxRate;
    }

    /**
     * \u8bbe\u7f6etaxRate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTaxRate(Double value) {
        this.taxRate = value;
    }

    /**
     * \u83b7\u53d6extraPrice\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getExtraPrice() {
        return extraPrice;
    }

    /**
     * \u8bbe\u7f6eextraPrice\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setExtraPrice(Double value) {
        this.extraPrice = value;
    }

    /**
     * \u83b7\u53d6editable\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEditable() {
        return editable;
    }

    /**
     * \u8bbe\u7f6eeditable\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEditable(Boolean value) {
        this.editable = value;
    }

    /**
     * \u83b7\u53d6extraEditable\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isExtraEditable() {
        return extraEditable;
    }

    /**
     * \u8bbe\u7f6eextraEditable\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExtraEditable(Boolean value) {
        this.extraEditable = value;
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
     * \u83b7\u53d6incomeReceiptaCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIncomeReceiptaCode() {
        return incomeReceiptaCode;
    }

    /**
     * \u8bbe\u7f6eincomeReceiptaCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIncomeReceiptaCode(String value) {
        this.incomeReceiptaCode = value;
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
     * \u83b7\u53d6taxReceiptaCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaxReceiptaCode() {
        return taxReceiptaCode;
    }

    /**
     * \u8bbe\u7f6etaxReceiptaCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxReceiptaCode(String value) {
        this.taxReceiptaCode = value;
    }

    /**
     * \u83b7\u53d6incomeDepartmentCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIncomeDepartmentCode() {
        return incomeDepartmentCode;
    }

    /**
     * \u8bbe\u7f6eincomeDepartmentCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIncomeDepartmentCode(String value) {
        this.incomeDepartmentCode = value;
    }

    /**
     * \u83b7\u53d6groupCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupCode() {
        return groupCode;
    }

    /**
     * \u8bbe\u7f6egroupCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupCode(String value) {
        this.groupCode = value;
    }

    /**
     * \u83b7\u53d6groupName\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * \u8bbe\u7f6egroupName\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupName(String value) {
        this.groupName = value;
    }

    /**
     * \u83b7\u53d6displayOrder\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDisplayOrder() {
        return displayOrder;
    }

    /**
     * \u8bbe\u7f6edisplayOrder\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDisplayOrder(Integer value) {
        this.displayOrder = value;
    }

    /**
     * \u83b7\u53d6category\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link ServiceFeeCategory }
     *     
     */
    public ServiceFeeCategory getCategory() {
        return category;
    }

    /**
     * \u8bbe\u7f6ecategory\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceFeeCategory }
     *     
     */
    public void setCategory(ServiceFeeCategory value) {
        this.category = value;
    }

    /**
     * \u83b7\u53d6incomeDepartmentFinancialCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIncomeDepartmentFinancialCode() {
        return incomeDepartmentFinancialCode;
    }

    /**
     * \u8bbe\u7f6eincomeDepartmentFinancialCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIncomeDepartmentFinancialCode(String value) {
        this.incomeDepartmentFinancialCode = value;
    }

    /**
     * \u83b7\u53d6feeAmountUnit\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getFeeAmountUnit() {
        return feeAmountUnit;
    }

    /**
     * \u8bbe\u7f6efeeAmountUnit\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setFeeAmountUnit(Double value) {
        this.feeAmountUnit = value;
    }

    /**
     * \u83b7\u53d6taxAmountUnit\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTaxAmountUnit() {
        return taxAmountUnit;
    }

    /**
     * \u8bbe\u7f6etaxAmountUnit\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTaxAmountUnit(Double value) {
        this.taxAmountUnit = value;
    }

    /**
     * \u83b7\u53d6extraAmountUnit\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getExtraAmountUnit() {
        return extraAmountUnit;
    }

    /**
     * \u8bbe\u7f6eextraAmountUnit\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setExtraAmountUnit(Double value) {
        this.extraAmountUnit = value;
    }

    /**
     * \u83b7\u53d6totalAmountUnit\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTotalAmountUnit() {
        return totalAmountUnit;
    }

    /**
     * \u8bbe\u7f6etotalAmountUnit\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTotalAmountUnit(Double value) {
        this.totalAmountUnit = value;
    }

    /**
     * \u83b7\u53d6defaultSelectFee\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDefaultSelectFee() {
        return defaultSelectFee;
    }

    /**
     * \u8bbe\u7f6edefaultSelectFee\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDefaultSelectFee(Boolean value) {
        this.defaultSelectFee = value;
    }

    /**
     * \u83b7\u53d6effectiveDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * \u8bbe\u7f6eeffectiveDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEffectiveDate(String value) {
        this.effectiveDate = value;
    }

    /**
     * \u83b7\u53d6expiryDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * \u8bbe\u7f6eexpiryDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpiryDate(String value) {
        this.expiryDate = value;
    }

}
