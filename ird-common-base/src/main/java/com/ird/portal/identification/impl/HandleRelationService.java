package com.ird.portal.identification.impl;

import com.ird.portal.data.BaseDTO;

/**
 * '處理關聯'-操作者接口.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 08/08/2018 16:59:15<br/>
 * 
 * @author Keith.Chen
 * @version 1.0
 * @param <P> 參數對象
 * @param <R> 回傳對象
 */
public interface HandleRelationService<R extends BaseDTO> {
    
    /**
     * 處理關聯實體.
     * @param resultDTO 響應模型
     * @return boolean 處理結果
     */
    default boolean updateRelationEntity(R resultDTO) {
        return false;
    }
}
