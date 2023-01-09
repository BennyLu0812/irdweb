package com.ird.portal.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Title: 獲取IP.<br/>
 * Description: <br/>
 * Date: Aug 20, 2016 2:52:00 PM<br/>
 *
 * @author Jim
 * @version 1.0
 * @since JDK1.8
 */
public class IPUtils {
    private static final Logger logger = LoggerFactory.getLogger(IPUtils.class);

    public static String getIpAddr(HttpServletRequest request) {
        if (request == null) {
            logger.error("request is null.");
            return null;
        }
        String ip = request.getHeader("X-FORWARDED-FOR");
        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip.equalsIgnoreCase("0:0:0:0:0:0:0:1")) {
            InetAddress inetAddress = null;
            try {
                inetAddress = InetAddress.getLocalHost();
                ip = inetAddress.getHostAddress();
            } catch (UnknownHostException e) {
                logger.error("get client ip exception.", e);
            }
        }
        return ip;
    }

    public static String getHostName() {
        try {
            InetAddress ia = InetAddress.getByName("127.0.0.1");
            return ia.getHostName();
        } catch (UnknownHostException e) {
            return null;
        }
    }
    
    public static String getIpAddress() {
        try {
            InetAddress address = InetAddress.getLocalHost();
            String hostAddress = address.getHostAddress();
            return hostAddress;
        }
        catch (UnknownHostException e) {
            return null;
        }
    }

    public static boolean ipExistsIn24Mask(String ip, String networkSegment) {
        String[] ipArray = ip.trim().split("\\.");
        String[] networkSegmentArray = networkSegment.trim().split("\\.");
        int index = 0;
        for(String part: networkSegmentArray) {
            if (!part.trim().equals(ipArray[index].trim())) {
                break;
            }
            index++;
        }
        return index > 2;
    }

}
