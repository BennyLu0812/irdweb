package com.ird.portal.exception;

/**
 * 
 * 預約開始時間+驗車中心允許提前報到分鐘數後是否比當前時間小.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 14/12/2021 11:42:29<br/>
 * 
 * @author Zack
 * @version 1.0
 */
public class BookingTimeAfterException extends BaseException {

    private static final long serialVersionUID = 9123L;

    public static final String ERROR_CODE = "F-9123";

    public BookingTimeAfterException(Object... arguments) {
        super(arguments);
    }

    @Override
    public String getErrorCode() {
        return ERROR_CODE;
    }
}
