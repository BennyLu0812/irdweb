package com.ird.portal.sys.service;

import com.ird.portal.common.sys.data.SummaryGraphDTO;
import com.ird.portal.common.sys.data.TableTotalDTO;

import java.util.List;
import java.util.Map;

/**
 　　* @description:Dashboard統計圖
 　　* @return
 　　* @throws
 　　* @author Vincent
 　　* @date 2021/11/4 14:41
 　　*/
public interface TotalDashboardService {

    /**
     * 獲取業務分類統計數據（入場數量和出場數量）
     * @param centerCode 驗車中心
     * @param inspectionDate 驗車日期
     * @return
     */
    SummaryGraphDTO statisticsByCategory(String centerCode, String inspectionDate);

    /**
     *
     * @param centerCode 驗車中心
     * @param inspectionDate 驗車日期
     * @return
     */
    List<TableTotalDTO> getTableSumTotal(String centerCode, String inspectionDate);

    /**
     * 獲取車輛平均檢驗時間和有效記錄
     * @param centerCode 驗車中心
     * @param inspectionDate 驗車日期
     * @return
     */
    Map<String,Integer> getCitizenAvgData(String centerCode, String inspectionDate);

    /**
     * 獲取市民平均等待時間和有效記錄
     * @param centerCode 驗車中心
     * @param inspectionDate 驗車日期
     * @return
     */
    Map<String,Integer> getCarAvgData(String centerCode, String inspectionDate);


}
