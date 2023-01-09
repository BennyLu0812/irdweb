package com.ird.portal.sys;

import com.ird.portal.i18n.CustomizedMessageSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/sys/i18n")
public class I18nController {
    
    @Autowired
    private CustomizedMessageSource messageSource;
    
    @GetMapping("/getByModules")
    @ResponseBody
    public HttpEntity<Map<String, String>> getByModules(HttpServletRequest request, @RequestParam String moduleCodes) {
        Map<String, String> map = new HashMap<>();
        
        String[] moduleCodeArray = StringUtils.commaDelimitedListToStringArray(StringUtils.trimAllWhitespace(moduleCodes));
        Set<String> basenameSet = messageSource.getBasenameSet();
        for (String moduleCode : moduleCodeArray) {
            String name = "i18n/" + moduleCode.trim() + "/messages";
            for (String basename : basenameSet) {
                if (name.equals(basename)) {
                    Locale locale=(Locale) WebUtils.getSessionAttribute(request,
                            SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
                    if(locale == null){
                        locale = new Locale("ZH_CN");
                    }
                    messageSource.putCodeAndMessages(basename, locale, map);
                    break;
                }
            }
        }
        
        return new HttpEntity<Map<String, String>>(map);
    }
    
}
