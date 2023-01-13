package com.ird.portal.web.annotion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * Annotation to indicate that the annotated method is one of the SpTransaction method
 * CREATE, TERMINATE, COMPLETE, CANCEL
 * @author atos.dchu
 *
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface SpTransaction {
    
}
