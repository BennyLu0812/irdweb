
package com.ird.portal.client;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SendSmsByAppTypeResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "sendSmsByAppTypeResult"
})
@XmlRootElement(name = "SendSmsByAppTypeResponse")
public class SendSmsByAppTypeResponse {

    @XmlElement(name = "SendSmsByAppTypeResult")
    protected String sendSmsByAppTypeResult;

    /**
     * Gets the value of the sendSmsByAppTypeResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSendSmsByAppTypeResult() {
        return sendSmsByAppTypeResult;
    }

    /**
     * Sets the value of the sendSmsByAppTypeResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSendSmsByAppTypeResult(String value) {
        this.sendSmsByAppTypeResult = value;
    }

}
