package com.ird.portal.sms;

import javax.mail.MessagingException;

import java.util.Map;

/**
 * @author Fred Lai
 * @since 2022-11-02
 */
public interface IEmailService {

    /**
     * 发送文本邮件
     * @param to
     * @param subject
     * @param content
     */
    public void sendSimpleMail(String to, String subject, String content, String from);

    public void sendSimpleMail(String to, String subject, String content, String from, String... cc);

    public void sendSimpleMail(String[] to, String subject, String content, String from, String... cc);

    /**
     * 发送HTML邮件
     * @param to
     * @param subject
     * @param content
     * @throws MessagingException
     */
    public void sendHtmlMail(String to, String subject, String content, String from) throws MessagingException;

    public void sendHtmlMail(String to, String subject, String content, String from, String... cc) throws MessagingException;

    public void sendThymeleafHtmlMail(String to, String subject, Map<String, Object> map, String htmlPath,
                                      String from, String... cc) throws MessagingException;

    /**
     * 发送带附件的邮件
     * @param to
     * @param subject
     * @param content
     * @param filePath
     * @throws MessagingException
     */
    public void sendAttachmentsMail(String to, String subject, String content, String from, String filePath) throws MessagingException;

    public void sendAttachmentsMail(String to, String subject, String content, String from, String filePath, String... cc) throws MessagingException;
}
