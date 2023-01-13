package com.ird.portal.sys;

import com.ird.portal.common.sys.data.SysConfigDTO;
import com.ird.portal.common.sys.data.SysProcessDTO;
import com.ird.portal.common.sys.data.SysServiceDTO;
import com.ird.portal.common.sys.data.SysServiceProcessDTO;
import com.ird.portal.datatable.DataTablePage;
import com.ird.portal.sys.service.SysServiceService;
import com.ird.portal.sys.util.AppConfigUtils;
import com.ird.portal.user.User;
import com.ird.portal.user.UserContext;
import com.ird.portal.web.security.annotion.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/sys/service")
public class SysServiceController {
    
    @Autowired
    private SysServiceService sysServiceService;

    @Autowired
    private AppConfigUtils appConfigUtils;
    
    @Value("${server.contextPath}")
    private String contextPath;
    
    @GetMapping("/getSysServiceList")
    @ResponseBody
    public HttpEntity<List<SysServiceDTO>> getSysServiceList(SysServiceDTO queryDTO) {
        return new HttpEntity<List<SysServiceDTO>>(sysServiceService.getSysServiceList(queryDTO));
    }

    @GetMapping("/getSysServiceProcessByUserId")
    @ResponseBody
    public HttpEntity<SysServiceProcessDTO> getSysServiceProcessByUserId(SysServiceDTO queryDTO) {
        User user = UserContext.getUser();
        if (user != null) {
            queryDTO.setUserId(user.getUserId());
        }
        return new HttpEntity<SysServiceProcessDTO>(sysServiceService.getSysServiceProcessByUserId(queryDTO));
    }




    @GetMapping("/getSysProcessList")
    @ResponseBody
    public HttpEntity<List<SysProcessDTO>> getSysProcessList(SysProcessDTO queryDTO) {
        return new HttpEntity<List<SysProcessDTO>>(sysServiceService.getSysProcessList(queryDTO));
    }
    
    @GetMapping("/getSysDate")
    @ResponseBody
    public HttpEntity<String> getSysDate() {
        return new HttpEntity<String>(sysServiceService.getSysDate());
    }
    
    @GetMapping("/getSysDateTime")
    @ResponseBody
    public HttpEntity<String> getSysDateTime() {
        return new HttpEntity<String>(sysServiceService.getSysDateTime());
    }

    @PreAuthorize("hasPermission('SYS-CONFIG-VIEW')")
    @GetMapping("/configList.html")
    public String configListPage() {
        return "/sys/config/configList";
    }

    /**
     * 获取系统配置
     * @return
     */
    @PreAuthorize("hasPermission('SYS-CONFIG-VIEW')")
    @GetMapping("/getConfigList")
    @ResponseBody
    public HttpEntity<DataTablePage> getConfigList() {
        DataTablePage dataTablePage = new DataTablePage(new SysConfigDTO());
        List<SysConfigDTO> list = appConfigUtils.getConfigDetail();
        // 反转list
        Collections.reverse(list);

        dataTablePage.setData(list);
        dataTablePage.setRecordsTotal(list.size());
        dataTablePage.setTotal(list.size());
        dataTablePage.setStartForm(0);
        dataTablePage.setDraw(list.size());
        return  new HttpEntity<DataTablePage>(dataTablePage);
    }
}
