package com.ird.portal.web.security.annotion;

import java.lang.annotation.*;

/**
 * 對外API的登錄驗證
 * @author Zack
 * @version 1.0
 * @date 08/11/2021 15:25
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface NeedApiLogin {
}
