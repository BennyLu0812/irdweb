package com.ird.portal.sys.mapper;

import com.ird.portal.sys.dao.SysDao;
import com.ird.portal.sys.dao.SysDaoCmd;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Tim
 * @version 1.0
 * @date 21/10/2021 16:13
 */
@Repository
public class SpDateprofileMapper {

    private final SysDao dao;

    public SpDateprofileMapper(SysDao dao) {
        this.dao = dao;
    }

    /**
     * 判断是否假期日期
     * @param date 日期
     * @return 是假期则返回日期字符串反正返回null
     */
    public String getHoliday(Date date) {
        Map<String, Object> params = new HashMap<>(1);
        params.put("dateValue", date);
        SysDaoCmd cmd = new SysDaoCmd("getHoliday", params);
        return dao.getSingle(cmd, String.class, true);
    }
}
