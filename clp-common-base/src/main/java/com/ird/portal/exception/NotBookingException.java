package com.ird.portal.exception;

/**
 * 
 * 没有預約錯誤
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 12/12/2017 11:42:29<br/>
 * 
 * @author Zack
 * @version 1.0
 */
public class NotBookingException extends BaseException {

    private static final long serialVersionUID = 9103L;

    public static final String ERROR_CODE = "F-9106";

    public NotBookingException(Object... arguments) {
        super(arguments);
    }

    @Override
    public String getErrorCode() {
        return ERROR_CODE;
    }
}
