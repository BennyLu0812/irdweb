package com.ird.portal.sys;

import com.ird.portal.audit.annotation.AuditRequest;
import com.ird.portal.common.sys.data.SysParamDTO;
import com.ird.portal.common.sys.enums.YesOrNoEnum;
import com.ird.portal.model.Page;
import com.ird.portal.sys.entity.ParamsEntity;
import com.ird.portal.sys.service.ParamsService;
import com.ird.portal.util.SysParamsConstant;
import com.ird.portal.web.security.annotion.PreAuthorize;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 参数管理.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 16/11/2017 10:33:36<br/>
 * 
 * @author Deft
 * @version 1.0
 */
@Controller
@RequestMapping("sys/params")
public class ParamsController {
    
    @Autowired
    private ParamsService sysParamService;

    
    @PreAuthorize("hasPermission('SYS-PARAMS-VIEW')")
    @GetMapping(path = "/list.html")
    public String index() {
        return "sys/params/list";
    }

    @GetMapping(path = "/dashboard.html")
    public String dashboard(Model model) {
        // 獲取是否使用舊工控參數
        String paramValue = SysParamsConstant.getParamValue("IS_USE_OLD_INDUSTRIAL_CONTROL");
        model.addAttribute("isUseOldIndustrialControl",
                StringUtils.isNotBlank(paramValue) && YesOrNoEnum.YES.getCode().equals(paramValue));
        return "sys/params/dashboard";
    }
    
    @PreAuthorize("hasPermission('SYS-PARAMS-UPDATE')")
    @GetMapping(path = "/edit.html")
    public String edit(String paramName, Model model) {
        model.addAttribute("paramName", paramName);
        return "sys/params/edit";
    }

    @GetMapping(path = "/operationCodes.html")
    public String operationCodes() {
        return "sys/params/operationCodes";
    }




    @PostMapping("/list")
    @ResponseBody
    public HttpEntity<Page> getPage(@RequestBody SysParamDTO sysParamDto) {
        Page list = sysParamService.getPage(sysParamDto);
        return new HttpEntity<Page>(list);
    }
    
    @GetMapping("/{name}")
    public HttpEntity<ParamsEntity> getById(@PathVariable String name) {
        ParamsEntity entity = sysParamService.getByName(name);
        return new HttpEntity<ParamsEntity>(entity);
    }

    /**
     * 修改系統參數
     * @param entity
     */
    @AuditRequest(funcCode = "SYS-PARAMS-UPDATE")
    @PreAuthorize("hasPermission('SYS-PARAMS-UPDATE')")
    @PutMapping("/{paramName}")
    @ResponseStatus(code = HttpStatus.OK)
    public void update(@RequestBody ParamsEntity entity) {
        sysParamService.update(entity);        
    }

    /**
     * 重載redis的值
     */
    @GetMapping("/reloadSysParamCache")
    @ResponseStatus(code = HttpStatus.OK)
    public void reloadSysParamCache() {
        sysParamService.reloadSysParams();
    }



    @GetMapping("/sysParamsContrast.html")
    public String getSysParamsContrast(){
        return "sys/params/sysParamsContrast";
    }

    /**
     * 系統參數的對比界面（DB讀出來的與REDIS中的做對比）
     * @return
     */
    @GetMapping("/getSysParamsContrast")
    @PreAuthorize("hasPermission('SYS-PARAMS-COMPARE')")
    @ResponseBody
    public List<SysParamDTO> getSysParamsContrastList(){
        List<SysParamDTO> resultList = new ArrayList<>();
        List<SysParamDTO> list = sysParamService.getAllParams();
        Map<String,String> map = SysParamsConstant.getParams();
        //map為redis中的值, dateMap 為數據庫裡面的值
        //list 轉map
        Map<String,String> dateMap = new HashMap<>();
        for(SysParamDTO dto : list){
            dateMap.put(dto.getParamName(),dto.getParamValue());
        }
        //循環數據庫中的數據
        for(SysParamDTO dto : list){
            if(map.containsKey(dto.getParamName())){
                if(!dto.getParamValue().equals(map.get(dto.getParamName()))){
                    dto.setParamName(dto.getParamName());
                    dto.setParamValue(dto.getParamValue());
                    dto.setRedisParamValue(map.get(dto.getParamName()));
                    dto.setParamDesc("ehcahe中的值和數據庫中的值不同");
                    resultList.add(dto);
                    map.remove(dto.getParamName());
                }
            }else{
                dto.setParamName(dto.getParamName());
                dto.setParamValue(dto.getParamValue());
                dto.setParamDesc("存在數據庫中,不存在ehcahe中");
                resultList.add(dto);
            }
        }
        //循環redis中的數據
        for(Map.Entry<String, String> e : map.entrySet()){
            SysParamDTO dto = new SysParamDTO();
            //判斷數據庫中是否存在該值
            if(dateMap.containsKey(e.getKey())){
                //判斷數據庫中的值是否和redis中的值相同
                if(!dateMap.get(e.getKey()).equals(e.getValue())){
                    dto.setParamName(e.getKey());
                    dto.setParamValue(dateMap.get(e.getKey()));
                    dto.setRedisParamValue(e.getValue());
                    dto.setParamDesc("數據庫中的值和ehcahe中的值不同");
                    resultList.add(dto);
                }
            }else{
                dto.setParamName(e.getKey());
                dto.setRedisParamValue(e.getValue());
                dto.setParamDesc("存在ehcahe中,不存在數據庫中");
                resultList.add(dto);
            }
        }
        return resultList;
    }
}
