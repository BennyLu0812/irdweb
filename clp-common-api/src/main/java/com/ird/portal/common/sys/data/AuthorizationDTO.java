package com.ird.portal.common.sys.data;

import com.ird.portal.data.BaseDTO;

import java.util.Date;



/**
 * TODO 請給AuthorizationDTO說明一下吧!
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 31/05/2018 15:26:13<br/>
 * @author James
 * @version 1.0
 */
public class AuthorizationDTO extends BaseDTO {

    /** Field說明 */
    private static final long serialVersionUID = 2029355210935865587L;
    
    /** 授權ID  */
    private Long authId;
    /** 授權用戶ID  */
    private String authUser;
    /** 授權時間  */
    private Date authTime;
    /** 授權項  */
    private String authItem;
    /** 申請編號   */
    private String spNo;
    /** 備註  */
    private String remark;
    /** 操作ID  */
    private Integer processId;
    /** 受權項具體值 */
    private String authItemKey;
    /** 駕照編號   */
    private String licNo;
    /** 駕照類別 SYS_CODE(CODE_TYPE=31021)  */
    private String licType;

    /** 用戶ID */
    private Long docId;
    
    public Long getAuthId() {
        return authId;
    }
    
    public void setAuthId(Long authId) {
        this.authId = authId;
    }
    
    public String getAuthUser() {
        return authUser;
    }
    
    public void setAuthUser(String authUser) {
        this.authUser = authUser;
    }
    
    public Date getAuthTime() {
        return authTime;
    }
    
    public void setAuthTime(Date authTime) {
        this.authTime = authTime;
    }
    
    public String getAuthItem() {
        return authItem;
    }
    
    public void setAuthItem(String authItem) {
        this.authItem = authItem;
    }
    
    public String getSpNo() {
        return spNo;
    }
    
    public void setSpNo(String spNo) {
        this.spNo = spNo;
    }
    
    public String getRemark() {
        return remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    public Integer getProcessId() {
        return processId;
    }
    
    public void setProcessId(Integer processId) {
        this.processId = processId;
    }
    
    public String getAuthItemKey() {
        return authItemKey;
    }
    
    public void setAuthItemKey(String authItemKey) {
        this.authItemKey = authItemKey;
    }
    
    public String getLicNo() {
        return licNo;
    }
    
    public void setLicNo(String licNo) {
        this.licNo = licNo;
    }
    
    public String getLicType() {
        return licType;
    }
    
    public void setLicType(String licType) {
        this.licType = licType;
    }

    public Long getDocId() {
        return docId;
    }

    public void setDocId(Long docId) {
        this.docId = docId;
    }

    @Override
    public String toString() {
        return "AuthorizationDTO [authId=" + authId + ", authUser=" + authUser + ", authTime=" + authTime
            + ", authItem=" + authItem + ", spNo=" + spNo + ", remark=" + remark + ", processId=" + processId
            + ", authItemKey=" + authItemKey + ", licNo=" + licNo + ", licType=" + licType +", docId=" + docId + "]";
    }
    
}
