package com.ird.portal.common.sys.data;


import com.ird.portal.data.BaseDTO;

import java.util.Map;

/**
 * @Author: kent long
 * @Date: 2019/3/8 下午 10:28
 */
public class SysConfigDTO extends BaseDTO {
    private String profileName;
    private Map<String,Object> map;

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
