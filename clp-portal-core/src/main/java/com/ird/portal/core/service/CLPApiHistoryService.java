package com.ird.portal.core.service;

import com.ird.portal.common.api.data.APIRequestDTO;
import com.ird.portal.common.api.data.APIResponseDTO;
import com.ird.portal.common.api.data.CLPApiHistoryDTO;
import com.ird.portal.model.Page;
import com.ird.portal.select2.Select2Page;

/**
 * @version 1.0
 * @description:
 * @DATE: 2023/1/16
 * @author: Benny
 */
public interface CLPApiHistoryService {

    /**
     * 分頁查詢.
     * @param dto 考試管理dto
     * @return 考试管理表DTO
     * */
    Page getPage(APIRequestDTO dto);


    /**
     * 獲取數據通過id.
     * @param apiHistoryId id
     * @return
     */
    CLPApiHistoryDTO getApiHistoryDTOById(String apiHistoryId);

    /**
     * 保存api history info.
     * @param clpApiHistoryDTO history info
     * @return
     */
    CLPApiHistoryDTO doSave(CLPApiHistoryDTO clpApiHistoryDTO);

    /**
     * 調用接口。
     * @param apiRequestDTO
     * @return
     */
    APIResponseDTO doTriggerAPI(APIRequestDTO apiRequestDTO);

    /**
     * 將系統參數值作為下拉框（用逗號當分隔符）。
     * @param keyword 查詢值
     * @param pageSize pageSize
     * @param pageNumber pageNumber
     * @return
     */
    Select2Page getSystemParamSelectPage(String keyword, int pageSize, int pageNumber);



}
