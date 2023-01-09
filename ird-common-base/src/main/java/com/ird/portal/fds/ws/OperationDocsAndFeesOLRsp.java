
package com.ird.portal.fds.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 								get Operation's ServiceDocuments And ServiceFees
 * 								Response
 * 							
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OperationDocsAndFeesOLRsp", propOrder = {
    "counterServiceDocuments",
    "onlineServiceDocuments",
    "busiServiceFees",
    "optionalBusiServiceFees"
})
public class OperationDocsAndFeesOLRsp {

    protected List<ServiceDocument> counterServiceDocuments;
    protected List<ServiceDocument> onlineServiceDocuments;
    protected List<ServiceFee> busiServiceFees;
    protected List<ServiceFee> optionalBusiServiceFees;

    /**
     * Gets the value of the counterServiceDocuments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the counterServiceDocuments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCounterServiceDocuments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceDocument }
     * 
     * 
     */
    public List<ServiceDocument> getCounterServiceDocuments() {
        if (counterServiceDocuments == null) {
            counterServiceDocuments = new ArrayList<ServiceDocument>();
        }
        return this.counterServiceDocuments;
    }

    /**
     * Gets the value of the onlineServiceDocuments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the onlineServiceDocuments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOnlineServiceDocuments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceDocument }
     * 
     * 
     */
    public List<ServiceDocument> getOnlineServiceDocuments() {
        if (onlineServiceDocuments == null) {
            onlineServiceDocuments = new ArrayList<ServiceDocument>();
        }
        return this.onlineServiceDocuments;
    }

    /**
     * Gets the value of the busiServiceFees property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the busiServiceFees property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBusiServiceFees().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceFee }
     * 
     * 
     */
    public List<ServiceFee> getBusiServiceFees() {
        if (busiServiceFees == null) {
            busiServiceFees = new ArrayList<ServiceFee>();
        }
        return this.busiServiceFees;
    }

    /**
     * Gets the value of the optionalBusiServiceFees property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the optionalBusiServiceFees property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOptionalBusiServiceFees().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceFee }
     * 
     * 
     */
    public List<ServiceFee> getOptionalBusiServiceFees() {
        if (optionalBusiServiceFees == null) {
            optionalBusiServiceFees = new ArrayList<ServiceFee>();
        }
        return this.optionalBusiServiceFees;
    }

}
