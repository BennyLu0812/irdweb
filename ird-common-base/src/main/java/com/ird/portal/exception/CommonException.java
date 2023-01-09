package com.ird.portal.exception;

/**
 * 
 * 通用異常類
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 02/08/2018 11:42:29<br/>
 * @author Cyl
 * @version 1.0
 */
public class CommonException extends BaseException {
    
    /** Field說明 */
    private static final long serialVersionUID = -7605384346526687667L;
    private static final String ERROR_CODE = "F-0061";
    
    public CommonException(Object... arguments) {
        super(arguments);
    }

    @Override
    public String getErrorCode() {
        return ERROR_CODE;
    }
}
