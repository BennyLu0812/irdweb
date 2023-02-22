package com.ird.portal.common.api.data;

import com.ird.portal.data.BaseDTO;
import org.apache.commons.lang3.StringUtils;
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


    public String getRequestInputParams() {
        StringBuffer requestInputParams = new StringBuffer();
        requestInputParams.append("{");
        requestInputParams.append(" dataCentreId:\""+ this.dataCentreId);

        if (StringUtils.isNotBlank(this.blackoutWindowBegin)) {
            requestInputParams.append("\", blackoutWindowBegin:\"" + this.blackoutWindowBegin);
        }
        if (StringUtils.isNotBlank(this.blackoutWindowEnd)) {
            requestInputParams.append("\", blackoutWindowEnd: \"" + this.blackoutWindowEnd);
        }
        if (StringUtils.isNotBlank(this.description)) {
            requestInputParams.append("\", description: \"" + this.description);
        }
        if (StringUtils.isNotBlank(this.timeStampSent)) {
            requestInputParams.append("\", timeStampSent: \"" + this.timeStampSent);
        }
        if (StringUtils.isNotBlank(this.eventUid)) {
            requestInputParams.append("\", eventUid:\"" + this.eventUid);
        }
        if (StringUtils.isNotBlank(this.cancleReason)) {
            requestInputParams.append("\", cancleReason:\"" + this.cancleReason);
        }
        if (StringUtils.isNotBlank(this.severity)) {
            requestInputParams.append("\", severity:\"" + this.severity);
        }
        if (StringUtils.isNotBlank(this.failure)) {
            requestInputParams.append("\", failure:\"" + this.failure);
        }
        if (StringUtils.isNotBlank(this.servicesAffected)) {
            requestInputParams.append("\", servicesAffected:\"" + this.servicesAffected);
        }
        if (StringUtils.isNotBlank(this.timeStampEvent)) {
            requestInputParams.append("\", timeStampEvent:\"" + this.timeStampEvent);
        }
        if (StringUtils.isNotBlank(this.eventType)) {
            requestInputParams.append("\", eventType:\"" + this.eventType);
        }
        if (StringUtils.isNotBlank(this.securityAlertId)) {
            requestInputParams.append("\", securityAlertId:\"" + this.securityAlertId);
        }
        if (StringUtils.isNotBlank(this.x509CertFile)) {
            requestInputParams.append("\", x509CertFile:\"" + this.x509CertFile);
        }
        if (StringUtils.isNotBlank(this.createDateFrom)) {
            requestInputParams.append("\", createDateFrom:\"" + this.createDateFrom);
        }
        if (StringUtils.isNotBlank(this.createDateTo)) {
            requestInputParams.append("\", createDateTo:\"" + this.createDateTo);
        }
        if (StringUtils.isNotBlank(this.fileName)) {
            requestInputParams.append("\", fileName:\"" + this.fileName);
        }
        if (StringUtils.isNotBlank(this.filePath)) {
            requestInputParams.append("\", filePath:\"" + this.filePath);
        }
        requestInputParams.append("\"}");
        return requestInputParams.toString();
    }









}
