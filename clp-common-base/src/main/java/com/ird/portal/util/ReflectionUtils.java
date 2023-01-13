package com.ird.portal.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 反射工具 常使用于做抽象基類獲取泛型
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 28/06/2018 13:47:19<br/>
 * 
 * @author Keith.Chen
 * @version 1.0
 */
public class ReflectionUtils {
    
    private static final Logger logger = LoggerFactory.getLogger(ReflectionUtils.class);
    
    /**
     * 通过反射, 获得定义 Class 时声明的父类的泛型参数的类型 如: public EmployeeDao extends BaseDao<Employee, String>
     * 
     * @param clazz
     * @param index
     * @return
     */
    public static Class<?> getSuperClassGenricType(Class<?> clazz, int index) {
        Type genType = clazz.getGenericSuperclass();
        
        if (!(genType instanceof ParameterizedType)) {
            if (logger.isWarnEnabled()) {
                logger.warn(clazz.getSimpleName() + "'s superclass not ParameterizedType");
            }
            return Object.class;
        }
        
        Type[] params = ((ParameterizedType)genType).getActualTypeArguments();
        
        if (index > params.length || index < 0) {
            if (logger.isWarnEnabled()) {
                logger.warn(
                    "Index:" + index + ",Size of " + clazz.getSimpleName() + "'s Parameterized Type: " + params.length);
            }
            return Object.class;
        }
        
        if (!(params[index] instanceof Class)) {
            if (logger.isWarnEnabled()) {
                logger.warn(clazz.getSimpleName() + " not set the actual class on superclass generic parameter");
            }
            return Object.class;
        }
        
        return (Class<?>)params[index];
    }
    
    /**
     * 通过反射, 获得 Class 定义中声明的父类的泛型参数类型 如:
     * 
     * @param <T>
     * @param clazz
     * @return
     */
    public static <T> Class<T> getSuperGenericType(Class<?> clazz) {
        return (Class<T>)getSuperClassGenricType(clazz, 0);
    }
    
}
