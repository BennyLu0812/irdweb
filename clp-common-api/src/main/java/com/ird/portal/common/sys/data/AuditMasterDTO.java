package com.ird.portal.common.sys.data;

import com.ird.portal.data.BaseDTO;
import com.ird.portal.util.DateUtil;

import java.util.Date;
import java.util.List;



public class AuditMasterDTO extends BaseDTO {
    
    /**
     * 序列號
     */
    private static final long serialVersionUID = 295097231763310769L;

    private Long auditMasterId;

    private String sysFuncCode;

    private String sysOperatorId;

    private Date sysOperationTime;

    /**經辦時間開始*/
    private String sysOperationTimeStart;
    /**經辦時間結束*/
    private String sysOperationTimeEnd;

    private String hostName;

    private String hostIP;

    private String sysRemark;

    private Long docId;

    private Integer docSeq;

    private List<String> funcCodes;

    private String sysFuncDesc;

    private String sysOperationTimeDesc;



    public Long getAuditMasterId() {
        return auditMasterId;
    }

    public void setAuditMasterId(Long auditMasterId) {
        this.auditMasterId = auditMasterId;
    }

    public List<String> getFuncCodes() {
        return funcCodes;
    }
    
    public void setFuncCodes(List<String> funcCodes) {
        this.funcCodes = funcCodes;
    }
    
    public String getHostIP() {
        return hostIP;
    }
    
    public void setHostIP(String hostIP) {
        this.hostIP = hostIP;
    }

    

    public String getSysFuncCode() {
        return sysFuncCode;
    }
    
    public void setSysFuncCode(String sysFuncCode) {
        this.sysFuncCode = sysFuncCode;
    }
    
    public String getSysOperatorId() {
        return sysOperatorId;
    }
    
    public void setSysOperatorId(String sysOperatorId) {
        this.sysOperatorId = sysOperatorId;
    }
    
    public Date getSysOperationTime() {
        return sysOperationTime;
    }
    
    public void setSysOperationTime(Date sysOperationTime) {
        this.sysOperationTime = sysOperationTime;
    }
    
    public String getHostName() {
        return hostName;
    }
    
    public void setHostName(String hostName) {
        this.hostName = hostName;
    }
    
    public String getSysRemark() {
        return sysRemark;
    }
    
    public void setSysRemark(String sysRemark) {
        this.sysRemark = sysRemark;
    }
    
    public String getSysFuncDesc() {
        return sysFuncDesc;
    }
    
    public void setSysFuncDesc(String sysFuncDesc) {
        this.sysFuncDesc = sysFuncDesc;
    }

    public String getSysOperationTimeStart() {
        return sysOperationTimeStart;
    }

    public void setSysOperationTimeStart(String sysOperationTimeStart) {
        this.sysOperationTimeStart = sysOperationTimeStart;
    }

    public String getSysOperationTimeEnd() {
        return sysOperationTimeEnd;
    }

    public void setSysOperationTimeEnd(String sysOperationTimeEnd) {
        this.sysOperationTimeEnd = sysOperationTimeEnd;
    }

    public Long getDocId() {
        return docId;
    }

    public void setDocId(Long docId) {
        this.docId = docId;
    }

    public Integer getDocSeq() {
        return docSeq;
    }

    public void setDocSeq(Integer docSeq) {
        this.docSeq = docSeq;
    }

    public void setSysOperationTimeDesc(String sysOperationTimeDesc) {
        this.sysOperationTimeDesc = sysOperationTimeDesc;
    }


    public String getSysOperationTimeDesc() {
        if (sysOperationTime != null) {
            sysOperationTimeDesc = DateUtil.format(sysOperationTime, DateUtil.DATE_TIME_PATTERN);
        }
        return sysOperationTimeDesc;
    }



    @Override
    public String toString() {
        return "AuditMasterDTO{" +
                "auditMasterId=" + auditMasterId +
                ", sysFuncCode='" + sysFuncCode + '\'' +
                ", sysOperatorId='" + sysOperatorId + '\'' +
                ", sysOperationTime=" + sysOperationTime +
                ", sysOperationTimeStart='" + sysOperationTimeStart + '\'' +
                ", sysOperationTimeEnd='" + sysOperationTimeEnd + '\'' +
                ", hostName='" + hostName + '\'' +
                ", hostIP='" + hostIP + '\'' +
                ", sysRemark='" + sysRemark + '\'' +
                ", docId=" + docId +
                ", docSeq=" + docSeq +
                ", funcCodes=" + funcCodes +
                ", sysFuncDesc='" + sysFuncDesc + '\'' +
                ", sysOperationTimeDesc='" + sysOperationTimeDesc + '\'' +

                '}';
    }
}
