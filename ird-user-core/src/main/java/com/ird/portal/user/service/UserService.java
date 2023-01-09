package com.ird.portal.user.service;

import com.ird.portal.common.user.data.UserDTO;
import com.ird.portal.model.Page;
import com.ird.portal.select2.Select2Page;
import com.ird.portal.user.entity.UserEntity;

import java.util.List;

public interface UserService {
    
    /**
     * 新增用戶記錄.
     * 
     * @param dto
     */
    void add(UserDTO dto);
    
    /**
     * 更新用戶記錄.
     * 
     * @param dto
     */
    void update(UserDTO dto);
    
    /**
     * 刪除用戶記錄.
     * 
     * @param id
     */
    void delete(String id);
    
    /**
     * 分頁查詢.
     * 
     * @param dto
     * @return 用戶記錄列表
     */
    Page getPage(UserDTO dto);

    UserEntity getById(String userId);

    Select2Page getUserNameQuotaSelectPage(String keyword, int pageSize, int pageNumber);

    /**
     * 根據funcCode拿到對應下的用戶下拉列表
     * @param keyword
     * @param pageSize
     * @param pageNumber
     * @param funcList
     * @param excludeUsers
     */
    Select2Page getAuthorizedBatchPrintUsers(String keyword, int pageSize, int pageNumber, List<String> funcList, List<String> excludeUsers);


    /**
 　　* @description: 根据查询账号密码用户
 　　* @return
 　　* @throws
 　　* @author Vincent
 　　* @date 2021/9/22 10:45
 　　*/
    UserEntity getUser(String userId,String password);

     /**
 　　* @description: 修改用户

 　　* @return
 　　* @throws
 　　* @author Vincent
 　　* @date 2021/11/18 16:45
 　　*/
    void updatePwd(UserEntity userEntity);

}
