
package com.ird.portal.fds.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 								Return Object
 * 							
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReturnObject", propOrder = {
    "success",
    "errorCode",
    "errorMsg",
    "procOutput"
})
public class ReturnObject {

    protected boolean success;
    @XmlElement(required = true)
    protected String errorCode;
    @XmlElement(required = true)
    protected String errorMsg;
    @XmlElement(required = true)
    protected ProceOutput procOutput;

    /**
     * \u83b7\u53d6success\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * \u8bbe\u7f6esuccess\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setSuccess(boolean value) {
        this.success = value;
    }

    /**
     * \u83b7\u53d6errorCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * \u8bbe\u7f6eerrorCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorCode(String value) {
        this.errorCode = value;
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
     * \u83b7\u53d6procOutput\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link ProceOutput }
     *     
     */
    public ProceOutput getProcOutput() {
        return procOutput;
    }

    /**
     * \u8bbe\u7f6eprocOutput\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link ProceOutput }
     *     
     */
    public void setProcOutput(ProceOutput value) {
        this.procOutput = value;
    }

}
