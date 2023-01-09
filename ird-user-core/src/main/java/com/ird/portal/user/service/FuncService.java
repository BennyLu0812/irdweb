
package com.ird.portal.user.service;

import com.ird.portal.common.user.data.DynamicMenuDTO;
import com.ird.portal.common.user.data.FuncDTO;
import com.ird.portal.model.Page;
import com.ird.portal.select2.Select2Page;
import com.ird.portal.user.entity.FuncEntity;

import java.util.List;

/**
 * 
 * 功能信息管理的接口-查詢、新增、更新、刪除等.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 13/12/2017 10:33:40<br/>
 * 
 * @author Deft
 * @version 1.0
 */
public interface FuncService {
    
    /**
     * 查詢全部功能信息.
     * 
     * @param dto
     * @return
     */
    List<FuncDTO> findAll(FuncDTO dto);
    
    /**
     * 根據Id查詢功能信息
     * 
     * @param id
     * @return
     */
    FuncEntity getById(Long id);
    
    /**
     * 新增.
     * 
     * @param dto
     */
    void add(FuncDTO dto);
    
    /**
     * 更新.
     * 
     * @param dto
     */
    void update(FuncDTO dto);
    
    /**
     * 刪除.
     * 
     * @param id
     */
    void delete(long id);
    
    /**
     * 查詢所有父項功能.
     * 
     * @param dto
     * @return
     */
    List<FuncEntity> getTop(FuncDTO dto);
    
    /**
     * 
     * @param funcId
     * @return
     */
    List<FuncEntity> buildParent(Long funcId);
    
    /**
     * 分頁查詢.
     * 
     * @param dto
     * @return
     */
    Page getPage(FuncDTO dto);
    
    /**
     * 根據功能代碼查詢.
     * 
     * @param funcCode
     * @return
     */
    FuncEntity getFuncByFuncCode(String funcCode);

    List<FuncEntity> getFuncByIds(Long[] funcIds);
    
    Page getRptPreviledgePage(FuncDTO dto);


    Select2Page getFuncQuotaSelectPageData(String keyword, int pageSize, int pageNumber);

    /**
     * 根據用戶ID查詢用戶功能
     * @param userId 用戶ID
     * @return
     */
    List<FuncDTO> findFuncByUser(String userId);


    /**
     * 根據用戶ID和查詢用戶功能
     * @param userId 用戶ID
     * @param centerId 驗車中心ID
     * @return
     */
    List<FuncDTO> findFuncByUser(String userId, Integer centerId);

    DynamicMenuDTO generateDynamicMenuDTO(List<FuncDTO> funcDTOList);

    /**
     * 查詢所有用戶菜單和功能
     * @return
     */
    List<FuncDTO> findAllMenuFunc();

    /**
     * 查詢所有菜單
     * @return
     */
    List<FuncEntity> findMenuList();
}
