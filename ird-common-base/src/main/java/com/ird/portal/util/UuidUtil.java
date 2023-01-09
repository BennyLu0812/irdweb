/**
 * @Project Name: dls-common-base
 * @File Name: UuidUtil.java
 * @Date: 04/05/2018 16:28:36
 * @Copyright: Copyright (c) 2018 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.util;

import java.util.UUID;

/**
 * UUID工具类.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 04/05/2018 16:28:36<br/>
 * @author raysely
 * @version 1.0
 */
public final class UuidUtil {
    
    /**
     * 私有构造函数.
     */
    private UuidUtil() {
    }
    
    /**
     * 生成一个UUID，32位.
     * e.g. 35244127-7730-43e8-9aa0-8630f58276a0  --> 35244127773043e89aa08630f58276a0
     * 
     * @return UUID
     */
    public static String generateUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
