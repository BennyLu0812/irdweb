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
 * <b>Date:</b> 29/11/2017 17:21:16<br/>
 * @author Deft
 * @version 1.0
 */

@Audited
@Entity
@Table(name = "CLP_SYS_USER" )
public class UserEntity extends AbstractEntity implements Comparable<UserEntity>{

    private static final long serialVersionUID = 2261350397707755905L;

    /** User ID */
	private String userId;

	/** User name */
	private String cnName;
	
	private String enName;
	
	/** Status of the user account */
	private String status;

	/** Role of the user */
	@OrderBy("role")
	private Set<RoleEntity> roles = new TreeSet<>();

	/** A - AD L - 本地 */
	private String userType;

	/**
	 * user password
	 */
	private String password;

	@Id
	@Column(name = "USER_ID", columnDefinition = "VARCHAR2(8 CHAR)")
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "USER_STATUS", length = 1)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name="USER_NAME_CN", columnDefinition = "VARCHAR2(64 CHAR)")
	public String getCnName() {
        return cnName;
    }

    public void setCnName(String zhName) {
        this.cnName = zhName;
    }

    @Column(name="USER_NAME_EN", columnDefinition = "VARCHAR2(64 CHAR)")
    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

	@Column(name = "USER_TYPE", length = 1)
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@NotAudited
    @ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, fetch=FetchType.LAZY)
	@JoinTable(name = "CLP_SYS_USER_ROLE", joinColumns = { @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID") },
	    inverseJoinColumns = { @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID") })
//	@Fetch(value = FetchMode.SUBSELECT)
	public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }

	@Column(name="PASSWORD", columnDefinition = "VARCHAR2(20 CHAR)")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int compareTo(UserEntity o) {
		return userId.compareTo(o.getUserId());
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof UserEntity) {
			return userId.equals(((UserEntity) o).getUserId());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return userId.hashCode();
	}
}
