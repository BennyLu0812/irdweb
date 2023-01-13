package com.ird.portal.user;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * User DTO
 */
public class User implements Serializable {
    
    /** 
     *
     */
    private static final long serialVersionUID = 998708470140526107L;
    
    /** User ID */
    private String userId;
    
    /** User name */
    private String userName;

    /** User name En */
    private String userNameEn;

    /** User password */
    private String password;

    /** Department the user belongs to */
    private String dept;
    
    /** Status of the user account */
    private UserStatus status;
    
    private String ip;
    
    /** Roles */
    private Set<Role> roles = new HashSet<Role>();
    
    /** Func Codes*/
    private Set<String> funcCodes = new HashSet<>();
    
    /** User locale **/
    private Locale locale;

    private String userType;


    public User() {
        super();
    }
    
    public User(String userId, String userName, String password,String dept, UserStatus status, Collection<Role> roles) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.dept = dept;
        this.status = status;
        
    }
    
    public String getUserId() {
        return userId;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public String getDept() {
        return dept;
    }
    
    public UserStatus getStatus() {
        return status;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public void setDept(String dept) {
        this.dept = dept;
    }
    
    public void setStatus(UserStatus status) {
        this.status = status;
    }
    
    public Set<Role> getRoles() {
        return roles;
    }
    
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    
    
    public String getIp() {
        return ip;
    }

    
    public void setIp(String ip) {
        this.ip = ip;
    }
    
    public Set<String> getFuncCodes() {
        return funcCodes;
    }
    
    public void setFuncCodes(Set<String> funcCodes) {
        this.funcCodes = funcCodes;
    }

    public Locale getLocale() {
        return locale;
    }

    
    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserNameEn() {
        return userNameEn;
    }

    public void setUserNameEn(String userNameEn) {
        this.userNameEn = userNameEn;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }



    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userNameEn='" + userNameEn + '\'' +
                ", password='" + password + '\'' +
                ", dept='" + dept + '\'' +
                ", status=" + status +
                ", ip='" + ip + '\'' +
                ", roles=" + roles +
                ", funcCodes=" + funcCodes +
                ", locale=" + locale +
                ", userType='" + userType + '\'' +
                '}';
    }
}
