/**
 * @Project Name: dls-web
 * @File Name: IpAddressUtil.java
 * @Date: 2018年4月24日
 * @Copyright: Copyright (c) 2018 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.user.util;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * <br/>
 * <br/>
 * <b>Date:</b>2018年4月24日<br/>
 * @author linwood
 * @version 1.0
 */
public class IpAddressUtil {

	/**
     * 获取真實Ip地址
     * @param request
     * @return
     */
    public static String getIpAddress(HttpServletRequest request) {
        String xip = request.getHeader("X-Real-IP");
        String xfor = request.getHeader("X-Forwarded-For");
        if(StringUtils.isNotEmpty(xfor) && !"unKnown".equalsIgnoreCase(xfor)){
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = xfor.indexOf(",");
            if(index != -1){
                return xfor.substring(0,index);
            }else{
                return xfor;
            }
        }
        xfor = xip;
        if(StringUtils.isNotEmpty(xfor) && !"unKnown".equalsIgnoreCase(xfor)){
            return xfor;
        }
        if (StringUtils.isBlank(xfor) || "unknown".equalsIgnoreCase(xfor)) {
        	xfor = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(xfor) || "unknown".equalsIgnoreCase(xfor)) {
        	xfor = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(xfor) || "unknown".equalsIgnoreCase(xfor)) {
        	xfor = request.getHeader("HTTP_CLIENT_IP");
        }
        if (StringUtils.isBlank(xfor) || "unknown".equalsIgnoreCase(xfor)) {
        	xfor = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (StringUtils.isBlank(xfor) || "unknown".equalsIgnoreCase(xfor)) {
        	xfor = request.getRemoteAddr();
        }
        return xfor;
    }
}
