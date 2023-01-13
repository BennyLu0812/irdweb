package com.ird.portal.user.service.impl;

import com.ird.portal.common.user.data.DynamicMenuDTO;
import com.ird.portal.common.user.data.FuncDTO;
import com.ird.portal.common.user.data.ModuleDTO;
import com.ird.portal.common.user.enums.FuncTypeEnum;
import com.ird.portal.exception.FuncTypeUpdateException;
import com.ird.portal.exception.RecordExistException;
import com.ird.portal.exception.RecordNotFoundException;
import com.ird.portal.model.Page;
import com.ird.portal.select2.Select2Page;
import com.ird.portal.user.entity.FuncEntity;
import com.ird.portal.user.entity.ModuleEntity;
import com.ird.portal.user.mapper.FuncMapper;
import com.ird.portal.user.service.FuncService;
import com.ird.portal.user.service.ModuleService;
import com.ird.portal.user.util.ConstantUtil;
import com.ird.portal.util.BeanMapper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 
 * 功能信息管理-查詢、新增、更新、刪除等.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 13/12/2017 15:54:39<br/>
 * 
 * @author Deft
 * @version 1.0
 */
@Service
@Transactional
public class FuncServiceImpl implements FuncService {
    
    @Autowired
    private FuncMapper funcMapper;
    
    @Autowired
    private BeanMapper beanMapper;

    @Autowired
    private ModuleService moduleService;

    @Override
    public List<FuncDTO> findAll(FuncDTO dto) {
        return funcMapper.getList(dto);
    }
    
    @Override
    public FuncEntity getById(Long id) {
        return funcMapper.getSingle(id);
    }
    
    @Override
    public void add(FuncDTO dto) {
        FuncEntity temp = getFuncByFuncCode(dto.getFuncCode());
        if (temp != null) {
            throw new RecordExistException("funcCode=" + dto.getFuncCode());
        }

        if (FuncTypeEnum.MENU.getCode().equals(dto.getFuncType())) {
            dto.setParent(null);
        } else {
            dto.setFuncResource(null);
        }

        FuncEntity entity = beanMapper.mapTo(dto, FuncEntity.class);
        entity.setStatus(ConstantUtil.FUNC_STATUS_ACTIVE);
        entity.setSort(0);
        if (FuncTypeEnum.FUNCTION.getCode().equals(entity.getFuncType())) {
            entity.setParent(this.getById(entity.getParent().getFuncId()));
        }
        funcMapper.insert(entity);
    }
    
    @Override
    public void update(FuncDTO dto) {
        FuncEntity entity = getById(dto.getFuncId());
        if (entity == null) {
            throw new RecordNotFoundException("funcId=" + dto.getFuncId());
        }

        FuncEntity temp = getFuncByFuncCode(dto.getFuncCode());
        if (temp != null && !temp.getFuncId().equals(dto.getFuncId())) {
            throw new RecordExistException("funcCode=" + dto.getFuncCode());
        }

        // 菜單類型修改為按鈕功能，判斷是否存在關連的按鈕功能
        if (FuncTypeEnum.MENU.getCode().equals(entity.getFuncType())
                && FuncTypeEnum.FUNCTION.getCode().equals(dto.getFuncType())
                && CollectionUtils.isNotEmpty(entity.getChildren())){
            throw new FuncTypeUpdateException();
        }

        if (FuncTypeEnum.MENU.getCode().equals(dto.getFuncType())) {
            dto.setParent(null);
        } else {
            dto.setFuncResource(null);
        }

        entity = beanMapper.mapTo(dto, FuncEntity.class);

        // 按鈕权限需要设置所属菜单
        if (FuncTypeEnum.FUNCTION.getCode().equals(entity.getFuncType())) {
            entity.setParent(this.getById(dto.getParent().getFuncId()));
        }


        funcMapper.update(entity);
    }
    
    @Override
    public void delete(long id) {
        funcMapper.deleteById(id);
    }
    
    @Override
    public List<FuncEntity> getTop(FuncDTO dto) {
        return funcMapper.getTop(dto);
    }
    
    @Override
    public List<FuncEntity> buildParent(Long funcId) {
        return funcMapper.buildParent(funcId);
    }
    
    @Override
    public Page getPage(FuncDTO dto) {
        return funcMapper.getPage(dto);
    }
    
    @Override
    public FuncEntity getFuncByFuncCode(String funcCode) {
        return funcMapper.getFuncByFuncCode(funcCode);
    }
    
    @Override
    public List<FuncEntity> getFuncByIds(Long[] funcIds) {
        return funcMapper.getFuncByIds(funcIds);
    }
    @Override
    public Page getRptPreviledgePage(FuncDTO dto){
        return funcMapper.getRptPreviledgePage( dto);
    }

    @Override
    public Select2Page getFuncQuotaSelectPageData(String keyword, int pageSize, int pageNumber) {
        return funcMapper.getFuncQuotaSelectPageData(keyword,pageSize,pageNumber);
    }

    @Override
    public List<FuncDTO> findFuncByUser(String userId) {
        return funcMapper.findFuncByUser(userId,  null);
    }

    @Override
    public List<FuncDTO> findFuncByUser(String userId, Integer centerId) {
        return funcMapper.findFuncByUser(userId, centerId);
    }

    @Override
    public DynamicMenuDTO generateDynamicMenuDTO(List<FuncDTO> funcDTOList) {

        DynamicMenuDTO dynamicMenuDTO = new DynamicMenuDTO();

        Map<Long , DynamicMenuDTO.Module> moduleMap = new HashMap<>();
        Map<Long, DynamicMenuDTO.Menu> menuMap = new HashMap<>();

        for(FuncDTO funcDTO: funcDTOList) {
            Long moduleId = funcDTO.getModuleId() == null? funcDTO.getModule().getModuleId(): funcDTO.getModuleId();
            DynamicMenuDTO.Module module = moduleMap.get(moduleId);
            if (module == null) {
                module = new DynamicMenuDTO.Module();
                if (funcDTO.getModuleId() == null) {
                    ModuleDTO moduleDTO = funcDTO.getModule();
                    BeanUtils.copyProperties(moduleDTO, module);
                } else {
                    ModuleEntity moduleEntity = moduleService.getById(funcDTO.getModuleId());
                    BeanUtils.copyProperties(moduleEntity, module);
                }
                moduleMap.put(moduleId, module);
                dynamicMenuDTO.getModuleList().add(module);
            }
            if (FuncTypeEnum.MENU.getCode().equals(funcDTO.getFuncType())) {
                DynamicMenuDTO.Menu menu = menuMap.get(funcDTO.getFuncId());
                if (menu == null) {
                    menu = new DynamicMenuDTO.Menu();
                    BeanUtils.copyProperties(funcDTO, menu);
                    menuMap.put(funcDTO.getFuncId(), menu);
                    module.getMenuList().add(menu);
                }
            } else {
                Long parentId = funcDTO.getParentId() == null? funcDTO.getParent().getFuncId(): funcDTO.getParentId();
                DynamicMenuDTO.Menu menu = menuMap.get(parentId);
                if (menu != null) {
                    menu.getFuncList().add(funcDTO);
                }
            }
        }

        moduleMap = null;
        menuMap = null;

        // 重排序
        dynamicMenuDTO.setModuleList(
                dynamicMenuDTO.getModuleList().stream()
                        .sorted(Comparator.comparingInt(DynamicMenuDTO.Module::getSort))
                        .collect(Collectors.toList())
        );

        return dynamicMenuDTO;
    }

    @Override
    public List<FuncDTO> findAllMenuFunc() {
        return funcMapper.findAllMenuFunc();
    }

    @Override
    public List<FuncEntity> findMenuList() {
        return funcMapper.findMenuList();
    }
}
