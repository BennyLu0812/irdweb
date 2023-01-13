
package com.ird.portal.fds.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * 
 * 								An Phone Call History
 * 							
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PhoneCallHistory")
public class PhoneCallHistory {

    @XmlAttribute(name = "contactUid")
    protected String contactUid;
    @XmlAttribute(name = "phoneContent")
    protected String phoneContent;
    @XmlAttribute(name = "clientTel")
    protected String clientTel;
    @XmlAttribute(name = "contactTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar contactTime;
    @XmlAttribute(name = "phoneCallResult")
    protected PhoneCallResult phoneCallResult;

    /**
     * \u83b7\u53d6contactUid\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactUid() {
        return contactUid;
    }

    /**
     * \u8bbe\u7f6econtactUid\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactUid(String value) {
        this.contactUid = value;
    }

    /**
     * \u83b7\u53d6phoneContent\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoneContent() {
        return phoneContent;
    }

    /**
     * \u8bbe\u7f6ephoneContent\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoneContent(String value) {
        this.phoneContent = value;
    }

    /**
     * \u83b7\u53d6clientTel\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientTel() {
        return clientTel;
    }

    /**
     * \u8bbe\u7f6eclientTel\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientTel(String value) {
        this.clientTel = value;
    }

    /**
     * \u83b7\u53d6contactTime\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getContactTime() {
        return contactTime;
    }

    /**
     * \u8bbe\u7f6econtactTime\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setContactTime(XMLGregorianCalendar value) {
        this.contactTime = value;
    }

    /**
     * \u83b7\u53d6phoneCallResult\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link PhoneCallResult }
     *     
     */
    public PhoneCallResult getPhoneCallResult() {
        return phoneCallResult;
    }

    /**
     * \u8bbe\u7f6ephoneCallResult\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link PhoneCallResult }
     *     
     */
    public void setPhoneCallResult(PhoneCallResult value) {
        this.phoneCallResult = value;
    }

}
