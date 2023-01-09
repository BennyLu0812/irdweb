package com.ird.portal.common.user.data;

import com.ird.portal.data.BaseDTO;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;


/**
 * 
 * 角色DTO.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 12/12/2017 17:30:29<br/>
 * 
 * @author Deft
 * @version 1.0
 */
public class RoleDTO extends BaseDTO implements Comparable<RoleDTO> {
    
    private static final long serialVersionUID = 20151113L;
    
    private Long roleId;
    
    private String role;
    
    private String status;
    
    private String roleDesc;
    
    private Set<FuncDTO> funcs = new TreeSet<FuncDTO>();
    
    /** 查詢字段 */
    private String createDate_start;
    
    private String createDate_end;
    
    private String lastUpdDate_start;
    
    private String lastUpdDate_end;
    
    private Long[] funcIds;
    
    public Long getRoleId() {
        return roleId;
    }
    
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    
    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getRoleDesc() {
        return roleDesc;
    }
    
    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
    
    public Set<FuncDTO> getFuncs() {
        return funcs;
    }
    
    public void setFuncs(Set<FuncDTO> funcs) {
        this.funcs = funcs;
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
    
    public Long[] getFuncIds() {
        return funcIds;
    }
    
    public void setFuncIds(Long[] funcIds) {
        this.funcIds = funcIds;
    }
    
    public boolean havaFuncById(Long funcId) {
        if (funcId != null) {
            Set<FuncDTO> set = getFuncs();
            Iterator<FuncDTO> it = set.iterator();
            while (it.hasNext()) {
                FuncDTO funcDTO = it.next();
                if (funcDTO.getFuncId().equals(funcId)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean havaFuncByCode(String funcCode) {
        if (StringUtils.isNotBlank(funcCode)) {
            Set<FuncDTO> set = getFuncs();
            Iterator<FuncDTO> it = set.iterator();
            while (it.hasNext()) {
                FuncDTO funcDTO = it.next();
                if (funcDTO.getFuncCode().equals(funcCode)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean havaAllFunc(String[] funcCodes) {
        if (funcCodes == null || funcCodes.length == 0) {
            return false;
        }
        Set<FuncDTO> set = getFuncs();
        if (funcCodes.length > set.size()) {
            return false;
        }
        Iterator<FuncDTO> it = set.iterator();
        String[] codes = new String[set.size()];
        for (int i = 0; it.hasNext(); i++) {
            FuncDTO funcDTO = it.next();
            codes[i] = funcDTO.getFuncCode();
        }
        int count = 0;
        for (String code : funcCodes) {
            if (Arrays.binarySearch(codes, code) > -1) {
                count++;
            }
        }
        
        if (count == funcCodes.length) {
            return true;
        }
        
        return false;
    }
    
    @Override
    public int compareTo(RoleDTO o) {
        return role.compareTo(o.getRole());
    }
}
