/**
 * @Project Name: dls-sch-core
 * @File Name: ScheduleException.java
 * @Date: Nov 21, 2017
 * @Copyright: Copyright (c) 2017 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.sch.exception;

import com.ird.portal.exception.BaseException;

/**
 * 排程管理異常.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> Nov 21, 2017<br/>
 * @author Allen
 * @version 1.0
 */
public class ScheduleException extends BaseException {

    private static final long serialVersionUID = 3625917554635874598L;

    /**
     * unknown exception.在系統中沒有被BaseException子類抓捕的異常,統一報 {@link #ERROR_UNKNOWN} 錯誤代碼.
     */
    public static final String ERROR_SCHEDULE = "2000";
    
    public ScheduleException(String errorMsg){
        super(errorMsg);
    }
    
    public ScheduleException(String errorMsg, Exception cause) {
        super(errorMsg, cause);
    }
    
    @Override
    public String getErrorCode() {
        return ERROR_SCHEDULE;
    }
    
    
    

    
    
}
