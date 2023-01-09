
package com.ird.portal.be.ws;

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
 *         &lt;element name="oldDocId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="newDocId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
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
    "oldDocId",
    "newDocId",
    "uid"
})
@XmlRootElement(name = "updateInterDrivingLicRecordDocId")
public class UpdateInterDrivingLicRecordDocId {

    protected long oldDocId;
    protected long newDocId;
    @XmlElement(required = true)
    protected String uid;

    /**
     * \u83b7\u53d6oldDocId\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public long getOldDocId() {
        return oldDocId;
    }

    /**
     * \u8bbe\u7f6eoldDocId\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setOldDocId(long value) {
        this.oldDocId = value;
    }

    /**
     * \u83b7\u53d6newDocId\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public long getNewDocId() {
        return newDocId;
    }

    /**
     * \u8bbe\u7f6enewDocId\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setNewDocId(long value) {
        this.newDocId = value;
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
