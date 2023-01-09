package com.ird.portal.common.rpt.data;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;

import java.util.Date;

/**
 * @author Tim
 * @version 1.0
 * @date 26/01/2022 10:31
 */
public class InspectionItemStatisticsPO {

    /**
     * 驗車中心中文名
     */
    @ExcelProperty("驗車中心名稱")
    private String centerNameCn;

    /**
     * 檢驗時間
     */
    @ExcelProperty("時間")
    @DateTimeFormat("dd/mm/yyyy")
    @ColumnWidth(10)
    private Date inspectionTime;

    /**
     * 車輛檢測數量
     */
    @ExcelProperty("車輛檢測數量")
    private Integer inspectionCount;

    /**
     * 車輛檢測合格數
     */
    @ExcelProperty("車輛檢測合格數")
    private Integer inspectionPassCount;

    /**
     * 車輛檢測不合格數
     */
    @ExcelProperty("車輛檢測不合格數")
    private Integer inspectionNoPassCount;

    /**
     * 車輛檢測合格率
     */
    @ExcelProperty("車輛檢測合格率")
    @NumberFormat("0.00%")
    private Double inspectionPassRate;

    /**
     * 車輛檢測不合格率
     */
    @ExcelProperty("車輛檢測不合格率")
    @NumberFormat("0.00%")
    private Double inspectionNoPassRate;

    /**
     * A(目視及底盤檢驗)檢測數量
     */
    @ExcelProperty("A(目視及底盤檢驗)檢測數量")
    private Integer aaCount;

    /**
     * A(目視及底盤檢驗)合格數
     */
    @ExcelProperty("A(目視及底盤檢驗)合格數")
    private Integer aaPassCount;

    /**
     * A(目視及底盤檢驗)不合格數
     */
    @ExcelProperty("A(目視及底盤檢驗)不合格數")
    private Integer aaNoPassCount;

    /**
     * A(目視及底盤檢驗)合格率
     */
    @ExcelProperty("A(目視及底盤檢驗)合格率")
    @NumberFormat("0.00%")
    private Double aaPassRate;

    /**
     * A(目視及底盤檢驗)不合格率
     */
    @ExcelProperty("A(目視及底盤檢驗)不合格率")
    @NumberFormat("0.00%")
    private Double aaNoPassRate;

    /**
     * B(汽油／天然氣汽車尾氣排放)檢測數量
     */
    @ExcelProperty("B(汽油／天然氣汽車尾氣排放)檢測數量")
    private Integer bbCount;

    /**
     * B(汽油／天然氣汽車尾氣排放)合格數
     */
    @ExcelProperty("B(汽油／天然氣汽車尾氣排放)合格數")
    @NumberFormat("0.00%")
    private Integer bbPassCount;

    /**
     * B(汽油／天然氣汽車尾氣排放)不合格數
     */
    @ExcelProperty("B(汽油／天然氣汽車尾氣排放)不合格數")
    @NumberFormat("0.00%")
    private Integer bbNoPassCount;

    /**
     *  B(汽油／天然氣汽車尾氣排放)合格率
     */
    @ExcelProperty("B(汽油／天然氣汽車尾氣排放)合格率")
    @NumberFormat("0.00%")
    private Double bbPassRate;

    /**
     *  B(汽油／天然氣汽車尾氣排放)不合格率
     */
    @ExcelProperty("B(汽油／天然氣汽車尾氣排放)不合格率")
    @NumberFormat("0.00%")
    private Double bbNoPassRate;

    /**
     * C(柴油汽車尾氣排放)檢測數量
     */
    @ExcelProperty("C(柴油汽車尾氣排放)檢測數量")
    private Integer ccCount;

    /**
     * C(柴油汽車尾氣排放)合格數
     */
    @ExcelProperty("C(柴油汽車尾氣排放)合格數")
    private Integer ccPassCount;

    /**
     * C(柴油汽車尾氣排放)不合格數
     */
    @ExcelProperty("C(柴油汽車尾氣排放)不合格數")
    private Integer ccNoPassCount;

    /**
     * C(柴油汽車尾氣排放)合格率
     */
    @ExcelProperty("C(柴油汽車尾氣排放)合格率")
    @NumberFormat("0.00%")
    private Double ccPassRate;

    /**
     *  C(柴油汽車尾氣排放)不合格率
     */
    @ExcelProperty("C(柴油汽車尾氣排放)不合格率")
    @NumberFormat("0.00%")
    private Double ccNoPassRate;

    /**
     * D(摩托車尾氣排放)檢測數量
     */
    @ExcelProperty("D(摩托車尾氣排放)檢測數量")
    private Integer ddCount;

    /**
     * D(摩托車尾氣排放)合格數
     */
    @ExcelProperty("D(摩托車尾氣排放)合格數")
    private Integer ddPassCount;

    /**
     * D(摩托車尾氣排放)不合格數
     */
    @ExcelProperty("D(摩托車尾氣排放)不合格數")
    private Integer ddNoPassCount;

    /**
     * D(摩托車尾氣排放)合格率
     */
    @ExcelProperty("D(摩托車尾氣排放)合格率")
    @NumberFormat("0.00%")
    private Double ddPassRate;

    /**
     *  D(摩托車尾氣排放)不合格率
     */
    @ExcelProperty("D(摩托車尾氣排放)不合格率")
    @NumberFormat("0.00%")
    private Double ddNoPassRate;

    /**
     * E(汽油汽車尾氣排放（穩態工況法）)檢測數量
     */
    @ExcelProperty("E(汽油汽車尾氣排放（穩態工況法）)檢測數量")
    private Integer eeCount;

    /**
     * E(汽油汽車尾氣排放（穩態工況法）)合格數
     */
    @ExcelProperty("E(汽油汽車尾氣排放（穩態工況法）)合格數")
    private Integer eePassCount;

    /**
     * E(汽油汽車尾氣排放（穩態工況法）)不合格數
     */
    @ExcelProperty("E(汽油汽車尾氣排放（穩態工況法）)不合格數")
    private Integer eeNoPassCount;

    /**
     * E(汽油汽車尾氣排放（穩態工況法）)合格率
     */
    @ExcelProperty("E(汽油汽車尾氣排放（穩態工況法）)合格率")
    @NumberFormat("0.00%")
    private Double eePassRate;

    /**
     *  E(汽油汽車尾氣排放（穩態工況法）)不合格率
     */
    @ExcelProperty("E(汽油汽車尾氣排放（穩態工況法）)不合格率")
    @NumberFormat("0.00%")
    private Double eeNoPassRate;

    /**
     * F(柴油汽車尾氣排放（加載減速法）)檢測數量
     */
    @ExcelProperty("F(柴油汽車尾氣排放（加載減速法）)檢測數量")
    private Integer ffCount;

    /**
     * F(柴油汽車尾氣排放（加載減速法）)合格數
     */
    @ExcelProperty("F(柴油汽車尾氣排放（加載減速法）)合格數")
    private Integer ffPassCount;

    /**
     * F(柴油汽車尾氣排放（加載減速法）)不合格數
     */
    @ExcelProperty("F(柴油汽車尾氣排放（加載減速法）)不合格數")
    private Integer ffNoPassCount;

    /**
     * F(柴油汽車尾氣排放（加載減速法）)合格率
     */
    @ExcelProperty("F(柴油汽車尾氣排放（加載減速法）)合格率")
    @NumberFormat("0.00%")
    private Double ffPassRate;

    /**
     * F(柴油汽車尾氣排放（加載減速法）)不合格率
     */
    @ExcelProperty("F(柴油汽車尾氣排放（加載減速法）)不合格率")
    @NumberFormat("0.00%")
    private Double ffNoPassRate;

    /**
     * G(側滑檢測)檢測數量
     */
    @ExcelProperty("G(側滑檢測)檢測數量")
    private Integer ggCount;

    /**
     * G(側滑檢測)合格數
     */
    @ExcelProperty("G(側滑檢測)合格數")
    private Integer ggPassCount;

    /**
     * G(側滑檢測)不合格數
     */
    @ExcelProperty("G(側滑檢測)不合格數")
    private Integer ggNoPassCount;

    /**
     * G(側滑檢測)合格率
     */
    @ExcelProperty("G(側滑檢測)合格率")
    @NumberFormat("0.00%")
    private Double ggPassRate;

    /**
     * G(側滑檢測)不合格率
     */
    @ExcelProperty("G(側滑檢測)不合格率")
    @NumberFormat("0.00%")
    private Double ggNoPassRate;

    /**
     * H(行車制動 (儀器))檢測數量
     */
    @ExcelProperty("H(行車制動 (儀器))檢測數量")
    private Integer hhCount;

    /**
     * H(行車制動 (儀器))合格數
     */
    @ExcelProperty("H(行車制動 (儀器))合格數")
    private Integer hPassCount;

    /**
     * H(行車制動 (儀器))不合格數
     */
    @ExcelProperty("H(行車制動 (儀器))不合格數")
    private Integer hNoPassCount;

    /**
     * H(行車制動 (儀器))合格率
     */
    @ExcelProperty("H(行車制動 (儀器))合格率")
    @NumberFormat("0.00%")
    private Double hhPassRate;

    /**
     * H(行車制動 (儀器))不合格率
     */
    @ExcelProperty("H(行車制動 (儀器))不合格率")
    @NumberFormat("0.00%")
    private Double hhNoPassRate;

    /**
     * I(行車制動 (路試))檢測數量
     */
    @ExcelProperty("I(行車制動 (路試))檢測數量")
    private Integer iiCount;

    /**
     * I(行車制動 (路試))合格數
     */
    @ExcelProperty("I(行車制動 (路試))合格數")
    private Integer iiPassCount;

    /**
     * I(行車制動 (路試))不合格數
     */
    @ExcelProperty("I(行車制動 (路試))不合格數")
    private Integer iiNoPassCount;

    /**
     * I(行車制動 (路試))合格率
     */
    @ExcelProperty("I(行車制動 (路試))合格率")
    @NumberFormat("0.00%")
    private Double iiPassRate;

    /**
     * I(行車制動 (路試))不合格率
     */
    @ExcelProperty("I(行車制動 (路試))不合格率")
    @NumberFormat("0.00%")
    private Double iiNoPassRate;

    /**
     * J(駐車制動 (儀器))檢測數量
     */
    @ExcelProperty("J(駐車制動 (儀器))檢測數量")
    private Integer jjCount;

    /**
     * J(駐車制動 (儀器))合格數
     */
    @ExcelProperty("J(駐車制動 (儀器))合格數")
    private Integer jjPassCount;

    /**
     * J(駐車制動 (儀器))不合格數
     */
    @ExcelProperty("J(駐車制動 (儀器))不合格數")
    private Integer jjNoPassCount;

    /**
     * J(駐車制動 (儀器))合格率
     */
    @ExcelProperty("J(駐車制動 (儀器))合格率")
    @NumberFormat("0.00%")
    private Double jjPassRate;

    /**
     * J(駐車制動 (儀器))不合格率
     */
    @ExcelProperty("J(駐車制動 (儀器))不合格率")
    @NumberFormat("0.00%")
    private Double jjNoPassRate;

    /**
     * K(駐車制動 (路試))檢測數量
     */
    @ExcelProperty("K(駐車制動 (路試))檢測數量")
    private Integer kkCount;

    /**
     * K(駐車制動 (路試))合格數
     */
    @ExcelProperty("K(駐車制動 (路試))合格數")
    private Integer kkPassCount;

    /**
     * K(駐車制動 (路試))不合格數
     */
    @ExcelProperty("K(駐車制動 (路試))不合格數")
    private Integer kkNoPassCount;

    /**
     * K(駐車制動 (路試))合格率
     */
    @ExcelProperty("K(駐車制動 (路試))合格率")
    @NumberFormat("0.00%")
    private Double kkPassRate;

    /**
     * K(駐車制動 (路試))不合格率
     */
    @ExcelProperty("K(駐車制動 (路試))不合格率")
    @NumberFormat("0.00%")
    private Double kkNoPassRate;

    /**
     * L(前照燈)檢測數量
     */
    @ExcelProperty("L(前照燈)檢測數量")
    private Integer llCount;

    /**
     * L(前照燈)合格數
     */
    @ExcelProperty("L(前照燈)合格數")
    private Integer llPassCount;

    /**
     * L(前照燈)不合格數
     */
    @ExcelProperty("L(前照燈)不合格數")
    private Integer llNoPassCount;

    /**
     * L(前照燈)合格率
     */
    @ExcelProperty("L(前照燈)合格率")
    @NumberFormat("0.00%")
    private Double llPassRate;

    /**
     * L(前照燈)不合格率
     */
    @ExcelProperty("L(前照燈)不合格率")
    @NumberFormat("0.00%")
    private Double llNoPassRate;

    /**
     * M(噪音)檢測數量
     */
    @ExcelProperty("M(噪音)檢測數量")
    private Integer mmCount;

    /**
     * M(噪音)合格數
     */
    @ExcelProperty("M(噪音)合格數")
    private Integer mmPassCount;

    /**
     * M(噪音)不合格數
     */
    @ExcelProperty("M(噪音)不合格數")
    private Integer mmNoPassCount;

    /**
     * M(噪音)合格率
     */
    @ExcelProperty("M(噪音)合格率")
    @NumberFormat("0.00%")
    private Double mmPassRate;

    /**
     * M(噪音)不合格率
     */
    @ExcelProperty("M(噪音)不合格率")
    @NumberFormat("0.00%")
    private Double mmNoPassRate;

    /**
     * P(計程錶)檢測數量
     */
    @ExcelProperty("P(計程錶)檢測數量")
    private Integer ppCount;

    /**
     * P(計程錶)合格數
     */
    @ExcelProperty("P(計程錶)合格數")
    private Integer ppPassCount;

    /**
     * P(計程錶)不合格數
     */
    @ExcelProperty("P(計程錶)不合格數")
    private Integer ppNoPassCount;

    /**
     * P(計程錶)合格率
     */
    @ExcelProperty("P(計程錶)合格率")
    @NumberFormat("0.00%")
    private Double ppPassRate;

    /**
     * P(計程錶)不合格率
     */
    @ExcelProperty("P(計程錶)不合格率")
    @NumberFormat("0.00%")
    private Double ppNoPassRate;

    /**
     * 機械檢驗數量
     */
    @ExcelProperty("機械檢驗數量")
    private Integer mechanicalInspectionCount;

    /**
     * 機械檢驗合格數
     */
    @ExcelProperty("機械檢驗合格數")
    private Integer mechanicalInspectionPassCount;

    /**
     * 機械檢驗不合格數
     */
    @ExcelProperty("機械檢驗不合格數")
    private Integer mechanicalInspectionNoPassCount;

    /**
     * 機械檢驗合格率
     */
    @ExcelProperty("機械檢驗合格率")
    @NumberFormat("0.00%")
    private Double mechanicalInspectionPassRate;

    /**
     * 機械檢驗不合格率
     */
    @ExcelProperty("機械檢驗不合格率")
    @NumberFormat("0.00%")
    private Double mechanicalInspectionNoPassRate;

    public String getCenterNameCn() {
        return centerNameCn;
    }

    public void setCenterNameCn(String centerNameCn) {
        this.centerNameCn = centerNameCn;
    }

    public Date getInspectionTime() {
        return inspectionTime;
    }

    public void setInspectionTime(Date inspectionTime) {
        this.inspectionTime = inspectionTime;
    }

    public Integer getInspectionCount() {
        return inspectionCount;
    }

    public void setInspectionCount(Integer inspectionCount) {
        this.inspectionCount = inspectionCount;
    }

    public Integer getInspectionPassCount() {
        return inspectionPassCount;
    }

    public void setInspectionPassCount(Integer inspectionPassCount) {
        this.inspectionPassCount = inspectionPassCount;
    }

    public Integer getInspectionNoPassCount() {
        return inspectionNoPassCount;
    }

    public void setInspectionNoPassCount(Integer inspectionNoPassCount) {
        this.inspectionNoPassCount = inspectionNoPassCount;
    }

    public Double getInspectionPassRate() {
        return inspectionPassRate;
    }

    public void setInspectionPassRate(Double inspectionPassRate) {
        this.inspectionPassRate = inspectionPassRate;
    }

    public Double getInspectionNoPassRate() {
        return inspectionNoPassRate;
    }

    public void setInspectionNoPassRate(Double inspectionNoPassRate) {
        this.inspectionNoPassRate = inspectionNoPassRate;
    }

    public Integer getAaCount() {
        return aaCount;
    }

    public void setAaCount(Integer aaCount) {
        this.aaCount = aaCount;
    }

    public Integer getAaPassCount() {
        return aaPassCount;
    }

    public void setAaPassCount(Integer aaPassCount) {
        this.aaPassCount = aaPassCount;
    }

    public Integer getAaNoPassCount() {
        return aaNoPassCount;
    }

    public void setAaNoPassCount(Integer aaNoPassCount) {
        this.aaNoPassCount = aaNoPassCount;
    }

    public Double getAaPassRate() {
        return aaPassRate;
    }

    public void setAaPassRate(Double aaPassRate) {
        this.aaPassRate = aaPassRate;
    }

    public Double getAaNoPassRate() {
        return aaNoPassRate;
    }

    public void setAaNoPassRate(Double aaNoPassRate) {
        this.aaNoPassRate = aaNoPassRate;
    }

    public Integer getBbCount() {
        return bbCount;
    }

    public void setBbCount(Integer bbCount) {
        this.bbCount = bbCount;
    }

    public Integer getBbPassCount() {
        return bbPassCount;
    }

    public void setBbPassCount(Integer bbPassCount) {
        this.bbPassCount = bbPassCount;
    }

    public Integer getBbNoPassCount() {
        return bbNoPassCount;
    }

    public void setBbNoPassCount(Integer bbNoPassCount) {
        this.bbNoPassCount = bbNoPassCount;
    }

    public Double getBbPassRate() {
        return bbPassRate;
    }

    public void setBbPassRate(Double bbPassRate) {
        this.bbPassRate = bbPassRate;
    }

    public Double getBbNoPassRate() {
        return bbNoPassRate;
    }

    public void setBbNoPassRate(Double bbNoPassRate) {
        this.bbNoPassRate = bbNoPassRate;
    }

    public Integer getCcCount() {
        return ccCount;
    }

    public void setCcCount(Integer ccCount) {
        this.ccCount = ccCount;
    }

    public Integer getCcPassCount() {
        return ccPassCount;
    }

    public void setCcPassCount(Integer ccPassCount) {
        this.ccPassCount = ccPassCount;
    }

    public Integer getCcNoPassCount() {
        return ccNoPassCount;
    }

    public void setCcNoPassCount(Integer ccNoPassCount) {
        this.ccNoPassCount = ccNoPassCount;
    }

    public Double getCcPassRate() {
        return ccPassRate;
    }

    public void setCcPassRate(Double ccPassRate) {
        this.ccPassRate = ccPassRate;
    }

    public Double getCcNoPassRate() {
        return ccNoPassRate;
    }

    public void setCcNoPassRate(Double ccNoPassRate) {
        this.ccNoPassRate = ccNoPassRate;
    }

    public Integer getDdCount() {
        return ddCount;
    }

    public void setDdCount(Integer ddCount) {
        this.ddCount = ddCount;
    }

    public Integer getDdPassCount() {
        return ddPassCount;
    }

    public void setDdPassCount(Integer ddPassCount) {
        this.ddPassCount = ddPassCount;
    }

    public Integer getDdNoPassCount() {
        return ddNoPassCount;
    }

    public void setDdNoPassCount(Integer ddNoPassCount) {
        this.ddNoPassCount = ddNoPassCount;
    }

    public Double getDdPassRate() {
        return ddPassRate;
    }

    public void setDdPassRate(Double ddPassRate) {
        this.ddPassRate = ddPassRate;
    }

    public Double getDdNoPassRate() {
        return ddNoPassRate;
    }

    public void setDdNoPassRate(Double ddNoPassRate) {
        this.ddNoPassRate = ddNoPassRate;
    }

    public Integer getEeCount() {
        return eeCount;
    }

    public void setEeCount(Integer eeCount) {
        this.eeCount = eeCount;
    }

    public Integer getEePassCount() {
        return eePassCount;
    }

    public void setEePassCount(Integer eePassCount) {
        this.eePassCount = eePassCount;
    }

    public Integer getEeNoPassCount() {
        return eeNoPassCount;
    }

    public void setEeNoPassCount(Integer eeNoPassCount) {
        this.eeNoPassCount = eeNoPassCount;
    }

    public Double getEePassRate() {
        return eePassRate;
    }

    public void setEePassRate(Double eePassRate) {
        this.eePassRate = eePassRate;
    }

    public Double getEeNoPassRate() {
        return eeNoPassRate;
    }

    public void setEeNoPassRate(Double eeNoPassRate) {
        this.eeNoPassRate = eeNoPassRate;
    }

    public Integer getFfCount() {
        return ffCount;
    }

    public void setFfCount(Integer ffCount) {
        this.ffCount = ffCount;
    }

    public Integer getFfPassCount() {
        return ffPassCount;
    }

    public void setFfPassCount(Integer ffPassCount) {
        this.ffPassCount = ffPassCount;
    }

    public Integer getFfNoPassCount() {
        return ffNoPassCount;
    }

    public void setFfNoPassCount(Integer ffNoPassCount) {
        this.ffNoPassCount = ffNoPassCount;
    }

    public Double getFfPassRate() {
        return ffPassRate;
    }

    public void setFfPassRate(Double ffPassRate) {
        this.ffPassRate = ffPassRate;
    }

    public Double getFfNoPassRate() {
        return ffNoPassRate;
    }

    public void setFfNoPassRate(Double ffNoPassRate) {
        this.ffNoPassRate = ffNoPassRate;
    }

    public Integer getGgCount() {
        return ggCount;
    }

    public void setGgCount(Integer ggCount) {
        this.ggCount = ggCount;
    }

    public Integer getGgPassCount() {
        return ggPassCount;
    }

    public void setGgPassCount(Integer ggPassCount) {
        this.ggPassCount = ggPassCount;
    }

    public Integer getGgNoPassCount() {
        return ggNoPassCount;
    }

    public void setGgNoPassCount(Integer ggNoPassCount) {
        this.ggNoPassCount = ggNoPassCount;
    }

    public Double getGgPassRate() {
        return ggPassRate;
    }

    public void setGgPassRate(Double ggPassRate) {
        this.ggPassRate = ggPassRate;
    }

    public Double getGgNoPassRate() {
        return ggNoPassRate;
    }

    public void setGgNoPassRate(Double ggNoPassRate) {
        this.ggNoPassRate = ggNoPassRate;
    }

    public Integer getHhCount() {
        return hhCount;
    }

    public void setHhCount(Integer hhCount) {
        this.hhCount = hhCount;
    }

    public Integer gethPassCount() {
        return hPassCount;
    }

    public void sethPassCount(Integer hPassCount) {
        this.hPassCount = hPassCount;
    }

    public Integer gethNoPassCount() {
        return hNoPassCount;
    }

    public void sethNoPassCount(Integer hNoPassCount) {
        this.hNoPassCount = hNoPassCount;
    }

    public Double getHhPassRate() {
        return hhPassRate;
    }

    public void setHhPassRate(Double hhPassRate) {
        this.hhPassRate = hhPassRate;
    }

    public Double getHhNoPassRate() {
        return hhNoPassRate;
    }

    public void setHhNoPassRate(Double hhNoPassRate) {
        this.hhNoPassRate = hhNoPassRate;
    }

    public Integer getIiCount() {
        return iiCount;
    }

    public void setIiCount(Integer iiCount) {
        this.iiCount = iiCount;
    }

    public Integer getIiPassCount() {
        return iiPassCount;
    }

    public void setIiPassCount(Integer iiPassCount) {
        this.iiPassCount = iiPassCount;
    }

    public Integer getIiNoPassCount() {
        return iiNoPassCount;
    }

    public void setIiNoPassCount(Integer iiNoPassCount) {
        this.iiNoPassCount = iiNoPassCount;
    }

    public Double getIiPassRate() {
        return iiPassRate;
    }

    public void setIiPassRate(Double iiPassRate) {
        this.iiPassRate = iiPassRate;
    }

    public Double getIiNoPassRate() {
        return iiNoPassRate;
    }

    public void setIiNoPassRate(Double iiNoPassRate) {
        this.iiNoPassRate = iiNoPassRate;
    }

    public Integer getJjCount() {
        return jjCount;
    }

    public void setJjCount(Integer jjCount) {
        this.jjCount = jjCount;
    }

    public Integer getJjPassCount() {
        return jjPassCount;
    }

    public void setJjPassCount(Integer jjPassCount) {
        this.jjPassCount = jjPassCount;
    }

    public Integer getJjNoPassCount() {
        return jjNoPassCount;
    }

    public void setJjNoPassCount(Integer jjNoPassCount) {
        this.jjNoPassCount = jjNoPassCount;
    }

    public Double getJjPassRate() {
        return jjPassRate;
    }

    public void setJjPassRate(Double jjPassRate) {
        this.jjPassRate = jjPassRate;
    }

    public Double getJjNoPassRate() {
        return jjNoPassRate;
    }

    public void setJjNoPassRate(Double jjNoPassRate) {
        this.jjNoPassRate = jjNoPassRate;
    }

    public Integer getKkCount() {
        return kkCount;
    }

    public void setKkCount(Integer kkCount) {
        this.kkCount = kkCount;
    }

    public Integer getKkPassCount() {
        return kkPassCount;
    }

    public void setKkPassCount(Integer kkPassCount) {
        this.kkPassCount = kkPassCount;
    }

    public Integer getKkNoPassCount() {
        return kkNoPassCount;
    }

    public void setKkNoPassCount(Integer kkNoPassCount) {
        this.kkNoPassCount = kkNoPassCount;
    }

    public Double getKkPassRate() {
        return kkPassRate;
    }

    public void setKkPassRate(Double kkPassRate) {
        this.kkPassRate = kkPassRate;
    }

    public Double getKkNoPassRate() {
        return kkNoPassRate;
    }

    public void setKkNoPassRate(Double kkNoPassRate) {
        this.kkNoPassRate = kkNoPassRate;
    }

    public Integer getLlCount() {
        return llCount;
    }

    public void setLlCount(Integer llCount) {
        this.llCount = llCount;
    }

    public Integer getLlPassCount() {
        return llPassCount;
    }

    public void setLlPassCount(Integer llPassCount) {
        this.llPassCount = llPassCount;
    }

    public Integer getLlNoPassCount() {
        return llNoPassCount;
    }

    public void setLlNoPassCount(Integer llNoPassCount) {
        this.llNoPassCount = llNoPassCount;
    }

    public Double getLlPassRate() {
        return llPassRate;
    }

    public void setLlPassRate(Double llPassRate) {
        this.llPassRate = llPassRate;
    }

    public Double getLlNoPassRate() {
        return llNoPassRate;
    }

    public void setLlNoPassRate(Double llNoPassRate) {
        this.llNoPassRate = llNoPassRate;
    }

    public Integer getMmCount() {
        return mmCount;
    }

    public void setMmCount(Integer mmCount) {
        this.mmCount = mmCount;
    }

    public Integer getMmPassCount() {
        return mmPassCount;
    }

    public void setMmPassCount(Integer mmPassCount) {
        this.mmPassCount = mmPassCount;
    }

    public Integer getMmNoPassCount() {
        return mmNoPassCount;
    }

    public void setMmNoPassCount(Integer mmNoPassCount) {
        this.mmNoPassCount = mmNoPassCount;
    }

    public Double getMmPassRate() {
        return mmPassRate;
    }

    public void setMmPassRate(Double mmPassRate) {
        this.mmPassRate = mmPassRate;
    }

    public Double getMmNoPassRate() {
        return mmNoPassRate;
    }

    public void setMmNoPassRate(Double mmNoPassRate) {
        this.mmNoPassRate = mmNoPassRate;
    }

    public Integer getPpCount() {
        return ppCount;
    }

    public void setPpCount(Integer ppCount) {
        this.ppCount = ppCount;
    }

    public Integer getPpPassCount() {
        return ppPassCount;
    }

    public void setPpPassCount(Integer ppPassCount) {
        this.ppPassCount = ppPassCount;
    }

    public Integer getPpNoPassCount() {
        return ppNoPassCount;
    }

    public void setPpNoPassCount(Integer ppNoPassCount) {
        this.ppNoPassCount = ppNoPassCount;
    }

    public Double getPpPassRate() {
        return ppPassRate;
    }

    public void setPpPassRate(Double ppPassRate) {
        this.ppPassRate = ppPassRate;
    }

    public Double getPpNoPassRate() {
        return ppNoPassRate;
    }

    public void setPpNoPassRate(Double ppNoPassRate) {
        this.ppNoPassRate = ppNoPassRate;
    }

    public Integer getMechanicalInspectionCount() {
        return mechanicalInspectionCount;
    }

    public void setMechanicalInspectionCount(Integer mechanicalInspectionCount) {
        this.mechanicalInspectionCount = mechanicalInspectionCount;
    }

    public Integer getMechanicalInspectionPassCount() {
        return mechanicalInspectionPassCount;
    }

    public void setMechanicalInspectionPassCount(Integer mechanicalInspectionPassCount) {
        this.mechanicalInspectionPassCount = mechanicalInspectionPassCount;
    }

    public Integer getMechanicalInspectionNoPassCount() {
        return mechanicalInspectionNoPassCount;
    }

    public void setMechanicalInspectionNoPassCount(Integer mechanicalInspectionNoPassCount) {
        this.mechanicalInspectionNoPassCount = mechanicalInspectionNoPassCount;
    }

    public Double getMechanicalInspectionPassRate() {
        return mechanicalInspectionPassRate;
    }

    public void setMechanicalInspectionPassRate(Double mechanicalInspectionPassRate) {
        this.mechanicalInspectionPassRate = mechanicalInspectionPassRate;
    }

    public Double getMechanicalInspectionNoPassRate() {
        return mechanicalInspectionNoPassRate;
    }

    public void setMechanicalInspectionNoPassRate(Double mechanicalInspectionNoPassRate) {
        this.mechanicalInspectionNoPassRate = mechanicalInspectionNoPassRate;
    }

    @Override
    public String toString() {
        return "InspectionItemStatisticsPO{" +
                "centerNameCn='" + centerNameCn + '\'' +
                ", inspectionTime=" + inspectionTime +
                ", inspectionCount=" + inspectionCount +
                ", inspectionPassCount=" + inspectionPassCount +
                ", inspectionNoPassCount=" + inspectionNoPassCount +
                ", inspectionPassRate=" + inspectionPassRate +
                ", inspectionNoPassRate=" + inspectionNoPassRate +
                ", aaCount=" + aaCount +
                ", aaPassCount=" + aaPassCount +
                ", aaNoPassCount=" + aaNoPassCount +
                ", aaPassRate=" + aaPassRate +
                ", aaNoPassRate=" + aaNoPassRate +
                ", bbCount=" + bbCount +
                ", bbPassCount=" + bbPassCount +
                ", bbNoPassCount=" + bbNoPassCount +
                ", bbPassRate=" + bbPassRate +
                ", bbNoPassRate=" + bbNoPassRate +
                ", ccCount=" + ccCount +
                ", ccPassCount=" + ccPassCount +
                ", ccNoPassCount=" + ccNoPassCount +
                ", ccPassRate=" + ccPassRate +
                ", ccNoPassRate=" + ccNoPassRate +
                ", ddCount=" + ddCount +
                ", ddPassCount=" + ddPassCount +
                ", ddNoPassCount=" + ddNoPassCount +
                ", ddPassRate=" + ddPassRate +
                ", ddNoPassRate=" + ddNoPassRate +
                ", eeCount=" + eeCount +
                ", eePassCount=" + eePassCount +
                ", eeNoPassCount=" + eeNoPassCount +
                ", eePassRate=" + eePassRate +
                ", eeNoPassRate=" + eeNoPassRate +
                ", ffCount=" + ffCount +
                ", ffPassCount=" + ffPassCount +
                ", ffNoPassCount=" + ffNoPassCount +
                ", ffPassRate=" + ffPassRate +
                ", ffNoPassRate=" + ffNoPassRate +
                ", ggCount=" + ggCount +
                ", ggPassCount=" + ggPassCount +
                ", ggNoPassCount=" + ggNoPassCount +
                ", ggPassRate=" + ggPassRate +
                ", ggNoPassRate=" + ggNoPassRate +
                ", hhCount=" + hhCount +
                ", hPassCount=" + hPassCount +
                ", hNoPassCount=" + hNoPassCount +
                ", hhPassRate=" + hhPassRate +
                ", hhNoPassRate=" + hhNoPassRate +
                ", iiCount=" + iiCount +
                ", iiPassCount=" + iiPassCount +
                ", iiNoPassCount=" + iiNoPassCount +
                ", iiPassRate=" + iiPassRate +
                ", iiNoPassRate=" + iiNoPassRate +
                ", jjCount=" + jjCount +
                ", jjPassCount=" + jjPassCount +
                ", jjNoPassCount=" + jjNoPassCount +
                ", jjPassRate=" + jjPassRate +
                ", jjNoPassRate=" + jjNoPassRate +
                ", kkCount=" + kkCount +
                ", kkPassCount=" + kkPassCount +
                ", kkNoPassCount=" + kkNoPassCount +
                ", kkPassRate=" + kkPassRate +
                ", kkNoPassRate=" + kkNoPassRate +
                ", llCount=" + llCount +
                ", llPassCount=" + llPassCount +
                ", llNoPassCount=" + llNoPassCount +
                ", llPassRate=" + llPassRate +
                ", llNoPassRate=" + llNoPassRate +
                ", mmCount=" + mmCount +
                ", mmPassCount=" + mmPassCount +
                ", mmNoPassCount=" + mmNoPassCount +
                ", mmPassRate=" + mmPassRate +
                ", mmNoPassRate=" + mmNoPassRate +
                ", ppCount=" + ppCount +
                ", ppPassCount=" + ppPassCount +
                ", ppNoPassCount=" + ppNoPassCount +
                ", ppPassRate=" + ppPassRate +
                ", ppNoPassRate=" + ppNoPassRate +
                ", mechanicalInspectionCount=" + mechanicalInspectionCount +
                ", mechanicalInspectionPassCount=" + mechanicalInspectionPassCount +
                ", mechanicalInspectionNoPassCount=" + mechanicalInspectionNoPassCount +
                ", mechanicalInspectionPassRate=" + mechanicalInspectionPassRate +
                ", mechanicalInspectionNoPassRate=" + mechanicalInspectionNoPassRate +
                '}';
    }
}
