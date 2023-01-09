
package com.ird.portal.fds.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 								Rubrica defines a rubrica from DSCC
 * 							
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Rubrica", propOrder = {
    "code",
    "zh",
    "pt",
    "enable",
    "receiptas"
})
public class Rubrica {

    @XmlElement(required = true)
    protected String code;
    @XmlElement(required = true)
    protected String zh;
    @XmlElement(required = true)
    protected String pt;
    protected boolean enable;
    protected List<Receipta> receiptas;

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
     * \u83b7\u53d6enable\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public boolean isEnable() {
        return enable;
    }

    /**
     * \u8bbe\u7f6eenable\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setEnable(boolean value) {
        this.enable = value;
    }

    /**
     * Gets the value of the receiptas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the receiptas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReceiptas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Receipta }
     * 
     * 
     */
    public List<Receipta> getReceiptas() {
        if (receiptas == null) {
            receiptas = new ArrayList<Receipta>();
        }
        return this.receiptas;
    }

}
