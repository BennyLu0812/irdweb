package com.ird.portal.sch.service;

import com.ird.portal.sch.data.SchCtrlDTO;

/**
 * 
 * 排程管理. 方法:獲取排程工作狀態.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 2017年11月15日<br/>
 * 
 * @author Allen
 * @version 1.0
 */
public interface ScheduleService {
    
    /**
     * 獲取沒個排程工作的狀態
     * @param schCtrlDTO
     * @return 工作狀態
     */
    String getScheduleStatus(SchCtrlDTO schCtrlDTO);
}
