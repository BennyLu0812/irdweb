package com.ird.portal.common.sys.service;

import com.ird.portal.common.sys.data.SysUrlDTO;

/**
 * 系統URL的對外服務接口
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 23/06/2018 15:37:40<br/>
 * @author: Crystal Zhao
 * @version 1.0
 */
public interface SysUrlServiceApi {
	
    public SysUrlDTO getSysStartUrlByProcessIdAndStageId(String spNo, Integer processId, Integer stageId);
    
}
