package com.rental.bikerent.controller;

import com.rental.bikerent.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {


//sineup handler
@RequestMapping("/register")
public String register(Model model){
    model.addAttribute("title","register-Bike Rental");
    model.addAttribute("user",new User());
    return "registration";
    }


}
