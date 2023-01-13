package com.ird.portal.user.process.func;


import com.ird.portal.common.user.data.FuncDTO;
import com.ird.portal.exception.RecordNotFoundException;
import com.ird.portal.user.dao.UserDao;
import com.ird.portal.user.entity.FuncEntity;
import com.ird.portal.user.entity.ModuleEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * 功能管理-更新.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 12/12/2017 16:18:20<br/>
 * @author Deft
 * @version 1.0
 */
@Component("updateFuncProcess")
public class FuncUpdateProcess{

	@Autowired
	private UserDao dao;
	
//	@Autowired
//	private BeanMapper mapper;


    public void update(FuncDTO dto) {
        FuncEntity entity = dao.getSingle(FuncEntity.class, dto.getFuncId());
        if(entity == null){
			throw new RecordNotFoundException("funcId="+dto.getFuncId());
		}
        if(StringUtils.isNotBlank(dto.getFuncCode())){
        	entity.setFuncCode(dto.getFuncCode().toUpperCase());
        }
        if(StringUtils.isNotBlank(dto.getFuncDesc())){
        	entity.setFuncDesc(dto.getFuncDesc());
        }
        if(dto.getModule() != null && dto.getModule().getModuleId() !=null){
        	ModuleEntity moduleEntity  = dao.getSingle(ModuleEntity.class, dto.getModule().getModuleId());
        	entity.setModule(moduleEntity);
        }
        if(dto.getParentId() != null){
            FuncEntity parent = dao.getSingle(FuncEntity.class,dto.getParentId());
            entity.setParent(parent);
        }
        dao.update(entity);
    }

}
