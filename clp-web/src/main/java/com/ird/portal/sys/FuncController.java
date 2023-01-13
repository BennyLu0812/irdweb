package com.ird.portal.sys;

import com.ird.portal.audit.annotation.AuditRequest;
import com.ird.portal.common.user.data.FuncDTO;
import com.ird.portal.model.Page;
import com.ird.portal.select2.Select2Page;
import com.ird.portal.user.entity.FuncEntity;
import com.ird.portal.user.service.FuncService;
import com.ird.portal.web.security.annotion.PreAuthorize;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 
 * 功能管理.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 16/11/2017 10:33:36<br/>
 * 
 * @author Deft
 * @version 1.0
 */
@Controller
@RequestMapping("/sys/func")
public class FuncController {
    
    @Autowired
    private FuncService funcService;
    
    @PreAuthorize("hasPermission('USER-FUNC-QUERY')")
    @GetMapping(path = "/list.html")
    public String index() {
        return "sys/func/list";
    }
    
    @PreAuthorize("hasPermission('USER-FUNC-MODIFY')")
    @GetMapping(path = "/edit.html")
    public String edit(Long funcId, Model model) {
        model.addAttribute("funcId", funcId);
        return "sys/func/edit";
    }
    
    @PreAuthorize("hasPermission('USER-FUNC-QUERY')")
    @PostMapping("/page")
    @ResponseBody
    public HttpEntity<Page> getPage(@RequestBody FuncDTO dto) {
    	if(StringUtils.isNotBlank(dto.getFuncCode())){
    		dto.setFuncCode(dto.getFuncCode().trim());
    	}
    	if(StringUtils.isNotBlank(dto.getFuncDesc())){
    		dto.setFuncDesc(dto.getFuncDesc().trim());
    	}
        Page list = funcService.getPage(dto);
        return new HttpEntity<Page>(list);
    }
    
    /**
     * 查询功能名称下拉
     * @param keyword
     * @return
     */
    @GetMapping("/getFuncQuotaSelectPage")
    @ResponseBody
    public HttpEntity<Select2Page> getFuncQuotaSelectPage(String keyword,
                                                          @RequestParam(value = "pageSize", defaultValue = "30") int pageSize,
                                                          @RequestParam(value = "pageNumber", defaultValue = "1") int pageNumber) {
        Select2Page page = funcService.getFuncQuotaSelectPageData(keyword, pageSize, pageNumber);
        return new HttpEntity<Select2Page>(page);
    }
    
    @PreAuthorize("hasPermission('USER-FUNC-QUERY')")
    @PostMapping("/list")
    @ResponseBody
    public HttpEntity<Page> getList() {
        FuncDTO dto = new FuncDTO();
        Page list = funcService.getPage(dto);
        return new HttpEntity<Page>(list);
    }

    @PostMapping("/menuList")
    @ResponseBody
    public List<FuncEntity> findMenuList() {
        return funcService.findMenuList();
    }
    
    @GetMapping("/{funcId}")
    public HttpEntity<FuncEntity> getById(@PathVariable Long funcId) {
        FuncEntity entity = funcService.getById(funcId);
        return new HttpEntity<FuncEntity>(entity);
    }
    
    @AuditRequest(funcCode="USER-FUNC-ADD")
    @PreAuthorize("hasPermission('USER-FUNC-ADD')")
    @PostMapping(path = "/save")
    @ResponseStatus(code = HttpStatus.OK)
    public void save(@RequestBody FuncDTO dto) {
        funcService.add(dto);
    }
    
    @AuditRequest(funcCode="USER-FUNC-DELETE")
    @PreAuthorize("hasPermission('USER-FUNC-DELETE')")
    @DeleteMapping("/{funcId}")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@PathVariable Long funcId) {
        funcService.delete(funcId);
    }
    
    @AuditRequest(funcCode="USER-FUNC-MODIFY")
    @PreAuthorize("hasPermission('USER-FUNC-MODIFY')")
    @PutMapping("/{funcId}")
    @ResponseStatus(code = HttpStatus.OK)
    public void update(@RequestBody FuncDTO dto) {
        funcService.update(dto);
    }
    
}
