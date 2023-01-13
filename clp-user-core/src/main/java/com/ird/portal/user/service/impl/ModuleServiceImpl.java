package com.ird.portal.user.service.impl;

import com.ird.portal.common.user.data.ModuleDTO;
import com.ird.portal.model.Page;
import com.ird.portal.user.entity.ModuleEntity;
import com.ird.portal.user.mapper.ModuleMapper;
import com.ird.portal.user.service.ModuleService;
import com.ird.portal.util.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ModuleServiceImpl implements ModuleService {
    
    @Autowired
    private ModuleMapper moduleMapper;
    
    @Autowired
    private BeanMapper beanMapper;
    
    @Override
    public ModuleEntity getById(Long moduleId) {
        return moduleMapper.getById(moduleId);
    }
    
    @Override
    public void add(ModuleDTO dto) {
        ModuleEntity entity = new ModuleEntity();
        
        if (dto.getParentId() != null) {
            ModuleEntity parent = getById(dto.getParentId());
            entity.setParent(parent);
        }

        entity.setSort(dto.getSort() == null? 0: dto.getSort());

        moduleMapper.insert(entity);
    }
    
    @Override
    public void update(ModuleDTO dto) {
        ModuleEntity entity = beanMapper.mapTo(dto, ModuleEntity.class);
        moduleMapper.update(entity);
    }
    
    @Override
    public void delete(Long id) {
        moduleMapper.deleteById(id);
    }
    
    @Override
    public Page getPage(ModuleDTO dto) {
        return moduleMapper.getPage(dto);
    }
    
    @Override
    public List<ModuleEntity> getList(ModuleDTO dto) {
        return moduleMapper.getList(dto);
    }
    
    @Override
    public List<ModuleEntity> getChildren(Long moduleId) {
        return moduleMapper.getChildren(moduleId);
    }
    
    @Override
    public List<ModuleEntity> getTop(Long moduleId) {
        return moduleMapper.getTop(moduleId);
    }
    
    @Override
    public List<ModuleEntity> buildParent(Long moduleId) {
        return moduleMapper.buildParent(moduleId);
    }
    
}
