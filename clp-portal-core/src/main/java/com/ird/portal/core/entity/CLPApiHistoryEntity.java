package com.ird.portal.core.entity;

import com.ird.portal.audit.annotation.Audited;
import com.ird.portal.entity.AbstractEntity;

import javax.persistence.*;


/**
 * @version 1.0
 * @description: 調用別人系統api後需要記錄日誌。
 * @DATE: 2023/1/16
 * @author: Benny
 */

@Audited
@Entity
@Table(name="CLP_API_HISTORY")
public class CLPApiHistoryEntity extends AbstractEntity {

    private Integer apiHistoryId;

    /**
     * Request Params
     */
    private String apiRequestParams;

    /**
     * Response Values
     */
    private String apiResponseValues;

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

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLP_API_HISTORY_SEQ")
    @SequenceGenerator(name = "CLP_API_HISTORY_SEQ", sequenceName = "CLP_API_HISTORY_SEQ", allocationSize = 1)
    @Column(name = "API_HISTORY_ID")
    public Integer getApiHistoryId() {
        return apiHistoryId;
    }

    public void setApiHistoryId(Integer apiHistoryId) {
        this.apiHistoryId = apiHistoryId;
    }

    @Column(name = "API_REQUEST_PARAMS")
    public String getApiRequestParams() {
        return apiRequestParams;
    }

    public void setApiRequestParams(String apiRequestParams) {
        this.apiRequestParams = apiRequestParams;
    }

    @Column(name = "API_RESPONSE_VALUES")
    public String getApiResponseValues() {
        return apiResponseValues;
    }

    public void setApiResponseValues(String apiResponseValues) {
        this.apiResponseValues = apiResponseValues;
    }

    @Column(name = "API_MEDIA_TYPE")
    public String getApiMediaType() {
        return apiMediaType;
    }

    public void setApiMediaType(String apiMediaType) {
        this.apiMediaType = apiMediaType;
    }

    @Column(name = "API_FILE_NAME")
    public String getApiFileName() {
        return apiFileName;
    }

    public void setApiFileName(String apiFileName) {
        this.apiFileName = apiFileName;
    }

    @Column(name = "API_FILE_PATH")
    public String getApiFilePath() {
        return apiFilePath;
    }

    public void setApiFilePath(String apiFilePath) {
        this.apiFilePath = apiFilePath;
    }
}
