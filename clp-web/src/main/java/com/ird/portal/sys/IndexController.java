package com.ird.portal.sys;

import com.ird.portal.common.user.data.FuncDTO;
import com.ird.portal.user.User;
import com.ird.portal.user.UserContext;
import com.ird.portal.user.service.FuncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Vincent
 * @version V1.0
 * @description: TODO
 * @ClassName: indexcontroller
 * @projectName dls_dev
 * @date 2021/2/22 9:20
 */
@Controller
public class IndexController {

    @Autowired
    private FuncService funcService;

    @Autowired
    private Environment evn;

    @Value("${clp-web.version}")
    private String version;

    @RequestMapping("/")
    public String web(){
        return "forward:/index.html";
    }

    @RequestMapping("/index.html")
    public String web_index(Model model){
        User user = UserContext.getUser();
        List<FuncDTO> funcDTOList = funcService.findFuncByUser(user.getUserId());
        model.addAttribute("dynamicMenuDTO", funcService.generateDynamicMenuDTO(funcDTOList));
        model.addAttribute("username", user.getUserName());
        model.addAttribute("ip", user.getIp());
        model.addAttribute("userType", user.getUserType());
        model.addAttribute("version", version);
        model.addAttribute("profile", evn.getActiveProfiles()[0]);
        return "/index";
    }
}
