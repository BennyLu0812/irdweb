/**
 * @Project Name: atos-web
 * @File Name: ExceptionRestResponseHandler.java
 * @Package Name: net.atos
 * @Date: 2017年9月11日 上午11:32:30
 * @Copyright: Copyright (c) 2017 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.web.error;


import com.ird.portal.exception.*;
import com.ird.portal.user.UserAccessResourceContext;
import com.ird.portal.util.JsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.TransactionException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * 对系统定义了的异常进行抓捕，只对Controller层.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 19/12/2017 22:51:13<br/>
 *
 * @author Jim
 * @version 1.0
 */
@ControllerAdvice
public class ExceptionRestResponseHandler {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionRestResponseHandler.class);

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView exceptionServerError(
            HttpServletRequest request, HttpServletResponse response, Throwable throwable)
            throws Exception {

        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorInfo.setPath(ErrorRestResponseController.getRequestURI(request));
        errorInfo.setSysErrorMsg(ErrorRestResponseController.getExceptionTrace(throwable));

        if (throwable instanceof BaseException) {
            BaseException exception = (BaseException)throwable;
            errorInfo.setErrorCode(exception.getErrorCode());
            errorInfo.setArguments(exception.getArguments());
            errorInfo
                    .setErrorMsg(ErrorMessageHelper.getErrorMsgByCode(exception.getErrorCode(), exception.getArguments()));

            logger.info("erorrCode: {}, errorMsg: {}", errorInfo.getErrorCode(), errorInfo.getErrorMsg());
        } else if (throwable instanceof MissingServletRequestParameterException) {
            MissingServletRequestParameterException exception = (MissingServletRequestParameterException)throwable;
            errorInfo.setErrorCode(ParameterIsEmptyException.ERROR_CODE);
            errorInfo.setErrorMsg(ErrorMessageHelper.getErrorMessageWithCode(ParameterIsEmptyException.ERROR_CODE, exception.getParameterName()));
        }  else if (throwable instanceof TransactionException) {
            errorInfo.setErrorCode(DatabaseException.ERROR_DATABASE);
            errorInfo.setErrorMsg(ErrorMessageHelper.getErrorMsgByCode(DatabaseException.ERROR_DATABASE));
        } else {
            errorInfo.setErrorCode(BaseException.ERROR_UNKNOWN);
            errorInfo.setErrorMsg(ErrorMessageHelper.getErrorMsgByCode(BaseException.ERROR_UNKNOWN));
        }

        logger.error("error:\r\n{}", ExceptionUtils.getStackTrace(throwable));

        // ajax
        if (StringUtils.equalsIgnoreCase("XMLHttpRequest", request.getHeader("X-Requested-With"))) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=UTF-8");

            String result = JsonUtil.format(errorInfo);
            logger.info(result);


            response.getWriter().write(result);


            return null;
        }

        // text/htmlmj
        ModelAndView mv = new ModelAndView();
        mv.setViewName(ErrorRestResponseController.ERROR_SERVICE_EXCEPTION);
        mv.addObject("error", errorInfo);
        mv.addObject("ip", request.getRemoteAddr());

        return mv;
    }

    @ExceptionHandler(value = AuthorizationException.class)
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public ModelAndView exceptionNoAuth(HttpServletRequest request, HttpServletResponse response, AuthorizationException authorizationException) throws Exception {

        ErrorInfo errorInfo = new ErrorInfo().setStatus(HttpStatus.FORBIDDEN.value());
        errorInfo.setPath(ErrorRestResponseController.getRequestURI(request));
        errorInfo.setSysErrorMsg(UserAccessResourceContext.get());
        errorInfo.setErrorCode(authorizationException.getErrorCode());
        errorInfo.setArguments(authorizationException.getArguments());
        errorInfo.setErrorMsg(ErrorMessageHelper.getErrorMsgByCode(authorizationException.getErrorCode(), authorizationException.getArguments()));
        logger.error("erorrCode: {}, errorMsg: {}", errorInfo.getErrorCode(), errorInfo.getErrorMsg());


        // ajax
        if (StringUtils.equalsIgnoreCase("XMLHttpRequest", request.getHeader("X-Requested-With"))) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=UTF-8");
            String result = JsonUtil.format(errorInfo);
            logger.info(result);
            response.getWriter().write(result);
            return null;
        }

        // text/htmlmj
        ModelAndView mv = new ModelAndView();
        mv.setViewName(ErrorRestResponseController.ERROR_NO_AUTH);
        mv.addObject("authorizeExpression", UserAccessResourceContext.get());
        mv.addObject("error", errorInfo);
        mv.addObject("ip", request.getRemoteAddr());
        return mv;
    }


    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
    public ErrorInfo exceptionMethodNotAllowed(
            HttpServletRequest request, HttpRequestMethodNotSupportedException exception) {
        logger.info("method not allowed error:\r\n{}", ExceptionUtils.getStackTrace(exception));

        return new ErrorInfo().setStatus(HttpStatus.METHOD_NOT_ALLOWED.value())
                // .setErrorCode(exception.getErrorCode())
                // .setErrorMsg(ErrorMessageHelper.getErrorMsgByCode(exception.getErrorCode()))
                .setPath(ErrorRestResponseController.getRequestURI(request))
                .setSysErrorMsg(ErrorRestResponseController.getExceptionTrace(exception));

    }

}
