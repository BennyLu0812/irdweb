
package com.ird.portal.fds.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * 
 * 								Transaction Document Data
 * 							
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransDocsData", propOrder = {
    "spDocID",
    "thirdPartyID",
    "docNameZh",
    "docNamePt",
    "docStatus",
    "docUrl",
    "docUrlType",
    "docCallBackUrl",
    "docUpdateTime",
    "docExtName",
    "attachIdentCode",
    "rtnDocSelectedTxnNo"
})
public class TransDocsData {

    protected long spDocID;
    @XmlElement(required = true)
    protected String thirdPartyID;
    @XmlElement(required = true)
    protected String docNameZh;
    @XmlElement(required = true)
    protected String docNamePt;
    protected boolean docStatus;
    @XmlElement(required = true)
    protected String docUrl;
    @XmlElement(required = true)
    protected String docUrlType;
    @XmlElement(required = true)
    protected String docCallBackUrl;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar docUpdateTime;
    @XmlElement(required = true)
    protected String docExtName;
    @XmlElement(required = true)
    protected String attachIdentCode;
    @XmlElement(required = true)
    protected String rtnDocSelectedTxnNo;

    /**
     * \u83b7\u53d6spDocID\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public long getSpDocID() {
        return spDocID;
    }

    /**
     * \u8bbe\u7f6espDocID\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setSpDocID(long value) {
        this.spDocID = value;
    }

    /**
     * \u83b7\u53d6thirdPartyID\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThirdPartyID() {
        return thirdPartyID;
    }

    /**
     * \u8bbe\u7f6ethirdPartyID\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThirdPartyID(String value) {
        this.thirdPartyID = value;
    }

    /**
     * \u83b7\u53d6docNameZh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocNameZh() {
        return docNameZh;
    }

    /**
     * \u8bbe\u7f6edocNameZh\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocNameZh(String value) {
        this.docNameZh = value;
    }

    /**
     * \u83b7\u53d6docNamePt\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocNamePt() {
        return docNamePt;
    }

    /**
     * \u8bbe\u7f6edocNamePt\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocNamePt(String value) {
        this.docNamePt = value;
    }

    /**
     * \u83b7\u53d6docStatus\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public boolean isDocStatus() {
        return docStatus;
    }

    /**
     * \u8bbe\u7f6edocStatus\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setDocStatus(boolean value) {
        this.docStatus = value;
    }

    /**
     * \u83b7\u53d6docUrl\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocUrl() {
        return docUrl;
    }

    /**
     * \u8bbe\u7f6edocUrl\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocUrl(String value) {
        this.docUrl = value;
    }

    /**
     * \u83b7\u53d6docUrlType\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocUrlType() {
        return docUrlType;
    }

    /**
     * \u8bbe\u7f6edocUrlType\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocUrlType(String value) {
        this.docUrlType = value;
    }

    /**
     * \u83b7\u53d6docCallBackUrl\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocCallBackUrl() {
        return docCallBackUrl;
    }

    /**
     * \u8bbe\u7f6edocCallBackUrl\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocCallBackUrl(String value) {
        this.docCallBackUrl = value;
    }

    /**
     * \u83b7\u53d6docUpdateTime\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDocUpdateTime() {
        return docUpdateTime;
    }

    /**
     * \u8bbe\u7f6edocUpdateTime\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDocUpdateTime(XMLGregorianCalendar value) {
        this.docUpdateTime = value;
    }

    /**
     * \u83b7\u53d6docExtName\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocExtName() {
        return docExtName;
    }

    /**
     * \u8bbe\u7f6edocExtName\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocExtName(String value) {
        this.docExtName = value;
    }

    /**
     * \u83b7\u53d6attachIdentCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttachIdentCode() {
        return attachIdentCode;
    }

    /**
     * \u8bbe\u7f6eattachIdentCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttachIdentCode(String value) {
        this.attachIdentCode = value;
    }

    /**
     * \u83b7\u53d6rtnDocSelectedTxnNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRtnDocSelectedTxnNo() {
        return rtnDocSelectedTxnNo;
    }

    /**
     * \u8bbe\u7f6ertnDocSelectedTxnNo\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRtnDocSelectedTxnNo(String value) {
        this.rtnDocSelectedTxnNo = value;
    }

}
