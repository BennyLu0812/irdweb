
package com.ird.portal.be.ws;

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
 *         &lt;element name="interLicAppRtn" type="{urn:dsat.gov.mo:be/ws}InterLicAppRtn"/&gt;
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
    "interLicAppRtn"
})
@XmlRootElement(name = "createInterLicApplicantResponse")
public class CreateInterLicApplicantResponse {

    @XmlElement(required = true)
    protected InterLicAppRtn interLicAppRtn;

    /**
     * \u83b7\u53d6interLicAppRtn\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link InterLicAppRtn }
     *     
     */
    public InterLicAppRtn getInterLicAppRtn() {
        return interLicAppRtn;
    }

    /**
     * \u8bbe\u7f6einterLicAppRtn\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link InterLicAppRtn }
     *     
     */
    public void setInterLicAppRtn(InterLicAppRtn value) {
        this.interLicAppRtn = value;
    }

}
