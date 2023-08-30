//package com.rental.bikerent.Email;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.context.event.EventListener;
//
//import javax.mail.MessagingException;
//
//@SpringBootApplication
//
//public class Emailinfo {
//    @Autowired
//    private EmailSenderService senderService;
//    public static void main(String[] args) {
//        SpringApplication.run(Emailinfo.class, args);
//    }
//    @EventListener(ApplicationReadyEvent.class)
//    public void triggerMail() throws MessagingException {
//        String to="shresthasajak123@gmail.com";
//        String subject="Try";
//        String body="Successfull";
//        senderService.sendSimpleEmail(to, subject, body);
//    }
//}
