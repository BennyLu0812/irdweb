
package com.ird.portal.fds.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>WorkflowStage\u7684 Java \u7c7b\u3002
 * 
 * <p>\u4ee5\u4e0b\u6a21\u5f0f\u7247\u6bb5\u6307\u5b9a\u5305\u542b\u5728\u6b64\u7c7b\u4e2d\u7684\u9884\u671f\u5185\u5bb9\u3002
 * <p>
 * <pre>
 * &lt;simpleType name="WorkflowStage"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="FRONTEND_PROCEEDING_CHECK_STAGE"/&gt;
 *     &lt;enumeration value="RECEIVED_CHECK_STAGE"/&gt;
 *     &lt;enumeration value="CANCELLED_CHECK_STAGE"/&gt;
 *     &lt;enumeration value="FINISHED_CHECK_STAGE"/&gt;
 *     &lt;enumeration value="FRONTEND_PROCEEDING"/&gt;
 *     &lt;enumeration value="RECEIVED"/&gt;
 *     &lt;enumeration value="CANCELLED"/&gt;
 *     &lt;enumeration value="BACKEND_PROCEEDING"/&gt;
 *     &lt;enumeration value="FINISHED"/&gt;
 *     &lt;enumeration value="LICENSE_READY"/&gt;
 *     &lt;enumeration value="LICENSE_ISSUEING"/&gt;
 *     &lt;enumeration value="LICENSE_PICKED"/&gt;
 *     &lt;enumeration value="TASK_COMPLETED"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "WorkflowStage")
@XmlEnum
public enum WorkflowStage {

    FRONTEND_PROCEEDING_CHECK_STAGE,
    RECEIVED_CHECK_STAGE,
    CANCELLED_CHECK_STAGE,
    FINISHED_CHECK_STAGE,
    FRONTEND_PROCEEDING,
    RECEIVED,
    CANCELLED,
    BACKEND_PROCEEDING,
    FINISHED,
    LICENSE_READY,
    LICENSE_ISSUEING,
    LICENSE_PICKED,
    TASK_COMPLETED;

    public String value() {
        return name();
    }

    public static WorkflowStage fromValue(String v) {
        return valueOf(v);
    }

}
