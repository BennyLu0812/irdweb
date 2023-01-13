/**
 * @Project Name: dls-sch-core
 * @File Name: JobSyncFactory.java
 * @Date: Nov 21, 2017
 * @Copyright: Copyright (c) 2017 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.sch.quartz;

import com.ird.portal.sch.Constants;
import com.ird.portal.sch.data.SchCtrlDTO;
import com.ird.portal.util.JsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * 执行同步任务的工厂方法，不允許并發執行
 *
 * <br/>
 * <br/>
 * <b>Date:</b> Nov 21, 2017<br/>
 * @author Allen
 * @version 1.0
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class JobSyncFactory implements Job, Serializable{

    /**  */
    private static final long serialVersionUID = 4000912310920851172L;

    private static final Logger logger = LoggerFactory.getLogger(JobSyncFactory.class);
    
    /**
     * 
     */
    @Override
    public void execute(JobExecutionContext context)
        throws JobExecutionException {
        if (logger.isDebugEnabled()) {
            logger.debug("JobSyncFactory execute...");
        }
        Object object = context.getMergedJobDataMap().get(Constants.JOB_PARAM_KEY);
        logger.info("object: {}", object);
        if (object == null || StringUtils.isBlank(object.toString())) {
            throw new IllegalStateException("job json is null");
        }
        SchCtrlDTO schCtrlDTO = JsonUtil.parse(object.toString(), SchCtrlDTO.class);
        JobFactoryProcess.execute(schCtrlDTO);
    }
    
}
