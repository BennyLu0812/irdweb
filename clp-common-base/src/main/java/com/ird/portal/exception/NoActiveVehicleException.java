package com.ird.portal.exception;

/**
 * F-9118=沒有對應有效車輛記錄:{0}({1})!
 * @author Zack
 */
public class NoActiveVehicleException extends BaseException {

    private static final long serialVersionUID = 9118L;

    public static final String ERROR_CODE = "F-9118";

    public NoActiveVehicleException(Object... arguments) {
        super(arguments);
    }

    @Override
    public String getErrorCode() {
        return ERROR_CODE;
    }
}
