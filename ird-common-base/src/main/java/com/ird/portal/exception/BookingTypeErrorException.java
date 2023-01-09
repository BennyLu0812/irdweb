package com.ird.portal.exception;

/**
 * 進場與報到，所選擇的預約方式不一致
 * @author Zack
 */
public class BookingTypeErrorException extends BaseException {

    private static final long serialVersionUID = 130628L;

    public static final String ERROR_CODE = "F-9116";

    public BookingTypeErrorException(Object... arguments) {
        super(arguments);
    }

    @Override
    public String getErrorCode() {
        return ERROR_CODE;
    }
}
