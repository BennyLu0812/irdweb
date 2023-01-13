package com.ird.portal.user.entity;

import java.io.Serializable;

/**
 * 用戶和角色關聯聯合主鍵
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 25/11/2020 10:36:16<br/>
 * @author Gerrard
 * @version 1.0
 */
public class RoleFuncPK implements Serializable {

    private static final long serialVersionUID = 4874082227673682847L;

    /** Role ID */
    private Long roleId;

    /** Func Id */
    private Long funcId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getFuncId() {
        return funcId;
    }

    public void setFuncId(Long funcId) {
        this.funcId = funcId;
    }

    /**
     * 默認構造函數.
     * */
    public RoleFuncPK() {
        super();
    }

    public RoleFuncPK(Long roleId, Long funcId) {
        super();
        this.roleId = roleId;
        this.funcId = funcId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        RoleFuncPK other = (RoleFuncPK) obj;
        if (roleId == null) {
            if (other.roleId != null) {
                return false;
            }
        } else if (!roleId.equals(other.roleId)) {
            return false;
        }
        if (funcId == null) {
            if (other.funcId != null) {
                return false;
            }
        } else if (!funcId.equals(other.funcId)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
        result = prime * result + ((funcId == null) ? 0 : funcId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "{" +
                "roleId=" + roleId +
                ", funcId=" + funcId +
                '}';
    }
}
