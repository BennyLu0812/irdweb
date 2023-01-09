/**
 * @Project Name: dls-common-web
 * @File Name: ResourcesInitializer.java
 * @Date: 16/05/2018 17:03:03
 * @Copyright: Copyright (c) 2018 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.web.Initializer;

import com.ird.portal.common.sys.data.SysParamDTO;
import com.ird.portal.common.sys.service.ParamsServiceApi;
import com.ird.portal.util.SysParamsConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系統資源初始化.
 * 用于在系統起動時初始化一些常用數據.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 16/05/2018 17:03:03<br/>
 * @author raysely
 * @version 1.0
 */
@Component
public class ResourcesInitializer implements CommandLineRunner {
    
    /**
     * LOG.
     */
    private static final  Logger LOG = LoggerFactory.getLogger(ResourcesInitializer.class);
    
    /**
     * 系統參數服務.
     */
    @Autowired
    private ParamsServiceApi paramsService;

    @Autowired
    @Qualifier("thymeleafViewResolver")
    private ThymeleafViewResolver thymeleafViewResolver;

    @Value("${weblogic.webPrefix}")
    private String webPrefix;


    @Override
    public void run(String... args) throws Exception {

        systemParameter();
        initConfigureViewResolvers();
    }

    private void systemParameter(){
        LOG.info(" >>>>>>>>>>>>>>> System resource init :Start Initialize system parameters to Redis。");
        final long start = System.currentTimeMillis();
        List<SysParamDTO> list  = paramsService.getAllParams();
        Map<String, String> params = new HashMap<String, String>();
        for (SysParamDTO dto:list) {
            params.put(dto.getParamName(),dto.getParamValue());
        }
        SysParamsConstant.setParam(params);
        LOG.info(">>>>>>>>>>>>>>> System resource init: End Initialize system parameters to Redis。Date： {} ms。", System.currentTimeMillis() - start);
    }


    /**
     * @description: 初始化项目前缀升级配置
     * @param
     * @return java.lang.String
     * @author Vincent
     * @throws
     * @date 2021/2/19 18:00
     */
    public void initConfigureViewResolvers() {
        LOG.info(" >>>>>>>>>>>>>>> System resource init :Start Initialize system parameters to Prefix update config。");
        final long start = System.currentTimeMillis();
        if (thymeleafViewResolver != null) {
            Map<String, Object> map = new HashMap<>();
            map.put("webPrefix", webPrefix);
            thymeleafViewResolver.setStaticVariables(map);
        }
        LOG.info("weblogic update config param:{}", webPrefix);
        LOG.info(">>>>>>>>>>>>>>> System resource init: End Initialize system parameters to Prefix update config： {} ms。", System.currentTimeMillis() - start);

    }




}
