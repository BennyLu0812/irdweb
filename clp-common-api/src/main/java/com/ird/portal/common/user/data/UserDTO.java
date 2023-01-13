package com.ird.portal.common.user.data;


import com.ird.portal.data.BaseDTO;

import java.util.*;

/**
 * 
 * 用戶實體DTO.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 12/12/2017 17:29:42<br/>
 * 
 * @author Deft
 * @version 1.0
 */
public class UserDTO extends BaseDTO implements Comparable<UserDTO> {
    
    private static final long serialVersionUID = 20151113L;
    
    private String userId;
    
    private String cnName;
    
    private String enName;
    
    private String status;
    
    private Set<RoleDTO> roles = new TreeSet<RoleDTO>();
    
    private String roleNames;
    
    /** 查詢字段 */
    private String createDate_start;
    
    private String createDate_end;
    
    private String lastUpdDate_start;
    
    private String lastUpdDate_end;
    
    private Long[] roleIds;
    
    private String role;

    private String userType;

    private String  oldPassword;

    private String newPassword;

    private String newPassword2;
    
    public String getUserId() {
        return userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public String getCnName() {
        return cnName;
    }
    
    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public Set<RoleDTO> getRoles() {
        return roles;
    }
    
    public void setRoles(Set<RoleDTO> roles) {
        this.roles = roles;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getRoleNames() {
        return roleNames;
    }
    
    public void setRoleNames(String roleNames) {
        this.roleNames = roleNames;
    }
    
    public String getCreateDate_start() {
        return createDate_start;
    }
    
    public void setCreateDate_start(String createDate_start) {
        this.createDate_start = createDate_start;
    }
    
    public String getCreateDate_end() {
        return createDate_end;
    }
    
    public void setCreateDate_end(String createDate_end) {
        this.createDate_end = createDate_end;
    }
    
    public String getLastUpdDate_start() {
        return lastUpdDate_start;
    }
    
    public void setLastUpdDate_start(String lastUpdDate_start) {
        this.lastUpdDate_start = lastUpdDate_start;
    }
    
    public String getLastUpdDate_end() {
        return lastUpdDate_end;
    }
    
    public void setLastUpdDate_end(String lastUpdDate_end) {
        this.lastUpdDate_end = lastUpdDate_end;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * 根據用戶角色Id獲取指定角色 return false 沒有;true 有
     * 
     * @param roleId
     * @return
     */
    public RoleDTO getRoleById(Long roleId) {
        if (roleId != null) {
            Set<RoleDTO> set = getRoles();
            Iterator<RoleDTO> it = set.iterator();
            while (it.hasNext()) {
                RoleDTO roleDTO = it.next();
                if (roleDTO.getRoleId().equals(roleId)) {
                    return roleDTO;
                }
            }
        }
        return null;
    }
    
    /**
     * 根據角色Id判斷用戶是否有該角色 return false 沒有;true 有
     * 
     * @param roleId
     * @return
     */
    public boolean havaRoleById(Long roleId) {
        if (roleId != null) {
            Set<RoleDTO> set = getRoles();
            Iterator<RoleDTO> it = set.iterator();
            while (it.hasNext()) {
                RoleDTO roleDTO = it.next();
                if (roleDTO.getRoleId().equals(roleId)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    /**
     * 根據功能編碼判斷用戶是否有該功能權限 return false 沒有;true 有
     * 
     * @param funcCode
     * @return
     */
    public boolean havaFuncByCode(String funcCode) {
        if (funcCode != null) {
            for (RoleDTO r : getRoles()) {
                for (FuncDTO f : r.getFuncs()) {
                    if (funcCode.equals(f.getFuncCode())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    /**
     * 根據用戶權限編碼獲取該功能權限 return false 沒有;true 有
     * 
     * @param funcCode
     * @return
     */
    public FuncDTO getFuncByCode(String funcCode) {
        if (funcCode != null) {
            for (RoleDTO r : getRoles()) {
                for (FuncDTO f : r.getFuncs()) {
                    if (funcCode.equals(f.getFuncCode())) {
                        return f;
                    }
                }
            }
        }
        return null;
    }
    
    /**
     * 根據傳入功能編碼List判斷用戶是否有指定編碼List的全部功能權限 return false 沒有;true 有
     * 
     * @param funcCodes
     * @return
     */
    public boolean havaAllFunc(List<String> funcCodes) {
        if (funcCodes != null && funcCodes.size() > 0) {
            int num = 0, len = funcCodes.size();
            for (RoleDTO r : getRoles()) {
                for (FuncDTO f : r.getFuncs()) {
                    if (funcCodes.contains(f.getFuncCode())) {
                        num++;
                    }
                    if (num >= len) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    /**
     * 根據傳入功能編碼List判斷用戶返回Map {key 功能編碼：value true/false} false 沒有該權限;true 有該權限 如:list {"user_add","user_update"} 返回Map
     * {"user_add":true,"user_update":false}
     * 
     * @param funcCodes
     * @return
     */
    public Map<String, Boolean> isHavaFunc(List<String> funcCodes) {
        if (funcCodes != null && funcCodes.size() > 0) {
            Map<String, Boolean> privilege = new HashMap<String, Boolean>();
            boolean flag;
            for (String code : funcCodes) {
                flag = false;
                for (RoleDTO r : getRoles()) {
                    for (FuncDTO f : r.getFuncs()) {
                        if (code.equals(f.getFuncCode())) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        break;
                    }
                }
                if (flag) {
                    privilege.put(code, true);
                }
                else {
                    privilege.put(code, false);
                }
            }
            return privilege;
        }
        return null;
    }
    
    @Override
    public int compareTo(UserDTO o) {
        return userId.compareTo(o.getUserId());
    }
    
    public Long[] getRoleIds() {
        return roleIds;
    }
    
    public void setRoleIds(Long[] roleIds) {
        this.roleIds = roleIds;
    }
    
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewPassword2() {
        return newPassword2;
    }

    public void setNewPassword2(String newPassword2) {
        this.newPassword2 = newPassword2;
    }
}
