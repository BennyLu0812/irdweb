
package com.ird.portal.fds.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 								Procedure Input Data
 * 							
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProceInputData", propOrder = {
    "procName",
    "procParams",
    "outParamsCount",
    "dependSuccessCode"
})
public class ProceInputData {

    @XmlElement(required = true)
    protected String procName;
    @XmlElement(nillable = true)
    protected List<String> procParams;
    protected int outParamsCount;
    @XmlElement(required = true)
    protected String dependSuccessCode;

    /**
     * \u83b7\u53d6procName\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcName() {
        return procName;
    }

    /**
     * \u8bbe\u7f6eprocName\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcName(String value) {
        this.procName = value;
    }

    /**
     * Gets the value of the procParams property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the procParams property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProcParams().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getProcParams() {
        if (procParams == null) {
            procParams = new ArrayList<String>();
        }
        return this.procParams;
    }

    /**
     * \u83b7\u53d6outParamsCount\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public int getOutParamsCount() {
        return outParamsCount;
    }

    /**
     * \u8bbe\u7f6eoutParamsCount\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setOutParamsCount(int value) {
        this.outParamsCount = value;
    }

    /**
     * \u83b7\u53d6dependSuccessCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDependSuccessCode() {
        return dependSuccessCode;
    }

    /**
     * \u8bbe\u7f6edependSuccessCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDependSuccessCode(String value) {
        this.dependSuccessCode = value;
    }

}
