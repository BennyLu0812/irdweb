package com.ird.portal.common.sys.service;

import java.util.Date;

/**
 * @author Tim
 * @version 1.0
 * @date 21/10/2021 15:54
 */
public interface SpDateprofileServiceApi {

    /**
     * 判断是否假期日期
     * @param date 日期
     * @return 是假期则返回日期字符串反正返回null
     */
    String getHoliday(Date date);

    /**
     * 日期天数在 startDate 之后。如果结束日期是非工作日，则查找到最近的工作日
     * @param startDate 开始日期
     * @param daysForward 开始日期之后天数
     * @return 最近的工作日
     */
    Date getWorkingEndDate(Date startDate, Integer daysForward);

}
