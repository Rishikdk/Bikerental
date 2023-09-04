package com.rental.bikerent.controller;

import com.rental.bikerent.model.User;
import com.rental.bikerent.repository.AcategoryRepository;
import com.rental.bikerent.repository.ASellingProductRepository;
import com.rental.bikerent.repository.ArproductRepository;
import com.rental.bikerent.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
private ArproductRepository arproductRepository;

@Autowired
private ASellingProductRepository aSellingProductRepository;
    @RequestMapping("/home")
    public String home(Model model){
        model.addAttribute("title","Home-Bike Rental");
        model.addAttribute("sellings",aSellingProductRepository.findAll());
        model.addAttribute("products",arproductRepository.findAll());

        return "Normal/userhome";
    }
    @RequestMapping("/contact")
    public String about() {
        return "Normal/contact";
    }

    @RequestMapping("/service")
    public String service() {
            return "Normal/service";
        }
        @RequestMapping("/about")
        public String product(){
        return "Normal/about";
    }
@Autowired
private AcategoryRepository acategoryRepository;
    @RequestMapping("/book")
    public String book(Model model){
        model.addAttribute("categories", acategoryRepository.findAll());
        return "/Normal/book";
    }

//    @RequestMapping("/do_Verification")
//    public String OTP(){return "Normal/OTPVerification";}


}

