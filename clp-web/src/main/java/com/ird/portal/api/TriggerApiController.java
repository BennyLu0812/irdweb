package com.ird.portal.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Benny
 * @description:
 * @date 2023/1/16
 */
@Controller
@RequestMapping("/triggerApi")
public class TriggerApiController {

    @GetMapping("/alertBlackoutCreate.html")
    public String alertBlackoutCreateRequest() {
        return "triggerApi/alertBlackoutCreate";
    }

    @GetMapping("/alertBlackoutUpdate.html")
    public String alertBlackoutUpdateRequest() {
        return "triggerApi/alertBlackoutUpdate";
    }

    @GetMapping("/alertBlackoutQuery.html")
    public String alertBlackoutAPIQueryRequest() {
        return "triggerApi/alertBlackoutQuery";
    }

    @GetMapping("/alertBlackoutOutput.html")
    public String alertBlackoutRequestOutput() {
        return "triggerApi/alertBlackoutOutput";
    }

    @GetMapping("/alertBlackoutCancel.html")
    public String alertBlackoutAPICancelRequest() {
        return "triggerApi/alertBlackoutCancel";
    }

    @GetMapping("/serviceFailureEvent.html")
    public String serviceFailureEventAPIRequest() {
        return "triggerApi/serviceFailureEvent";
    }

    @GetMapping("/securityEvent.html")
    public String securityEventAPIRequest() {
        return "triggerApi/securityEvent";
    }

    @GetMapping("/renewCert.html")
    public String renewCertResponse() {
        return "triggerApi/renewCert";
    }

    @GetMapping("/heartBeat.html")
    public String heartBeatAPIRequest() {
        return "triggerApi/heartBeat";
    }

    @GetMapping("/history.html")
    public String showHistory() {
        return "triggerApi/history";
    }

}
