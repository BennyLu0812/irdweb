package com.ird.portal.rpt;

import com.ird.portal.common.rpt.data.RptMasterDTO;
import com.ird.portal.common.user.data.FuncDTO;
import com.ird.portal.model.Page;
import com.ird.portal.rpt.entity.RptMasterEntity;
import com.ird.portal.rpt.service.RptMasterService;
import com.ird.portal.user.service.FuncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * 報表管理
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 23/07/2018 16:13:34<br/>
 * @author Joe
 * @version 1.0
 */
@Controller
@RequestMapping("/rpt/master")
public class RptMasterController {
    
    @Autowired
    private RptMasterService rptMasterService;
    
    @Autowired
    private FuncService funcservice;
    
    @GetMapping("/list.html")
    public String index() {
       
        return "rpt/list";
    }
    
    @GetMapping("/rpt_master_info.html")
    public String info(String rptId , ModelMap model) {
        model.put("rptId", rptId);
        return "rpt/rptMasterInfo";
    }
    
    @GetMapping("/rpt_previledge.html")
    public String previledge(String rptPreviledge , ModelMap model) {
        model.put("rptPreviledge", rptPreviledge);
        return "rpt/rptPreviledge";
    }
    /**
     * rptMaster的datatable
     * @param rptMasterDTO
     * @return
     */
    @PostMapping("/data")
    @ResponseBody
    public HttpEntity<Page> getPage(@RequestBody RptMasterDTO rptMasterDTO) {
        Page list = rptMasterService.getPage(rptMasterDTO);
        return new HttpEntity<Page>(list);
    }
    
    @PostMapping("/getRptPreviledgePage")
    @ResponseBody
    public HttpEntity<Page> getRptPreviledgePage(@RequestBody FuncDTO functDTO) {
        String[] codes = functDTO.getFuncCode().split(",");
        functDTO.setFuncCodes(codes);
        Page list = funcservice.getRptPreviledgePage(functDTO);
        return new HttpEntity<Page>(list);
    }
    
    @GetMapping("/getRptMasterByRptId")
    public HttpEntity<RptMasterEntity> getRptMasterByRptId(String rptId ){
        RptMasterEntity rptMasterEntity = rptMasterService.getById(rptId);
        return new HttpEntity<RptMasterEntity>(rptMasterEntity);
    }
    
}
