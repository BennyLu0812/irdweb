
package com.ird.portal.fds.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 								A Transaction Payment Info
 * 							
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentInfo", propOrder = {
    "bankCode",
    "bankDescZh",
    "bankDescPt",
    "number",
    "approvalCode",
    "flag",
    "paymentMethodDesc",
    "totalPrice"
})
public class PaymentInfo {

    @XmlElement(required = true)
    protected String bankCode;
    @XmlElement(required = true)
    protected String bankDescZh;
    @XmlElement(required = true)
    protected String bankDescPt;
    @XmlElement(required = true)
    protected String number;
    @XmlElement(required = true)
    protected String approvalCode;
    @XmlElement(required = true)
    protected String flag;
    @XmlElement(required = true)
    protected String paymentMethodDesc;
    protected double totalPrice;

    /**
     * \u83b7\u53d6bankCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankCode() {
        return bankCode;
    }

    /**
     * \u8bbe\u7f6ebankCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankCode(String value) {
        this.bankCode = value;
    }

    /**
     * \u83b7\u53d6bankDescZh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankDescZh() {
        return bankDescZh;
    }

    /**
     * \u8bbe\u7f6ebankDescZh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankDescZh(String value) {
        this.bankDescZh = value;
    }

    /**
     * \u83b7\u53d6bankDescPt\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankDescPt() {
        return bankDescPt;
    }

    /**
     * \u8bbe\u7f6ebankDescPt\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankDescPt(String value) {
        this.bankDescPt = value;
    }

    /**
     * \u83b7\u53d6number\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumber() {
        return number;
    }

    /**
     * \u8bbe\u7f6enumber\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumber(String value) {
        this.number = value;
    }

    /**
     * \u83b7\u53d6approvalCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApprovalCode() {
        return approvalCode;
    }

    /**
     * \u8bbe\u7f6eapprovalCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApprovalCode(String value) {
        this.approvalCode = value;
    }

    /**
     * \u83b7\u53d6flag\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlag() {
        return flag;
    }

    /**
     * \u8bbe\u7f6eflag\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlag(String value) {
        this.flag = value;
    }

    /**
     * \u83b7\u53d6paymentMethodDesc\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentMethodDesc() {
        return paymentMethodDesc;
    }

    /**
     * \u8bbe\u7f6epaymentMethodDesc\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentMethodDesc(String value) {
        this.paymentMethodDesc = value;
    }

    /**
     * \u83b7\u53d6totalPrice\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * \u8bbe\u7f6etotalPrice\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setTotalPrice(double value) {
        this.totalPrice = value;
    }

}
