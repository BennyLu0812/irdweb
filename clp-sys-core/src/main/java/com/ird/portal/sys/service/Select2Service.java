package com.ird.portal.sys.service;
/**
 *
 * select2查询
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 22/12/2017 13:19:22<br/>
 * @author Allen
 * @version 1.0
 */

import com.ird.portal.common.sys.data.Select2DTO;
import com.ird.portal.select2.Select2Page;

import java.util.List;
import java.util.Map;

public interface Select2Service {

    /**
     * 無分頁的查詢
     * @param codeType
     * @param keyword
     * @return
     */
    List<Select2DTO> selectSysCodeData(String codeType,String keyword);

    /**
     * 無分頁的外國駕照編號查詢
     * @param spNo
     * @param keyword
     * @return
     */
    List<Select2DTO> getForeignLicNoBySpNo(String spNo, String keyword);

    /**
     *
     * @param keyword
     * @return
     */
    Select2Page getLicNoList(String licType, String licStatus, String keyword, int pageSize, int pageNumber);

    /**
     * 分頁的查詢
     * @param paramDTO
     * @param pageSize
     * @param pageNumber
     * @return
     */
    Select2Page selectSysCodeData(Map<String, Object> params, int pageSize, int pageNumber);

    /**
     *
     * @param params
     * @param pageSize
     * @param pageNumber
     * @return
     */
    Select2Page selectLocation(Map<String, Object> params, int pageSize, int pageNumber);

    /**
     *
     * @param params
     * @param pageSize
     * @param pageNumber
     * @return
     */
    Select2Page selectStreet(Map<String, Object> params, int pageSize, int pageNumber);

    /**
     *
     * @param params
     * @param pageSize
     * @param pageNumber
     * @return
     */
    Select2Page selectBuilding(Map<String, Object> params, int pageSize, int pageNumber);

    /**
     *
     * @param codeType
     * @return
     */
    List<Select2DTO> selectCodeByType(String codeType);

    /**
     *
     * @param codeType
     */
    List<Select2DTO> updateRedisCodeByType(String codeType);

    /**
     * 無分頁的查詢,查询出的数据用于回显
     * @param codeType
     * @param keyword
     * @return
     */
    List<Select2DTO> selectSysCodeData4show(String codeType,String keyword);


    /**
     *
     * @param params
     * @param pageSize
     * @param pageNumber
     * @return
     */
    Select2Page selectForeignLicType(Map<String, Object> params, int pageSize, int pageNumber);

    /**
     * 獲取申請人界面的證件類別 31001 50062  50069 50084
     * @return
     */
    List<String> getIdentTypeSysCode();

    /**
     *獲取申請人界面的語言 60104
     */
    List<String> getLangSysCode();

    /**
     * 獲取預約方式 911001
     * @return
     */
    List<Map<String, Object>> getBookingType();
}
