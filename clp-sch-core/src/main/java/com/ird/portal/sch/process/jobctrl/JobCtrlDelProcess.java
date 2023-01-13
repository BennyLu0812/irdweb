package com.ird.portal.sch.process.jobctrl;

import com.ird.portal.sch.dao.SchDao;
import com.ird.portal.sch.entity.SchCtrlEntity;
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
public class JobCtrlDelProcess {

	@Autowired
	private SchDao dao;
	
	public void delete(Long id){
		SchCtrlEntity schCtrlEntity = dao.getSingle(SchCtrlEntity.class, id);
		dao.delete(schCtrlEntity);
	}
	
}
