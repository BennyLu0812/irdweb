package com.ird.portal.sys;

import com.ird.portal.audit.annotation.AuditRequest;
import com.ird.portal.common.user.data.DynamicMenuDTO;
import com.ird.portal.common.user.data.FuncDTO;
import com.ird.portal.common.user.data.RoleDTO;
import com.ird.portal.common.user.enums.FuncStatusEnum;
import com.ird.portal.common.user.enums.RoleStatusEnum;
import com.ird.portal.model.Page;
import com.ird.portal.user.entity.FuncEntity;
import com.ird.portal.user.entity.RoleEntity;
import com.ird.portal.user.service.FuncService;
import com.ird.portal.user.service.RoleService;
import com.ird.portal.web.security.annotion.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 
 * 角色管理.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 16/11/2017 10:33:36<br/>
 * 
 * @author Deft
 * @version 1.0
 */
@Controller
@RequestMapping("sys/role")
public class RoleController {

    @Autowired
    private RoleService roleService;
    
    @Autowired
    private FuncService funcService;
    
    @PreAuthorize("hasPermission('USER-ROLE-QUERY')")
    @GetMapping(path = "/list.html")
    public String index() {
        return "sys/role/list";
    }
    
    @PreAuthorize("hasPermission('USER-ROLE-QUERY')")
    @PostMapping("/list")
    @ResponseBody
    public HttpEntity<Page> getPage(@RequestBody RoleDTO dto) {
        Page list = roleService.getRolePage(dto);
        return new HttpEntity<Page>(list);
    }

    @PreAuthorize("hasPermission('USER-ROLE-QUERY')")
    @PostMapping("/getRoleList")
    @ResponseBody
    public List<RoleEntity> getRoleList() {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setStatus("A");
        return roleService.getRoleList(roleDTO);
    }
    
    @PreAuthorize("hasPermission('USER-ROLE-QUERY')")
    @GetMapping("/{roleId}")
    public HttpEntity<RoleEntity> getById(@PathVariable Long roleId) {
        RoleEntity entity = roleService.getById(roleId);
        return new HttpEntity<RoleEntity>(entity);
    }
    
    @PreAuthorize("hasPermission('USER-ROLE-QUERY')")
    @GetMapping(path = "/detail.html")
    public String detail(Long roleId, Model model) {
        model.addAttribute("roleId", roleId);
        return "sys/role/detail";
    }

    @AuditRequest(funcCode = "USER-ROLE-MODIFY")
    @PreAuthorize("hasPermission('USER-ROLE-MODIFY')")
    @GetMapping(path = "/edit.html")
    public String edit(Long roleId, Model model) {
        model.addAttribute("roleId", roleId);
        return "sys/role/edit";
    }
    
    @AuditRequest(funcCode="USER-ROLE-MODIFY")
    @PreAuthorize("hasPermission('USER-ROLE-MODIFY')")
    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void update(@RequestBody RoleDTO dto) {
        roleService.update(dto);
    }
    
    @AuditRequest(funcCode="USER-ROLE-ADD")
    @PreAuthorize("hasPermission('USER-ROLE-ADD')")
    @PostMapping(path = "")
    @ResponseStatus(code = HttpStatus.OK)
    public void save(@RequestBody RoleDTO dto) {
        roleService.add(dto);
    }

    @DeleteMapping("/{roleId}")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@PathVariable Long roleId) {
        roleService.delete(roleId);
    }
    
    @GetMapping("/listFunc/{roleId}")
    @ResponseBody
    public DynamicMenuDTO getUpdateFuncList(@PathVariable Long roleId) {
        RoleEntity role = roleService.getById(roleId);
        Set<FuncEntity> roleFuncs = role.getFuncs();

        return getMenuFuncsOfModuleId(roleFuncs);
    }

    @GetMapping("/listFunc")
    @ResponseBody
    public DynamicMenuDTO getAddFuncList() {
        return getMenuFuncsOfModuleId(new ArrayList<FuncEntity>());
    }
    
    private Map<String, List<FuncDTO>> getFuncsOfModuleId(Collection<FuncEntity> roleFuncs) {
        List<FuncDTO> allFuncs = funcService.findAll(new FuncDTO());
        Map<String, List<FuncDTO>> selectedFuncsOfModuleId = new HashMap<String, List<FuncDTO>>();
        
        for (FuncDTO funcDTO : allFuncs) {
            if (FuncStatusEnum.ACTIVE.getCode().equals(funcDTO.getStatus())) {
                for (FuncEntity funcEntity : roleFuncs) {
                    if (funcEntity.getFuncId().equals(funcDTO.getFuncId())) {
                        funcDTO.setChecked(true);
                        break;
                    }
                }
                
                String key = String.valueOf(funcDTO.getModule().getModuleId());
                if (!selectedFuncsOfModuleId.containsKey(key)) {
                    selectedFuncsOfModuleId.put(key, new ArrayList<FuncDTO>());
                }
                selectedFuncsOfModuleId.get(key).add(funcDTO);
            }
        }
        return selectedFuncsOfModuleId;
    }

    private DynamicMenuDTO getMenuFuncsOfModuleId(Collection<FuncEntity> roleFuncs) {
        Set<Long> roleFuncIds = roleFuncs.stream().map(FuncEntity::getFuncId).collect(Collectors.toSet());
        List<FuncDTO> allMenuFuncs = funcService.findAllMenuFunc();
        allMenuFuncs.forEach(funcDTO -> funcDTO.setChecked(roleFuncIds.contains(funcDTO.getFuncId())));
        return funcService.generateDynamicMenuDTO(allMenuFuncs);
    }
    
    @GetMapping(path = "/status")
    @ResponseBody
    public HttpEntity<List<Map<String, String>>> getUserStatus(HttpServletRequest request) {
        List<Map<String, String>> items = RoleStatusEnum.getItems(null);
        return new HttpEntity<List<Map<String, String>>>(items);
    }
}
