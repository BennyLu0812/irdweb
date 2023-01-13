package com.ird.portal.common.rpt.data;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author Tim
 * @version 1.0
 * @date 24/01/2022 9:19
 */
public class InspectionDataStatisticsDTO extends ReportExportBaseDTO {

    /**
     * 驗車中心中文名
     */
    @ExcelProperty("驗車中心名稱")
    private String centerNameCn;

    /**
     * 檢驗時間
     */
    @ExcelProperty("時間")
    private Date inspTime;

    /**
     * 驗車主檔編號
     */
    @ExcelProperty("驗車編號")
    private String inspMasterId;

    /**
     * 驗車次數
     */
    @ExcelProperty("驗車次數")
    private Integer noOfTimesInsp;

    /**
     * 車輛號牌
     */
    @ExcelProperty("車輛號牌")
    private String plateNo;

    /**
     * 車輛級別
     */
    @ExcelIgnore
    private String vehType;

    /**
     * 車輛級別中文名
     */
    @ExcelProperty("車輛類型")
    private String vehTypeCn;

    /**
     * 檢驗類別
     */
    @ExcelIgnore
    private String cvicInspType;

    /**
     * 檢驗類別中文名
     */
    @ExcelProperty("檢驗類別")
    private String cvicInspTypeCn;

    /**
     * 業務子類別
     */
    @ExcelIgnore
    private String inspSubtypeId;

    /**
     * 業務子類別
     */
    @ExcelProperty("業務子類別")
    private String inspSubtypeIdCn;

    /**
     * 檢測線名稱
     */
    @ExcelProperty("檢測線名稱")
    private String inspLineNo;

    @ExcelProperty("A(目視及底盤檢驗)")
    private String aoverallResult;

    @ExcelProperty("B(汽油／天然氣汽車尾氣排放)")
    private String boverallResult;

    @ExcelProperty("C(柴油汽車尾氣排放)")
    private String coverallResult;

    @ExcelProperty("D(摩托車尾氣排放)")
    private String doverallResult;

    @ExcelProperty("E(汽油汽車尾氣排放（穩態工況法）)")
    private String eoverallResult;

    @ExcelProperty("F(柴油汽車尾氣排放（加載減速法）)")
    private String foverallResult;

    @ExcelProperty("G(側滑檢測)")
    private String gsideslipResult;

    @ExcelProperty("H(行車制動 (儀器))")
    private String hbrkEffTResult;

    @ExcelProperty("I(行車制動 (路試))")
    private String ibrkResult;

    @ExcelProperty("J(駐車制動 (儀器))")
    private String jparkEffTResult;

    @ExcelProperty("K(駐車制動 (路試))")
    private String kparkResult;

    @ExcelProperty("L(前照燈)")
    private String loverallResult;

    @ExcelProperty("M(噪音)")
    private String mengineNoiseResult;

    @ExcelProperty("P(計程錶)")
    private String poverallResult;

    @ExcelProperty("機械檢驗結果")
    private String mechanicalInspectionResult;

    @ExcelProperty("檢驗結果")
    private String inspectionResult;

    @ExcelProperty("不合格信息")
    private String unqualifiedInfo;

    public String getCenterNameCn() {
        return centerNameCn;
    }

    public void setCenterNameCn(String centerNameCn) {
        this.centerNameCn = centerNameCn;
    }

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss",timezone="GMT+8")
    public Date getInspTime() {
        return inspTime;
    }

    public void setInspTime(Date inspTime) {
        this.inspTime = inspTime;
    }

    public String getInspMasterId() {
        return inspMasterId;
    }

    public void setInspMasterId(String inspMasterId) {
        this.inspMasterId = inspMasterId;
    }

    public Integer getNoOfTimesInsp() {
        return noOfTimesInsp;
    }

    public void setNoOfTimesInsp(Integer noOfTimesInsp) {
        this.noOfTimesInsp = noOfTimesInsp;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getVehType() {
        return vehType;
    }

    public void setVehType(String vehType) {
        this.vehType = vehType;
    }

    public String getVehTypeCn() {
        return vehTypeCn;
    }

    public void setVehTypeCn(String vehTypeCn) {
        this.vehTypeCn = vehTypeCn;
    }

    public String getCvicInspType() {
        return cvicInspType;
    }

    public void setCvicInspType(String cvicInspType) {
        this.cvicInspType = cvicInspType;
    }

    public String getCvicInspTypeCn() {
        return cvicInspTypeCn;
    }

    public void setCvicInspTypeCn(String cvicInspTypeCn) {
        this.cvicInspTypeCn = cvicInspTypeCn;
    }

    public String getInspSubtypeId() {
        return inspSubtypeId;
    }

    public void setInspSubtypeId(String inspSubtypeId) {
        this.inspSubtypeId = inspSubtypeId;
    }

    public String getInspSubtypeIdCn() {
        return inspSubtypeIdCn;
    }

    public void setInspSubtypeIdCn(String inspSubtypeIdCn) {
        this.inspSubtypeIdCn = inspSubtypeIdCn;
    }

    public String getInspLineNo() {
        return inspLineNo;
    }

    public void setInspLineNo(String inspLineNo) {
        this.inspLineNo = inspLineNo;
    }

    public String getAoverallResult() {
        return aoverallResult;
    }

    public void setAoverallResult(String aoverallResult) {
        this.aoverallResult = aoverallResult;
    }

    public String getBoverallResult() {
        return boverallResult;
    }

    public void setBoverallResult(String boverallResult) {
        this.boverallResult = boverallResult;
    }

    public String getCoverallResult() {
        return coverallResult;
    }

    public void setCoverallResult(String coverallResult) {
        this.coverallResult = coverallResult;
    }

    public String getDoverallResult() {
        return doverallResult;
    }

    public void setDoverallResult(String doverallResult) {
        this.doverallResult = doverallResult;
    }

    public String getEoverallResult() {
        return eoverallResult;
    }

    public void setEoverallResult(String eoverallResult) {
        this.eoverallResult = eoverallResult;
    }

    public String getFoverallResult() {
        return foverallResult;
    }

    public void setFoverallResult(String foverallResult) {
        this.foverallResult = foverallResult;
    }

    public String getGsideslipResult() {
        return gsideslipResult;
    }

    public void setGsideslipResult(String gsideslipResult) {
        this.gsideslipResult = gsideslipResult;
    }

    public String getHbrkEffTResult() {
        return hbrkEffTResult;
    }

    public void setHbrkEffTResult(String hbrkEffTResult) {
        this.hbrkEffTResult = hbrkEffTResult;
    }

    public String getIbrkResult() {
        return ibrkResult;
    }

    public void setIbrkResult(String ibrkResult) {
        this.ibrkResult = ibrkResult;
    }

    public String getJparkEffTResult() {
        return jparkEffTResult;
    }

    public void setJparkEffTResult(String jparkEffTResult) {
        this.jparkEffTResult = jparkEffTResult;
    }

    public String getKparkResult() {
        return kparkResult;
    }

    public void setKparkResult(String kparkResult) {
        this.kparkResult = kparkResult;
    }

    public String getLoverallResult() {
        return loverallResult;
    }

    public void setLoverallResult(String loverallResult) {
        this.loverallResult = loverallResult;
    }

    public String getMengineNoiseResult() {
        return mengineNoiseResult;
    }

    public void setMengineNoiseResult(String mengineNoiseResult) {
        this.mengineNoiseResult = mengineNoiseResult;
    }

    public String getPoverallResult() {
        return poverallResult;
    }

    public void setPoverallResult(String poverallResult) {
        this.poverallResult = poverallResult;
    }

    public String getMechanicalInspectionResult() {
        return mechanicalInspectionResult;
    }

    public void setMechanicalInspectionResult(String mechanicalInspectionResult) {
        this.mechanicalInspectionResult = mechanicalInspectionResult;
    }

    public String getInspectionResult() {
        return inspectionResult;
    }

    public void setInspectionResult(String inspectionResult) {
        this.inspectionResult = inspectionResult;
    }

    public String getUnqualifiedInfo() {
        return unqualifiedInfo;
    }

    public void setUnqualifiedInfo(String unqualifiedInfo) {
        this.unqualifiedInfo = unqualifiedInfo;
    }

    @Override
    public String toString() {
        return "InspectionDataStatisticsDTO{" +
                "centerNameCn='" + centerNameCn + '\'' +
                ", inspTime=" + inspTime +
                ", inspMasterId='" + inspMasterId + '\'' +
                ", noOfTimesInsp=" + noOfTimesInsp +
                ", plateNo='" + plateNo + '\'' +
                ", vehType='" + vehType + '\'' +
                ", vehTypeCn='" + vehTypeCn + '\'' +
                ", cvicInspType='" + cvicInspType + '\'' +
                ", cvicInspTypeCn='" + cvicInspTypeCn + '\'' +
                ", inspSubtypeId='" + inspSubtypeId + '\'' +
                ", inspSubtypeIdCn='" + inspSubtypeIdCn + '\'' +
                ", inspLineNo='" + inspLineNo + '\'' +
                ", aoverallResult='" + aoverallResult + '\'' +
                ", boverallResult='" + boverallResult + '\'' +
                ", coverallResult='" + coverallResult + '\'' +
                ", doverallResult='" + doverallResult + '\'' +
                ", eoverallResult='" + eoverallResult + '\'' +
                ", foverallResult='" + foverallResult + '\'' +
                ", gsideslipResult='" + gsideslipResult + '\'' +
                ", hbrkEffTResult='" + hbrkEffTResult + '\'' +
                ", ibrkResult='" + ibrkResult + '\'' +
                ", jparkEffTResult='" + jparkEffTResult + '\'' +
                ", kparkResult='" + kparkResult + '\'' +
                ", loverallResult='" + loverallResult + '\'' +
                ", mengineNoiseResult='" + mengineNoiseResult + '\'' +
                ", poverallResult='" + poverallResult + '\'' +
                ", mechanicalInspectionResult='" + mechanicalInspectionResult + '\'' +
                ", inspectionResult='" + inspectionResult + '\'' +
                ", unqualifiedInfo='" + unqualifiedInfo + '\'' +
                '}';
    }
}
