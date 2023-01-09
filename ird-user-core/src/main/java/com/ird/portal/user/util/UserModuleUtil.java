package com.ird.portal.user.util;

import com.ird.portal.user.entity.FuncEntity;
import com.ird.portal.user.entity.RoleEntity;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * @author Steven
 */
@SuppressWarnings("rawtypes")
public final class UserModuleUtil {
    /**
     * Stores the class name for debugging purpose.
     */
    private static final String CLASS_NAME = UserModuleUtil.class.getName();

    /**
     * 判断元素element是否是sourceList列表中的一个子元素
     * @param sourceList 源列表
     * @param element 待判断的包含元素
     * @return 包含返回 true，不包含返回 false
     */
    public static boolean myFuncListContains(List<FuncEntity> sourceList, FuncEntity element) {
        if (CollectionUtils.isEmpty(sourceList) || element == null){
            return false;
        }
        if (sourceList.isEmpty()){
            return false;
        }
        for (FuncEntity funcEntity : sourceList){
            if(element.getFuncId().longValue() == funcEntity.getFuncId().longValue()){
                return true;
            }
        }
        return false;
    }

    /**
     * 判断元素element是否是sourceList列表中的一个子元素
     * @param sourceList 源列表
     * @param element 待判断的包含元素
     * @return 包含返回 true，不包含返回 false
     */
    public static boolean myRoleListContains(List<RoleEntity> sourceList, RoleEntity element) {
        if (CollectionUtils.isEmpty(sourceList) || element == null){
            return false;
        }
        if (sourceList.isEmpty()){
            return false;
        }
        for (RoleEntity roleEntity : sourceList){
            if(element.getRoleId().longValue() == roleEntity.getRoleId().longValue()){
                return true;
            }
        }
        return false;
    }

}