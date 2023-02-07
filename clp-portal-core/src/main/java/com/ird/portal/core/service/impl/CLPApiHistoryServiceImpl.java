package com.ird.portal.core.service.impl;

import com.ird.portal.common.api.data.APIRequestDTO;
import com.ird.portal.common.api.data.CLPApiHistoryDTO;
import com.ird.portal.core.entity.CLPApiHistoryEntity;
import com.ird.portal.core.mapper.CLPApiHistoryMapper;
import com.ird.portal.core.service.CLPApiHistoryService;
import com.ird.portal.model.Page;
import com.ird.portal.util.BeanMapper;
import org.apache.commons.lang3.StringUtils;
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

    @Autowired
    private BeanMapper beanMapper;

    @Override
    public Page getPage(APIRequestDTO dto) {
        return clpApiHistoryMapper.getPage(dto);
    }

    @Override
    public CLPApiHistoryDTO getApiHistoryDTOById(String apiHistoryId) {
        Integer id=0;
        if (StringUtils.isNotBlank(apiHistoryId)) {
            id = Integer.parseInt(apiHistoryId);
        }
        CLPApiHistoryEntity entity = clpApiHistoryMapper.getSingle(id);
        if(entity != null) {
            return beanMapper.map(entity, CLPApiHistoryDTO.class); // 轉換為DTO返回
        }
        return new CLPApiHistoryDTO();
    }

    @Override
    public CLPApiHistoryDTO doSave(CLPApiHistoryDTO clpApiHistoryDTO) {
        if (clpApiHistoryDTO != null) {
            CLPApiHistoryEntity clpApiHistoryEntity = beanMapper.mapTo(clpApiHistoryDTO, CLPApiHistoryEntity.class);
            CLPApiHistoryEntity clpApiHistoryEntity1 =(CLPApiHistoryEntity) clpApiHistoryMapper.insert(clpApiHistoryEntity);
            return beanMapper.mapTo(clpApiHistoryEntity1, CLPApiHistoryDTO.class);
        }
        return clpApiHistoryDTO;
    }


}
