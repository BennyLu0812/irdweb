
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
 *         &lt;element name="zoneCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="first" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="count" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
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
    "zoneCode",
    "first",
    "count"
})
@XmlRootElement(name = "getDayEndDetails")
public class GetDayEndDetails {

    @XmlElement(required = true)
    protected String zoneCode;
    protected long first;
    protected long count;

    /**
     * \u83b7\u53d6zoneCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZoneCode() {
        return zoneCode;
    }

    /**
     * \u8bbe\u7f6ezoneCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZoneCode(String value) {
        this.zoneCode = value;
    }

    /**
     * \u83b7\u53d6first\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public long getFirst() {
        return first;
    }

    /**
     * \u8bbe\u7f6efirst\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setFirst(long value) {
        this.first = value;
    }

    /**
     * \u83b7\u53d6count\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public long getCount() {
        return count;
    }

    /**
     * \u8bbe\u7f6ecount\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setCount(long value) {
        this.count = value;
    }

}