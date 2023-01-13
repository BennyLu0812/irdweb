package com.ird.portal.rpt.util;

import java.util.Calendar;
import java.util.Date;

public class DateFormat {
    
    public static void main(String[] args) {
        System.out.println(dateFormat(new Date(),"CN"));
    }
    
    public static String dateFormat(Date d,String language) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int date = calendar.get(Calendar.DAY_OF_MONTH);
        String dateFormat = "";
        if("CN".equals(language)) {
            String yearCn = numToCn(year);
            String monthCn = "";
            if(month<=9) {
                monthCn = numToCn(month);
            }else if(month==10) {
                monthCn = "十";
            }else if(11<=month&&month<=12) {
                monthCn = "十"+ numToCn(month-10);
            }
            
            String dateCn = "";
            if(date<10) {
                dateCn = numToCn(date);
            }else if(date==10) {
                dateCn = "十";
            }else if(11<=date&&date<=19) {
                dateCn = "十" + numToCn(date-10);
            }
            else if(date==20) {
                dateCn = "二十";
            }else if(21<=date&&date<=29) {
                dateCn = "二十" + numToCn(date-20);
            }
            else if(date==30) {
                dateCn = "三十";
            }else {
                dateCn = "三十一";
            }
            dateFormat =  yearCn+"年"+monthCn+"月"+dateCn+"日";
        }else if("PT".equals(language)) {
            String monthPt = "";
            switch(month) {
                case 1:
                    monthPt = "Janeiro";
                    break;
                case 2:
                    monthPt = "Fevereiro";
                    break;
                case 3:
                    monthPt = "Março";
                    break;
                case 4:
                    monthPt = "Abril";
                    break;
                case 5:
                    monthPt = "Maio";
                    break;
                case 6:
                    monthPt = "Junho";
                    break;
                case 7:
                    monthPt = "Julho";
                    break;
                case 8:
                    monthPt = "Agosto";
                    break;
                case 9:
                    monthPt = "Setembro";
                    break;
                case 10:
                    monthPt = "Outubro";
                    break;
                case 11:
                    monthPt = "Novembro";
                    break;
                case 12:
                    monthPt = "Dezembro";
                    break;
                    
            }
            dateFormat =  date+" de "+monthPt+" de "+year;
        }
        return dateFormat;
    }
    
    private static String numToCn(int num) {
        String numStr = num+"";
        String numCn = "";
        for(int i=0;i<numStr.length();i++) {
            char c = numStr.charAt(i);
            switch(c) {
                case '0':
                    numCn=numCn+"零";
                    break;
                case '1':
                    numCn=numCn+"一";
                    break;
                case '2':
                    numCn=numCn+"二";
                    break;
                case '3':
                    numCn=numCn+"三";
                    break;
                case '4':
                    numCn=numCn+"四";
                    break;
                case '5':
                    numCn=numCn+"五";
                    break;
                case '6':
                    numCn=numCn+"六";
                    break;
                case '7':
                    numCn=numCn+"七";
                    break;
                case '8':
                    numCn=numCn+"八";
                    break;
                case '9':
                    numCn=numCn+"九";
                    break;
            }
        }
        return numCn;
    }
}
