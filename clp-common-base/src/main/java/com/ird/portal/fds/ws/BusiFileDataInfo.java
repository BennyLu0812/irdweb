
package com.ird.portal.fds.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 								businesses file datas return information
 * 							
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BusiFileDataInfo", propOrder = {
    "dataType",
    "dataSize",
    "dataName",
    "data",
    "extraParams"
})
public class BusiFileDataInfo {

    @XmlElement(required = true)
    protected String dataType;
    @XmlElement(required = true)
    protected String dataSize;
    @XmlElement(required = true)
    protected String dataName;
    @XmlElement(required = true)
    protected String data;
    protected List<String> extraParams;

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

    /**
     * Gets the value of the extraParams property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the extraParams property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExtraParams().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getExtraParams() {
        if (extraParams == null) {
            extraParams = new ArrayList<String>();
        }
        return this.extraParams;
    }

}
