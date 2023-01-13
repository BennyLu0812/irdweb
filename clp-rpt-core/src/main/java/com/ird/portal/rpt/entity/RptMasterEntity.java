package com.ird.portal.rpt.entity;

import com.ird.portal.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * 所有報表的實體類，用於記錄每份報表的名字和對應URL等
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 04/01/2018 11:46:07<br/>
 * 
 * @author Deft
 * @version 1.0
 */
@Entity
@Table(name = "CLP_RPT_MASTER")
public class RptMasterEntity extends AbstractEntity {
    
    private static final long serialVersionUID = 919407181549013165L;
    
    /** 報表ID */
    private String id;
    
    /** 報表中文名 */
    private String cname;
    
    /** 報表葡文名 */
    private String pname;
    
    /** 報表狀態 (A=有效; C=失效) */
    private String status;
    
    /** 報表URL */
    private String url;
    
    /** 報表描述中文 */
    private String descCn;
    
    /** 報表描述葡文 */
    private String descPt;
    
    /** 報表類型(R=報表; P=制件) */
    private String rptType;
    
    /** 報表所需權限 （以","隔開） */
    private String rptPreviledge;
    
    /** 報表模板路徑 **/
    private String rptTemplate;
    
    @Id
    @Column(name = "RPT_ID", columnDefinition = "VARCHAR2(20 CHAR)")
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    @Column(name = "RPT_CNAME", columnDefinition = "VARCHAR2(50 CHAR)")
    public String getCname() {
        return cname;
    }
    
    public void setCname(String cname) {
        this.cname = cname;
    }
    
    @Column(name = "RPT_PNAME", columnDefinition = "VARCHAR2(50 CHAR)")
    public String getPname() {
        return pname;
    }
    
    public void setPname(String pname) {
        this.pname = pname;
    }
    
    @Column(name = "RPT_STATUS", columnDefinition = "CHAR(1 CHAR)")
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    @Column(name = "RPT_URL", columnDefinition = "VARCHAR2(500 CHAR)")
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    @Column(name = "RPT_DESC_CN", columnDefinition = "VARCHAR2(200 CHAR)")
    public String getDescCn() {
        return descCn;
    }
    
    public void setDescCn(String descCn) {
        this.descCn = descCn;
    }
    
    @Column(name = "RPT_DESC_PT", columnDefinition = "VARCHAR2(200 CHAR)")
    public String getDescPt() {
        return descPt;
    }
    
    public void setDescPt(String descPt) {
        this.descPt = descPt;
    }
    
    @Column(name = "RPT_TYPE", columnDefinition = "CHAR(1 CHAR)")
    public String getRptType() {
        return rptType;
    }
    
    public void setRptType(String rptType) {
        this.rptType = rptType;
    }
    
    @Column(name = "RPT_PREVILEDGE", columnDefinition = "VARCHAR2(500 CHAR)")
    public String getRptPreviledge() {
        return rptPreviledge;
    }
    
    public void setRptPreviledge(String rptPreviledge) {
        this.rptPreviledge = rptPreviledge;
    }

    
    @Column(name = "RPT_TEMPLATE", columnDefinition = "VARCHAR2(200 CHAR)")
    public String getRptTemplate() {
        return rptTemplate;
    }
    
    public void setRptTemplate(String rptTemplate) {
        this.rptTemplate = rptTemplate;
    }

    @Override
    public String toString() {
        return "RptMasterEntity [id=" + id + ", cname=" + cname + ", pname=" + pname + ", status=" + status + ", url=" + url + ", descCn=" + descCn + ", descPt=" + descPt + ", rptType=" + rptType + ", rptPreviledge="
                + rptPreviledge + ", rptTemplate=" + rptTemplate + "]";
    }
    
    
}
