/**
 * @Project Name: dls-sch-core
 * @File Name: ScheduleUtils.java
 * @Date: 2017年11月16日
 * @Copyright: Copyright (c) 2017 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.sch.util;

import com.ird.portal.sch.Constants;
import com.ird.portal.sch.data.SchCtrlDTO;
import com.ird.portal.sch.exception.ScheduleException;
import com.ird.portal.sch.quartz.JobFactory;
import com.ird.portal.sch.quartz.JobSyncFactory;
import com.ird.portal.util.JsonUtil;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * 排程的工具類
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 2017年11月16日<br/>
 * 
 * @author Allen
 * @version 1.0
 */
public class ScheduleUtils {
    private static final Logger LOG = LoggerFactory.getLogger(ScheduleUtils.class);

    /**
     * 获取触发器key
     * 
     * @param jobName
     * @param jobGroup
     * @return
     */
    public static TriggerKey getTriggerKey(String jobName, String jobGroup) {
        return TriggerKey.triggerKey(jobName, jobGroup);
    }

    /**
     * 获取表达式触发器
     *
     * @param scheduler
     *            the scheduler
     * @param jobName
     *            the job name
     * @param jobGroup
     *            the job group
     * @return cron trigger
     */
    public static CronTrigger getCronTrigger(Scheduler scheduler, String jobName, String jobGroup) {

        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
            return (CronTrigger) scheduler.getTrigger(triggerKey);
        } catch (SchedulerException e) {
            LOG.error("获取定时任务CronTrigger出现异常", e);
            throw new ScheduleException("获取定时任务CronTrigger出现异常");
        }
    }
   

    /**
     * 创建任务
     *
     * @param scheduler
     *            the scheduler
     * @param scheduleJob
     *            the schedule job
     */
    public static void createScheduleJob(Scheduler scheduler, SchCtrlDTO scheduleJob) {
        createScheduleJob(scheduler, scheduleJob.getJobCode(), scheduleJob.getJobGroup(), scheduleJob.getCronChar(), scheduleJob.getIsSync(), scheduleJob);
    }

    /**
     * 创建定时任务
     *
     * @param scheduler
     *            the scheduler
     * @param jobName
     *            the job name
     * @param jobGroup
     *            the job group
     * @param cronExpression
     *            the cron expression
     * @param isSync
     *            the is sync
     * @param param
     *            the param
     */
    public static void createScheduleJob(Scheduler scheduler, String jobName, String jobGroup, String cronExpression, boolean isSync, Object param) {
        // 同步或异步 Y/N 同步/異步
        Class<? extends Job> jobClass = isSync ? JobSyncFactory.class : JobFactory.class;

        JobKey jobKey = new JobKey(jobName, jobGroup);
        try {
            scheduler.deleteJob(jobKey);
        } catch (SchedulerException e) {
//            LOG.error("刪除 jobKey:[name="+jobKey.getName()+" group="+jobKey.getGroup()+"] 錯誤.", jobKey);
			LOG.error("Delete jobKey:[name="+jobKey.getName()+" group="+jobKey.getGroup()+"] error.", jobKey);
        }
        // 构建job信息
        JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobKey).requestRecovery().build();

        // 放入参数，运行时的方法可以获取
        jobDetail.getJobDataMap().put(Constants.JOB_PARAM_KEY, JsonUtil.format(param));

        // 表达式调度构建器
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
        scheduleBuilder.withMisfireHandlingInstructionDoNothing();
        // 按新的cronExpression表达式构建一个新的trigger
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobName, jobGroup).withSchedule(scheduleBuilder).build();

        try {
            Date firstRun = scheduler.scheduleJob(jobDetail, trigger);
			LOG.info("Job [{}] schedule as [{}] and first run at {}", jobName, cronExpression, firstRun);
        } catch (SchedulerException e) {
//            LOG.error("创建定时任务失败.", e);
//            throw new ScheduleException("创建定时任务失败", e);
            LOG.error("Create schedule job fail. JobName: " + jobName, e);
            throw new ScheduleException("Create schedule job fail. JobName: " + jobName);
        }
    }

    /**
     * 运行一次任务
     * 
     * @param scheduler
     * @param jobName
     * @param jobGroup
     */
    public static void runOnce(Scheduler scheduler, String jobName, String jobGroup) {
        JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
        try {
            scheduler.triggerJob(jobKey);
			LOG.info("Job [{}] triggered(runOnce).", jobName);
        } catch (SchedulerException e) {
//            LOG.error("运行一次定时任务失败", e);
//            throw new ScheduleException("运行一次定时任务失败");
            LOG.error("Run[Once] schedule job fail. JobName: " + jobName, e);
            throw new ScheduleException("Run[Once] schedule job fail. JobName: " + jobName);
        }
    }

    /**
     * 暂停任务
     * 
     * @param scheduler
     * @param jobName
     * @param jobGroup
     */
    public static void pauseJob(Scheduler scheduler, String jobName, String jobGroup) {

        JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
        try {
            scheduler.pauseJob(jobKey);
			LOG.info("Job [{}] paused.", jobName);
        } catch (SchedulerException e) {
//            LOG.error("暂停定时任务失败", e);
//            throw new ScheduleException("暂停定时任务失败");
            LOG.error("Pause schedule job fail. JobName: " + jobName, e);
            throw new ScheduleException("Pause schedule job fail. JobName: " + jobName);
        }
    }

    /**
     * 恢复任务
     *
     * @param scheduler
     * @param jobName
     * @param jobGroup
     */
    public static void resumeJob(Scheduler scheduler, String jobName, String jobGroup) {

        JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
        try {
            scheduler.resumeJob(jobKey);
			LOG.info("Job [{}] resumed.", jobName);
        } catch (SchedulerException e) {
//            LOG.error("暂停定时任务失败", e);
//            throw new ScheduleException("暂停定时任务失败");
            LOG.error("Resume schedule job fail. JobName: " + jobName, e);
            throw new ScheduleException("Resume schedule job fail. JobName: " + jobName);
        }
    }

    /**
     * 获取jobKey
     *
     * @param jobName
     *            the job name
     * @param jobGroup
     *            the job group
     * @return the job key
     */
    public static JobKey getJobKey(String jobName, String jobGroup) {
        return JobKey.jobKey(jobName, jobGroup);
    }

    /**
     * 更新定时任务
     *
     * @param scheduler
     *            the scheduler
     * @param scheduleJob
     *            the schedule job
     */
    public static void updateScheduleJob(Scheduler scheduler, SchCtrlDTO scheduleJob) {
        updateScheduleJob(scheduler, scheduleJob.getJobCode(), scheduleJob.getJobGroup(), scheduleJob.getCronChar(), scheduleJob.getIsSync(), scheduleJob);
    }

    /**
     * 更新定时任务
     *
     * @param scheduler
     *            the scheduler
     * @param jobName
     *            the job name
     * @param jobGroup
     *            the job group
     * @param cronExpression
     *            the cron expression
     * @param isSync
     *            the is sync
     * @param param
     *            the param
     */
    public static void updateScheduleJob(Scheduler scheduler, String jobName, String jobGroup, String cronExpression, boolean isSync, Object param) {

        // 同步或异步
        // Class<? extends Job> jobClass = isSync ? JobSyncFactory.class :
        // JobFactory.class;

        try {
            // JobDetail jobDetail = scheduler.getJobDetail(getJobKey(jobName,
            // jobGroup));

            // jobDetail = jobDetail.getJobBuilder().ofType(jobClass).build();

            // 更新参数 实际测试中发现无法更新
            // JobDataMap jobDataMap = jobDetail.getJobDataMap();
            // jobDataMap.put(ScheduleJobVo.JOB_PARAM_KEY, param);
            // jobDetail.getJobBuilder().usingJobData(jobDataMap);

            TriggerKey triggerKey = ScheduleUtils.getTriggerKey(jobName, jobGroup);

            // 表达式调度构建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
            scheduleBuilder.withMisfireHandlingInstructionDoNothing();
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);

            // 按新的cronExpression表达式重新构建trigger
            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
            trigger.getJobDataMap().put(Constants.JOB_PARAM_KEY, JsonUtil.format(param));
            // 按新的trigger重新设置job执行
            Date rescheduleJob = scheduler.rescheduleJob(triggerKey, trigger);
            
            //LOG.info("rescheduleJob: {}", rescheduleJob);
			LOG.info("Job [{}] rescheduled as [{}] and first run at {}", jobName, cronExpression, rescheduleJob);
            
        } catch (SchedulerException e) {
//            LOG.error("更新定时任务失败", e);
//            throw new ScheduleException("更新定时任务失败");
			LOG.error("Update schedule job fail. JobName: " + jobName, e);
			throw new ScheduleException("Update schedule job fail. JobName: " + jobName);
        }
    }

    /**
     * 删除定时任务
     *
     * @param scheduler
     * @param jobName
     * @param jobGroup
     */
    public static void deleteScheduleJob(Scheduler scheduler, String jobName, String jobGroup) {
        try {
            scheduler.deleteJob(getJobKey(jobName, jobGroup));
			LOG.info("Job [{}] deleted.", jobName);
        } catch (SchedulerException e) {
//            LOG.error("删除定时任务失败", e);
//            throw new ScheduleException("删除定时任务失败");
			LOG.error("Delete schedule job fail. JobName: " + jobName, e);
			throw new ScheduleException("Delete schedule job fail. JobName: " + jobName);
        }
    }

    public static void createOrUpdateScheduleJob(Scheduler scheduler, SchCtrlDTO dto) throws SchedulerException {
        CronTrigger cronTrigger = ScheduleUtils.getCronTrigger(scheduler, dto.getJobCode(),dto.getJobGroup());
        
        LOG.info("scheduler.getSchedulerInstanceId(): {}", scheduler.getSchedulerInstanceId());
        
                /* dto.getJobGroup() scheduler.getSchedulerInstanceId() */
        // 不存在，创建一个
        if (cronTrigger == null) {
            ScheduleUtils.createScheduleJob(scheduler, dto);
        } else {
            // 已存在，那么更新相应的定时设置
            ScheduleUtils.updateScheduleJob(scheduler, dto);
        }
    }
}
