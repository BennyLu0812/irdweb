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
 * 角色和功能代碼關聯實體.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 25/11/2020 10:36:16<br/>
 * @author Gerrard
 * @version 1.0
 */

@Audited
@Entity
@Table(name = "CLP_SYS_ROLE_FUNC" )
@IdClass(RoleFuncPK.class)
public class RoleFuncEntity implements Serializable {

    private static final long serialVersionUID = 7713553881944046918L;

    /** 角色 ID */
    private Long roleId;

    /** 功能 ID */
    private Long funcId;

    @Id
    @Column(name = "ROLE_ID", columnDefinition = "NUMBER(10,0)")
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Id
    @Column(name = "FUNC_ID", columnDefinition = "NUMBER(10,0)")
    public Long getFuncId() {
        return funcId;
    }

    public void setFuncId(Long funcId) {
        this.funcId = funcId;
    }

    @Override
    public String toString() {
        return roleId + "," + funcId;
    }

}
