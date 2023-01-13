package com.ird.portal.exception;


/**
 * 功能类型更新异常
 *
 * @author Tim
 */
public class FuncTypeUpdateException extends BaseException {

    private static final long serialVersionUID = 130629L;

    private static final String ERROR_CODE = "F-0117";

    public FuncTypeUpdateException(Object... arguments) {
        super(arguments);
    }

    @Override
    public String getErrorCode() {
        return ERROR_CODE;
    }
}
