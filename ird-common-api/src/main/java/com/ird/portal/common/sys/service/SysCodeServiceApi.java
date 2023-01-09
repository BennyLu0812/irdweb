/**
 * @Project Name: dls-common-api
 * @File Name: ParamsServiceApi.java
 * @Date: 09/05/2018 16:33:23
 * @Copyright: Copyright (c) 2018 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.common.sys.service;

import com.ird.portal.common.sys.data.CodeDTO;
import java.util.List;
import java.util.Map;

/**
 * 系統代碼的對外服務接口
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 23/06/2018 15:37:40<br/>
 * @author: Crystal Zhao
 * @version 1.0
 */
public interface SysCodeServiceApi {

    public Map<String, CodeDTO> getCodesInMap(Integer codeType);
    
    public CodeDTO getCodeByTypeAndCode(Integer codeType, String codeKey);

    @Deprecated
    List<CodeDTO> listVssSysCodeByCodeType(Integer codeType);

    /**
     * 根據codeType批量獲取sysCode
     * @param codeTypes
     * @return
     */
    Map<Integer, List<CodeDTO>> batchGetSysCodeMapByCodeTypes(List<Integer> codeTypes);
}
