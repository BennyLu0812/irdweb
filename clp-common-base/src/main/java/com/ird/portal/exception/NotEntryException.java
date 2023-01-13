package com.ird.portal.exception;

/**
 * 沒有進場記錄，不能出場.
 * @author AugusChen
 */
public class NotEntryException extends BaseException {

    private static final long serialVersionUID = 130628L;

    public static final String ERROR_CODE = "F-9109";

    public NotEntryException(Object... arguments) {
        super(arguments);
    }

    @Override
    public String getErrorCode() {
        return ERROR_CODE;
    }
}
