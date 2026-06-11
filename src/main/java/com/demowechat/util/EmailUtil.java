package com.demowechat.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtil {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private SpringContextUtil springContextUtil;

    /**
     * 发送纯文本邮件
     */
    public void sendTextEmail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(springContextUtil.getProperty("spring.mail.username"));
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);

        mailSender.send(message);
    }

    /**
     * 发送HTML邮件
     */
    public void sendHtmlEmail(String to, String subject, String htmlContent) {
        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(springContextUtil.getProperty("spring.mail.username"));
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(htmlContent, true); // true = HTML

            mailSender.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException("邮件发送失败", e);
        }
    }
}
