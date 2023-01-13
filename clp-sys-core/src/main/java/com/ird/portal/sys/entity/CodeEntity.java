package com.ird.portal.sys.entity;

import com.ird.portal.audit.annotation.Audited;
import com.ird.portal.entity.AbstractEntity;

import javax.persistence.*;

@Audited
@Entity
@Table(name = "CLP_SYS_CODE")
public class CodeEntity extends AbstractEntity {
    
    private static final long serialVersionUID = -6514876247706355748L;
    /**
     * 參數ID 
     */
    private Integer codeId;
    /**
     * 代碼分類編號
     */
    private Integer codeType;
    /**
     * 代碼分類內的編號
     */
    private String codeKey;
    /**
     * 代碼葡文內容 
     */
    private String codePname;
    /**
     * 代碼中文內容 
     */
    private String codeCname;
    /**
     * 狀態: A=ACTIVE,C=CANCEL
     */
    private String codeStatus;
    /**
     * 代碼葡文印刷名
     */
    private String codePrintPname;
    /**
     * 代碼中文印刷名
     */
    private String codePrintCname;
    /**
     * 排序號, 用於在同一類參數里排序 
     */
    private Integer codeOrder;

    @Id
    @Column(name = "CODE_ID", columnDefinition = "NUMBER(10,0)")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getCodeId() {
        return codeId;
    }
    
    public void setCodeId(Integer codeId) {
        this.codeId = codeId;
    }
    
    @Column(name = "CODE_TYPE", columnDefinition = "NUMBER(5,0)")
    public Integer getCodeType() {
        return codeType;
    }
    
    public void setCodeType(Integer codeType) {
        this.codeType = codeType;
    }
    
    @Column(name = "CODE_KEY", columnDefinition = "VARCHAR2(6 CHAR)")
    public String getCodeKey() {
        return codeKey;
    }
    
    public void setCodeKey(String codeKey) {
        this.codeKey = codeKey;
    }
    
    @Column(name = "CODE_PNAME", columnDefinition = "VARCHAR2(100 CHAR)")
    public String getCodePname() {
        return codePname;
    }
    
    public void setCodePname(String codePname) {
        this.codePname = codePname;
    }
    
    @Column(name = "CODE_CNAME", columnDefinition = "VARCHAR2(100 CHAR)")
    public String getCodeCname() {
        return codeCname;
    }
    
    public void setCodeCname(String codeCname) {
        this.codeCname = codeCname;
    }
    
    @Column(name = "CODE_STATUS", columnDefinition = "CHAR(1 CHAR)", nullable = false)
    public String getCodeStatus() {
        return codeStatus;
    }
    
    public void setCodeStatus(String codeStatus) {
        this.codeStatus = codeStatus;
    }
    
    @Column(name = "CODE_PRINT_PNAME", columnDefinition = "VARCHAR2(100 CHAR)")
    public String getCodePrintPname() {
        return codePrintPname;
    }
    
    public void setCodePrintPname(String codePrintPname) {
        this.codePrintPname = codePrintPname;
    }
    
    @Column(name = "CODE_PRINT_CNAME", columnDefinition = "VARCHAR2(100 CHAR)")
    public String getCodePrintCname() {
        return codePrintCname;
    }
    
    public void setCodePrintCname(String codePrintCname) {
        this.codePrintCname = codePrintCname;
    }
    
    @Column(name = "CODE_ORDER", columnDefinition = "NUMBER(5,0)")
    public Integer getCodeOrder() {
        return codeOrder;
    }
    
    public void setCodeOrder(Integer codeOrder) {
        this.codeOrder = codeOrder;
    }


    @Override
    public String toString() {
        return "CodeEntity [codeId=" + codeId + ", codeType=" + codeType + ", codeKey=" + codeKey + ", codePname="
            + codePname + ", codeCname=" + codeCname + ", codeStatus=" + codeStatus + ", codePrintPname="
            + codePrintPname + ", codePrintCname=" + codePrintCname + ", codeOrder=" + codeOrder + "]";
    }
    
   
    
}