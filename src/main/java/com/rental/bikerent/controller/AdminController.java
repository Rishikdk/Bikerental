package com.rental.bikerent.controller;

import com.rental.bikerent.model.Category;
import com.rental.bikerent.model.Product;
import com.rental.bikerent.model.Sellingp;
import com.rental.bikerent.model.User;
import com.rental.bikerent.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("/")
    public String admin(){

        return"Admin/home";
    }

    @RequestMapping("/add_category")
    public String acategory(Model model){
        model.addAttribute("title","Category-Bike Rental");
        model.addAttribute("category",new Category());
        return "/Admin/addcategory";
    }
@Autowired
private AcategoryRepository acategoryRepository;
    @RequestMapping("/add_Rproduct")
    public String aRproduct(Model model){
        model.addAttribute("title","Product-Bike Rental");
      model.addAttribute("product",new Product());
      model.addAttribute("categories", acategoryRepository.findAll());
        return "/Admin/addRproduct";
    }
    @RequestMapping("/add_Sproduct")
    public String aSproduct(Model model){
        model.addAttribute("title","Product-Bike Rental");
        model.addAttribute("sellingp",new Sellingp());
        model.addAttribute("categories", acategoryRepository.findAll());

        return "/Admin/addSproduct";
    }

    @RequestMapping("/category")
    public String category(Model model){
        model.addAttribute("title","Category-Bike Rental");
//        model.addAttribute("category",new ());
        return "/Admin/category";
    }
@Autowired
private UserRepository userRepository;
    @GetMapping("/user")
    public String user(Model model){
        model.addAttribute("title","User-Bike Rental");
       model.addAttribute("user",userRepository.findAll());
        return "/Admin/user";
    }
    @Autowired
    private ArproductRepository arproductRepository;

    @Autowired
    private ASellingProductRepository aSellingProductRepository;
    @GetMapping("/product")
    public String product(Model model){
        model.addAttribute("title","Product-Bike Rental");
        model.addAttribute("products",arproductRepository.findAll());
        model.addAttribute("sellings",aSellingProductRepository.findAll());

        return "/Admin/product";
    }







//@Autowired
//private RentalRepository rentalRepository;
//  @PostMapping("/add_rentingp")
//    public String product(Product product){
//       Product to = rentalRepository.save(product);
//       System.out.println(to.getpName());
//        System.out.println(product.getpName());
//        return "redirect:/admin";
//    }



}
