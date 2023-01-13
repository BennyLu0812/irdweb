package com.ird.portal.identification;

import com.ird.portal.data.BaseDTO;

/**
 * '處理關聯'接口.
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
public interface IHandleRelation<P extends BaseDTO, R extends BaseDTO> extends IParamProcess<P, R> {
    
}
