package com.ird.portal.sys.service.impl;

import com.ird.portal.common.sys.service.SpDateprofileServiceApi;
import com.ird.portal.sys.mapper.SpDateprofileMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Tim
 * @version 1.0
 * @date 21/10/2021 16:22
 */
@Service
public class SpDateprofileServiceImpl implements SpDateprofileServiceApi {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    private final SpDateprofileMapper spDateprofileMapper;

    public SpDateprofileServiceImpl(SpDateprofileMapper spDateprofileMapper) {
        this.spDateprofileMapper = spDateprofileMapper;
    }

    @Override
    public String getHoliday(Date date) {
        return spDateprofileMapper.getHoliday(date);
    }

    public Date getWorkingDateForward(Date startDate, Integer daysForward){
        return getWorkingDate(startDate, daysForward);
    }

    public Date getWorkingDateBackward(Date startDate, Integer daysBackward){
        return getWorkingDate(startDate, daysBackward * -1);
    }

    public Date getWorkingDate(Date startDate, Integer daysForward){
        Calendar cd = Calendar.getInstance();
        int delta = daysForward > 0 ? 1 : -1;
        int step = daysForward < 0 ? daysForward * -1 : daysForward;
        int intHolidayCnt = 0;
        cd.setTime(startDate);
        for (int i = 0; i < step; i++) {
            cd.add(Calendar.DAY_OF_MONTH, delta);
            String holiday = getHoliday(cd.getTime());
            int week = cd.get(Calendar.DAY_OF_WEEK);
            if (!StringUtils.isBlank(holiday) ||
                    week == Calendar.SATURDAY ||
                    week == Calendar.SUNDAY) {
                intHolidayCnt++;
            }
        }
        while (intHolidayCnt != 0) {
            cd.add(Calendar.DAY_OF_MONTH, delta);
            String holiday = getHoliday(cd.getTime());
            int week = cd.get(Calendar.DAY_OF_WEEK);
            if (StringUtils.isBlank(holiday) &&
                    week != Calendar.SATURDAY &&
                    week != Calendar.SUNDAY) {
                intHolidayCnt--;
            }
        }
        return cd.getTime();
    }

    /**
     * @return Date daysBackward forward of startDate. if the end date is non-working day, it find forward to a nearest working day.
     */
    public Date getWorkingEndDateForward(Date startDate, Integer daysForward) {
        return getWorkingEndDate(startDate, daysForward);
    }

    @Override
    public Date getWorkingEndDate(Date startDate, Integer daysForward) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(startDate);
        cd.add(Calendar.DAY_OF_MONTH, daysForward);
        if (daysForward >=0 ) {
            return isWorkingDayAndForward(cd.getTime());
        } else {
            return isWorkingDayAndBackward(cd.getTime());
        }
    }

    /**
     * <pre>
     * Find out the number of working day between "from" and "to" inclusively.
     * </pre>
     * @param from
     * @param to
     * @return Integer Number of working day
     */
    public Integer getWorkingDayCount(Date from, Date to) {
        if (from == null || to == null) {
            logger.error("from / to date is null, from:{}, to:{}", from, to);
            throw new InvalidParameterException("from / to date is null");
        }
        Date start;
        Date end;
        if (from.before(to)) {
            start = from;
            end = to;
        } else {
            start = to;
            end = from;
        }
        Calendar cd = Calendar.getInstance();
        Integer workingDaycount = 0;
        do {
            cd.setTime(start);
            String holiday = getHoliday(cd.getTime());
            int week = cd.get(Calendar.DAY_OF_WEEK);
            if (StringUtils.isBlank(holiday) &&
                    week != Calendar.SATURDAY &&
                    week != Calendar.SUNDAY) {
                workingDaycount ++;
            }
            cd.add(Calendar.DAY_OF_MONTH, 1);
            start = cd.getTime();
        }
        while (start.compareTo(end) <= 0);
        return workingDaycount;
    }

    /**
     * Check whether inputed pDate is working day or not
     * @param pDate Date to be checked
     * @return Date pDate if it is a working day, else find the nearest working day from backward
     */
    public Date isWorkingDayAndBackward(Date pDate){
        Calendar cd = Calendar.getInstance();
        cd.setTime(pDate);
        String holiday = getHoliday(cd.getTime());
        int week = cd.get(Calendar.DAY_OF_WEEK);
        if (StringUtils.isBlank(holiday) &&
                week != Calendar.SATURDAY &&
                week != Calendar.SUNDAY) {
            return pDate;
        } else {
            return getWorkingDateBackward(pDate, 1);
        }
    }

    /**
     * Check whether inputed pDate is working day or not
     * @param pDate Date to be checked
     * @return Date pDate if it is a working day, else find the nearest working day from forward
     */
    public Date isWorkingDayAndForward(Date pDate){
        Calendar cd = Calendar.getInstance();
        cd.setTime(pDate);
        String holiday = getHoliday(cd.getTime());
        int week = cd.get(Calendar.DAY_OF_WEEK);
        if (StringUtils.isBlank(holiday) &&
                week != Calendar.SATURDAY &&
                week != Calendar.SUNDAY) {
            return pDate;
        } else {
            return getWorkingDateForward(pDate, 1);
        }
    }


    public boolean isWorkingDay(Date pDate){
        Calendar cd = Calendar.getInstance();
        cd.setTime(pDate);
        String holiday = getHoliday(cd.getTime());
        int week = cd.get(Calendar.DAY_OF_WEEK);
        return StringUtils.isBlank(holiday) &&
                week != Calendar.SATURDAY &&
                week != Calendar.SUNDAY;
    }


}
