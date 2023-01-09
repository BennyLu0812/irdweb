/**
 * @Project Name: atos-web
 * @File Name: ErrorRestResponseController.java
 * @Package Name: net.atos
 * @Date: 2017年9月11日 下午5:24:26
 * @Copyright: Copyright (c) 2017 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.web.error;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ird.portal.exception.BaseException;
import com.ird.portal.exception.ErrorMessageHelper;
import com.ird.portal.user.UserAccessResourceContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;


/**
 * 
 * @ControllerAdvice没有捕获的异常，ErrorController进行处理.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 19/12/2017 22:54:10<br/>
 * @author Jim
 * @version 1.0
 */
@Controller
@RequestMapping("${server.error.path:${error.path:/error}}")
public class ErrorRestResponseController implements ErrorController {
    
    @Value("${error.path:/error}")
    private String errorPath;
    
    protected static final String ERROR_ATTRIBUTE = DefaultErrorAttributes.class.getName() + ".ERROR";
    
    protected static final String ERROR_NO_FOUND = "error/404";
    
    protected static final String ERROR_NO_LOGIN = "error/401";
    
    protected static final String ERROR_NO_AUTH = "error/403";
    
    protected static final String ERROR_SERVICE_EXCEPTION = "error/500";
    
    protected static final String ERROR_NO_METHOD = "error/405";
    
    @RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ResponseBody
    public ResponseEntity<ErrorInfo> error(HttpServletRequest request) {
        
        HttpStatus status = getStatus(request);
        
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        Throwable throwable = getError(requestAttributes);
        
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setStatus(status.value());
        errorInfo.setPath(getRequestURI(request));
        errorInfo.setSysErrorMsg(getExceptionTrace(throwable));
        
        if (throwable instanceof BaseException) {
            BaseException exception = (BaseException)throwable;
            errorInfo.setErrorCode(exception.getErrorCode());
            errorInfo.setErrorMsg(ErrorMessageHelper.getErrorMsgByCode(exception.getErrorCode(), exception.getArguments()));
        } else {
            errorInfo.setErrorCode(BaseException.ERROR_UNKNOWN);
            errorInfo.setErrorMsg(ErrorMessageHelper.getErrorMsgByCode(BaseException.ERROR_UNKNOWN));
        }
        
        return new ResponseEntity<ErrorInfo>(errorInfo, status);
    }
    
    //@RequestMapping(produces = "text/html")
    @RequestMapping
    public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
        HttpStatus status = getStatus(request);
        //response.setStatus(status.value());

        
        ErrorInfo errorInfo = new ErrorInfo();
        
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        Throwable throwable = getError(requestAttributes);
        
        String errorCode = String.valueOf(status.value());
        errorInfo.setErrorCode(errorCode);
        errorInfo.setErrorMsg(ErrorMessageHelper.getErrorMsgByCode("T-" + errorCode));
        errorInfo.setSysErrorMsg(getExceptionTrace(throwable));
        errorInfo.setStatus(status.value());
        errorInfo.setPath(getRequestURI(request));
        
        ModelAndView mv = new ModelAndView();
        if (status.value() == HttpStatus.NOT_FOUND.value()) {
            mv.setViewName(ERROR_NO_FOUND);
        }
        else if (status.value() == HttpStatus.UNAUTHORIZED.value()) {
            mv.setViewName(ERROR_NO_LOGIN);
        }
        else if (status.value() == HttpStatus.FORBIDDEN.value()) {
            mv.setViewName(ERROR_NO_AUTH);
            mv.addObject("authorizeExpression", UserAccessResourceContext.get());
        }
        else if (status.value() == HttpStatus.METHOD_NOT_ALLOWED.value()) {
            mv.setViewName(ERROR_NO_METHOD);
        }
        else if (status.value() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            mv.setViewName(ERROR_SERVICE_EXCEPTION);
        }
        mv.addObject("error", errorInfo);
        
        mv.addObject("ip", request.getRemoteAddr());
        
        return mv;
    }
    
    public String getErrorPath() {
        return errorPath;
    }
    
    public Throwable getError(RequestAttributes requestAttributes) {
        Throwable exception = getAttribute(requestAttributes, ERROR_ATTRIBUTE);
        if (exception == null) {
            exception = getAttribute(requestAttributes, RequestDispatcher.ERROR_EXCEPTION/*"javax.servlet.error.exception"*/);
        }
        return exception;
    }
    
    @SuppressWarnings("unchecked")
    private <T> T getAttribute(RequestAttributes requestAttributes, String name) {
        return (T)requestAttributes.getAttribute(name, RequestAttributes.SCOPE_REQUEST);
    }
    
    public static HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer)request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE/*"javax.servlet.error.status_code"*/);
        if (statusCode == null) {
            return HttpStatus.OK;
        }
        try {
            return HttpStatus.valueOf(statusCode);
        }
        catch (Exception ex) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
    
    
    public static String getExceptionTrace(Throwable throwable) {
        
        if(throwable == null) {
            return "";
        }
        
        StringBuilder traceBuilder = new StringBuilder();
        traceBuilder.append("\tat " + throwable.getMessage()).append("\r\n");
        StackTraceElement[] trace = throwable.getStackTrace();
        for (StackTraceElement traceElement : trace) {
            traceBuilder.append("\tat " + traceElement).append("\r\n");
        }

        // Print suppressed exceptions, if any
        for (Throwable se : throwable.getSuppressed()) {
            trace = se.getStackTrace();
            for (StackTraceElement traceElement : trace) {
                traceBuilder.append("\tat " + traceElement).append("\r\n");
            }
        }
            

        // Print cause, if any
        Throwable ourCause = throwable.getCause();
        if (ourCause != null) {
            trace = ourCause.getStackTrace();
            for (StackTraceElement traceElement : trace) {
                traceBuilder.append("\tat " + traceElement).append("\r\n");
            }
        }
        return traceBuilder.toString();
    }
    
    public static String getRequestURI(HttpServletRequest request) {
        HttpStatus status = getStatus(request);
        String uri;
        if (status.value() == HttpStatus.NOT_FOUND.value()||status.value() == HttpStatus.METHOD_NOT_ALLOWED.value()) {
            uri = (String)request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI);
        }else{
            uri = request.getRequestURI();
        }
        return uri;
        
    }
    
}
