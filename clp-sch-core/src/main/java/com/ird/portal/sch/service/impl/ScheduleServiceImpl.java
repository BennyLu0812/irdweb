/**
 * @Project Name: dls-sch-core
 * @File Name: ScheduleServiceImpl.java
 * @Date: Nov 21, 2017
 * @Copyright: Copyright (c) 2017 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.sch.service.impl;

import com.ird.portal.sch.Constants;
import com.ird.portal.sch.data.SchCtrlDTO;
import com.ird.portal.sch.service.ScheduleService;
import com.ird.portal.sch.util.ScheduleUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 排程管理.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> Nov 21, 2017<br/>
 * 
 * @author Allen
 * @version 1.0
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {
    
    private static final Logger log = LoggerFactory.getLogger(ScheduleServiceImpl.class);
    
    @Autowired
    private Scheduler scheduler;
    
    @Override
    public String getScheduleStatus(SchCtrlDTO schCtrlDTO) {
        String jobGroup = Constants.JOB_GROUP;
        JobKey jobKey = ScheduleUtils.getJobKey(schCtrlDTO.getJobCode(), jobGroup);
        List<? extends Trigger> triggers;
        try {
            triggers = scheduler.getTriggersOfJob(jobKey);
            if (CollectionUtils.isEmpty(triggers)) {
                return Trigger.TriggerState.NONE.name();
            }
            // 这里一个任务可以有多个触发器， 但是我们一个任务对应一个触发器，所以只取第一个即可，清晰明了
            Trigger trigger = triggers.iterator().next();

            Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
            return triggerState.name();
        }
        catch (SchedulerException e) {
            log.error("get the job name :"+ schCtrlDTO.getJobCode() +"  status error.", e);
        }
        return Trigger.TriggerState.NONE.name();
    }
    
}
