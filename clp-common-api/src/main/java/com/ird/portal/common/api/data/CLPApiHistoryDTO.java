package com.ird.portal.common.api.data;

import com.ird.portal.data.BaseDTO;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * @author Benny
 * @description: CLP ApiHistory DTO
 * @date 2023/1/30
 */
public class CLPApiHistoryDTO extends BaseDTO {

    private Integer apiHistoryId;

    /**
     * api Name
     */
    private String apiName;

    /**
     * Request Params
     */
    private String apiRequestParams;

    /**
     * Response Values
     */
    private String apiResponseValues;

    /**
     * Response Status
     */
    private String apiResponseStatus;

    /**
     *  Media Type (application/json or multipart/form-data)
     */
    private String apiMediaType;

    /**
     * x509CretFile  name
     */
    private String apiFileName;

    /**
     * x509CretFile  path
     */
    private String apiFilePath;

    public Integer getApiHistoryId() {
        return apiHistoryId;
    }

    public void setApiHistoryId(Integer apiHistoryId) {
        this.apiHistoryId = apiHistoryId;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getApiRequestParams() {
        return apiRequestParams;
    }

    public void setApiRequestParams(String apiRequestParams) {
        this.apiRequestParams = apiRequestParams;
    }

    public String getApiResponseValues() {
        return apiResponseValues;
    }

    public void setApiResponseValues(String apiResponseValues) {
        this.apiResponseValues = apiResponseValues;
    }

    public String getApiResponseStatus() {
        return apiResponseStatus;
    }

    public void setApiResponseStatus(String apiResponseStatus) {
        this.apiResponseStatus = apiResponseStatus;
    }

    public String getApiMediaType() {
        return apiMediaType;
    }

    public void setApiMediaType(String apiMediaType) {
        this.apiMediaType = apiMediaType;
    }

    public String getApiFileName() {
        return apiFileName;
    }

    public void setApiFileName(String apiFileName) {
        this.apiFileName = apiFileName;
    }

    public String getApiFilePath() {
        return apiFilePath;
    }

    public void setApiFilePath(String apiFilePath) {
        this.apiFilePath = apiFilePath;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}
