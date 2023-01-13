package com.ird.portal.common.sys.data;

import com.ird.portal.data.BaseDTO;

import java.util.List;


public class SysServiceDTO extends BaseDTO {
    
    private static final long serialVersionUID = 1802217882105676941L;
    
    // "SERVICE_ID" NUMBER(10,0) NOT NULL ENABLE,
    // "SERVICE_CODE" VARCHAR2(10 CHAR) NOT NULL ENABLE,
    // "SERVICE_CNAME" VARCHAR2(50 CHAR) NOT NULL ENABLE,
    // "SERVICE_PNAME" VARCHAR2(50 CHAR) NOT NULL ENABLE,
    // "SERVICE_DETAIL" VARCHAR2(200 CHAR),
    // "SERVICE_STATUS" CHAR(1 CHAR) NOT NULL ENABLE,
    // "IS_ENQ" CHAR(1 CHAR),
    // "LAST_UPD_USER" VARCHAR2(20 CHAR),
    // "LAST_UPD_DATE" TIMESTAMP (6),
    // "CREATE_USER" VARCHAR2(20 CHAR),
    // "CREATE_DATE" TIMESTAMP (6),

    private String userId;
    private List<String> operationCodes;

    
    public String getUserId() {
        return userId;
    }

    
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getOperationCodes() {
        return operationCodes;
    }
    
    public void setOperationCodes(List<String> operationCodes) {
        this.operationCodes = operationCodes;
    }
    
    
    
}
