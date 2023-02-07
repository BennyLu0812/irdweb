package com.ird.portal.common.api.data;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.math.BigDecimal;

/**
 * @author Benny
 * @description: UploadFileDTO
 * @date 2023/1/29
 */
public class UploadFileDTO {
    private BigDecimal size;
    private String fileValue;
    private String fileName;
    private byte[] fileBytes;
    private String filePath;

    public BigDecimal getSize() {
        return size;
    }

    public void setSize(BigDecimal size) {
        this.size = size;
    }

    public String getFileValue() {
        return fileValue;
    }

    public void setFileValue(String fileValue) {
        this.fileValue = fileValue;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getFileBytes() {
        return fileBytes;
    }

    public void setFileBytes(byte[] fileBytes) {
        this.fileBytes = fileBytes;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}
