package com.ird.portal.sys;

import com.ird.portal.common.sys.data.SummaryGraphDTO;
import com.ird.portal.common.sys.data.TableTotalDTO;
import com.ird.portal.sys.service.TotalDashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 
 * 参数管理.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 16/11/2017 10:33:36<br/>
 * 
 * @author Deft
 * @version 1.0
 */
@Controller
@RequestMapping("sys/dashboard")
public class TotalDashboardController {

    @Autowired
    private TotalDashboardService totalDashboardService;

    @PostMapping("/getSortSumTotal/{centerCode}")
    @ResponseBody
    public SummaryGraphDTO getSortSumTotal(@PathVariable String centerCode, @RequestParam String inspectionDate) {
        return totalDashboardService.statisticsByCategory(centerCode, inspectionDate);
    }


    @PostMapping("/getTableSumTotal/{centerCode}")
    @ResponseBody
    public List<TableTotalDTO> getTableSumTotal(@PathVariable String centerCode, @RequestParam String inspectionDate) {
        return totalDashboardService.getTableSumTotal(centerCode, inspectionDate);
    }

    @PostMapping("/getCitizenAvgData/{centerCode}")
    @ResponseBody
    public Map<String,Integer> getCitizenAvgData(@PathVariable String centerCode, @RequestParam String inspectionDate) {
        return totalDashboardService.getCitizenAvgData(centerCode, inspectionDate);
    }

    @PostMapping("/getCarAvgData/{centerCode}")
    @ResponseBody
    public Map<String,Integer> getCarAvgData(@PathVariable String centerCode, @RequestParam String inspectionDate) {
        return totalDashboardService.getCarAvgData(centerCode, inspectionDate);
    }
}
