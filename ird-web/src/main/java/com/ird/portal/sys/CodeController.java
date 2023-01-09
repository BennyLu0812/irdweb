package com.ird.portal.sys;

import com.ird.portal.audit.annotation.AuditRequest;
import com.ird.portal.common.sys.data.CodeDTO;
import com.ird.portal.common.sys.enums.SysCodeStatus;
import com.ird.portal.model.Page;
import com.ird.portal.sys.entity.CodeEntity;
import com.ird.portal.sys.service.CodeService;
import com.ird.portal.web.security.annotion.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 
 * 系統代碼管理.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 16/11/2017 09:55:10<br/>
 * 
 * @author Deft
 * @version 1.0
 */
@Controller
@RequestMapping("/sys/code")
public class CodeController {
    
    @Autowired
    private CodeService codeService;
    
    @PreAuthorize("hasPermission('SYS-CODE-VIEW')")
    @GetMapping(path = "/list.html")
    public String index(CodeDTO codeDto, Model model) {
        model.addAttribute("codeType", codeDto.getCodeType());
        model.addAttribute("codeCname", codeDto.getCodeCname());
        model.addAttribute("codePname", codeDto.getCodePname());
        model.addAttribute("codeKey", codeDto.getCodeKey());
        return "sys/code/list";
    }

    @PreAuthorize("hasPermission('SYS-CODE-UPD')")
    @GetMapping(path = "/edit.html")
    public String edit(CodeDTO codeDto,Model model) {
        model.addAttribute("codeId", codeDto.getCodeId());
        model.addAttribute("codeType", codeDto.getCodeType());
        model.addAttribute("codeCname", codeDto.getCodeCname());
        model.addAttribute("codePname", codeDto.getCodePname());
        return "sys/code/edit";
    }

    @PreAuthorize("hasPermission('SYS-CODE-VIEW')")
    @GetMapping(path = "/detail.html")
    public String detail(CodeDTO codeDto,Model model) {
        model.addAttribute("codeId", codeDto.getCodeId());
        model.addAttribute("codeType", codeDto.getCodeType());
        model.addAttribute("codeCname", codeDto.getCodeCname());
        model.addAttribute("codePname", codeDto.getCodePname());
        return "sys/code/detail";
    }

    @PreAuthorize("hasPermission('SYS-CODE-VIEW')")
    @PostMapping("/list")
    @ResponseBody
    public HttpEntity<Page> getPage(@RequestBody CodeDTO codeDto) {
        Page list = codeService.getPage(codeDto);
        return new HttpEntity<Page>(list);
    }

    @PreAuthorize("hasPermission('SYS-CODE-VIEW')")
    @GetMapping("/{id}")
    public HttpEntity<CodeEntity> getById(@PathVariable Integer id) {
        CodeEntity entity = codeService.getById(id);
        return new HttpEntity<CodeEntity>(entity);
    }

    @PreAuthorize("hasPermission('SYS-CODE-ADD')")
    @AuditRequest(funcCode="SYS-CODE-ADD")
    @PostMapping(path = "")
    @ResponseStatus(code = HttpStatus.OK)
    public void save(@RequestBody CodeEntity entity) {
        codeService.CodeTypeOnlyProcess(entity);
        codeService.add(entity);
    }

    @PreAuthorize("hasPermission('SYS-CODE-UPD')")
    @AuditRequest(funcCode="SYS-CODE-UPD")
    @PutMapping(path = "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void update(@RequestBody CodeEntity entity) {
        codeService.CodeTypeOnlyProcess(entity);
        codeService.update(entity);
    }

    @PreAuthorize("hasPermission('SYS-CODE-REACTIVE')")
    @AuditRequest(funcCode="SYS-CODE-REACTIVE")
    @PostMapping(path = "/reactivate/{codeId}")
    @ResponseStatus(code = HttpStatus.OK)
    public void reactivate(@PathVariable Integer codeId) {
        codeService.UpdateCodesStatus(codeId, SysCodeStatus.INVALID.getCode(), SysCodeStatus.ACTIVE.getCode());
    }

    @PreAuthorize("hasPermission('SYS-CODE-CANCEL')")
    @AuditRequest(funcCode="SYS-CODE-CANCEL")
    @PostMapping(path = "/cancelStatus/{codeId}")
    @ResponseStatus(code = HttpStatus.OK)
    public void cancelStatus(@PathVariable Integer codeId) {
        codeService.UpdateCodesStatus(codeId, SysCodeStatus.ACTIVE.getCode(), SysCodeStatus.INVALID.getCode());
    }
}
