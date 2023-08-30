package com.rental.bikerent.controller;

import com.rental.bikerent.Email.EmailSenderService;
import com.rental.bikerent.model.User;
import com.rental.bikerent.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UserRegister {
    @Autowired
    private BCryptPasswordEncoder PasswordEncoder;
    @Autowired
    private UserRepository userRepository;
    @RequestMapping(value="/do_register", method= RequestMethod.POST)
    public String registerUser( @ModelAttribute("user") User user, Model model, HttpSession session) {
      /*   try {
           if (result.hasErrors()) {
                System.out.println("ERROR" + result.toString());
                model.addAttribute("user", user);
                return "registration";
            }*/
            user.setRole("ROLE_USER");

            user.setPassword(PasswordEncoder.encode(user.getPassword()));

            System.out.println("USER" + user);
            User result = this.userRepository.save(user);
            String to = user.getEmail();
            String subject = "Rental Bikes Welcomes!";
            String body = "Sucessfully Resgistered";
            System.out.printf(to);
            EmailSenderService.sendSimpleEmail(to,subject,body);
//            model.addAttribute("user", new User());
            /*session.setAttribute("message", new Message("Successfully Register!!",
                    "alert-error"));*/
            return "login";
        /*}
        catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("user", user);

            session.setAttribute("message", new Message("Something went wrong!!" + e.getMessage(), "alert-error"));
            return "registration";
        }*/
    }
}
