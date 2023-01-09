/**
 * @Project Name: dls-common-api-test
 * @File Name: TestCase.java
 * @Date: 25/12/2017 17:27:22
 * @Copyright: Copyright (c) 2017 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.test;

import com.ird.portal.audit.AuditContext;
import com.ird.portal.user.AnonymousUser;
import com.ird.portal.user.User;
import com.ird.portal.user.UserContext;
import org.junit.After;
import org.junit.Before;

/**
 * Test Case的測試類的基礎類，所有方法都需要繼承此類，實現 setUp() 和 tearDown().
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 25/12/2017 17:27:22<br/>
 * 
 * @author Jim
 * @version 1.0
 */
public abstract class TestCase {
    
    /**
     * 做一些前提條件的設置/預設值等操作.
     */
    @Before
    public void setUp() {
        boolean isAudited = true;
        User user = new AnonymousUser();
        UserContext.setUser(user);
        AuditContext auditContext = AuditContext.getInstance();
        auditContext.setUserId(user.getUserId());
        auditContext.setFuncCode("TEST_CASE");
        auditContext.setIsAudited(isAudited);
        
    }
    
    /**
     * 釋放資源、刪除文件、回滾數據等操作.
     */
    @After
    public void tearDown() {
        UserContext.removeUser();
        AuditContext.getInstance().remove();
    }
}
