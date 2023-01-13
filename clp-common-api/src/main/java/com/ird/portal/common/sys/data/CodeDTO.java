package com.ird.portal.common.sys.data;

import com.ird.portal.data.BaseDTO;

/**
 * 
 * 系統代碼的DTO.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 16/11/2017 09:56:48<br/>
 * 
 * @author Deft
 * @version 1.0
 */
public class CodeDTO extends BaseDTO {
    
    private static final long serialVersionUID = -5437821019211623204L;
    
    private Integer codeId;
    
    private Integer codeType;
    
    private String codeKey;
    
    private String codePname;
    
    private String codeCname;
    
    private String codeStatus;
    
    private String codePrintPname;
    
    private String codePrintCname;
    
    private Integer codeOrder;
    
    private String codeDesc;
    
    
   
    
    public void setCodeDesc(String codeDesc) {
        this.codeDesc = codeDesc;
    }

    public Integer getCodeId() {
        return codeId;
    }
    
    public void setCodeId(Integer codeId) {
        this.codeId = codeId;
    }
    
    public Integer getCodeType() {
        return codeType;
    }
    
    public void setCodeType(Integer codeType) {
        this.codeType = codeType;
    }
    
    public String getCodeKey() {
        return codeKey;
    }
    
    public void setCodeKey(String codeKey) {
        this.codeKey = codeKey;
    }
    
    public String getCodePname() {
        return codePname;
    }
    
    public void setCodePname(String codePname) {
        this.codePname = codePname;
    }
    
    public String getCodeCname() {
        return codeCname;
    }
    
    public void setCodeCname(String codeCname) {
        this.codeCname = codeCname;
    }
    
    public String getCodeStatus() {
        return codeStatus;
    }
    
    public void setCodeStatus(String codeStatus) {
        this.codeStatus = codeStatus;
    }
    
    /**
     * @return the codePrintPname
     */
    public String getCodePrintPname() {
        return codePrintPname;
    }
    
    public void setCodePrintPname(String codePrintPname) {
        this.codePrintPname = codePrintPname;
    }
    
    public String getCodePrintCname() {
        return codePrintCname;
    }
    
    public void setCodePrintCname(String codePrintCname) {
        this.codePrintCname = codePrintCname;
    }
    
    public Integer getCodeOrder() {
        return codeOrder;
    }
    
    public void setCodeOrder(Integer codeOrder) {
        this.codeOrder = codeOrder;
    }
    
    public String getCodeDesc() {
    	codeDesc = codeKey + " - " + codePname + " - " + codeCname;
		return codeDesc;
	}

	@Override
    public String toString() {
        return "CodeDTO [codeId=" + codeId + ", codeType=" + codeType + ", codeKey=" + codeKey + ", codePname="
            + codePname + ", codeCname=" + codeCname + ", codeStatus=" + codeStatus + ", codePrintPname="
            + codePrintPname + ", codePrintCname=" + codePrintCname + ", codeOrder=" + codeOrder + "]";
    }

}
