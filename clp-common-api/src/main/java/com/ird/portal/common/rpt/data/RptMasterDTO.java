package com.ird.portal.common.rpt.data;


import com.ird.portal.common.sys.enums.SysCodeStatus;
import com.ird.portal.data.BaseDTO;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * 
 * 報表記錄的DTO
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 23/06/2018 16:06:23<br/>
 * @author: Crystal Zhao
 * @version 1.0
 */
public class RptMasterDTO extends BaseDTO {
    /** Field說明 */
    private static final long serialVersionUID = 3229728857968903881L;
    /** 報表ID */
    private String id;
    /** 報表中文名 */
    private String cname;
    /** 報表葡文名 */
    private String pname;
    /** 報表狀態 (A=有效; C=失效) */
    private String status;
    /**報表狀態説明*/
    private String statusDesc;
    /** 報表URL */
    private String url;
    /** 報表描述中文 */
    private String descCn;
    /** 報表描述葡文 */
    private String descPt;
    /** 報表類型(R=報表; P=制件)*/
    private String rptType;
    /** 報表所需權限 （以","隔開）*/
    private String rptPreviledge;
                    
    private String funcCode;
    private String funcDesc;
    private String moduleName;
    
    private List<String> rptPreviledgeList;
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        this.statusDesc = SysCodeStatus.getTextByCode(status, null);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescCn() {
        return descCn;
    }

    public void setDescCn(String descCn) {
        this.descCn = descCn;
    }

    public String getDescPt() {
        return descPt;
    }

    public void setDescPt(String descPt) {
        this.descPt = descPt;
    }

    /**
     * @return the rptType
     */
    public String getRptType() {
        return rptType;
    }

    /**
     * @param rptType the rptType to set
     */
    public void setRptType(String rptType) {
        this.rptType = rptType;
    }

    /**
     * @return the rptPreviledge
     */
    public String getRptPreviledge() {
        return rptPreviledge;
    }

    /**
     * @param rptPreviledge the rptPreviledge to set
     */
    public void setRptPreviledge(String rptPreviledge) {
        this.rptPreviledge = rptPreviledge;
    }

    /**
     * @return the funcCode
     */
    public String getFuncCode() {
        return funcCode;
    }

    /**
     * @param funcCode the funcCode to set
     */
    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode;
    }

    /**
     * @return the funcDesc
     */
    public String getFuncDesc() {
        return funcDesc;
    }

    /**
     * @param funcDesc the funcDesc to set
     */
    public void setFuncDesc(String funcDesc) {
        this.funcDesc = funcDesc;
    }

    /**
     * @return the moduleName
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * @param moduleName the moduleName to set
     */
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    /**
     * @return the rptPreviledgeList
     */
    public List<String> getRptPreviledgeList() {
        return rptPreviledgeList;
    }

    /**
     * @param rptPreviledgeList the rptPreviledgeList to set
     */
    public void setRptPreviledgeList(List<String> rptPreviledgeList) {
        this.rptPreviledgeList = rptPreviledgeList;
    }
    
    public String getStatusDesc() {
        if (StringUtils.isNotBlank(status)) {
            statusDesc = SysCodeStatus.getTextByCode(status, null);
        }
        return statusDesc;
    }
    
    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    @Override
    public String toString() {
        return "RptMasterDTO [id=" + id + ", cname=" + cname + ", pname=" + pname + ", status=" + status + ", url=" + url + ", descCn=" + descCn + ", descPt=" + descPt + ", rptType=" + rptType + ", rptPreviledge="
                + rptPreviledge + ", funcCode=" + funcCode + ", funcDesc=" + funcDesc + ", moduleName=" + moduleName + ", rptPreviledgeList=" + rptPreviledgeList + "]";
    }

}
