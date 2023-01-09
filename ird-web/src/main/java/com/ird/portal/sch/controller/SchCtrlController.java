package com.ird.portal.sch.controller;

import com.ird.portal.audit.annotation.AuditRequest;
import com.ird.portal.model.Page;
import com.ird.portal.sch.data.SchCtrlDTO;
import com.ird.portal.sch.entity.SchCtrlEntity;
import com.ird.portal.sch.service.JobCtrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 
 * 排程管理.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 07/12/2017 17:47:35<br/>
 * 
 * @author Allen
 * @version 1.0
 */
@Controller
@RequestMapping("/sch/ctrl")
public class SchCtrlController {
    
    @Autowired
    private JobCtrlService jobCtrlService;
    
    @GetMapping(path = "/list.html")
    public String index() {
        return "sch/list";
    }
    
    @GetMapping(path = "/edit.html")
    public String edit(Long id, Model model) {
        model.addAttribute("id", id);
        return "sch/edit";
    }
    
    @GetMapping(path = "/sch_detail.html")
    public String detail(Long id, Model model) {
        model.addAttribute("id", id);
        return "sch/job_detail";
    }
    
    @PostMapping(path = "/list")
    @ResponseBody
    public HttpEntity<Page> getPage(@RequestBody SchCtrlDTO schCtrlDTO) {
        Page list = jobCtrlService.getPage(schCtrlDTO);
        return new HttpEntity<Page>(list);
    }
    
    @PostMapping(path = "")
    @ResponseStatus(code = HttpStatus.OK)
    @AuditRequest(funcCode="ADD-SCH-CTRL")
    public void save(@RequestBody SchCtrlEntity schCtrlEntity) {
        jobCtrlService.add(schCtrlEntity);
    }
    
    @GetMapping("/{id}")
    public HttpEntity<SchCtrlEntity> getById(@PathVariable Long id) {
        SchCtrlEntity entity = jobCtrlService.getById(id);
        return new HttpEntity<SchCtrlEntity>(entity);
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    @AuditRequest(funcCode="UPDATE-SCH-CTRL")
    public void update(@RequestBody SchCtrlEntity entity) {
        jobCtrlService.update(entity);
    }
    
    @PutMapping("/pause/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    @AuditRequest(funcCode="PAUSE-SCH-CTRL")
    public void pause(@PathVariable Long id) {
        jobCtrlService.pause(id);
    }
    
    @PutMapping("/start/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    @AuditRequest(funcCode="START-SCH-CTRL")
    public void start(@PathVariable Long id) {
        jobCtrlService.start(id);
    }
    
    @PutMapping("/restart/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    @AuditRequest(funcCode="RESTART-SCH-CTRL")
    public void restart(@PathVariable Long id) {
        jobCtrlService.restart(id);
    }
    
    @PutMapping("/resume/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void resume(@PathVariable Long id) {
        jobCtrlService.resume(id);
    }
    
    @PutMapping("/runOnce/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    @AuditRequest(funcCode="RUN-ONCE-SCH-CTRL")
    public void runOnce(@PathVariable Long id) {
        jobCtrlService.runOnce(id);
    }    
}
