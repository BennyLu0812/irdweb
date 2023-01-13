
package com.ird.portal.mega.tpms.service;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>TPMSData complex type\u7684 Java \u7c7b\u3002
 * 
 * <p>\u4ee5\u4e0b\u6a21\u5f0f\u7247\u6bb5\u6307\u5b9a\u5305\u542b\u5728\u6b64\u7c7b\u4e2d\u7684\u9884\u671f\u5185\u5bb9\u3002
 * 
 * <pre>
 * &lt;complexType name="TPMSData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="certCanceledForY5C4" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="customer" type="{http://service.tpms.dsat.mega.com/}TPMSCustomer" minOccurs="0"/&gt;
 *         &lt;element name="examLangCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="examRecords" type="{http://service.tpms.dsat.mega.com/}TPMSExamRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="exemptions" type="{http://service.tpms.dsat.mega.com/}TPMSExemption" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="fines" type="{http://service.tpms.dsat.mega.com/}TPMSProCertFine" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="latestExamTime" type="{http://service.tpms.dsat.mega.com/}TPMSExamTime" minOccurs="0"/&gt;
 *         &lt;element name="renewals" type="{http://service.tpms.dsat.mega.com/}TPMSRenewal" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="tpmsProCert" type="{http://service.tpms.dsat.mega.com/}TPMSProCert" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TPMSData", propOrder = {
    "certCanceledForY5C4",
    "customer",
    "examLangCode",
    "examRecords",
    "exemptions",
    "fines",
    "latestExamTime",
    "renewals",
    "tpmsProCert"
})
public class TPMSData {

    protected Boolean certCanceledForY5C4;
    protected TPMSCustomer customer;
    protected String examLangCode;
    @XmlElement(nillable = true)
    protected List<TPMSExamRecord> examRecords;
    @XmlElement(nillable = true)
    protected List<TPMSExemption> exemptions;
    @XmlElement(nillable = true)
    protected List<TPMSProCertFine> fines;
    protected TPMSExamTime latestExamTime;
    @XmlElement(nillable = true)
    protected List<TPMSRenewal> renewals;
    protected TPMSProCert tpmsProCert;

    /**
     * \u83b7\u53d6certCanceledForY5C4\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCertCanceledForY5C4() {
        return certCanceledForY5C4;
    }

    /**
     * \u8bbe\u7f6ecertCanceledForY5C4\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCertCanceledForY5C4(Boolean value) {
        this.certCanceledForY5C4 = value;
    }

    /**
     * \u83b7\u53d6customer\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link TPMSCustomer }
     *     
     */
    public TPMSCustomer getCustomer() {
        return customer;
    }

    /**
     * \u8bbe\u7f6ecustomer\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link TPMSCustomer }
     *     
     */
    public void setCustomer(TPMSCustomer value) {
        this.customer = value;
    }

    /**
     * \u83b7\u53d6examLangCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExamLangCode() {
        return examLangCode;
    }

    /**
     * \u8bbe\u7f6eexamLangCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExamLangCode(String value) {
        this.examLangCode = value;
    }

    /**
     * Gets the value of the examRecords property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the examRecords property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExamRecords().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TPMSExamRecord }
     * 
     * 
     */
    public List<TPMSExamRecord> getExamRecords() {
        if (examRecords == null) {
            examRecords = new ArrayList<TPMSExamRecord>();
        }
        return this.examRecords;
    }

    /**
     * Gets the value of the exemptions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exemptions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExemptions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TPMSExemption }
     * 
     * 
     */
    public List<TPMSExemption> getExemptions() {
        if (exemptions == null) {
            exemptions = new ArrayList<TPMSExemption>();
        }
        return this.exemptions;
    }

    /**
     * Gets the value of the fines property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fines property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFines().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TPMSProCertFine }
     * 
     * 
     */
    public List<TPMSProCertFine> getFines() {
        if (fines == null) {
            fines = new ArrayList<TPMSProCertFine>();
        }
        return this.fines;
    }

    /**
     * \u83b7\u53d6latestExamTime\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link TPMSExamTime }
     *     
     */
    public TPMSExamTime getLatestExamTime() {
        return latestExamTime;
    }

    /**
     * \u8bbe\u7f6elatestExamTime\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link TPMSExamTime }
     *     
     */
    public void setLatestExamTime(TPMSExamTime value) {
        this.latestExamTime = value;
    }

    /**
     * Gets the value of the renewals property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the renewals property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRenewals().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TPMSRenewal }
     * 
     * 
     */
    public List<TPMSRenewal> getRenewals() {
        if (renewals == null) {
            renewals = new ArrayList<TPMSRenewal>();
        }
        return this.renewals;
    }

    /**
     * \u83b7\u53d6tpmsProCert\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link TPMSProCert }
     *     
     */
    public TPMSProCert getTpmsProCert() {
        return tpmsProCert;
    }

    /**
     * \u8bbe\u7f6etpmsProCert\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link TPMSProCert }
     *     
     */
    public void setTpmsProCert(TPMSProCert value) {
        this.tpmsProCert = value;
    }

}
