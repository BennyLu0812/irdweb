package com.ird.portal.common.api.data;

/**
 * @author Benny
 * @description: Response DTO
 * @date 2023/1/30
 */
public class APIResponseDTO {


    private String code;
    private String message;
    private String eventUid;
    private String eventReference;
    private String thumbprint;
    private String validFrom;
    private String validTo;
    private String subject;

    public String getEventUid() {
        return eventUid;
    }

    public void setEventUid(String eventUid) {
        this.eventUid = eventUid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEventReference() {
        return eventReference;
    }

    public void setEventReference(String eventReference) {
        this.eventReference = eventReference;
    }

    public String getThumbprint() {
        return thumbprint;
    }

    public void setThumbprint(String thumbprint) {
        this.thumbprint = thumbprint;
    }

    public String getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(String validFrom) {
        this.validFrom = validFrom;
    }

    public String getValidTo() {
        return validTo;
    }

    public void setValidTo(String validTo) {
        this.validTo = validTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
