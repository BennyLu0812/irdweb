package com.ird.portal.sch.process.jobctrl;

import com.ird.portal.sch.dao.SchDao;
import com.ird.portal.sch.entity.SchCtrlEntity;
import com.ird.portal.util.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 * 
 * 排程管理-更新
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 2017年11月16日<br/>
 * @author Allen
 * @version 1.0
 */
@Component
public class JobCtrlUpdateProcess {

	@Autowired
	private SchDao dao;
	
	@Autowired
    private BeanMapper beanMapper;
	
	public SchCtrlEntity update(SchCtrlEntity schCtrlEntity){
		SchCtrlEntity newJobCtrlEntity = dao.getSingle(SchCtrlEntity.class, schCtrlEntity.getId());
		if(newJobCtrlEntity != null){
			beanMapper.map(schCtrlEntity, newJobCtrlEntity);
			return (SchCtrlEntity) dao.update(newJobCtrlEntity);
		}
		return null;
	}
}
