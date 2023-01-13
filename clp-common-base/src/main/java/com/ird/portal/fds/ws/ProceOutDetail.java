
package com.ird.portal.fds.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 								Procedure Output Detail
 * 							
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProceOutDetail", propOrder = {
    "procName",
    "callSuccess",
    "errorMsg",
    "outDatas"
})
public class ProceOutDetail {

    @XmlElement(required = true)
    protected String procName;
    protected boolean callSuccess;
    @XmlElement(required = true)
    protected String errorMsg;
    @XmlElement(nillable = true)
    protected List<String> outDatas;

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
     * \u83b7\u53d6callSuccess\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public boolean isCallSuccess() {
        return callSuccess;
    }

    /**
     * \u8bbe\u7f6ecallSuccess\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setCallSuccess(boolean value) {
        this.callSuccess = value;
    }

    /**
     * \u83b7\u53d6errorMsg\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * \u8bbe\u7f6eerrorMsg\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorMsg(String value) {
        this.errorMsg = value;
    }

    /**
     * Gets the value of the outDatas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the outDatas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOutDatas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getOutDatas() {
        if (outDatas == null) {
            outDatas = new ArrayList<String>();
        }
        return this.outDatas;
    }

}
