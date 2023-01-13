package com.ird.portal.sys;

import com.ird.portal.common.user.data.ModuleDTO;
import com.ird.portal.model.Page;
import com.ird.portal.user.entity.ModuleEntity;
import com.ird.portal.user.service.ModuleService;
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
@RequestMapping("sys/module")
public class ModuleController {
    
    @Autowired
    private ModuleService moduleService;
    
    @GetMapping(path = "/list.html")
    public String index() {
        return "sys/module/list";
    }
    
    @GetMapping(path = "/edit.html")
    public String edit(Long moduleId, Model model) {
        model.addAttribute("moduleId", moduleId);
        return "sys/module/edit";
    }
    
    @PostMapping("/page")
    @ResponseBody
    public HttpEntity<Page> getPage(@RequestBody ModuleDTO dto) {
        Page list = moduleService.getPage(dto);
        return new HttpEntity<Page>(list);
    }
    
    @PostMapping("/list")
    public HttpEntity<List<ModuleEntity>> getList() {
        List<ModuleEntity> list = moduleService.getList(new ModuleDTO());
        return new HttpEntity<List<ModuleEntity>>(list);
    }
    
    @GetMapping("/{id}")
    public HttpEntity<ModuleEntity> getById(@PathVariable Long moduleId) {
        ModuleEntity entity = moduleService.getById(moduleId);
        return new HttpEntity<ModuleEntity>(entity);
    }
    
    @PostMapping(path = "")
    @ResponseStatus(code = HttpStatus.OK)
    public void save(@RequestBody ModuleDTO dto) {
        moduleService.add(dto);
    }
    
    @DeleteMapping("/{moduleId}")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@PathVariable Long moduleId) {
        moduleService.delete(moduleId);
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void update(@RequestBody ModuleDTO dto) {
        moduleService.update(dto);
    }
    
}
