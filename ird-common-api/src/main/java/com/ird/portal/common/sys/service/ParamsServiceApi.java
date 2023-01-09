/**
 * @Project Name: dls-common-api
 * @File Name: ParamsServiceApi.java
 * @Date: 09/05/2018 16:33:23
 * @Copyright: Copyright (c) 2018 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.common.sys.service;

import com.ird.portal.common.sys.data.SysParamDTO;

import java.util.List;

/**
 * 系統參數服務接口.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 09/05/2018 16:33:23<br/>
 * @author raysely
 * @version 1.0
 */
public interface ParamsServiceApi {
    
    /**
     * 根據參數名稱獲取對像.
     * 
     * @param paramName 參數名稱
     * @return ParamEntity 參數實體
     */
    SysParamDTO getParamByName(String paramName);
    
    /**
     * 獲取全部參數
     * @return
     */
    List<SysParamDTO> getAllParams();

}
