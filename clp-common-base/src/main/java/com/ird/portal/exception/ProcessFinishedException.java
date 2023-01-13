package com.ird.portal.exception;

/**
 * 
 * F-9125=該車輛服務已完成
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 17/01/2022 16:59:29<br/>
 * 
 * @author Zack
 * @version 1.0
 */
public class ProcessFinishedException extends BaseException {

    private static final long serialVersionUID = 9125L;

    public static final String ERROR_CODE = "F-9125";

    public ProcessFinishedException(Object... arguments) {
        super(arguments);
    }

    @Override
    public String getErrorCode() {
        return ERROR_CODE;
    }
}
