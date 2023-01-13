/**
 * @Project Name: clp-web
 * @File Name: JobCtrlLogController.java
 * @Date: Nov 17, 2017
 * @Copyright: Copyright (c) 2017 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.sch.controller;

import com.ird.portal.model.Page;
import com.ird.portal.sch.data.SchCtrlDTO;
import com.ird.portal.sch.service.JobCtrlLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 排程日志管理.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> Nov 17, 2017<br/>
 * 
 * @author Allen
 * @version 1.0
 */
@Controller
@RequestMapping("/sch/ctrl/log")
public class SchCtrlLogController {
    
    
    @Autowired
    private JobCtrlLogService jobCtrlLogService;
    
    @GetMapping(path = "/log_list.html")
    public String index() {
        return "sch/log_list";
    }
    
    @PostMapping("/list")
    @ResponseBody
    public HttpEntity<Page> getPage(@RequestBody SchCtrlDTO schCtrlDTO) {
        Page list = jobCtrlLogService.getPage(schCtrlDTO);
        return new HttpEntity<Page>(list);
    }
    
    @PostMapping("/by/jobCtrlId")
    @ResponseBody
    public HttpEntity<Page> getPageByJobCtrlId(@RequestBody SchCtrlDTO schCtrlDTO) {
        Page list = jobCtrlLogService.getJobCtrlLogPageByJobCtrlId(schCtrlDTO);
        return new HttpEntity<Page>(list);
    }
    
}
