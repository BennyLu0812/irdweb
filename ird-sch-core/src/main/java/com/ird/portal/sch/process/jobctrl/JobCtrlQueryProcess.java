package com.ird.portal.sch.process.jobctrl;

import com.ird.portal.datatable.DataTablePage;
import com.ird.portal.datatable.DatatableDaoCmd;
import com.ird.portal.model.Page;
import com.ird.portal.sch.dao.Queries;
import com.ird.portal.sch.dao.SchDao;
import com.ird.portal.sch.dao.SchDaoCmd;
import com.ird.portal.sch.data.SchCtrlDTO;
import com.ird.portal.sch.entity.SchCtrlEntity;
import com.ird.portal.sch.service.ScheduleService;
import com.ird.portal.util.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 
 * 排程管理：分頁查詢,單條查詢,獲取全部
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 2017年11月16日<br/>
 * 
 * @author Allen
 * @version 1.0
 */
@Component
public class JobCtrlQueryProcess {
    
    
    @Autowired
    private SchDao dao;
    
    @Autowired
    private BeanMapper beanMapper;
    
    @Autowired
    private ScheduleService scheduleService;
    
    public Page getPage(SchCtrlDTO schCtrlDTO) {
        DatatableDaoCmd daoCmd = new DatatableDaoCmd(Queries.HQL_FIND_SCHCTRL_PAGE, schCtrlDTO);
        Long recordsTotal = dao.getCount(daoCmd);
        DataTablePage page = (DataTablePage)dao.getPage(daoCmd, SchCtrlDTO.class, true);
        for (Object obj : page.getData()) {
            SchCtrlDTO dto = (SchCtrlDTO) obj;
            String status = scheduleService.getScheduleStatus(dto);
            dto.setWorkStatus(status);
        }
        page.setRecordsTotal(recordsTotal);
        return page;
    };
    
    public SchCtrlEntity getById(Long id) {
        return dao.getSingle(SchCtrlEntity.class, id);
    }
    
    public List<SchCtrlDTO> getList(){
        SchDaoCmd cmd = new SchDaoCmd(Queries.HQL_FIND_SCHCTRL_LIST);
        List<SchCtrlEntity> list = dao.getList(cmd, SchCtrlEntity.class, true);
        return beanMapper.mapList(list, SchCtrlDTO.class);
    }
}
