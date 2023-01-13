package com.ird.portal.sys;

import com.ird.portal.sys.service.IDCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/idcard")
public class IDCardController {
    
    @Autowired
    private IDCardService idCardService;
    @GetMapping("/getSpIDType")
    @ResponseBody
    public String getSpIDType(String nationalCode) {//根據國籍編號查詢spId的類型
        return idCardService.getSpIDType(nationalCode);
    }
}
