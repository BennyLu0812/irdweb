package com.ird.portal.util;

import javax.servlet.http.HttpServletRequest;

public class HttpServletRequestUtil {

    protected static final String XML_HTTP_REQUEST = "XMLHttpRequest";
    protected static final String X_REQUESTED_WITH = "X-Requested-With";
    
    public static boolean isAjaxRequest(HttpServletRequest request) {
        return XML_HTTP_REQUEST.equals(request.getHeader(X_REQUESTED_WITH));
    }
}
