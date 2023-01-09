package com.ird.portal.sys;

import com.ird.portal.audit.annotation.AuditRequest;
import com.ird.portal.common.user.data.RoleDTO;
import com.ird.portal.common.user.data.UserDTO;
import com.ird.portal.common.user.enums.RoleStatusEnum;
import com.ird.portal.common.user.enums.UserStatusEnum;
import com.ird.portal.common.user.enums.UserTypeEnum;
import com.ird.portal.model.Page;
import com.ird.portal.select2.Select2Page;
import com.ird.portal.user.User;
import com.ird.portal.user.UserContext;
import com.ird.portal.user.entity.FuncEntity;
import com.ird.portal.user.entity.RoleEntity;
import com.ird.portal.user.entity.UserEntity;
import com.ird.portal.user.service.RoleService;
import com.ird.portal.user.service.UserService;
import com.ird.portal.web.security.annotion.PreAuthorize;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 
 * 用户管理.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 16/11/2017 10:33:36<br/>
 * 
 * @author Deft
 * @version 1.0
 */
@Controller
@RequestMapping("/sys/user")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private RoleService roleService;
    
    @PreAuthorize("hasPermission('USER-QUERY')")
    @GetMapping(path = "/list.html")
    public String index() {
        return "sys/user/list";
    }
    
    @PreAuthorize("hasPermission('USER-MODIFY')")
    @GetMapping(path = "/edit.html")
    public String edit(String userId, Model model) {
        model.addAttribute("userId", userId);
        return "sys/user/edit";
    }
    
    @PreAuthorize("hasPermission('USER-QUERY')")
    @GetMapping(path = "/detail.html")
    public String detail(String userId, Model model) {
        model.addAttribute("userId", userId);
        return "sys/user/detail";
    }
    
    @PreAuthorize("hasPermission('USER-QUERY')")
    @PostMapping("/list")
    @ResponseBody
    public HttpEntity<Page> getPage(@RequestBody UserDTO dto) {
    	if(StringUtils.isNotBlank(dto.getUserId())){
    		dto.setUserId(dto.getUserId().trim().toUpperCase());
    	}
        Page list = userService.getPage(dto);
        return new HttpEntity<Page>(list);
    }
    
    
    @PostMapping(path = "/getById")
    public HttpEntity<UserEntity> getById(@RequestBody UserDTO dto) {
    	UserEntity entity = userService.getById(dto.getUserId());
        return new HttpEntity<UserEntity>(entity);
    }
    
    @AuditRequest(funcCode = "USER-ADD")
    @PreAuthorize("hasPermission('USER-ADD')")
    @PostMapping()
    @ResponseStatus(code = HttpStatus.OK)
    public void save(@RequestBody UserDTO dto) {
    	if(StringUtils.isNotBlank(dto.getUserId())){
    		dto.setUserId(dto.getUserId().trim().toUpperCase());
    	}
        userService.add(dto);
    }
    
    @AuditRequest(funcCode = "USER-DEL")
    @PreAuthorize("hasPermission('USER-DEL')")
    @DeleteMapping("/{userId}")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@PathVariable String userId) {
        userService.delete(userId);
    }
    
    @AuditRequest(funcCode = "USER-MODIFY")
    @PreAuthorize("hasPermission('USER-MODIFY')")
    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void update(@RequestBody UserDTO dto) {
        userService.update(dto);
    }
    
    @GetMapping(path = "/listRole")
    @ResponseBody
    public HttpEntity<List<RoleEntity>> getRoleList() {
        RoleDTO queryDTO = new RoleDTO();
        queryDTO.setStatus(RoleStatusEnum.ACTIVE.getCode());
        List<RoleEntity> list = roleService.getRoleList(queryDTO);
        return new HttpEntity<List<RoleEntity>>(list);
    }
    
    @GetMapping(path = "/status")
    @ResponseBody
    public HttpEntity<List<Map<String, String>>> getUserStatus(HttpServletRequest request) {
        List<Map<String, String>> items = UserStatusEnum.getItems(null);
        return new HttpEntity<List<Map<String, String>>>(items);
    }

    @GetMapping(path = "/type")
    @ResponseBody
    public HttpEntity<List<Map<String, String>>> getUserType(HttpServletRequest request) {
        List<Map<String, String>> items = UserTypeEnum.getItems(request.getLocale());
        return new HttpEntity<List<Map<String, String>>>(items);
    }
    
    
    /**
     * 查询功能名称下拉
     * @param keyword
     * @return
     */
    @GetMapping("/getUserNameQuotaSelectPage")
    @ResponseBody
    public HttpEntity<Select2Page> getUserNameQuotaSelectPage(String keyword,
                                                              @RequestParam(value = "pageSize", defaultValue = "30") int pageSize,
                                                              @RequestParam(value = "pageNumber", defaultValue = "1") int pageNumber) {
        Select2Page page = userService.getUserNameQuotaSelectPage(keyword, pageSize, pageNumber);
        return new HttpEntity<Select2Page>(page);
    }

    @PostMapping("/getButtonPermission")
    public HttpEntity<Set<FuncEntity>> getButtonPermission (String userId) {
        UserEntity user = userService.getById(userId);
        Set<RoleEntity> roles = user.getRoles();
        Set<FuncEntity> funcList = new HashSet<FuncEntity>();

        for (RoleEntity role :roles) {
            if (StringUtils.equals(role.getStatus(),"A")) {
                Set<FuncEntity>  funcEntities = role.getFuncs();
                for (FuncEntity func :funcEntities) {
                    if (StringUtils.equals(func.getStatus(),"A")) {
                        funcList.add(func);
                    }
                }
            }
        }
        return new HttpEntity<>(funcList);

    }

    @GetMapping("/getAuthorizedBatchPrintUsers")
    public HttpEntity<Select2Page> getAuthorizedBatchPrintUsers (String keyword,
        @RequestParam(value = "pageSize", defaultValue = "30") int pageSize,
        @RequestParam(value = "pageNumber", defaultValue = "1") int pageNumber) {
        String func_code = "DLS-LIC-BATCH-INPUT";
        List<String> list = new ArrayList<String>();
        list.add(func_code);
        User user = UserContext.getUser();
        List<String> excludeUserList = new ArrayList<>();
        excludeUserList.add(user!=null?user.getUserId():"");


        Select2Page select2Page = userService.getAuthorizedBatchPrintUsers(keyword, pageSize, pageNumber, list, excludeUserList);
        return new HttpEntity<>(select2Page);

    }

    @GetMapping("/getAllAuthorizedBatchPrintUsers")
    public HttpEntity<Select2Page> getAllAuthorizedBatchPrintUsers (String keyword,
         @RequestParam(value = "pageSize", defaultValue = "30") int pageSize,
         @RequestParam(value = "pageNumber", defaultValue = "1") int pageNumber) {
        String func_code = "DLS-LIC-BATCH-INPUT";
        List<String> list = new ArrayList<String>();
        list.add(func_code);
        Select2Page select2Page = userService.getAuthorizedBatchPrintUsers(keyword,
                pageSize, pageNumber, list, null);
        return new HttpEntity<>(select2Page);

    }
}
