
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
 *         &lt;element name="SendSmsBatchResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "sendSmsBatchResult"
})
@XmlRootElement(name = "SendSmsBatchResponse")
public class SendSmsBatchResponse {

    @XmlElement(name = "SendSmsBatchResult")
    protected String sendSmsBatchResult;

    /**
     * Gets the value of the sendSmsBatchResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSendSmsBatchResult() {
        return sendSmsBatchResult;
    }

    /**
     * Sets the value of the sendSmsBatchResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSendSmsBatchResult(String value) {
        this.sendSmsBatchResult = value;
    }

}
