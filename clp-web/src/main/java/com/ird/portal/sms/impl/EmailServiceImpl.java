package com.ird.portal.sms.impl;

import com.ird.portal.sms.IEmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import java.io.File;
import java.util.Map;

/**
 * @author Benny
 * @since 2023-01-09
 */
@Service
public class EmailServiceImpl implements IEmailService {

    private static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine templateEngine;


    @Override
    public void sendSimpleMail(String to, String subject, String content, String from) {
        sendSimpleMail(to, subject, content, from, new String[] {});
    }

    @Override
    public void sendSimpleMail(String to, String subject, String content, String from, String... cc) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setCc(cc);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);

        logger.info("sendSimpleMail=> from: {}, to: {}, subject: {}, content: {}, cc: {}", from, to, subject, content, cc);
    }

    @Override
    public void sendSimpleMail(String[] to, String subject, String content,
                               String from, String... cc) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setCc(cc);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);

        logger.info("sendSimpleMail=> from: {}, to: {}, subject: {}, content: {}, cc: {}", from, to, subject, content, cc);
    }

    @Override
    public void sendHtmlMail(String to, String subject, String content, String from)
            throws MessagingException {
        sendHtmlMail(to, subject, content, from, new String[] {});
    }

    @Override
    public void sendHtmlMail(String to, String subject, String content, String from,  String... cc) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);
        helper.setCc(cc);

        mailSender.send(message);
        logger.info("sendHtmlMail=> from: {}, to: {}, subject: {}, content: {}, cc: {}", from, to, subject, content, cc);
    }

    @Override
    public void sendAttachmentsMail(String to, String subject, String content, String from, String filePath)
            throws MessagingException {
        sendAttachmentsMail(to, subject, content, from, filePath, new String[] {});
    }

    @Override
    public void sendAttachmentsMail(String to, String subject, String content, String from, String filePath, String... cc) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);
        helper.setCc(cc);

        FileSystemResource file = new FileSystemResource(new File(filePath));
        String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
        helper.addAttachment(fileName, file);

        mailSender.send(message);

        logger.info("sendAttachmentsMail=> from: {}, to: {}, subject: {}, filePath: {} content: {}, cc: {}", from, to, subject, filePath, content, cc);
    }

    @Override
    public void sendThymeleafHtmlMail(String to, String subject, Map<String, Object> params, String htmlPath,
                                      String from, String... cc) throws MessagingException {

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setCc(cc);
        Context context = new Context();
        context.setVariables(params);
        String process = templateEngine.process(htmlPath, context);
        helper.setText(process, true);
        mailSender.send(message);
        logger.info("sendThymeleafHtmlMail=> from: {}, to: {}, subject: {}, content: {}, cc: {}", from, to, subject, process, cc);
    }
}
