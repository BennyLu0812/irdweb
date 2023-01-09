package com.ird.portal.web.xss;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.owasp.encoder.Encode;

import java.io.IOException;

/**
 * 用于處理RequestBody中的JSON數據
 * Created by dujinkai on 2018/5/23.
 * 基于xss的JsonDeserializer
 */
public class XssStringJsonDeserializer extends JsonDeserializer<String>  {


    @Override
    public Class<String> handledType() {
        return String.class;
    }

    @Override
    public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String s = jsonParser.getValueAsString();
        if (s != null) {
            return Encode.forHtmlContent(jsonParser.getValueAsString());
        }
        return s;
    }


}
