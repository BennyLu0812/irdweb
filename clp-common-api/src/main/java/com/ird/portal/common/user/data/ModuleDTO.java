package com.ird.portal.common.user.data;


import com.ird.portal.data.BaseDTO;

import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * 模组DTO
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 12/12/2017 17:27:14<br/>
 * 
 * @author Deft
 * @version 1.0
 */
public class ModuleDTO extends BaseDTO implements Comparable<ModuleDTO> {
    
    private static final long serialVersionUID = 117057419001955251L;
    
    private Long moduleId;
    
    private String moduleName;
    
    private String moduleDesc;
    
    private String sysCode;
    
    private ModuleDTO parent;
    
    private Set<ModuleDTO> children = new TreeSet<ModuleDTO>();
    
    private Long parentId;

    private Integer sort;


    
    public Long getModuleId() {
        return moduleId;
    }
    
    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }
    
    public String getModuleName() {
        return moduleName;
    }
    
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
    
    public String getModuleDesc() {
        return moduleDesc;
    }
    
    public void setModuleDesc(String moduleDesc) {
        this.moduleDesc = moduleDesc;
    }
    
    public String getSysCode() {
        return sysCode;
    }
    
    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }
    
    public ModuleDTO getParent() {
        return parent;
    }
    
    public void setParent(ModuleDTO parent) {
        this.parent = parent;
    }
    
    public Set<ModuleDTO> getChildren() {
        return children;
    }
    
    public void setChildren(Set<ModuleDTO> children) {
        this.children = children;
    }
    
    @Override
    public int compareTo(ModuleDTO o) {
        return moduleName.compareTo(o.getModuleName());
    }

    
    public Long getParentId() {
        return parentId;
    }

    
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }


}
