package com.ird.portal.web.annotion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * SpTransaction 業務列表展示.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 20/09/2018 16:40:08<br/>
 * @author Keith.Chen
 * @version 1.0
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface SpBusinessListStep {
    
}
