
package com.ird.portal.fds.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 								Photo Result
 * 							
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PhotoResult", propOrder = {
    "success",
    "photoId",
    "errorMsg"
})
public class PhotoResult {

    protected boolean success;
    protected long photoId;
    @XmlElement(required = true)
    protected String errorMsg;

    /**
     * \u83b7\u53d6success\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * \u8bbe\u7f6esuccess\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setSuccess(boolean value) {
        this.success = value;
    }

    /**
     * \u83b7\u53d6photoId\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public long getPhotoId() {
        return photoId;
    }

    /**
     * \u8bbe\u7f6ephotoId\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setPhotoId(long value) {
        this.photoId = value;
    }

    /**
     * \u83b7\u53d6errorMsg\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * \u8bbe\u7f6eerrorMsg\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorMsg(String value) {
        this.errorMsg = value;
    }

}
