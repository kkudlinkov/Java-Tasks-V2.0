package com.example.task14.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender sender;

    @Value("${spring.mail.username}")
    private String username;

    @Value("${mail.to}")
    private String emailTo;

    @Async
    public void sendEmail(String subject, String message) {
//        SimpleMailMessage mailMessage = new SimpleMailMessage();
//        mailMessage.setFrom(username);
//        mailMessage.setTo(emailTo);
//        mailMessage.setSubject(subject);
//        mailMessage.setText(message);
//        sender.send(mailMessage);
        log.info("Email send to {}, with subject {}, and text {}, from {}", emailTo, subject, message, username);
    }

}