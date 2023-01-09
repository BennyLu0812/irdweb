package com.ird.portal.common.rpt.data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Tim
 * @version 1.0
 * @date 07/02/2022 9:52
 */
public class BenExhaustStatisticsDTO extends ReportExportBaseDTO {

    /**
     * 報表類型
     */
    private String type;

    /**
     * 驗車編號
     */
    private String inspMasterId;

    /**
     * 檢驗次數
     */
    private Integer noOfTimesInsp;

    /**
     * 地點
     */
    private String centerNameCn;

    /**
     * 車輛號牌
     */
    private String plateNo;

    /**
     * 車輛類型
     */
    private String vehType;

    /**
     * 車身編號
     */
    private String vin;

    /**
     * 引擎編號
     */
    private String engineNo;

    /**
     * 品牌
     */
    private String vehBrandCode;

    /**
     * 型號
     */
    private String vehModel;

    /**
     * 出廠年份
     */
    private Integer vehBuildYear;

    /**
     * 型號年份
     */
    private Integer vtaYear;

    /**
     * 登記日期
     */
    private Date vehRegDate;

    /**
     * 最大馬力
     */
    private BigDecimal maxPower;

    /**
     * 馬力類型
     */
    private String powerUnitType;

    /**
     * 氣缸容量
     */
    private BigDecimal cylinderVol;

    /**
     * 燃油類別
     */
    private String fuelType;

    /**
     * 燃油類別中文
     */
    private String fuelTypeCn;

    /**
     * 燃油類別葡文
     */
    private String fuelTypePt;

    /**
     * 供油方式
     */
    private String fuelSupplyType;

    /**
     * 供油方式中文
     */
    private String fuelSupplyTypeCn;

    /**
     * 車輛種類
     */
    private String vehCategory;

    /**
     * 車輛種類中文
     */
    private String vehCategoryCn;

    /**
     * 車輛種類葡文
     */
    private String vehCategoryPt;

    /**
     * 車輛用途
     */
    private String vehUsageCode;

    /**
     * 車輛用途中文
     */
    private String vehUsageCodeCn;

    /**
     * 車輛用途葡文
     */
    private String vehUsageCodePt;

    /**
     * 來源地
     */
    private String vehBuildCtryCode;

    /**
     * 車身重量
     */
    private BigDecimal vehWeight;

    /**
     * 縂重量
     */
    private BigDecimal vehGrossWeight;

    /**
     * 檢驗時間
     */
    private Date inspTime;

    /**
     * ASM5025_CO測量值[%]
     */
    private BigDecimal eeCo5025;

    /**
     * ASM5025_CO判定結果
     */
    private String eeCo5025Result;

    /**
     * ASM5025_HC測量值[ppm]
     */
    private BigDecimal eeHc5025;

    /**
     * ASM5025_HC判定結果
     */
    private String eeHc5025Result;

    /**
     * ASM5025_NO測量值[ppm]
     */
    private BigDecimal eeNo5025;

    /**
     * ASM5025_NO判定結果
     */
    private String eeNo5025Result;

    /**
     * ASM2540_CO測量值[%]
     */
    private BigDecimal eeCo2540;

    /**
     * ASM2540_CO判定結果
     */
    private String eeCo2540Result;

    /**
     * ASM2540_HC測量值[ppm]
     */
    private BigDecimal eeHc2540;

    /**
     * ASM2540_HC判定結果
     */
    private String eeHc2540Result;

    /**
     * ASM2540_NO測量值[ppm]
     */
    private BigDecimal eeNo2540;

    /**
     * ASM2540_NO判定結果
     */
    private String eeNo2540Result;

    /**
     * E項目檢驗的縂判定結果
     */
    private String eeOverallResult;

    /**
     * LD煙霧(100%)測量值[HSU]
     */
    private BigDecimal ffHsu100;

    /**
     * LD煙霧(90%)測量值[HSU]
     */
    private BigDecimal ffHsu90;

    /**
     * LD煙霧(80%)測量值[HSU]
     */
    private BigDecimal ffHsu80;

    /**
     * LD最大輪邊功率[kW]
     */
    private BigDecimal ffMaxWp;

    /**
     * F項目檢驗的縂判定結果
     */
    private String ffOverallResult;

    /**
     * 怠速CO測量值[%]
     */
    private BigDecimal ddCoIdle;

    /**
     * 怠速HC測量值[ppm]
     */
    private BigDecimal ddHcIdle;

    /**
     * D項目檢驗的縂判定結果
     */
    private String ddOverallResult;

    /**
     * 怠速CO測量值[%]
     */
    private BigDecimal bbCoIdle;

    /**
     * 怠速HC測量值[ppm]
     */
    private BigDecimal bbHcIdle;

    /**
     * 高怠速CO測量值[%]
     */
    private BigDecimal bbCoHighIdle;

    /**
     * 高怠速HC測量值[ppm]
     */
    private BigDecimal bbHcHighIdle;

    /**
     * B項目檢驗的縂判定結果
     */
    private String bbOverallResult;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getCenterNameCn() {
        return centerNameCn;
    }

    public void setCenterNameCn(String centerNameCn) {
        this.centerNameCn = centerNameCn;
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

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getEngineNo() {
        return engineNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
    }

    public String getVehBrandCode() {
        return vehBrandCode;
    }

    public void setVehBrandCode(String vehBrandCode) {
        this.vehBrandCode = vehBrandCode;
    }

    public String getVehModel() {
        return vehModel;
    }

    public void setVehModel(String vehModel) {
        this.vehModel = vehModel;
    }

    public Integer getVehBuildYear() {
        return vehBuildYear;
    }

    public void setVehBuildYear(Integer vehBuildYear) {
        this.vehBuildYear = vehBuildYear;
    }

    public Integer getVtaYear() {
        return vtaYear;
    }

    public void setVtaYear(Integer vtaYear) {
        this.vtaYear = vtaYear;
    }

    public Date getVehRegDate() {
        return vehRegDate;
    }

    public void setVehRegDate(Date vehRegDate) {
        this.vehRegDate = vehRegDate;
    }

    public BigDecimal getMaxPower() {
        return maxPower;
    }

    public void setMaxPower(BigDecimal maxPower) {
        this.maxPower = maxPower;
    }

    public String getPowerUnitType() {
        return powerUnitType;
    }

    public void setPowerUnitType(String powerUnitType) {
        this.powerUnitType = powerUnitType;
    }

    public BigDecimal getCylinderVol() {
        return cylinderVol;
    }

    public void setCylinderVol(BigDecimal cylinderVol) {
        this.cylinderVol = cylinderVol;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getFuelTypeCn() {
        return fuelTypeCn;
    }

    public void setFuelTypeCn(String fuelTypeCn) {
        this.fuelTypeCn = fuelTypeCn;
    }

    public String getFuelTypePt() {
        return fuelTypePt;
    }

    public void setFuelTypePt(String fuelTypePt) {
        this.fuelTypePt = fuelTypePt;
    }

    public String getFuelSupplyType() {
        return fuelSupplyType;
    }

    public void setFuelSupplyType(String fuelSupplyType) {
        this.fuelSupplyType = fuelSupplyType;
    }

    public String getFuelSupplyTypeCn() {
        return fuelSupplyTypeCn;
    }

    public void setFuelSupplyTypeCn(String fuelSupplyTypeCn) {
        this.fuelSupplyTypeCn = fuelSupplyTypeCn;
    }

    public String getVehCategory() {
        return vehCategory;
    }

    public void setVehCategory(String vehCategory) {
        this.vehCategory = vehCategory;
    }

    public String getVehCategoryCn() {
        return vehCategoryCn;
    }

    public void setVehCategoryCn(String vehCategoryCn) {
        this.vehCategoryCn = vehCategoryCn;
    }

    public String getVehCategoryPt() {
        return vehCategoryPt;
    }

    public void setVehCategoryPt(String vehCategoryPt) {
        this.vehCategoryPt = vehCategoryPt;
    }

    public String getVehUsageCode() {
        return vehUsageCode;
    }

    public void setVehUsageCode(String vehUsageCode) {
        this.vehUsageCode = vehUsageCode;
    }

    public String getVehUsageCodeCn() {
        return vehUsageCodeCn;
    }

    public void setVehUsageCodeCn(String vehUsageCodeCn) {
        this.vehUsageCodeCn = vehUsageCodeCn;
    }

    public String getVehUsageCodePt() {
        return vehUsageCodePt;
    }

    public void setVehUsageCodePt(String vehUsageCodePt) {
        this.vehUsageCodePt = vehUsageCodePt;
    }

    public String getVehBuildCtryCode() {
        return vehBuildCtryCode;
    }

    public void setVehBuildCtryCode(String vehBuildCtryCode) {
        this.vehBuildCtryCode = vehBuildCtryCode;
    }

    public BigDecimal getVehWeight() {
        return vehWeight;
    }

    public void setVehWeight(BigDecimal vehWeight) {
        this.vehWeight = vehWeight;
    }

    public BigDecimal getVehGrossWeight() {
        return vehGrossWeight;
    }

    public void setVehGrossWeight(BigDecimal vehGrossWeight) {
        this.vehGrossWeight = vehGrossWeight;
    }

    public Date getInspTime() {
        return inspTime;
    }

    public void setInspTime(Date inspTime) {
        this.inspTime = inspTime;
    }

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

    public BigDecimal getEeNo2540() {
        return eeNo2540;
    }

    public void setEeNo2540(BigDecimal eeNo2540) {
        this.eeNo2540 = eeNo2540;
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
        return "BenExhaustStatisticsDTO{" +
                "type='" + type + '\'' +
                ", inspMasterId='" + inspMasterId + '\'' +
                ", noOfTimesInsp=" + noOfTimesInsp +
                ", centerNameCn='" + centerNameCn + '\'' +
                ", plateNo='" + plateNo + '\'' +
                ", vehType='" + vehType + '\'' +
                ", vin='" + vin + '\'' +
                ", engineNo='" + engineNo + '\'' +
                ", vehBrandCode='" + vehBrandCode + '\'' +
                ", vehModel='" + vehModel + '\'' +
                ", vehBuildYear=" + vehBuildYear +
                ", vtaYear=" + vtaYear +
                ", vehRegDate=" + vehRegDate +
                ", maxPower=" + maxPower +
                ", powerUnitType='" + powerUnitType + '\'' +
                ", cylinderVol=" + cylinderVol +
                ", fuelType='" + fuelType + '\'' +
                ", fuelTypeCn='" + fuelTypeCn + '\'' +
                ", fuelTypePt='" + fuelTypePt + '\'' +
                ", fuelSupplyType='" + fuelSupplyType + '\'' +
                ", fuelSupplyTypeCn='" + fuelSupplyTypeCn + '\'' +
                ", vehCategory='" + vehCategory + '\'' +
                ", vehCategoryCn='" + vehCategoryCn + '\'' +
                ", vehCategoryPt='" + vehCategoryPt + '\'' +
                ", vehUsageCode='" + vehUsageCode + '\'' +
                ", vehUsageCodeCn='" + vehUsageCodeCn + '\'' +
                ", vehUsageCodePt='" + vehUsageCodePt + '\'' +
                ", vehBuildCtryCode='" + vehBuildCtryCode + '\'' +
                ", vehWeight=" + vehWeight +
                ", vehGrossWeight=" + vehGrossWeight +
                ", inspTime=" + inspTime +
                ", eeCo5025=" + eeCo5025 +
                ", eeCo5025Result='" + eeCo5025Result + '\'' +
                ", eeHc5025=" + eeHc5025 +
                ", eeHc5025Result='" + eeHc5025Result + '\'' +
                ", eeNo5025=" + eeNo5025 +
                ", eeNo5025Result='" + eeNo5025Result + '\'' +
                ", eeCo2540=" + eeCo2540 +
                ", eeCo2540Result='" + eeCo2540Result + '\'' +
                ", eeHc2540=" + eeHc2540 +
                ", eeHc2540Result='" + eeHc2540Result + '\'' +
                ", eeNo2540=" + eeNo2540 +
                ", eeNo2540Result='" + eeNo2540Result + '\'' +
                ", eeOverallResult='" + eeOverallResult + '\'' +
                ", ffHsu100=" + ffHsu100 +
                ", ffHsu90=" + ffHsu90 +
                ", ffHsu80=" + ffHsu80 +
                ", ffMaxWp=" + ffMaxWp +
                ", ffOverallResult='" + ffOverallResult + '\'' +
                ", ddCoIdle=" + ddCoIdle +
                ", ddHcIdle=" + ddHcIdle +
                ", ddOverallResult='" + ddOverallResult + '\'' +
                ", bbCoIdle=" + bbCoIdle +
                ", bbHcIdle=" + bbHcIdle +
                ", bbCoHighIdle=" + bbCoHighIdle +
                ", bbHcHighIdle=" + bbHcHighIdle +
                ", bbOverallResult='" + bbOverallResult + '\'' +
                '}';
    }
}
