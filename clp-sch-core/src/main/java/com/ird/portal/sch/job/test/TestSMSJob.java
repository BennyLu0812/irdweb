package com.ird.portal.sch.job.test;

import com.ird.portal.exception.SysException;
import com.ird.portal.sch.BatchResult;
import com.ird.portal.sch.JobStatus;
import com.ird.portal.sch.Task;
import com.ird.portal.sch.data.SchCtrlDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/*
* 測試定時任務.
* */
@Component
public class TestSMSJob implements Task {

    private static final Logger logger = LoggerFactory.getLogger(TestSMSJob.class);

    @Override
    public BatchResult execute(SchCtrlDTO context) throws Exception {

        BatchResult batchResult = new BatchResult();

        try {

            String cronDate = context.getCronDate();
            logger.info("===before executing===");

            System.out.println("getDataCentreId="+context.getDataCentreId());
            batchResult.setStatus(JobStatus.PROGRESS);

            System.out.println("test SMSJob");
            int count = 1;

            batchResult.setCountProcess(count);
            batchResult.setStatus(JobStatus.COMPLETE);

            logger.info("===after executing===");
        }
        catch (Exception e) {
            e.printStackTrace();
            batchResult.setStatus(JobStatus.FAILED);
            batchResult.setException(new SysException(e.getMessage()));
        }

        return batchResult;
    }
}
