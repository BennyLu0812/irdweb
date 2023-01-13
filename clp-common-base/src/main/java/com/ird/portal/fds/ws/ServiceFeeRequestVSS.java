
package com.ird.portal.fds.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 								ServiceFeeRequest
 * 							
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceFeeRequestVSS", propOrder = {
    "serviceFeeCode",
    "remarkZh",
    "remarkPt",
    "defaultQty",
    "unitPrize",
    "groupCode",
    "groupName",
    "exempt",
    "exemptTax"
})
public class ServiceFeeRequestVSS {

    @XmlElement(required = true)
    protected String serviceFeeCode;
    @XmlElement(required = true)
    protected String remarkZh;
    @XmlElement(required = true)
    protected String remarkPt;
    protected int defaultQty;
    protected double unitPrize;
    @XmlElement(required = true)
    protected String groupCode;
    @XmlElement(required = true)
    protected String groupName;
    protected boolean exempt;
    protected boolean exemptTax;

    /**
     * \u83b7\u53d6serviceFeeCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceFeeCode() {
        return serviceFeeCode;
    }

    /**
     * \u8bbe\u7f6eserviceFeeCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceFeeCode(String value) {
        this.serviceFeeCode = value;
    }

    /**
     * \u83b7\u53d6remarkZh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemarkZh() {
        return remarkZh;
    }

    /**
     * \u8bbe\u7f6eremarkZh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemarkZh(String value) {
        this.remarkZh = value;
    }

    /**
     * \u83b7\u53d6remarkPt\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemarkPt() {
        return remarkPt;
    }

    /**
     * \u8bbe\u7f6eremarkPt\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemarkPt(String value) {
        this.remarkPt = value;
    }

    /**
     * \u83b7\u53d6defaultQty\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public int getDefaultQty() {
        return defaultQty;
    }

    /**
     * \u8bbe\u7f6edefaultQty\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setDefaultQty(int value) {
        this.defaultQty = value;
    }

    /**
     * \u83b7\u53d6unitPrize\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public double getUnitPrize() {
        return unitPrize;
    }

    /**
     * \u8bbe\u7f6eunitPrize\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setUnitPrize(double value) {
        this.unitPrize = value;
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
     * \u83b7\u53d6exempt\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public boolean isExempt() {
        return exempt;
    }

    /**
     * \u8bbe\u7f6eexempt\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setExempt(boolean value) {
        this.exempt = value;
    }

    /**
     * \u83b7\u53d6exemptTax\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public boolean isExemptTax() {
        return exemptTax;
    }

    /**
     * \u8bbe\u7f6eexemptTax\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setExemptTax(boolean value) {
        this.exemptTax = value;
    }

}
