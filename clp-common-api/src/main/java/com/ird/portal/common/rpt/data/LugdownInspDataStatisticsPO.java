package com.ird.portal.common.rpt.data;

import com.alibaba.excel.annotation.ExcelProperty;

import java.math.BigDecimal;

/**
 * @author Tim
 * @version 1.0
 * @date 07/02/2022 11:09
 */
public class LugdownInspDataStatisticsPO extends BenExhaustStatisticsPO {

    /**
     * LD煙霧(100%)測量值[HSU]
     */
    @ExcelProperty("LD煙霧(100%)測量值[HSU]")
    private BigDecimal ffHsu100;

    /**
     * LD煙霧(90%)測量值[HSU]
     */
    @ExcelProperty("LD煙霧(90%)測量值[HSU]")
    private BigDecimal ffHsu90;

    /**
     * LD煙霧(80%)測量值[HSU]
     */
    @ExcelProperty("LD煙霧(80%)測量值[HSU]")
    private BigDecimal ffHsu80;

    /**
     * LD最大輪邊功率[kW]
     */
    @ExcelProperty("LD最大輪邊功率[kW]")
    private BigDecimal ffMaxWp;

    /**
     * F項目檢驗的縂判定結果
     */
    @ExcelProperty("判定結果")
    private String ffOverallResult;

    public BigDecimal getFfHsu100() {
        return ffHsu100;
    }

    public void setFfHsu100(BigDecimal ffHsu100) {
        this.ffHsu100 = ffHsu100;
    }

    public BigDecimal getFfHsu90() {
        return ffHsu90;
    }

    public void setFfHsu90(BigDecimal ffHsu90) {
        this.ffHsu90 = ffHsu90;
    }

    public BigDecimal getFfHsu80() {
        return ffHsu80;
    }

    public void setFfHsu80(BigDecimal ffHsu80) {
        this.ffHsu80 = ffHsu80;
    }

    public BigDecimal getFfMaxWp() {
        return ffMaxWp;
    }

    public void setFfMaxWp(BigDecimal ffMaxWp) {
        this.ffMaxWp = ffMaxWp;
    }

    public String getFfOverallResult() {
        return ffOverallResult;
    }

    public void setFfOverallResult(String ffOverallResult) {
        this.ffOverallResult = ffOverallResult;
    }

    @Override
    public String toString() {
        return "LugdownInspDataStatisticsPO{" +
                "ffHsu100=" + ffHsu100 +
                ", ffHsu90=" + ffHsu90 +
                ", ffHsu80=" + ffHsu80 +
                ", ffMaxWp=" + ffMaxWp +
                ", ffOverallResult='" + ffOverallResult + '\'' +
                '}';
    }
}
