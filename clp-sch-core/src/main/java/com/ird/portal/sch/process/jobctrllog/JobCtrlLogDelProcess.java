package com.ird.portal.sch.process.jobctrllog;

import com.ird.portal.sch.dao.SchDao;
import com.ird.portal.sch.entity.SchCtrlLogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * 排程管理-刪除
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 2017年11月16日<br/>
 * @author Allen
 * @version 1.0
 */
@Component
public class JobCtrlLogDelProcess {

	@Autowired
	private SchDao dao;
	
	public void deleteById(Long id){
		SchCtrlLogEntity schCtrlLogEntity = dao.getSingle(SchCtrlLogEntity.class, id);
		dao.delete(schCtrlLogEntity);
	}
}
