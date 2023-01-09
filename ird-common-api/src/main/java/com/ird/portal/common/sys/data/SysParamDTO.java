package com.ird.portal.common.sys.data;


import com.ird.portal.data.BaseDTO;

/**
 * 
 * 系統參數DTO.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 16/11/2017 09:58:05<br/>
 * 
 * @author Deft
 * @version 1.0
 */
public class SysParamDTO extends BaseDTO {
    
    private static final long serialVersionUID = 8865284305650369380L;
    
    private String paramName;
    
    private String paramDesc;
    
    private String paramStatus;
    
    private String paramValue;

    private String redisParamValue;

    private String keyword;

    public String getParamName() {
        return paramName;
    }
    
    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamDesc() {
        return paramDesc;
    }
    
    public void setParamDesc(String paramDesc) {
        this.paramDesc = paramDesc;
    }

    public String getParamStatus() {
        return paramStatus;
    }
    
    public void setParamStatus(String paramStatus) {
        this.paramStatus = paramStatus;
    }

    public String getParamValue() {
        return paramValue;
    }
    
    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }
    
    public String getKeyword() {
        return keyword;
    }
    
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getRedisParamValue() {
        return redisParamValue;
    }

    public void setRedisParamValue(String redisParamValue) {
        this.redisParamValue = redisParamValue;
    }

    @Override public String toString() {
        return "SysParamDTO{" + "paramName='" + paramName + '\'' + ", paramDesc='" + paramDesc + '\''
            + ", paramStatus='" + paramStatus + '\'' + ", paramValue='" + paramValue + '\'' + ", redisParamValue='"
            + redisParamValue + '\'' + ", keyword='" + keyword + '\'' + '}';
    }
}
