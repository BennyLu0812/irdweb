package com.ird.portal.sys.service;

import com.ird.portal.common.sys.data.AuditIndexDTO;
import com.ird.portal.model.Page;

/**
 * 
 * 系統代碼日志接口的相關服務接口
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 03/05/2018 15:36:03<br/>
 * 
 * @author georgia
 * @version 1.0
 */
public interface AuditMasterService {

	/**
	 * 分頁查詢列表
	 * 
	 * @param codeMasterDTO:
	 *            包含所有查詢條件
	 * @return
	 */
	Page getAuditIndexPage(AuditIndexDTO auditIndexDTO);

}
