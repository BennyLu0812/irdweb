
package com.ird.portal.fds.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 								A Fee Entry associated with a Transaction
 * 							
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FeeEntry")
public class FeeEntry {

    @XmlAttribute(name = "selected")
    protected Boolean selected;
    @XmlAttribute(name = "zh")
    protected String zh;
    @XmlAttribute(name = "pt")
    protected String pt;
    @XmlAttribute(name = "price")
    protected Double price;
    @XmlAttribute(name = "qty")
    protected Integer qty;
    @XmlAttribute(name = "taxAmount")
    protected Double taxAmount;
    @XmlAttribute(name = "extraPrice")
    protected Double extraPrice;
    @XmlAttribute(name = "extraQty")
    protected Integer extraQty;
    @XmlAttribute(name = "displayOrder")
    protected Integer displayOrder;
    @XmlAttribute(name = "groupName")
    protected String groupName;
    @XmlAttribute(name = "exempt")
    protected Boolean exempt;
    @XmlAttribute(name = "exemptTax")
    protected Boolean exemptTax;
    @XmlAttribute(name = "subTotal")
    protected Double subTotal;

    /**
     * \u83b7\u53d6selected\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSelected() {
        return selected;
    }

    /**
     * \u8bbe\u7f6eselected\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSelected(Boolean value) {
        this.selected = value;
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
     * \u83b7\u53d6qty\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getQty() {
        return qty;
    }

    /**
     * \u8bbe\u7f6eqty\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setQty(Integer value) {
        this.qty = value;
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
     * \u83b7\u53d6extraQty\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getExtraQty() {
        return extraQty;
    }

    /**
     * \u8bbe\u7f6eextraQty\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setExtraQty(Integer value) {
        this.extraQty = value;
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

    /**
     * \u83b7\u53d6subTotal\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getSubTotal() {
        return subTotal;
    }

    /**
     * \u8bbe\u7f6esubTotal\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setSubTotal(Double value) {
        this.subTotal = value;
    }

}
