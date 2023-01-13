package com.ird.portal.sys.entity;

import com.ird.portal.audit.annotation.Audited;
import com.ird.portal.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * 系統參數實體.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 16/11/2017 10:05:50<br/>
 * 
 * @author Deft
 * @version 1.0
 */
@Audited
@Entity
@Table(name = "CLP_SYS_PARAMS")
public class ParamsEntity extends AbstractEntity {
    
    private static final long serialVersionUID = 1534105377799359294L;
    
    private String paramName;
    
    private String paramDesc;
    
    private String paramStatus;
    
    private String paramValue;
    
    @Id
    @Column(name = "PARAM_NAME", columnDefinition = "VARCHAR2(50 CHAR)")
    public String getParamName() {
        return paramName;
    }
    
    public void setParamName(String paramName) {
        this.paramName = paramName;
    }
    
    @Column(name = "PARAM_DESC", columnDefinition = "VARCHAR2(100 CHAR)", nullable = false)
    public String getParamDesc() {
        return paramDesc;
    }
    
    public void setParamDesc(String paramDesc) {
        this.paramDesc = paramDesc;
    }
    
    @Column(name = "PARAM_STATUS", columnDefinition = "CHAR(1 CHAR)", nullable = false)
    public String getParamStatus() {
        return paramStatus;
    }
    
    public void setParamStatus(String paramStatus) {
        this.paramStatus = paramStatus;
    }
    
    @Column(name = "PARAM_VALUE", columnDefinition = "VARCHAR2(200 CHAR)", nullable = false)
    public String getParamValue() {
        return paramValue;
    }
    
    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    @Override
    public String toString() {
        return "ParamsEntity [paramName=" + paramName + ", paramDesc=" + paramDesc + ", paramStatus=" + paramStatus
            + ", paramValue=" + paramValue + "]";
    }

}
