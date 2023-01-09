
package com.ird.portal.fds.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 								string defines a Street from DSCC
 * 							
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Street", propOrder = {
    "code",
    "location",
    "zh",
    "en",
    "pt",
    "buildings"
})
public class Street {

    @XmlElement(required = true)
    protected String code;
    @XmlElement(required = true)
    protected String location;
    @XmlElement(required = true)
    protected String zh;
    @XmlElement(required = true)
    protected String en;
    @XmlElement(required = true)
    protected String pt;
    protected List<Building> buildings;

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
     * \u83b7\u53d6location\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocation() {
        return location;
    }

    /**
     * \u8bbe\u7f6elocation\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocation(String value) {
        this.location = value;
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
     * Gets the value of the buildings property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the buildings property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBuildings().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Building }
     * 
     * 
     */
    public List<Building> getBuildings() {
        if (buildings == null) {
            buildings = new ArrayList<Building>();
        }
        return this.buildings;
    }

}
