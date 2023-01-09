package com.ird.portal.util;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 引擎編號格式化
 * @author AugusChen
 */
public class EngineNoFormatUtil {

    public static String formatEngineNo(String engineNo,String engineNo2,String engineNo3,String engineNo4){
        return formatVemregEngineNo( formatVemregEngineNo(engineNo, engineNo2), formatVemregEngineNo(engineNo3, engineNo4) );
    }

    public static List<String> get4EngineNo(String engineNo, String engineNo2, String engineNo3, String engineNo4){
        List<String> engineNoList = new ArrayList<>();
        if(StringUtils.isNotBlank(engineNo)){
            engineNoList.add(engineNo);
        }
        if(StringUtils.isNotBlank(engineNo2)){
            engineNoList.add(engineNo2);
        }
        if(StringUtils.isNotBlank(engineNo3)){
            engineNoList.add(engineNo3);
        }
        if(StringUtils.isNotBlank(engineNo4)){
            engineNoList.add(engineNo4);
        }
        return engineNoList;
    }

    public static String formatVemregEngineNo(String engineNo,String engineNo2){
        if(StringUtils.isBlank(engineNo) && StringUtils.isBlank(engineNo2)){
            return "";
        }
        if(StringUtils.isBlank(engineNo2)){
            return engineNo;
        }
        if(StringUtils.isBlank(engineNo)){
            return engineNo2;
        }
        return engineNo+" / "+engineNo2;
    }

    //存在多于三个马达时调用(作用于第一行,車輛證明書調用)
    public static String formatVemreg4EngineNo(String engineNo,String engineNo2){
        if(StringUtils.isBlank(engineNo) && StringUtils.isBlank(engineNo2)){
            return "";
        }
        if(StringUtils.isBlank(engineNo2)){
            return engineNo;
        }
        if(StringUtils.isBlank(engineNo)){
            return engineNo2;
        }
        return engineNo+" / "+engineNo2+" / ";
    }
}
