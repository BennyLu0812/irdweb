package com.ird.portal.exception;

/**
 * 
 * 進場時沒有報到抛出的異常的信息.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 12/12/2017 11:42:29<br/>
 * 
 * @author Zack
 * @version 1.0
 */
public class NotCheckInException extends BaseException {

    private static final long serialVersionUID = 123456L;

    public static final String ERROR_CODE = "F-9104";

    public NotCheckInException(Object... arguments) {
        super(arguments);
    }

    @Override
    public String getErrorCode() {
        return ERROR_CODE;
    }
}
