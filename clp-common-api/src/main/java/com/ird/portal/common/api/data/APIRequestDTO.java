package com.ird.portal.common.api.data;

import com.ird.portal.data.BaseDTO;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * @author Benny
 * @description: Request DTO
 * @date 2023/1/30
 */
public class APIRequestDTO extends BaseDTO {

    private static final long serialVersionUID = 3792168222169505545L;

    private String dataCentreId;
    private String blackoutWindowBegin;
    private String blackoutWindowEnd;
    private String description;
    private String timeStampSent;
    private String eventUid;
    private String cancleReason;
    private String severity;
    private String failure;
    private String servicesAffected;
    private String timeStampEvent;
    private String eventType;
    private String securityAlertId;
    private String x509CertFile;
    private String apiName;
    private String createDateFrom;
    private String createDateTo;
    private String fileName;
    private String filePath;

    public String getDataCentreId() {
        return dataCentreId;
    }

    public void setDataCentreId(String dataCentreId) {
        this.dataCentreId = dataCentreId;
    }

    public String getBlackoutWindowBegin() {
        return blackoutWindowBegin;
    }

    public void setBlackoutWindowBegin(String blackoutWindowBegin) {
        this.blackoutWindowBegin = blackoutWindowBegin;
    }

    public String getBlackoutWindowEnd() {
        return blackoutWindowEnd;
    }

    public void setBlackoutWindowEnd(String blackoutWindowEnd) {
        this.blackoutWindowEnd = blackoutWindowEnd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTimeStampSent() {
        return timeStampSent;
    }

    public void setTimeStampSent(String timeStampSent) {
        this.timeStampSent = timeStampSent;
    }

    public String getEventUid() {
        return eventUid;
    }

    public void setEventUid(String eventUid) {
        this.eventUid = eventUid;
    }

    public String getCancleReason() {
        return cancleReason;
    }

    public void setCancleReason(String cancleReason) {
        this.cancleReason = cancleReason;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getFailure() {
        return failure;
    }

    public void setFailure(String failure) {
        this.failure = failure;
    }

    public String getServicesAffected() {
        return servicesAffected;
    }

    public void setServicesAffected(String servicesAffected) {
        this.servicesAffected = servicesAffected;
    }

    public String getTimeStampEvent() {
        return timeStampEvent;
    }

    public void setTimeStampEvent(String timeStampEvent) {
        this.timeStampEvent = timeStampEvent;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getSecurityAlertId() {
        return securityAlertId;
    }

    public void setSecurityAlertId(String securityAlertId) {
        this.securityAlertId = securityAlertId;
    }

    public String getX509CertFile() {
        return x509CertFile;
    }

    public void setX509CertFile(String x509CertFile) {
        this.x509CertFile = x509CertFile;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getCreateDateFrom() {
        return createDateFrom;
    }

    public void setCreateDateFrom(String createDateFrom) {
        this.createDateFrom = createDateFrom;
    }

    public String getCreateDateTo() {
        return createDateTo;
    }

    public void setCreateDateTo(String createDateTo) {
        this.createDateTo = createDateTo;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this);
    }


    public String getAlertBlackoutAPICreateRequestInputParams() {
        return "{" +
                "dataCentreId=" + dataCentreId +
                ", blackoutWindowBegin=" + blackoutWindowBegin +
                ", blackoutWindowEnd=" + blackoutWindowEnd +
                ", description=" + description +
                ", timeStampSent=" + timeStampSent +
                '}';
    }

    public String getAlertBlackoutAPIUpdateRequestInputParams() {
        return "{" +
                "dataCentreId=" + dataCentreId +
                ", blackoutWindowBegin=" + blackoutWindowBegin +
                ", blackoutWindowEnd=" + blackoutWindowEnd +
                ", description=" + description +
                ", timeStampSent=" + timeStampSent +
                ", eventUid=" + eventUid +
                '}';
    }

    public String getAlertBlackoutAPIQueryRequestInputParams() {
        return "{" +
                "dataCentreId=" + dataCentreId +
                ", timeStampSent=" + timeStampSent +
                '}';
    }

    public String getAlertBlackoutRequestOutputInputParams() {
        return "{" +
                "dataCentreId=" + dataCentreId +
                ", eventUid=" + eventUid +
                ", blackoutWindowBegin=" + blackoutWindowBegin +
                ", blackoutWindowEnd=" + blackoutWindowEnd +
                ", description=" + description +
                ", timeStampSent=" + timeStampSent +
                '}';
    }

    public String getAlertBlackoutAPICancelRequestInputParams() {
        return "{" +
                "dataCentreId=" + dataCentreId +
                ", blackoutWindowBegin=" + blackoutWindowBegin +
                ", blackoutWindowEnd=" + blackoutWindowEnd +
                ", timeStampSent=" + timeStampSent +
                ", cancleReason=" + cancleReason +
                ", eventUid=" + eventUid +
                '}';
    }

    public String getServiceFailureEventAPIRequestInputParams() {
        return "{" +
                "dataCentreId=" + dataCentreId +
                ", severity=" + severity +
                ", failure=" + failure +
                ", servicesAffected=" + servicesAffected +
                ", timeStampSent=" + timeStampSent +
                ", timeStampEvent=" + timeStampEvent +
                '}';
    }

    public String getSecurityEventAPIRequestInputParams() {
        return "{" +
                "dataCentreId=" + dataCentreId +
                ", eventType=" + eventType +
                ", severity=" + severity +
                ", securityAlertId=" + securityAlertId +
                ", servicesAffected=" + servicesAffected +
                ", timeStampSent=" + timeStampSent +
                ", timeStampEvent=" + timeStampEvent +
                '}';
    }




    public String getRrenewCertInputParams() {
        return "{" +
                "dataCentreId=" + dataCentreId +
                ", x509CertFile=" + x509CertFile +
                ", timeStampSent=" + timeStampSent +
                '}';
    }

    public String getHeartBeatAPIRequestInputParams() {
        return "{" +
                "dataCentreId=" + dataCentreId +
                ", timeStampSent=" + timeStampSent +
                '}';
    }

}
