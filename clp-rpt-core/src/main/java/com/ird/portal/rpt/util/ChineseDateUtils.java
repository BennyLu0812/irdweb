package com.ird.portal.rpt.util;

import java.util.Calendar;
import java.util.Date;

/**
 * 小寫格式日期轉大寫格式日期
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 20/06/2018 17:08:16<br/>
 * @author Joe
 * @version 1.0
 */
public class ChineseDateUtils {

    private ChineseDateUtils(){}

    protected static final char[] upper = "〇一二三四五六七八九十".toCharArray();
    
    public static String getUpperDate(Date date) {
        if(date ==null) return null;
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH)+1;
        int day = cal.get(Calendar.DATE);
        
        StringBuilder sb = new StringBuilder();
        sb.append(formatYear(year));
        sb.append("年");//拼接年
        sb.append(formatMonth(month));
        sb.append("月");//拼接月
        sb.append(formatDate(day));
        sb.append("日");//拼接日
        
        return sb.toString();
    }
    
    public static String formatYear(int year) {
        StringBuilder result = new StringBuilder();
        for(char c : String.valueOf(year).toCharArray()) {
            result.append(formatDigit(c));
        }
        return result.toString();
    }

    public static String formatMonth(int month) {
        StringBuilder result = new StringBuilder();
        int i = String.valueOf(month).length();
        for(char c : String.valueOf(month).toCharArray()) {
            if(i==2) {
                if(c=='1') {
                    result.append("十");
                }
            }else{
                result.append(formatDigit(c));
            }
            i--;
        }
        return result.toString();
    }


    public static String formatDate(int date) {
        StringBuilder result = new StringBuilder();
        int i = String.valueOf(date).length();
        for(char c : String.valueOf(date).toCharArray()) {
            result.append(formatDigit(c));
            if(i==2) {
                if("一".equals(result.toString())){
                    result.setLength(0);
                    result.append("十");
                }else{
                    result.append("十");
                }
            }
            i--;
        }
        return result.toString();
    }
    
    /**
     * 描述：将源字符串中的阿拉伯数字格式化为汉字
     * @param sign 源字符串中的字符
     * @return
     */
   private static char formatDigit(char sign){
       switch (sign) {
           case '0':
               return '零';
           case '1':
               return '一';
           case '2':
               return '二';
           case '3':
               return '三';
           case '4':
               return '四';
           case '5':
               return '五';
           case '6':
               return '六';
           case '7':
               return '七';
           case '8':
               return '八';
           case '9':
               return '九';
           default:
               return sign;
       }
   }
}
