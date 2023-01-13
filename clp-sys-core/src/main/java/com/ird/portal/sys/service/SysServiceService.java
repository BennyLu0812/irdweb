package com.ird.portal.sys.service;

import com.ird.portal.common.sys.data.SysProcessDTO;
import com.ird.portal.common.sys.data.SysServiceDTO;
import com.ird.portal.common.sys.data.SysServiceProcessDTO;

import java.util.List;

public interface SysServiceService {
    
    public List<SysServiceDTO> getSysServiceList(SysServiceDTO queryDTO);
    
    public List<SysProcessDTO> getSysProcessList(SysProcessDTO queryDTO);
    
    public List<SysServiceDTO> getSysServiceByUserId(SysServiceDTO queryDTO);
    
    public List<SysProcessDTO> getSysProcessByUserId(SysProcessDTO queryDTO);
    
    /**
     * @return 獲取系統(數據庫)時間.
     */
    String getSysDate();
    
    /**
     * @return 獲取系統(數據庫)時間（帶時分秒）.
     */
    String getSysDateTime();

    SysServiceProcessDTO getSysServiceProcessByUserId(SysServiceDTO queryDTO);
}
