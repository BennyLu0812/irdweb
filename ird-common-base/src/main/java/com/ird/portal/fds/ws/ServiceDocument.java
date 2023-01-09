
package com.ird.portal.fds.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 								service Document
 * 							
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceDocument")
public class ServiceDocument {

    @XmlAttribute(name = "serviceDocumentID")
    protected Long serviceDocumentID;
    @XmlAttribute(name = "code")
    protected String code;
    @XmlAttribute(name = "nameZh")
    protected String nameZh;
    @XmlAttribute(name = "namePt")
    protected String namePt;
    @XmlAttribute(name = "category")
    protected Integer category;
    @XmlAttribute(name = "displayOrder")
    protected Integer displayOrder;
    @XmlAttribute(name = "upLoadable")
    protected Boolean upLoadable;
    @XmlAttribute(name = "attachIdentCode")
    protected String attachIdentCode;

    /**
     * \u83b7\u53d6serviceDocumentID\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getServiceDocumentID() {
        return serviceDocumentID;
    }

    /**
     * \u8bbe\u7f6eserviceDocumentID\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setServiceDocumentID(Long value) {
        this.serviceDocumentID = value;
    }

    /**
     * \u83b7\u53d6code\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * \u8bbe\u7f6ecode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * \u83b7\u53d6nameZh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameZh() {
        return nameZh;
    }

    /**
     * \u8bbe\u7f6enameZh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameZh(String value) {
        this.nameZh = value;
    }

    /**
     * \u83b7\u53d6namePt\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNamePt() {
        return namePt;
    }

    /**
     * \u8bbe\u7f6enamePt\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNamePt(String value) {
        this.namePt = value;
    }

    /**
     * \u83b7\u53d6category\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCategory() {
        return category;
    }

    /**
     * \u8bbe\u7f6ecategory\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCategory(Integer value) {
        this.category = value;
    }

    /**
     * \u83b7\u53d6displayOrder\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDisplayOrder() {
        return displayOrder;
    }

    /**
     * \u8bbe\u7f6edisplayOrder\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDisplayOrder(Integer value) {
        this.displayOrder = value;
    }

    /**
     * \u83b7\u53d6upLoadable\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isUpLoadable() {
        return upLoadable;
    }

    /**
     * \u8bbe\u7f6eupLoadable\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUpLoadable(Boolean value) {
        this.upLoadable = value;
    }

    /**
     * \u83b7\u53d6attachIdentCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttachIdentCode() {
        return attachIdentCode;
    }

    /**
     * \u8bbe\u7f6eattachIdentCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttachIdentCode(String value) {
        this.attachIdentCode = value;
    }

}
