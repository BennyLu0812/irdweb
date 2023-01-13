
package com.ird.portal.mega.tpms.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>TPMSCustomer complex type\u7684 Java \u7c7b\u3002
 * 
 * <p>\u4ee5\u4e0b\u6a21\u5f0f\u7247\u6bb5\u6307\u5b9a\u5305\u542b\u5728\u6b64\u7c7b\u4e2d\u7684\u9884\u671f\u5185\u5bb9\u3002
 * 
 * <pre>
 * &lt;complexType name="TPMSCustomer"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="docId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="drivingLicenseCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="drivingLicenseType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="examLanguage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="mobileNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tpmsExemption" type="{http://service.tpms.dsat.mega.com/}TPMSExemption" minOccurs="0"/&gt;
 *         &lt;element name="tpmsProofFile" type="{http://service.tpms.dsat.mega.com/}TPMSProofFile" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TPMSCustomer", propOrder = {
    "docId",
    "drivingLicenseCode",
    "drivingLicenseType",
    "examLanguage",
    "mobileNo",
    "tpmsExemption",
    "tpmsProofFile"
})
public class TPMSCustomer {

    protected Long docId;
    protected String drivingLicenseCode;
    protected String drivingLicenseType;
    protected String examLanguage;
    protected String mobileNo;
    protected TPMSExemption tpmsExemption;
    protected TPMSProofFile tpmsProofFile;

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
     * \u83b7\u53d6drivingLicenseCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrivingLicenseCode() {
        return drivingLicenseCode;
    }

    /**
     * \u8bbe\u7f6edrivingLicenseCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrivingLicenseCode(String value) {
        this.drivingLicenseCode = value;
    }

    /**
     * \u83b7\u53d6drivingLicenseType\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrivingLicenseType() {
        return drivingLicenseType;
    }

    /**
     * \u8bbe\u7f6edrivingLicenseType\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrivingLicenseType(String value) {
        this.drivingLicenseType = value;
    }

    /**
     * \u83b7\u53d6examLanguage\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExamLanguage() {
        return examLanguage;
    }

    /**
     * \u8bbe\u7f6eexamLanguage\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExamLanguage(String value) {
        this.examLanguage = value;
    }

    /**
     * \u83b7\u53d6mobileNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * \u8bbe\u7f6emobileNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMobileNo(String value) {
        this.mobileNo = value;
    }

    /**
     * \u83b7\u53d6tpmsExemption\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link TPMSExemption }
     *     
     */
    public TPMSExemption getTpmsExemption() {
        return tpmsExemption;
    }

    /**
     * \u8bbe\u7f6etpmsExemption\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link TPMSExemption }
     *     
     */
    public void setTpmsExemption(TPMSExemption value) {
        this.tpmsExemption = value;
    }

    /**
     * \u83b7\u53d6tpmsProofFile\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link TPMSProofFile }
     *     
     */
    public TPMSProofFile getTpmsProofFile() {
        return tpmsProofFile;
    }

    /**
     * \u8bbe\u7f6etpmsProofFile\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link TPMSProofFile }
     *     
     */
    public void setTpmsProofFile(TPMSProofFile value) {
        this.tpmsProofFile = value;
    }

}
