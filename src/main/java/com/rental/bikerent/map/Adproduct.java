package com.rental.bikerent.map;

import com.rental.bikerent.model.Category;
import com.rental.bikerent.model.Product;
import com.rental.bikerent.repository.AcategoryRepository;
import com.rental.bikerent.repository.ArproductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@Controller
public class Adproduct {
    @Autowired
    private ArproductRepository arproductRepository;

    @Autowired
    private  AcategoryRepository acategoryRepository;

//    @RequestMapping(value="/add_Rentingp", method= RequestMethod.POST)
//
//    public String arproduct(@RequestBody AdRproductDto adRproductDto) throws Exception {
//        Product product= new Product();
//        Category category = acategoryRepository.findById(1)
//                .orElseThrow(() -> new Exception("Category not found"));
//        product.setCategory(category);
//        product.setpName(adRproductDto.getpName());
//        product.setpPic(adRproductDto.getpPic());
//        product.setPbooked(adRproductDto.getPbooked());
//        product.setpDiscount(adRproductDto.getpDiscount());
//        product.setpQuantity(adRproductDto.getpQuantity());
//        product.setpPrice(adRproductDto.getpPrice());
//        product.setpRepair(adRproductDto.getpRepair());
//
//
////        arproductRepository.save((Product)product);
//        Product product1= arproductRepository.save((Product)product);
//System.out.println(product1.getpName());
////        System.out.println(product.getpName());
//        return "Admin/home";
//    }


    @RequestMapping(value="/add_Renting", method= RequestMethod.POST)
//    @PostMapping("/add_Renting")
    public String processRenting(@ModelAttribute Product product, Principal principal){


     String name= principal.getName();
     //Category category= this.acategoryRepository.getCategoryByCategoryName(name);
   //  product.setCategory(category);

   //  this.acategoryRepository.save(category);
        System.out.println("Data" + product);
        product.setPbooked(0);
        Product product1 =this.arproductRepository.save(product);

        product1.getCategory().getCategoryTitle();

        return "Admin/addRproduct";
    }
}
