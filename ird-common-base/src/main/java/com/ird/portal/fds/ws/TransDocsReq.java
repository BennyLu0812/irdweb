
package com.ird.portal.fds.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 								Transaction Document Request Object
 * 							
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransDocsReq", propOrder = {
    "txnNo",
    "uid",
    "incomeIP",
    "docRemark",
    "createResubmitTransaction",
    "exAppCode",
    "transDocsDatas"
})
public class TransDocsReq {

    @XmlElement(required = true)
    protected String txnNo;
    @XmlElement(required = true)
    protected String uid;
    @XmlElement(required = true)
    protected String incomeIP;
    @XmlElement(required = true)
    protected String docRemark;
    protected boolean createResubmitTransaction;
    @XmlElement(required = true)
    protected String exAppCode;
    @XmlElement(nillable = true)
    protected List<TransDocsData> transDocsDatas;

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
     * \u83b7\u53d6docRemark\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocRemark() {
        return docRemark;
    }

    /**
     * \u8bbe\u7f6edocRemark\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocRemark(String value) {
        this.docRemark = value;
    }

    /**
     * \u83b7\u53d6createResubmitTransaction\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public boolean isCreateResubmitTransaction() {
        return createResubmitTransaction;
    }

    /**
     * \u8bbe\u7f6ecreateResubmitTransaction\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setCreateResubmitTransaction(boolean value) {
        this.createResubmitTransaction = value;
    }

    /**
     * \u83b7\u53d6exAppCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExAppCode() {
        return exAppCode;
    }

    /**
     * \u8bbe\u7f6eexAppCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExAppCode(String value) {
        this.exAppCode = value;
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
