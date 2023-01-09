
package com.ird.portal.fds.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type\u7684 Java \u7c7b\u3002
 * 
 * <p>\u4ee5\u4e0b\u6a21\u5f0f\u7247\u6bb5\u6307\u5b9a\u5305\u542b\u5728\u6b64\u7c7b\u4e2d\u7684\u9884\u671f\u5185\u5bb9\u3002
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idTypeCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idNo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="docId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="vId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="driverLicType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="driverLicNo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="categoryTypeCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="categoryNo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="uid" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "idTypeCode",
    "idNo",
    "docId",
    "vId",
    "driverLicType",
    "driverLicNo",
    "categoryTypeCode",
    "categoryNo",
    "uid"
})
@XmlRootElement(name = "isNeedToSendSMS")
public class IsNeedToSendSMS {

    @XmlElement(required = true)
    protected String idTypeCode;
    @XmlElement(required = true)
    protected String idNo;
    protected long docId;
    protected long vId;
    @XmlElement(required = true)
    protected String driverLicType;
    @XmlElement(required = true)
    protected String driverLicNo;
    @XmlElement(required = true)
    protected String categoryTypeCode;
    @XmlElement(required = true)
    protected String categoryNo;
    @XmlElement(required = true)
    protected String uid;

    /**
     * \u83b7\u53d6idTypeCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdTypeCode() {
        return idTypeCode;
    }

    /**
     * \u8bbe\u7f6eidTypeCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdTypeCode(String value) {
        this.idTypeCode = value;
    }

    /**
     * \u83b7\u53d6idNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdNo() {
        return idNo;
    }

    /**
     * \u8bbe\u7f6eidNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdNo(String value) {
        this.idNo = value;
    }

    /**
     * \u83b7\u53d6docId\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public long getDocId() {
        return docId;
    }

    /**
     * \u8bbe\u7f6edocId\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setDocId(long value) {
        this.docId = value;
    }

    /**
     * \u83b7\u53d6vId\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public long getVId() {
        return vId;
    }

    /**
     * \u8bbe\u7f6evId\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setVId(long value) {
        this.vId = value;
    }

    /**
     * \u83b7\u53d6driverLicType\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDriverLicType() {
        return driverLicType;
    }

    /**
     * \u8bbe\u7f6edriverLicType\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDriverLicType(String value) {
        this.driverLicType = value;
    }

    /**
     * \u83b7\u53d6driverLicNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDriverLicNo() {
        return driverLicNo;
    }

    /**
     * \u8bbe\u7f6edriverLicNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDriverLicNo(String value) {
        this.driverLicNo = value;
    }

    /**
     * \u83b7\u53d6categoryTypeCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategoryTypeCode() {
        return categoryTypeCode;
    }

    /**
     * \u8bbe\u7f6ecategoryTypeCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategoryTypeCode(String value) {
        this.categoryTypeCode = value;
    }

    /**
     * \u83b7\u53d6categoryNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategoryNo() {
        return categoryNo;
    }

    /**
     * \u8bbe\u7f6ecategoryNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategoryNo(String value) {
        this.categoryNo = value;
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

}
