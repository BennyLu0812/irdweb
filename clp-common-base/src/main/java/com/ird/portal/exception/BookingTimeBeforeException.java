package com.ird.portal.exception;

/**
 * 
 * 預約開始時間+驗車中心允許提前報到分鐘數後是否比當前時間小.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 12/12/2017 11:42:29<br/>
 * 
 * @author Zack
 * @version 1.0
 */
public class BookingTimeBeforeException extends BaseException {

    private static final long serialVersionUID = 9102L;

    public static final String ERROR_CODE = "F-9105";

    public BookingTimeBeforeException(Object... arguments) {
        super(arguments);
    }

    @Override
    public String getErrorCode() {
        return ERROR_CODE;
    }
}
