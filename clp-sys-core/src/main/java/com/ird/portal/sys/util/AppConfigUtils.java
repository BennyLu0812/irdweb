package com.ird.portal.sys.util;

import com.ird.portal.common.sys.data.SysConfigDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @Author: kent long
 * @Date: 2019/3/7 下午 12:57
 */

@Component
public class AppConfigUtils {
    @Autowired
    private ConfigurableEnvironment environment;
    public List<SysConfigDTO> getConfigDetail() {
        List<SysConfigDTO> list = new ArrayList<>();
        MutablePropertySources propertySources = environment.getPropertySources();
        for (PropertySource prop: propertySources) {
            if (StringUtils.startsWith(prop.getName(),"applicationConfig")) {
                SysConfigDTO sysConfigDTO = new SysConfigDTO();
                sysConfigDTO.setProfileName(prop.getName());
                sysConfigDTO.setMap((Map<String, Object>)prop.getSource());
                list.add(sysConfigDTO);
            }
        }
        //添加當前locale進入list
        Locale locale = LocaleContextHolder.getLocale();
        if (locale == null) {
            locale = Locale.TRADITIONAL_CHINESE;
        }
        SysConfigDTO localeDTO = new SysConfigDTO();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("locale",locale);
        localeDTO.setProfileName("LOCALE");
        localeDTO.setMap(map);
        list.add(localeDTO);
        return list;
    }

}
