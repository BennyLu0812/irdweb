
package com.ird.portal.fds.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 								Submit FeeEntry Request Object
 * 							
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubmitFeeEntryReq", propOrder = {
    "isUpdateFeeRequests",
    "feeRemark",
    "exemptReason",
    "serviceFeeRequests"
})
public class SubmitFeeEntryReq {

    protected boolean isUpdateFeeRequests;
    @XmlElement(required = true)
    protected String feeRemark;
    @XmlElement(required = true)
    protected String exemptReason;
    @XmlElement(nillable = true)
    protected List<ServiceFeeRequest> serviceFeeRequests;

    /**
     * \u83b7\u53d6isUpdateFeeRequests\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public boolean isIsUpdateFeeRequests() {
        return isUpdateFeeRequests;
    }

    /**
     * \u8bbe\u7f6eisUpdateFeeRequests\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setIsUpdateFeeRequests(boolean value) {
        this.isUpdateFeeRequests = value;
    }

    /**
     * \u83b7\u53d6feeRemark\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeRemark() {
        return feeRemark;
    }

    /**
     * \u8bbe\u7f6efeeRemark\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeRemark(String value) {
        this.feeRemark = value;
    }

    /**
     * \u83b7\u53d6exemptReason\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExemptReason() {
        return exemptReason;
    }

    /**
     * \u8bbe\u7f6eexemptReason\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExemptReason(String value) {
        this.exemptReason = value;
    }

    /**
     * Gets the value of the serviceFeeRequests property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceFeeRequests property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceFeeRequests().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceFeeRequest }
     * 
     * 
     */
    public List<ServiceFeeRequest> getServiceFeeRequests() {
        if (serviceFeeRequests == null) {
            serviceFeeRequests = new ArrayList<ServiceFeeRequest>();
        }
        return this.serviceFeeRequests;
    }

}
