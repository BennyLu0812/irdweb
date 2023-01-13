/**
 * @Project Name: dls-sch-api
 * @File Name: JobType.java
 * @Date: 2017年10月31日 下午12:10:26
 * @Copyright: Copyright (c) 2017 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.sch;

/**
 * Title: Job的類型.<br/>
 * Description: <br/>
 * Date: 2017年10月31日 下午12:10:26<br/>
 *
 * @author Jim
 * @version 1.0
 * @since JDK1.8
 */
public enum JobType {
    /**
     * 觸發器.
     */
    TRIGGER("TRIGGER"),
    
    /**
     * JAVA程序代碼.
     */
    JAVA("JAVA"),
    
    /**
     * PLSQL 編寫.
     */
    PLSQL("PLSQL"),
    
    /**
     * JAVA程序代碼，但是不需要系統記錄日誌的.此類型需要自己記錄job的日誌.
     */
    JAVA_NOLOG("JAVA_NOLOG");
    
    
    private String type;
    private JobType(String type) {
        this.type = type;
    }
   
    public String getType() {
        return type;
    }
}
