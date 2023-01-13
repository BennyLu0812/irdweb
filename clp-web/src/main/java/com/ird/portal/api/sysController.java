package com.ird.portal.api;

import com.ird.portal.util.SysParamsConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * 系統參數對外管理
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 2021/11/02 11:40<br/>
 *
 * @author Vincent
 * @version 1.0
 */
@Controller
@RequestMapping("/api/v1/mobile/sys")
public class sysController {


    /**
     * 系統參數對外
     * @return
     */
    @GetMapping("/getSysParameters")
    @ResponseBody
    public String getSysParameters(){
        return SysParamsConstant.getParamValue("CLP_WAITING_PARAMETERS");
    }



}
