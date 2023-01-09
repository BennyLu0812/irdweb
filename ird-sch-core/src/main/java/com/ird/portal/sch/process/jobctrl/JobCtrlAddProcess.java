package com.ird.portal.sch.process.jobctrl;

import com.ird.portal.sch.dao.SchDao;
import com.ird.portal.sch.entity.SchCtrlEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 * 
 * 排程管理-新增.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 2017年11月16日<br/>
 * @author Allen
 * @version 1.0
 */
@Component
public class JobCtrlAddProcess {

	@Autowired
	private SchDao dao;
	
	public SchCtrlEntity add(SchCtrlEntity schCtrlEntity){
		return (SchCtrlEntity) dao.insert(schCtrlEntity);
	}
}
