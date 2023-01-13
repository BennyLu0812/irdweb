
package com.ird.portal.mega.tpms.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>cancelTPMSProCert complex type\u7684 Java \u7c7b\u3002
 * 
 * <p>\u4ee5\u4e0b\u6a21\u5f0f\u7247\u6bb5\u6307\u5b9a\u5305\u542b\u5728\u6b64\u7c7b\u4e2d\u7684\u9884\u671f\u5185\u5bb9\u3002
 * 
 * <pre>
 * &lt;complexType name="cancelTPMSProCert"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="txnNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="docId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="taxiProCertNo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="applicationType" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="actionParam" type="{http://service.tpms.dsat.mega.com/}ActionParam" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cancelTPMSProCert", propOrder = {
    "txnNo",
    "docId",
    "taxiProCertNo",
    "applicationType",
    "actionParam"
})
public class CancelTPMSProCert {

    protected String txnNo;
    protected Long docId;
    protected Long taxiProCertNo;
    protected int applicationType;
    protected ActionParam actionParam;

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
     * \u83b7\u53d6docId\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDocId() {
        return docId;
    }

    /**
     * \u8bbe\u7f6edocId\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDocId(Long value) {
        this.docId = value;
    }

    /**
     * \u83b7\u53d6taxiProCertNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTaxiProCertNo() {
        return taxiProCertNo;
    }

    /**
     * \u8bbe\u7f6etaxiProCertNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTaxiProCertNo(Long value) {
        this.taxiProCertNo = value;
    }

    /**
     * \u83b7\u53d6applicationType\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public int getApplicationType() {
        return applicationType;
    }

    /**
     * \u8bbe\u7f6eapplicationType\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setApplicationType(int value) {
        this.applicationType = value;
    }

    /**
     * \u83b7\u53d6actionParam\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link ActionParam }
     *     
     */
    public ActionParam getActionParam() {
        return actionParam;
    }

    /**
     * \u8bbe\u7f6eactionParam\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link ActionParam }
     *     
     */
    public void setActionParam(ActionParam value) {
        this.actionParam = value;
    }

}
