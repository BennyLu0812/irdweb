
package com.ird.portal.fds.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 								Zone is the Zone code table which is sharing from
 * 								Service Portal to all client apps.
 * 							
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Zone", propOrder = {
    "code",
    "zh",
    "pt",
    "en",
    "enableDayEnd",
    "addrZh",
    "addrPt",
    "addrEn",
    "enableIssue",
    "ipRanges"
})
public class Zone {

    @XmlElement(required = true)
    protected String code;
    @XmlElement(required = true)
    protected String zh;
    @XmlElement(required = true)
    protected String pt;
    @XmlElement(required = true)
    protected String en;
    protected boolean enableDayEnd;
    @XmlElement(required = true)
    protected String addrZh;
    @XmlElement(required = true)
    protected String addrPt;
    @XmlElement(required = true)
    protected String addrEn;
    protected boolean enableIssue;
    protected List<IPRange> ipRanges;

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
     * \u83b7\u53d6zh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZh() {
        return zh;
    }

    /**
     * \u8bbe\u7f6ezh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZh(String value) {
        this.zh = value;
    }

    /**
     * \u83b7\u53d6pt\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPt() {
        return pt;
    }

    /**
     * \u8bbe\u7f6ept\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPt(String value) {
        this.pt = value;
    }

    /**
     * \u83b7\u53d6en\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEn() {
        return en;
    }

    /**
     * \u8bbe\u7f6een\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEn(String value) {
        this.en = value;
    }

    /**
     * \u83b7\u53d6enableDayEnd\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public boolean isEnableDayEnd() {
        return enableDayEnd;
    }

    /**
     * \u8bbe\u7f6eenableDayEnd\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setEnableDayEnd(boolean value) {
        this.enableDayEnd = value;
    }

    /**
     * \u83b7\u53d6addrZh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddrZh() {
        return addrZh;
    }

    /**
     * \u8bbe\u7f6eaddrZh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddrZh(String value) {
        this.addrZh = value;
    }

    /**
     * \u83b7\u53d6addrPt\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddrPt() {
        return addrPt;
    }

    /**
     * \u8bbe\u7f6eaddrPt\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddrPt(String value) {
        this.addrPt = value;
    }

    /**
     * \u83b7\u53d6addrEn\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddrEn() {
        return addrEn;
    }

    /**
     * \u8bbe\u7f6eaddrEn\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddrEn(String value) {
        this.addrEn = value;
    }

    /**
     * \u83b7\u53d6enableIssue\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public boolean isEnableIssue() {
        return enableIssue;
    }

    /**
     * \u8bbe\u7f6eenableIssue\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setEnableIssue(boolean value) {
        this.enableIssue = value;
    }

    /**
     * Gets the value of the ipRanges property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ipRanges property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIpRanges().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IPRange }
     * 
     * 
     */
    public List<IPRange> getIpRanges() {
        if (ipRanges == null) {
            ipRanges = new ArrayList<IPRange>();
        }
        return this.ipRanges;
    }

}
