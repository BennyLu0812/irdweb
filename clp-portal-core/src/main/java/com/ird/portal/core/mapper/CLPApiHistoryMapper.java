package com.ird.portal.core.mapper;

import com.ird.portal.core.dao.PortalDao;
import com.ird.portal.core.entity.CLPApiHistoryEntity;
import com.ird.portal.dao.AbstractCommonDao;
import com.ird.portal.dao.AbstractMapper;
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
    private PortalDao portalDao;

    @Override
    protected AbstractCommonDao getDao() {
        return portalDao;
    }


}
