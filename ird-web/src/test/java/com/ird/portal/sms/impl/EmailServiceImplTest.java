package com.ird.portal.sms.impl;

import com.ird.portal.IRDWebApplication;
import com.ird.portal.sms.IEmailService;
import com.ird.portal.util.SysParamsConstant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = IRDWebApplication.class)
@Transactional
public class EmailServiceImplTest {

    @Autowired
    private IEmailService emailService;



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

}