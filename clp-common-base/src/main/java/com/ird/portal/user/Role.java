package com.ird.portal.user;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

/**
 * 
 * 系統角色 ROLE.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 15/12/2017 17:23:02<br/>
 * @author Jim
 * @version 1.0
 */
public class Role implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 20130825L;
    
    private Long roleId;
    
    /** Role name */
    private String role;
    
    /** Sys Code */
    private String sysCode;
    
    /** Role for display */
    private String roleDisplay;
    
    /** Role desc */
    private String roleDesc;
    
    /** Granted function access, Key: Function name, Value Function class */
    private Collection<Function> funcs;
    
    public Role() {
        super();
    }
    
    public Role(String role, String sysCode, String roleDisplay, String roleDesc, Collection<Function> funcs) {
        super();
        this.role = role;
        this.sysCode = sysCode;
        this.roleDesc = roleDesc;
        this.roleDisplay = roleDisplay;
        
        if (funcs == null)
            this.funcs = Collections.emptyList();
        else
            this.funcs = Collections.unmodifiableCollection(funcs);
    }
    
    public String getRole() {
        return role;
    }
    
    public String getSysCode() {
        return sysCode;
    }
    
    public String getRoleDesc() {
        return roleDesc;
    }
    
    public String getRoleDisplay() {
        return roleDisplay;
    }
    
    public void setRoleDisplay(String roleDisplay) {
        this.roleDisplay = roleDisplay;
    }
    
    public Collection<Function> getFuncs() {
        return funcs;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }
    
    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
    
    public void setFuncs(Collection<Function> funcs) {
        this.funcs = funcs;
    }
    
    public Long getRoleId() {
        return roleId;
    }
    
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    
    
}
