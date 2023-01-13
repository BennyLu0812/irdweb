package com.ird.portal.sys.mapper;

import com.ird.portal.sys.dao.SysDao;
import com.ird.portal.sys.dao.SysDaoCmd;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class IDCardMapper {
    @Autowired
    private SysDao dao;
    
    public String getSpIDType(String nationalCode) {
        if(StringUtils.isNotBlank(nationalCode)) {
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("nationalCode",nationalCode);        
            SysDaoCmd sysDaoCmd = new SysDaoCmd("getSpIDTypeByNationalCode", paramMap);
            return dao.getSingle(sysDaoCmd, String.class);
        }
        return null;                  
    }
    
}
