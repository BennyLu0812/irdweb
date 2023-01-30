package com.ird.portal.core.service;

import com.ird.portal.common.api.data.APIRequestDTO;
import com.ird.portal.model.Page;

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


}
