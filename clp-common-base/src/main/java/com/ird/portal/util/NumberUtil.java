package com.ird.portal.util;

import java.math.BigDecimal;

/**
 * <br/>
 * <br/>
 * <b>Date:</b> 2022/8/24 11:33<br/>
 *
 * @author Zack
 * @version 1.0
 */
public class NumberUtil {

    public static BigDecimal bigDecimalFormat(BigDecimal bigDecimal, Integer scale){
        if(bigDecimal == null){
            return null;
        }
        return bigDecimal.setScale(scale, BigDecimal.ROUND_DOWN);
    }

    public static BigDecimal bigDecimalFormat(BigDecimal bigDecimal){
        if(bigDecimal == null){
            return null;
        }
        return bigDecimal.setScale(0, BigDecimal.ROUND_DOWN);
    }

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal(0.0000000);
        System.out.println(bigDecimalFormat(bigDecimal));
    }
}
