package com.ird.portal.core.service.impl;

import com.ird.portal.common.api.data.APIRequestDTO;
import com.ird.portal.core.mapper.CLPApiHistoryMapper;
import com.ird.portal.core.service.CLPApiHistoryService;
import com.ird.portal.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author Benny
 * @description:
 * @date 2023/1/30
 */
@Service
@Transactional
public class CLPApiHistoryServiceImpl implements CLPApiHistoryService {

    @Autowired
    private CLPApiHistoryMapper clpApiHistoryMapper;

    @Override
    public Page getPage(APIRequestDTO dto) {
        return clpApiHistoryMapper.getPage(dto);
    }
}
