package com.ird.portal.web.security.annotion;

import java.lang.annotation.*;

/**
 * @author Tim
 * @version 1.0
 * @date 18/08/2021 15:48
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface NotLogin {
}
