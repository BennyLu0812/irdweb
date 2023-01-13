package com.ird.portal.sys.service.impl;

import com.ird.portal.sys.mapper.IDCardMapper;
import com.ird.portal.sys.service.IDCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class IDCardServiceImpl implements IDCardService {
    @Autowired
    private IDCardMapper idCardMapper;
    @Override
    public String getSpIDType(String nationalCode) {
        return idCardMapper.getSpIDType(nationalCode);
    }
    
}
