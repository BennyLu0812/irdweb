
package com.ird.portal.fds.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 								RequiringDocsInfo
 * 							
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequiringDocsInfo", propOrder = {
    "txnNo",
    "requiringDocsCount"
})
public class RequiringDocsInfo {

    @XmlElement(required = true)
    protected String txnNo;
    protected int requiringDocsCount;

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
     * \u83b7\u53d6requiringDocsCount\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public int getRequiringDocsCount() {
        return requiringDocsCount;
    }

    /**
     * \u8bbe\u7f6erequiringDocsCount\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setRequiringDocsCount(int value) {
        this.requiringDocsCount = value;
    }

}
