package com.rental.bikerent.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
    private static JavaMailSender mailSender = null;

    @Autowired
    public EmailSenderService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public static void sendSimpleEmail(String toEmail,
                                       String subject,
                                       String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("rentalbike90@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);
        mailSender.send(message);
        System.out.println("Email sent successfully!");
    }
}

