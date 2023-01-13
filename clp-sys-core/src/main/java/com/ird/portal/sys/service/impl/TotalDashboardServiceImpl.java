package com.ird.portal.sys.service.impl;

import com.ird.portal.common.sys.data.StatisticsDTO;
import com.ird.portal.common.sys.data.SummaryGraphDTO;
import com.ird.portal.common.sys.data.TableTotalDTO;
import com.ird.portal.exception.ParameterIsEmptyException;
import com.ird.portal.sys.mapper.TotalDashboardMapper;
import com.ird.portal.sys.service.TotalDashboardService;
import com.ird.portal.util.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static com.ird.portal.util.DateUtil.DATE_PATTERN;
import static com.ird.portal.util.DateUtil.DATE_TIME_PATTERN;

/**
 * 　　* @description:Dashboard統計圖
 * 　　* @return
 * 　　* @throws
 * 　　* @author Vincent
 * 　　* @date 2021/11/4 14:41
 */
@Service
@Transactional
public class TotalDashboardServiceImpl implements TotalDashboardService {
    private static final Logger logger = LoggerFactory.getLogger(TotalDashboardServiceImpl.class);

    @Autowired
    private TotalDashboardMapper totalDashboardMapper;

    /**
     * 獲取業務分類統計數據（入場數量和出場數量）
     *
     * @param centerCode     驗車中心
     * @param inspectionDate 驗車日期
     * @return
     */
    @Override
    public SummaryGraphDTO statisticsByCategory(String centerCode, String inspectionDate) {
        if(StringUtils.isBlank(centerCode)){
            throw new ParameterIsEmptyException("centerCode");
        }
        if(StringUtils.isBlank(inspectionDate)){
            throw new ParameterIsEmptyException("inspectionDate");
        }

        Date createDate = DateUtil.parse(inspectionDate, DATE_PATTERN);
        logger.info("[statisticsByCategory] centerCode : {}, inspectionDate : {}, createDate :{}", centerCode, inspectionDate, createDate);

        //时间区间（8:00到18:00，間隔半個小時）
        List<String> workDate = getDayMi(DateUtil.parse(DateUtil.format(DateUtil.parse(inspectionDate, DATE_PATTERN))));

        //獲取符合條件的數據
        List<StatisticsDTO> entry_statistics = totalDashboardMapper.entryTimeTotal(centerCode, createDate);
        List<StatisticsDTO> complete_statistics = totalDashboardMapper.completeTimeTotal(centerCode, createDate);
        logger.info("[statisticsByCategory] entry_statistics : {}", entry_statistics);
        logger.info("[statisticsByCategory] complete_statistics : {}", complete_statistics);

        //將數據根據時間處理（8点之前算8点，18点之后算18点）
        List<Integer> entryBeforeAndAfter = statisticsWorkDate(entry_statistics, workDate);
        List<Integer> completeBeforeAndAfter = statisticsWorkDate(complete_statistics, workDate);
        logger.info("[statisticsByCategory] entryBeforeAndAfter : {}", entryBeforeAndAfter);
        logger.info("[statisticsByCategory] completeBeforeAndAfter : {}", completeBeforeAndAfter);

        //统计
        List<Integer> entryTimeTotal = statisticsResult(entry_statistics, workDate, entryBeforeAndAfter);
        List<Integer> completeTimeTotal = statisticsResult(complete_statistics, workDate, completeBeforeAndAfter);
        logger.info("[statisticsByCategory] entryTimeTotal : {}", entryTimeTotal);
        logger.info("[statisticsByCategory] completeTimeTotal : {}", completeTimeTotal);

        List<String> filterDate = new ArrayList<>();

        //过滤掉年月日
        for (String s : workDate) {
            filterDate.add(DateUtil.format(DateUtil.parse(s, DATE_TIME_PATTERN), "HH:mm"));
        }

        //返回统计图
        SummaryGraphDTO summaryGraphDTO = new SummaryGraphDTO();
        summaryGraphDTO.setWorkDate(filterDate);
        summaryGraphDTO.setEntryTimeTotal(entryTimeTotal);
        summaryGraphDTO.setCompleteTimeTotal(completeTimeTotal);

        logger.info("[statisticsByCategory] SummaryGraphDTO : {}", summaryGraphDTO);
        return summaryGraphDTO;
    }

    @Override
    public List<TableTotalDTO> getTableSumTotal(String centerCode, String inspectionDate) {
        if(StringUtils.isBlank(centerCode)){
            throw new ParameterIsEmptyException("centerCode");
        }
        if(StringUtils.isBlank(inspectionDate)){
            throw new ParameterIsEmptyException("inspectionDate");
        }

        Date createDate = DateUtil.parse(inspectionDate, DATE_PATTERN);
        logger.info("[getTableSumTotal] centerCode : {}, inspectionDate : {}, createDate :{}", centerCode, inspectionDate, createDate);

        List<TableTotalDTO> tableTotalDTOS = totalDashboardMapper.getTableSumTotal(centerCode, createDate);
        logger.info("[getTableSumTotal] tableTotalDTOS :{}", tableTotalDTOS);
        return tableTotalDTOS;
    }

    /**
     * 獲取車輛平均檢驗時間和有效記錄
     *
     * @param centerCode     驗車中心
     * @param inspectionDate 驗車日期
     * @return
     */
    @Override
    public Map<String, Integer> getCitizenAvgData(String centerCode, String inspectionDate) {
        if(StringUtils.isBlank(centerCode)){
            throw new ParameterIsEmptyException("centerCode");
        }
        if(StringUtils.isBlank(inspectionDate)){
            throw new ParameterIsEmptyException("inspectionDate");
        }

        Date createDate = DateUtil.parse(inspectionDate, DATE_PATTERN);
        logger.info("[getCitizenAvgData] centerCode : {}, inspectionDate : {}, createDate :{}", centerCode, inspectionDate, createDate);

        logger.info("[getCitizenAvgData] centerCode : {}, inspectionDate : {}", centerCode, inspectionDate);
        Map<String, Integer> maps = totalDashboardMapper.getCitizenAvgData(centerCode, createDate);
        logger.info("[getCitizenAvgData] maps :{}", maps);
        return maps;
    }

    /**
     * 獲取市民平均等待時間和有效記錄
     *
     * @param centerCode     驗車中心
     * @param inspectionDate 驗車日期
     * @return
     */
    @Override
    public Map<String, Integer> getCarAvgData(String centerCode, String inspectionDate) {
        if(StringUtils.isBlank(centerCode)){
            throw new ParameterIsEmptyException("centerCode");
        }
        if(StringUtils.isBlank(inspectionDate)){
            throw new ParameterIsEmptyException("inspectionDate");
        }

        Date createDate = DateUtil.parse(inspectionDate, DATE_PATTERN);
        logger.info("[getCarAvgData] centerCode : {}, inspectionDate : {}, createDate :{}", centerCode, inspectionDate, createDate);

        logger.info("[getCarAvgData] centerCode : {}, inspectionDate : {}", centerCode, inspectionDate);
        Map<String, Integer> maps = totalDashboardMapper.getCarAvgData(centerCode, createDate);
        logger.info("[getCarAvgData] maps :{}", maps);
        return maps;
    }


    /**
     * 　　* @description: 获取时间区间
     * 　　* @return
     * 　　* @throws
     * 　　* @author Vincent
     * 　　* @date 2022/2/16 16:46
     */
    private static List<String> getDayMi(Date date) {
        List<String> dateList = new ArrayList<String>();

        Calendar initDate = Calendar.getInstance();
        initDate.setTime(date);
        initDate.add(Calendar.HOUR_OF_DAY, 8);

        Calendar endDate = Calendar.getInstance();
        endDate.setTime(date);
        endDate.add(Calendar.DAY_OF_MONTH, 1);
        endDate.add(Calendar.HOUR_OF_DAY, 8);

        Calendar finalDate = Calendar.getInstance();
        finalDate.setTime(date);
        finalDate.add(Calendar.HOUR_OF_DAY, 18);


        for (; initDate.compareTo(endDate) < 0; initDate.add(Calendar.MINUTE, 30)) {
            logger.info("[getDayMi] 時間區間：{}", DateUtil.format(initDate.getTime(), DATE_TIME_PATTERN));
            dateList.add(DateUtil.format(initDate.getTime(), DATE_TIME_PATTERN));
            if (initDate.compareTo(finalDate) == 0) {
                break;
            }
        }
        return dateList;
    }

    /**
     * 　　* @description: 8点之前算8点，18点之后算18点
     * 　　* @return
     * 　　* @throws
     * 　　* @author Vincent
     * 　　* @date 2022/2/16 16:55
     */
    private static List<Integer> statisticsWorkDate(List<StatisticsDTO> statisticsList, List<String> workDate) {
        List<Integer> arr = new ArrayList<>();
        int beforeTimeTotal = 0;
        int afterTimeTotal = 0;

        for (StatisticsDTO s : statisticsList) {
            if (DateUtil.parse(workDate.get(0), DATE_TIME_PATTERN).getTime() >= s.getDate().getTime() && s.getDate().getTime() < DateUtil.parse(workDate.get(workDate.size() - 1), DATE_TIME_PATTERN).getTime()) {
                beforeTimeTotal += s.getTotal();
            }
            if (s.getDate().getTime() >= DateUtil.parse(workDate.get(workDate.size() - 1), DATE_TIME_PATTERN).getTime()) {
                afterTimeTotal += s.getTotal();
            }
        }
        arr.add(beforeTimeTotal);
        arr.add(afterTimeTotal);

        return arr;
    }

    /**
     * 　　* @description: 统计结果
     * 　　* @return
     * 　　* @throws
     * 　　* @author Vincent
     * 　　* @date 2022/2/16 16:57
     */
    private static List<Integer> statisticsResult(List<StatisticsDTO> statisticsList, List<String> workDate, List<Integer> beforeAndAfter) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < workDate.size(); i++) {
            arr.add(0);
            if (i == 0) {
                arr.set(i, beforeAndAfter.get(0));
                continue;
            }
            if (i == workDate.size() - 1) {
                arr.set(i, beforeAndAfter.get(1));
                continue;
            }
            for (StatisticsDTO s : statisticsList) {
                logger.info(DateUtil.format(s.getDate(), DATE_TIME_PATTERN) + ">>>>>>>>>>>>>" + workDate.get(i));
                if (DateUtil.format(s.getDate(), DATE_TIME_PATTERN).equals(workDate.get(i))) {
                    arr.set(i, s.getTotal());
                }
            }

        }

        return arr;
    }


}

