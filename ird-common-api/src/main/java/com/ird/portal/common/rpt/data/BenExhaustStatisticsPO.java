package com.ird.portal.common.rpt.data;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Tim
 * @version 1.0
 * @date 07/02/2022 10:59
 */
public class BenExhaustStatisticsPO {

    /**
     * 驗車編號
     */
    @ExcelProperty(value = "驗車編號", order = 0)
    private String inspMasterId;

    /**
     * 檢驗次數
     */
    @ExcelProperty(value = "檢驗次數", order = 1)
    private Integer noOfTimesInsp;

    /**
     * 地點
     */
    @ExcelProperty(value = "地點", order = 2)
    private String centerNameCn;

    /**
     * 車輛號牌
     */
    @ExcelProperty(value = "車輛號牌", order = 3)
    private String plateNo;

    /**
     * 車輛類型
     */
    @ExcelProperty(value = "車輛類型", order = 4)
    private String vehType;

    /**
     * 車身編號
     */
    @ExcelProperty(value = "車身編號", order = 5)
    private String vin;

    /**
     * 引擎編號
     */
    @ExcelProperty(value = "引擎編號", order = 6)
    private String engineNo;

    /**
     * 品牌
     */
    @ExcelProperty(value = "品牌", order = 7)
    private String vehBrandCode;

    /**
     * 型號
     */
    @ExcelProperty(value = "型號", order = 8)
    private String vehModel;

    /**
     * 出廠年份
     */
    @ExcelProperty(value = "出廠年份", order = 9)
    private Integer vehBuildYear;

    /**
     * 型號年份
     */
    @ExcelProperty(value = "型號年份", order = 10)
    private Integer vtaYear;

    /**
     * 登記日期
     */
    @ExcelProperty(value = "登記日期", order = 11)
    @ColumnWidth(20)
    private Date vehRegDate;

    /**
     * 最大馬力
     */
    @ExcelProperty(value = "最大馬力", order = 12)
    private BigDecimal maxPower;

    /**
     * 馬力類型
     */
    @ExcelProperty(value = "馬力類型", order = 13)
    private String powerUnitType;

    /**
     * 氣缸容量
     */
    @ExcelProperty(value = "氣缸容量", order = 14)
    private BigDecimal cylinderVol;

    /**
     * 燃油類別
     */
    @ExcelProperty(value = "燃油類別", order = 15)
    private String fuelType;

    /**
     * 燃油類別中文
     */
    @ExcelProperty(value = "燃油類別中文", order = 16)
    private String fuelTypeCn;

    /**
     * 燃油類別葡文
     */
    @ExcelProperty(value = "燃油類別葡文", order = 17)
    private String fuelTypePt;

    /**
     * 供油方式
     */
    @ExcelProperty(value = "供油方式", order = 18)
    private String fuelSupplyTypeCn;

    /**
     * 車輛種類
     */
    @ExcelProperty(value = "車輛種類", order = 19)
    private String vehCategory;

    /**
     * 車輛種類中文
     */
    @ExcelProperty(value = "車輛種類中文", order = 20)
    private String vehCategoryCn;

    /**
     * 車輛種類葡文
     */
    @ExcelProperty(value = "車輛種類葡文", order = 21)
    private String vehCategoryPt;

    /**
     * 車輛用途
     */
    @ExcelProperty(value = "車輛用途", order = 22)
    private String vehUsageCode;

    /**
     * 車輛用途中文
     */
    @ExcelProperty(value = "車輛用途中文", order = 23)
    private String vehUsageCodeCn;

    /**
     * 車輛用途葡文
     */
    @ExcelProperty(value = "車輛用途葡文", order = 24)
    private String vehUsageCodePt;

    /**
     * 來源地
     */
    @ExcelProperty(value = "來源地", order = 25)
    private String vehBuildCtryCode;

    /**
     * 車身重量
     */
    @ExcelProperty(value = "車身重量", order = 26)
    private BigDecimal vehWeight;

    /**
     * 縂重量
     */
    @ExcelProperty(value = "縂重量", order = 27)
    private BigDecimal vehGrossWeight;

    /**
     * 檢驗時間
     */
    @ExcelProperty(value = "檢驗時間", order = 28)
    @ColumnWidth(20)
    private Date inspTime;

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

    @Override
    public String toString() {
        return "BenExhaustStatisticsPO{" +
                "inspMasterId='" + inspMasterId + '\'' +
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
                '}';
    }
}
