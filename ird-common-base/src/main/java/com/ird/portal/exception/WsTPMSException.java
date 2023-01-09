package com.ird.portal.exception;

/**
 * Title:  調用TPMS的web-service，捕獲其拋出的異常<br>
 * Description:   <br>
 *
 * @author: luke feng
 * @version 1.0
 * @CreateTime: 2018年09月18日 下午5:05:30
 */
public class WsTPMSException extends BaseException {

    private static final long serialVersionUID = -7984315833385919411L;
    private static final String ERROR_CODE = "F-0113";
    
    public WsTPMSException(Object... arguments) {
        super(arguments);
    }
    
    @Override
    public String getErrorCode() {
        return ERROR_CODE;
    }

}
