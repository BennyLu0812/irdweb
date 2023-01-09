package com.ird.portal.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.ird.portal.util.DateUtil;

import java.io.IOException;
import java.util.Date;


public class JsonDatetimeSerializer extends JsonSerializer<Date> {
    
    @Override
    public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers)
        throws IOException, JsonProcessingException {
        gen.writeString(DateUtil.format(value, DateUtil.DATE_TIME_PATTERN));
    }
    
}
