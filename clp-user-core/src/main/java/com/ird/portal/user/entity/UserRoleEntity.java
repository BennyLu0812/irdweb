package com.ird.portal.user.entity;

import com.ird.portal.audit.annotation.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

/**
 *
 * 用戶和角色關聯實體.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 25/11/2020 10:36:16<br/>
 * @author Gerrard
 * @version 1.0
 */

@Audited
@Entity
@IdClass(UserRolePK.class)
@Table(name = "CLP_SYS_USER_ROLE" )
public class UserRoleEntity implements Serializable {

    private static final long serialVersionUID = -5658110405729836500L;

    /** Role ID */
    private Long roleId;

    /** User ID */
    private String userId;

    @Id
    @Column(name = "ROLE_ID", columnDefinition = "NUMBER(10, 0)")
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Id
    @Column(name = "USER_ID", columnDefinition = "VARCHAR2(20 CHAR)")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return roleId + "," + userId;
    }
}
