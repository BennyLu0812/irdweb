package com.ird.portal.core.mapper;

import com.ird.portal.common.api.data.APIRequestDTO;
import com.ird.portal.common.api.data.CLPApiHistoryDTO;
import com.ird.portal.common.sys.data.Select2DTO;
import com.ird.portal.core.entity.CLPApiHistoryEntity;
import com.ird.portal.dao.AbstractCommonDao;
import com.ird.portal.dao.AbstractMapper;
import com.ird.portal.dao.JpaSqlDao;
import com.ird.portal.datatable.DataTablePage;
import com.ird.portal.datatable.DatatableDaoCmd;
import com.ird.portal.model.Page;
import com.ird.portal.select2.Select2DaoCmd;
import com.ird.portal.select2.Select2Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Benny
 * @description:
 * @date 2023/1/16
 */
@Repository
public class CLPApiHistoryMapper extends AbstractMapper<CLPApiHistoryEntity> {

    @Autowired
    private JpaSqlDao dao;

    @Override
    protected AbstractCommonDao getDao() {
        return dao;
    }

    private static final String SQL_GET_API_HISTORY_LIST_PAGE = "geCLPApiHistoryPage";

    private static final String SQL_GET_SYS_PARAM_SELECT_PAGE = "getSystemParamSelectPage";

    /**
     * 分頁功能.
     *
     * @param dto dto對象.
     * @return 放回Page
     */
    public Page getPage(APIRequestDTO dto) {
        DatatableDaoCmd cmd = new DatatableDaoCmd(SQL_GET_API_HISTORY_LIST_PAGE, dto);
        DataTablePage page = (DataTablePage) this.getDao().getPage(cmd, CLPApiHistoryDTO.class,true); // 分頁功能
        return page;
    }

    /**
     * 將系統參數值作為下拉框（用逗號當分隔符）。
     * @param keyword 查詢值
     * @param pageSize pageSize
     * @param pageNumber pageNumber
     * @return
     */
    public Select2Page getSystemParamSelectPage(String keyword, int pageSize, int pageNumber) {
        Map<String, Object> params = new HashMap<>();
        if (StringUtils.isNotBlank(keyword)) {
            params.put("keyword", keyword);
        }
        Select2DaoCmd daoCmd = new Select2DaoCmd(SQL_GET_SYS_PARAM_SELECT_PAGE, params, pageSize, pageNumber);
        Select2Page page = (Select2Page) dao.getPage(daoCmd, Select2DTO.class, true);
        return page;
    }




}
