package com.ird.portal.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ird.portal.audit.annotation.Audited;
import com.ird.portal.audit.annotation.NotAudited;
import com.ird.portal.entity.AbstractEntity;


import javax.persistence.*;
import java.util.Set;
import java.util.TreeSet;
/**
 * 
 * 功能代碼實體.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 29/11/2017 17:20:08<br/>
 * @author Deft
 * @version 1.0
 */
@Audited
@Entity
@Table(name = "CLP_SYS_FUNC")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler"})
public class FuncEntity extends AbstractEntity implements Comparable<FuncEntity>{

    private static final long serialVersionUID = -7581991867475876875L;
    /**
	 * 
	 */

	/** Func Id */
	private Long funcId;

	/** Func Code */
	private String funcCode;
	
	/** Func description */
	private String funcDesc;
	
	private String status;

	//=================================
	private ModuleEntity module;

	private FuncEntity parent;

	private Set<FuncEntity> children = new TreeSet<FuncEntity>();

	/**
	 * 功能類型 {@link com.ird.portal.common.user.enums.FuncTypeEnum}
	 */
	private String funcType;

	/**
	 * 功能資源URL， FuncType=M的需要設置
	 */
	private String funcResource;

	/**
	 * 排序
	 */
	private Integer sort;



	@Id
	@Column(name = "FUNC_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getFuncId() {
		return funcId;
	}

	public void setFuncId(Long funcId) {
		this.funcId = funcId;
	}

	@Column(name = "FUNC_CODE", columnDefinition="VARCHAR2(24 CHAR)")
	public String getFuncCode() {
		return funcCode;
	}

	public void setFuncCode(String funcCode) {
		this.funcCode = funcCode;
	}

	@Column(name = "FUNC_DESC", columnDefinition="VARCHAR2(128 CHAR)")
    public String getFuncDesc() {
        return funcDesc;
    }

    public void setFuncDesc(String funcDesc) {
        this.funcDesc = funcDesc;
    }

    @Column(name = "STATUS", columnDefinition="VARCHAR2(1 CHAR)")
    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@NotAudited
	@ManyToOne(cascade = {CascadeType.REFRESH}, fetch=FetchType.EAGER)
    @JoinColumn(name = "MODULE_ID")
    public ModuleEntity getModule() {
        return module;
    }

    public void setModule(ModuleEntity module) {
        this.module = module;
    }

    @NotAudited
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, fetch=FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    public FuncEntity getParent() {
        return parent;
    }

    public void setParent(FuncEntity parent) {
        this.parent = parent;
    }

    @NotAudited
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, mappedBy= "parent", fetch=FetchType.EAGER)
	@JsonIgnore
	public Set<FuncEntity> getChildren() {
        return children;
    }

    public void setChildren(Set<FuncEntity> children) {
        this.children = children;
    }

    @Column(name = "FUNC_TYPE")
    public String getFuncType() {
		return funcType;
	}

	public void setFuncType(String funcType) {
		this.funcType = funcType;
	}

	@Column(name = "FUNC_RESOURCE")
	public String getFuncResource() {
		return funcResource;
	}

	public void setFuncResource(String funcResource) {
		this.funcResource = funcResource;
	}

	@Column(name = "SORT")
	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	@Override
	public int compareTo(FuncEntity o) {
		return funcCode.compareTo(o.getFuncCode());
	}


}
