package com.ird.portal.web.xss;


import com.ird.portal.common.sys.enums.YesOrNoEnum;
import com.ird.portal.util.SysParamsConstant;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by dujinkai on 2018/5/23.
 * xss 过滤器只能过滤form表单形式提交的参数
 */
public class XssFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final String xssFilterSwitch = SysParamsConstant.getParamValue("XSS_FILTER_SWITCH");
        if (xssFilterSwitch != null && xssFilterSwitch.equals(YesOrNoEnum.YES.getCode())) {
            XssHttpServletRequestWrapper xssRequest =
                    new XssHttpServletRequestWrapper((HttpServletRequest) servletRequest);
            filterChain.doFilter(xssRequest, servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}