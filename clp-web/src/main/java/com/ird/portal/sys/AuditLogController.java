package com.ird.portal.sys;

import com.ird.portal.common.sys.data.AuditDetailDTO;
import com.ird.portal.common.sys.data.AuditIndexDTO;
import com.ird.portal.model.Page;
import com.ird.portal.rpt.service.impl.AuditLogExporter;
import com.ird.portal.sys.service.AuditDetailService;
import com.ird.portal.sys.service.AuditMasterService;
import com.ird.portal.web.security.annotion.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

@Controller
@RequestMapping("/sys/auditlog")
public class AuditLogController {
    
	@Autowired
    AuditLogExporter auditLogExporter ;
	
	@Autowired
	private AuditMasterService auditMasterService;

	@Autowired
	private AuditDetailService auditDetailService;
    
    /**
     * 跳轉list頁面.
     * 
     * @return 返回字符串
     */
	@PreAuthorize("hasPermission('SYS-AUDITLOG-QUERY')")
    @GetMapping(path = "/auditLogList.html")
    public String auditLogList() {
        return "/sys/auditLog/auditLogList";
    }
	
	@PreAuthorize("hasPermission('SYS-AUDITLOG-VIEW')")
	@GetMapping(path = "/auditDetailList.html")
	public String detail(Model model, @RequestParam Long auditMasterId) {
	    model.addAttribute("auditMasterId", auditMasterId);
		return "/sys/auditLog/auditDetailList";
	}

	@PostMapping("/getAuditIndexPage")
	@ResponseBody
	public HttpEntity<Page> getAuditIndexPage(@RequestBody AuditIndexDTO dto) {
		Page page = auditMasterService.getAuditIndexPage(dto);
		return new HttpEntity<Page>(page);
	}

	@PostMapping("/getAuditDetailPage")
	@ResponseBody
	public HttpEntity<Page> getAuditDetailPage(@RequestBody AuditDetailDTO dto) {
		Page page = auditDetailService.getAuditDetailPage(dto);
		return new HttpEntity<Page>(page);
	}
	 
	@PreAuthorize("hasPermission('SYS-AUDITLOG-QUERY')")
    @GetMapping(path = "/auditLogListPage.html")
    public String auditLogListPage(AuditIndexDTO auditIndex, Model model) {
	    model.addAttribute("auditIndex", auditIndex);
        return "/sys/auditLog/auditLogListPage";
    }
	
	/**
     * 審計日誌導出 
     */
    @PreAuthorize("hasPermission('SYS-AUDITLOG-EXPORT')")
    @PostMapping("/export")
    public void export(@RequestBody AuditIndexDTO indexDTO, HttpServletResponse response) throws Exception {
        OutputStream out = response.getOutputStream();
        auditLogExporter.export(indexDTO, out);
    }

	@RequestMapping("/index.html")
	public String index(){
		return "/index";
	}
}
