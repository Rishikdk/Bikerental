package com.rental.bikerent;

import com.rental.bikerent.Email.EmailSenderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class bikerent {

	public static void main(String[] args) {
		SpringApplication.run(bikerent.class, args);
//		String to = "shresthasajak123@gmail.com";
//		String subject = "Try";
//		String body = "Successfull";
//		EmailSenderService.sendSimpleEmail(to, subject, body);

	}
}
