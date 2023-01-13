package com.ird.portal.common.sys.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ird.portal.data.BaseDTO;
import com.ird.portal.util.DateUtil;

import java.util.Date;
import java.util.List;


public class AuditIndexDTO extends BaseDTO {
    
    /** Field說明 */
    private static final long serialVersionUID = -3587683531840303485L;
    
    private Long auditIndexId;
    
    private String sysFuncCode;
    
    private String sysOperatorId;
    
    private Date sysOperationTime;
    

    private Date sysOperationTimeStart;

    private Date sysOperationTimeEnd;
    
    private String hostName;
    
    private String hostIP;
    
    private String sysRemark;

    
    private List<String> funcCodes;
    
    private String sysFuncDesc;
    
    private String sysOperationTimeDesc;


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
    
    public Long getAuditIndexId() {
        return auditIndexId;
    }
    
    public void setAuditIndexId(Long id) {
        this.auditIndexId = id;
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
    
    public String getSysOperationTimeDesc() {
        if (sysOperationTime != null) {
            sysOperationTimeDesc = DateUtil.format(sysOperationTime, DateUtil.DATE_TIME_PATTERN);
        }
        return sysOperationTimeDesc;
    }




    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss",timezone="GMT+8")
    public Date getSysOperationTimeStart() {
        return sysOperationTimeStart;
    }
    
    public void setSysOperationTimeStart(Date sysOperationTimeStart) {
        this.sysOperationTimeStart = sysOperationTimeStart;
    }
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss",timezone="GMT+8")
    public Date getSysOperationTimeEnd() {
        if (sysOperationTimeEnd ==null) {
            sysOperationTimeEnd = new Date();
        }
        return sysOperationTimeEnd;
    }
    
    public void setSysOperationTimeEnd(Date sysOperationTimeEnd) {
        this.sysOperationTimeEnd = sysOperationTimeEnd;
    }

    @Override
    public String toString() {
        return "AuditIndexDTO{" +
                "auditIndexId=" + auditIndexId +
                ", sysFuncCode='" + sysFuncCode + '\'' +
                ", sysOperatorId='" + sysOperatorId + '\'' +
                ", sysOperationTime=" + sysOperationTime +
                ", sysOperationTimeStart=" + sysOperationTimeStart +
                ", sysOperationTimeEnd=" + sysOperationTimeEnd +
                ", hostName='" + hostName + '\'' +
                ", hostIP='" + hostIP + '\'' +
                ", sysRemark='" + sysRemark + '\'' +
                '}';
    }
}
