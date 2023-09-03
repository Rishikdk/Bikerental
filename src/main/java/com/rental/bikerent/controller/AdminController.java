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



    @GetMapping("/category")
    public String category(Model model){
        model.addAttribute("title","Category-Bike Rental");
        model.addAttribute("category",acategoryRepository.findAll());
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
        model.addAttribute("categorys",acategoryRepository.findAll());

        return "/Admin/product";
    }
    //handler for update Renting product
    @RequestMapping(value="/updateRproduct/{pId}", method= RequestMethod.POST)
    public String updateproduct(@PathVariable("pId") Integer pId,Model model){
        model.addAttribute("title","Rental-Update");
        Product product =this.arproductRepository.findById(Long.valueOf(pId)).get();
        model.addAttribute("categories", acategoryRepository.findAll());
        model.addAttribute("product",product);
        return "/Admin/updateproduct";
    }


//handler for updating Selling product
@RequestMapping(value="/updateSproduct/{id}", method= RequestMethod.POST)
public String updateSproduct(@PathVariable("id") Integer id,Model model){
    model.addAttribute("title","Rental-Update");
    Sellingp sellingp =this.aSellingProductRepository.findById(Long.valueOf(id)).get();
    model.addAttribute("categories", acategoryRepository.findAll());
    model.addAttribute("selling",sellingp);
    return "/Admin/updateSproduct";
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
