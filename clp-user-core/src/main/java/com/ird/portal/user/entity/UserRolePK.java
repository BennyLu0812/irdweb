package com.ird.portal.user.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * 用戶和角色關聯聯合主鍵
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 25/11/2020 10:36:16<br/>
 * @author Gerrard
 * @version 1.0
 */
public class UserRolePK implements Serializable {

    private static final long serialVersionUID = 8499832851335584264L;

    /** Role ID */
    private Long roleId;

    /** User ID */
    private String userId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 默認構造函數.
     * */
    public UserRolePK() {
        super();
    }

    public UserRolePK(String userId, Long roleId) {
        super();
        this.userId = userId;
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        UserRolePK that = (UserRolePK) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(roleId, that.roleId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, roleId);
    }

    @Override
    public String toString() {
        return "{" +
                "userId='" + userId + '\'' +
                ", roleId=" + roleId +
                '}';
    }
}
