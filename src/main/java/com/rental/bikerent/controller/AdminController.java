package com.rental.bikerent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("/")
    public String admin(){

        return "Admin/home";
    }

    @GetMapping("/product")
    public String product(){

        return "Admin/home";
    }



}
