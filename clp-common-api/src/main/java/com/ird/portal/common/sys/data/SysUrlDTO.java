package com.ird.portal.common.sys.data;


import com.ird.portal.data.BaseDTO;

public class SysUrlDTO extends BaseDTO {
    
    private static final long serialVersionUID = 7738815813478904090L;
    
    private Long urlId;
    
    private Long stageId;
    
    private Long processId;
    
    private String urlLink;
    
    private String urlTag;
    
    private Long nextUrlId;
    
    private String formattedUrlLink;
    
    private String nextUrlLink;
    
    private String nextFormattedUrlLink;
    
    private String processCode;
    
    public Long getUrlId() {
        return urlId;
    }
    
    public void setUrlId(Long urlId) {
        this.urlId = urlId;
    }
    
    public Long getStageId() {
        return stageId;
    }
    
    public void setStageId(Long stageId) {
        this.stageId = stageId;
    }
    
    public Long getProcessId() {
        return processId;
    }
    
    public void setProcessId(Long processId) {
        this.processId = processId;
    }
    
    public String getUrlLink() {
        return urlLink;
    }
    
    public void setUrlLink(String urlLink) {
        this.urlLink = urlLink;
    }
    
    public String getUrlTag() {
        return urlTag;
    }
    
    public void setUrlTag(String urlTag) {
        this.urlTag = urlTag;
    }
    
    public Long getNextUrlId() {
        return nextUrlId;
    }
    
    public void setNextUrlId(Long nextUrlId) {
        this.nextUrlId = nextUrlId;
    }
    
    public String getFormattedUrlLink() {
        return formattedUrlLink;
    }
    
    public void setFormattedUrlLink(String formattedUrlLink) {
        this.formattedUrlLink = formattedUrlLink;
    }
    
    public String getNextUrlLink() {
        return nextUrlLink;
    }
    
    public void setNextUrlLink(String nextUrlLink) {
        this.nextUrlLink = nextUrlLink;
    }
    
    public String getNextFormattedUrlLink() {
        return nextFormattedUrlLink;
    }
    
    public void setNextFormattedUrlLink(String nextFormattedUrlLink) {
        this.nextFormattedUrlLink = nextFormattedUrlLink;
    }
    
    public String getProcessCode() {
        return processCode;
    }
    
    public void setProcessCode(String processCode) {
        this.processCode = processCode;
    }
    
}
