package com.ird.portal.exception;

/**
 * 
 * F-9126=該車輛服務已取消
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 17/01/2022 16:59:29<br/>
 * 
 * @author Zack
 * @version 1.0
 */
public class ProcessCancelException extends BaseException {

    private static final long serialVersionUID = 9126L;

    public static final String ERROR_CODE = "F-9126";

    public ProcessCancelException(Object... arguments) {
        super(arguments);
    }

    @Override
    public String getErrorCode() {
        return ERROR_CODE;
    }
}
