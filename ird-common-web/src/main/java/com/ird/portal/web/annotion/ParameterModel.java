/**
 * @Project Name: dls-common-web
 * @File Name: ParameterModel.java
 * @Date: 17/07/2018 17:46:34
 * @Copyright: Copyright (c) 2018 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.web.annotion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 自定义的参数装载.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 17/07/2018 17:46:34<br/>
 * @author Benny
 * @version 1.0
 */
@Target(value = ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface ParameterModel {
    
}
