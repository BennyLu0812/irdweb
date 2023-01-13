package com.ird.portal.util;

import java.lang.annotation.Annotation;

/**
 * 註解類工具.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 16/10/2018 09:55:09<br/>
 * @author Keith.Chen
 * @version 1.0
 */
public final class AnnotationUtil {
    private AnnotationUtil() { }
    
    /**
     * 根據註解類型在註解數組中獲取具體對象.
     * @param annotations 註解數組
     * @param annotationCls 需要的註解類型
     * @param <T> 返回類型
     * @return <T> 結果對象
     */
    @SuppressWarnings("unchecked")
    public static <T extends Annotation> T getAnnotationByType(Annotation[] annotations, Class<T> annotationCls) {
        for (Annotation annotation : annotations) {
            if (annotation.annotationType().isAssignableFrom(annotationCls)) {
                return (T) annotation;
            }
        }
        return null;
    }
}
