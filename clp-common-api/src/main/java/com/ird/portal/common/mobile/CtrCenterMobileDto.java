package com.ird.portal.common.mobile;

/**
 * 驗車中心Dto
 * @author AugusChen
 */
public class CtrCenterMobileDto {
    

    /**
     * 驗車中心簡稱
     */
    private String centerShortName;

    private String queueSortingModeDesc;


    public String getCenterShortName() {
        return centerShortName;
    }

    public void setCenterShortName(String centerShortName) {
        this.centerShortName = centerShortName;
    }

    public String getQueueSortingModeDesc() {
        return queueSortingModeDesc;
    }

    public void setQueueSortingModeDesc(String queueSortingModeDesc) {
        this.queueSortingModeDesc = queueSortingModeDesc;
    }
}