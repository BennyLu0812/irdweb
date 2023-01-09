package com.ird.portal.user.process.authorize;

import com.ird.portal.user.UserContext;
import com.ird.portal.user.dao.Queries;
import com.ird.portal.user.dao.UserDao;
import com.ird.portal.user.dao.UserDaoCmd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


/**
 * 
 * 
 * 查詢該用戶是否包含該角色.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 18/12/2017 17:49:17<br/>
 * @author Deft
 * @version 1.0
 */
@Component
public class HasAnyRoleProcess {
    @Autowired
    private UserDao dao;
    
    public Boolean hasAnyRole(String[] roles) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("roles", roles);
        params.put("userId", UserContext.getUser().getUserId());
        UserDaoCmd cmd = new UserDaoCmd(Queries.HAS_ANY_ROLE, params);
        BigDecimal result = dao.getSingle(cmd, BigDecimal.class);
        
        if(result!=null&&result.intValue()>0) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
