package com.ird.portal.util;

import java.util.Collection;
import java.util.Objects;

import org.apache.commons.lang3.ArrayUtils;

/**
 * 對象工具.
 * 
 * <br/>
 * <br/>
 * <b>Date:</b> 29/09/2018 10:43:36<br/>
 * @author Keith.Chen
 * @version 1.0
 */
public final class ObjectUtil {
   
    /** 封閉工具類實例化入口 */
    private ObjectUtil() { }
    
    /**
     * 對象是否為空 .
     * @param target 目标对象
     * @return 判断值
     */
    public static boolean isEmpty(Object target) {
        if (Objects.isNull(target)) {
            return true;
        }
        if (target instanceof Collection) {
            return ((Collection<?>) target).isEmpty();
        } else if (target.getClass().isArray()) {
            Object[] temp = (Object[]) target;
            return ArrayUtils.isEmpty(temp);
        }
        return true;
    }
    
}
