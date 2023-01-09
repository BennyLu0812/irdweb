
package com.ird.portal.fds.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * 
 * 								DayEndDetails is the workdays Day-end details
 * 							
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DayEndDetails", propOrder = {
    "zoneCode",
    "zoneName",
    "applicationCode",
    "receiptDate",
    "receiptCount",
    "receiptAmount",
    "serviceCount",
    "serviceCancelCount",
    "receiptModifyCount",
    "pendingRecords",
    "dayEndInfos"
})
public class DayEndDetails {

    @XmlElement(required = true)
    protected String zoneCode;
    @XmlElement(required = true)
    protected String zoneName;
    @XmlElement(required = true)
    protected String applicationCode;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar receiptDate;
    protected int receiptCount;
    protected double receiptAmount;
    protected int serviceCount;
    protected int serviceCancelCount;
    protected int receiptModifyCount;
    protected List<PendingRecord> pendingRecords;
    protected List<DayEndInfo> dayEndInfos;

    /**
     * \u83b7\u53d6zoneCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZoneCode() {
        return zoneCode;
    }

    /**
     * \u8bbe\u7f6ezoneCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZoneCode(String value) {
        this.zoneCode = value;
    }

    /**
     * \u83b7\u53d6zoneName\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZoneName() {
        return zoneName;
    }

    /**
     * \u8bbe\u7f6ezoneName\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZoneName(String value) {
        this.zoneName = value;
    }

    /**
     * \u83b7\u53d6applicationCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicationCode() {
        return applicationCode;
    }

    /**
     * \u8bbe\u7f6eapplicationCode\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicationCode(String value) {
        this.applicationCode = value;
    }

    /**
     * \u83b7\u53d6receiptDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getReceiptDate() {
        return receiptDate;
    }

    /**
     * \u8bbe\u7f6ereceiptDate\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setReceiptDate(XMLGregorianCalendar value) {
        this.receiptDate = value;
    }

    /**
     * \u83b7\u53d6receiptCount\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public int getReceiptCount() {
        return receiptCount;
    }

    /**
     * \u8bbe\u7f6ereceiptCount\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setReceiptCount(int value) {
        this.receiptCount = value;
    }

    /**
     * \u83b7\u53d6receiptAmount\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public double getReceiptAmount() {
        return receiptAmount;
    }

    /**
     * \u8bbe\u7f6ereceiptAmount\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setReceiptAmount(double value) {
        this.receiptAmount = value;
    }

    /**
     * \u83b7\u53d6serviceCount\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public int getServiceCount() {
        return serviceCount;
    }

    /**
     * \u8bbe\u7f6eserviceCount\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setServiceCount(int value) {
        this.serviceCount = value;
    }

    /**
     * \u83b7\u53d6serviceCancelCount\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public int getServiceCancelCount() {
        return serviceCancelCount;
    }

    /**
     * \u8bbe\u7f6eserviceCancelCount\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setServiceCancelCount(int value) {
        this.serviceCancelCount = value;
    }

    /**
     * \u83b7\u53d6receiptModifyCount\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public int getReceiptModifyCount() {
        return receiptModifyCount;
    }

    /**
     * \u8bbe\u7f6ereceiptModifyCount\u5c5e\u6027\u7684\u503c\u3002
     * 
     */
    public void setReceiptModifyCount(int value) {
        this.receiptModifyCount = value;
    }

    /**
     * Gets the value of the pendingRecords property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pendingRecords property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPendingRecords().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PendingRecord }
     * 
     * 
     */
    public List<PendingRecord> getPendingRecords() {
        if (pendingRecords == null) {
            pendingRecords = new ArrayList<PendingRecord>();
        }
        return this.pendingRecords;
    }

    /**
     * Gets the value of the dayEndInfos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dayEndInfos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDayEndInfos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DayEndInfo }
     * 
     * 
     */
    public List<DayEndInfo> getDayEndInfos() {
        if (dayEndInfos == null) {
            dayEndInfos = new ArrayList<DayEndInfo>();
        }
        return this.dayEndInfos;
    }

}
