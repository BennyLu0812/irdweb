package com.ird.portal.exception;

/**
 * F-9117=找不到對應的驗車中心
 * @author Zack
 */
public class NoCenterException extends BaseException {

    private static final long serialVersionUID = 9117L;

    public static final String ERROR_CODE = "F-9117";

    public NoCenterException(Object... arguments) {
        super(arguments);
    }

    @Override
    public String getErrorCode() {
        return ERROR_CODE;
    }
}
