/**
 * @Project Name: dls-exl-core
 * @File Name: IllegalParameterException.java
 * @Date: 30/05/2018 23:39:40
 * @Copyright: Copyright (c) 2018 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.exception;

/**
 * 不合法參數值異常.
 * 
 * e.g. 只要求傳入0或1，但是傳入的是0或1以外的值。
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 30/05/2018 23:39:40<br/>
 * @author raysely
 * @version 1.0
 */
public class IllegalParameterValueException extends BaseException {

    /**
     * 序列化serialVersionUID.
     */
    private static final long serialVersionUID = -2474002158365788986L;
    
    /**
     * 異常CODE.
     */
    private static final String ERROR_CODE = "F-3001";

    /**
     * 構造函數.
     * @param arguments 異常信息
     */
    public IllegalParameterValueException(Object... arguments) {
        super(arguments);
    }

    @Override
    public String getErrorCode() {
        return ERROR_CODE;
    }
}
