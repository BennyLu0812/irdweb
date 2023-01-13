package com.ird.portal.exception;

/**
 * 
 * Title: <br/>
 * Description: <br/>
 * Date: 2017年8月30日 下午4:04:28<br/>
 *
 * @author Jim
 * @version 1.0
 * @since JDK1.8
 */
public class SysException extends BaseException {
    
    /** 
     *
     */
    private static final long serialVersionUID = 7214310797789922352L;
    
    public static final String ERROR_SYS = "F-0018";
    
    public SysException(Object... arguments) {
        super(arguments);
    }
    
    @Override
    public String getErrorCode() {
        return ERROR_SYS;
    }
}
