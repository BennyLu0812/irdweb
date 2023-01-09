
package com.ird.portal.be.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 								download international license data return information
 * 							
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InternationalLicenseData", propOrder = {
    "dataType",
    "dataSize",
    "dataName",
    "data"
})
public class InternationalLicenseData {

    @XmlElement(required = true)
    protected String dataType;
    @XmlElement(required = true)
    protected String dataSize;
    @XmlElement(required = true)
    protected String dataName;
    @XmlElement(required = true)
    protected String data;

    /**
     * \u83b7\u53d6dataType\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * \u8bbe\u7f6edataType\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataType(String value) {
        this.dataType = value;
    }

    /**
     * \u83b7\u53d6dataSize\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataSize() {
        return dataSize;
    }

    /**
     * \u8bbe\u7f6edataSize\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataSize(String value) {
        this.dataSize = value;
    }

    /**
     * \u83b7\u53d6dataName\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataName() {
        return dataName;
    }

    /**
     * \u8bbe\u7f6edataName\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataName(String value) {
        this.dataName = value;
    }

    /**
     * \u83b7\u53d6data\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getData() {
        return data;
    }

    /**
     * \u8bbe\u7f6edata\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setData(String value) {
        this.data = value;
    }

}
