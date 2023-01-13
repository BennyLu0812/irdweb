
package com.ird.portal.fds.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 								A Bank Related Payment associated with a Transaction
 * 							
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BankPayment", propOrder = {
    "number",
    "amount",
    "approvalCode",
    "bank"
})
public class BankPayment {

    @XmlElement(required = true)
    protected String number;
    protected double amount;
    @XmlElement(required = true)
    protected String approvalCode;
    @XmlElement(required = true)
    protected Bank bank;

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
     * \u83b7\u53d6amount\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public double getAmount() {
        return amount;
    }

    /**
     * \u8bbe\u7f6eamount\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setAmount(double value) {
        this.amount = value;
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
     * \u83b7\u53d6bank\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Bank }
     *     
     */
    public Bank getBank() {
        return bank;
    }

    /**
     * \u8bbe\u7f6ebank\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Bank }
     *     
     */
    public void setBank(Bank value) {
        this.bank = value;
    }

}
