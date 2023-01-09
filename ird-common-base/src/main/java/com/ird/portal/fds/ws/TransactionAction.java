
package com.ird.portal.fds.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * 
 * 								An Transaction Action
 * 							
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionAction")
public class TransactionAction {

    @XmlAttribute(name = "zh")
    protected String zh;
    @XmlAttribute(name = "pt")
    protected String pt;
    @XmlAttribute(name = "serviceActionType")
    protected String serviceActionType;
    @XmlAttribute(name = "selectionGroupId")
    protected Integer selectionGroupId;
    @XmlAttribute(name = "displayOrder")
    protected Integer displayOrder;
    @XmlAttribute(name = "systemUpdateOnly")
    protected Boolean systemUpdateOnly;
    @XmlAttribute(name = "needSend")
    protected Boolean needSend;
    @XmlAttribute(name = "needSendDTS")
    protected Boolean needSendDTS;
    @XmlAttribute(name = "needSendEmail")
    protected Boolean needSendEmail;
    @XmlAttribute(name = "needSendSMS")
    protected Boolean needSendSMS;
    @XmlAttribute(name = "actualSendSms")
    protected Boolean actualSendSms;
    @XmlAttribute(name = "actualSendEmail")
    protected Boolean actualSendEmail;
    @XmlAttribute(name = "selected")
    protected Boolean selected;
    @XmlAttribute(name = "selectTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar selectTime;
    @XmlAttribute(name = "selectUid")
    protected String selectUid;
    @XmlAttribute(name = "createUid")
    protected String createUid;
    @XmlAttribute(name = "updateUid")
    protected String updateUid;
    @XmlAttribute(name = "createTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createTime;
    @XmlAttribute(name = "updateTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar updateTime;
    @XmlAttribute(name = "smsResultTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar smsResultTime;
    @XmlAttribute(name = "smsId")
    protected String smsId;
    @XmlAttribute(name = "emailResultTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar emailResultTime;
    @XmlAttribute(name = "dtsResultTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dtsResultTime;
    @XmlAttribute(name = "smsContent")
    protected String smsContent;
    @XmlAttribute(name = "emailContent")
    protected String emailContent;
    @XmlAttribute(name = "emailTitle")
    protected String emailTitle;
    @XmlAttribute(name = "completeStatus")
    protected Boolean completeStatus;
    @XmlAttribute(name = "smsResult")
    protected NotificationResult smsResult;
    @XmlAttribute(name = "emailResult")
    protected NotificationResult emailResult;
    @XmlAttribute(name = "dtsResult")
    protected NotificationResult dtsResult;
    @XmlAttribute(name = "workflowStage")
    protected WorkflowStage workflowStage;

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
     * \u83b7\u53d6serviceActionType\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceActionType() {
        return serviceActionType;
    }

    /**
     * \u8bbe\u7f6eserviceActionType\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceActionType(String value) {
        this.serviceActionType = value;
    }

    /**
     * \u83b7\u53d6selectionGroupId\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSelectionGroupId() {
        return selectionGroupId;
    }

    /**
     * \u8bbe\u7f6eselectionGroupId\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSelectionGroupId(Integer value) {
        this.selectionGroupId = value;
    }

    /**
     * \u83b7\u53d6displayOrder\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDisplayOrder() {
        return displayOrder;
    }

    /**
     * \u8bbe\u7f6edisplayOrder\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDisplayOrder(Integer value) {
        this.displayOrder = value;
    }

    /**
     * \u83b7\u53d6systemUpdateOnly\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSystemUpdateOnly() {
        return systemUpdateOnly;
    }

    /**
     * \u8bbe\u7f6esystemUpdateOnly\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSystemUpdateOnly(Boolean value) {
        this.systemUpdateOnly = value;
    }

    /**
     * \u83b7\u53d6needSend\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNeedSend() {
        return needSend;
    }

    /**
     * \u8bbe\u7f6eneedSend\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNeedSend(Boolean value) {
        this.needSend = value;
    }

    /**
     * \u83b7\u53d6needSendDTS\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNeedSendDTS() {
        return needSendDTS;
    }

    /**
     * \u8bbe\u7f6eneedSendDTS\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNeedSendDTS(Boolean value) {
        this.needSendDTS = value;
    }

    /**
     * \u83b7\u53d6needSendEmail\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNeedSendEmail() {
        return needSendEmail;
    }

    /**
     * \u8bbe\u7f6eneedSendEmail\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNeedSendEmail(Boolean value) {
        this.needSendEmail = value;
    }

    /**
     * \u83b7\u53d6needSendSMS\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNeedSendSMS() {
        return needSendSMS;
    }

    /**
     * \u8bbe\u7f6eneedSendSMS\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNeedSendSMS(Boolean value) {
        this.needSendSMS = value;
    }

    /**
     * \u83b7\u53d6actualSendSms\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isActualSendSms() {
        return actualSendSms;
    }

    /**
     * \u8bbe\u7f6eactualSendSms\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setActualSendSms(Boolean value) {
        this.actualSendSms = value;
    }

    /**
     * \u83b7\u53d6actualSendEmail\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isActualSendEmail() {
        return actualSendEmail;
    }

    /**
     * \u8bbe\u7f6eactualSendEmail\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setActualSendEmail(Boolean value) {
        this.actualSendEmail = value;
    }

    /**
     * \u83b7\u53d6selected\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSelected() {
        return selected;
    }

    /**
     * \u8bbe\u7f6eselected\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSelected(Boolean value) {
        this.selected = value;
    }

    /**
     * \u83b7\u53d6selectTime\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSelectTime() {
        return selectTime;
    }

    /**
     * \u8bbe\u7f6eselectTime\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSelectTime(XMLGregorianCalendar value) {
        this.selectTime = value;
    }

    /**
     * \u83b7\u53d6selectUid\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSelectUid() {
        return selectUid;
    }

    /**
     * \u8bbe\u7f6eselectUid\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSelectUid(String value) {
        this.selectUid = value;
    }

    /**
     * \u83b7\u53d6createUid\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreateUid() {
        return createUid;
    }

    /**
     * \u8bbe\u7f6ecreateUid\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreateUid(String value) {
        this.createUid = value;
    }

    /**
     * \u83b7\u53d6updateUid\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpdateUid() {
        return updateUid;
    }

    /**
     * \u8bbe\u7f6eupdateUid\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpdateUid(String value) {
        this.updateUid = value;
    }

    /**
     * \u83b7\u53d6createTime\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreateTime() {
        return createTime;
    }

    /**
     * \u8bbe\u7f6ecreateTime\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreateTime(XMLGregorianCalendar value) {
        this.createTime = value;
    }

    /**
     * \u83b7\u53d6updateTime\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUpdateTime() {
        return updateTime;
    }

    /**
     * \u8bbe\u7f6eupdateTime\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUpdateTime(XMLGregorianCalendar value) {
        this.updateTime = value;
    }

    /**
     * \u83b7\u53d6smsResultTime\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSmsResultTime() {
        return smsResultTime;
    }

    /**
     * \u8bbe\u7f6esmsResultTime\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSmsResultTime(XMLGregorianCalendar value) {
        this.smsResultTime = value;
    }

    /**
     * \u83b7\u53d6smsId\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSmsId() {
        return smsId;
    }

    /**
     * \u8bbe\u7f6esmsId\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSmsId(String value) {
        this.smsId = value;
    }

    /**
     * \u83b7\u53d6emailResultTime\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEmailResultTime() {
        return emailResultTime;
    }

    /**
     * \u8bbe\u7f6eemailResultTime\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEmailResultTime(XMLGregorianCalendar value) {
        this.emailResultTime = value;
    }

    /**
     * \u83b7\u53d6dtsResultTime\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDtsResultTime() {
        return dtsResultTime;
    }

    /**
     * \u8bbe\u7f6edtsResultTime\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDtsResultTime(XMLGregorianCalendar value) {
        this.dtsResultTime = value;
    }

    /**
     * \u83b7\u53d6smsContent\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSmsContent() {
        return smsContent;
    }

    /**
     * \u8bbe\u7f6esmsContent\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSmsContent(String value) {
        this.smsContent = value;
    }

    /**
     * \u83b7\u53d6emailContent\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailContent() {
        return emailContent;
    }

    /**
     * \u8bbe\u7f6eemailContent\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailContent(String value) {
        this.emailContent = value;
    }

    /**
     * \u83b7\u53d6emailTitle\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailTitle() {
        return emailTitle;
    }

    /**
     * \u8bbe\u7f6eemailTitle\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailTitle(String value) {
        this.emailTitle = value;
    }

    /**
     * \u83b7\u53d6completeStatus\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCompleteStatus() {
        return completeStatus;
    }

    /**
     * \u8bbe\u7f6ecompleteStatus\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCompleteStatus(Boolean value) {
        this.completeStatus = value;
    }

    /**
     * \u83b7\u53d6smsResult\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link NotificationResult }
     *     
     */
    public NotificationResult getSmsResult() {
        return smsResult;
    }

    /**
     * \u8bbe\u7f6esmsResult\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link NotificationResult }
     *     
     */
    public void setSmsResult(NotificationResult value) {
        this.smsResult = value;
    }

    /**
     * \u83b7\u53d6emailResult\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link NotificationResult }
     *     
     */
    public NotificationResult getEmailResult() {
        return emailResult;
    }

    /**
     * \u8bbe\u7f6eemailResult\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link NotificationResult }
     *     
     */
    public void setEmailResult(NotificationResult value) {
        this.emailResult = value;
    }

    /**
     * \u83b7\u53d6dtsResult\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link NotificationResult }
     *     
     */
    public NotificationResult getDtsResult() {
        return dtsResult;
    }

    /**
     * \u8bbe\u7f6edtsResult\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link NotificationResult }
     *     
     */
    public void setDtsResult(NotificationResult value) {
        this.dtsResult = value;
    }

    /**
     * \u83b7\u53d6workflowStage\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @return
     *     possible object is
     *     {@link WorkflowStage }
     *     
     */
    public WorkflowStage getWorkflowStage() {
        return workflowStage;
    }

    /**
     * \u8bbe\u7f6eworkflowStage\u5c5e\u6027\u7684\u503c\u3002
     * 
     * @param value
     *     allowed object is
     *     {@link WorkflowStage }
     *     
     */
    public void setWorkflowStage(WorkflowStage value) {
        this.workflowStage = value;
    }

}
