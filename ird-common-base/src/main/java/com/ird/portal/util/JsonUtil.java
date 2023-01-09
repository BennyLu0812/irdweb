package com.ird.portal.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ird.portal.exception.IllegalParameterValueException;

import java.text.SimpleDateFormat;

/**
 * json通用工具.
 *
 * <br/>
 * <br/>
 * <b>Date:</b> 20/07/2018 17:39:37<br/>
 * @author parko.lam
 * @version 1.0
 */
public final class JsonUtil {

    private JsonUtil() {
        super();
    }

    private static ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.setDateFormat(new SimpleDateFormat(DateUtil.DATE_TIME_PATTERN)); // 定義格式化規則
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * parse.
     * @param content json字符串内容
     * @param valueType 類類型
     * @param <T> valueType對應的對象
     * @return 對應的對象
     */
    public static <T> T parse(String content, Class<T> valueType) {
        try {
            return mapper.readValue(content, valueType);
        } catch (Exception e) {
            throw new IllegalParameterValueException(content);
        }
    }

    public static  <T> T parse(String content, TypeReference<T> valueTypeRef) {
        try {
            return mapper.readValue(content, valueTypeRef);
        } catch (Exception e) {
            throw new IllegalParameterValueException(content);
        }
    }
    
    /**
     * format對象.
     * @param obj obj
     * @return String
     */
    public static String format(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new IllegalParameterValueException(obj);
        }
    }
    
    /**
     * requestBody 轉爲JsonNode.
     * @param requestBody requestBody
     * @return JsonNode
     */
    public static JsonNode readTree(String requestBody) {
        try {
            return mapper.readTree(requestBody);
        } catch (Exception e) {
            throw new IllegalParameterValueException(requestBody);
        }
    }
}
