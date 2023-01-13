package com.ird.portal.common.user.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ird.portal.data.BaseDTO;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * 功能DTO.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 12/12/2017 17:24:46<br/>
 * 
 * @author Deft
 * @version 1.0
 */
public class FuncDTO extends BaseDTO implements Comparable<FuncDTO> {
    
    private static final long serialVersionUID = 20151113L;
    
    private Long funcId;
    
    private String funcCode;
    
    private String[] funcCodes;
    
    private String funcDesc;
    
    private String status;
    
    private Long moduleId;
    
    private ModuleDTO module;
    
    private FuncDTO parent;
    
    private boolean checked;
    
    private String moduleName;

    @JsonIgnore
    private Set<FuncDTO> children = new TreeSet<FuncDTO>();
    
    private Long parentId;

    private String funcType;

    private String funcResource;

    private Integer sort;


    public Long getFuncId() {
        return funcId;
    }
    
    public void setFuncId(Long funcId) {
        this.funcId = funcId;
    }
    
    public String getFuncCode() {
        return funcCode;
    }

    
    public String[] getFuncCodes() {
        return funcCodes;
    }


    
    public String getModuleName() {
        return moduleName;
    }

    
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public void setFuncCodes(String[] funcCodes) {
        this.funcCodes = funcCodes;
    }

    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode;
    }
    
    public String getFuncDesc() {
        return funcDesc;
    }
    
    public void setFuncDesc(String funcDesc) {
        this.funcDesc = funcDesc;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public ModuleDTO getModule() {
        return module;
    }
    
    public void setModule(ModuleDTO module) {
        this.module = module;
    }
    
    public FuncDTO getParent() {
        return parent;
    }
    
    public void setParent(FuncDTO parent) {
        this.parent = parent;
    }
    
    public Set<FuncDTO> getChildren() {
        return children;
    }
    
    public void setChildren(Set<FuncDTO> children) {
        this.children = children;
    }
    
    public Long getModuleId() {
        return moduleId;
    }
    
    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }
    
    public boolean isChecked() {
        return checked;
    }
    
    public void setChecked(boolean checked) {
        this.checked = checked;
    }
    
    public Long getParentId() {
        return parentId;
    }
    
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getFuncType() {
        return funcType;
    }

    public void setFuncType(String funcType) {
        this.funcType = funcType;
    }

    public String getFuncResource() {
        return funcResource;
    }

    public void setFuncResource(String funcResource) {
        this.funcResource = funcResource;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }



    @Override
    public String toString() {
        String funcCodeList = "";
        if(funcCodes != null){
            funcCodeList = Arrays.toString(funcCodes);
        }
        return "FuncDTO{" +
                "funcId=" + funcId +
                ", funcCode='" + funcCode + '\'' +
                ", funcCodes=" +  funcCodeList  + '\'' +
                ", funcDesc='" + funcDesc + '\'' +
                ", status='" + status + '\'' +
                ", moduleId=" + moduleId +
                ", module=" + module +
                ", parent=" + parent +
                ", checked=" + checked +
                ", moduleName='" + moduleName + '\'' +
                ", children=" + children +
                ", parentId=" + parentId +
                ", funcType='" + funcType + '\'' +
                ", funcResource='" + funcResource + '\'' +
                ", sort=" + sort +

                '}';
    }

    @Override
    public int compareTo(FuncDTO o) {
        if(o != null && o.getFuncCode() != null && funcCode != null){
            return funcCode.compareTo(o.getFuncCode());
        }else{
            return 0;
        }

    }
    
}
