package com.ird.portal.common.sys.data;

import com.ird.portal.data.BaseDTO;

import java.util.List;
import java.util.Map;



public class SysServiceProcessDTO extends BaseDTO {

    private static final long serialVersionUID = 4896554625967779024L;
    
    private List<SysServiceDTO> serviceList;
    
    private Map<Long,  List<SysProcessDTO>> processListOfServiceId;

    
    public List<SysServiceDTO> getServiceList() {
        return serviceList;
    }

    
    public void setServiceList(List<SysServiceDTO> serviceList) {
        this.serviceList = serviceList;
    }

    public Map<Long, List<SysProcessDTO>> getProcessListOfServiceId() {
        return processListOfServiceId;
    }

    public void setProcessListOfServiceId(Map<Long, List<SysProcessDTO>> processListOfServiceId) {
        this.processListOfServiceId = processListOfServiceId;
    }
}
