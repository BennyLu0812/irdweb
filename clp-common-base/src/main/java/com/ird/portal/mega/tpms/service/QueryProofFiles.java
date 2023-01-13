
package com.ird.portal.mega.tpms.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>queryProofFiles complex type\u7684 Java \u7c7b\u3002
 * 
 * <p>\u4ee5\u4e0b\u6a21\u5f0f\u7247\u6bb5\u6307\u5b9a\u5305\u542b\u5728\u6b64\u7c7b\u4e2d\u7684\u9884\u671f\u5185\u5bb9\u3002
 * 
 * <pre>
 * &lt;complexType name="queryProofFiles"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tpmsProofFile" type="{http://service.tpms.dsat.mega.com/}TPMSProofFile" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "queryProofFiles", propOrder = {
    "tpmsProofFile"
})
public class QueryProofFiles {

    protected TPMSProofFile tpmsProofFile;

    /**
     * \u83b7\u53d6tpmsProofFile\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link TPMSProofFile }
     *     
     */
    public TPMSProofFile getTpmsProofFile() {
        return tpmsProofFile;
    }

    /**
     * \u8bbe\u7f6etpmsProofFile\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link TPMSProofFile }
     *     
     */
    public void setTpmsProofFile(TPMSProofFile value) {
        this.tpmsProofFile = value;
    }

}
