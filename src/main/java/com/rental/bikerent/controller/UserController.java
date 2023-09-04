package com.rental.bikerent.controller;

import com.rental.bikerent.model.Book;
import com.rental.bikerent.model.Product;
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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

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
        List<Product> products = arproductRepository.findAll();
        for(Product product : products){
            int booked = 0;
            for(Book book: product.getBooks()){
                booked+= book.getBquantity();
            }
            product.setPbooked(booked);
        }
        model.addAttribute("products",products);

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
    @PostMapping("/book")
    public String book(Model model,@RequestParam("id") Integer id){
        model.addAttribute("id", id);

        return "/Normal/book";
    }

//    @RequestMapping("/do_Verification")
//    public String OTP(){return "Normal/OTPVerification";}


}

