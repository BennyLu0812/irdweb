package com.ird.portal.sch;

import com.ird.portal.sch.data.SchCtrlDTO;

/**
 * Title: 定時任務的接口,所有定時任務都需要實現此接口.<br/>
 * Description: <br/>
 * Date: 15/04/2016 2:10:21 PM<br/>
 *
 * @author Jim
 * @version 1.0
 * @since JDK1.8
 */
public interface Task {

    /**
     * 執行定時任務.
     * 
     * @param context
     *            該任務在當前執行縣城中的上下文信息.
     * 
     * @return BatchResult
     * @throws Exception
     */
    BatchResult execute(SchCtrlDTO context) throws Exception;
}
