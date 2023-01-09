package com.ird.portal.exception;

/**
 * 分配停車區域抛出的異常的信息.
 * @author AugusChen
 */
public class AllotParkingAreaException extends BaseException {

    private static final long serialVersionUID = 130628L;

    public static final String ERROR_CODE = "F-9107";

    public AllotParkingAreaException(Object... arguments) {
        super(arguments);
    }

    @Override
    public String getErrorCode() {
        return ERROR_CODE;
    }
}
