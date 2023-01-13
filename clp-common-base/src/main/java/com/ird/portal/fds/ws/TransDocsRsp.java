
package com.ird.portal.fds.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 								Transaction Document Object
 * 							
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransDocsRsp", propOrder = {
    "success",
    "errorCode",
    "errorMsg",
    "txnNo",
    "transDocsDatas"
})
public class TransDocsRsp {

    protected boolean success;
    @XmlElement(required = true)
    protected String errorCode;
    @XmlElement(required = true)
    protected String errorMsg;
    @XmlElement(required = true)
    protected String txnNo;
    @XmlElement(nillable = true)
    protected List<TransDocsData> transDocsDatas;

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
     * \u83b7\u53d6txnNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTxnNo() {
        return txnNo;
    }

    /**
     * \u8bbe\u7f6etxnNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTxnNo(String value) {
        this.txnNo = value;
    }

    /**
     * Gets the value of the transDocsDatas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transDocsDatas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransDocsDatas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransDocsData }
     * 
     * 
     */
    public List<TransDocsData> getTransDocsDatas() {
        if (transDocsDatas == null) {
            transDocsDatas = new ArrayList<TransDocsData>();
        }
        return this.transDocsDatas;
    }

}
