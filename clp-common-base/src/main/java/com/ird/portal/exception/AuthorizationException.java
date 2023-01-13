package com.ird.portal.exception;

/**
 * 
 * 權限異常信息.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 12/12/2017 11:40:28<br/>
 * 
 * @author Deft
 * @version 1.0
 */
public class AuthorizationException extends BaseException {
    private static final long serialVersionUID = 8098040347329388674L;
    /**
     * 權限異常代碼
     */
    private static final String ERROR_CODE = "T-1002";

    public AuthorizationException() {
        super();
    }
    
    public AuthorizationException(Object... args) {
        super(args);
    }
    
    public AuthorizationException(String message) {
        super(message);
    }

    public AuthorizationException(String message, Exception cause) {
        super(message, cause);
    }

    @Override
    public String getErrorCode() {
        return ERROR_CODE;
    }
    
}