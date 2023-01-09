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



@Component
public class HasPermissionProcess {
    @Autowired
    private UserDao dao;
    
    public Boolean hasPermission(String funcCode) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("funcCode", funcCode);
        params.put("userId", UserContext.getUser().getUserId());
        UserDaoCmd cmd = new UserDaoCmd(Queries.HAS_PERMISSION, params);
        BigDecimal result = dao.getSingle(cmd, BigDecimal.class);
        if(result!=null&&result.intValue()>0) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
