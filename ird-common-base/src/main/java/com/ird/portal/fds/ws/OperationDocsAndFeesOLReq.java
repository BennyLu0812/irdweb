
package com.ird.portal.fds.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 								get Operation's ServiceDocuments And ServiceFees
 * 								Request
 * 							
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OperationDocsAndFeesOLReq", propOrder = {
    "uid",
    "incomeIP",
    "operationCode",
    "busiFeeProcInput"
})
public class OperationDocsAndFeesOLReq {

    @XmlElement(required = true)
    protected String uid;
    @XmlElement(required = true)
    protected String incomeIP;
    @XmlElement(required = true)
    protected String operationCode;
    @XmlElement(required = true)
    protected ProceInput busiFeeProcInput;

    /**
     * \u83b7\u53d6uid\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUid() {
        return uid;
    }

    /**
     * \u8bbe\u7f6euid\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUid(String value) {
        this.uid = value;
    }

    /**
     * \u83b7\u53d6incomeIP\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIncomeIP() {
        return incomeIP;
    }

    /**
     * \u8bbe\u7f6eincomeIP\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIncomeIP(String value) {
        this.incomeIP = value;
    }

    /**
     * \u83b7\u53d6operationCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperationCode() {
        return operationCode;
    }

    /**
     * \u8bbe\u7f6eoperationCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperationCode(String value) {
        this.operationCode = value;
    }

    /**
     * \u83b7\u53d6busiFeeProcInput\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link ProceInput }
     *     
     */
    public ProceInput getBusiFeeProcInput() {
        return busiFeeProcInput;
    }

    /**
     * \u8bbe\u7f6ebusiFeeProcInput\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link ProceInput }
     *     
     */
    public void setBusiFeeProcInput(ProceInput value) {
        this.busiFeeProcInput = value;
    }

}
