
package com.ird.portal.fds.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ServiceFeeCategory\u7684 Java \u7c7b\u3002
 * 
 * <p>\u4ee5\u4e0b\u6a21\u5f0f\u7247\u6bb5\u6307\u5b9a\u5305\u542b\u5728\u6b64\u7c7b\u4e2d\u7684\u9884\u671f\u5185\u5bb9\u3002
 * <p>
 * <pre>
 * &lt;simpleType name="ServiceFeeCategory"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="NORMAL"/&gt;
 *     &lt;enumeration value="RUNTIME"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ServiceFeeCategory")
@XmlEnum
public enum ServiceFeeCategory {

    NORMAL,
    RUNTIME;

    public String value() {
        return name();
    }

    public static ServiceFeeCategory fromValue(String v) {
        return valueOf(v);
    }

}
