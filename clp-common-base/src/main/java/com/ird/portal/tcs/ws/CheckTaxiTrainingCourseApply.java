
package com.ird.portal.tcs.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="docId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="userInfo" type="{urn:dsat.gov.mo:tcs/ws}UserInfo"/&gt;
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
    "docId",
    "userInfo"
})
@XmlRootElement(name = "checkTaxiTrainingCourseApply")
public class CheckTaxiTrainingCourseApply {

    protected long docId;
    @XmlElement(required = true)
    protected UserInfo userInfo;

    /**
     * 获取docId属性的值。
     * 
     */
    public long getDocId() {
        return docId;
    }

    /**
     * 设置docId属性的值。
     * 
     */
    public void setDocId(long value) {
        this.docId = value;
    }

    /**
     * 获取userInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link UserInfo }
     *     
     */
    public UserInfo getUserInfo() {
        return userInfo;
    }

    /**
     * 设置userInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link UserInfo }
     *     
     */
    public void setUserInfo(UserInfo value) {
        this.userInfo = value;
    }

}
