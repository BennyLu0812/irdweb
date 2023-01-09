package com.ird.portal.sch.process.jobctrllog;

import com.ird.portal.sch.dao.SchDao;
import com.ird.portal.sch.entity.SchCtrlLogEntity;
import com.ird.portal.util.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 * 
 * 排程工作日志-更新
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 2017年11月16日<br/>
 * @author Allen
 * @version 1.0
 */
@Component
public class JobCtrlLogUpdateProcess {

	@Autowired
	private SchDao dao;
	
	@Autowired
    private BeanMapper beanMapper;
	
	public SchCtrlLogEntity update(SchCtrlLogEntity schCtrlLogEntity){
		SchCtrlLogEntity newEntity = dao.getSingle(SchCtrlLogEntity.class, schCtrlLogEntity.getSchCtrlLogId());
		if(newEntity != null){
			beanMapper.map(schCtrlLogEntity, newEntity);
			return (SchCtrlLogEntity) dao.update(newEntity);
		}
		return null;
	}
}
