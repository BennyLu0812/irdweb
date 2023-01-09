
package com.ird.portal.fds.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 								Procedure Output Object
 * 							
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProceOutput", propOrder = {
    "allCallSuccess",
    "failedAtIndex",
    "details"
})
public class ProceOutput {

    protected boolean allCallSuccess;
    protected int failedAtIndex;
    @XmlElement(nillable = true)
    protected List<ProceOutDetail> details;

    /**
     * \u83b7\u53d6allCallSuccess\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public boolean isAllCallSuccess() {
        return allCallSuccess;
    }

    /**
     * \u8bbe\u7f6eallCallSuccess\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setAllCallSuccess(boolean value) {
        this.allCallSuccess = value;
    }

    /**
     * \u83b7\u53d6failedAtIndex\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public int getFailedAtIndex() {
        return failedAtIndex;
    }

    /**
     * \u8bbe\u7f6efailedAtIndex\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setFailedAtIndex(int value) {
        this.failedAtIndex = value;
    }

    /**
     * Gets the value of the details property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the details property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProceOutDetail }
     * 
     * 
     */
    public List<ProceOutDetail> getDetails() {
        if (details == null) {
            details = new ArrayList<ProceOutDetail>();
        }
        return this.details;
    }

}
