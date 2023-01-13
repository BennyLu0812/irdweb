package com.ird.portal.common.rpt.data;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;

import java.math.BigDecimal;

/**
 * @author Tim
 * @version 1.0
 * @date 07/02/2022 11:04
 */
public class AsmInspDataStatisticsPO extends BenExhaustStatisticsPO {

    /**
     * ASM5025_CO測量值[%]
     */
    @ExcelProperty("ASM5025_CO測量值[%]")
    @ColumnWidth(30)
    private BigDecimal eeCo5025;

    /**
     * ASM5025_CO判定結果
     */
    @ExcelProperty("ASM5025_CO判定結果")
    @ColumnWidth(30)
    private String eeCo5025Result;

    /**
     * ASM5025_HC測量值[ppm]
     */
    @ExcelProperty("ASM5025_HC測量值[ppm]")
    @ColumnWidth(30)
    private BigDecimal eeHc5025;

    /**
     * ASM5025_HC判定結果
     */
    @ExcelProperty("ASM5025_HC判定結果")
    @ColumnWidth(30)
    private String eeHc5025Result;

    /**
     * ASM5025_NO測量值[ppm]
     */
    @ExcelProperty("ASM5025_NO測量值[ppm]")
    @ColumnWidth(30)
    private BigDecimal eeNo5025;

    /**
     * ASM5025_NO判定結果
     */
    @ExcelProperty("ASM5025_NO判定結果")
    @ColumnWidth(30)
    private String eeNo5025Result;

    /**
     * ASM2540_CO測量值[%]
     */
    @ExcelProperty("ASM2540_CO測量值[%]")
    @ColumnWidth(30)
    private BigDecimal eeCo2540;

    /**
     * ASM2540_CO判定結果
     */
    @ExcelProperty("ASM2540_CO判定結果")
    @ColumnWidth(30)
    private String eeCo2540Result;

    /**
     * ASM2540_HC測量值[ppm]
     */
    @ExcelProperty("ASM2540_HC測量值[ppm]")
    @ColumnWidth(30)
    private BigDecimal eeHc2540;

    /**
     * ASM2540_HC判定結果
     */
    @ExcelProperty("ASM2540_HC判定結果")
    @ColumnWidth(30)
    private String eeHc2540Result;

    /**
     * ASM2540_NO測量值[ppm]
     */
    @ExcelProperty("ASM2540_NO測量值[ppm]")
    @ColumnWidth(30)
    private BigDecimal eNo2540;

    /**
     * ASM2540_NO判定結果
     */
    @ExcelProperty("ASM2540_NO判定結果")
    @ColumnWidth(30)
    private String eeNo2540Result;

    /**
     * E項目檢驗的縂判定結果
     */
    @ExcelProperty("判定結果")
    private String eeOverallResult;

    public BigDecimal getEeCo5025() {
        return eeCo5025;
    }

    public void setEeCo5025(BigDecimal eeCo5025) {
        this.eeCo5025 = eeCo5025;
    }

    public String getEeCo5025Result() {
        return eeCo5025Result;
    }

    public void setEeCo5025Result(String eeCo5025Result) {
        this.eeCo5025Result = eeCo5025Result;
    }

    public BigDecimal getEeHc5025() {
        return eeHc5025;
    }

    public void setEeHc5025(BigDecimal eeHc5025) {
        this.eeHc5025 = eeHc5025;
    }

    public String getEeHc5025Result() {
        return eeHc5025Result;
    }

    public void setEeHc5025Result(String eeHc5025Result) {
        this.eeHc5025Result = eeHc5025Result;
    }

    public BigDecimal getEeNo5025() {
        return eeNo5025;
    }

    public void setEeNo5025(BigDecimal eeNo5025) {
        this.eeNo5025 = eeNo5025;
    }

    public String getEeNo5025Result() {
        return eeNo5025Result;
    }

    public void setEeNo5025Result(String eeNo5025Result) {
        this.eeNo5025Result = eeNo5025Result;
    }

    public BigDecimal getEeCo2540() {
        return eeCo2540;
    }

    public void setEeCo2540(BigDecimal eeCo2540) {
        this.eeCo2540 = eeCo2540;
    }

    public String getEeCo2540Result() {
        return eeCo2540Result;
    }

    public void setEeCo2540Result(String eeCo2540Result) {
        this.eeCo2540Result = eeCo2540Result;
    }

    public BigDecimal getEeHc2540() {
        return eeHc2540;
    }

    public void setEeHc2540(BigDecimal eeHc2540) {
        this.eeHc2540 = eeHc2540;
    }

    public String getEeHc2540Result() {
        return eeHc2540Result;
    }

    public void setEeHc2540Result(String eeHc2540Result) {
        this.eeHc2540Result = eeHc2540Result;
    }

    public BigDecimal geteNo2540() {
        return eNo2540;
    }

    public void seteNo2540(BigDecimal eNo2540) {
        this.eNo2540 = eNo2540;
    }

    public String getEeNo2540Result() {
        return eeNo2540Result;
    }

    public void setEeNo2540Result(String eeNo2540Result) {
        this.eeNo2540Result = eeNo2540Result;
    }

    public String getEeOverallResult() {
        return eeOverallResult;
    }

    public void setEeOverallResult(String eeOverallResult) {
        this.eeOverallResult = eeOverallResult;
    }

    @Override
    public String toString() {
        return "AsmInspDataStatisticsPO{" +
                "eeCo5025=" + eeCo5025 +
                ", eeCo5025Result='" + eeCo5025Result + '\'' +
                ", eeHc5025=" + eeHc5025 +
                ", eeHc5025Result='" + eeHc5025Result + '\'' +
                ", eeNo5025=" + eeNo5025 +
                ", eeNo5025Result='" + eeNo5025Result + '\'' +
                ", eeCo2540=" + eeCo2540 +
                ", eeCo2540Result='" + eeCo2540Result + '\'' +
                ", eeHc2540=" + eeHc2540 +
                ", eeHc2540Result='" + eeHc2540Result + '\'' +
                ", eNo2540=" + eNo2540 +
                ", eeNo2540Result='" + eeNo2540Result + '\'' +
                ", eeOverallResult='" + eeOverallResult + '\'' +
                '}';
    }
}
