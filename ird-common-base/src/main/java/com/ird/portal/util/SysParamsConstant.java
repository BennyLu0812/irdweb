/**
 * @Project Name: dls-common-web
 * @File Name: RedisRepository.java
 * @Date: 11/05/2018 09:16:10
 * @Copyright: Copyright (c) 2018 Atos Information Technology HK Limited. All Rights Reserved.
 */
package com.ird.portal.util;

import com.ird.portal.ehcahe.EhcacheKeyConst;
import com.ird.portal.ehcahe.EhcacheNameConst;
import com.ird.portal.ehcahe.EhcacheUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 系统参数常量
 * 使用方法：String paramValue = SysParamsConstant.getParamValue(paramName);
 * <br/>
 * <br/>
 * <b>Date:</b> 11/05/2018 09:16:10<br/>
 * @author luke
 * @version 1.0
 */
//@Component
public class SysParamsConstant {

    private static final String NULL_VALUE = "NULL";

    /** 时间格式. */
    public static final String DATE_FORMAT = "dd/MM/yyyy";
    /** 日期格式. */
    public static final String DATE_TIME_FORMAT = "dd/MM/yyyy HH:mm:ss";

    /** 連接字符. */
    public static final String CONNECTER = "_";

    /**
     * 根據參數名稱獲取參數的值.
     *
     * @param paramName
     * @return ParamValue in String, null when paramValue is blank or trimmed paramValue equals to {@link#NULL_VALUE}.
     */
    public static String getParamValue(String paramName) {
        String paramValue = getRedisMapValue(paramName);
        return StringUtils.equalsIgnoreCase(StringUtils.trim(paramValue), NULL_VALUE) ? null : paramValue;
    }


    /**
     * Retrieve value map by paramName as Key
     */
    @SuppressWarnings("rawtypes")
    public static Map getParamMapValue(String paramName) {
        String paramValue = getParamValue(paramName);
        return isBlankOrNull(paramValue) ?
                Collections.emptyMap() :
                JsonUtil.parse(paramValue, Map.class);
    }

    /**
     * Retrieve value list by paramName as key, then split the value into list by inputed delimiter
     * @param paramName Name of parameter to be retrieved
     * @param delimiter delimiter use to split the value
     * @return List<String> value list
     */
    public static List<String> getParamValueList(String paramName, String delimiter) {
        String paramValue = getParamValue(paramName);
        return isBlankOrNull(paramValue) ?
                Collections.emptyList() :
                Arrays.asList(StringUtils.split(paramValue, delimiter));
    }


    /**
     * Retrieve value list by paramName as key
     * Split the value with DEFAULT_DELIMITER when the value is not null, else return an empty list
     * @param paramName Name of parameter to be retrieved
     * @return List<String> value list
     */
    public static List<String> getParamValueList(String paramName) {
        return getParamValueList(paramName, DEFAULT_DELIMITER);
    }

    /**
     * Retrieve value list by paramName as key, then split the value into list by inputed delimiter
     * @param paramName Name of parameter to be retrieved
     * @param delimiter delimiter use to split the value
     * @return List<Integer> value list
     */
    public static List<Integer> getParamIntValueList(String paramName, String delimiter) {
        return getParamValueList(paramName, delimiter)
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
//        ArrayList<Integer> paramList = new ArrayList<Integer>();
//        for (String val: getParamValueList(paramName, delimiter)) {
//            paramList.add(Integer.parseInt(val));
//        }
//        return paramList;
    }

    /**
     * Retrieve value list by paramName as key
     * Split the value with DEFAULT_DELIMITER when the value is not null, else return an empty list
     * @param paramName Name of parameter to be retrieved
     * @return List<Integer> value list
     */
    public static List<Integer> getParamIntValueList(String paramName) {
        return getParamIntValueList(paramName, DEFAULT_DELIMITER);
    }

    /**
     * 根據參數名稱獲取參數的Boolean值.
     * @param paramName - Name of parameter to be retrieved
     * @return Boolean - the boolean value of the parameter
     */
    public static Boolean getParamBooleanValue(String paramName) {
        String paramValue = getRedisMapValue(paramName);
        return paramValue == null ? null : BooleanUtils.toBooleanObject(paramValue);
    }

    /**
     * 根據參數名稱獲取參數的Integer值.
     * @param paramName - Name of parameter to be retrieved
     * @return Integer - the Integer value of the parameter
     */
    public static Integer getParamIntValue(String paramName) {
        String paramValue = getRedisMapValue(paramName);
        return NumberUtils.isParsable(paramValue) ? Integer.parseInt(paramValue) : null;
    }

    /**
     * 根據參數名稱獲取參數的Long值.
     * @param paramName - Name of parameter to be retrieved
     * @return Long - the Long value of the parameter
     */
    public static Long getParamLongValue(String paramName) {
        String paramValue = getRedisMapValue(paramName);
        return NumberUtils.isParsable(paramValue) ? Long.parseLong(paramValue) : null;
    }

    /**
     * 根據參數名稱獲取參數的Date值. Date is parsed with default pattern
     * @param paramName Name of parameter to be retrieved
     * @return Date - The date value of the parameter
     */
    public static Date getParamDateValue(String paramName) {
        String paramValue = getRedisMapValue(paramName);
        return isBlankOrNull(paramValue) ? null : DateUtil.parse(paramValue);
    }

    /**
     * 根據參數名稱獲取參數的Date值. Date is parsed with input pattern
     * @param paramName - Name of parameter to be retrieved
     * @param datePattern - pattern to parse the string into date
     * @return Date - The date value of the parameter
     */
    public static Date getParamDateValue(String paramName, String datePattern) {
        String paramValue = getRedisMapValue(paramName);
        return isBlankOrNull(paramValue) ? null : DateUtil.parse(paramValue, datePattern);
    }

    private static String DEFAULT_DELIMITER = ",";


    @SuppressWarnings("rawtypes")
    public static void setParam(Map paramValue){
        EhcacheUtils.put(EhcacheNameConst.SYSTEM, EhcacheKeyConst.SYSPARAM, paramValue);
    }

    @SuppressWarnings("unchecked")
    public static Map<String, String> getParams(){
        return EhcacheUtils.getMap(EhcacheNameConst.SYSTEM, EhcacheKeyConst.SYSPARAM);
    }

    public static String getDateFormat() {
        return Optional.ofNullable(getRedisMapValue("DATE_FORMAT")).orElse(DATE_FORMAT);
    }

    public static String getDateTimeFormat() {
        return Optional.ofNullable(getRedisMapValue("DATE_TIME_FORMAT")).orElse(DATE_TIME_FORMAT);
    }

    private static boolean isBlankOrNull(String paramValue) {
        return StringUtils.isBlank(paramValue) || StringUtils.equalsIgnoreCase(paramValue, NULL_VALUE);
    }

    private static String getRedisMapValue(String paramName) {
        return EhcacheUtils.getMapValue(EhcacheNameConst.SYSTEM, EhcacheKeyConst.SYSPARAM, paramName);
    }

    /**
     * 根據參數名稱獲取參數的Double值.
     * @param paramName - Name of parameter to be retrieved
     * @return Integer - the Integer value of the parameter
     */
    public static Double getParamDoubleValue(String paramName) {
        String paramValue = getRedisMapValue(paramName);
        return NumberUtils.isParsable(paramValue) ? Double.parseDouble(paramValue) : null;
    }

    /**
     * 清除緩存
     */
    public static void remove() {
        EhcacheUtils.delete(EhcacheNameConst.SYSTEM, EhcacheKeyConst.SYSPARAM);
    }

    public static String getDefaultDelimiter() {
        return DEFAULT_DELIMITER;
    }

    public static void setDefaultDelimiter(String defaultDelimiter) {
        DEFAULT_DELIMITER = defaultDelimiter;
    }
}
