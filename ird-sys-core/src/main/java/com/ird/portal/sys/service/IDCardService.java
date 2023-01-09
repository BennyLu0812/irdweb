package com.ird.portal.sys.service;


public interface IDCardService {

    /**
     * 根據國籍編號查詢spId類型
     * @param nationalCode
     * @return
     */
    String getSpIDType(String nationalCode);


    
}
