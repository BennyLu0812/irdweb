package com.ird.portal.exception;

/**
 * 
 * when the status is not valid to be updated to another status
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 19/04/2018 20:22:41<br/>
 * 
 * @author Crystal Zhao
 * @version 1.0
 */
public class InvalidStatusException extends BaseException {
    
    private static final long serialVersionUID = 5213616962418667555L;
    
    private static final String ERROR_CODE = "F-0016";
    
    public InvalidStatusException(Object... arguments) {
        super(arguments);
    }
    
    @Override
    public String getErrorCode() {
        return ERROR_CODE;
    }
    
}
