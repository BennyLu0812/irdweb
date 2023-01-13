package com.ird.portal.sys;

import com.ird.portal.common.sys.data.CodeMasterDTO;
import com.ird.portal.model.Page;
import com.ird.portal.sys.service.CodeMasterService;
import com.ird.portal.web.security.annotion.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sys/codeMaster")
public class CodeMasterController {
    
    @Autowired
    private CodeMasterService codeMasterService;
    
    @PreAuthorize("hasPermission('SYS-CODE-MASTER-VIEW')")
    @GetMapping(path = "/list.html")
    public String index() {
        return "sys/codeMaster/list";
    }
    
//    @GetMapping(path = "/edit.html")
//    public String edit(Integer codeId, Model model) {
//        model.addAttribute("codeId", codeId);
//        return "sys/codeMaster/edit";
//    }
    
    @PostMapping("/list")
    @ResponseBody
    public HttpEntity<Page> getPage(@RequestBody CodeMasterDTO codeMasterDto) {
        Page list = codeMasterService.getPage(codeMasterDto);
        return new HttpEntity<Page>(list);
    }
    
//    @GetMapping("/{id}")
//    public HttpEntity<CodeMasterEntity> getById(@PathVariable Integer id) {
//        CodeMasterEntity entity = codeMasterService.getById(id);
//        return new HttpEntity<CodeMasterEntity>(entity);
//    }
    
    
//    @PutMapping(path = "/{id}")
//    @ResponseStatus(code = HttpStatus.OK)
//    public void update(@RequestBody CodeMasterEntity entity) {
//        codeMasterService.update(entity);
//    }
}
