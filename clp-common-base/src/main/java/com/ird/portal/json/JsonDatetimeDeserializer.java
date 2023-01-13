package com.ird.portal.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.ird.portal.util.DateUtil;

import java.io.IOException;
import java.util.Date;


public class JsonDatetimeDeserializer extends JsonDeserializer<Date> {
    
    @Override
    public Date deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {
        return DateUtil.parse(jp.getText(), DateUtil.DATE_TIME_PATTERN);
    }
}
