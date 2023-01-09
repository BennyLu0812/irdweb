
package com.ird.portal.fds.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>anonymous complex type\u7684 Java \u7c7b\u3002
 * 
 * <p>\u4ee5\u4e0b\u6a21\u5f0f\u7247\u6bb5\u6307\u5b9a\u5305\u542b\u5728\u6b64\u7c7b\u4e2d\u7684\u9884\u671f\u5185\u5bb9\u3002
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="startDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" /&gt;
 *       &lt;attribute name="dateStyle" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;attribute name="deltaDays" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;attribute name="countDays" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;attribute name="countHalfday" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "getNextDateProfileRequest")
public class GetNextDateProfileRequest {

    @XmlAttribute(name = "startDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startDate;
    @XmlAttribute(name = "dateStyle")
    protected Integer dateStyle;
    @XmlAttribute(name = "deltaDays")
    protected Integer deltaDays;
    @XmlAttribute(name = "countDays")
    protected Integer countDays;
    @XmlAttribute(name = "countHalfday")
    protected Boolean countHalfday;

    /**
     * \u83b7\u53d6startDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * \u8bbe\u7f6estartDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

    /**
     * \u83b7\u53d6dateStyle\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDateStyle() {
        return dateStyle;
    }

    /**
     * \u8bbe\u7f6edateStyle\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDateStyle(Integer value) {
        this.dateStyle = value;
    }

    /**
     * \u83b7\u53d6deltaDays\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDeltaDays() {
        return deltaDays;
    }

    /**
     * \u8bbe\u7f6edeltaDays\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDeltaDays(Integer value) {
        this.deltaDays = value;
    }

    /**
     * \u83b7\u53d6countDays\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCountDays() {
        return countDays;
    }

    /**
     * \u8bbe\u7f6ecountDays\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCountDays(Integer value) {
        this.countDays = value;
    }

    /**
     * \u83b7\u53d6countHalfday\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isCountHalfday() {
        if (countHalfday == null) {
            return false;
        } else {
            return countHalfday;
        }
    }

    /**
     * \u8bbe\u7f6ecountHalfday\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCountHalfday(Boolean value) {
        this.countHalfday = value;
    }

}
