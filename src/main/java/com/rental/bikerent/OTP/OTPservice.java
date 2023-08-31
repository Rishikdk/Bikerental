//package com.rental.bikerent.OTP;
//
//import com.rental.bikerent.model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
//import org.apache.commons.lang3.RandomStringUtils;
//
//@Service
//
//public class OTPservice {
//    @Autowired
//    private JavaMailSender mailSender;
//    String otp = RandomStringUtils.randomNumeric(6);
//
//    public void sendOtpByEmail(User user, String otp) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(user.getEmail());
//        message.setSubject("Your OTP for Registration");
//        message.setText("Your OTP is: " + otp);
//        mailSender.send(message);
//    }
//}
