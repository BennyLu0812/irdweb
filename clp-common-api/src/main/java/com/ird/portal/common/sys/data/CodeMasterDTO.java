package com.ird.portal.common.sys.data;

import com.ird.portal.data.BaseDTO;

/**
 * 
 * 系統代碼Master對應的 DTO
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 03/05/2018 15:37:11<br/>
 * @author Ada Yu
 * @version 1.0
 */
public class CodeMasterDTO extends BaseDTO {
    
    /** 序列號 */
    private static final long serialVersionUID = 8791567497499914059L;

    private Integer codeMasterType;
    
    private String codeMasterCname;
    
    private String codeMasterPname;

    
    public Integer getCodeMasterType() {
        return codeMasterType;
    }

    
    public void setCodeMasterType(Integer codeMasterType) {
        this.codeMasterType = codeMasterType;
    }

    
    public String getCodeMasterCname() {
        return codeMasterCname;
    }

    
    public void setCodeMasterCname(String codeMasterCname) {
        this.codeMasterCname = codeMasterCname;
    }

    
    public String getCodeMasterPname() {
        return codeMasterPname;
    }

    
    public void setCodeMasterPname(String codeMasterPname) {
        this.codeMasterPname = codeMasterPname;
    }


    @Override
    public String toString() {
        return "CodeMasterDTO [codeMasterType=" + codeMasterType + ", codeMasterCname=" + codeMasterCname
            + ", codeMasterPname=" + codeMasterPname + "]";
    }

    
}
