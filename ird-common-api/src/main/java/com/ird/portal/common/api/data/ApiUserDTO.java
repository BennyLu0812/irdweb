package com.ird.portal.common.api.data;

/**
 * <br/> 閘機/報到PDA登錄實體
 * <br/>
 * <b>Date:</b> 2021/9/23 9:46<br/>
 *
 * @author Zack
 * @version 1.0
 */
public class ApiUserDTO {
    /**
     * 用戶ID
     */
    private String userId;

    /**
     * 密碼
     */
    private String password;

    /**
     * 設備類別
     */
    private String machineType;

    /**
     * 設備ID
     */
    private String machineId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getMachineId() {
        return machineId;
    }

    public void setMachineId(String machineId) {
        this.machineId = machineId;
    }

    @Override
    public String toString() {
        return "ApiUserDTO{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", machineType='" + machineType + '\'' +
                ", machineId='" + machineId + '\'' +
                '}';
    }
}
