/**
 * @Project Name: dls-sch-core
 * @File Name: JobFactory.java
 * @Date: Nov 21, 2017
 * @Copyright: Copyright (c) 2017 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.sch.quartz;

import com.ird.portal.sch.Constants;
import com.ird.portal.sch.data.SchCtrlDTO;
import com.ird.portal.util.JsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * 執行非同步任務的工廠方法,并發執行.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> Nov 21, 2017<br/>
 * 
 * @author Allen
 * @version 1.0
 */
public class JobFactory implements Job, Serializable {
    
    
    /** Field說明 */
    private static final long serialVersionUID = -279901810935563774L;
    
    private static final Logger logger = LoggerFactory.getLogger(JobFactory.class);
    
    /**
     * 
     */
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        logger.debug("JobFactory execute...");
        Object object = context.getMergedJobDataMap().get(Constants.JOB_PARAM_KEY);
        logger.info("object: {}", object);
        if (object == null || StringUtils.isBlank(object.toString())) {
            throw new IllegalStateException("job json is null");
        }
        SchCtrlDTO schCtrlDTO = JsonUtil.parse(object.toString(), SchCtrlDTO.class);
        JobFactoryProcess.execute(schCtrlDTO);
    }
    
}
