package com.ird.portal.sys.mapper;

import com.ird.portal.common.sys.data.StatisticsDTO;
import com.ird.portal.common.sys.data.TableTotalDTO;
import com.ird.portal.dao.AbstractCommonDao;
import com.ird.portal.dao.AbstractMapper;
import com.ird.portal.dao.JpaSqlDao;
import com.ird.portal.datatable.JpaSqlDaoCmd;
import org.apache.poi.ss.formula.functions.T;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * TODO 請給ParamsMapper說明一下吧!
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 21/05/2018 15:56:34<br/>
 * @author James
 * @version 1.0
 */
@Repository
public class TotalDashboardMapper extends AbstractMapper<T> {

    @Autowired
    private JpaSqlDao dao;


    public List<StatisticsDTO> entryTimeTotal(String centerCode, Date createDate){
        Map<String, Object> params = new HashMap<>(2);
        params.put("centerCode", centerCode);
        params.put("createDate", createDate);
        JpaSqlDaoCmd cmd = new JpaSqlDaoCmd("entryTimeTotal", params);
        return dao.getList(cmd, StatisticsDTO.class, true);
    }

    public List<StatisticsDTO> completeTimeTotal(String centerCode, Date createDate){
        Map<String, Object> params = new HashMap<>(2);
        params.put("centerCode", centerCode);
        params.put("createDate", createDate);
        JpaSqlDaoCmd cmd = new JpaSqlDaoCmd("completeTimeTotal", params);
        return dao.getList(cmd, StatisticsDTO.class, true);
    }


    public List<TableTotalDTO> getTableSumTotal(String centerCode, Date createDate){
        Map<String, Object> params = new HashMap<>(2);
        params.put("centerCode", centerCode);
        params.put("createDate", createDate);
        JpaSqlDaoCmd cmd = new JpaSqlDaoCmd("getTableSumTotal", params);
        return dao.getList(cmd, TableTotalDTO.class, true);
    }

    public Map<String,Integer> getCitizenAvgData(String centerCode, Date createDate){
        Map<String, Object> params = new HashMap<>(2);
        params.put("centerCode", centerCode);
        params.put("createDate", createDate);
        JpaSqlDaoCmd cmd = new JpaSqlDaoCmd("getCitizenAvgData", params);

        Map<String, BigDecimal> result = dao.getSingle(cmd, Map.class, Transformers.ALIAS_TO_ENTITY_MAP);

        Map<String,Integer> map = new HashMap<String,Integer>();
        if(result != null ){
            map.put("citizenAvgMin",result.get("citizenAvgMin").intValue());
            map.put("citizenAvgMinCount",result.get("citizenAvgMinCount").intValue());
        }else{
            map.put("citizenAvgMin",0);
            map.put("citizenAvgMinCount",0);
        }
        return map;
    }

    public Map<String,Integer> getCarAvgData(String centerCode, Date createDate){
        Map<String, Object> params = new HashMap<>(2);
        params.put("centerCode", centerCode);
        params.put("createDate", createDate);
        JpaSqlDaoCmd cmd = new JpaSqlDaoCmd("getCarAvgData", params);

        Map<String, BigDecimal> result = dao.getSingle(cmd, Map.class, Transformers.ALIAS_TO_ENTITY_MAP);

        Map<String,Integer> map = new HashMap<String,Integer>();
        if(result != null ){
            map.put("carAvgMin",result.get("carAvgMin").intValue());
            map.put("carAvgMinCount",result.get("carAvgMinCount").intValue());
        }else{
            map.put("carAvgMin",0);
            map.put("carAvgMinCount",0);
        }
        return map;
    }

    @Override
    protected AbstractCommonDao getDao() {
        return dao;
    }
    
}
