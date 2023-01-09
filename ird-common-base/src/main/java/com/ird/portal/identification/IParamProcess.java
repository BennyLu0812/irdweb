package com.ird.portal.identification;

import com.ird.portal.data.BaseDTO;

/**
 * 進程參數接口.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 07/08/2018 17:39:15<br/>
 * 
 * @author Keith.Chen
 * @version 1.0
 * 
 * @param <P> 參數對象
 * @param <R> 回傳對象
 */
public interface IParamProcess<P extends BaseDTO, R extends BaseDTO> {
    
    /**
     * DO PROCESS NEED PARAMS.
     * 
     * @param paramDTO 初始參數對象
     * @return R 響應參數對象
     */
    R processCommonParam(P paramDTO);
}
