
package com.ird.portal.fds.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 								A Payment associated with a Transaction
 * 							
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Payment", propOrder = {
    "cash",
    "check",
    "check2",
    "check3",
    "creditCard",
    "creditCard2",
    "creditCard3",
    "paymentDescription",
    "expandPayment"
})
public class Payment {

    protected double cash;
    @XmlElement(required = true)
    protected BankPayment check;
    @XmlElement(required = true)
    protected BankPayment check2;
    @XmlElement(required = true)
    protected BankPayment check3;
    @XmlElement(required = true)
    protected BankPayment creditCard;
    @XmlElement(required = true)
    protected BankPayment creditCard2;
    @XmlElement(required = true)
    protected BankPayment creditCard3;
    @XmlElement(required = true)
    protected String paymentDescription;
    @XmlElement(required = true)
    protected ExpandPayment expandPayment;

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
     *     {@link BankPayment }
     *     
     */
    public BankPayment getCheck() {
        return check;
    }

    /**
     * \u8bbe\u7f6echeck\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link BankPayment }
     *     
     */
    public void setCheck(BankPayment value) {
        this.check = value;
    }

    /**
     * \u83b7\u53d6check2\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link BankPayment }
     *     
     */
    public BankPayment getCheck2() {
        return check2;
    }

    /**
     * \u8bbe\u7f6echeck2\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link BankPayment }
     *     
     */
    public void setCheck2(BankPayment value) {
        this.check2 = value;
    }

    /**
     * \u83b7\u53d6check3\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link BankPayment }
     *     
     */
    public BankPayment getCheck3() {
        return check3;
    }

    /**
     * \u8bbe\u7f6echeck3\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link BankPayment }
     *     
     */
    public void setCheck3(BankPayment value) {
        this.check3 = value;
    }

    /**
     * \u83b7\u53d6creditCard\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link BankPayment }
     *     
     */
    public BankPayment getCreditCard() {
        return creditCard;
    }

    /**
     * \u8bbe\u7f6ecreditCard\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link BankPayment }
     *     
     */
    public void setCreditCard(BankPayment value) {
        this.creditCard = value;
    }

    /**
     * \u83b7\u53d6creditCard2\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link BankPayment }
     *     
     */
    public BankPayment getCreditCard2() {
        return creditCard2;
    }

    /**
     * \u8bbe\u7f6ecreditCard2\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link BankPayment }
     *     
     */
    public void setCreditCard2(BankPayment value) {
        this.creditCard2 = value;
    }

    /**
     * \u83b7\u53d6creditCard3\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link BankPayment }
     *     
     */
    public BankPayment getCreditCard3() {
        return creditCard3;
    }

    /**
     * \u8bbe\u7f6ecreditCard3\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link BankPayment }
     *     
     */
    public void setCreditCard3(BankPayment value) {
        this.creditCard3 = value;
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
