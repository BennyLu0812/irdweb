package com.ird.portal.common.rpt.data;

import com.alibaba.excel.annotation.ExcelProperty;

import java.math.BigDecimal;

/**
 * @author Tim
 * @version 1.0
 * @date 07/02/2022 11:14
 */
public class MotorcycleIdleInspDataStatisticsPO extends BenExhaustStatisticsPO {

    /**
     * 怠速CO測量值[%]
     */
    @ExcelProperty("怠速CO測量值[%]")
    private BigDecimal ddCoIdle;

    /**
     * 怠速HC測量值[ppm]
     */
    @ExcelProperty("怠速HC測量值[ppm]")
    private BigDecimal ddHcIdle;

    /**
     * D項目檢驗的縂判定結果
     */
    @ExcelProperty("判定結果")
    private String ddOverallResult;

    public BigDecimal getDdCoIdle() {
        return ddCoIdle;
    }

    public void setDdCoIdle(BigDecimal ddCoIdle) {
        this.ddCoIdle = ddCoIdle;
    }

    public BigDecimal getDdHcIdle() {
        return ddHcIdle;
    }

    public void setDdHcIdle(BigDecimal ddHcIdle) {
        this.ddHcIdle = ddHcIdle;
    }

    public String getDdOverallResult() {
        return ddOverallResult;
    }

    public void setDdOverallResult(String ddOverallResult) {
        this.ddOverallResult = ddOverallResult;
    }

    @Override
    public String toString() {
        return "MotorcycleIdleInspDataStatisticsPO{" +
                "ddCoIdle=" + ddCoIdle +
                ", ddHcIdle=" + ddHcIdle +
                ", ddOverallResult='" + ddOverallResult + '\'' +
                '}';
    }
}
