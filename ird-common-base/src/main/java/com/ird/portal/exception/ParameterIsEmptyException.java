package com.ird.portal.exception;

public class ParameterIsEmptyException extends BaseException {
    
    private static final long serialVersionUID = 20160201L;
    
    public static final String ERROR_CODE = "F-0015";
    
    public ParameterIsEmptyException(Object... arguments) {
        super(arguments);
    }
    
    @Override
    public String getErrorCode() {
        return ERROR_CODE;
    }
    
}