package com.ird.portal.exception;

/**
 * 當前驗車中心沒有啟動報到.
 * @author AugusChen
 */
public class CenterNotCheckInException extends BaseException {

    private static final long serialVersionUID = 130628L;

    public static final String ERROR_CODE = "F-9108";

    public CenterNotCheckInException(Object... arguments) {
        super(arguments);
    }

    @Override
    public String getErrorCode() {
        return ERROR_CODE;
    }
}
