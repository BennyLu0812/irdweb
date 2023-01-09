package com.ird.portal.common.rpt.enums;

import java.util.Arrays;

/**
 * @author Tim
 * @version 1.0
 * @date 07/02/2022 11:24
 */
public enum BenExhaustStatisticsTypeEnum {
    /**
     * ASM檢測數據統計
     */
    ASM_INSP_DATA_STATISTICS("1", "ASM檢測數據統計"),

    /**
     * Lugdown檢測數據統計
     */
    LUGDOWN_INSP_DATA_STATISTICS("2", "Lugdown檢測數據統計"),

    /**
     * 摩托車怠速檢測數據統計
     */
    MOTORCYCLE_IDLE_INSP_DATA_STATISTICS("3", "摩托車怠速檢測數據統計"),

    /**
     * 汽車雙怠速檢測數據統計
     */
    CAR_DOUBLE_IDLE_INSP_DATA_STATISTICS("4", "汽車雙怠速檢測數據統計");

    private String code;

    private String text;

    BenExhaustStatisticsTypeEnum(String code, String text) {
        this.code = code;
        this.text = text;
    }

    public String getCode() {
        return code;
    }

    public String getText() {
        return text;
    }

    public static BenExhaustStatisticsTypeEnum valueOfCode(String code) {
        return Arrays.stream(BenExhaustStatisticsTypeEnum.values())
                .filter(benExhaustStatisticsTypeEnum -> benExhaustStatisticsTypeEnum.code.equals(code))
                .findFirst().orElse(null);
    }
}
