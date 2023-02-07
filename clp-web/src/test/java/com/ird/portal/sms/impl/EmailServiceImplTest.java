package com.ird.portal.sms.impl;

import com.ird.portal.CLPWebApplication;
import com.ird.portal.common.api.data.CLPApiHistoryDTO;
import com.ird.portal.core.service.CLPApiHistoryService;
import com.ird.portal.sms.IEmailService;
import com.ird.portal.util.SysParamsConstant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CLPWebApplication.class)
@Transactional
public class EmailServiceImplTest  {

    @Autowired
    private IEmailService emailService;

    @Autowired
    private CLPApiHistoryService clpApiHistoryService;

    @Test
    public void testSendSimpleMail() {

        String toEmail= SysParamsConstant.getParamValue("TEST_TO_EMAIL");
        String fromEmail= SysParamsConstant.getParamValue("TEST_FROM_EMAIL");
        String ccEmail= SysParamsConstant.getParamValue("CC_EMAIL");

            try{

                // 將taskPlanList配置為郵件參數
                Map<String, Object> params = new HashMap<String, Object>();

                //  發送郵件
                emailService.sendThymeleafHtmlMail(toEmail,"testSendSimpleMail", params,
                        "sms/testMail", fromEmail, ccEmail.split(","));

            }catch (Exception e){
                //發送失敗不能影響到任務運行
                System.out.println("Send email failed, " + e.getMessage());

            }

    }

    @Test
    @Rollback(false)
    public void testSaveApiHistory() {
        CLPApiHistoryDTO clpApiHistoryDTO = new CLPApiHistoryDTO();
        clpApiHistoryDTO.setApiName("securityEventAPIRequest");
        clpApiHistoryDTO.setApiRequestParams("{\"dataCentreId\": \"111111111122224\"\n" +
                "\"blackoutWindowBegin\": \"2022-02-13T19:45:00+08:00\"\n" +
                "\"blackoutWindowEnd\": \"2022-02-13T22:45:00+08:00\"\n" +
                "\"timeStampSent\": \"2022-02-13T09:46:28.061+08:00\"\n" +
                "\"cancleReason\": \"Reason of cancelling this alert blackout request\"\n" +
                "\"eventUid\": \"016f4683-3687-473d-93ef-f98406cec54e\"}");
        clpApiHistoryDTO.setApiResponseValues("{\"eventUid\" : \"System generated unique identifier of this event 016f4683-3687-473d-93ef-f98406cec54e\"\n" +
                "\"message\" : \"Message of processing this request\"\n" +
                "\"code\" : \"200\"\n" +
                "\"eventReference\" : \"Subject of the certificate 94db6410409ed94c3ab95078f5f25c355460c8b2\"\n" +
                "\"thumbprint\" : \"Subject of the certificate\"\n" +
                "\"validFrom\" : \"Validity period of the certificate 2024-02-13T19:45:00+08:00\"\n" +
                "\"validTo\" : \"Validity period to of the certificate 2024-02-13T19:45:00+08:00\"\n" +
                "\"subject\" : \"Subject of the certificate *.testing.gov.hksarg\"}");
        clpApiHistoryDTO.setApiResponseStatus("200");
        clpApiHistoryDTO.setApiMediaType("application/json");

        CLPApiHistoryDTO clpApiHistoryDTO1 = clpApiHistoryService.doSave(clpApiHistoryDTO);
        System.out.println(clpApiHistoryDTO1.toString());
        org.junit.Assert.assertNotNull(clpApiHistoryDTO1);
    }

    public static void main(String[] args) {
        // 2023-01-28 17:58:41
        // Date testDate = DateUtil.parse("2023-01-28 17:58:41", DateUtil.DATE_FORMAT);
        // String dateText = DateUtil.format(testDate, DateUtil.DATE_FORMAT_2);
        // 2023-01-28T17:58:41.807+08:00
        // System.out.println(dateText);


         //Date testDate = DateUtil.parse("2023-01-28T17:58:41.807+08:00", DateUtil.DATE_FORMAT_2);
         //String dateText = DateUtil.format(testDate, DateUtil.DATE_FORMAT);
         // 2023-01-28 17:58:41
         //System.out.println(dateText);
    }

}