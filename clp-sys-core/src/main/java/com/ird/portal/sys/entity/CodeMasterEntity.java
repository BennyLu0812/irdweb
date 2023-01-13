package com.ird.portal.sys.entity;

import com.ird.portal.audit.annotation.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Audited
@Entity
@Table(name = "CLP_SYS_CODE_MASTER")
public class CodeMasterEntity implements Serializable {
    /** 序列化版本號 */
    private static final long serialVersionUID = 5182322469041757864L;
    
    /**
     * 參數分類編號
     */
    private Integer codeMasterType;
    /**
     * 分類中文描述
     */
    private String codeMasterCname;
    /**
     * 分類葡文描述
     */
    private String codeMasterPname;
    
    @Id
    @Column(name = "CODE_TYPE", columnDefinition = "NUMBER(5,0)")
    public Integer getCodeMasterType() {
        return codeMasterType;
    }



    public void setCodeMasterType(Integer codeMasterType) {
        this.codeMasterType = codeMasterType;
    }



    @Column(name = "CODE_CNAME", columnDefinition = "VARCHAR2(100 CHAR)")
    public String getCodeMasterCname() {
        return codeMasterCname;
    }



    
    public void setCodeMasterCname(String codeMasterCname) {
        this.codeMasterCname = codeMasterCname;
    }



    @Column(name = "CODE_PNAME", columnDefinition = "VARCHAR2(100 CHAR)")
    public String getCodeMasterPname() {
        return codeMasterPname;
    }



    
    public void setCodeMasterPname(String codeMasterPname) {
        this.codeMasterPname = codeMasterPname;
    }



    @Override
    public String toString() {
        return "CodeMasterEntity [codeMasterType=" + codeMasterType + ", codeMasterCname=" + codeMasterCname
            + ", codeMasterPname=" + codeMasterPname + "]";
    }
    
    
    
}
