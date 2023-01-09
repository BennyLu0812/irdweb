package com.ird.portal.sch;

import com.ird.portal.exception.BaseException;

/**
 * Title: 執行批量任務的返回結果.<br/>
 * Description: <br/>
 * Date: 20/04/2016 10:10:47 AM<br/>
 *
 * @author Jim
 * @version 1.0
 * @since JDK1.8
 */
public class BatchResult {
    /** 剩餘處理記錄數 */
    private int pendingTotal;
    /** 總處理記錄數 */
    private int countProcess;
    /** 新增記錄數 */
    private int countInsert;
    /** 更新記錄數 */
    private int countUpdate;
    /** 刪除記錄數 */
    private int countDelete;
    /** 工作狀態 (PROGRESS –> COMPLETE/FAILED) */
    private JobStatus status = JobStatus.PROGRESS;
    /** 異常 */
    private BaseException exception;

    public BatchResult() {}

    public BatchResult(int pendingTotal, int countProcess, int countInsert, int countUpdate, int countDelete) {
        this.pendingTotal = pendingTotal;
        this.countProcess = countProcess;
        this.countInsert = countInsert;
        this.countUpdate = countUpdate;
        this.countDelete = countDelete;
    }

    public int getPendingTotal() {
        return pendingTotal;
    }

    public void setPendingTotal(int pendingTotal) {
        this.pendingTotal = pendingTotal;
    }

    public int getCountUpdate() {
        return countUpdate;
    }

    public void setCountUpdate(int countUpdate) {
        this.countUpdate = countUpdate;
    }

    public int getCountProcess() {
        return countProcess;
    }

    public void setCountProcess(int countProcess) {
        this.countProcess = countProcess;
    }

    public int getCountInsert() {
        return countInsert;
    }

    public void setCountInsert(int countInsert) {
        this.countInsert = countInsert;
    }

    public int getCountDelete() {
        return countDelete;
    }

    public void setCountDelete(int countDelete) {
        this.countDelete = countDelete;
    }

    public JobStatus getStatus() {
        return status;
    }

    public void setStatus(JobStatus status) {
        this.status = status;
    }

    public BaseException getException() {
        return exception;
    }

    public void setException(BaseException exception) {
        this.exception = exception;
    }

    @Override
    public String toString() {
        return "BatchResult{" +
                "pendingTotal=" + pendingTotal +
                ", countProcess=" + countProcess +
                ", countInsert=" + countInsert +
                ", countUpdate=" + countUpdate +
                ", countDelete=" + countDelete +
                ", status=" + status +
                ", exception=" + exception +
                '}';
    }


    public BatchResult insertResult(Integer insertNum){
        countInsert = countInsert + insertNum;
        pendingTotal = pendingTotal - insertNum;
        countProcess = countProcess + insertNum;
        return this;
    }

    public BatchResult updateResult(Integer updateNum){
        countUpdate = countUpdate + updateNum;
        pendingTotal = pendingTotal - updateNum;
        countProcess = countProcess + updateNum;
        return this;
    }

    public BatchResult deleteResult(Integer deleteNum){
        countDelete = countDelete + deleteNum;
        pendingTotal = pendingTotal - deleteNum;
        countProcess = countProcess + deleteNum;
        return this;
    }
}
