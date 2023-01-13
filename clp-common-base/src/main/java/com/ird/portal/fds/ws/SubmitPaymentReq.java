
package com.ird.portal.fds.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 								Submit Payment Request Object
 * 							
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubmitPaymentReq", propOrder = {
    "paymentMethodValue",
    "paymentDescription",
    "cash",
    "check",
    "creditCard",
    "expandPayment"
})
public class SubmitPaymentReq {

    @XmlElement(required = true)
    protected String paymentMethodValue;
    @XmlElement(required = true)
    protected String paymentDescription;
    protected double cash;
    @XmlElement(required = true)
    protected BankPaymentSimple check;
    @XmlElement(required = true)
    protected BankPaymentSimple creditCard;
    @XmlElement(required = true)
    protected ExpandPayment expandPayment;

    /**
     * \u83b7\u53d6paymentMethodValue\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentMethodValue() {
        return paymentMethodValue;
    }

    /**
     * \u8bbe\u7f6epaymentMethodValue\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentMethodValue(String value) {
        this.paymentMethodValue = value;
    }

    /**
     * \u83b7\u53d6paymentDescription\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentDescription() {
        return paymentDescription;
    }

    /**
     * \u8bbe\u7f6epaymentDescription\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentDescription(String value) {
        this.paymentDescription = value;
    }

    /**
     * \u83b7\u53d6cash\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public double getCash() {
        return cash;
    }

    /**
     * \u8bbe\u7f6ecash\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setCash(double value) {
        this.cash = value;
    }

    /**
     * \u83b7\u53d6check\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link BankPaymentSimple }
     *     
     */
    public BankPaymentSimple getCheck() {
        return check;
    }

    /**
     * \u8bbe\u7f6echeck\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link BankPaymentSimple }
     *     
     */
    public void setCheck(BankPaymentSimple value) {
        this.check = value;
    }

    /**
     * \u83b7\u53d6creditCard\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link BankPaymentSimple }
     *     
     */
    public BankPaymentSimple getCreditCard() {
        return creditCard;
    }

    /**
     * \u8bbe\u7f6ecreditCard\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link BankPaymentSimple }
     *     
     */
    public void setCreditCard(BankPaymentSimple value) {
        this.creditCard = value;
    }

    /**
     * \u83b7\u53d6expandPayment\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link ExpandPayment }
     *     
     */
    public ExpandPayment getExpandPayment() {
        return expandPayment;
    }

    /**
     * \u8bbe\u7f6eexpandPayment\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link ExpandPayment }
     *     
     */
    public void setExpandPayment(ExpandPayment value) {
        this.expandPayment = value;
    }

}
