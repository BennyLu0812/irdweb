package com.ird.portal.user.entity;

import java.io.Serializable;

/**
 * @author Tim
 * @version 1.0
 * @date 18/08/2021 14:06
 */
public class CenterRolePK implements Serializable {

    private static final long serialVersionUID = 3544536161225906856L;

    private Long centerId;

    private Long roleId;

    public Long getCenterId() {
        return centerId;
    }

    public void setCenterId(Long centerId) {
        this.centerId = centerId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "CenterRolePK{" +
                "centerId=" + centerId +
                ", roleId=" + roleId +
                '}';
    }
}
