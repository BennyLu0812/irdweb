
package com.ird.portal.tcs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 								Simple Result for WebService Check
 * 							
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SimpleCheckResult", propOrder = {
    "allow",
    "failedCode"
})
public class SimpleCheckResult {

    protected boolean allow;
    @XmlElement(required = true)
    protected String failedCode;

    /**
     * 获取allow属性的值。
     * 
     */
    public boolean isAllow() {
        return allow;
    }

    /**
     * 设置allow属性的值。
     * 
     */
    public void setAllow(boolean value) {
        this.allow = value;
    }

    /**
     * 获取failedCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFailedCode() {
        return failedCode;
    }

    /**
     * 设置failedCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFailedCode(String value) {
        this.failedCode = value;
    }

}
