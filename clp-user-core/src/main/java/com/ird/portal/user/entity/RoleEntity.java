package com.ird.portal.user.entity;

import com.ird.portal.audit.annotation.Audited;
import com.ird.portal.audit.annotation.NotAudited;
import com.ird.portal.entity.AbstractEntity;

import javax.persistence.*;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * 用戶實體.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 29/11/2017 17:20:56<br/>
 * @author Deft
 * @version 1.0
 */
@Audited
@Entity
@Table(name = "CLP_SYS_ROLE")
public class RoleEntity extends AbstractEntity implements Comparable<RoleEntity>{

    private static final long serialVersionUID = 3942070503412411370L;

    /** Object ID */
	private Long roleId;

	/** Role name */
	private String role;
	
	private String status;

	/** Role desc */
	private String roleDesc;

	/** Related functions */
	private Set<FuncEntity> funcs = new TreeSet<FuncEntity>();
	
	@Id
	@Column(name = "ROLE_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	@Column(name = "ROLE", columnDefinition="VARCHAR2(32 CHAR)")
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	@Column(name = "STATUS", length = 1)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
	

	@Column(name = "ROLE_DESC", columnDefinition="VARCHAR2(128 CHAR)")
	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	@NotAudited
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, fetch=FetchType.LAZY)
    @JoinTable(name = "CLP_SYS_ROLE_FUNC", joinColumns = { @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID") },
        inverseJoinColumns = { @JoinColumn(name = "FUNC_ID", referencedColumnName = "FUNC_ID") })
	public Set<FuncEntity> getFuncs() {
		return funcs;
	}

	public void setFuncs(Set<FuncEntity> funcs) {
		this.funcs = funcs;
	}

	@Override
	public int compareTo(RoleEntity o) {
		return role.compareTo(o.getRole());
	}

}
