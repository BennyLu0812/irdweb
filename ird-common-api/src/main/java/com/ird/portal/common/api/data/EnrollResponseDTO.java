package com.ird.portal.common.api.data;

/**
 *
 * 進場校驗的返回數據 DTO
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 2021/12/10 14:43<br/>
 * @author Vincent
 * @version 1.0
 */
public class EnrollResponseDTO {

    /**
     * 校驗結果代碼
     */
    private String result;

    /**
     * 校驗結果描述
     */
    private String resultMsg;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    @Override
    public String toString() {
        return "EnrollResponseDTO{" +
                "result='" + result + '\'' +
                ", resultMsg='" + resultMsg + '\'' +
                '}';
    }
}
