package com.ird.portal.rpt.mapper;

import com.ird.portal.common.rpt.data.BenExhaustStatisticsDTO;
import com.ird.portal.common.rpt.data.InspectionDataStatisticsDTO;
import com.ird.portal.common.rpt.data.InspectionItemStatisticsDTO;
import com.ird.portal.common.rpt.data.PdaLoginLogoutLogDTO;
import com.ird.portal.dao.JpaSqlDao;
import com.ird.portal.datatable.DatatableDaoCmd;
import com.ird.portal.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Tim
 * @version 1.0
 * @date 21/01/2022 17:46
 */
@Repository
public class ReportExportMapper {

    @Autowired
    private JpaSqlDao dao;

    public Page getInspectionDataStatisticsPage(InspectionDataStatisticsDTO inspectionDataStatisticsDTO)  {
        return dao.getPage(new DatatableDaoCmd("getInspectionDataStatisticsPage", inspectionDataStatisticsDTO),
                InspectionDataStatisticsDTO.class, true);
    }

    public Page getInspectionItemStatisticsPage(InspectionItemStatisticsDTO inspectionItemStatisticsDTO) {
        return dao.getPage(new DatatableDaoCmd("getInspectionItemStatisticsPage", inspectionItemStatisticsDTO),
                InspectionItemStatisticsDTO.class, true);
    }

    public Page getPdaLoginLogoutLogPage(PdaLoginLogoutLogDTO pdaLoginLogoutLogDTO) {
        return dao.getPage(new DatatableDaoCmd("getPdaLoginLogoutLogPage", pdaLoginLogoutLogDTO),
                PdaLoginLogoutLogDTO.class, true);
    }

    public Page getAsmInspDataStatisticsPage(BenExhaustStatisticsDTO benExhaustStatisticsDTO) {
        return dao.getPage(new DatatableDaoCmd("getAsmInspDataStatisticsPage", benExhaustStatisticsDTO),
                BenExhaustStatisticsDTO.class, true);
    }

    public Page getLugdownInspDataStatisticsPage(BenExhaustStatisticsDTO benExhaustStatisticsDTO) {
        return dao.getPage(new DatatableDaoCmd("getLugdownInspDataStatisticsPage", benExhaustStatisticsDTO),
                BenExhaustStatisticsDTO.class, true);
    }

    public Page getMotorcycleIdleInspDataStatisticsPage(BenExhaustStatisticsDTO benExhaustStatisticsDTO) {
        return dao.getPage(new DatatableDaoCmd("getMotorcycleIdleInspDataStatisticsPage", benExhaustStatisticsDTO),
                BenExhaustStatisticsDTO.class, true);
    }

    public Page getCarDoubleIdleInspDataStatisticsPage(BenExhaustStatisticsDTO benExhaustStatisticsDTO) {
        return dao.getPage(new DatatableDaoCmd("getCarDoubleIdleInspDataStatisticsPage", benExhaustStatisticsDTO),
                BenExhaustStatisticsDTO.class, true);
    }

}
