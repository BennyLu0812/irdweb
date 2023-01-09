package com.ird.portal.web.annotion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * SpTransaction 業務界面保存步驟切面
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 02/08/2018 10:11:13<br/>
 * @author Keith.Chen
 * @version 1.0
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface SpTransactionSaveStep {
    
    boolean enableSaveExamDetail() default true;
    
    boolean enableSaveSpTransaction() default true;
    
    boolean enableSaveExamRemark() default true;
}
