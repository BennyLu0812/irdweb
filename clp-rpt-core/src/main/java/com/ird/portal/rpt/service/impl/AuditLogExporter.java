package com.ird.portal.rpt.service.impl;

import com.ird.portal.common.sys.data.AuditIndexDTO;
import com.ird.portal.common.sys.data.AuditMasterDTO;
import com.ird.portal.common.sys.service.AuditLogServiceApi;
import com.ird.portal.model.Page;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.*;

@Service
public class AuditLogExporter {
    
    private static final Logger logger = LoggerFactory.getLogger(AuditLogExporter.class);
    
    @Autowired
    private AuditLogServiceApi auditLogServiceApi;
    
    @Autowired
    private Configuration freemarkerConfiguration;
    
    @SuppressWarnings("unchecked")
    public void export(AuditIndexDTO auditIndexDTO, OutputStream out)
        throws Exception {
        ByteArrayOutputStream outputStream = null;
        OutputStreamWriter writer = null;
        try {
            String reportName = "/sys/audit_log_csv.ftl";
            Template template = freemarkerConfiguration.getTemplate(reportName);
            
            auditIndexDTO.setLength(10);
            int pageSize = 10;
            Page page = auditLogServiceApi.getAuditIndexPage(auditIndexDTO);
            int pages = (int)(page.getTotal() / pageSize + (page.getTotal() % pageSize > 0 ? 1 : 0));
            
            logger.info("total: {}, pages: {}", page.getTotal(), pages);
            
            Map<String, Object> dataModel = new HashMap<String, Object>();
            List<AuditMasterDTO> list = new ArrayList<>();
            for (int pageNum = 0; pageNum < pages; pageNum++) {
                logger.info("pageNum: {}", pageNum);
                auditIndexDTO.setStart(pageNum * page.getPageSize());
                auditIndexDTO.setLength(10);
                page = auditLogServiceApi.getAuditIndexPage(auditIndexDTO);
                list.addAll((Collection<? extends AuditMasterDTO>)page.getData());
            }
            
            dataModel.put("list", list);
            
            out.write(new byte[] {(byte)0xEF, (byte)0xBB, (byte)0xBF});
            writer = new OutputStreamWriter(out, "UTF-8");
            template.process(dataModel, writer);
            writer.flush();
        }
        catch (Exception e) {
            throw e;
        }
        finally {
            IOUtils.closeQuietly(outputStream);
            IOUtils.closeQuietly(writer);
        }
    }
    
}
