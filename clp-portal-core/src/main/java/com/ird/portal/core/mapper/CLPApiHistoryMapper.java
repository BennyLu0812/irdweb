package com.ird.portal.core.mapper;

import com.ird.portal.common.api.data.APIRequestDTO;
import com.ird.portal.common.api.data.CLPApiHistoryDTO;
import com.ird.portal.core.entity.CLPApiHistoryEntity;
import com.ird.portal.dao.AbstractCommonDao;
import com.ird.portal.dao.AbstractMapper;
import com.ird.portal.dao.JpaSqlDao;
import com.ird.portal.datatable.DataTablePage;
import com.ird.portal.datatable.DatatableDaoCmd;
import com.ird.portal.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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




}
