
package com.ird.portal.fds.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type\u7684 Java \u7c7b\u3002
 * 
 * <p>\u4ee5\u4e0b\u6a21\u5f0f\u7247\u6bb5\u6307\u5b9a\u5305\u542b\u5728\u6b64\u7c7b\u4e2d\u7684\u9884\u671f\u5185\u5bb9\u3002
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="serviceFeeRequests" type="{urn:dsat.gov.mo:fds/ws}ServiceFeeRequestVSS" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="payment" type="{urn:dsat.gov.mo:fds/ws}Payment"/&gt;
 *         &lt;element name="createTransInfo" type="{urn:dsat.gov.mo:fds/ws}CreateTransInfo"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "serviceFeeRequests",
    "payment",
    "createTransInfo"
})
@XmlRootElement(name = "autoCreateAndCompleteTransaction")
public class AutoCreateAndCompleteTransaction {

    @XmlElement(nillable = true)
    protected List<ServiceFeeRequestVSS> serviceFeeRequests;
    @XmlElement(required = true)
    protected Payment payment;
    @XmlElement(required = true)
    protected CreateTransInfo createTransInfo;

    /**
     * Gets the value of the serviceFeeRequests property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceFeeRequests property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceFeeRequests().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceFeeRequestVSS }
     * 
     * 
     */
    public List<ServiceFeeRequestVSS> getServiceFeeRequests() {
        if (serviceFeeRequests == null) {
            serviceFeeRequests = new ArrayList<ServiceFeeRequestVSS>();
        }
        return this.serviceFeeRequests;
    }

    /**
     * \u83b7\u53d6payment\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Payment }
     *     
     */
    public Payment getPayment() {
        return payment;
    }

    /**
     * \u8bbe\u7f6epayment\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Payment }
     *     
     */
    public void setPayment(Payment value) {
        this.payment = value;
    }

    /**
     * \u83b7\u53d6createTransInfo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link CreateTransInfo }
     *     
     */
    public CreateTransInfo getCreateTransInfo() {
        return createTransInfo;
    }

    /**
     * \u8bbe\u7f6ecreateTransInfo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link CreateTransInfo }
     *     
     */
    public void setCreateTransInfo(CreateTransInfo value) {
        this.createTransInfo = value;
    }

}
