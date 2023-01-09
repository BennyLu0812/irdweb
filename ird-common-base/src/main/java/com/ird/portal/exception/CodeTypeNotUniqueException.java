package com.ird.portal.exception;

import java.io.Serializable;

public class CodeTypeNotUniqueException extends BaseException {
    private static final long serialVersionUID = 8098040347329388674L;
    
    private static final String ERROR_CODE = "F-0017";

    public CodeTypeNotUniqueException(Serializable key) {
        super(ERROR_CODE, key);
    }

    @Override
    public String getErrorCode() {
        return ERROR_CODE;
    }
}