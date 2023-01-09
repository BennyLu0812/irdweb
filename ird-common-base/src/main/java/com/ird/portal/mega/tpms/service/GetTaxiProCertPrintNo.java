
package com.ird.portal.mega.tpms.service;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>getTaxiProCertPrintNo complex type\u7684 Java \u7c7b\u3002
 * 
 * <p>\u4ee5\u4e0b\u6a21\u5f0f\u7247\u6bb5\u6307\u5b9a\u5305\u542b\u5728\u6b64\u7c7b\u4e2d\u7684\u9884\u671f\u5185\u5bb9\u3002
 * 
 * <pre>
 * &lt;complexType name="getTaxiProCertPrintNo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="taxiProCertNo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="modifiedCodes" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="actionParam" type="{http://service.tpms.dsat.mega.com/}ActionParam" minOccurs="0"/&gt;
 *         &lt;element name="spTxnno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getTaxiProCertPrintNo", propOrder = {
    "taxiProCertNo",
    "modifiedCodes",
    "actionParam",
    "spTxnno"
})
public class GetTaxiProCertPrintNo {

    protected Long taxiProCertNo;
    protected List<String> modifiedCodes;
    protected ActionParam actionParam;
    protected String spTxnno;

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
     * Gets the value of the modifiedCodes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the modifiedCodes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getModifiedCodes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getModifiedCodes() {
        if (modifiedCodes == null) {
            modifiedCodes = new ArrayList<String>();
        }
        return this.modifiedCodes;
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

    /**
     * \u83b7\u53d6spTxnno\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpTxnno() {
        return spTxnno;
    }

    /**
     * \u8bbe\u7f6espTxnno\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpTxnno(String value) {
        this.spTxnno = value;
    }

}
