package com.ird.portal.identification.impl;

import com.ird.portal.data.BaseDTO;

/**
 * '修改狀態'業務接口.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 08/08/2018 11:25:05<br/>
 * @author Keith.Chen
 * @version 1.0
 * @param <R> 響應模型
 */
public interface AddEntityService<R extends BaseDTO> {
    
    /**
     * 處理修改狀態.
     * @param resultDTO 響應模型
     * @return boolean 處理結果
     */
    default boolean addEntity(R resultDTO) {
        return false;
    }
}
