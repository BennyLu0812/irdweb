package com.ird.portal.exception;

/**
 * 
 * 記錄找不到時抛出的異常的信息.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 12/12/2017 11:42:29<br/>
 * 
 * @author Deft
 * @version 1.0
 */
public class RecordExistException extends BaseException {
    
    private static final long serialVersionUID = 130628L;
    
    private static final String ERROR_CODE = "F-0013";
    
    public RecordExistException(Object... arguments) {
        super(arguments);
    }
    
    @Override
    public String getErrorCode() {
        return ERROR_CODE;
    }
}
