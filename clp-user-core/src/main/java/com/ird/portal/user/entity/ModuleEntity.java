package com.ird.portal.user.entity;

import com.ird.portal.audit.annotation.Audited;
import com.ird.portal.audit.annotation.NotAudited;
import com.ird.portal.entity.AbstractEntity;


import javax.persistence.*;
import java.util.Set;
import java.util.TreeSet;
/**
 * 
 * 模塊實體.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 29/11/2017 17:20:38<br/>
 * @author Deft
 * @version 1.0
 */
@Audited
@Entity
@Table(name = "CLP_SYS_MODULE")
public class ModuleEntity extends AbstractEntity implements Comparable<ModuleEntity>{

    private static final long serialVersionUID = -8499281829754507134L;

    /** Module Id */
    private Long moduleId;

    /** Module Code */
    private String moduleName;


    /** System Code */
    private String sysCode;
    
    
    private Set<ModuleEntity> children = new TreeSet<ModuleEntity>();

    private ModuleEntity parent;

    private Integer sort;



    @Id
    @Column(name = "MODULE_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    @Column(name = "SYS_CODE", columnDefinition="VARCHAR2(3 CHAR)")
    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    @Column(name = "MODULE_NAME", columnDefinition="VARCHAR2(32 CHAR)")
    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    @NotAudited
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, mappedBy= "parent", fetch=FetchType.EAGER)
    public Set<ModuleEntity> getChildren() {
        return children;
    }

    public void setChildren(Set<ModuleEntity> children) {
        this.children = children;
    }

    @NotAudited
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, fetch=FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    public ModuleEntity getParent() {
        return parent;
    }

    public void setParent(ModuleEntity parent) {
        this.parent = parent;
    }

    @Column(name = "SORT")
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }


    @Override
	public int compareTo(ModuleEntity o) {
		return moduleName.compareTo(o.getModuleName());
	}

}
