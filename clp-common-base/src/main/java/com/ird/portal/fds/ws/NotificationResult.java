
package com.ird.portal.fds.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>NotificationResult\u7684 Java \u7c7b\u3002
 * 
 * <p>\u4ee5\u4e0b\u6a21\u5f0f\u7247\u6bb5\u6307\u5b9a\u5305\u542b\u5728\u6b64\u7c7b\u4e2d\u7684\u9884\u671f\u5185\u5bb9\u3002
 * <p>
 * <pre>
 * &lt;simpleType name="NotificationResult"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="FRESH"/&gt;
 *     &lt;enumeration value="PROCEEDING"/&gt;
 *     &lt;enumeration value="SUCCESS"/&gt;
 *     &lt;enumeration value="FAILED"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "NotificationResult")
@XmlEnum
public enum NotificationResult {

    FRESH,
    PROCEEDING,
    SUCCESS,
    FAILED;

    public String value() {
        return name();
    }

    public static NotificationResult fromValue(String v) {
        return valueOf(v);
    }

}
