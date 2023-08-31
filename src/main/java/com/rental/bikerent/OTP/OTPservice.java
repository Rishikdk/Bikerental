package com.rental.bikerent.OTP;

import com.rental.bikerent.model.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Service

public class OTPservice {
    @Autowired
    private JavaMailSender mailSender;

    @RequestMapping(value="/do_Verification", method= RequestMethod.POST)
//    String otp = RandomStringUtils.randomNumeric(6);
//    public ResponseEntity<String> verifyOtp(@RequestParam String enteredOtp) {
//        // Verify the entered OTP against the stored OTP
//        String storedOtp = "123456";
//    if (enteredOtp.equals(storedOtp)) {
//        return ResponseEntity.ok("OTP verified successfully!");
//    } else {
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid OTP");
//    }

    public void sendOtpByEmail(User user, String otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject("Your OTP for Registration");
        message.setText("Your OTP is: " + otp);
        mailSender.send(message);
    }

    String otp = RandomStringUtils.randomNumeric(6);

    public ResponseEntity<String> verifyOtp(@RequestParam String enteredOtp) {
        // Verify the entered OTP against the stored OTP
        String storedOtp = "Your OTP is: " + otp;
        if (enteredOtp.equals(storedOtp)) {
            return ResponseEntity.ok("OTP verified successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid OTP");
        }
    }
}
