package com.rental.bikerent.controller;

import com.rental.bikerent.model.User;
import com.rental.bikerent.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @RequestMapping(value="/registration", method= RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, Model model,BindingResult result,HttpSession session) {
        try {
            if (result.hasErrors()) {
                System.out.println("ERROR" + result.toString());
                model.addAttribute("user", user);
                return "registration";
            }
            user.setRole("ROLE_USER");
            System.out.println("USER" + user);
            User user1 = this.userRepository.save(user);
            model.addAttribute("user", new User());
            session.setAttribute("message", new Message("Successfully Register!!", "alert-error"));
            return "registration";


        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("user", user);

            session.setAttribute("message", new Message("Something went wrong!!" + e.getMessage(), "alert-error"));
            return "registration";


        }
    }
}

