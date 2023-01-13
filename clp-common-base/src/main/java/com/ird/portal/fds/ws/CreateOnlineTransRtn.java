
package com.ird.portal.fds.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 								Create Online Transaction Rtn
 * 							
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateOnlineTransRtn", propOrder = {
    "txnNo",
    "receiptNo",
    "qrNo",
    "transDocsRsp",
    "procOutput"
})
public class CreateOnlineTransRtn {

    @XmlElement(required = true)
    protected String txnNo;
    @XmlElement(required = true)
    protected String receiptNo;
    @XmlElement(required = true)
    protected String qrNo;
    @XmlElement(required = true)
    protected TransDocsRsp transDocsRsp;
    @XmlElement(required = true)
    protected ProceOutput procOutput;

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
     * \u83b7\u53d6receiptNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReceiptNo() {
        return receiptNo;
    }

    /**
     * \u8bbe\u7f6ereceiptNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReceiptNo(String value) {
        this.receiptNo = value;
    }

    /**
     * \u83b7\u53d6qrNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQrNo() {
        return qrNo;
    }

    /**
     * \u8bbe\u7f6eqrNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQrNo(String value) {
        this.qrNo = value;
    }

    /**
     * \u83b7\u53d6transDocsRsp\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link TransDocsRsp }
     *     
     */
    public TransDocsRsp getTransDocsRsp() {
        return transDocsRsp;
    }

    /**
     * \u8bbe\u7f6etransDocsRsp\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link TransDocsRsp }
     *     
     */
    public void setTransDocsRsp(TransDocsRsp value) {
        this.transDocsRsp = value;
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
