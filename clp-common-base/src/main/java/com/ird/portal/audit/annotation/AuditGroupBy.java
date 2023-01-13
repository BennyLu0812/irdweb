/**
 * @Project Name: dsat-common
 * @File Name: AuditGroupBy.java
 * @Date: 2017年5月17日 下午4:21:40
 * @Copyright: Copyright (c) 2017 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.audit.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Title: 對屬性值進行歸類 類似SQL的 group by功能.<br/>
 * Description: <br/>
 * Date: 2017年5月17日 下午4:21:40<br/>
 *
 * @author Jim
 * @version 1.0
 * @since JDK1.8
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface AuditGroupBy {

}
