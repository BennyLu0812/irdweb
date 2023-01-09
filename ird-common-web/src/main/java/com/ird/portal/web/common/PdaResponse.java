package com.ird.portal.web.common;

import com.ird.portal.exception.BaseException;
import com.ird.portal.exception.ErrorMessageHelper;
import com.ird.portal.web.error.ErrorInfo;

/**
 * @author Tim
 * @version 1.0
 * @date 12/08/2021 9:35
 */
public class PdaResponse {

    private int status;

    private String errCode;

    private String errMsg;

    private Object data;

    public static final int SUCCESS_STATUS = 200;

    public static final int ERROR_STATUS = 500;

    public static PdaResponse success() {
        return success(SUCCESS_STATUS,null);
    }

    public static PdaResponse success(int status) {
        return success(status, null);
    }

    public static PdaResponse success(Object data) {
        return success(SUCCESS_STATUS, data);
    }

    public static PdaResponse success(int status, Object data) {
        PdaResponse pdaResponse = new PdaResponse();
        pdaResponse.setStatus(status);
        pdaResponse.setData(data);
        return pdaResponse;
    }

    public static PdaResponse error(int status) {
        return error(status, null);
    }

    public static PdaResponse error() {
        return error(PdaResponse.ERROR_STATUS, null);
    }

    public static PdaResponse error(Throwable exception) {
        return error(PdaResponse.ERROR_STATUS, exception);
    }

    public static PdaResponse error(int status, Throwable exception) {
        PdaResponse pdaResponse = new PdaResponse();
        pdaResponse.setStatus(status);
        if (exception instanceof BaseException) {
            BaseException baseException = (BaseException) exception;
            pdaResponse.setErrCode(baseException.getErrorCode());
            pdaResponse.setErrMsg(ErrorMessageHelper.getErrorMsgByCode(pdaResponse.errCode, baseException.getArguments()));
        } else {
            pdaResponse.setErrCode(BaseException.ERROR_UNKNOWN);
            pdaResponse.setErrMsg(ErrorMessageHelper.getErrorMsgByCode(pdaResponse.errCode));
        }
        return pdaResponse;
    }

    public static PdaResponse error(ErrorInfo errorInfo) {
        PdaResponse pdaResponse = new PdaResponse();
        pdaResponse.setStatus(errorInfo.getStatus());
        pdaResponse.setErrCode(errorInfo.getErrorCode());
        pdaResponse.setErrMsg(errorInfo.getErrorMsg());
        return pdaResponse;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PdaResponse{" +
                "status=" + status +
                ", errCode='" + errCode + '\'' +
                ", errMsg='" + errMsg + '\'' +
                ", data=" + data +
                '}';
    }
}
