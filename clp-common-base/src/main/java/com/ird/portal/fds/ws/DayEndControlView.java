
package com.ird.portal.fds.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * 
 * 								DayEndControlView is the no Day-end zone Info
 * 							
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DayEndControlView", propOrder = {
    "zoneCode",
    "noDayEndCount",
    "minNotDayEndDate",
    "maxNotDayEndDate"
})
public class DayEndControlView {

    @XmlElement(required = true)
    protected String zoneCode;
    protected int noDayEndCount;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar minNotDayEndDate;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar maxNotDayEndDate;

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
     * \u83b7\u53d6noDayEndCount\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public int getNoDayEndCount() {
        return noDayEndCount;
    }

    /**
     * \u8bbe\u7f6enoDayEndCount\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setNoDayEndCount(int value) {
        this.noDayEndCount = value;
    }

    /**
     * \u83b7\u53d6minNotDayEndDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getMinNotDayEndDate() {
        return minNotDayEndDate;
    }

    /**
     * \u8bbe\u7f6eminNotDayEndDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setMinNotDayEndDate(XMLGregorianCalendar value) {
        this.minNotDayEndDate = value;
    }

    /**
     * \u83b7\u53d6maxNotDayEndDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getMaxNotDayEndDate() {
        return maxNotDayEndDate;
    }

    /**
     * \u8bbe\u7f6emaxNotDayEndDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setMaxNotDayEndDate(XMLGregorianCalendar value) {
        this.maxNotDayEndDate = value;
    }

}
