/**
 * @Project Name: atos-web
 * @File Name: ErrorInfo.java
 * @Package Name: net.atos
 * @Date: 2017年9月11日 上午11:39:52
 * @Copyright: Copyright (c) 2017 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.web.error;

/**
 * 
 * 錯誤消息的封裝類，描述系統發生錯誤時，輸出的消息格式.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 15/11/2017 17:22:13<br/>
 * 
 * @author Jim
 * @version 1.0
 */
public class ErrorInfo {
    
    // http status 狀態碼
    private int status;
    
    // 錯誤編碼
    private String errorCode;
    
    // 錯誤消息
    private String errorMsg;
    
    // 系統原始錯誤消息 java catch(Exception e) 最原始的java堆棧消息,只提供編程人員查看.
    private String sysErrorMsg;
    
    // 當前錯誤時請求的URL
    private String path;
    
    // 跳轉的URL,如果是status = 302,發生跳轉.
    private String redirectUrl;

    // Exception里面的参数.
    private Object[] arguments;
    
    public int getStatus() {
        return status;
    }
    
    public ErrorInfo setStatus(int status) {
        this.status = status;
        return this;
    }
    
    public String getErrorCode() {
        return errorCode;
    }
    
    public ErrorInfo setErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }
    
    public String getErrorMsg() {
        return errorMsg;
    }
    
    public ErrorInfo setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
        return this;
    }
    
    public String getSysErrorMsg() {
        return sysErrorMsg;
    }
    
    public ErrorInfo setSysErrorMsg(String sysErrorMsg) {
        this.sysErrorMsg = sysErrorMsg;
        return this;
    }
    
    public String getPath() {
        return path;
    }
    
    public ErrorInfo setPath(String path) {
        this.path = path;
        return this;
    }
    
    public String getRedirectUrl() {
        return redirectUrl;
    }
    
    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public Object[] getArguments() {
        return arguments;
    }

    public void setArguments(Object[] arguments) {
        this.arguments = arguments;
    }
}
