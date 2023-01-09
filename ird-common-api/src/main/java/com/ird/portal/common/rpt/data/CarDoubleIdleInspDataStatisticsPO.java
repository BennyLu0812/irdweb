package com.ird.portal.common.rpt.data;

import com.alibaba.excel.annotation.ExcelProperty;

import java.math.BigDecimal;

/**
 * @author Tim
 * @version 1.0
 * @date 07/02/2022 11:21
 */
public class CarDoubleIdleInspDataStatisticsPO extends BenExhaustStatisticsPO {

    /**
     * 怠速CO測量值[%]
     */
    @ExcelProperty("怠速CO測量值[%]")
    private BigDecimal bbCoIdle;

    /**
     * 怠速HC測量值[ppm]
     */
    @ExcelProperty("怠速HC測量值[ppm]")
    private BigDecimal bbHcIdle;

    /**
     * 高怠速CO測量值[%]
     */
    @ExcelProperty("高怠速CO測量值[%]")
    private BigDecimal bbCoHighIdle;

    /**
     * 高怠速HC測量值[ppm]
     */
    @ExcelProperty("高怠速HC測量值[ppm]")
    private BigDecimal bbHcHighIdle;

    /**
     * B項目檢驗的縂判定結果
     */
    @ExcelProperty("判定結果")
    private String bbOverallResult;

    public BigDecimal getBbCoIdle() {
        return bbCoIdle;
    }

    public void setBbCoIdle(BigDecimal bbCoIdle) {
        this.bbCoIdle = bbCoIdle;
    }

    public BigDecimal getBbHcIdle() {
        return bbHcIdle;
    }

    public void setBbHcIdle(BigDecimal bbHcIdle) {
        this.bbHcIdle = bbHcIdle;
    }

    public BigDecimal getBbCoHighIdle() {
        return bbCoHighIdle;
    }

    public void setBbCoHighIdle(BigDecimal bbCoHighIdle) {
        this.bbCoHighIdle = bbCoHighIdle;
    }

    public BigDecimal getBbHcHighIdle() {
        return bbHcHighIdle;
    }

    public void setBbHcHighIdle(BigDecimal bbHcHighIdle) {
        this.bbHcHighIdle = bbHcHighIdle;
    }

    public String getBbOverallResult() {
        return bbOverallResult;
    }

    public void setBbOverallResult(String bbOverallResult) {
        this.bbOverallResult = bbOverallResult;
    }

    @Override
    public String toString() {
        return "CarDoubleIdleInspDataStatisticsPO{" +
                "bbCoIdle=" + bbCoIdle +
                ", bbHcIdle=" + bbHcIdle +
                ", bbCoHighIdle=" + bbCoHighIdle +
                ", bbHcHighIdle=" + bbHcHighIdle +
                ", bbOverallResult='" + bbOverallResult + '\'' +
                '}';
    }
}
