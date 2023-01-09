package com.ird.portal.common.rpt.data;

import java.util.ArrayList;
import java.util.List;

/**
 * 自動打印報表參數
 * @author AugusChen
 */
public class AutoPrintReport {

    /**
     * 客戶端IP
     */
    private String clientIp;

    /**
     * 驗車中心編碼
     */
    private String centerCode;

    /**
     * 驗車線集合
     */
    private List<String> lineNoList = new ArrayList<>();

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getCenterCode() {
        return centerCode;
    }

    public void setCenterCode(String centerCode) {
        this.centerCode = centerCode;
    }

    public List<String> getLineNoList() {
        return lineNoList;
    }

    public void setLineNoList(List<String> lineNoList) {
        this.lineNoList = lineNoList;
    }
}
