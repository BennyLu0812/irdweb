package com.ird.portal.util;

import com.ird.portal.exception.ParameterIsEmptyException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.datatype.XMLGregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * Title: methods for handling the Date. Description: Date: Jun 4, 2016 3:06:42 PM
 *
 * @author: Crystal Zhao
 * @version 1.0
 * @Create Time: 3:06:42 PM
 */
public final class DateUtil {

    private DateUtil(){}

    public static final String DATE_PATTERN_1 = "yyyyMMdd";

    public static final String DATE_PATTERN = "dd/MM/yyyy";
    
    public static final String DATE_TIME_PATTERN = "dd/MM/yyyy HH:mm:ss";

    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_FORMAT_2 = "yyyy-MM-dd'T'HH:mm:ss.SSS+08:00";

    public static final String DATE_TIME_SYSTEM_PATTERN = "yyyyMMddHHmmss";

    private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);
    
    public static String sysTimeInSystemFormat() {
        return format(new Date(), DATE_TIME_SYSTEM_PATTERN);
    }
    
    public static Date trimTimePart(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
    
    public static Integer getYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        
        return cal.get(Calendar.YEAR);
    }

    public static Integer getMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        return cal.get(Calendar.MONTH);
    }

    public static Integer getDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        return cal.get(Calendar.DAY_OF_MONTH);
    }

    public static boolean dateEquals(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);

        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)
                && cal1.get(Calendar.DATE) == cal2.get(Calendar.DATE);
    }
    
    /**
     * Compare the date with startDate and endDate
     *
     * @param startDate
     * @param endDate
     * @param date
     * @return
     */
    public static boolean compareDate(Date startDate, Date endDate, Date date) {
        date = getDate(date);
        return date.compareTo(getDate(startDate)) >= 0 && date.compareTo(getDate(endDate)) <= 0;
    }
    
    /**
     * ??????startDate ????????????endDate?????????true,????????????.
     * @param startDate
     * @param endDate
     * @return
     */
    public static boolean compareDate(Date startDate, Date endDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN_1);
        int startDateVal = Integer.parseInt(simpleDateFormat.format(startDate));
        int endDateVal = Integer.parseInt(simpleDateFormat.format(endDate));
        return startDateVal >= endDateVal;
    }

    /**
     * ??????startDate ??????endDate?????????true,????????????.
     * @param startDate
     * @param endDate
     * @return
     */
    public static boolean compareDateByValidate(Date startDate, Date endDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN_1);
        int startDateVal = Integer.parseInt(simpleDateFormat.format(startDate));
        int endDateVal = Integer.parseInt(simpleDateFormat.format(endDate));
        return startDateVal > endDateVal;
    }
    
    public static Date getDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getTime();
    }
    
    /**
     * ??????????????????????????????
     * 
     * @param dateStr ????????????????????????
     * @return ????????????
     */
    public static Date parse(String dateStr) {
        return parse(dateStr, DATE_PATTERN);
    }
    
    public static Date parse(String dateStr, String format) {
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        Date date = null;
        SimpleDateFormat dataFormat = new SimpleDateFormat(format);
        try {
            date = dataFormat.parse(dateStr);
        }
        catch (Exception ex) {
            logger.error("dataFormat is error",ex);
        }
        return date;
    }
    
    public static String format(Date date) {
        return format(date, DATE_PATTERN);
    }
    
    public static String format(Date date, String format) {
        if (date == null || StringUtils.isBlank(format)) {
            return null;
        } else {
            SimpleDateFormat dataFormat = new SimpleDateFormat(format);
            return dataFormat.format(date);
        }
    }

    /**
     * ??????????????????????????????????????????
     *
     * @param smdate ???????????????
     * @param bdate ???????????????
     * @return ???????????????
     * @throws ParseException
     */
    public static int minsBetween(Date smdate, Date bdate)
            throws ParseException {
        //??????????????????
        long nd = (long)1000*24*60*60;
        //?????????????????????
        long nm = (long)1000*60;

        SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_PATTERN);
        long diff = sdf.parse(sdf.format(bdate)).getTime() - sdf.parse(sdf.format(smdate)).getTime();
        //?????????????????????
        long betweenDays = diff%nd/nm;
        return Integer.parseInt(String.valueOf(betweenDays));
    }
    
    /**
     * ???????????????????????????????????????
     * 
     * @param smdate ???????????????
     * @param bdate ???????????????
     * @return ????????????
     * @throws ParseException
     */
    public static int daysBetween(Date smdate, Date bdate)
        throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
        smdate = sdf.parse(sdf.format(smdate));
        bdate = sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long betweenDays = (time2 - time1) / (1000 * 3600 * 24);
        
        return Integer.parseInt(String.valueOf(betweenDays));
    }
    
    public static int monthsBetween(Date start, Date end) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(start);
        c2.setTime(end);
        if (c1.getTimeInMillis() < c2.getTimeInMillis()) {
            long milSeconds = c2.getTimeInMillis();
            c2.setTimeInMillis(c1.getTimeInMillis());
            c1.setTimeInMillis(milSeconds);
        }
        int year1 = c1.get(Calendar.YEAR);
        int year2 = c2.get(Calendar.YEAR);
        int month1 = c1.get(Calendar.MONTH);
        int month2 = c2.get(Calendar.MONTH);
        int day1 = c1.get(Calendar.DAY_OF_MONTH);
        int day2 = c2.get(Calendar.DAY_OF_MONTH);
        
        int yearInterval = year1 - year2;
        // ?????? d1??? ???-??? ?????? d2??? ???-??? ?????? yearInterval-- ?????????????????????????????????
        if (month1 < month2 || month1 == month2 && day1 < day2)
            yearInterval--;
        // ??????????????????
        int monthInterval = (month1 + 12) - month2;
        if (day1 < day2)
            monthInterval--;
        monthInterval %= 12;
        return yearInterval * 12 + monthInterval;
    }
    
    public static double yearsBetween(Date start, Date end) {

        // ??????????????????????????????????????????
        int startYear = getYear(start);
        int endYear = getYear(end);
        int sum=0;
        for(int i = startYear;i <= endYear; i++) {
            if (i % 400 == 0 || (i % 4 == 0 && i % 100 != 0)) {
                sum++;
            }
        }
        if((startYear % 400 == 0 || (startYear % 4 == 0 && startYear % 100 != 0))
                && start.compareTo(parse("28/02/"+startYear)) > 0) {
            sum--;
        }
        if((endYear % 400 == 0 || (endYear % 4 == 0 && endYear % 100 != 0))
                && end.compareTo(parse("28/02/"+endYear)) <= 0) {
            sum--;
        }
        // ???????????????????????????????????????-????????????????????? / 365
        long intervalMills = end.getTime() - start.getTime();
        long dayMills = (long) 1000 * 60 * 60 * 24;
        long days = intervalMills/dayMills;
        return Math.abs((days - sum) / 365.0);
    }
    
    public static Date dayPlus(Date date, long plus)
        throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
        date = sdf.parse(sdf.format(date));
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        long time = cal.getTimeInMillis();
        long days = (plus) * (1000 * 3600 * 24);
        long time2 = time + days;
        
        Calendar cal2 = Calendar.getInstance();
        cal2.setTimeInMillis(time2);
        
        return cal2.getTime();
    }

    public static Date dayAdd(Date date,int field, int amount)
             {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(field,amount);
        return cal.getTime();
    }
    /**
     * Null safe method to check if it is on same day
     * 
     * @param date1
     * @param date2
     * @return true if date1 and date2 is on same day, only Date part is consider, time part is ignored
     */
    public static Boolean isSameDay(Date date1, Date date2) {
        if (date1 == null && date2 == null) {
            return true;
        }
        if (date1 != null && date2 != null) {
            return DateUtils.isSameDay(date1, date2);
        }
        return false;
    }

    /**
     * ?????????????????????.
     *
     * @param date date
     * @return days
     */
    public static Integer getMonthDays(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
    
    /**
     * ??????????????????????????????.
     * 
     * @param date ????????????
     * @return ????????????????????????
     */
    public static Date getAfterDay(final Date date) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // ??????????????????
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }
    
    /**
     * ??????????????????????????????.
     * 
     * @param date ????????????
     * @param days ??????
     * @return ?????????????????????
     */
    public static Date getAfterDayByOrg(final Date date, final Integer days) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // ??????????????????
        calendar.add(Calendar.DAY_OF_MONTH, days);
        return calendar.getTime();
    }
    
    /**
     * ??????????????????????????????.
     * 
     * @param date ????????????
     * @return ????????????????????????
     */
    public static Date getBeforeDay(final Date date) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // ??????????????????
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        return calendar.getTime();
    }
    
    /**
     * ???????????????.
     * 
     * 1:????????????2:????????????3:????????????4:????????????5:????????????6:????????????7:????????????
     * 
     * @param date ????????????
     * @return Weekday
     */
    public static int getWeekday(final Date date) {
        final Calendar calendar = Calendar.getInstance();
        if (date != null) {
             calendar.setTime(date);      
        }        
        int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;      
        if (w == 0) {
            w = 7;      
        }      
        return w;    
    }

    /**
     * ?????????????????????????????????????????????
     *
     * @param date
     *            ?????????????????????
     * @return
     */
    public static boolean isLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH) == calendar
                .getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /** 
     * ?????????????????????.
     * @param date ????????????
     * @return boolean
     */  
    public static boolean isWeekend(final Date date){  
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        final int week = calendar.get(Calendar.DAY_OF_WEEK) - 1; 
        //0???????????????6????????????
        return week ==6 || week==0;
    }  
    
    public static Date xmlDate2Date(XMLGregorianCalendar cal){
        return cal.toGregorianCalendar().getTime();
    }

    /**
     * @param date1 ????????????
     * @param date2 ?????????
     * @return diff ????????????
     */
    public static Boolean isInDiffMonths(Date date1, Date date2,int diffMonth) {
        return DateUtils.addMonths(date1,diffMonth).after(date2);
    }


    /**
     * ????????????67?????????N???????????????
     */
    public static Double getAgeBy67(Double dAlertAge67,String alertAgeChange){
        Calendar calendar = Calendar.getInstance();
        int yearNow = calendar.get(Calendar.YEAR);
        int monthNow = calendar.get(Calendar.MONTH) + 1;
        int dayNow = calendar.get(Calendar.DAY_OF_MONTH);
        int year67 = (int) (yearNow - dAlertAge67);
        String str = year67 + "-" + monthNow + "-" + dayNow;
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(str);
        } catch (ParseException e) {
            logger.error("SimpleDateFormat is error",e);
        }
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, Integer.parseInt(alertAgeChange));//????????????67????????????9??????
        return DateUtil.yearsBetween(calendar.getTime(), new Date());
    }

    /**
     * ??????????????????????????????????????????????????????????????????true
     * @param startDate
     * @param endDate
     * @return
     */
    public static boolean compareToDate(Date startDate, Date endDate) {
        return compareDateByValidate(startDate, endDate);
    }

    /**
     * ??????????????????(???????????????)????????????????????????????????????????????????true
     * @param startDate
     * @param endDate
     * @return
     */
    public static boolean compareTime(Date startDate, Date endDate) {
        return startDate.getTime() < endDate.getTime();
    }

    /**
     * ????????????????????????????????????
     * @return string
     */
    public static String getYesterday() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE,-1);
        Date d = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN_1);
        return sdf.format(d);
    }


    public static int getAgeByBirthday(Date birthday) {
        return getAgeByBirthday(birthday, new Date());
    }


    public static int getAgeByBirthday(Date birthday, Date comparedDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(comparedDate);
        if (cal.before(birthday)) {
            throw new IllegalArgumentException(
                "The birthDay is before Now.It's unbelievable!");
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH) + 1;
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);

        cal.setTime(birthday);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH) + 1;
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
        int age = yearNow - yearBirth;
        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                // monthNow==monthBirth??
                if (dayOfMonthNow < dayOfMonthBirth) {
                    age--;
                }
            } else {
                // monthNow>monthBirth??
                age--;
            }
        }
        return age;
    }

    /**
     * ??????????????????????????????????????????????????????????????????
     * @param startTime ??????????????????
     * @param endTime ??????????????????
     * @return
     */
    public static String getBookingTime(Date startTime, Date endTime){
        if(startTime == null){
            throw new ParameterIsEmptyException("startTime");
        }
        if (endTime == null){
            throw new ParameterIsEmptyException("endTime");
        }

        SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_PATTERN);
        StringBuilder bookingTime = new StringBuilder();

        bookingTime.append(sdf.format(startTime));
        sdf = new SimpleDateFormat("HH:mm:ss");
        bookingTime.append(" - " + sdf.format(endTime));

        return bookingTime.toString();
    }

    /**
     * ??????????????????+??????????????????????????????????????????????????????????????????
     * @param startTime ??????????????????
     * @param checkInEarlyMin ???????????????????????????????????????
     * @return
     */
    public static boolean isBeforeCurrentDate(Date startTime, int checkInEarlyMin){
        logger.debug("checkInEarlyMin????????????: {}", (0-checkInEarlyMin));

        Calendar start = Calendar.getInstance();
        start.setTime(startTime);
        start.add(Calendar.MINUTE, (0-checkInEarlyMin));
        logger.debug("???????????????{}", start.getTime());

        Calendar current = Calendar.getInstance();
        current.setTime(new Date());
        logger.debug("???????????????{}", current.getTime());

        //??????????????????????????????????????????true
        if (start.before(current)){
            logger.debug("true");
            return true;
        }
        logger.debug("false");
        return false;
    }

    /**
     * ??????????????????+?????????????????????????????????????????????????????????????????????
     * @param endTime ??????????????????
     * @param checkInLateMin ???????????????????????????????????????
     * @return
     */
    public static boolean isAfterCurrentDate(Date endTime, int checkInLateMin){
        logger.debug("checkInLateMin: {}", checkInLateMin);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);
        end.add(Calendar.MINUTE, checkInLateMin);
        logger.debug("???????????????{}", end.getTime());

        Calendar current = Calendar.getInstance();
        current.setTime(new Date());
        logger.debug("???????????????{}", current.getTime());

        //??????????????????????????????????????????true
        if (end.after(current)){
            logger.debug("true");
            return true;
        }
        logger.debug("false");
        return false;
    }

    public static Date getDate(String dates, String time){
        String newDate = dates.split(" ")[0].replace("-", "/");
        try {
            return new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").parse(newDate + " " + time + ":00");
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date getBeginDate(String targetDate, String targetTime){
        String beginTimeS = targetTime.substring(0, 8);
        try {
            return new SimpleDateFormat().parse(targetDate + " " + beginTimeS);
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date getEndDate(String targetDate, String targetTime){
        String endTimeS = targetTime.substring(9);
        try {
            return new SimpleDateFormat().parse(targetDate + " " + endTimeS);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String getDateByFileName(String fileName, String pattern){
        logger.debug(fileName);
        String[] files = fileName.split("\\\\");
        //???????????????
        String photoTimeStr = files[files.length - 1];
        photoTimeStr = photoTimeStr.substring(0, photoTimeStr.indexOf("."));

        Date photoTime = null;

        //????????????\??????????????????????????????????????????
        String[] timeStr = photoTimeStr.split("_");
        if(timeStr.length == 1){
            //?????????????????????????????????????????????
            photoTime = new Date(Long.valueOf(photoTimeStr));

        }else{
            //????????????plateNo_vehType_chekInId_yyyyMMddHHmmss
            photoTimeStr = timeStr[timeStr.length - 1];
            photoTime = DateUtil.parse(photoTimeStr, pattern);
        }

        return format(photoTime, DATE_TIME_PATTERN);
    }


}
