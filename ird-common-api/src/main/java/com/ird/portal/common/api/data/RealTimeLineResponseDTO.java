package com.ird.portal.common.api.data;

/**
 * @Description
 * @Author Aaron
 * @Date 2021/11/2 16:16
 * @Version 1.0
 */

public class RealTimeLineResponseDTO {

    private String lineName;

    private Integer lineNum;

    public RealTimeLineResponseDTO() {
    }

    public RealTimeLineResponseDTO(String lineName, Integer lineNum) {
        this.lineName = lineName;
        this.lineNum = lineNum;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public Integer getLineNum() {
        return lineNum;
    }

    public void setLineNum(Integer lineNum) {
        this.lineNum = lineNum;
    }

    @Override
    public String toString() {
        return "RealTimeLineResponseDTO{" +
                "lineName='" + lineName + '\'' +
                ", lineNum=" + lineNum +
                '}';
    }
}
