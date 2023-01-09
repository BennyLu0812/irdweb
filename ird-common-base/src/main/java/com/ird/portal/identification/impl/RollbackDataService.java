package com.ird.portal.identification.impl;

import com.ird.portal.data.BaseDTO;

/**
 * '數據回滾'業務接口.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 08/08/2018 11:25:05<br/>
 * @author Keith.Chen
 * @version 1.0
 * @param <R> 響應模型
 */
public interface RollbackDataService<R extends BaseDTO> {
    
    /**
     * 處理數據回滾.
     * @param resultDTO 響應模型
     * @return boolean 處理結果
     */
    default boolean handleDataRollback(R resultDTO) {
        return false;
    }
}
