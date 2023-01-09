
package com.ird.portal.fds.ws;

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
 *         &lt;element name="transActionGroupReq" type="{urn:dsat.gov.mo:fds/ws}TransActionGroupReq"/&gt;
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
    "transActionGroupReq"
})
@XmlRootElement(name = "deselectTransactionActionGroupEx")
public class DeselectTransactionActionGroupEx {

    @XmlElement(required = true)
    protected TransActionGroupReq transActionGroupReq;

    /**
     * \u83b7\u53d6transActionGroupReq\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link TransActionGroupReq }
     *     
     */
    public TransActionGroupReq getTransActionGroupReq() {
        return transActionGroupReq;
    }

    /**
     * \u8bbe\u7f6etransActionGroupReq\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link TransActionGroupReq }
     *     
     */
    public void setTransActionGroupReq(TransActionGroupReq value) {
        this.transActionGroupReq = value;
    }

}
