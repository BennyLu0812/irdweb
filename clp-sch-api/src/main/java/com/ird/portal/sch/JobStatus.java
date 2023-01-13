package com.ird.portal.sch;

/**
 * Title: Job的狀態.<br/>
 * Description: <br/>
 * Date: 15/04/2016 1:37:57 PM<br/>
 *
 * @author Jim
 * @version 1.0
 * @since JDK1.8
 */
public enum JobStatus {
    /**
     * 处理中.
     */
    PROGRESS,
    /**
     * 完成.
     */
    COMPLETE,
    /**
     * 失败.
     */
    FAILED
}
