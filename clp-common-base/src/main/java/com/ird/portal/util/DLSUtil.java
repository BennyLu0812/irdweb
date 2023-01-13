package com.ird.portal.util;

import com.ird.portal.exception.InvalidDataException;
import com.ird.portal.exception.ParameterIsEmptyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * 系統相關幫助類
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 08/05/2018 21:28:44<br/>
 * @author Crystal Zhao
 * @version 1.0
 */
public final class DLSUtil {
    private static final Logger LOG = LoggerFactory.getLogger(DLSUtil.class);

    /**
     * 根據出生日期計算年齡
     * @param birthDate
     * @return
     */
    public static int getAge(Date birthDate) {
        int age = 0;
        Calendar born = Calendar.getInstance();
        Calendar now = Calendar.getInstance();
        if (birthDate != null) {
            //當前系統時間
            now.setTime(new Date());
            born.setTime(birthDate);
            if (born.after(now)) {
                throw new IllegalArgumentException("出生日期不能超过当前日期");
            }
            int nowYear = now.get(Calendar.YEAR);
            int bornYear = born.get(Calendar.YEAR);
            age = nowYear - bornYear;
            
            int nowMonth = now.get(Calendar.MONTH)+1;
            int bornMonth = born.get(Calendar.MONTH)+1;
            
            int nowDate = now.get(Calendar.DATE);
            int bornDate = born.get(Calendar.DATE);
            
            if(bornMonth>nowMonth) {
                age-=1;
            }else if(bornMonth==nowMonth){
                if(bornDate>nowDate) {
                    age-=1;
                }
            }
//            int nowDayOfYear = now.get(Calendar.DAY_OF_YEAR);
//            int bornDayOfYear = born.get(Calendar.DAY_OF_YEAR);
//            
//            System.out.println("test");
//            //System.out.println("nowDayOfYear:" + nowDayOfYear + " bornDayOfYear:" + bornDayOfYear);
//            if (nowDayOfYear < bornDayOfYear) {
//                age -= 1;
//            }
        }
        return age;
    }
    
    
    public static Date calSubstituteValidDate(Date applyDate, Date licenseValidDate) throws ParseException {
        Date substituteValidDate = applyDate;
        
        Integer interval = SysParamsConstant.getParamIntValue("SUBSTITUTE_VALID_INTERVAL");
        interval = (interval == null)?90:interval;
        //申請日期加89天
        substituteValidDate = DateUtil.dayPlus(applyDate, interval-1);

//        //若駕照有效期少於90日，則替代文件有效期等於駕照有效期
//        if(licenseValidDate == null) {
//            substituteValidDate = DateUtil.dayPlus(applyDate, interval-1);
//        }else {
//            int licValidCount = DateUtil.daysBetween(new Date(), licenseValidDate);
//            if(licValidCount < interval) {
//                substituteValidDate = licenseValidDate;
//            }else {//若駕照有效期大於等於90日，則替代文件有效期等於申請日+90日
//                substituteValidDate = DateUtil.dayPlus(applyDate, interval-1);
//            }
//        }
        
        return substituteValidDate;

    }
    
    /**
     * 判斷一個日期與另一個日期的時間間隔是否在傳入的這個時間間隔內
     * @param currentDate 當前日期
     * @param licenseValidDate 駕照有效期
     * @param interval 時間間隔
     * @return true 表示在這個間隔內，false 在這個間隔外
     * @throws ParseException
     */
    public static boolean comparingDateInRange(Date currentDate, Date licenseValidDate, Integer interval) throws ParseException {
        if(interval == null) {
            throw new ParameterIsEmptyException("interval is null");
        }
        try {
            Date date = DateUtil.dayAdd(licenseValidDate,Calendar.MONTH,interval * -1);
            interval = DateUtil.daysBetween(currentDate,date);
        } catch (ParseException e) {
            throw new InvalidDataException(e);
        }
        if (interval >= 0) {
            return false;
        }else {
            return true;
        }
    }


    /**
     * 用生日與sysdate做比較，判斷是否在interval的範圍內
     * 若不在範圍內，拋出異常
     * @param birthDate: 指定日期
     * @param interval: 以月份作為單位
     */
    public static boolean checkDateAlert(Date birthDate, Integer age, Integer interval) {
        if(interval == null || interval <= 0){
            throw new ParameterIsEmptyException("interval = " + interval);
        }
        if(birthDate == null){
            throw new ParameterIsEmptyException("date is null");
        }

        //獲取age對應的生日的日期：
        Date ageBirthDate = DateUtil.dayAdd(birthDate, Calendar.YEAR, age);
        LOG.debug("birthDate: {}, age: {}, ageBirthDate: {}", birthDate, age, ageBirthDate);
        //減去能提示的範圍：
        Date alertStartDate = DateUtil.dayAdd(ageBirthDate, Calendar.MONTH, -interval);
        LOG.debug("alertStartDate: {}", alertStartDate);
        //檢查sysdate是否在alertStartDate之後
        boolean result = DateUtil.compareDate(new Date(),alertStartDate);
        //result=true, 代表今日系alertStartDate之後，需要提示
        return result;
    }

    public static String getAgeDays(Date birthDate) throws ParseException{
        int age = 0;
        Calendar born = Calendar.getInstance();
        Calendar now = Calendar.getInstance();
        //當前系統時間
        now.setTime(new Date());
        born.setTime(birthDate);
        if (born.after(now)) {
            throw new IllegalArgumentException("出生日期不能超过当前日期");
        }
        int nowYear = now.get(Calendar.YEAR);
        int bornYear = born.get(Calendar.YEAR);
        age = nowYear - bornYear;

        int nowMonth = now.get(Calendar.MONTH)+1;
        int bornMonth = born.get(Calendar.MONTH)+1;

        int nowDate = now.get(Calendar.DATE);
        int bornDate = born.get(Calendar.DATE);

        if(bornMonth>nowMonth) {
            age-=1;
        }else if(bornMonth==nowMonth){
            if(bornDate>nowDate) {
                age-=1;
            }
        }

        Date thisYearBirthDate = DateUtil.dayAdd(birthDate, Calendar.YEAR, age);

        int months = DateUtil.daysBetween(thisYearBirthDate, new Date());

        Date thisYearBirthDate2 = DateUtil.dayAdd(thisYearBirthDate, Calendar.MONTH, -months);

        int days = DateUtil.daysBetween(thisYearBirthDate2, new Date());


        return age+"歲，多"+months+"個月"+days+"天";
    }
    
    public static void main(String[] args) {
        /*int age = DLSUtil.getAge(DateUtil.parse("11/12/1961"));
        System.out.println(age);*/

        /*boolean result1 = DLSUtil.checkDateAlert(DateUtil.parse("06/11/1954"), 67, 12);
        System.out.println(result1);

        boolean result2 = DLSUtil.checkDateAlert(DateUtil.parse("01/11/1953"), 67, 12);
        System.out.println(result2);*/

        try{
            String result3 = DLSUtil.getAgeDays(DateUtil.parse("06/11/1954"));
            System.out.println(result3);
        }catch(ParseException ex){
            System.out.println(ex.toString());
        }

    }
}
