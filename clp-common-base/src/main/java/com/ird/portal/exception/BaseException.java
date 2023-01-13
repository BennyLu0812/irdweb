/**
 * @Project Name: atos-core
 * @File Name: BaseException.java
 * @Package Name: net.atos.exception
 * @Date: 2017年8月30日 上午10:09:23
 * @Copyright: Copyright (c) 2017 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.exception;

/**
 * 
 * <p>
 * 系統異常的基類.
 * </p>
 * <p>
 * 繼承RuntimeException(unchecked异常),規定每一個異常都有一個ERROR_CODE,並且對應多語言的errorMsg.
 * </p>
 * <p>
 * 參考文件:errorMsg_zh_TW.properties,errorMsg_en.properties,errorMsg_pt.properties
 * </p>
 *
 * <br/>
 * <b>Date:</b> 16/11/2017 23:23:29<br/>
 * 
 * @author Jim
 * @version 1.0
 */
public abstract class BaseException extends RuntimeException {
    
    /** 
     *
     */
    private static final long serialVersionUID = 3248492588624714944L;
    
    /**
     * unknown exception.在系統中沒有被BaseException子類抓捕的異常,統一報 {@link #ERROR_UNKNOWN} 錯誤代碼.
     */
    public static final String ERROR_UNKNOWN = "T-9999";
    
    /**
     * 參數.
     */
    protected Object[] arguments;
    
    /**
     * 默認異常.
     * <h3>代碼示例:</h3>
     * 
     * <pre>
     * try {
     *     // 業務代碼
     * }
     * catch (Exception e) {
     *     throw new DatabaseException();
     * }
     * </pre>
     */
    public BaseException() {
        super();
    }
    
    /**
     * <p>
     * errorMsg是需要經過 {@link ErrorMessageHelper#getErrorMsgByCode(String)} 轉換后的 errorMsg.
     * </p>
     * <h3>代碼示例:</h3>
     * 
     * <pre>
     * try {
     *     // 業務代碼
     * }
     * catch (Exception e) {
     *     throw new DatabaseException(ErrorMessageHelper.getErrorMsgByCode(DatabaseException.ERROR_DATABASE));
     * }
     * </pre>
     * 
     * @param errorMsg 需要经过 ErrorMessageHelper 转换.
     */
    public BaseException(String errorMsg) {
        super(errorMsg);
    }
    
    /**
     * {@link #BaseException(String)}
     * 
     * <h3>代碼示例:</h3>
     * 
     * <pre>
     * try {
     *     // 業務代碼
     * }
     * catch (Exception e) {
     *     throw new DatabaseException(ErrorMessageHelper.getErrorMsgByCode(DatabaseException.ERROR_DATABASE), e);
     * }
     * </pre>
     * 
     * @param errorMsg 需要经过 ErrorMessageHelper 转换.
     * @param cause 原始异常对象.
     */
    public BaseException(String errorMsg, Exception cause) {
        super(errorMsg, cause);
    }
    
    /**
     * 默認異常.
     * <h3>代碼示例:</h3>
     * 
     * <pre>
     * try {
     *     // 業務代碼
     * }
     * catch (Exception e) {
     *     throw new DatabaseException(e);
     * }
     * </pre>
     * 
     * @param cause 原始異常對象.
     */
    public BaseException(Exception cause) {
        super(cause);
    }
    
    
    public BaseException(Object... arguments) {
        super();
        this.arguments = arguments;
    }
    
    public Object[] getArguments() {
        return arguments;
    }

    
    public void setArguments(Object[] arguments) {
        this.arguments = arguments;
    }

    public abstract String getErrorCode();
    
}
