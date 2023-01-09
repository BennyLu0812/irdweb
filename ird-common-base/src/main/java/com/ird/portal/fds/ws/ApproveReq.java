
package com.ird.portal.fds.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 								Approve Req
 * 							
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ApproveReq", propOrder = {
    "uid",
    "incomeIP",
    "exAppCode",
    "keys",
    "procInput"
})
public class ApproveReq {

    @XmlElement(required = true)
    protected String uid;
    @XmlElement(required = true)
    protected String incomeIP;
    @XmlElement(required = true)
    protected String exAppCode;
    @XmlElement(nillable = true)
    protected List<TransactionActionKey> keys;
    @XmlElement(required = true)
    protected ProceInput procInput;

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
     * Gets the value of the keys property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the keys property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKeys().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransactionActionKey }
     * 
     * 
     */
    public List<TransactionActionKey> getKeys() {
        if (keys == null) {
            keys = new ArrayList<TransactionActionKey>();
        }
        return this.keys;
    }

    /**
     * \u83b7\u53d6procInput\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link ProceInput }
     *     
     */
    public ProceInput getProcInput() {
        return procInput;
    }

    /**
     * \u8bbe\u7f6eprocInput\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link ProceInput }
     *     
     */
    public void setProcInput(ProceInput value) {
        this.procInput = value;
    }

}
